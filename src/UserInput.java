import java.util.Scanner;

class UserInput {

    Scanner scanner = new Scanner(System.in);
    public Questions question = new Questions();

    int response;

    public int getUserResponse(int i) {
        while (true) {

            prompt();

            response = scanner.nextInt();
            scanner.nextLine();

            if (checkAnswer()) {
                break;
            } else {
                System.out.println("\nThis is wrong input (out of range), try again:\n");
                System.out.println(question.questionTexts[i]);
            }
        }
        return response;
    }

    public void prompt(){
        System.out.println("1. Eens");
        System.out.println("2. Oneens\n");
    }

    public boolean checkAnswer() {
        return response == 1 || response == 2;
    }
}