package filangee;

import java.util.HashMap;
import java.util.Date;
/**
 *
 * @author akhil
 */
public class DummyFilangee implements Filangee
{
    public HashMap<String, Object> process(HashMap<String, Object> hm)
    {
        String command = (String)hm.get("command");
        HashMap<String, Object> toReturn = new HashMap<String, Object>();
        if (command.equalsIgnoreCase("getTime"))
            toReturn.put("Time", (new Date()).toString());

        return(toReturn);
    }
}
