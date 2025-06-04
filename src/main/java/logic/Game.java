package logic;

public class Game {
    private final Dictionary dictionary;
    private final HiddenWord hiddenWord;
    private int lifeCounter = 7;


    public Game() {
        dictionary = new Dictionary();
        hiddenWord = new HiddenWord();
        hiddenWord.initWords(dictionary.getRandomWord());
    }

    public void remakeGame() {
        restoreLifeCounter();
        hiddenWord.clearWords();
        hiddenWord.initWords(dictionary.getRandomWord());
    }

    public boolean checkWin() {
        return (hiddenWord.getCorrectlyGuessedLettersCount() == hiddenWord.getActualWord().size());
    }

    public boolean checkLose() {
        return (lifeCounter == 0);
    }

    public void decreaseLifeCount() {
        lifeCounter--;
    }

    public void restoreLifeCounter() {
        lifeCounter = 7;
    }

    public int getLifeCounter() {
        return lifeCounter;
    }


    public HiddenWord getHiddenWord() {
        return hiddenWord;
    }


}
