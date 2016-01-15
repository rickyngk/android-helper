package R.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by duynk on 12/29/15.
 */
public class Common {
    public static boolean isLollipopOrLater() {
        return Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    }

    public static boolean isMarshMallowOrLater() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public static boolean isVersionOrLater(int version) {
        return Build.VERSION.SDK_INT >= version;
    }

    public static int sign(float a) {
        return a > 0?1:(a<0?-1:0);
    }

    public static float lerp(float start, float end, float percent) {
        float dt = Math.abs(start - end);
        float min = Math.max(Math.abs(start) * 0.1f, Math.abs(end) * 0.1f);
        if (dt <= min) {
            start = end;
        }
        return (start + percent * (end - start));
    }

    public static int lerp(int start, int end, float percent) {
        float dt = Math.abs(start - end);
        float min = Math.max(Math.abs(start) * 0.1f, Math.abs(end) * 0.1f);
        if (dt <= min) {
            start = end;
        }
        return (int) (start + percent * (end - start));
    }

    public static float convertDpToPixel(float dp) {
        Resources resources = BaseApplication.sInstance.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * (metrics.densityDpi / 160f);
    }

    public static float convertPixelsToDp(float px, Context context){
        Resources resources = BaseApplication.sInstance.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / (metrics.densityDpi / 160f);
    }

    public static void acceptAllSSL() {
        NukeSSLCerts.nuke();
    }

    public static String join(List<String> list,@NonNull String delim) {
        String tmp_delim = "";
        StringBuilder sb = new StringBuilder();
        for (String s:list) {
            sb.append(tmp_delim);
            sb.append(s);
            tmp_delim = delim;
        }
        return sb.toString();
    }

    public static long getMillis() {
        return Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
    }

    public final static long ONE_SEC = 1000;
    public final static long ONE_MINUTE = ONE_SEC*60;
    public final static long HALF_HOUR = ONE_MINUTE*30;
    public final static long ONE_HOUR = ONE_MINUTE*60;
    public final static long HALF_DAY = ONE_HOUR*12;
    public final static long ONE_DAY = ONE_HOUR*24;
    public final static long ONE_WEEK = ONE_DAY*7;
    public final static long ONE_WORKING_WEEK = ONE_DAY*5;
    public final static long HALF_MONTH = ONE_DAY*15;
    public final static long ONE_MONTH = ONE_DAY*30;

    public static class Dialog {
        public static void alert(final Context ctx, String message, final Callback callback) {
            new AlertDialog.Builder(ctx)
                    .setTitle("Alert")
                    .setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            callback.onCompleted(ctx, new CallbackSuccess(null));
                        }
                    }).create().show();
        }
    }


}
