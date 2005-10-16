<%--
  User: rro
  Date: 14.05.2005
  Time: 18:48:35

  @author Roman R&auml;dle
  @version $Id: customer_list.jsp,v 1.1 2005/10/16 18:27:21 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>

<%@ include file="include/list_header.jsp" %>

    <form method="post">
      <display:table class="data_table"
                     name="${customerDtoList}"
                     uid="customer"
                     export="true"
                     sort="list"
                     pagesize="${pagesize}"
                     requestURI="list_customer.jspa">
        <display:caption>
          <tr class="data_table_filter_input">
            <td class="data_table_icon" colspan="3">
              <input type="image" src="../images/search.png"/>
            </td>
            <td class="list"><input type="text" name="firstname" value="<c:out value="${firstname}"/>" /></td>
            <td class="list"><input type="text" name="lastname" value="<c:out value="${lastname}"/>" /></td>
            <td class="list"><input type="text" name="street" value="<c:out value="${street}"/>" /></td>
            <td class="list"><input type="text" name="zipCode" value="<c:out value="${zipCode}"/>" /></td>
            <td class="list"><input type="text" name="city" value="<c:out value="${city}"/>" /></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_light" colspan="8"></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_dark" colspan="8"></td>
          </tr>
        </display:caption>
        <display:column class="data_table_icon">
          <a href="edit_customer.jspa?id=<c:out value="${customer.persistentId}"/>">
            <img src="../images/edit.png" alt="<fmt:message key="edit.customer"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="<c:out value="${redirectPage}"/>?id=<c:out value="${customer.persistentId}"/>">
            <img src="../images/new.png" alt="<fmt:message key="edit.customer"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="delete_customer.jspa?id=<c:out value="${customer.persistentId}"/>" onclick="return confirm('Wollen Sie den Kunden <c:out value="${customer.lastname}"/> <c:out value="${customer.firstname}"/> wirklich l&ouml;schen?');">
            <img src="../images/cancel.gif" alt="<fmt:message key="delete.customer"/>"/>
          </a>
        </display:column>
        <display:column property="firstname"
                        titleKey="firstname"
                        sortable="true"/>
        <display:column property="lastname"
                        titleKey="lastname"
                        sortable="true"/>
        <display:column property="street"
                        titleKey="street"
                        sortable="true"/>
        <display:column property="zipCode"
                        titleKey="zip.code"
                        sortable="true"/>
        <display:column property="city"
                        titleKey="city"
                        sortable="true"/>
      </display:table>
      <table class="data_table_extensible_menu">
        <tr>
          <td>
            <a href="list_customer.jspa?pagesize=<c:out value="${pagesize}"/>">Selektion aufheben</a>
          </td>
          <td> | </td>
          <td>Kunden pro Seite:
            <select id="pagesize" class="data_table_extensible_menu" onchange="OSBUtility.submitForm(this, 'pagesize=' + pagesize.value);">
              <option value="10" <c:if test='${pagesize == "10"}'>selected</c:if>>10</option>
              <option value="25" <c:if test='${pagesize == "25"}'>selected</c:if>>25</option>
              <option value="50" <c:if test='${pagesize == "50"}'>selected</c:if>>50</option>
              <option value="100" <c:if test='${pagesize == "100"}'>selected</c:if>>100</option>
            </select>
          </td>
        </tr>
      </table>
    </form>

<%@ include file="include/list_footer.jsp" %>