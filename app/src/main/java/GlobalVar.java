import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2016/9/5.
 * 全局变量
 */
public class GlobalVar {

    //单例对象
    private static GlobalVar instance;

    //读写锁
    private ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();
    private Lock readLock=rwLock.readLock();
    private Lock writeLock=rwLock.writeLock();

    //keepalive保活时间
    private AtomicInteger keepAlive_Interval = new AtomicInteger(10);

    //会话的sessionToken
    private volatile String session_Token = "";

    //私有构造函数，禁止外部创建
    private GlobalVar() {
    }

    //外部获取单例对象
    public static GlobalVar getInstance() {
        if (null == instance) {
            instance = new GlobalVar();
        }
        return instance;
    }

}
