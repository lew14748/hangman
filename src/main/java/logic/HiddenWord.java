package logic;

import org.jetbrains.annotations.NotNull;
import utils.IOAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class HiddenWord {
    private final ArrayList<String> actualWord = new ArrayList<>();
    private final ArrayList<String> templateWord = new ArrayList<>();
    private final ArrayList<String> maskedWord = new ArrayList<>();


    public boolean guessLetter(String letter) {
        if (actualWord.contains(letter)) {
            while (templateWord.contains(letter)) {
                maskedWord.set(templateWord.indexOf(letter), letter);
                templateWord.set(templateWord.indexOf(letter), "_");
            }
            return true;
        }
        return false;
    }

    public void initWords(@NotNull String word) {
        Collections.addAll(actualWord, word.split(""));
        Collections.addAll(templateWord, word.split(""));

        for (int i = 0; i < actualWord.size(); i++) maskedWord.add("_");
    }

    public void clearWords() {
        actualWord.clear();
        maskedWord.clear();
    }

    public void printMaskedWord() {
        IOAdapter.getInstance().write(String.join(" ", maskedWord));
    }

    public ArrayList<String> getActualWord() {
        return actualWord;
    }

    public ArrayList<String> getMaskedWord() {
        return maskedWord;
    }
}
