package util;

/**
 * Created by Administrator on 2016/8/27.
 */
public class StringUtil {

    private StringUtil() {
        //can not be instantiated
        throw new UnsupportedOperationException("can not be instantiated");
    }

    /**
     * 通用字符串非空判断
     *
     * @param content
     * @return isEmpty
     */
    public static boolean isEmpty(String content) {
        if (null == content)
            return true;

        if ("".equals(content.trim()))
            return true;

        return false;
    }

}
