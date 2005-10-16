package ebooking.core.util;

/**
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 18:00:39
 *
 * @author Roman R&auml;dle
 * @version $Id: Encrypter.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public final class Encrypter {

    /**
     * The crypt tab <code>String</code>.
     */
    private String cryptTab;

    /**
     * The new encrypter with the encrypt tab.
     */
    public Encrypter() {
        cryptTab = "CQ]}5(%8KaMcef*hi,Wkl|>pUr{utEwyx=/B2vDGF&JI9LbN?Z6R!TqVmX.PY:j;1)s3[0#+S4OzH7$-dAgon";
    }

    /**
     * Sets the new crypt tab.
     *
     * @param s The crypt tab <code>String</code>.
     */
    public final void setCryptTab(String s) {
        if (s != null && s.length() >= 0)
            cryptTab = s;
    }

    /**
     * Returns the actual crypt tab.
     *
     * @return The crypt tab <code>String</code>.
     */
    public final String getCryptTab() {
        return cryptTab;
    }

    /**
     * Encrypts this <code>String</code>.
     *
     * @param s The <code>String</code> that should be encrypted.
     * @return The encrypted <code>String</code>.
     */
    public final String encrypt(String s) {
        String s1 = "";
        String s2 = cryptTab + cryptTab;
        String s3 = mkKey(s2, s.length());
        for (int i = 0; i < s.length(); i++) {
            int j = s2.indexOf(s.charAt(i), 0);
            if (j >= 0) {
                j += s2.indexOf(s3.charAt(i), 0);
                s1 = s1 + getTabC(s2, j);
            }
            else {
                s1 = s1 + s.charAt(i);
            }
        }

        s3 = null;
        return s1;
    }

    /**
     * Decrypts this <code>String</code>.
     *
     * @param s The <code>String</code> that should be decrypted.
     * @return The decrypted <code>String</code>.
     */
    public final String decrypt(String s) {
        String s1 = "";
        String s2 = cryptTab + cryptTab;
        String s3 = mkKey(s2, s.length());
        for (int i = 0; i < s.length(); i++) {
            int j = s2.indexOf(s.charAt(i), 0);
            if (j >= 0) {
                j -= s2.indexOf(s3.charAt(i), 0);
                s1 = s1 + getTabC(s2, j);
            }
            else {
                s1 = s1 + s.charAt(i);
            }
        }

        s3 = null;
        return s1;
    }

    /**
     * Make a key.
     *
     * @param s A <code>String</code> that gets the reformat.
     * @param i Reformatting the <code>String</code> with a size i.
     * @return The reformatted <code>String</code>.
     */
    private String mkKey(String s, int i) {
        StringBuffer stringbuffer = new StringBuffer();
        for (int k = 0; k < i; k++)
            stringbuffer.append(getTabC(s, 0x2f73aa49 % (k * 3 + 1) + 3));

        return stringbuffer.toString();
    }

    /**
     * Gets a tab character.
     *
     * @param s A <code>String</code> that gets reformatted.
     * @param i Reformatting the <code>String</code> with a size i.
     * @return The formatted <code>String</code>.
     */
    private char getTabC(String s, int i) {
        char c = '\0';
        int j = s.length();
        if (i < j / 2) {
            c = s.charAt(i + j / 2);
        }
        else {
            int l;
            for (int k = l = 0; k < i; k++)
                if ((k + 1) % (j / 2) == 0)
                    l = 0;
                else
                    l++;

            c = s.charAt(l);
        }
        return c;
    }

    /**
     * Checks whether the encrypted password matches with the entered password or not.
     *
     * @param encryptedPassword The encrypted password.
     * @param enteredPassword The entered password.
     * @return Whether the encrypted password matches with the entered or not.
     */
    public final boolean matches(String encryptedPassword, String enteredPassword) {
        String newCrypt = encrypt(enteredPassword);
        return newCrypt.equals(encryptedPassword);
    }
}
