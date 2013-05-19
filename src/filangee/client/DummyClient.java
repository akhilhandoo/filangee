
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
public class DummyClient
{
    public static void main(String args[])
    {
        Socket sc = null;
        try
        {
            sc = new Socket(InetAddress.getLocalHost(), 9191);
            HashMap<String, Object> output = null;
            HashMap<String, Object> input = new HashMap<String, Object>();
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            out.writeObject("filangee.CounterFilangee");
            out.writeObject(input);
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
            output = (HashMap<String, Object>)in.readObject();

            Set<String> keys = output.keySet();

            System.out.println("Output from Server");
            for (String key : keys)
                System.out.println(" Key : " + key + "\t" + " Value : " + (Integer)output.get(key));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
