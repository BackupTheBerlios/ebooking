package ebooking.module.base.controller;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.beans.BeansException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 20:08:42
 *
 * @author Roman R&auml;dle
 * @version $Id: LogoutController.java,v 1.1 2005/10/16 18:27:05 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class LogoutController implements Controller, ApplicationContextAware {

    protected Log LOG = LogFactory.getLog(this.getClass());

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        applicationContext.publishEvent(new ApplicationEvent(this) {
        });
        request.getSession().invalidate();
        LOG.info("Session invalidated.");
        return new ModelAndView(new RedirectView(request.getContextPath() + "/base/login.jspa"));
    }
}
