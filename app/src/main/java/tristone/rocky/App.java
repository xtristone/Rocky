package tristone.rocky;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/8/27.
 */
public class App extends Application {
    static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static Context getContext(){
        return instance;
    }
}
