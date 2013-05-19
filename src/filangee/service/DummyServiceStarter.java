package filangee.service;

/**
 *
 * @author akhil
 */

public class DummyServiceStarter
{
    public static void main(String args[])
    {
        FilangeeServiceManager serviceManager = FilangeeServiceManager.getInstance(9191);
        serviceManager.startService();
    }
}
