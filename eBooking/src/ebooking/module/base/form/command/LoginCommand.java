package ebooking.module.base.form.command;

/**
 * LoginCommand.
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 10:45:37
 *
 * @author Roman R&auml;dle
 * @version $Id: LoginCommand.java,v 1.1 2005/10/16 18:27:11 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class LoginCommand {

    /**
     * The user login id.
     */
    private String loginId;

    /**
     * The user password.
     */
    private String password;

    /**
     * The error object that gets the occuring errors.
     */
    private Object error;

    /**
     * Returns the login id.
     *
     * @return The user login id.
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the login id.
     *
     * @param loginId The user login id.
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Returns the user password.
     *
     * @return The user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user password.
     *
     * @param password The user password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the object that contains all errors.
     *
     * @return A dummy object that gets binding errors.
     */
    public Object getError() {
        return error;
    }

    /**
     * Sets the errors object.
     *
     * @param error A dummy object that gets binding errors.
     */
    public void setError(Object error) {
        this.error = error;
    }
}
