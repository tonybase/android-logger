package wiki.tony.andlog.samples;

import android.app.Activity;
import android.os.Bundle;

import wiki.tony.andlog.LogConfig;
import wiki.tony.andlog.Logger;
import wiki.tony.andlog.LoggerFactory;

/**
 * Created by Tony on 4/12/16.
 */
public class MainActivity extends Activity {

    private Logger logger = LoggerFactory.getLogger(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        test();
    }

    private void test() {

        logger.v(LogConfig.FILE_PATH.getAbsolutePath());

        logger.v("test VERBOSE");
        logger.d("test DEBUG");
        logger.i("test INFO");
        logger.w("test WARN");
        logger.e("test ERROR");

    }

}
