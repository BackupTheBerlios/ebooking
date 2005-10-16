package ebooking.module.base.exception;

/**
 * <p/>
 * User: rro
 * Date: 15.05.2005
 * Time: 14:15:38
 *
 * @author Roman R&auml;dle
 * @version $Id: CountryNotExistException.java,v 1.1 2005/10/16 18:27:11 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class CountryNotExistException extends RuntimeException {
    public CountryNotExistException(String message) {
        super(message);
    }
}
