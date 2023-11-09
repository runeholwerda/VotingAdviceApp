import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Status action = new Status();

        action.questionLoop();
        action.printPartyScores();
        action.findPartyWithHighestScore();
    }
}
