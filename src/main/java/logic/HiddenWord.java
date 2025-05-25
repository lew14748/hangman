package logic;

import org.jetbrains.annotations.NotNull;
import utils.IOAdapter;

import java.util.*;

public class HiddenWord {
    private final List<String> actualWord = new ArrayList<>();
    private final List<String> templateWord = new ArrayList<>();
    private final List<String> maskedWord = new ArrayList<>();
    private final Set<String> wronglyGuessedLetters = new HashSet<>();
    private final List<String> correctlyGuessedLetters = new ArrayList<>();

    public boolean guessLetter(String letter) {
        if (actualWord.contains(letter)) {
            while (templateWord.contains(letter)) {
                maskedWord.set(templateWord.indexOf(letter), letter);
                templateWord.set(templateWord.indexOf(letter), "_");
                correctlyGuessedLetters.add(letter);
            }
            return true;
        }
        return !wronglyGuessedLetters.add(letter);
    }

    public void initWords(@NotNull String word) {
        Collections.addAll(actualWord, word.split(""));
        Collections.addAll(templateWord, word.split(""));

        for (int i = 0; i < actualWord.size(); i++) maskedWord.add("_");
    }

    public void clearWords() {
        actualWord.clear();
        maskedWord.clear();
        templateWord.clear();
        correctlyGuessedLetters.clear();
        wronglyGuessedLetters.clear();
    }

    public void printMaskedWord() {
        IOAdapter.getInstance().write(String.join(" ", maskedWord));
    }

    public void printWronglyGuessedLetters(){
        IOAdapter.getInstance().write("Неверные догадки: " + (String.join(" ", wronglyGuessedLetters)));
    }

    public List<String> getActualWord() {
        return actualWord;
    }

    public List<String> getMaskedWord() {
        return maskedWord;
    }

    public int getCorrectlyGuessedLettersCount() {
        return correctlyGuessedLetters.size();
    }
}
