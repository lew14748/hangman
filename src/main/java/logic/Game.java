package logic;

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
