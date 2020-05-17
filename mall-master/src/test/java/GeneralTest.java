import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GeneralTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("a",1);
        map.put("b",1);
        map.put("c",1);

        //map key 遍历
        Set<String> keySet = map.keySet();
        for(String key: keySet){
            System.out.println(key);
        }

        //map value 遍历

    }
}
