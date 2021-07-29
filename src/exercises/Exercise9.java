package exercises;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Exercise9 extends Exercise {

    private final Queue<String> rows;
    private final Map<String, List<String>> resultMap;

    public Exercise9() {
        rows = new LinkedList<>();
        resultMap = new HashMap<>();
    }

    @Override
    public void run() {
        readFile("ex9.txt");
        parseRowsToMap();
        printMap();
    }

    private void readFile(String directory) {
        try {
            Path path = Paths.get(directory);
            scanner = new Scanner(path);

            scanner.useDelimiter(System.getProperty("line.separator"));

            while(scanner.hasNext()){
                rows.add(scanner.next());
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseRowsToMap() {
        String row = "init";
        if ("roles:".equals(rows.peek())) {
            rows.poll();

            while (!Objects.equals(row, "")) {
                row = rows.poll();
                if (!Objects.equals(row, "")) {
                    resultMap.put(row, new ArrayList<>());
                }
            }
        }

        if ("textLines:".equals(rows.peek())) {
            rows.poll();

            while (!rows.isEmpty()) {
                row = rows.poll();
                String role = checkRow(row, resultMap.keySet().toArray(String[]::new));
                if (role != null) {
                    List<String> lines = resultMap.get(role);
                    lines.add(row.substring(role.length() + 1));
                }
            }
        }
    }

    private String checkRow(String row, String[] roles) {
        for (String role : roles) {
            if (row.startsWith(role)) {
                return role;
            }
        }

        return null;
    }

    private void printMap() {
        int lineNumber = 0;
        for (Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (String line : entry.getValue()) {
                lineNumber++;
                System.out.printf("(%d) %s%n", lineNumber, line);
            }
            System.out.println();
        }
    }
}
