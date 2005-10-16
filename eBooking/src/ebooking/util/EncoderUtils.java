package ebooking.util;

import javax.servlet.http.HttpServletRequest;

/**
 * EncoderUtils.
 * <p/>
 * User: rro
 * Date: 22.06.2005
 * Time: 23:51:58
 *
 * @author Roman R&auml;dle
 * @version $Id: EncoderUtils.java,v 1.1 2005/10/16 18:27:17 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class EncoderUtils {

    /**
     * Encodes an URL using the context and servlet path available in the request.
     *
     * @param request The current HttpServletRequest
     * @param url     The url to encode.
     * @return The encoded URL
     */
    public static String encodeURL(HttpServletRequest request, String url) {
        StringBuffer sb = new StringBuffer(request.getScheme()).
                append("://").
                append(request.getServerName()).
                append(":").
                append(request.getServerPort()).
                append(request.getContextPath()).
                append(request.getServletPath()).
                append(url);

        return sb.toString();
    }
}