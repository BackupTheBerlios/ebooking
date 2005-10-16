        /**
         * @author Roman R&auml;dle
         * @version $Id: ebookingutility.js,v 1.1 2005/10/16 18:26:54 raedler Exp $
         * @since DAPS INTRA 1.0
         */

        function eBookingUtility() {
}
        function eBookingUtility_getEnclosingForm(node) {
        // search the form wich embbeds the Element
  var parent = node.parentNode;

  if (null == parent) return null;

  if (parent.nodeName == 'FORM' || parent.nodeName == 'form') {
    return parent;
  }
  else {
    return arguments.callee(parent);
  }
}

        function eBookingUtility_submitForm(node, params) {
  var form = null;

          // try to find the enclosing form
  form = this.getEnclosingForm(node);

  if (null != form) {
    var p = this.splitParameters(params);
    for (var i = 0; i < p.length; i++)
    {
      var nameValue = p[i].split('=');
      form.appendChild(this.createHidden(nameValue[0], nameValue[1]));
    }
    var hasOnSubmitEvent = form.getAttribute("onSubmit");
    if (hasOnSubmitEvent) {
      if (form.onsubmit())
              form.submit();
    }
    else
            form.submit();
  }
  else {
          // not found. Do nothing
  }
}

        // -- FORM FUNCTIONS ---------------------------------------------------------------------------------------

        function __getForm(name) {
  if (name) return document.forms[name];
  return document.forms[0];
}

        function __createHidden(fldName, fldValue) {
  var input = document.createElement('INPUT');
  input.type = 'hidden';
  input.id = fldName;
  input.name = fldName;
  input.value = fldValue;
  return input;
}

        function __submitForm(form) {
  if (form) {
    if (form.fireEvent) {
      if (!form.fireEvent("onsubmit", document.createEventObject())) {
        return;
      }

    }
    else if (document.createEvent && form.dispatchEvent) {
      var eventType = (__isOpera() || __isSafari()) ? "UIEvents" : "Events";
      var event = document.createEvent(eventType);
      event.initEvent("submit", false, true);

      var result = form.dispatchEvent(event);
      if (!result && !__isOpera()) {
        return;
      }
      else
      {
        form.__submitted = true;
      }

    }
    else {
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

        // -- CARD FUNCTIONS ---------------------------------------------------------------------------------------

        function __showCard(target, formName) {
  var form = __getForm(formName);
  if (form) {
    var finish = __createHidden(target, target);
    form.appendChild(finish);
    __submitForm(form);
  }
}

new eBookingUtility();
eBookingUtility.getEnclosingForm = eBookingUtility_getEnclosingForm;
eBookingUtility.createHidden = eBookingUtility_submitForm;