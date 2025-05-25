package state;

import utils.Menu;

public class GameOver extends AbstractState {
    public void run() {
        render();
        handleMenuInput();
    }

    public void render() {
        adapter.clearConsole();
        Menu.renderTitleBanner();
        if (getContext().getGame().checkWin()) {
            adapter.write("Вы победили, желаете сыграть еще?");
        } else {
            adapter.write("Вы проиграли, желаете сыграть еще?");
        }
        Menu.renderMenu();
    }

    protected void goToNextState() {
        getContext().getGame().remakeGame();
        getContext().goToState(new state.Game());
    }

    protected void goToAlternativeState() {
        getContext().goToState(new state.Exit());
    }
}
