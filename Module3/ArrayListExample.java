import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student names (type 'exit' to stop):");
        while (true) {
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("exit")) break;
            studentNames.add(name);
        }

        System.out.println("Student names entered:");
        for (String name : studentNames) {
            System.out.println(name);
        }
        sc.close();
    }
}
