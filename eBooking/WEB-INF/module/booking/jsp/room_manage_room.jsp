<%--
  User: rro
  Date: 20.06.2005
  Time: 23:00:29
  
  @author Roman R&auml;dle
  @version $Id: room_manage_room.jsp,v 1.1 2005/10/16 18:27:24 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ include file="../../base/jsp/include/manage_header.jsp" %>

    <form method="post" name="<c:out value="${formName}"/>">

      <table class="form">

<!-- BEGIN FIRST ROW -->

        <tr>

<!-- BEGIN FIRST ROW AND FIRST COLUMN -->

          <td><fmt:message key="key"/></td>
          <td>
          <spring:bind path="room.key">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END FIRST ROW AND FIRST COLUMN -->

        </tr>

<!-- END FIRST ROW -->

<!-- BEGIN SECOND ROW -->

        <tr>

<!-- BEGIN SECOND ROW AND FIRST COLUMN -->

          <td><fmt:message key="bed.amount"/></td>
          <td>
          <spring:bind path="room.bedAmount">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END SECOND ROW AND FIRST COLUMN -->

        </tr>

<!-- END SECOND ROW -->

      </table>
      <br/>
      <span style="background-color: #EFEFEF; border: 1px dotted #9F9F9F; padding: 2px 4px 2px 4px; margin: 0px 0px 0px 0px; width: 100%; display: block;">
      <input class="form_button" type="reset" value="<fmt:message key="reset"/>">&nbsp;
      <input class="form_button" type="submit" value="<fmt:message key="save"/>">
      <br/>
      <br/>
      <input class="form_button" type="button" name="back" value="<fmt:message key="back"/>" onClick="history.back()">
      </span>

    </form>

<%@ include file="../../base/jsp/include/manage_footer.jsp" %>