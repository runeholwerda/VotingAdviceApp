import java.io.IOException;
import java.util.List;
class Status {

    private final ReadData readData = new ReadData();
    private final UserInput userInput = new UserInput();
    private final Calculations calculations;

    public Status() throws IOException {
        readData.readDataFromFile();
        List<String> partyNames = readData.getParties();
        List<Party> parties = Party.createPartyObjects(partyNames);
        calculations = new Calculations(parties);
    }

    public void questionLoop() {
        List<String> questionTexts = readData.getQuestionTexts();
        List<List<Integer>> questionCalculations = readData.getQuestionCalculations();

        for (int i = 0; i < questionTexts.size(); i++) {
            System.out.println("\n" + questionTexts.get(i) + "\n");

            int response = userInput.getUserResponse(i, questionTexts);
            List<Integer> questionCalculationsList = questionCalculations.get(i);

            calculations.updateValues(i, response, questionCalculationsList);
        }
    }

    public void printPartyScores() {
        calculations.printPartyScores();
    }
    public void findPartyWithHighestScore() {
        calculations.findPartyWithHighestScore();
    }
}
