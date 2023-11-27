import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadData {

    private final String COMMA_DELIMITER = ",";
    private boolean firstLine = true;
    private String line;

    public  ArrayList<String> questionTexts = new ArrayList<>();
    public ArrayList<String> parties = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> questionCalculations = new ArrayList<>();
    private BufferedReader reader;

    private final String filePath = "C:\\Users\\runeh\\Documents\\StemWijzer Sheet.csv";
    private final String filePath2 = "C:\\Users\\runeh\\Documents\\README.TXT";

    public void readDataFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            this.reader = reader;
            readParties(reader);
            readQuestions();
            readCalculations();
        }
    }

    private void readParties(BufferedReader reader) throws IOException {
        if (firstLine) {
            line = this.reader.readLine();
            String[] values = line.split(COMMA_DELIMITER);
            Collections.addAll(parties, values);
            parties.remove(0);
            firstLine = false;
        }
    }

    public void refillParties() throws IOException {
        parties.clear();
        Party.createPartyObjects(parties);
    }

    private void readQuestions() throws IOException {
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(COMMA_DELIMITER);
            questionTexts.add(values[0]);
        }
    }

    public void readREADME() throws IOException {
        try (BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {
            String line;
            System.out.println();
            while ((line = reader2.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private void readCalculations() throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(COMMA_DELIMITER);
            ArrayList<Integer> intValues = new ArrayList<>();


            for (int i = 1; i < values.length; i++) {
                intValues.add(Integer.parseInt(values[i]));
            }
            questionCalculations.add(intValues);
        }

        if (reader != null) {
            reader.close();
        }
    }

    public List<String> getQuestionTexts() {
        return new ArrayList<>(questionTexts);
    }

    public List<String> getParties() {
        return new ArrayList<>(parties);
    }

    public List<List<Integer>> getQuestionCalculations() {
        return new ArrayList<>(questionCalculations);
    }
}

