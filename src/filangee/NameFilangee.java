package filangee;

import java.util.HashMap;
/**
 *
 * @author akhil
 */
public class NameFilangee implements Filangee
{
    public HashMap<String, Object> process(HashMap<String, Object> hm)
    {
        String firstName = (String)hm.get("firstName");
        String lastName = (String)hm.get("lastName");

        HashMap<String, Object> toReturn = new HashMap<String, Object>();
        toReturn.put("fullName", "" + firstName + " " + lastName);
        return(toReturn);
    }
}
