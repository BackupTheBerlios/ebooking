<%--
  User: rro
  Date: 12.04.2005
  Time: 11:41:39

  @author Roman R&auml;dle
  @version $Id: customer_manage.jsp,v 1.1 2005/10/16 18:27:22 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ include file="include/manage_header.jsp" %>

    <form name="customerForm" method="post" onreset="refreshCountySelect(document.customerForm, '<c:out value="${customer.countryKey}"/>', <c:choose><c:when test="${customer.countryKey == null}">'empty'</c:when><c:otherwise>'<c:out value="${customer.countyKey}"/>'</c:otherwise></c:choose>, false, true);">

      <table class="form">

<!-- BEGIN FIRST ROW -->

        <tr>

<!-- BEGIN FIRST ROW AND FIRST COLUMN -->

          <td><fmt:message key="title_academic.title"/></td>
          <td>
          <spring:bind path="customer.titleKey">
            <select class="form_select" style="width: 98px;" name="<c:out value="${status.expression}"/>">
              <option value="empty" <c:if test="${customer.titleKey == 'empty'}">selected</c:if>></option>
              <c:forEach var="definedTitle" items="${allTitles}">
              <option value="<c:out value="${definedTitle.key}"/>"<c:if test="${definedTitle.key == status.value}"> selected</c:if>><c:out value="${definedTitle.name}"/></option>
              </c:forEach>
            </select>
          </spring:bind>

          <spring:bind path="customer.academicTitleKey">
            <select class="form_select" style="width: 98px;" name="<c:out value="${status.expression}"/>">
              <option value="empty" <c:if test="${customer.academicTitleKey == 'empty'}">selected</c:if>></option>
              <c:forEach var="definedAcademicTitle" items="${allAcademicTitles}">
              <option value="<c:out value="${definedAcademicTitle.key}"/>"<c:if test="${definedAcademicTitle.key == status.value}"> selected</c:if>><c:out value="${definedAcademicTitle.name}"/></option>
              </c:forEach>
            </select>
          </spring:bind>
          </td>

<!-- END FIRST ROW AND FIRST COLUMN -->

          <td style="width: 40px;"></td>

<!-- BEGIN FIRST ROW AND SECOND COLUMN -->

          <td><fmt:message key="postal.name"/></td>
          <td>
          <spring:bind path="customer.postalName">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END SECOND ROW AND FIRST COLUMN -->

        </tr>

<!-- END FIRST ROW -->

<!-- BEGIN SECOND ROW -->

        <tr>

<!-- BEGIN SECOND ROW AND FIRST COLUMN -->

          <td><fmt:message key="lastname"/></td>
          <td>
          <spring:bind path="customer.lastname">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END SECOND ROW AND FIRST COLUMN -->

          <td></td>

<!-- BEGIN SECOND ROW AND SECOND COLUMN -->

          <td><fmt:message key="department"/></td>
          <td>
          <spring:bind path="customer.department">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END SECOND ROW AND SECOND COLUMN -->

        </tr>

<!-- END SECOND ROW -->

<!-- BEGIN THIRD ROW -->

        <tr>

<!-- BEGIN THIRD ROW AND FIRST COLUMN -->

          <td><fmt:message key="firstname"/></td>
          <td>
          <spring:bind path="customer.firstname">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>"/>
          </spring:bind>
          </td>

<!-- END THIRD ROW AND FIRST COLUMN -->

          <td></td>

<!-- BEGIN THIRD ROW AND SECOND COLUMN -->

          <td></td>
          <td></td>

<!-- END THIRD ROW AND SECOND COLUMN -->

        </tr>

<!-- END THIRD ROW -->

<!-- BEGIN FOURTH ROW -->

        <tr>

<!-- BEGIN FOURTH ROW AND FIRST COLUMN -->

          <td><fmt:message key="street"/></td>
          <td>
          <spring:bind path="customer.street">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END FOURTH ROW AND FIRST COLUMN -->

          <td></td>

<!-- BEGIN FOURTH ROW AND SECOND COLUMN -->

          <td><fmt:message key="phone1"/></td>
          <td>
          <spring:bind path="customer.phone1">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END 'FOURTH ROW AND SECOND COLUMN -->

        </tr>

<!-- END FOURTH ROW -->

<!-- BEGIN FIFTH ROW -->

        <tr>

<!-- BEGIN FIFTH ROW AND FIRST COLUMN -->

          <td><fmt:message key="zip.code_city"/></td>
          <td>
          <spring:bind path="customer.zipCode">
            <input class="form_input" style="width: 50px;" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>

          <spring:bind path="customer.city">
            <input class="form_input" type="text" style="width: 146px;" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END FIFTH ROW AND FIRST COLUMN -->

          <td></td>

<!-- BEGIN FIFTH ROW AND SECOND COLUMN -->

          <td><fmt:message key="phone2"/></td>
          <td>
          <spring:bind path="customer.phone2">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END FIFTH ROW AND SECOND COLUMN -->

        </tr>

<!-- END FIFTH ROW -->

<!-- BEGIN SIXTH ROW -->

        <tr>

<!-- BEGIN SIXTH ROW AND FIRST COLUMN -->

            <td></td>
            <td></td>

<!-- END SIXTH ROW AND FIRST COLUMN -->

            <td></td>

<!-- BEGIN SIXTH ROW AND SECOND COLUMN -->

            <td><fmt:message key="telefax"/></td>
            <td>
            <spring:bind path="customer.telefax">
              <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
            </spring:bind>
            </td>

<!-- END SIXTH ROW AND SECOND COLUMN -->

        </tr>

<!-- END SIXTH ROW -->

<!-- BEGIN SEVENTH ROW -->

        <tr>

<!-- BEGIN SEVENTH ROW AND FIRST COLUMN -->

          <td><fmt:message key="country"/></td>
          <td>
          <spring:bind path="customer.countryKey">
            <select class="form_select" name="<c:out value="${status.expression}"/>" onchange="refreshCountySelect(document.customerForm, document.customerForm.countryKey.options[document.customerForm.countryKey.selectedIndex].value, <c:choose><c:when test="${customer.countryKey == null}">'empty'</c:when><c:otherwise>'<c:out value="${customer.countyKey}"/>'</c:otherwise></c:choose>, false, true);">
              <option value="empty" <c:if test="${customer.countryKey == 'empty'}">selected</c:if>></option>
              <c:forEach var="definedCountry" items="${allCountries}">
              <option value="<c:out value="${definedCountry.key}"/>"<c:if test="${definedCountry.key == status.value}"> selected</c:if>><c:out value="${definedCountry.name}"/></option>
              </c:forEach>
            </select>
          </spring:bind>
          </td>

<!-- END SEVENTH ROW AND FIRST COLUMN -->

          <td></td>

<!-- BEGIN SEVENTH ROW AND SECOND COLUMN -->

          <td><fmt:message key="www"/></td>
          <td>
          <spring:bind path="customer.www">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END SEVENTH ROW AND SECOND COLUMN -->

        </tr>

<!-- END SEVENTH ROW -->

<!-- BEGIN EIGHTH ROW -->

        <tr>

<!-- BEGIN EIGHTH ROW AND FIRST COLUMN -->

          <td><fmt:message key="county"/></td>
          <td>

          <spring:bind path="customer.countyKey">
            <select class="form_select" name="<c:out value="${status.expression}"/>">
              <!-- FILLED BY refreshCountySelect(form, countryKey, selected) -->
            </select>
          </spring:bind>

<!-- BEGIN ATTENTION: MUST STAY AT THIS PLACE, BECAUSE FORM NAME, COUNTRY SELECT AND COUNTY SELECT DOESN'T EXIST BEFORE -->
          <script type="text/javascript">
            <c:out value="${htmlJS}" escapeXml="false"/>
          </script>
<!-- END ATTENTION -->

          </td>

<!-- END EIGHTH ROW AND FIRST COLUMN -->

          <td></td>

<!-- BEGIN EIGHTH ROW AND SECOND COLUMN -->

          <td><fmt:message key="mobile.phone"/></td>
          <td>
          <spring:bind path="customer.mobilePhone">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END EIGHTH ROW AND SECOND COLUMN -->

        </tr>

<!-- END EIGHTH ROW -->

<!-- BEGIN NINETH ROW -->

        <tr>

<!-- BEGIN NINETH ROW AND FIRST COLUMN -->

          <td></td>
          <td></td>

<!-- END NINETH ROW AND FIRST COLUMN -->

          <td></td>

<!-- BEGIN NINETH ROW AND SECOND COLUMN -->

          <td><fmt:message key="email"/></td>
          <td>
          <spring:bind path="customer.email">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END NINETH ROW AND SECOND COLUMN -->

        </tr>

<!-- END NINETH ROW -->

<!-- BEGIN TENTH ROW -->

        <tr>

<!-- BEGIN TENTH ROW AND FIRST COLUMN -->

          <td><fmt:message key="identification.number"/></td>
          <td>
          <spring:bind path="customer.identificationNumber">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END TENTH ROW AND FIRST COLUMN -->

            <td></td>

<!-- BEGIN TENTH ROW AND SECOND COLUMN -->

            <td></td>
            <td></td>

<!-- END TENTH ROW AND SECOND COLUMN -->

        </tr>

<!-- END TENTH ROW -->

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