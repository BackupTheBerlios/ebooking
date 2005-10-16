package ebooking.module.base.bean.system;

import java.io.Serializable;

/**
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 11:39:07
 *
 * @author Roman R&auml;dle
 * @version $Id: User.java,v 1.1 2005/10/16 18:27:04 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class User implements Serializable {

    /**
     * The unique user id.
     */
    private Long id;

    /**
     * The user login id.
     */
    private String loginId;

    /**
     * The user password.
     */
    private String password;

    /**
     * If the user is locked or not.
     */
    private boolean locked = false;

    /**
     * The failed user logins.
     */
    private int passwordFailed = 0;

    /**
     * Returns the user id.
     *
     * @return The user id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the user id.
     *
     * @param id The user id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the user login id.
     *
     * @return The user login id.
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the user login id.
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
     * Whether the user is locked or not.
     *
     * @return Will return true if the user is locked, else false.
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Sets the user locked (true) or not (false).
     *
     * @param locked True if the user should be locked, else false.
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * Returns the number of failed logins.
     *
     * @return Number of failed logins.
     */
    public int getPasswordFailed() {
        return passwordFailed;
    }

    /**
     * Sets the number of failed logins.
     *
     * @param passwordFailed The number of failed logins.
     */
    public void setPasswordFailed(int passwordFailed) {
        this.passwordFailed = passwordFailed;
    }
}
