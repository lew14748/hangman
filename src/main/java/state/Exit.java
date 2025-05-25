package state;

import utils.IOAdapter;

public class Exit extends AbstractState {
    public void run() {
        render();
        System.exit(0);
    }

    public void render() {
        adapter.clearConsole();
        adapter.write("Спасибо за игру!");
    }

    @Override
    protected void goToNextState() {
    }

    @Override
    protected void goToAlternativeState() {
    }
}
