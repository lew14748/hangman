package state;

import utils.Menu;

public class Game extends AbstractState {

    public void run() {
        render();
        if(!getContext().getGame().getHiddenWord().guessLetter(String.valueOf(Menu.validateGameInput()))) {
            getContext().getGame().decreaseLifeCount();
        }
        //System.exit(0);
    }

    public void render() {
        adapter.clearConsole();
        getContext().getGame().getHiddenWord().printMaskedWord();
        adapter.write("Осталось жизней - " + getContext().getGame().getLifeCounter());
        //adapter.write("Game should be here");
    }

    @Override
    protected void goToNextState() {
        getContext().goToState(new state.GameOver());
    }

    @Override
    protected void goToAlternativeState() {
    }
}
