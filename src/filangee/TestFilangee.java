package filangee;

import java.util.HashMap;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author akhil
 */
public class TestFilangee implements Filangee
{
    @Override
    public HashMap<String, Object> process(HashMap<String, Object> hm)
    {
	System.out.println("Got a hit...");
        PrintWriter out = null;
        try
        {
	    System.out.println("About to process test filangee...");
            out = new PrintWriter(new FileWriter(new File((String)(hm.get("fileName")))));
	System.out.println("Created print writer to write to the file...");
            out.println("Hello " + (String)(hm.get("userName")) + " !");
	System.out.println("Written message to file...");
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
        finally
        {
	System.out.println("About to close writer...");
            out.close();
	System.out.println("Writer closed. About to return to client");
            return(new HashMap<String, Object>());
        }
    }
}
