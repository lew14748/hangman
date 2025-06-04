package logic;

import state.AbstractState;

public class Context {

    private Game game;
    private AbstractState currentAbstractState;

    public void setUp() {
        game = new Game();
    }

    public Context(AbstractState initialState) {
        currentAbstractState = initialState;
        currentAbstractState.setContext(this);
    }

    public void goToState(AbstractState newAbstractState) {
        currentAbstractState = newAbstractState;
        currentAbstractState.setContext(this);
    }

    public AbstractState getCurrentAbstractState() {
        return currentAbstractState;
    }

    public Game getGame() {
        return game;
    }
}
