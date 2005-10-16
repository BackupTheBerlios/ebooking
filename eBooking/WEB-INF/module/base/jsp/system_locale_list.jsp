<%--
  User: rro
  Date: 15.05.2005
  Time: 15:32:37
  
  @author Roman R&auml;dle
  @version $Id: system_locale_list.jsp,v 1.1 2005/10/16 18:27:23 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ include file="include/list_header.jsp" %>

    <form method="post">
      <display:table class="data_table"
                     name="${systemLocaleDtoList}"
                     uid="systemLocaleDto"
                     export="true"
                     sort="list"
                     pagesize="${pagesize}"
                     requestURI="list_system_locale.jspa">
        <display:caption>
          <tr class="data_table_filter_input">
            <td class="data_table_icon" colspan="4">
              <input type="image" src="../images/search.png"/>
            </td>
            <td class="list"><input type="text" name="key" value="<c:out value="${key}"/>" /></td>
            <td class="list"><input type="text" name="language" value="<c:out value="${name}"/>" /></td>
            <td class="list"><input type="text" name="country" value="<c:out value="${countryName}"/>" /></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_light" colspan="7"></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_dark" colspan="7"></td>
          </tr>
        </display:caption>
        <display:column class="data_table_icon">
          <a href="edit_system_locale.jspa?key=<c:out value="${systemLocaleDto.key}"/>">
            <img src="../images/edit.png" alt="<fmt:message key="edit.system.locale"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="list_country.jspa?systemLocaleKey=<c:out value="${systemLocaleDto.key}"/>">
            <img src="../images/list.png" alt="<fmt:message key="list.countries"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="<c:out value="${redirectPage}"/>?key=<c:out value="${systemLocaleDto.key}"/>">
            <img src="../images/new.png" alt="<fmt:message key="edit.system.locale"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="delete_system_locale.jspa?key=<c:out value="${systemLocaleDto.key}"/>" onclick="return confirm('Wollen Sie die System Locale <c:out value="${systemLocaleDto.key}"/> wirklich l&ouml;schen?');">
            <img src="../images/cancel.gif" alt="<fmt:message key="delete.system.locale"/>"/>
          </a>
        </display:column>
        <display:column property="key"
                        titleKey="key"
                        sortable="true"/>
        <display:column property="language"
                        titleKey="language"
                        sortable="true"/>
        <display:column property="countryName"
                        titleKey="country.name"
                        sortable="true"/>
      </display:table>
      <table class="data_table_extensible_menu">
        <tr>
          <td>
            <a href="list_system_locale.jspa?pagesize=<c:out value="${pagesize}"/>">Selektion aufheben</a>
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