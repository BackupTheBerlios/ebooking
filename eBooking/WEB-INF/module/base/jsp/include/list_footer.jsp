<%--
  User: rro
  Date: 14.05.2005
  Time: 18:48:29

  @author Roman R&auml;dle
  @version $Id: list_footer.jsp,v 1.1 2005/10/16 18:27:23 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>

<%@ taglib uri="/c" prefix="c" %>

  </body>

  <script language='JavaScript' src="<c:url value="/js/tooltip.js"/>"></script>
  <script language="JavaScript">
    if (!window.OSBUtility_script_loaded) {
      document.write("\<script" );
      document.write(' language="JavaScript"' );
      document.write(" src='../js/osbutility.js'");
      document.write("\>" );
      document.write("\</script\>" );
    }
    setTimeout('__applyFocusEventListeners();',220);
    setTimeout('__registerValidators();',220);
    setTimeout('__applyValidationEventListeners();',220);
  </script>

</html>