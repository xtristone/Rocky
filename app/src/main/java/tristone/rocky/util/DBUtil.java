package tristone.rocky.util;

import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.List;

import tristone.rocky.App;

/**
 * Created by Administrator on 2016/9/7.
 */
public class DBUtil {

    private final String DB_NAME = "rockygank.db";

    private static DBUtil dbUtil;

    private LiteOrm liteOrm;

    private DBUtil() {
        liteOrm = LiteOrm.newSingleInstance(App.getContext(), DB_NAME);
    }

    public static DBUtil getDbUtil() {
        if (dbUtil == null) {
            dbUtil = new DBUtil();
        }
        return dbUtil;
    }

    public LiteOrm getLiteOrm(){
        return liteOrm;
    }

    public <T> List<T> getData(Class<T> clazz){
        List<T> list=getDbUtil().getLiteOrm().query(clazz);
        if (list==null||list.size()==0){
            list=new ArrayList<>();
            try {
                list.add(clazz.newInstance());
                getDbUtil().getLiteOrm().save(list);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
