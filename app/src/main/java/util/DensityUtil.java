package util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Administrator on 2016/8/27.
 */
public class DensityUtil {

    private DensityUtil() {
        //can not be instinated
        throw new UnsupportedOperationException("can not be instinated");
    }

    /**
     * dp转px
     *
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param context
     * @param px
     * @return
     */
    public static float px2dp(Context context, int px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (px / scale);
    }

}
