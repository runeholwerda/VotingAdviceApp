import java.util.ArrayList;
import java.util.List;

class Questions {

    public List<Party> parties = new ArrayList<>();

    public Questions() {

        parties.add(new Party("VVD"));
        parties.add(new Party("PVV"));
        parties.add(new Party("D66"));
        parties.add(new Party("SP"));
        parties.add(new Party("CDA"));
    }

    public List<Party> getParties() {
        return parties;
    }

    String[] questionTexts = {
            "De regering moet ervoor zorgen dat de hoeveelheid vee minstens de helft kleiner wordt",
            "De accijns op benzine, gas en diesel moet omlaag",
            "Het eigen risico bij zorgverzekeringen moet worden afgeschaft",
            "Elke regio in Nederland moet een vast aantal mensen in de Tweede Kamer krijgen",
            "Mensen vanaf 65 jaar moeten gratis met de trein, tram en bus kunnen reizen",
            "De regering moet meer investeren in opslag van CO2 onder de grond"
    };

    public void updateValues(List<Party> parties, int questionIndex, int response) {

        // Order of array is order of parties
        int[][] questionCalculations = {
                {-1, -1, 1, -1, -1},
                {1, 1, -1, 1, 1},
                {-1, -1, -1, 1, 1},
                {-1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, -1, 1, -1, -1},
        };
        int[] currentQuestion = questionCalculations[questionIndex];

        for (int i = 0; i < parties.size(); i++) {

            if (response == 1) {
                parties.get(i).updateScore(currentQuestion[i]);
            } else if (response == 2) {
                parties.get(i).updateScore(-currentQuestion[i]);
            }
        }
    }
}