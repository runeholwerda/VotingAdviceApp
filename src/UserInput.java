import java.util.List;
import java.util.Scanner;

class UserInput {

    private final Scanner scanner = new Scanner(System.in);

    public int questionResponse(int i, List<String> questionTexts) {
        while (true) {
            prompt();
            if (scanner.hasNextInt()) {
                int response = scanner.nextInt();
                scanner.nextLine();
                if (checkIfTwo(response)) {
                    return response;
                } else {
                    System.out.println("\nThis is wrong input (out of range), try again:\n");
                }
            }
            System.out.println(questionTexts.get(i)+"\n");
        }
    }

    public int interfaceResponse(){
        while (true) {
            if (scanner.hasNextInt()) {
                int response = scanner.nextInt();
                scanner.nextLine();
                if (checkIfTree(response)) {
                    return response;
                } else {
                    System.out.println("\nInvalid Input\n");
                }
            }
        }
    }
    private void prompt() {
        System.out.println("1. Eens");
        System.out.println("2. Oneens\n");
    }

    private boolean checkIfTwo(int response) {
        return response == 1 || response == 2;
    }

    private boolean checkIfTree(int response) {
        return response == 1 || response == 2 || response == 3;
    }
}

