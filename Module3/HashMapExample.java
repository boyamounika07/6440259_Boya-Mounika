import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Add student ID and name (type 'exit' to stop):");
        while (true) {
            System.out.print("Enter ID: ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            int id = Integer.parseInt(input);

            System.out.print("Enter name: ");
            String name = sc.nextLine();
            studentMap.put(id, name);
        }

        System.out.print("Enter ID to retrieve name: ");
        int queryId = sc.nextInt();
        String studentName = studentMap.get(queryId);
        if (studentName != null) {
            System.out.println("Name for ID " + queryId + ": " + studentName);
        } else {
            System.out.println("No student found with ID " + queryId);
        }
        sc.close();
    }
}
