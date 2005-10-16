<%--
  User: rro
  Date: 14.05.2005
  Time: 18:48:35

  @author Roman R&auml;dle
  @version $Id: booking_list.jsp,v 1.1 2005/10/16 18:27:24 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ include file="include/list_header.jsp" %>

    <form method="post">
      <display:table class="data_table"
                     name="${bookingDtoList}"
                     uid="bookingDto"
                     export="true"
                     sort="list"
                     pagesize="${pagesize}"
                     requestURI="list_booking.jspa">
        <display:caption>
          <tr class="data_table_filter_input">
            <td class="data_table_icon" colspan="3">
              <input type="image" src="../images/search.png"/>
            </td>
            <td class="list"><input type="text" name="id" value="<c:out value="${id}"/>" /></td>
            <td class="list"><input type="text" name="firstname" value="<c:out value="${firstname}"/>" /></td>
            <td class="list"><input type="text" name="lastname" value="<c:out value="${lastname}"/>" /></td>
            <td class="list"></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_light" colspan="6"></td>
          </tr>
          <tr>
            <td class="data_table_filter_empty_row_dark" colspan="6"></td>
          </tr>
        </display:caption>
        <display:column class="data_table_icon">
          <a href="edit_booking.jspa?id=<c:out value="${bookingDto.persistentId}"/>">
            <img src="../images/edit.png" alt="<fmt:message key="edit.booking"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="list_booking_item.jspa?bookingId=<c:out value="${bookingDto.persistentId}"/>">
            <img src="../images/list.png" alt="<fmt:message key="list.booking.items"/>"/>
          </a>
        </display:column>
        <display:column class="data_table_icon">
          <a href="delete_booking.jspa?id=<c:out value="${bookingDto.persistentId}"/>" onclick="return confirm('Wollen Sie die Buchung <c:out value="${bookingDto.firstname}"/> <c:out value="${bookingDto.lastname}"/> wirklich l&ouml;schen?');">
            <img src="../images/cancel.gif" alt="<fmt:message key="delete.booking"/>"/>
          </a>
        </display:column>
        <display:column property="persistentId"
                        titleKey="id"
                        sortable="true"/>
        <display:column property="firstname"
                        titleKey="firstname"
                        sortable="true"/>
        <display:column property="lastname"
                        titleKey="lastname"
                        sortable="true"/>
        <display:column titleKey="booking.time"
                        sortable="true">
          <c:forEach items="${bookingDto.bookingItems}" var="bookingItem">
            <c:out value="${bookingItem.fromDate}"/> - <c:out value="${bookingItem.toDate}"/>
          </c:forEach>
          <br/>
        </display:column>
      </display:table>
      <table class="data_table_extensible_menu">
        <tr>
          <td>
            <a href="list_booking.jspa?pagesize=<c:out value="${pagesize}"/>">Selektion aufheben</a>
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