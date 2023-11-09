import java.util.List;
public class Calculations {
    private final List<Party> parties;

    public Calculations(List<Party> parties) {
        this.parties = parties;
    }

    public void updateValues(int questionIndex, int response, List<Integer> questionCalculations) {
        for (int i = 0; i < parties.size(); i++) {
            if (response == 1) {
                parties.get(i).updateScore(questionCalculations.get(i));
            } else if (response == 2) {
                parties.get(i).updateScore(-questionCalculations.get(i));
            }
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
