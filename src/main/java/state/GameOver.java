package state;

public class GameOver extends AbstractState {
    public void run() {
        render();
    }

    public void render() {
        //if( getContext())
    }

    protected void goToNextState() {
        getContext().goToState(new state.Game());
    }

    protected void goToAlternativeState() {
        getContext().goToState(new state.Exit());
    }
}
