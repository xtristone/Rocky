package tristone.rocky;

import android.app.Application;
import android.content.Context;

import com.litesuits.orm.LiteOrm;

/**
 * Created by Administrator on 2016/8/27.
 */
public class App extends Application {

    private static String DB_NAME="rocky.db"

    public static App instance;
    public static LiteOrm sDB;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        sDB=LiteOrm.newSingleInstance(this, DB_NAME);    //创建数据库
        if (BuildConfig.DEBUG){
            sDB.setDebugged(true);
        }
    }

}
