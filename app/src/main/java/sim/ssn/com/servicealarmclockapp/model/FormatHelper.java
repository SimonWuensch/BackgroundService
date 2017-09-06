package sim.ssn.com.servicealarmclockapp.model;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FormatHelper {

    public static String formatDate(long millis) {
        return formatDate(new Date(millis));
    }

    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy - hh:mm:ss");
        return format.format(date);
    }

    public static String getEncodeAddress(String address) throws UnsupportedEncodingException {
        if (address.contains("?")) {
            address = address.replaceAll(" ", "%20");
            return address;
        }
        return address;
    }

    public static long formatHoursToMilliseconds(String hour) {
        return TimeUnit.HOURS.toMillis(Integer.parseInt(hour));
    }

    public static long formatMinutesToMilliseconds(String minutes) {
        return TimeUnit.MINUTES.toMillis(Integer.parseInt(minutes));
    }

    public static long formatMinutesToMilliseconds(int minutes) {
        return TimeUnit.MINUTES.toMillis(minutes);
    }

    public static long formatMillisecondsToHours(long millis) {
        return TimeUnit.MILLISECONDS.toHours(millis);
    }

    public static long formatMillisecondsToMinutes(long millis) {
        return TimeUnit.MILLISECONDS.toMinutes(millis);
    }
}
