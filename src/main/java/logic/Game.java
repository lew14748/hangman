package logic;

import java.util.Set;

public class Game {
    private Dictionary dictionary;
    private HiddenWord hiddenWord;
    private int lifeCounter = 7;
    public Game() {
    }

    public Game(String filename) {
        dictionary = new Dictionary(filename);
        hiddenWord = new HiddenWord();
        hiddenWord.initWords(dictionary.getRandomWord());
    }

    public boolean checkWin(){
        return (hiddenWord.getCorrectlyGuessedLettersCount() == hiddenWord.getActualWord().size());
    }

    public boolean checkLose(){
        return (lifeCounter == 0);
    }

    public void decreaseLifeCount() {
        lifeCounter--;
    }

    public void resetLifeCounter() {
        lifeCounter = 7;
    }

    public int getLifeCounter() {
        return lifeCounter;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public HiddenWord getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(HiddenWord hiddenWord) {
        this.hiddenWord = hiddenWord;
    }


}
