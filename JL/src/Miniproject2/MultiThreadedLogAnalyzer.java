package Miniproject2;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class MultiThreadedLogAnalyzer {

    // Concurrent global keyword counter
    private static ConcurrentHashMap<String, AtomicInteger> globalCounts = new ConcurrentHashMap<>();

    // ------------------- Worker (Callable) -------------------
    static class FileWorker implements Callable<Map<String, Integer>> {

        private final File file;
        private final List<String> keywords;

        FileWorker(File file, List<String> keywords) {
            this.file = file;
            this.keywords = keywords;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> localMap = new HashMap<>();

            // Initialize local map
            for (String k : keywords) {
                localMap.put(k, 0);
            }

            try (Stream<String> lines = Files.lines(file.toPath())) {
                lines.forEach(line -> {
                    String lower = line.toLowerCase();
                    for (String k : keywords) {
                        if (lower.contains(k.toLowerCase())) {
                            localMap.put(k, localMap.get(k) + 1);
                        }
                    }
                });
            }
            return localMap;
        }
    }

    // ------------------- Sequential Version -------------------
    public static Map<String, Integer> analyzeSequential(File folder, List<String> keywords) throws Exception {

        Map<String, Integer> result = new HashMap<>();
        for (String k : keywords) result.put(k, 0);

        File[] files = folder.listFiles((d, n) -> n.endsWith(".txt"));
        if (files == null) return result;

        for (File file : files) {
            try (Stream<String> lines = Files.lines(file.toPath())) {

                lines.forEach(line -> {
                    String lower = line.toLowerCase();
                    for (String k : keywords) {
                        if (lower.contains(k.toLowerCase())) {
                            result.put(k, result.get(k) + 1);
                        }
                    }
                });

            }
        }
        return result;
    }

    // ------------------- Concurrent Version -------------------
    public static Map<String, Integer> analyzeConcurrent(File folder, int numThreads, List<String> keywords)
            throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        File[] files = folder.listFiles((d, n) -> n.endsWith(".txt"));
        if (files == null) return new HashMap<>();

        List<Future<Map<String, Integer>>> list = new ArrayList<>();

        for (File file : files) {
            list.add(executor.submit(new FileWorker(file, keywords)));
        }

        // Aggregate results into globalCounts
        for (Future<Map<String, Integer>> future : list) {
            Map<String, Integer> local = future.get();

            local.forEach((k, v) -> {
                globalCounts.putIfAbsent(k, new AtomicInteger(0));
                globalCounts.get(k).addAndGet(v);
            });
        }

        executor.shutdown();

        // Convert AtomicInteger → Integer
        Map<String, Integer> normalMap = new HashMap<>();
        globalCounts.forEach((k, v) -> normalMap.put(k, v.get()));

        return normalMap;
    }

    // ------------------- Write results to file -------------------
    public static void writeResultToFile(Map<String, Integer> seq, Map<String, Integer> con,
                                         long seqTime, long conTime) throws Exception {

        try (PrintWriter pw = new PrintWriter(new FileWriter("results.txt"))) {

            pw.println("===== LOG ANALYZER SUMMARY =====\n");

            pw.println("Sequential Time  : " + seqTime + " ms");
            pw.println("Concurrent Time  : " + conTime + " ms");
            pw.println("Speedup          : " + ((double) seqTime / conTime) + "\n");

            pw.println("---- Sequential Count ----");
            seq.forEach((k, v) -> pw.println(k + " : " + v));

            pw.println("\n---- Concurrent Count ----");
            con.forEach((k, v) -> pw.println(k + " : " + v));
        }
    }

    // ------------------- MAIN METHOD -------------------
    public static void main(String[] args) throws Exception {

        if (args.length < 3) {
            System.out.println("Usage: java MultiThreadedLogAnalyzer <folderPath> <numThreads> <keyword1,keyword2,...>");
            return;
        }

        File folder = new File(args[0]);
        int numThreads = Integer.parseInt(args[1]);
        List<String> keywords = Arrays.asList(args[2].split(","));

        // SEQUENTIAL EXECUTION
        long start1 = System.currentTimeMillis();
        Map<String, Integer> seqResult = analyzeSequential(folder, keywords);
        long end1 = System.currentTimeMillis();
        long seqTime = end1 - start1;

        // CONCURRENT EXECUTION
        long start2 = System.currentTimeMillis();
        Map<String, Integer> conResult = analyzeConcurrent(folder, numThreads, keywords);
        long end2 = System.currentTimeMillis();
        long conTime = end2 - start2;

        // OUTPUT
        System.out.println("\n===== FINAL OUTPUT =====");
        System.out.println("Sequential Time : " + seqTime + " ms");
        System.out.println("Concurrent Time : " + conTime + " ms");

        System.out.println("\n--- Sequential Result ---");
        seqResult.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("\n--- Concurrent Result ---");
        conResult.forEach((k, v) -> System.out.println(k + " : " + v));

        // Write to file
        writeResultToFile(seqResult, conResult, seqTime, conTime);

        System.out.println("\nSummary written to results.txt");
    }
}