package bobo.learn.algorithm.vivo;

import sun.security.provider.MD5;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class VivoToken {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        printToken();
    }

    public static void printToken() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String appid = "15001";
        String appKey = "57407078-2680-4465-81d6-7f663ec2600b";
        String timeStamp = System.currentTimeMillis()+"";
        System.out.println(timeStamp);
        String appSecre = "adc65517-8549-4084-a836-51cc9d6f565d";

        String result = appid + appKey + timeStamp + appSecre;
        byte[] bytesOfMessage = result.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        String myHash = DatatypeConverter
                .printHexBinary(thedigest).toLowerCase();
        System.out.println(myHash);
    }
}
