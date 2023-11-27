import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class Status {

    private final ReadData readData = new ReadData();
    Scanner scanner = new Scanner(System.in);
    private final UserInput userInput = new UserInput();
    private Calculations calculations;
    private List<Party> parties;
    private final Menus menu;
    int number = 1;

    public Status(Menus menu) throws IOException {
        this.menu = menu;
        readData.readDataFromFile();
        List<String> partyNames = readData.getParties();
        parties = Party.createPartyObjects(partyNames);
        calculations = new Calculations(parties);
    }

    public void questionLoop() throws IOException {
        List<String> questionTexts = readData.getQuestionTexts();
        List<List<Integer>> questionCalculations = readData.getQuestionCalculations();

        parties = Party.createPartyObjects(readData.getParties());
        calculations = new Calculations(parties); // Move this line outside the loop

        for (int i = 0; i < questionTexts.size(); i++) {
            System.out.println("\n" + number + ". " + questionTexts.get(i) + "\n");
            number++;
            int response = userInput.questionResponse(i, questionTexts);
            List<Integer> questionCalculationsList = questionCalculations.get(i);

            calculations.updateValues(response, questionCalculationsList); // Remove the 'i' argument
        }


        if (menu.excludePartyEnabled) {
            System.out.println("\nThis is the end of the quiz!");
            number = 1;
            while (true) {
                System.out.println("Would you like to exclude a party ?\n");
                System.out.println("1. Yes");
                System.out.println("2. No\n");
                int response = scanner.nextInt();
                System.out.println();
                if (response == 1) {
                    calculations.excludeParty();
                    break;
                } else if (response == 2) {
                    break;
                } else {
                    System.out.println("Wrong Input");
                    continue;
                }
            }
        }

        printPartyScores();
        findPartyWithHighestScore();
    }

    public void printPartyScores() {
        calculations.printPartyScores();
    }

    public void findPartyWithHighestScore() {
        calculations.findPartyWithHighestScore();
    }
}

