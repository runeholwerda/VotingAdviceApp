import java.util.List;
import java.util.Scanner;
class UserInput {


    private final Scanner scanner = new Scanner(System.in);


    public int getUserResponse(int i, List<String> questionTexts) {
        while (true) {
            prompt();


            if (scanner.hasNextInt()) {
                int response = scanner.nextInt();
                scanner.nextLine();
                if (checkAnswer(response)) {
                    return response;
                } else {
                    System.out.println("\nThis is wrong input (out of range), try again:\n");
                }
            } else {
                scanner.nextLine();
                System.out.println("\nInvalid input, please enter a number (1 or 2):\n");
            }


            System.out.println(questionTexts.get(i)+"\n");
        }
    }


    private void prompt() {
        System.out.println("1. Eens");
        System.out.println("2. Oneens\n");
    }


    private boolean checkAnswer(int response) {
        return response == 1 || response == 2;
    }
}
