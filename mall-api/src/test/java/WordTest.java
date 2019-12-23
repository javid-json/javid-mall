import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ：javid
 * @date ：Created in 2019-11-15
 * @description：${description}
 * @modified By：
 * @version: 1.0
 */
public class WordTest {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\Administrator\\Desktop\\会议.docx";
        Map<String,Object> params = new HashMap();
        params.put("bookRUNPLAN","2019-11");
        params.put("bookPREPOWER","1000");
        params.put("bookYEARTOTAL","200");
        params.put("bookAQTS","150");

        List<List<Map<String,Object>>> tableList = new LinkedList();
        List<Map<String,Object>> listMap1 = new LinkedList<Map<String, Object>>();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("a",1);
        map.put("b",1);
        map.put("c",1);
        map.put("d",1);
        map.put("e",1);
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("a",1);
        map1.put("b",2);
        map1.put("c",3);
        map1.put("d",4);
        map1.put("e",5);
        listMap1.add(map);
        listMap1.add(map1);
        List<Map<String,Object>> listMap2 = new LinkedList<Map<String, Object>>();
        listMap2.add(map);
        tableList.add(listMap1);
        tableList.add(listMap2);
        WordUtil.getWord(path,params,tableList);
    }
}
