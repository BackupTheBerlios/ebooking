/**
 * @author Roman R&auml;dle
 * @version $Id: menu.js,v 1.1 2005/10/16 18:26:57 raedler Exp $
 * @since DAPS INTRA 1.0
 */

//Korrektur der Submenu-Position
intXPadding = -2;
intYPadding = 0;

//Zeit bis zum Schliessen(ms)
intTimeout = 100;

//hier werden später die Timeouts gespeichert... jeweils separat für jedes Submenu
arrTimeouts = new Array();

/**
  *  liefert beim Initialisieren des Menues zum jeweiligen Hauptmenupunkt
  *  die passende Tabbelle
  *  objMenu=Elternknoten der Hauptmenu-Tabelle
  *  intSub=Index des Menupunktes
  */
function get_sub(objMenu, intSub) {
    intTable = -1;

    for(j = 0; j < objMenu.childNodes.length; ++j) {
        intTable += (objMenu.childNodes[j].tagName=='TABLE') ? 1 : 0;

        if(intTable == intSub) {
            return(objMenu.childNodes[j]);
        }
        arrTimeouts.push(false);
    }
    return false;
}

/**
  *  Initialisiert das Menu beim ersten mouseover der Hauptmenupunkte-Tabelle
  *  ansonsten anzeigen/verstecken der jeweiligen Submenu-Tabelle
  *  objElem = (erster Aufruf)?Hauptmenupunktabelle:Index Menupunkt
  *  blnEvt = (!erster Aufruf)?(over=1||out=0):nix;
  */
function menu(objElem, blnEvt) {
    //initalisieren de Menues beim ersten Aufruf
    if(arrTimeouts.length == 0) {
        objElem.onmouseover = new Function('f','return false');
        objMenu = objElem.parentNode;
        blnType = (objElem.rows.length > 1) ? 1 : 0;
        intItems=(blnType)? objElem.rows.length: objElem.rows[0].cells.length

        for(i = 0; i < intItems; ++i) {
            objCell = (blnType)? objElem.rows[i].cells[0] : objElem.rows[0].cells[i];
            objCell.onmouseover = new Function('f', 'menu('+i+', 1)');
            objCell.onmouseout  = new Function('f',' menu('+i+', 0)');
            objSub = get_sub(objMenu, i+1);
            objSub.style.position = 'absolute';

            objSub.style.left = (blnType)
                ? (objCell.offsetLeft + (objSub.rows[0].cells[0].offsetLeft) + objCell.offsetWidth) + intXPadding
                : (objCell.offsetLeft + (objSub.rows[0].cells[0].offsetLeft)) + intXPadding;

            objSub.style.top  = (blnType)
                ? objCell.offsetTop + (objElem.rows[0].cells[0].offsetTop) + intYPadding
                : objCell.offsetHeight + (objElem.rows[0].cells[0].offsetTop) + intYPadding;

            objSub.id = 'sub' + i;
            objSub.width = 1;  //fixt opera-Macke mit Tabellenbreite
            objSub.onclick = new Function('f', 'this.style.display = "none"');
            objSub.onmouseover = new Function('f', 'menu(' + i + ', 1)');
            objSub.onmouseout  = new Function('f', 'menu(' + i + ', 0)');
            objSub.className = 'sub';
         }
         return;
     }

     //Zeigen
     if(blnEvt) {
        clearTimeout(arrTimeouts[objElem]);
        document.getElementById('sub'+objElem).style.display = "";
     }
     //Verstecken
     else {
         arrTimeouts[objElem] = setTimeout('document.getElementById("sub'+objElem+'").style.display="none"', intTimeout);
     }
}