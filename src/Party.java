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
}