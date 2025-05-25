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
        renderTitleBanner();
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

    private void renderTitleBanner() {
        String TITLE_BANNER =
                " ██╗  ██╗ █████╗ ███╗  ██╗ ██████╗ ███╗   ███╗ █████╗ ███╗  ██╗\n" +
                        " ██║  ██║██╔══██╗████╗ ██║██╔════╝ ████╗ ████║██╔══██╗████╗ ██║\n" +
                        " ███████║███████║██╔██╗██║██║  ███╗██╔████╔██║███████║██╔██╗██║\n" +
                        " ██╔══██║██╔══██║██║╚████║██║   ██║██║╚██╔╝██║██╔══██║██║╚████║\n" +
                        " ██║  ██║██║  ██║██║ ╚███║╚██████╔╝██║ ╚═╝ ██║██║  ██║██║ ╚███║\n" +
                        " ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝ ╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝";
        IOAdapter.getInstance().write(TITLE_BANNER);
    }
}
