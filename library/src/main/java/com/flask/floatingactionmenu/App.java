package com.flask.floatingactionmenu;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.View;

/**
 * Created by mtrakal on 27.05.2016.
 */
public class App extends Application {

    /**
     * Instance of the current application.
     */
    private static App instance;

    /**
     * Constructor.
     */
    public App() {
        instance = this;
    }

    /**
     * Gets the application context.
     *
     * @return the application context
     */
    public static Context getContext() {
        return instance;
    }

    /**
     * Is phone set to RTL (Arabic/Persian countries)
     *
     * @return {@code true} when phone is RTL, {@code false} when phone is LTR
     */
    public static boolean isRTL() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (App.getContext().getResources().getConfiguration().getLayoutDirection() == View.LAYOUT_DIRECTION_RTL) {
                return true;
            }
        }
        return false;
    }

}
