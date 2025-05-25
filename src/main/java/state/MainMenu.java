package state;

import utils.IOAdapter;
import utils.Menu;

public class MainMenu extends AbstractState {

    @Override
    public void run() {
        render();
        handleMenuInput();
    }

    @Override
    public void render() {
        adapter.clearConsole();
        Menu.renderTitleBanner();
        Menu.renderMenu();
    }

    @Override
    protected void goToNextState() {
        getContext().goToState(new state.Game());
    }

    @Override
    protected void goToAlternativeState() {
        getContext().goToState(new state.Exit());
    }


}
