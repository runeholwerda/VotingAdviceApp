import java.util.List;
import java.util.Scanner;

public class Calculations {

    private List<Party> parties;
    private Scanner scanner = new Scanner(System.in);

    public Calculations(List<Party> parties) {
        this.parties = parties;
    }

    public void updateValues(int response, List<Integer> questionCalculations) {
        for (int i = 0; i < parties.size(); i++) {
            if (response == 1) {
                parties.get(i).updateScore(questionCalculations.get(i));
            } else if (response == 2) {
                parties.get(i).updateScore(-questionCalculations.get(i));
            }
        }
    }

    public void accumulateScores(List<Integer> questionCalculations) {
        for (int i = 0; i < parties.size(); i++) {
            parties.get(i).updateScore(questionCalculations.get(i));
        }
    }

    public void questionLoop(List<String> questionTexts, List<List<Integer>> questionCalculations) {
        for (int i = 0; i < questionTexts.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + questionTexts.get(i) + "\n");
            int response = scanner.nextInt();
            List<Integer> questionCalculationsList = questionCalculations.get(i);

            updateValues(response, questionCalculationsList);
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

    public void excludeParty() {
        System.out.println("Choose a party to exclude \n");

        while (true) {
            if (parties.size() == 1) {
                break;
            }

            int i = 0;
            for (Party party : parties) {
                i++;
                System.out.println(i + ". " + party.getName());
            }
            System.out.println();

            while (true) {
                int response = scanner.nextInt();
                System.out.println();
                if (response > parties.size()) {
                    System.out.println("This is the wrong input\n");
                } else {
                    parties.remove(response - 1);
                    break;
                }
            }
            System.out.println("Would you like to exclude another party ?\n");
            System.out.println("1. Yes");
            System.out.println("2. No\n");
            int response = scanner.nextInt();

            if (response == 1) {
                continue;
            } else if (response == 2) {
                break;
            } else {
                System.out.println("Wrong Input");
                continue;
            }
        }
    }

    public void printPartyScores() {
        System.out.println("total score:\n");

        for (Party party : parties) {
            System.out.println(party.getName() + ": " + party.getScore());
        }
    }
}