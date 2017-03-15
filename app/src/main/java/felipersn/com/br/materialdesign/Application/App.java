package felipersn.com.br.materialdesign.Application;

import android.app.Application;
import android.content.Context;
import android.os.Vibrator;
import android.util.DisplayMetrics;

import static java.security.AccessController.getContext;

/**
 * Created by Felipe Silveira on 3/11/2017.
 */

public class App extends Application {

    private static App myInstance;
    private Vibrator vibe;

    public static App getInstance(){
        if(myInstance == null) myInstance = new App();
        return myInstance;
    }

    public void vibrate(Context c, long value){
        vibe = (Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(value);
    }

    public int dpToPx(Context c, int dp) {
        DisplayMetrics displayMetrics = c.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public int pxToDp(Context c, int px) {
        DisplayMetrics displayMetrics = c.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
