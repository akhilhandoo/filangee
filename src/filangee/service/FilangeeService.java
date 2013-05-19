package filangee.service;

import filangee.processor.*;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author akhil
 */
public class FilangeeService implements Runnable
{
    private Socket connection;
    private Thread serviceThread;

    public FilangeeService(Socket connection)
    {
        this.connection = connection;
        serviceThread = new Thread(this);
    }

    public void start()
    {
        serviceThread.start();
    }

    @Override
    public void run()
    {
        String filangeeName = null;
        HashMap<String, Object> input = null;
        HashMap<String, Object> output = null;

        try
        {
            ObjectInputStream inputStream = new ObjectInputStream(connection.getInputStream());
            filangeeName = (String)(inputStream.readObject());
            input = (HashMap<String, Object>)(inputStream.readObject());

            FilangeeProcessor fps = FilangeeProcessorManager.getinstance().getProcessor();
            output = fps.process(filangeeName, input);

            ObjectOutputStream outputStream = new ObjectOutputStream(connection.getOutputStream());
            outputStream.writeObject(output);
        }
        catch (ClassNotFoundException cnf)
        {
            cnf.printStackTrace();
        }
        catch (UnavailableException ue)
        {
            ue.printStackTrace();
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }
}
