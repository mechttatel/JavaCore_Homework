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
        resultMap = new LinkedHashMap<>();
    }

    @Override
    public void run() {
        System.out.println("\nДанные для этого задания находятся в файле ex9.txt в папке resources\n");
        readFile("resources/ex9.txt");
        parseRowsToMap();
        printMap();
    }

    /*
        Метод был создан для построчного чтения данных из файла по пути directory
        Прочитанные строки заносятся в очередь rows, для их последующего перевода в
        требуемый по заданию вид
    */

    private void readFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
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

    /*
        Из массива rows последовательно считываются роли и заносятся в мапу resultMap
        в качестве ключей, после чего считываются реплики, и если реплика начинается с какой - либо роли,
        она заносится в список мапы по ключу этой роли.
    */

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

            int lineNumber = 1;
            while (!rows.isEmpty()) {
                row = rows.poll();
                String role = checkRow(row, resultMap.keySet().toArray(String[]::new));
                if (role != null) {
                    List<String> lines = resultMap.get(role);
                    lines.add("(" + lineNumber + ") " + row.substring(role.length() + 1));
                    lineNumber++;
                }
            }
        }
    }

    /*
        Метод для проверки реплики

        Метод получает массив ролей (сет ключей из мапы) и в цикле проверяет строчку
        Если строчка начинается с какой - либо роли, метод возвращает эту роль
        Если же строчка не соответствует не одной роли, возвращается null
    */
    private String checkRow(String row, String[] roles) {
        for (String role : roles) {
            if (row.startsWith(role)) {
                return role;
            }
        }

        return null;
    }

    /*
        Метод для вывода в консоль согласно заданию
    */

    private void printMap() {
        System.out.println("Результат:");
        for (Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (String line : entry.getValue()) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}
