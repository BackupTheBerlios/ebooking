<%--
  User: rro
  Date: 14.05.2005
  Time: 18:48:35

  @author Roman R&auml;dle
  @version $Id: academic_title_list.jsp,v 1.1 2005/10/16 18:27:20 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>

<%@ include file="include/list_header.jsp" %>

    <form method="post">
      <display:table class="data_table"
                     name="${academicTitleDtoList}"
                     uid="academicTitleDto"
                     export="true"
                     sort="list"
                     pagesize="${pagesize}"
                     requestURI="list_title.jspa">
        <display:caption>
          <tr class="data_table_filter_input">
            <td class="data_table_icon" colspan="2">
              <input type="image" src="../images/search.png"/>
            </td>
            <td class="list"><input type="text" name="id" value="<c:out value="${id}"/>" /></td>
            <td class="list"><input type="text" name="key" value="<c:out value="${key}"/>" /></td>
            <td class="list"><input type="text" name="name" value="<c:out value="${name}"/>" /></td>
            <td class="list"><input type="text" name="systemLocaleLanguage" value="<c:out value="${systemLocaleLanguage}"/>" /></td>
            <td class="list"><input type="text" name="systemLocaleKey" value="<c:out value="${systemLocaleKey}"/>" /></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_light" colspan="7"></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_dark" colspan="7"></td>
          </tr>
        </display:caption>
        <display:column class="data_table_icon">
          <a href="edit_academic_title.jspa?id=<c:out value="${academicTitleDto.persistentId}"/>">
            <img src="../images/edit.png" alt="<fmt:message key="edit.country"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="delete_academic_title.jspa?id=<c:out value="${academicTitleDto.persistentId}"/>" onclick="return confirm('Wollen Sie das Land <c:out value="${countryDto.name}"/> <c:out value="${countryDto.key}"/> wirklich l&ouml;schen?');">
            <img src="../images/cancel.gif" alt="<fmt:message key="delete.title"/>"/>
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
            <a href="list_academic_title.jspa?pagesize=<c:out value="${pagesize}"/>">Selektion aufheben</a>
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