<%--
  User: rro
  Date: 12.04.2005
  Time: 11:41:39

  @author Roman R&auml;dle
  @version $Id: frameset.jsp,v 1.1 2005/10/16 18:27:22 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <title><fmt:message key="application.name"/></title>
    </head>

    <frameset rows="20%, *" border="0">
        <frame src="menu.jspa" border="0" name="menu" scrolling="no">
        <frame src="list_customer.jspa" border="0" name="main" scrolling="no">
    </frameset>

    <noframes>
        <fmt:message key="browser.doesnt.support.frames"/>
    </noframes>
</html>