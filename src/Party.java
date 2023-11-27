import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Party {

    private final String name;
    private int score;

    public Party(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int value) {
        score += value;
    }

    public static List<Party> createPartyObjects(List<String> partyNames) {
        List<Party> partyList = new ArrayList<>();

        for (String partyName : partyNames) {
            Party party = new Party(partyName);
            partyList.add(party);
        }

        return partyList;
    }
}
