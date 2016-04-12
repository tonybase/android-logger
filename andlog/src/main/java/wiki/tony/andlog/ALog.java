package wiki.tony.andlog;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Android日志扩展类
 * 1.控制输出级别
 * 2.控制日志输出长度
 * 3.打印JSON时漂亮输出
 *
 * Created by Tony on 4/12/16.
 */
public class ALog {

    public static int v(String tag, Object msg) {
        if (LogConfig.PRIORITY > Log.VERBOSE) return 0;

        return Log.v(tag, toString(msg));
    }

    public static int v(String tag, Object msg, Throwable tr) {
        if (LogConfig.PRIORITY > Log.VERBOSE) return 0;
        if (tr == null) {
            return v(tag, msg);
        }
        return Log.v(tag, toString(msg), tr);
    }

    public static int d(String tag, Object msg) {
        if (LogConfig.PRIORITY > Log.DEBUG) return 0;

        return Log.d(tag, toString(msg));
    }

    public static int d(String tag, Object msg, Throwable tr) {
        if (LogConfig.PRIORITY > Log.DEBUG) return 0;
        if (tr == null) {
            return d(tag, msg);
        }
        return Log.d(tag, toString(msg), tr);
    }

    public static int i(String tag, Object msg) {
        if (LogConfig.PRIORITY > Log.INFO) return 0;

        return Log.i(tag, toString(msg));
    }

    public static int i(String tag, Object msg, Throwable tr) {
        if (LogConfig.PRIORITY > Log.INFO) return 0;
        if (tr == null) {
            return i(tag, msg);
        }
        return Log.i(tag, toString(msg), tr);
    }

    public static int w(String tag, Object msg) {
        if (LogConfig.PRIORITY > Log.WARN) return 0;

        return Log.w(tag, toString(msg));
    }

    public static int w(String tag, Object msg, Throwable tr) {
        if (LogConfig.PRIORITY > Log.WARN) return 0;
        if (tr == null) {
            return w(tag, msg);
        }
        return Log.w(tag, toString(msg), tr);
    }

    public static int e(String tag, Object msg) {
        if (LogConfig.PRIORITY > Log.ERROR) return 0;

        return Log.e(tag, toString(msg));
    }

    public static int e(String tag, Object msg, Throwable tr) {
        if (LogConfig.PRIORITY > Log.ERROR) return 0;
        if (tr == null) {
            return e(tag, msg);
        }
        return Log.e(tag, toString(msg), tr);
    }

    public static String toString(Object msg) {
        if (msg == null || TextUtils.isEmpty(msg.toString())) {
            return "Empty/Null log content";
        }
        return toPrettyFormat(msg.toString());
    }

    public static String toPrettyFormat(String json) {
        String message;
        try {
            if (json.startsWith("{") && json.endsWith("}")) {
                message = new JSONObject(json).toString(LogConfig.JSON_INDENT);
            } else if (json.startsWith("[") && json.endsWith("]")) {
                message = new JSONArray(json).toString(LogConfig.JSON_INDENT);
            } else {
                message = json;
            }
        } catch (JSONException e) {
            message = json;
        }
        if (LogConfig.MAX_LENGTH > 0 && message.length() > LogConfig.MAX_LENGTH) {
            message = message.substring(0, LogConfig.MAX_LENGTH);
        }
        return message;
    }

}
