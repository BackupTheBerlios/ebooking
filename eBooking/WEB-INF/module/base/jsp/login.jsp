<%--
  User: rro
  Date: 12.04.2005
  Time: 11:41:39

  @author Roman R&auml;dle
  @version $Id: login.jsp,v 1.1 2005/10/16 18:27:22 raedler Exp $
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
    <title>The login page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/style/display_form.css"/>">
    <style type="text/css">

      body
      {
        background-color: #ffffff;
      }

      div.login_box
      {
        text-align: center;
        margin-top: 25%;
      }

      table.login_form {
        font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
        font-size: 11px;
        background-color: #FFEFAF;
        border: 1px solid #9F9F9F;
        spacing: 0px 0px 0px 0px;
        padding: 10px 10px 10px 10px;
      }
      td.login_form_text {
        height: 20px;
        border: 0px;
        font-weight: bold;
      }
      td.login_form_input {
        text-align: right;
      }

      td.login_form_login {
        text-align: left;
      }
      td.login_form_login_forgotten {
        text-align: right;
      }

      td.login_descr {
        border: 0px;
        font-weight: bold;
        text-align: center;
        height: 40px;
      }

    </style>
  </head>
  <body>
    <form method="post">

      <div class="login_box">

        <table class="login_form" align="center">
          <tr>
            <td colspan="2" class="login_descr">
              <fmt:message key="login.descr"/>
            </td>
          </tr>
          <tr>
            <td class="login_form_text">
              <fmt:message key="username"/>
            </td>
            <td class="login_form_input">
              <spring:bind path="login.loginId">
                <input type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>"/>
              </spring:bind>
            </td>
          </tr>
          <tr>
            <td class="login_form_text">
              <fmt:message key="password"/>
            </td>
            <td class="login_form_input">
              <spring:bind path="login.password">
                <input type="password" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>"/>
              </spring:bind>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="login_form_text">
              <spring:bind path="login.error">
                <c:out value="${status.errorMessage}"/>
              </spring:bind>
            </td>
          </tr>
          <tr>
            <td class="login_form_login">
              <input class="form_button" type="submit" value="<fmt:message key="login"/>"/>
            </td>
            <td class="login_form_login_forgotten">
              <input class="form_button" type="button" onclick="self.location.href='/ebooking/base/login_forgotten.jspa'" value="<fmt:message key="password.forgotten"/>"/>
            </td>
          </tr>
        </table>

      </div>

    </form>
  </body>
</html>