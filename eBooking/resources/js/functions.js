/**
 * @author Roman R&auml;dle
 * @version $Id: functions.js,v 1.1 2005/10/16 18:26:55 raedler Exp $
 * @since DAPS INTRA 1.0
 */

var activeComponent;

var activeMenu;

var activeClosingTimer;

var menuTimeout = 1000;

var isOpera = navigator.userAgent.toLowerCase().indexOf("opera") != -1;

var isIE = !isOpera && navigator.appName == "Microsoft Internet Explorer";

var popupOffsetLeft = 0;

var popupOffsetTop = -5;

var hiddenComponents = new Array();

function getComponentX(comp) {
    var offset = 0;
    while (comp) {
        offset += comp.offsetLeft;
        comp = comp.offsetParent;
    }
    return offset;
}

function getComponentY(comp) {
    var offset = 0;
    while (comp) {
        offset += comp.offsetTop;
        comp = comp.offsetParent;
    }
    return offset;
}

function closeAllSecondLevelPopups(menu) {
    var popup = top.main.document.getElementById(menu.id + "_popup0");
    if (popup) {
        var children = getPopupMenuItems(popup);
        if (children) {
            for (var i = 0; i < children.length; i++) {
                var child = children[i];
                if (child.id) {
                    closeRecursively(child.id, false);
                }
            }
        }
    }
}

function getComponentWidth(comp) {
    return comp.offsetWidth;
}

function ensurePopupAdded(menu) {
    var id = menu.id + "_popup0";
    var menuPopup = top.main.document.getElementById(id);
    if (menuPopup) {
        return menuPopup;
    }
    var topPopup = top.menu.document.getElementById(id);
    if (!menuPopup && topPopup) {
        ensureStyleRulesAdded();
        var copy;
        copy = top.main.document.createElement("div");
        copy.innerHTML = topPopup.innerHTML;
        copy.id = topPopup.id;
        copy.className = "hiddenPopupMenu";
        addListenersRecursively(copy, top.menu.mouseOver, top.menu.mouseOut, top.menu.mouseClick);
        top.main.document.body.appendChild(copy);
        menuPopup = copy;
    }
    return menuPopup;
}

function ensureStyleRulesAdded() {
    var head = getHead(top.main.document);
    if (head) {
        var dynStyleMeta = ensureDynamicStyleMetaAdded(head);
        if (dynStyleMeta.content == "true") {
            return;
        }
        var link = top.main.document.createElement("link");
        link.setAttribute("rel", "StyleSheet");
        link.setAttribute("href", "../css/style.css");
        link.setAttribute("type", "text/css");
        head.appendChild(link);
        dynStyleMeta.content = "true";
    } else {
        // TODO - maybe dynamically create a head element
    }
}

function ensureDynamicStyleMetaAdded(head) {
    var childNodes = head.childNodes;
    for (var i = 0; i < childNodes.length; i++) {
        var m = childNodes[i];
        if (m.tagName && m.tagName.toLowerCase() == "meta") {
            if (m.name == "dynamicStyle") {
                return m;
            }
        }
    }
    m = top.main.document.createElement("meta");
    m.name = "dynamicStyle";
    head.appendChild(m);
    return m;
}


function getHead(doc) {
    var head = doc.getElementsByTagName("head");
    if (head) {
        head = head[0];
    }
    return head;
}

function showMenuPopup(menu) {
    if (activeMenu) {
        closeRecursively(activeMenu.id, false);
        activeMenu = null;
    }
    closeAllSecondLevelPopups(menu);
    var popup = ensurePopupAdded(menu);
    activeMenu = menu;
    activeMenu.className = "menuSelected";
    menu.offsetLeft;
    if (popup) {
        var style = popup.style;
        style.left = getComponentX(menu) - 5;
        style.top = 2;
        popup.className = "popupMenu";
        if (isIE) {
            // IE doesn't know fixed positioning
            popup.style.position = "absolute";
            hideTopLevelComponents();
        }
    }
}

function showMenuItemPopup(menuItem) {
    var popup = ensurePopupAdded(menuItem);
    var parentPopup = getPopupOfMenuItem(menuItem);
    if (popup) {
        if (parentPopup) {
            var style = popup.style;
            style.left = getComponentX(parentPopup) + getComponentWidth(parentPopup) + popupOffsetLeft;
            style.top = getComponentY(menuItem) + popupOffsetTop;
            popup.className = "popupMenu";
            if (isIE) {
                // IE doesn't know fixed positioning
                popup.style.position = "absolute";
                hideTopLevelComponents();
            }
        }
    }
    // Get all children of the parent popup and close them
    if (parentPopup) {
        var children = getPopupMenuItems(parentPopup);
        if (children) {
            for (var i = 0; i < children.length; i++) {
                var item = children[i];
                if (item != menuItem) {
                    closeRecursively(item.id, false);
                }
            }
        }
    }
    return popup;
}

function mouseClick(source) {
    var target = getTarget(source);
    if (target && (target.className == "menuItem" || target.className == "menuItemSelected")) {
        var link = target.getAttribute("title");
        if (activeMenu) {
            if (activeClosingTimer) {
                clearTimeout(activeClosingTimer);
            }
            closeRecursively(activeMenu.id);
            activeMenu = null;
            if (link) {
                top.main.location.href = link;
            }
        }
    }
}

function mouseOver(source) {
    var target = getTarget(source);
    if (target) {
        activeComponent = target;
        var className = target.className;
        if (className == "menu" || className == "menuSelected") {
            showMenuPopup(target);
        } else if (className == "menuItem" || className == "menuItemSelected") {
            mouseOverMenuItem(target);
        }
    }
}

function mouseOverMenuItem(item) {
    var items = getPopupMenuItems(getPopupOfMenuItem(item));
    // Get all menu items of the popup and set them the normal style
    for (var i = 0; i < items.length; i++) {
        if (items[i].className == "menuItemSelected") {
            items[i].className = "menuItem";
        }
    }
    showMenuItemPopup(item);
    item.className = "menuItemSelected";
}

function mouseOut(source) {
    var target = getTarget(source);
    if (target) {
        activeComponent = null;
        var className = target.className;
        if (activeClosingTimer) {
            clearTimeout(activeClosingTimer);
        }
        var id = target.id;
        activeClosingTimer = setTimeout("closeOnTimer('" + id + "')", menuTimeout);
    }
}

function getTarget(source) {
    if (isIE) {
        if (source && source.srcElement) {
            return source.srcElement;
        } else if (event) {
            return event.srcElement;
        } else if (top.main.event) {
            // The event happened in the content frame
            return top.main.event.srcElement;
        } else {
            return null;
        }
    } else {
        return source.currentTarget;
    }
}

function closeOnTimer(id) {
    if (activeComponent == null) {
        closeRecursively(id, true);
    }
}

function closeRecursively(sourceId, closeParent) {
    if (!sourceId) {
        return;
    }
    var source = top.main.document.getElementById(sourceId);
    if (!source) {
        // Menus are in the upper frame
        source = document.getElementById(sourceId);
    }
    if (!source) {
        return;
    }
    var className = source.className;
    if (className == "popupMenu") {
        source.className = "hiddenPopupMenu";
        if (isIE) {
            showTopLevelComponents();
        }
        // Get all children which are menu items, get their popups and close them
        var children = getPopupMenuItems(source);
        // Close this popup, and all children popups
        if (children) {
            for (var i = 0; i < children.length; i++) {
                var child = children[i];
                // Children won't close their parent as it's already closed
                closeRecursively(child.id + "_popup0", false);
                child.className = "menuItem";
            }
        }
        // Eventually close the parent popup
        if (closeParent) {
            var inactiveParentPopup = getInactiveParentOfPopup(source);
            if (inactiveParentPopup) {
                closeRecursively(inactiveParentPopup.id, closeParent);
            } else {
                var menu = getMenuOfPopup(source);
                if (menu) {
                    menu.className = "menu";
                }
            }
        }
    } else if (className == "menu" || className == "menuSelected") {
        closeRecursively(source.id + "_popup0", false);
        source.className = "menu";
    } else if (className == "menuItem" || className == "menuItemSelected") {
        closeRecursively(source.id + "_popup0", closeParent);
    }
}

function getMenuOfPopup(popup) {
    var id = popup.id;
    var index = id.lastIndexOf("_popup0");
    if (index != -1) {
        id = id.substring(0, index);
        var menu = top.menu.document.getElementById(id);
        if (menu && (menu.className == "menu" || menu.className == "menuSelected")) {
            return menu;
        }
    }
    return null;
}

function getPopupOfMenuItem(menuItem) {
    var parent = menuItem.parentNode.parentNode;
    if (parent.className == "popupMenu") {
        return parent;
    } else {
        return null;
    }
}

function getPopupMenuItems(popup) {
    var children;
    divs = popup.childNodes;
    var items = new Array();
    if (divs) {
        for (var i = 0; i < divs.length; i++) {
            var spans = divs[i].childNodes;
            for (var j = 0; j < spans.length; j++) {
                var item = spans[j];
                if (item.className == "menuItem" || item.className == "menuItemSelected") {
                    items[items.length] = item;
                }
            }
        }
    }
    return items;
}

function getInactiveParentOfPopup(popup) {
    var id = popup.id;
    if (!id) {
        return null;
    }
    var index = id.lastIndexOf("_popup0");
    if (index == -1) {
        return null;
    }
    id = id.substring(0, index);
    var parent;
    parent = top.main.document.getElementById(id);
    if (parent && (parent.className == "menuItem" || parent.className == "menuItemSelected")) {
        parent = getPopupOfMenuItem(parent);
    }
    // Look if any of the menu items of the parent has a popup open,
    // otherwise close the popup
    if (parent && !hasActiveChild(parent)) {
        return parent;
    } else {
        return null;
    }
}

function hasActiveChild(popup) {
    var children = getPopupMenuItems(popup);
    if (children) {
        for (var i = 0; i < children.length; i++) {
            var child = children[i];
            var popupChild = top.main.document.getElementById(child.id + "_popup0");
            if (popupChild && popupChild.className == "popupMenu") {
                return true;
            }
        }
    }
    return false;
}

function addMenuListeners() {
    var spans = document.getElementsByTagName("span");
    if (spans) {
        for (var i = 0; i < spans.length; i++) {
            var sp = spans[i];
            if (sp.className == "menu" || sp.className == "menuSelected") {
                addNodeListeners(sp, top.menu.mouseOver, top.menu.mouseOut, null);
            }
        }
    }
}

function addListenersRecursively(element, mouseOverFn, mouseOutFn, mouseClickFn) {
    var className = element.className;
    if (className == "popupMenu" || className == "hiddenPopupMenu") {
        addNodeListeners(element, mouseOverFn, mouseOutFn, null);
    } else if (className == "menuItem" || className == "menuItemSelected") {
        addNodeListeners(element, mouseOverFn, mouseOutFn, mouseClickFn);
    }
    var children = element.childNodes;
    if (children) {
        for (var i = 0; i < children.length; i++) {
            addListenersRecursively(children[i], mouseOverFn, mouseOutFn, mouseClickFn);
        }
    }
}

function addNodeListeners(node, mouseOverFn, mouseOutFn, mouseClickFn) {
    if (isIE) {
        node.onmouseover = mouseOverFn;
        node.onmouseout = mouseOutFn;
        node.onclick = mouseClickFn
    } else {
        node.addEventListener("mouseover", mouseOverFn, false);
        node.addEventListener("mouseout", mouseOutFn, false);
        node.addEventListener("click", mouseClickFn, false);
   }
}

function safeParseInt(i, nanValue) {
    var strInt = "" + i;
    while (strInt.length > 0) {
        if (isNaN(strInt.charAt([strInt.length - 1]))) {
            strInt = strInt.substring(0, strInt.length - 1);
        } else {
            break;
        }
    }
    if (strInt.length == 0 || isNaN(strInt)) {
        return nanValue;
    } else {
        return parseInt(strInt);
    }
}

function hideTopLevelComponents() {
    var selects = top.main.document.getElementsByTagName("select");
    if (selects) {
        for (var i = 0; i < selects.length; i++) {
            var element = selects[i]
            if (element.style.visibility != "hidden") {
                var popups = getAllActivePopups();
                if (popups) {
                    for (var j = 0; j < popups.length; j++) {
                        if (intersect(element, popups[j])) {
                            element.style.visibility = "hidden";
                            hiddenComponents[hiddenComponents.length] = element;
                            break;
                        }
                    }
                }
            }
        }
    }
}

function showTopLevelComponents() {
    var popups = getAllActivePopups();
    var indices = new Array();
    if (hiddenComponents) {
        for (var i = 0; i < hiddenComponents.length; i++) {
            var elem = hiddenComponents[i];
            var hide = true;
            if (popups) {
                for (var j = 0; j < popups.length; j++) {
                    if (intersect(elem, popups[j])) {
                        hide = false;
                        break;
                    }
                }
            }
            if (hide) {
                elem.style.visibility = "visible";
                indices[indices.length] = i;
            }
        }
    }
    for (var i = 0; i < indices.length; i++) {
        removeFromArray(hiddenComponents, indices[i] - i);
    }
}

function removeFromArray(array, i) {
    for (var k = i; k < array.length - 1; k++) {
        array[k] = array[k + 1];
    }
    array.length = array.length - 1;
}

function intersect(element, popup) {
    var x1Elem = getComponentX(element);
    var x2Elem = x1Elem + element.offsetWidth;
    var y1Elem = getComponentY(element);
    var y2Elem = y1Elem + element.clientHeight;
    //
    var x1Pop = getComponentX(popup);
    var x2Pop = x1Pop + popup.offsetWidth;
    var y1Pop = getComponentY(popup);
    var y2Pop = y1Pop + popup.clientHeight;
    //
    var intersectX= x1Elem >= x1Pop && x1Elem <= x2Pop || x2Elem >= x1Pop && x2Elem <= x2Pop ||
            x1Elem <= x1Pop && x2Elem >= x2Pop;
    var intersectY = y1Elem >= y1Pop && y1Elem <= y2Pop || y2Elem >= y1Pop && y2Elem <= y2Pop ||
            y1Elem <= y1Pop && y2Elem >= y2Pop;
    return intersectX && intersectY;
}

function getAllActivePopups() {
    var list = new Array();
    if (activeMenu) {
        var popup = top.main.document.getElementById(activeMenu.id + "_popup0");
        if (popup && popup.className == "popupMenu") {
            addPopup(list, popup);
        }
    }
    return list;
}


function addPopup(popupList, popup) {
    popupList[popupList.length] = popup;
    var children = getPopupMenuItems(popup);
    if (children) {
        for (var i = 0; i < children.length; i++) {
            var childPopup = top.main.document.getElementById(children[i].id + "_popup0");
            if (childPopup && childPopup.className == "popupMenu") {
                addPopup(popupList, childPopup);
            }
        }
    }
}