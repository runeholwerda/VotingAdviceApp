import java.util.List;
import java.util.Scanner;

class CoreOperations {

    public Scanner scanner;
    public Questions question = new Questions();
    public UserInput UserInput = new UserInput();
    public List<Party> parties = question.parties;

    public void questionLoop() {
        for (int i = 0; i < question.questionTexts.length; i++) {

            System.out.println("\n" + question.questionTexts[i] + "\n");

            int response = UserInput.getUserResponse(i);
            question.updateValues(parties, i, response);
        }
    }

    public void findPartyWithHighestScore() {
        Party partyWithHighestScore = parties.get(0);

        for (Party party : parties) {
            if (party.getScore() > partyWithHighestScore.getScore()) {
                partyWithHighestScore = party;
            }
        }
        System.out.println("\nThe party with the highest score is: " + partyWithHighestScore.getName());
    }
    
    public void printPartyScores() {
        System.out.println("\ntotal score:\n");

        for (Party party : parties) {
            System.out.println(party.getName() + ": " + party.getScore());
        }
    }
}