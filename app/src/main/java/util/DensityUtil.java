package util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Administrator on 2016/8/27.
 */
public class DensityUtil {

    private DensityUtil() {
        //can not be instantiated
        throw new UnsupportedOperationException("can not be instantiated");
    }

    /**
     * dp转px
     *
     * @param context
     * @param dp
     * @return px
     */
    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param context
     * @param px
     * @return dp
     */
    public static float px2dp(Context context, int px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (px / scale);
    }

    /**
     * sp转px
     *
     * @param context
     * @param sp
     * @return px
     */
    public static int sp2px(Context context, float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    /**
     * px转sp
     *
     * @param context
     * @param px
     * @return sp
     */
    public static float px2sp(Context context, int px) {
        float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (px / scale);
    }
}
