package ebooking.core.session;

import ebooking.core.Constants;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * UserSession.
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 11:07:14
 *
 * @author Roman R&auml;dle
 * @version $Id: UserSession.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public final class UserSession implements Serializable {

    /**
     * Static convenience method to retrieve the UserSession object from
     * the HttpSession.
     *
     * @param request The current <code>HttpServletRequest</code>.
     * @return The <code>UserSession</code>.
     */
    public static UserSession getUserSession(HttpServletRequest request) {
        return (UserSession) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
    }

    /**
     * Returns true if the user is logged in, else returns false.
     *
     * @param request The current <code>HttpServletRequest</code>.
     * @return The true if the user is logged in.
     */
    public static boolean isLoggedIn(HttpServletRequest request) {
        return getUserSession(request) != null;
    }
}
