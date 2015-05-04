/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author kamohan2
 */
public class UTCToLocalTime {

    public static void main(String[] args) throws ParseException {


        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        utcFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date date = utcFormat.parse("2015-05-30T10:10:00Z");

        System.out.println("Time in UTC -->" + utcFormat.format(date));

        DateFormat localeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        localeFormat.setTimeZone(TimeZone.getDefault());

        System.out.println("Default timezone ->" + TimeZone.getDefault().getDisplayName());
        System.out.println("Time in local -->" + localeFormat.format(date));

    }
}
