package filangee;

import filangee.processor.*;
import java.util.HashMap;
/**
 *
 * @author akhil
 */
public class TestMain
{
    public static void main(String args[])
    {
        FilangeeProcessor fp = FilangeeProcessorManager.getinstance().getProcessor();
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("fileName", "/tmp/myFile");
        hm.put("userName", "Cinderella");
        try
        {
            fp.process("filangee.TestFilangee", hm);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
