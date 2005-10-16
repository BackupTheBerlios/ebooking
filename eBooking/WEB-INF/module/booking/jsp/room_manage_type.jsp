<%--
  User: rro
  Date: 20.06.2005
  Time: 23:00:46
  
  @author Roman R&auml;dle
  @version $Id: room_manage_type.jsp,v 1.1 2005/10/16 18:27:24 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ include file="../../base/jsp/include/manage_header.jsp" %>

    <form method="post" name="<c:out value="${formName}"/>">

      <table class="form">

<!-- BEGIN FIRST ROW -->

        <tr style="height: 20px">

<!-- BEGIN FIRST ROW AND FIRST COLUMN -->

          <td><fmt:message key="description"/></td>
          <td>
            <spring:bind path="room.description">
              <input type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>"/>   
            </spring:bind>
          </td>

<!-- END FIRST ROW AND FIRST COLUMN -->

          <td style="width: 40px;"></td>

<!-- BEGIN FIRST ROW AND SECOND COLUMN -->

          <td width="100%" rowspan="3">
            <display:table class="data_table"
                           name="${room.descriptions}"
                           uid="roomDescr"
                           export="false"
                           sort="list"
                           pagesize="${pagesize}"
                           requestURI="add_room.jspa">
              <display:caption>
                <tr class="data_table_filter_input">
                  <td class="data_table_icon" colspan="2">
                    <input type="image" src="../images/search.png"/>
                  </td>
                  <td class="list"><input type="text" name="key" value="<c:out value="${key}"/>" /></td>
                  <td class="list"><input type="text" name="description" value="<c:out value="${name}"/>" /></td>
                  <td class="list"><input type="text" name="systemLocaleLanguage" value="<c:out value="${systemLocaleKey}"/>" /></td>
                </tr>
                <tr>
                  <td class="data_table_filter_empty_row_light" colspan="6"></td>
                </tr>
                <tr>
                  <td class="data_table_filter_empty_row_dark" colspan="6"></td>
                </tr>
              </display:caption>
              <display:column class="data_table_icon">
                <a href="add_room.jspa?action=edit&id=<c:out value="${roomDescr.persistentId}"/>">
                  <img src="../images/edit.png" alt="<fmt:message key="edit.room_description"/>"/>
                </a>
              </display:column>
              <display:column class="data_table_icon">
                <a href="add_room.jspa?action=delete&id=<c:out value="${roomDescr.persistentId}"/>" onclick="return confirm('Wollen Sie das Bundesland <c:out value="${county.key}"/> <c:out value="${county.name}"/> wirklich l&ouml;schen?');">
                  <img src="../images/cancel.gif" alt="<fmt:message key="delete.room_description"/>"/>
                </a>
              </display:column>
              <display:column property="key"
                              titleKey="key"
                              sortable="true"/>
              <display:column property="description"
                              titleKey="description"
                              sortable="true"/>
              <display:column property="systemLocaleKey"
                              titleKey="system.locale.language"
                              sortable="true"/>
            </display:table>
            <table class="data_table_extensible_menu">
              <tr>
                <td>
                  <a href="list_room.jspa?pagesize=<c:out value="${pagesize}"/>">Selektion aufheben</a>
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
          </td>

<!-- END FIRST ROW AND SECOND COLUMN -->

        </tr>

<!-- END FIRST ROW -->

<!-- BEGIN SECOND ROW -->

        <tr style="height: 20px">

<!-- BEGIN SECOND ROW AND FIRST COLUMN -->

          <td><fmt:message key="language"/></td>
          <td>
          <spring:bind path="room.systemLocaleKey">
            <input class="form_input" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>">
          </spring:bind>
          </td>

<!-- END SECOND ROW AND FIRST COLUMN -->

          <td></td>

<!-- BEGIN SECOND ROW AND SECOND COLUMN -->

          <td></td>

<!-- END SECOND ROW AND SECOND COLUMN -->

        </tr>

<!-- END SECOND ROW -->

<!-- BEGIN DUMMY ROW - FOR THE DESCRIPTION TABLE -->

        <tr>
          <td></td>
          <td></td>
          <td></td>
        </tr>

<!-- BEGIN DUMMY ROW - FOR THE DESCRIPTION TABLE -->

        <tr>
          <td>
            <input class="form_button" type="submit" value="<fmt:message key="save"/>"/>
          </td>
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

<%@ include file="../../base/jsp/include/manage_footer.jsp" %>