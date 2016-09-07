package tristone.rocky.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/9/5.
 */
public class KeyboardUtil {

    private KeyboardUtil(){
        //can not be instantiated
        throw new UnsupportedOperationException("can not be instantiated");
    }

    /**
     * 显示键盘
     *
     * @param context
     * @param mEditText
     */
    public static void showKeyboard(Context context, EditText mEditText){
        InputMethodManager manager=(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        manager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 隐藏键盘
     *
     * @param context
     * @param mEditText
     */
    public static void hideKeyBoard(Context context, EditText mEditText){
        InputMethodManager manager=(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
