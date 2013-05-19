package filangee.service;

import java.net.ServerSocket;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author akhil
 */

public class FilangeeServiceManager implements Runnable
{
    private ServerSocket serverSocket = null;
    private static ConcurrentHashMap<Integer, FilangeeServiceManager> instances = new ConcurrentHashMap<Integer, FilangeeServiceManager>();
    private Thread serviceThread;
    private boolean running;

    public static synchronized FilangeeServiceManager getInstance(int portNumber)
    {
        try
        {
            if (instances.containsKey(portNumber))
                return(instances.get(portNumber));
            else
            {
                FilangeeServiceManager newManager = new FilangeeServiceManager(portNumber);
                instances.put(portNumber, newManager);
                return(newManager);
            }
        }
        catch (IOException ie)
        {
            return(null);
        }
    }

    private FilangeeServiceManager(int portNumber) throws IOException
    {
        serverSocket = new ServerSocket(portNumber);
        serviceThread = new Thread(this);
        running = false;
    }

    public void startService()
    {
        running = true;
        serviceThread.start();
    }

    public ServerSocket getServerSocket()
    {
        return(serverSocket);
    }

    public void run()
    {
        while(running)
        {
            try
            {
                FilangeeService fs = new FilangeeService(serverSocket.accept());
                fs.start();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void stopService()
    {
        running = false;
        try
        {
            serverSocket.close();
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }
}
