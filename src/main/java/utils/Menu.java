package utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Character.UnicodeBlock;

public class Menu {
    private static final List<String> MENU_LIST;
    private static final IOAdapter adapter;

    static {
        MENU_LIST = new ArrayList<String>(Arrays.asList("PLAY", "EXIT"));
        adapter = IOAdapter.getInstance();
    }

    public static String validateMenuInput() {
        String input = adapter.read().trim().toUpperCase();
        if (MENU_LIST.contains(input)) {
            return input;
        } else return "WRONG INPUT";
    }

    public static String validateGameInput() {
        String input = adapter.read();
        if (!input.isBlank() && Character.UnicodeBlock.of(input.charAt(0)) == UnicodeBlock.CYRILLIC && input.length() == 1) {
            return String.valueOf(input.toLowerCase().charAt(0));
        } else return "WRONG INPUT";
    }

    public static void renderMenu() {
        adapter.write("Главное меню:");
        for (int i = 0; i < MENU_LIST.size(); i++) {
            adapter.write((i + 1) + ". " + MENU_LIST.get(i));
        }
    }
}
