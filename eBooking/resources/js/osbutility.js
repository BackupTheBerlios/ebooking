/**
 * @author Juergen Denzel
 * @version $Id: osbutility.js,v 1.1 2005/10/16 18:26:59 raedler Exp $
 * @since DAPS INTRA 1.0
 */

// OSBUtility.js
// OSB JavaScript Utility Functions
// Author: Juergen Denzel

var bColor;

function OSBUtility() {}
function OSBUtility_getEnclosingForm(node) {
	// search the form wich embbeds the Element
	var parent = node.parentNode;

	if (null == parent) return null;

	if (parent.nodeName == 'FORM') {
		return parent;
	} else {
		return arguments.callee(parent);
	}
}

function OSBUtility_createHidden(fldName, fldValue) {
	var input=document.createElement('INPUT');
	input.type='hidden';
	input.id=fldName;
	input.name=fldName;
	input.value=fldValue;
	return input;
}

function OSBUtility_splitParameters(p) {
	var params = new String(p);

	if (null == params) {
		return null;
	}

	return params.split('&');
}

function OSBUtility_submitForm(node, params) {
	var form = null;

    // try to find the enclosing form
	form = this.getEnclosingForm(node);

	if (null != form) {
	    var p = this.splitParameters(params);
	    for ( var i = 0; i < p.length; i++ )
	    {
	        var nameValue = p[i].split('=');
		    form.appendChild(this.createHidden( nameValue[0], nameValue[1] ) );
	    }
        __submitForm(form);
	} else {
		// not found. Do nothing
	}
}

function OSBUtility_triggerSubmit(e, src, loc) {
    if (__isEnterPressed(e)) {
        var form = this.getEnclosingForm(src);
        __submitForm(form);
    }
}

function OSBUtility_triggerSubmitParams(e, src, params) {
    if (__isEnterPressed(e)) {
        var form = this.getEnclosingForm(src);
	    var p = this.splitParameters(params);
	    for ( var i = 0; i < p.length; i++ )
	    {
	        var nameValue = p[i].split('=');
		    form.appendChild(this.createHidden( nameValue[0], nameValue[1] ) );
	    }

        __submitForm(form);
    }
}

function OSBUtility_uncheck(items) {

	for (var i=0; i < items.length; i++) {
		if (items[i].type == 'checkbox' ) {

			// uncheck checkbox
			items[i].checked = false;
		}
	}
}

function OSBUtility_handleCheckboxEvent(node, prefix) {
    var form = this.getEnclosingForm(node);
    var checkboxes = new Array();
    if ( form != null ) {
        var j = 0;
        for (i = 0; i < form.length; i++) {
            var el = form.elements[i];
            if ( el.type == 'checkbox' && el.name.indexOf(prefix) == 0 && el != node ) {
                checkboxes[j] = el;
                j++;
            }
        }
    }
    this.uncheck(checkboxes);
}

function OSBUtility_gotoLocation(src, loc) {
    var form = this.getEnclosingForm(src);
    if (form) {
        form.setAttribute("action",loc);
        __submitForm(form);
    }
    return false;
}

function high(obj) {
    bColor = obj.style.backgroundColor;
	obj.style.background = '#eeeeee';
}

function low(obj) {
    obj.style.backgroundColor=bColor;
}

new OSBUtility();
OSBUtility.getEnclosingForm     = OSBUtility_getEnclosingForm;
OSBUtility.createHidden         = OSBUtility_createHidden;
OSBUtility.splitParameters      = OSBUtility_splitParameters;
OSBUtility.submitForm           = OSBUtility_submitForm;
OSBUtility.triggerSubmit        = OSBUtility_triggerSubmit;
OSBUtility.triggerSubmitParams  = OSBUtility_triggerSubmitParams;
OSBUtility.uncheck              = OSBUtility_uncheck;
OSBUtility.handleCheckboxEvent  = OSBUtility_handleCheckboxEvent;
OSBUtility.gotoLocation         = OSBUtility_gotoLocation;

// useful functions ------------------------------------------------------------------------

function getKeyCode(e) {
    var k;
    if(window.event) {
        k = e.keyCode;
    } else if(e.which) {
        k = e.which;
    }
    return k;
}

function getCharacter(code) {
 	return String.fromCharCode(code);
}

function checkNumeric(e) {
    var code = getKeyCode(e);
    if ( code>13 ) {
        pattern = /^[0-9]|[,]|[.]|[-]$/;
		return pattern.test(getCharacter(code));
    }
}

function enforcelimit(e,el,limit) {
    var k = getKeyCode(e);
    if (k>13) {
        if (el.value.length>=limit)
            return false;
    }
}

// browser detection -----------------------------------------------------------------------

function __isSafari() {
    return __checkBrowser('Safari');
}

function __isMSIE() {
    return __checkBrowser('MSIE') && !__isOpera();
}

function __isOpera() {
    return __checkBrowser('Opera');
}

function __isNetscape() {
    return __checkBrowser('Netscape');
}

function __isMozilla() {
    return __checkBrowser('Mozilla') && !__isOpera() && !__isMSIE() && !__isNetscape() && !__isSafari();
}

function __checkBrowser(name) {
    return navigator.userAgent.indexOf(name) > -1;
}

// form stuff -------------------------------------------------------------------------------

function __getForm(name) {
    if (name) return document.forms[name];
    return document.forms[0];
}

function __getFormElements(name) {
    var formElements = new Array();
    if (name) {
        var form = __getForm(name);
        if (form)
            formElements = form.elements;
    }
    return formElements;
}

function __getFormElementByName(form, name) {
    var formElements = form.elements;
    for (count = 0; count < formElements.length; count++) {
        if (formElements[count].name == name)
            return formElements[count];
    }
}

function __getKeyCode(kbdEvent) {
    var result = kbdEvent.which;
    if (!result) {
        result = kbdEvent.keyCode;
    }
    return result;
}

function __isEnterPressed(kbdEvent) {
    return __getKeyCode(kbdEvent) == 13;
}

function __getEnclosingForm(node) {
    var parent = node.parentNode;
    if (null == parent) return null;

    if (parent.nodeName == 'FORM') {
        return parent;
    } else {
        return arguments.callee(parent);
    }
}

function __createHidden(fldName, fldValue) {
    var input=document.createElement('INPUT');
	input.type='hidden';
	input.id=fldName;

	input.name=fldName;
	input.value=fldValue;
    return input;
}

function __splitParameters(p) {
    var params = new String(p);

    if (null == params) {
        return null;
    }
    return params.split('&');
}

function __appendParameters(form, params) {
    if (null != form) {
        var p = __splitParameters(params);

        for ( var i = 0; i < p.length; i++ ) {
            var nameValue = p[i].split('=');
            var child = __getFormElementByName(form,nameValue[0]);
            if (child) form.removeChild(child);

            form.appendChild(__createHidden( nameValue[0], nameValue[1] ) );
        }
    } else {
        // not found. Do nothing
    }
}

function __getEventTarget(e) {
    var eventTarget;
	if (!e) var e = window.event;
	if (e.target) eventTarget = e.target;
	else if (e.srcElement) eventTarget = e.srcElement;
	if (eventTarget.nodeType == 3) // defeat Safari bug
        eventTarget = eventTarget.parentNode;
    return eventTarget;
}

function __triggerFormSubmit(e) {
    var el = __getEventTarget(e);
    var form = __getEnclosingForm(el);

    if (__isEnterPressed(e) && form) {

        if (form.fireEvent) {
            if (!form.fireEvent("onsubmit", document.createEventObject())) {
                return;
            }
        } else if (document.createEvent && form.dispatchEvent) {
            var eventType = (__isOpera() || __isSafari()) ? "UIEvents" : "Events";
            var event = document.createEvent(eventType);
            event.initEvent("submit", false, true);
            var params = el.getAttribute("params");
            if (params) __appendParameters(form, params);

            var result = form.dispatchEvent(event);
            if (!result && !__isOpera()) {
                return;
            } else
            {
                form.__submitted = true;
            }

        } else {
            if (form.onsubmit) {
                var result = form.onsubmit();
                if (result == false) {
                    return;
                }
            }
        }

        if (!form.__submitted) {
            var params = el.getAttribute("params");
            if (params) __appendParameters(form, params);
            form.submit();
        }
    }
}

function __submitForm(form) {
    if (form) {
        if (form.fireEvent) {
            if (!form.fireEvent("onsubmit", document.createEventObject())) {
                return;
            }

        } else if (document.createEvent && form.dispatchEvent) {
            var eventType = (__isOpera() || __isSafari()) ? "UIEvents" : "Events";
            var event = document.createEvent(eventType);
            event.initEvent("submit", false, true);

            var result = form.dispatchEvent(event);
            if (!result && !__isOpera()) {
                return;
            } else
            {
                form.__submitted = true;
            }

        } else {
            if (form.onsubmit) {
                var result = form.onsubmit();
                if (result == false) {
                    return;
                }
            }
        }

        if (!form.__submitted) {
            form.submit();
        }
    }
}

// form event handling ---------------------------------------------------------------------------

function __cancelEvent(e) {
    if (__isMSIE())
        return false;
    else
        e.preventDefault();
}

function __addEventListener(element, eventName, handler) {
    if (element.attachEvent) {
        element.attachEvent('on' + eventName, handler);
    } else if (element.addEventListener) {
        element.addEventListener(eventName, handler, false);
    } else {
        alert("This browser does not support event listeners");
    }
}

function __applySubmitEventListener(formName) {
    var formElements = __getFormElements(formName);
    for (i = 0; i < formElements.length; i++) {
        var formElement = formElements[i];
        if (formElement && formElement.type != 'hidden' &&
            (formElement.nodeName == 'INPUT' || formElement.nodeName == 'SELECT'))
            __addEventListener(formElement, "keypress",__triggerFormSubmit);
    }
}

function __applyFormEventListeners() {
    var forms = document.forms;
    for (j = 0; j < forms.length; j++) {
        var formName = forms[j].name;
        __applySubmitEventListener(formName);
    }
}

function __getEventSource(e) {
    return (e.srcElement) ? event.srcElement : null;
}

function __high(e) {
    var el = __getEventSource(e);
    if (el)
        el.style.backgroundColor = '#C0C0C0';
    else
        this.style.backgroundColor = '#C0C0C0';
}

function __low(e) {
    var el = __getEventSource(e);
    if (el)
        el.style.backgroundColor = 'white';
    else
        this.style.backgroundColor = 'white';
}

function __error(formElement) {
    if (formElement) formElement.style.backgroundColor = 'red';
}


// form validation stuff ------------------------------------------------------------------

function __integerValidator(value) {
    return /^[+-]?\d+$/.test(value);
}

function __emailValidator_emailCheck(emailStr) {
    var emailPat=/^(.+)@(.+)$/;
    var specialChars="\\(\\)><@,;:\\\\\\\"\\.\\[\\]";
    var validChars="\[^\\s" + specialChars + "\]";
    var atom=validChars + '+';
    var quotedUser="(\"[^\"]*\")";
    var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/;
    var word="(" + atom + "|" + quotedUser + ")";
    var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
    var domainPat=new RegExp("^" + atom + "(\\." + atom +")+$");

    var matchArray=emailStr.match(emailPat);
    if (matchArray==null) {
        return false;
    }

    var user=matchArray[1];
    var domain=matchArray[2];

    for (i=0; i<user.length; i++) {
        if (user.charCodeAt(i)>127) {
            return false;
        }
    }

    for (i=0; i<domain.length; i++) {
        if (domain.charCodeAt(i)>127) {
            return false;
        }
    }

    if (user.match(userPat)==null) {
        return false;
    }

    var IPArray=domain.match(ipDomainPat);
    if (IPArray!=null) {
        for (var i=1;i<=4;i++) {
            if (IPArray[i]>255) {
                return false;
            }
        }
        return true;
    }

    var domainArray=domain.match(domainPat);
    if (domainArray==null) {
        return false;
    }

    return true;
}

function __retrieveValueToValidate(formElement) {
    var value = formElement.value;
    return value;
}

function __notEmptyValidator_validate(formElement) {
    if  (__isNotRequired(formElement)) return true;

    var valid;
    var value = __retrieveValueToValidate(formElement);
    if (value == undefined) {
        valid = true;
    } else if (value == null) {
        valid = false;
    } else if((formElement.type != undefined) && (formElement.type.indexOf('select') > -1)) {
        if(formElement.selectedIndex == 0) {
            valid = false;
        } else if(formElement.selectedIndex == -1) {
            valid = false;
        } else {
            valid = true;
        }
    } else {
        valid = !/^\s*$/.test(value);
    }

    return valid;
}

function __getMessage(formElement) {
    return formElement.getAttribute("message");
}

function __isNotRequired(formElement) {
    return "false" == formElement.getAttribute("required");
}

function __validateRequired(formElement) {
    return __notEmptyValidator_validate(formElement);
}

function __validateNumber(formElement) {
    if (!__notEmptyValidator_validate(formElement)) return false;

    var value = __retrieveValueToValidate(formElement);
    if (!value) return true;
    if (value.length == 0) return true;

    var valid = !isNaN(value);
    return valid;
}

function __validateEmail(formElement) {
    if (!__notEmptyValidator_validate(formElement)) return false;

    var value = __retrieveValueToValidate(formElement);
    if (!value) return true;
    if (value.length == 0) return true;

    var valid = __emailValidator_emailCheck(value);
    return valid;
}

function __validateInteger(formElement) {
    if (!__notEmptyValidator_validate(formElement)) return false;

    var value = __retrieveValueToValidate(formElement);
    if (!value) return true;
    if (value.length == 0) return true;

    var valid = __integerValidator(value);
    return valid;
}

function __validateRegex(formElement) {
    if (!__notEmptyValidator_validate(formElement)) return false;

    var value = __retrieveValueToValidate(formElement);
    if (!value) return true;
    if (value.length == 0) return true;

    var pattern = formElement.getAttribute("regex");
    if (!pattern) {
        alert("Regex pattern has not been defined");
        return true;
    }

    var regExp = new RegExp("^" + pattern + "$");
    var valid = regExp.test(value);
    return valid;
}

var formats = new Object();
formats["de"] = "DD.MM.YYYY";
formats["en"] = "MM/DD/YYYY";

function __validateDate(formElement) {
    if (!__notEmptyValidator_validate(formElement)) return false;

    var value = __retrieveValueToValidate(formElement);
    if (!value) return true;
    if (value.length == 0) return true;

    var locale = formElement.getAttribute("locale");
    var format = formElement.getAttribute("format");
    if (!format)
        format = formats[locale];

    // ignore server side formats
    if (format=="date" ||
        format=="dateshort" ||
        format=="time" ||
        format=="timeshort" ||
        format=="timestamp" ||
        format=="timestampshort")
        format = formats[locale];

    var date = new DateFormat(format);
    return date.parseDate(value);
}

function __validateLetter(formElement) {
    if (!__notEmptyValidator_validate(formElement)) return false;

    var value = __retrieveValueToValidate(formElement);
    if (!value) return true;
    if (value.length == 0) return true;

    return /^[a-zA-Z]+$/.test(value);
}

function __validateRange(formElement) {
    if (!__notEmptyValidator_validate(formElement)) return false;

    var value = __retrieveValueToValidate(formElement);
    if (!value) return true;
    if (value.length == 0) return true;

    if (isNaN(value)) return false;

    var min = parseInt(formElement.getAttribute("min"));
    var max = parseInt(formElement.getAttribute("max"));

    if (isNaN(min) || isNaN(max)) return false;
    if (min > max) return true;

    if (value<min || value>max) return false;

    return true;
}

function __validateOnSubmit(e) {
    var el = __getEventSource(e);

    // Mozilla
    if (!el) el = this;

    var formElements = el.elements;
    for (i = 0; i < formElements.length; i++) {
        var formElement = formElements[i];
        var validatorType = formElement.getAttribute("validator");
        if (validatorType) {
            var message = formElement.getAttribute("message");
            var validator = validators[validatorType];
            if (validator && !validator(formElement)) {
                alert(message);
                formElement.focus();
                __error(formElement);
                return __cancelEvent(e);
            }
        }
    }
}

var validators = new Object();

function __registerValidators() {
    validators["number"] = __validateNumber;
    validators["required"] = __validateRequired;
    validators["email"] = __validateEmail;
    validators["integer"] = __validateInteger;
    validators["regex"] = __validateRegex;
    validators["date"] = __validateDate;
    validators["letter"] = __validateLetter;
    validators["range"] = __validateRange;
}

function __checkValidation(formName) {
    var validationFieldsFound = false;
    var formElements = __getFormElements(formName);
    for (i = 0; i < formElements.length; i++) {
        var formElement = formElements[i];
        var validator = formElement.getAttribute("validator");
        if (validator) {
            validationFieldsFound = true;
        }
    }

    if (validationFieldsFound == true) {
        __addEventListener(__getForm(formName), "submit", __validateOnSubmit);
    }
}

// misc stuff --------------------------------------------------------------------------------

function __getElementById(id) {
    if (document.all) {
        return document.all[id];
    } else {
        return document.getElementById(id);
    }
}

function __hideElement(id) {
    var el = __getElementById(id);
    if (el) el.style.visibility = 'hidden';
}

function __showElement(id) {
    var el = __getElementById(id);
    if (el) el.style.visibility = 'visible';
}

function __escapeText(text) {
    var result = text;
    var re = /&/g;
    result = result.replace(re, "&amp;");
    return result;
}

function __unescapeText(text) {
    var result = text;
    var re = /&amp;/g;
    result = result.replace(re, "&");
    return result;
}

function __replaceAllStrings(replaceHere, replaceThis, withThis) {
    var result = replaceHere;
    while(result.indexOf(replaceThis) != -1)
        result = result.replace(replaceThis, withThis);
    return result;
}

// applies focus listeners to all applicable fields of a given form
function __applyFocusEventListener(formName) {
    var formElements = __getFormElements(formName);
    for (i = 0; i < formElements.length; i++) {
        var formElement = formElements[i];
        if (formElement && formElement.type != 'hidden' &&
            formElement.type != 'submit' &&
            formElement.type != 'button' &&
            (formElement.nodeName == 'INPUT' || formElement.nodeName == 'SELECT')) {
            __addEventListener(formElement, "focus",__high);
            __addEventListener(formElement, "blur",__low);
        }
    }
}

// applies focus listeners to all applicable form fields
function __applyFocusEventListeners() {
    var forms = document.forms;
    for (j = 0; j < forms.length; j++) {
        var formName = forms[j].name;
        __applyFocusEventListener(formName);
    }
}

// applies validation listeners to all applicable form fields
function __applyValidationEventListeners() {
    var forms = document.forms;
    for (j = 0; j < forms.length; j++) {
        var formName = forms[j].name;
        __checkValidation(formName);
    }
}

// -- POPUPCALENDAR --------------------------------------------------------------------------------------

var calendar = null;
function popupCalendar(fieldId, template) {

    var target = "";
	var width = 250;
    var height = 220;

	target += template;
	target += '?fieldid=' + fieldId;

	// get the coordinate to display the new window
	var left = (screen.width - width) / 2;
	var top  = (screen.height - height) / 2;

	// Check if the window is already opend
	if (null == calendar || calendar.closed) {
		calendar = window.open(target, '', 'top=' + top + ',left=' + left + ',width=' + width + ',height=' + height + ',status=no,toolbar=no,location=no,resizable=no,scrollbars=no,menubar=no');
	} else {
		calendar.focus();
	}
}

// -- CARD FUNCTIONS ---------------------------------------------------------------------------------------

function __showCard(target,formName) {

    var form = __getForm(formName);
    if (form) {
        var finish = __createHidden(target, target);
        form.appendChild(finish);
        __submitForm(form);
    }
}

// -- DATE FUNCTIONS ---------------------------------------------------------------------------------------

function DateFormat(format) {
    this.format = new String(format);
    this.format.formatCharAt = function(i) {
        return this.substring(i, i + 1).toUpperCase();
    };
    this.format.formatCharAtEx = function(i) {
        return i < this.length ? this.substring(i, i + 1) : '';
    };
}

DateFormat.prototype.parseDate = function (date) {
    var year = '';
    var month = '';
    var day = '';
    date = __replaceAllStrings(date,' ','');
    for (var i = 0; i < this.format.length; i++) {
        switch (this.format.formatCharAt(i)) {
        case 'Y':
        case 'y':
            year += date.substring(i, i + 1);
            break;
        case 'M':
        case 'm':
            month += date.substring(i, i + 1);
            break;
        case 'D':
        case 'd':
            day += date.substring(i, i + 1);
            break;
        default:
            if (this.format.substring(i, i + 1) != date.substring(i, i + 1)) {
                return false;
            }
            break;
        }
    }

    if (isNaN(day)) return false;
    var intday = parseInt(day);
    if (intday < 1 || intday > 31) return false;

    if (isNaN(month)) return false;
    var intmonth = parseInt(month);
    if (intmonth < 1 || intmonth > 12) return false;

    if (isNaN(year)) return false;
    var intyear = parseInt(year);
    if (intyear < 1900 || intyear > 2200) return false;

    return true;
}

// -- SIDEBAR FUNCTIONS ---------------------------------------------------------------------------------------

function __showControl(controlId) {
    var control = getControlById(controlId);
    control.style.visibility = 'visible';
}

function __hideControl(controlId) {
    var control = getControlById(controlId);
    control.style.visibility = 'hidden';
}

function getControlDataHandler(controlId, handlerSuffix) {
    return getControlDependentObj(controlId, "-dat-", handlerSuffix);
}

function getControlHelper(controlId, helperSuffix) {
    return getControlDependentObj(controlId, "-hlp-", helperSuffix);
}

function getControlDependentObj(controlId, separator, suffix) {
    var dependentId = controlId + separator + suffix;
    var result = getControlById(dependentId);
    return result;
}

function getControlById(id) {
    if (id == this._thisPageId)
        return this;
    if (document.all) {
        return document.all[id];
    } else {
        return document.getElementById(id);
    }
}

function getPageBarSelectedPageScrollPosition(pageBar) {
    return pageBar.__getSelectedPageScrollPosition();
}

function setPageBarSelectedPageScrollPosition(pageBar, scrollPosition) {
    pageBar.__setSelectedPageScrollPosition(scrollPosition);
}

function getPageBarSelectedPageIndex(pageBar) {
    return pageBar.__getSelectedPageIndex();
}

function setPageBarSelectedPageIndex(pageBar, pageIndex) {
    pageBar.__setSelectedPageIndex(pageIndex);
}

function scrollUpPageBarPage(pageBarID) {
    var pageBar = getControlById(pageBarID);
    pageBar.__scrollUp();
}

function scrollDownPageBarPage(pageBarID) {
    var pageBar = getControlById(pageBarID);
    pageBar.__scrollDown();
}

function __initPageBar(pageBarID, useSmallImages) {
    var pageBar = getControlById(pageBarID);

    pageBar.__selectedPageIndexField = getControlDataHandler(pageBarID, 'selectedPageIndex');
    pageBar.useSmallImages = useSmallImages;

    pageBar.__getSelectedPageScrollPosition = function() {
        var page = this.__pages[this.__getSelectedPageIndex()];
        return page.getScrollPosition();
    };

    pageBar.__setSelectedPageScrollPosition = function(scrollPosition) {
        var page = this.__pages[this.__getSelectedPageIndex()];
        page.setScrollPosition(scrollPosition);
    };

    pageBar.__getSelectedPageIndex = function() {
        return parseInt(this.__selectedPageIndexField.value);
    };

    pageBar.__setSelectedPageIndex = function(index) {
        if (this.__getSelectedPageIndex() != index && index > -1 && index < this.__pageCount) {
            this.__selectedPageIndexField.value = index;
            this.__draw();
  	    }
    };

    pageBar.__scrollUp = function() {
        var page = this.__pages[this.__getSelectedPageIndex()];
        page.scrollUp();
    };

    pageBar.__scrollDown = function() {
        var page = this.__pages[this.__getSelectedPageIndex()];
        page.scrollDown();
    };

    pageBar.__init = function() {
        this.__headers = new Array();
        this.__pages = new Array();

        var i = 0;
        var pageIDBase = this.id + "_page-spe-";

        var pageID = pageIDBase + i;
  	    var pageControl = getControlById(pageID);

  	    while (pageControl != null) {

  	        var page = new __PageBarPage(this, pageID);
  	        page.init();
  	        this.__pages[i] = page;

  	        var pageHeaderID = pageID + '_header';
  	        this.__headers[i] = getControlById(pageHeaderID);

  	        i = i + 1;

            pageID = pageIDBase + i;
  	        pageControl = getControlById(pageID);
   	    }
	    this.__pageCount = i;

  	    this.__draw();
    };

    pageBar.__draw = function() {
        var top = 0;
        if (__isOpera()) {
            top = 1;
        }

  	    for (var i = 0; i < this.__pageCount; i++) {
  	        var header = this.__headers[i];
  	        header.style.top = top;

            var page = this.__pages[i];

  	        if (i == this.__getSelectedPageIndex()) {
    		    var pageTop = top + header.offsetHeight;

                var sum = 0;
                for (var j = i + 1; j < this.__pageCount; j++) {
    		        sum = sum + this.__headers[i].offsetHeight;
                    if (__isMozilla() || isNetscape()) {
                        sum = sum - 1;
                    }
    		    }
                top = this.offsetHeight - sum - 2;
                if (__isOpera()) {
                    top = top + 1;
                }
                if (__isNetscape()) {
                    top = top - 2;
                }

    		    var pageHeight = top - pageTop;
    		    page.draw(pageTop, pageHeight);

  	        } else {
                top = top + header.offsetHeight;
                if (__isMozilla() || __isNetscape()) {
                    top = top - 1;
                }
                page.hide();
  	        }
  	    }
    };

    pageBar.__init();

    if (__isMozilla() || __isNetscape()) {
        setTimeout('__drawPageBar("' + pageBar.id + '")', 300);
    }
}

function __PageBarPage(pageBar, controlId) {

    this.pageBar = pageBar;
    this.id = controlId;
    this.control = getControlById(controlId);
    this.up = getControlById(controlId + '_scrollUp');
    this.down = getControlById(controlId + '_scrollDown');
    this.scrollPositionField = getControlHelper(controlId, 'pageBarPageScrollPosition');

    this.useSmallImages = function() {
        return this.pageBar.useSmallImages;
    };

    this.getScrollPosition = function() {
        return parseInt(this.scrollPositionField.value);
    };

    this.setScrollPosition = function(position) {
        if (position > -1 && position < this.itemCount) {
            this.scrollPositionField.value = position;
            this.redraw();
        }
    };

    this.redraw = function() {
        var curTop = parseInt(this.control.style.top);
  	    var curHeight = this.control.offsetHeight;
  	    this.draw(curTop, curHeight);
    };

    this.scrollUp = function() {
        this.setScrollPosition(this.getScrollPosition() - 1);
    };

    this.scrollDown = function() {
        this.setScrollPosition(this.getScrollPosition() + 1);
    };

    this.init = function() {
        this.items = new Array();
        var i = 0;
  	    var item = getControlById(this.id + '_item' + i);

  	    while (item != null) {
  	        this.items[i] = item;
  	        i = i + 1;
  	        item = getControlById(this.id + '_item' + i);
   	    }
	    this.itemCount = i;
    };

    this.hide = function() {
        this.control.style.height = 0;
        __hideControl(this.id);
    };

    this.getScrollButtonWidth = function() {
        return 20;
    };

    this.getScrollButtonHeight = function() {
        return 20;
    };

    this.draw = function(top, height) {
        this.control.style.top = top;
        this.control.style.height = height;

  	    var curHeight = 0;

  	    for (var i = 0; i < this.itemCount; i++) {

  	        var item = this.items[i];

  	        if (i < this.getScrollPosition()) {

  	            __hideControl(item.id);

  	        } else {

      	        var itemHeight = item.offsetHeight;

  	            if (__isNetscape() && itemHeight < 12) itemHeight = itemHeight * 4;

  	            if ((curHeight + itemHeight) < height) {

  	                var pw = this.control.offsetWidth;
  	                var sw = this.getScrollButtonWidth();

  	                if (this.useSmallImages()) {
                        item.style.width = pw - (sw + 18);
                        item.style.left = 6;
  	                } else {
                        item.style.width = pw - 2 * (sw + 6);
                        item.style.left = sw;
  	                }

                    item.style.top = curHeight;
                    __showControl(item.id);

                    curHeight = curHeight + itemHeight;
                } else {
                    __hideControl(item.id);
                    curHeight = curHeight + itemHeight;
    		    }
  	        }
        }

  	    if (this.getScrollPosition() == 0) {
  	        __hideControl(this.up.id);
  	    } else {
            var sw = this.getScrollButtonWidth();
            var scrollLeft = this.control.offsetWidth - sw - 6;
            if (__isMozilla() || __isNetscape()) {
                scrollLeft += 6;
            }

            this.up.style.left = scrollLeft;
            this.up.style.top = 4;
  	        __showControl(this.up.id);
  	    }

  	    if (curHeight > height) {
            var sw = this.getScrollButtonWidth();
            var sh = this.getScrollButtonHeight();

            var scrollLeft = this.control.offsetWidth - sw - 6;
            if (__isMozilla() || __isNetscape()) {
                scrollLeft += 6;
            }

            this.down.style.top = height - sh - 4;
            this.down.style.left = scrollLeft;
  	        __showControl(this.down.id);
        } else {
            __hideControl(this.down.id);
  	    }

        __showControl(this.id);
    };

    return this;
}

function __drawPageBar(pageBarID) {
    var pageBar = getControlById(pageBarID);
    pageBar.__draw();
}


// sanity check, ensure the script was loaded
var OSBUtility_script_loaded = true;