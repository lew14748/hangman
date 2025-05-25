package utils;

public class OSData {
    enum OS {
        WINDOWS,
        LINUX
    }

    private static final OS os;

    static {
        String osInfo = System.getProperty("os.name");
        if (osInfo.contains("Windows")) {
            os = OS.WINDOWS;
        } else {
            os = OS.LINUX;
        }
    }

    public static OS getOS() {
        return os;
    }
}
