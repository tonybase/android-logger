package wiki.tony.andlog;

import android.util.Log;

import java.io.File;

/**
 * 日志配置文件
 *
 * Created by Tony on 4/12/16.
 */
public class LogConfig {

    /**
     * 日志实现类，默认为常规Console输出日志，或者文件日志实现类等等
     */
    public static Class<? extends Logger> LOGGER_CLASS = Logger.class;

    /**
     * 最低日记输出级别
     */
    public static int PRIORITY = Log.VERBOSE;

    /**
     * 保存文件日志的级别
     */
    public static int FILE_PRIORITY = Log.ERROR;

    /**
     * 保存日志目录
     */
    public static File FILE_PATH = new File("logs");

    /**
     * 单个日志文件大小 200K
     */
    public static int FILE_MAX_LENGTH = 204800;

    /**
     * 日志文件最多数量 达到后删除日志
     */
    public static int FILE_MAX_COUNT = 100;

    /**
     * 日志长度
     */
    public static int MAX_LENGTH = -1;

    /**
     * Json 打印时缩进
     */
    public static int JSON_INDENT = 4;

    /**
     * TAG 前缀，方便区别系统日志
     */
    public static String TAG_PREFIX = "AndLog";

}
