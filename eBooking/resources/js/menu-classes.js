/**
 * @author Roman R&auml;dle
 * @version $Id: menu-classes.js,v 1.1 2005/10/16 18:26:57 raedler Exp $
 * @since DAPS INTRA 1.0
 */

// Creates a new menu with a given name and id
function menu(text, id) {
    this.text = text;
    this.id = id;
    this.addDivs = addMenuDivs;
    this.getDivs = getPopupDivs;
}

function addMenuDivs() {
    var divs = this.getDivs();
    if (!divs) {
        return;
    }
    for (var i = 0; i < divs.length; i++) {
        document.body.appendChild(divs[i]);
    }
}


function popupItem(text, id, parent) {
    this.text = text;
    this.id = id;
    this.parent = parent;
    if (!parent.children) {
        parent.children = new Array();
    }
    parent.children[parent.children.length] = this;
    this.getDiv = getPopupItemElement;
    this.getDivs = getPopupDivs;
}

function linkItem(text, link, parent) {
    this.text = text;
    this.link = link;
    this.parent = parent;
    if (!parent.children) {
        parent.children = new Array();
    }
    parent.children[parent.children.length] = this;
    this.getDiv = getLinkItemElement;
}

function getPopupDivs() {
    if (!this.children) {
        return null;
    }
    var div = document.createElement("div");
    div.className = "hiddenPopupMenu";
    if (this.id) {
        div.setAttribute("id", this.id + "_popup0");
    }
    // This is a workaround for yet another IE bug. We have to
    // create a dummy menu item first, because IE does not report
    // the size of the first menu item correctly. That is why
    // we first insert a dummy menu item and after it the menu items
    // which were specified programatically
    var dummyHolder = document.createElement("div");
    dummyHolder.className = "menuItemHolder";
    var dummyItem = document.createElement("span");
    dummyItem.className = "menuItem";
    dummyItem.appendChild(document.createTextNode(""));
    dummyHolder.appendChild(dummyItem);
    div.appendChild(dummyHolder);
    for (var i = 0; i < this.children.length; i++) {
        var item = this.children[i];
        div.appendChild(item.getDiv());
    }
    var arr = new Array();
    arr[0] = div;
    for (var i = 0; i < this.children.length; i++) {
        var item = this.children[i];
        if (item.getDivs && item.children) {
            childDivs = item.getDivs();
            for (var j = 0; j < childDivs.length; j++) {
                arr[arr.length] = childDivs[j];
            }
        }
    }
    return arr;
}

function getLinkItemElement() {
    var div = document.createElement("div");
    div.className = "menuItemHolder";
    var textSpan = document.createElement("span");
    textSpan.className = "menuItem";
    textSpan.setAttribute("title", this.link);
//    textSpan.appendChild(document.createTextNode(this.text));
    textSpan.innerHTML = this.text;
    div.appendChild(textSpan);
    return div;
}

function getPopupItemElement() {
    var div = document.createElement("div");
    div.className = "menuItemHolder";
    var textSpan = document.createElement("span");
    textSpan.className = "menuItem";
    textSpan.id = this.id;
    textSpan.innerHTML = this.text + "&nbsp;&nbsp;&raquo;";
    div.appendChild(textSpan);
    return div;
}