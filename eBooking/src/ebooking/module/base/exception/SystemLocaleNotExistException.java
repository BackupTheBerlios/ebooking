package ebooking.module.base.exception;

/**
 * <p/>
 * User: Tom
 * Date: 14.05.2005
 * Time: 13:53:32
 *
 * @author Thomas R&auml;dle
 * @version $Id: SystemLocaleNotExistException.java,v 1.1 2005/10/16 18:27:11 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class SystemLocaleNotExistException extends RuntimeException {
    public SystemLocaleNotExistException(String message) {
        super(message);    
    }
}
