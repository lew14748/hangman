package state;

import utils.Menu;
import utils.HangedManDrawer;

public class GameOver extends AbstractState {
    public void run() {
        render();
        handleMenuInput();
    }

    public void render() {
        adapter.clearConsole();
        Menu.renderTitleBanner();
        adapter.write("Было загадано слово - " + String.join("", getContext().getGame().getHiddenWord().getActualWord()));
        if (getContext().getGame().checkWin()) {
            adapter.write("Вы победили, желаете сыграть еще?");
        } else {
            adapter.write("Вы проиграли, желаете сыграть еще?");
            HangedManDrawer.printHangedMan(getContext().getGame().getLifeCounter());
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
