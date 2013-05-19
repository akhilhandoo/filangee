package filangee;

import java.util.HashMap;
import java.util.Date;
/**
 *
 * @author akhil
 */
public class CounterFilangee implements Filangee
{
    private static int count = 0;

    public HashMap<String, Object> process(HashMap<String, Object> hm)
    {
        count++;
        HashMap<String, Object> toReturn = new HashMap<String, Object>();
        toReturn.put("hitCount", count);
        return(toReturn);
    }
}
