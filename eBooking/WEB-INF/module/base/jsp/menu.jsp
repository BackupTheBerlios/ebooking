<%--
  User: rro
  Date: 12.04.2005
  Time: 11:41:39

  @author Roman R&auml;dle
  @version $Id: menu.jsp,v 1.1 2005/10/16 18:27:22 raedler Exp $
  @since DAPS INTRA 1.0
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>

<%@ taglib uri="/c" prefix="c" %>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/style/menu.css"/>">
    <script language="JavaScript" src="<c:url value="/js/functions.js"/>"></script>
    <script language="JavaScript" src="<c:url value="/js/menu-classes.js"/>"></script>

    <link rel="stylesheet" href="<c:url value="/style/template_css.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/style/theme.css"/>" type="text/css" />
    <script language="JavaScript" src="<c:url value="/js/JSCookMenu.js"/>" type="text/javascript"></script>
    <script language="JavaScript" src="<c:url value="/js/theme.js"/>" type="text/javascript"></script>
    <script language="JavaScript" src="<c:url value="/js/wz_tooltip.js"/>" type="text/javascript"></script>

  </head>

  <body onload="createMenus();">

    <table width="100%" class="menubar" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td class="menubackgr">
          <div id="myMenuID"></div>

      		<script language="JavaScript" type="text/javascript">
<c:out value="${menu}" escapeXml="false"/>
          </script>

        </td>
      </tr>
    </table>

    <div style="position: absolute; bottom: 5px;"/>
      <table border="0" width="100%">
        <tr valign="middle">
          <td>
            <table cellpadding="4" cellspacing="0" width="100%" border="0">
              <tr valign="center">
                <td align="right" width="*">
                  <a href="http://localhost:8081/ebooking/base/login.jspa" target="_top"><img src="/ebooking/images/symb_home.gif" border="0" align="middle" title="Startseite" alt="Startseite"/></a>
                  <a href="http://localhost:8081/ebooking/base/logout.jspa" target="_top"><img src="/ebooking/images/symb_exit.gif" border="0" align="middle" title="Abmelden" alt="Abmelden"/></a>
                </td>
                <!--
                <td align="right" valign="bottom" width="32">
                  <img src="/eprocurement/images/logo_en.gif" />
                </td>
                -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <table>
        <tr valign="middle" width="100%">
          <td colspan="5">
            <table width="100%" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td>
                  <script language="JavaScript">
function createMenus() {
  var menu0_0=new menu(null,"menu0_0");
  var menu0_0_0=new linkItem("Hinzuf&uuml;gen","<c:url value="/base/add_customer.jspa"/>",menu0_0);
  var menu0_0_1=new linkItem("Alle Kunden","<c:url value="/base/list_customer.jspa"/>",menu0_0);

  var menu1_0=new menu(null,"menu1_0");
  var menu1_0_0=new linkItem("Hinzuf&uuml;gen","<c:url value="/booking/add_booking.jspa"/>",menu1_0);
  var menu1_0_1=new linkItem("Alle Buchungen","<c:url value="/booking/list_booking.jspa"/>",menu1_0);

  var menu2_0=new menu(null,"menu2_0");
  var menu2_0_0=new linkItem("Hinzuf&uuml;gen","<c:url value="/base/add_bill.jspa"/>",menu2_0);
  var menu2_0_1=new linkItem("Alle Rechnungen","<c:url value="/base/list_bill.jspa"/>",menu2_0);

  var menu3_0=new menu(null,"menu3_0");
  var menu3_0_0=new popupItem("System Locale","menu3_0_0",menu3_0);
  var menu3_0_0_0=new linkItem("Hinzuf&uuml;gen","<c:url value="/base/add_system_locale.jspa"/>",menu3_0_0);
  var menu3_0_0_1=new linkItem("Alle System Locale","<c:url value="/base/list_system_locale.jspa"/>",menu3_0_0);
  var menu3_0_1=new popupItem("Anreden","menu3_0_1",menu3_0);
  var menu3_0_1_0=new linkItem("Hinzuf&uuml;gen","<c:url value="/base/add_title.jspa"/>",menu3_0_1);
  var menu3_0_1_1=new linkItem("Alle Anreden","<c:url value="/base/list_title.jspa"/>",menu3_0_1);
  var menu3_0_2=new popupItem("Titel","menu3_0_2",menu3_0);
  var menu3_0_2_0=new linkItem("Hinzuf&uuml;gen","<c:url value="/base/add_academic_title.jspa"/>",menu3_0_2);
  var menu3_0_2_1=new linkItem("Alle Titel","<c:url value="/base/list_academic_title.jspa"/>",menu3_0_2);
  var menu3_0_3=new popupItem("L&auml;nder","menu3_0_3",menu3_0);
  var menu3_0_3_0=new linkItem("Hinzuf&uuml;gen","<c:url value="/base/add_country.jspa"/>",menu3_0_3);
  var menu3_0_3_1=new linkItem("Alle L&auml;nder","<c:url value="/base/list_country.jspa"/>",menu3_0_3);
  var menu3_0_4=new popupItem("Bundesl&auml;nder","menu3_0_4",menu3_0);
  var menu3_0_4_0=new linkItem("Hinzuf&uuml;gen","<c:url value="/base/add_county.jspa"/>",menu3_0_4);
  var menu3_0_4_1=new linkItem("Alle Bundesl&auml;nder","<c:url value="/base/list_county.jspa"/>",menu3_0_4);
  var menu3_0_5=new popupItem("Zimmer","menu3_0_5",menu3_0);
  var menu3_0_5_0=new linkItem("Hinzuf&uuml;gen","<c:url value="/booking/add_room.jspa"/>",menu3_0_5);
  var menu3_0_5_1=new linkItem("Alle Zimmer","<c:url value="/booking/list_room.jspa"/>",menu3_0_5);

  menu0_0.addDivs();
  menu1_0.addDivs();
  menu2_0.addDivs();
  menu3_0.addDivs();

  addMenuListeners();
}
                  </script>
                  <nobr>
                    <span id="menu0_0" class="menu">Kunden</span>
                    <span id="menu1_0" class="menu">Buchungen</span>
                    <span id="menu2_0" class="menu">Rechnungen</span>
                    <span id="menu3_0" class="menu">System</span>
                  </nobr>
                </td>
                <td class="input" style="color:white;" align="right">
                  <span  onmouseover="this.T_TITLE='Benutzer';this.T_DELAY=1000;this.T_WIDTH=96;this.T_FONTCOLOR='#000000';this.T_BGCOLOR='#FFFFE1';this.T_WIDTH=100;this.T_PADDING=2;return escape('');" >Benutzer</span>: sys -  Systemadministrator &nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </div>

  </body>

  <script language="JavaScript" src="<c:url value="/js/tooltip.js"/>"></script>
  <!--
  <script language="JavaScript">
    if (!window.OSBUtility_script_loaded) {
      document.write("\<script" );
      document.write(' language="JavaScript"' );
      document.write(" src='../js/osbutility.js'");
      document.write("\>" );
      document.write("\</script\>" );
    }
    setTimeout('__applyFocusEventListeners();',220);
    setTimeout('__registerValidators();',220);
    setTimeout('__applyValidationEventListeners();',220);
  </script>
  -->
</html>