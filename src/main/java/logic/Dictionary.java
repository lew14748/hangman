package logic;

import utils.IOAdapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Dictionary {
    private final ArrayList<String> words = new ArrayList<>();

    public Dictionary() {
    }

    public Dictionary(String filename) {
        readWordsFromFile(filename);
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public String getRandomWord() {
        return words.get(ThreadLocalRandom.current().nextInt(0, words.size()));
    }

    boolean readWordsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            while (reader.ready()) {
                words.add(reader.readLine());
            }
            return true;
        } catch (FileNotFoundException e) {
            IOAdapter.getInstance().write("FileNotFoundException: Dictionary not found");
            return false;
        } catch (IOException e) {
            IOAdapter.getInstance().write("IOException: Exception during reading from dictionary");
            return false;
        }
    }
}
