package ebooking.core.context;

/**
 * BeanNotFoundException.
 * <p/>
 * <p>DOCUMENT ME!
 *
 * @author Juergen Denzel
 * @version $Id: BeanNotFoundException.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 */
public class BeanNotFoundException extends RuntimeException
{
    public BeanNotFoundException( String message )
    {
        super( message );
    }

    public BeanNotFoundException( String message, Throwable cause )
    {
        super( message, cause );
    }
}