package it.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String stringFromDate(Date d) {

        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(d);
    }

    public static Date dateTimeFromString(String s) {

        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date d= null;
        try {
            d = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return d;
    }
}
