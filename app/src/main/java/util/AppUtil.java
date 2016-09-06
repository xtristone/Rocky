package util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2016/9/6.
 */
public class AppUtil {

    private AppUtil() {
        //can not be instantiated
        throw new UnsupportedOperationException("can not be instantiated");
    }

    /**
     * 获取应用名称
     *
     * @param context
     * @return appName
     */
    public static String getAppName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            int labelRes = info.applicationInfo.labelRes;
            String appName = context.getResources().getString(labelRes);
            return appName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取版本信息
     *
     * @param context
     * @return versionName
     */
    public static String getVersionName(Context context){
        try {
            PackageManager manager=context.getPackageManager();
            PackageInfo info=manager.getPackageInfo(context.getPackageName(), 0);
            String versionName=info.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

}
