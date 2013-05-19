
package filangee.processor;

/**
 *
 * @author akhil
 */
public class UnavailableException extends Exception
{
    private String message;

    public UnavailableException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return(message);
    }
}
