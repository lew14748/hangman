package state;

import utils.IOAdapter;

public class Game extends AbstractState {

    public void run() {
        render();
        System.exit(0);
    }

    public void render() {
        IOAdapter.getInstance().write("Game should be here");
    }

    @Override
    protected void goToNextState() {
        getContext().goToState(new state.GameOver());
    }

    @Override
    protected void goToAlternativeState() {
    }
}
