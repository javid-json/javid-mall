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

        List<String[]> tableList = new LinkedList();
        Map<String,Object> map = new HashMap<String, Object>();
        String[] a = new String[]{"a","b","c","d","e"};
        String[] b = new String[]{"a","b","c","d","f"};
        tableList.add(a);
        tableList.add(b);
        WordUtil.getWord(path,params,tableList);
    }
}
