package state;

import utils.Menu;

public class Game extends AbstractState {
    @Override
    public void run() {
        render();
        guessLetter();
        if(getContext().getGame().checkLose()) {
            goToAlternativeState();
        } else {
            if (getContext().getGame().checkWin()) {
                goToNextState();
            }
        }
    }

    @Override
    public void render() {
        adapter.clearConsole();
        getContext().getGame().getHiddenWord().printMaskedWord();
        adapter.write("Осталось жизней - " + getContext().getGame().getLifeCounter());
        //adapter.write("Game should be here");
    }

    private void guessLetter(){
        String validatedGuessedLetter = String.valueOf(Menu.validateGameInput());
        if(!validatedGuessedLetter.equals("WRONG INPUT")){
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
