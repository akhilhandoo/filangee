
package filangee.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.io.*;

/**
 *
 * @author akhil
 */
class Client extends Thread
{
    private int serialNo;

    public Client(int serialNo) {
     this.serialNo = serialNo;
    }

    public void run()
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

            System.out.println("Client No : " + serialNo + " --> Output from Server");
            for (String key : keys)
                System.out.println(" Key : " + key + "\t" + " Value : " + (Integer)output.get(key));
            System.out.println("*********************************");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

public class DummyClient {
 public static void main(String args[]) {
  try {
   int num = Integer.parseInt(args[0]);
   Client d[] = new Client[num];
   for (int x = 1; x <= num; x++) {
    d[x - 1] = new Client(x);
   }
   System.out.println(num + " clients created. Waiting for you to type start...");
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   String input = "";
   while (!(input = br.readLine()).equalsIgnoreCase("start"));
   for (int y = 1; y <= num; y++)
    d[y - 1].start();
  } catch(Exception e) {
   e.printStackTrace();
  }
 }
}
