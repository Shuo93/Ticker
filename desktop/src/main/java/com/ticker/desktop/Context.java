package com.ticker.desktop;

public class Context {
    private static Context ourInstance = new Context();

    public static Context getInstance() {
        return ourInstance;
    }

    private Context() {
    }
}
