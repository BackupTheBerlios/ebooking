package ebooking.core.security;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UrlPathHelper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ebooking.core.session.UserSession;
import ebooking.core.Constants;

/**
 * SecurityInterceptor.
 * <p/>
 * <p>This security should be invoked for every request in the application.
 * It checks if the user has already logged in.
 * In case this check fails, the user gets a redirect to the login page.
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 20:59:05
 *
 * @author Roman R&auml;dle
 * @version $Id: SecurityInterceptor.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public final class SecurityInterceptor extends HandlerInterceptorAdapter {
    private UrlPathHelper pathHelper = new UrlPathHelper();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, Constants.USER_SESSION_KEY);

        if (userSession == null) {
            // retrieve target page
            String targetPage = pathHelper.getLookupPathForRequest(request);

            ModelAndView modelAndView = new ModelAndView(new RedirectView(request.getContextPath() + request.getServletPath() + "/login.jspa"));

            modelAndView.addObject("targetPage", targetPage);
            
            throw new ModelAndViewDefiningException(modelAndView);
        }
        else {
            // user is logged in -> set the security context
            /*
            Authorization authorization = userSession.getAuthorization();
            SecurityContextHolder.setSecurityContext(newSecurityContext(userSession, authorization));
            */
            return true;
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        //SecurityContextHolder.release();
    }
}
