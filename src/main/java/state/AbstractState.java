package state;

import logic.Context;
import utils.IOAdapter;
import utils.Menu;

public abstract class AbstractState {
    private Context context;
    IOAdapter adapter = IOAdapter.getInstance();

    public abstract void render();

    public abstract void run();

    protected abstract void goToNextState();

    protected abstract void goToAlternativeState();

    void renderWrongInputMsg() {
        IOAdapter.getInstance().write("Неверный ввод!");
    }

    void handleMenuInput() {
        String menuInput = Menu.validateMenuInput();
        switch (menuInput) {
            case ("PLAY"):
                goToNextState();
                break;
            case ("EXIT"):
                goToAlternativeState();
                break;
            default:
                render();
                renderWrongInputMsg();
                break;
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
