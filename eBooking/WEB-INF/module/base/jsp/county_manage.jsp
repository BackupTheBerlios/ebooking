<%--
  User: rro
  Date: 15.05.2005
  Time: 14:38:24
  
  @author Roman R&auml;dle
  @version $Id: county_manage.jsp,v 1.1 2005/10/16 18:27:21 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ include file="include/manage_header.jsp" %>

    <form name="countyForm" method="post">

      <table class="form">

<!-- BEGIN FIRST ROW -->

        <tr>

<!-- BEGIN FIRST ROW AND FIRST COLUMN -->

          <td><fmt:message key="key"/></td>
          <td>
          <spring:bind path="county.key">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END FIRST ROW AND FIRST COLUMN -->

        </tr>

<!-- END FIRST ROW -->

<!-- BEGIN SECOND ROW -->

        <tr>

<!-- BEGIN SECOND ROW AND FIRST COLUMN -->

          <td><fmt:message key="name"/></td>
          <td>
          <spring:bind path="county.name">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END SECOND ROW AND FIRST COLUMN -->

        </tr>

<!-- END SECOND ROW -->

<!-- BEGIN THIRD ROW -->

        <tr>

<!-- BEGIN THIRD ROW AND FIRST COLUMN -->

          <td><fmt:message key="country"/></td>
          <td>
          <spring:bind path="county.countryId">
            <select class="form_select" name="<c:out value="${status.expression}"/>">
              <c:forEach var="definedCountry" items="${allCountries}">
              <option value="<c:out value="${definedCountry.id}"/>"<c:if test="${definedCountry.id == status.value}"> selected</c:if>><c:out value="${definedCountry.name}"/> (<c:out value="${definedCountry.systemLocale.language}"/>)</option>
              </c:forEach>
            </select>
          </spring:bind>
          </td>

<!-- END THIRD ROW AND FIRST COLUMN -->

        </tr>

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

<%@ include file="include/manage_footer.jsp" %>