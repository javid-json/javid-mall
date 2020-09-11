import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GeneralTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(getValue());
        //System.out.println("汉字".getBytes("UTF-8").length);
    }

    protected boolean equals(String str) {
        return super.equals(str);
    }

    public static int getValue() {
        int i = 1;
        try {
            i = 4;
        } finally{
            i++;
            return i;
        }
    }

    public static void calulate(){

    }
}
