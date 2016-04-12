package wiki.tony.andlog.samples;

import android.app.Application;
import android.util.Log;

import wiki.tony.andlog.FileLogger;
import wiki.tony.andlog.LogConfig;

/**
 * Created by Tony on 4/12/16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        logConfig();
    }

    private void logConfig() {

        // 日志实现类
        // Logger 控制台日志
        // FileLogger 文件日志
        LogConfig.LOGGER_CLASS = FileLogger.class;
        // 最低日记输出级别
        LogConfig.PRIORITY = Log.VERBOSE;
        // 保存文件日志的级别
        LogConfig.FILE_PRIORITY = Log.ERROR;
        // 保存日志目录
        LogConfig.FILE_PATH = getExternalFilesDir("logs");
        // 日志tag
        LogConfig.TAG_PREFIX = "AndLog";
    }

}
