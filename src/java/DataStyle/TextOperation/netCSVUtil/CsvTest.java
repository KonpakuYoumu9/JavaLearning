package DataStyle.TextOperation.netCSVUtil;

/***Created by moyongzhuo
 *On 2017/10/17  ***20:38.
 ******/
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * CSV操作(导出和导入)
 *
 * @author 林计钦
 * @version 1.0 Jan 27, 2014 4:17:02 PM
 */
public class CsvTest {

    /**
     * CSV导出
     *
     * @throws Exception
     */
    @Test
    public void exportCsv() {
        List<String> dataList=new ArrayList<String>();
        dataList.add("1,张三,男");
        dataList.add("2,李四,男");
        dataList.add("3,小红,女");
        boolean isSuccess=CSVUtil.exportCsv(new File("D:/test/ljq.csv"), dataList);
        System.out.println(isSuccess);
    }

    /**
     * CSV导出
     *
     * @throws Exception
     */
    @Test
    public void importCsv()  {
        List<String> dataList=CSVUtil.importCsv(new File("D:/test/ljq.csv"));
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                System.out.println(data);
            }
        }
    }


}
