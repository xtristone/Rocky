package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/27.
 */
public class PublicUtils {

    private PublicUtils() {
        //can not be instantiated
        throw new UnsupportedOperationException("can not be instantiated");
    }

    /**
     * 时间格式化
     *
     * @param milliSec
     * @param format
     * @return time
     */
    public static String timeTransformer(long milliSec, String format) {
        if (null == format)
            format = "yyyy-MM-dd HH-mm-ss";

        return new SimpleDateFormat(format).format(new Date(milliSec));
    }

}
