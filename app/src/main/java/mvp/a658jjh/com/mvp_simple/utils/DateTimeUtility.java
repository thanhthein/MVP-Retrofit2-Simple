package mvp.a658jjh.com.mvp_simple.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@SuppressLint("SimpleDateFormat")
public class DateTimeUtility {
    public static final List<Long> times = Arrays.asList(TimeUnit.DAYS.toMillis(365L), TimeUnit.DAYS.toMillis(30L), TimeUnit.DAYS.toMillis(1L), TimeUnit.HOURS.toMillis(1L), TimeUnit.MINUTES.toMillis(1L), TimeUnit.SECONDS.toMillis(1L));
    private static final List<String> timesString = Arrays.asList("year", "month", "day", "hour", "minute", "second");
    private static final List<String> timesStringViet = Arrays.asList("n?m", "th�ng", "ng�y", "gi?", "ph�t", "gi�y");

    public static String format(long time) {
        return new SimpleDateFormat("dd/MM/yyyy hh:mma").format(time);
    }

    private static String formatDate(long time) {
        return new SimpleDateFormat("dd/MM/yyyy").format(time);
    }

    public static String formatDateEvent(long time1, long time2, long time3) {
        String str1 = new SimpleDateFormat(" hh:mma ").format(time1);
        String str2 = new SimpleDateFormat(" hh:mma ").format(time2);
        String str3 = new SimpleDateFormat("dd/MM").format(time1);
        if (str3.equalsIgnoreCase(new SimpleDateFormat("dd/MM").format(time2))) {
            return str3 + " " + str1 + "-" + str2;
        }
        str3 = new SimpleDateFormat("dd/MM").format(time1);
        String str4 = new SimpleDateFormat("dd/MM").format(time2);
        return str3 + "-" + str4 + " " + str1 + "-" + str2;
    }

    public static String formatDateStart(long time) {
        return new SimpleDateFormat("dd/MM").format(time);
    }

    public static String formatDateToDayMonth(long time) {
        return new SimpleDateFormat("dd MMMM").format(time);
    }

    private static String formatDateToDayMonthYear(long time) {
        return new SimpleDateFormat("dd/MM/yyyy").format(time);
    }

    public static String formatDateToMonth(long time) {
        return new SimpleDateFormat("MMMM").format(time);
    }

    public static String formatDayofWeek(long time) {
        return new SimpleDateFormat("EEEE").format(time);
    }

    public static String formatEvent(long time1, long time2) {
        String str1 = new SimpleDateFormat("hh:mma").format(time1);
        String str2 = new SimpleDateFormat("hh:mma").format(time2);
        return str1 + " - " + str2;
    }

    public static String formatEventTime(long time) {
        return new SimpleDateFormat("hh:mma").format(time);
    }

    public static String formatFullEventTime(long time1, long time2) {
        String str1 = new SimpleDateFormat("EEEE, dd MMMM, yyyy").format(time1);
        String str2 = new SimpleDateFormat("EEEE, dd MMMM, yyyy").format(time2);
        String str3 = new SimpleDateFormat("hh:mma").format(time1);
        String str4 = new SimpleDateFormat("hh:mma").format(time2);
        if (str1.equalsIgnoreCase(str2)) {
            return str1 + " " + str3 + " - " + str4;
        }
        return str1 + " - " + str2 + " " + str3 + " - " + str4;
    }

    public static String formatFullTime(long time) {
        return new SimpleDateFormat("hh:mma").format(time);
    }

    private static String fullFormatDate(long time) {
        return new SimpleDateFormat("EEEE dd/MM/yyyy").format(time);
    }

    public static String getDay(long time) {
        return new SimpleDateFormat("dd").format(time);
    }

    public static String getHour(long time) {
        return new SimpleDateFormat("HH").format(time);
    }

    public static String getMinute(long time) {
        return new SimpleDateFormat("mm").format(time);
    }

    public static String getMonth(long time) {
        return new SimpleDateFormat("M").format(time);
    }

    private Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }

    private Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 23, 59, 59);
        return calendar.getTime();
    }

    public static long getTimeEndOfDay(long time) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(time);
        localCalendar.set(Calendar.HOUR_OF_DAY, 23);
        localCalendar.set(Calendar.MINUTE, 59);
        localCalendar.set(Calendar.SECOND, 59);
        localCalendar.set(Calendar.MILLISECOND, 999);
        return localCalendar.getTimeInMillis();
    }

    public static long getTimeStartOfDay(long time) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(time);
        localCalendar.set(Calendar.HOUR_OF_DAY, 23);
        localCalendar.set(Calendar.MINUTE, 59);
        localCalendar.set(Calendar.SECOND, 59);
        localCalendar.set(Calendar.MILLISECOND, 999);
        return localCalendar.getTimeInMillis();
    }

    public static String getYear(long time) {
        return new SimpleDateFormat("yyyy").format(time);
    }

    public static boolean isOneDay(long time1, long time2) {
        return formatDateToDayMonthYear(time1).equalsIgnoreCase(formatDateToDayMonthYear(time2));
    }
}
