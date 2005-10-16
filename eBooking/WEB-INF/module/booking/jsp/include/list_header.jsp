<%--
  User: rro
  Date: 14.05.2005
  Time: 18:48:29
  
  @author Roman R&auml;dle
  @version $Id: list_header.jsp,v 1.1 2005/10/16 18:27:24 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>

<%@ taglib uri="/c" prefix="c" %>
<%@ taglib uri="/spring" prefix="spring" %>
<%@ taglib uri="/fmt" prefix="fmt" %>
<%@ taglib uri="/display" prefix="display"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><fmt:message key="application.title"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <link rel="stylesheet" type="text/css" href="<c:url value="/style/display_data_table.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/style/display_form.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/style/menu.css"/>">
    <script language="JavaScript" src="<c:url value="/js/osbutility.js"/>"></script>
  </head>

  <body>
