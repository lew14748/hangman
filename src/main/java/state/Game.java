package state;

import utils.Menu;
import utils.HangedManDrawer;

public class Game extends AbstractState {
    @Override
    public void run() {
        render();
        guessLetter();
        if (getContext().getGame().checkLose() || getContext().getGame().checkWin()) {
            goToNextState();
        }
    }

    @Override
    public void render() {
        adapter.clearConsole();
        getContext().getGame().getHiddenWord().printMaskedWord();
        getContext().getGame().getHiddenWord().printWronglyGuessedLetters();
        HangedManDrawer.printHangedMan(getContext().getGame().getLifeCounter());
        adapter.write("Осталось жизней - " + getContext().getGame().getLifeCounter());
    }

    private void guessLetter() {
        String validatedGuessedLetter = Menu.validateGameInput();
        if (!validatedGuessedLetter.equals("WRONG INPUT")) {
            if (!getContext().getGame().getHiddenWord().guessLetter(validatedGuessedLetter))
                getContext().getGame().decreaseLifeCount();
        }
    }

    @Override
    protected void goToNextState() {
        getContext().goToState(new state.GameOver());
    }

    @Override
    protected void goToAlternativeState() {
    }
}
