package bobo.learn.algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * stackoverflow上的解决办法：
 * https://stackoverflow.com/questions/20165564/calculating-days-between-two-dates-with-java/20165708#20165708
 */
public class LearnDate {
    public static void main(String[] args) {
        System.out.println(null instanceof String);
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String inputString1 = "2020-06-02";
        String inputString2 = "2020-06-01";

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
