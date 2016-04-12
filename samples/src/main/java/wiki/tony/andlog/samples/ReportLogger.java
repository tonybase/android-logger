package wiki.tony.andlog.samples;

import android.util.Log;

import wiki.tony.andlog.Logger;

/**
 * 自定义日志
 * <p/>
 * Created by Tony on 4/12/16.
 */
public class ReportLogger extends Logger {

    public ReportLogger(String tag) {
        super(tag);
    }

    @Override
    protected int println(int priority, Object msg, Throwable tr) {
        // 判断日志级别
        if (priority >= Log.ERROR) {
            report(priority, msg, tr);
        }
        return super.println(priority, msg, tr);
    }

    /**
     * 对日志反馈处理
     *
     * @param priority
     * @param msg
     * @param tr
     */
    private void report(int priority, Object msg, Throwable tr) {

    }
    
}
