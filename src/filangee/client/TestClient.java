
package filangee.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
 *
 * @author akhil
 */
public class TestClient
{
    public static void main(String args[])
    {
        Socket sc = null;
        try
        {
            System.out.println("Checkpoint 1");
            sc = new Socket(InetAddress.getLocalHost(), 9191);
            System.out.println("Checkpoint 2");
            HashMap<String, Object> output = null;
            System.out.println("Checkpoint 3");
            HashMap<String, Object> input = new HashMap<String, Object>();
            System.out.println("Checkpoint 4");
	    input.put("fileName", "/var/tmp/newFile.txt");
	    input.put("userName", "Lalu Prasad Yadav.");
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            System.out.println("Checkpoint 5");
            out.writeObject("filangee.TestFilangee");
            out.writeObject(input);
            System.out.println("Checkpoint 6");
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
            System.out.println("Checkpoint 7");
            output = (HashMap<String, Object>)in.readObject();
            System.out.println("Checkpoint 8");

            Set<String> keys = output.keySet();

            System.out.println("Output from Server");
            for (String key : keys)
                System.out.println(" Key : " + key + "\t" + " Value : " + (Integer)output.get(key));
            System.out.println("Done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
