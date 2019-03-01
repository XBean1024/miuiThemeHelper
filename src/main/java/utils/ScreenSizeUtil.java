package utils;

public final class ScreenSizeUtil {

    public static int getScreenWidth() {

        return java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    public static int getScreenHeight() {
        return java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    }
}