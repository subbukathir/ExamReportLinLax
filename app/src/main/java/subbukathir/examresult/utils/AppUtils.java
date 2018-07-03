package subbukathir.examresult.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by subbu on 04-07-2018.
 */

public class AppUtils {
    public static String calculatePercentage(double maxValue, double difference) {
        double percent = (difference/maxValue) * 100.0f;
        String percentage = String.format("%.0f",percent);
        return percentage+"%";
    }

    private static Date getActualDate(String strDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getExamDate(String startTime) {
        Date date = getActualDate(startTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d-MMM-yyy");
        return simpleDateFormat.format(date);
    }

    public static String getExamTime(String strDate) {
        Date date = getActualDate(strDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
        return simpleDateFormat.format(date);
    }

    public static String getExamDuration(String startTime, String endTime) {
        String strDuration = "";
        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(startTime);
            d2 = format.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffHours = diff / (60 * 60 * 1000);
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;

        if(diffHours > 0.0){
            if(diffMinutes > 0.0)
                strDuration = diffHours + " hrs " + diffMinutes + " mins";
            else strDuration = diffHours + "hrs ";
        }else if(diffMinutes > 0.0){
            strDuration = diffMinutes + " mins";
        }else if(diffSeconds>0.0)
            strDuration = diffSeconds + " secs";
        return strDuration;
    }
}
