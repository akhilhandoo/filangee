package filangee.processor;

/**
 *
 * @author akhil
 */

public class FilangeeProcessorManager
{
    private FilangeeProcessor processorPool[];

    private static final FilangeeProcessorManager instance = new FilangeeProcessorManager(10);

    public static FilangeeProcessorManager getinstance()
    {
        return instance;
    }

    public FilangeeProcessorManager(int numProcessors)
    {
        processorPool = new FilangeeProcessor[numProcessors];
    }

    public FilangeeProcessor getProcessor()
    {
        synchronized(instance) {
            FilangeeProcessor processor = null;

            int counter = 0;

            for (FilangeeProcessor temp : processorPool)
            {

                if (null == temp)
                {
                    processorPool[counter] = new FilangeeProcessor("" + counter);
                    processor = processorPool[counter];
                    break;
                }

                if (temp.isAvailable())
                {
                    processor = temp;
                    break;
                }

                counter++;
            }

            if (processor == null)
                return(null);
            else
                return(processor);
        }
    }
}
