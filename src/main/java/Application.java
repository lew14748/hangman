import logic.Context;

public class Application {
    public static void main(String[] argv) {
        Context context = new Context(new state.MainMenu());
        while (true)
            context.getCurrentAbstractState().run();
    }
}
