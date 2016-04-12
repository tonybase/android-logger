package wiki.tony.andlog;

import java.lang.reflect.Constructor;

/**
 * 日志工厂，选择日志实现方式
 * 1.常规Console日志输出
 * 2.文件日志输出
 *
 * Created by Tony on 4/12/16.
 */
public class LoggerFactory {

    public static Logger getLogger(String tag) {
        try {
            Constructor<? extends Logger> constructor
                    = LogConfig.LOGGER_CLASS.getDeclaredConstructor(new Class[]{String.class});
            return constructor.newInstance(tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Logger(tag);
    }

    public static Logger getLogger(Class clazz) {
        return getLogger(clazz.getSimpleName());
    }
}
