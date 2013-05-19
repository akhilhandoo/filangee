
package filangee.processor;

import filangee.Filangee;
import java.util.HashMap;

/**
 *
 * @author akhil
 */
public class FilangeeProcessor
{
    private boolean available;
    private String processorName;

    public FilangeeProcessor(String processorName)
    {
        this.processorName = processorName;
        available = true;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public synchronized HashMap<String, Object> process(String filangeeName, HashMap<String, Object> input) throws UnavailableException
    {
        HashMap<String, Object> result = null;
        if (!available)
            throw new UnavailableException(" This processor is otherwise engaged. Name : " + processorName);
        else
        {
            available = false;
            try
            {
                Class classToBeExercised = Class.forName(filangeeName);
                Filangee f = (Filangee)classToBeExercised.newInstance();
                result = f.process(input);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        available = true;
        return(result);
    }
}
