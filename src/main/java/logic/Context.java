package logic;

import state.AbstractState;

public class Context {


    private AbstractState currentAbstractState;
    private AbstractState prevAbstractState;

    public Context(AbstractState initialState) {
        currentAbstractState = initialState;
        currentAbstractState.setContext(this);
    }

    public void goToState(AbstractState newAbstractState) {
        prevAbstractState = currentAbstractState;
        currentAbstractState = newAbstractState;
        currentAbstractState.setContext(this);
    }

    public AbstractState getCurrentAbstractState() {
        return currentAbstractState;
    }
}
