package bobo.learn.algorithm.primary;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BodyRequest {
    public String token = getToken();

    public static String getToken() {
        System.out.println("调用了！" + System.currentTimeMillis());
        return "";
    }
}
