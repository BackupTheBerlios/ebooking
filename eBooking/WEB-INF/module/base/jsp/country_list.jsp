<%--
  User: rro
  Date: 14.05.2005
  Time: 18:48:35

  @author Roman R&auml;dle
  @version $Id: country_list.jsp,v 1.1 2005/10/16 18:27:20 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>

<%@ include file="include/list_header.jsp" %>

    <form method="post">
      <display:table class="data_table"
                     name="${countryDtoList}"
                     uid="countryDto"
                     export="true"
                     sort="list"
                     pagesize="${pagesize}"
                     requestURI="list_country.jspa">
        <display:caption>
          <tr class="data_table_filter_input">
            <td class="data_table_icon" colspan="4">
              <input type="image" src="../images/search.png"/>
            </td>
            <td class="list"><input type="text" name="id" value="<c:out value="${id}"/>" /></td>
            <td class="list"><input type="text" name="key" value="<c:out value="${key}"/>" /></td>
            <td class="list"><input type="text" name="name" value="<c:out value="${name}"/>" /></td>
            <td class="list"><input type="text" name="systemLocaleLanguage" value="<c:out value="${systemLocaleLanguage}"/>" /></td>
            <td class="list"><input type="text" name="systemLocaleKey" value="<c:out value="${systemLocaleKey}"/>" /></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_light" colspan="9"></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_dark" colspan="9"></td>
          </tr>
        </display:caption>
        <display:column class="data_table_icon">
          <a href="edit_country.jspa?id=<c:out value="${countryDto.persistentId}"/>">
            <img src="../images/edit.png" alt="<fmt:message key="edit.country"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="list_county.jspa?countryId=<c:out value="${countryDto.persistentId}"/>">
            <img src="../images/list.png" alt="<fmt:message key="list.counties"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="<c:out value="${redirectPage}"/>?id=<c:out value="${countryDto.persistentId}"/>">
            <img src="../images/new.png" alt="<fmt:message key="edit.country"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="delete_country.jspa?id=<c:out value="${countryDto.persistentId}"/>" onclick="return confirm('Wollen Sie das Land <c:out value="${countryDto.name}"/> <c:out value="${countryDto.key}"/> wirklich l&ouml;schen?');">
            <img src="../images/cancel.gif" alt="<fmt:message key="country.delete"/>"/>
          </a>
        </display:column>
        <display:column property="persistentId"
                        titleKey="id"
                        sortable="true"/>
        <display:column property="key"
                        titleKey="key"
                        sortable="true"/>
        <display:column property="name"
                        titleKey="name"
                        sortable="true"/>
        <display:column property="systemLocaleLanguage"
                        titleKey="system.locale.language"
                        sortable="true"/>
        <display:column property="systemLocaleKey"
                        titleKey="system.locale.key"
                        sortable="true"/>
      </display:table>
      <table class="data_table_extensible_menu">
        <tr>
          <td>
            <a href="list_country.jspa?pagesize=<c:out value="${pagesize}"/>">Selektion aufheben</a>
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