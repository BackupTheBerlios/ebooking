package ebooking.module.base.form;

import ebooking.module.base.form.command.LoginCommand;
import ebooking.module.base.bean.system.User;
import ebooking.core.Constants;
import ebooking.core.util.Encrypter;
import ebooking.core.session.UserSession;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import org.springframework.validation.BindException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginForm.
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 10:15:42
 *
 * @author Roman R&auml;dle
 * @version $Id: LoginForm.java,v 1.1 2005/10/16 18:27:11 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public final class LoginForm extends AbstractForm implements InitializingBean {

    /**
     * The display name of the application.
     */
    private String applicationDisplayName;

    /**
     * The password encrypter.
     */
    private Encrypter encrypter;

    /**
     * Prepare the login form.
     */
    public LoginForm() {
        this.setCommandName("login");
        this.setCommandClass(LoginCommand.class);
        this.setSessionForm(true);
        this.setValidateOnBinding(false);
        this.encrypter = new Encrypter();
    }

    /**
     * This method is called after all properties were set.
     *
     * @throws Exception If an error occures while initializing.
     */
    public void afterPropertiesSet() throws Exception {
        this.getServletContext().setAttribute(Constants.APPLICATION_DISPLAY_NAME_KEY, this.applicationDisplayName);
    }

    /**
     * Returns the display application name.
     *
     * @return A <code>String</code> that contains the application display name.
     */
    public String getApplicationDisplayName() {
        return applicationDisplayName;
    }

    /**
     * Sets the display application name.
     *
     * @param applicationDisplayName A <code>String</code> that contains the application display name.
     */
    public void setApplicationDisplayName(String applicationDisplayName) {
        this.applicationDisplayName = applicationDisplayName;
    }

    protected boolean isFormSubmission(HttpServletRequest request) {
        // if a UserSession is present or a normal POST request -> invoke onSubmit()
        return UserSession.isLoggedIn(request) || super.isFormSubmission(request);
    }

    protected void onBind(HttpServletRequest request, Object command, BindException errors) throws Exception {
        // only validate if the user has not yet logged in
        if (!UserSession.isLoggedIn(request)) {
            //doValidate(command, errors);
        }
    }

    /**
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, Object, org.springframework.validation.BindException)
     */
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object o, BindException errors) throws Exception {

        // User is logged -> forward to success view
        if (UserSession.isLoggedIn(request)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Using available UserSession for login.");
            }

            return new ModelAndView(this.getSuccessView());
        }

        LoginCommand loginCmd = (LoginCommand) o;

        if (LOG.isDebugEnabled()) {
            LOG.debug("Logging in with loginId: " + loginCmd.getLoginId() + " and password: " + loginCmd.getPassword());
        }

        User user = this.getBaseService().getUserByLoginId(loginCmd.getLoginId());

        if (user == null) {
            errors.rejectValue("error", "wrong.login.id.or.password", null, "Ungültiger Login oder falsches Passwort");
            return showForm(request, response, errors);
        }
        else if (!encrypter.matches(user.getPassword(), loginCmd.getPassword())) {
            int loginCount = user.getPasswordFailed() + 1;

            int maxAllowedTrys = 3;

            if (loginCount > maxAllowedTrys) {
                user.setLocked(true);
            }
            else {
                user.setPasswordFailed(loginCount);
            }

            this.getBaseService().saveOrUpdate(user);

            errors.rejectValue("error", "wrong.login.id.or.password", null, "Ungültiger Login oder falsches Passwort");

            return showForm(request, response, errors);
        }
        else if (user.isLocked()) {
            errors.rejectValue("error", "locked.login.access", null, "Zugang ist gesperrt");
            return showForm(request, response, errors);
        }

        user.setPasswordFailed(0);

        this.getBaseService().saveOrUpdate(user);

        /*
         * successful login put the UserSession into the HttpSession
         */
        UserSession userSession = new UserSession();

        WebUtils.setSessionAttribute(request, Constants.USER_SESSION_KEY, userSession);

        this.fireApplicationEvent(loginCmd);

        return new ModelAndView(this.getSuccessView());
    }
}
