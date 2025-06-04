package logic;

import utils.IOAdapter;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Dictionary {
    private final ArrayList<String> words = new ArrayList<>();


    public Dictionary() {
        readWordsFromDictionaryResource();
    }



    public String getRandomWord() {
        return words.get(ThreadLocalRandom.current().nextInt(0, words.size()));
    }

    void readWordsFromDictionaryResource() {
        try (InputStream is = Dictionary.class.getClassLoader().getResourceAsStream("Dictionary.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            while (reader.ready()) {
                words.add(reader.readLine());
            }
            System.out.println(words);
        } catch (FileNotFoundException e) {
            IOAdapter.getInstance().write("FileNotFoundException: Dictionary not found");
        } catch (IOException e) {
            IOAdapter.getInstance().write("IOException: Exception during reading from dictionary");
        }
    }
}
