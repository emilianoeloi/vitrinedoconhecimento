String.prototype.replaceAll = function(de, para) {
    var regex = new RegExp(de, 'g');

    var text = this.replace(regex, para);
    return text;
}
String.prototype.padLeft = function (width, charac) {
    if (!charac) {
        charac = "0";
    }

    if (("" + this).length >= width) {
        return "" + this;
    }
    else {
        return arguments.callee.call(
            charac + this,
            width,
            charac
            );
    }
} 

var Dbg = {
	debug : false,
	log : function(key, value){
		if(this.debug)
			window.console.log(key, value);	
	}
}
var debug = false;
var d = function(k,v){
	if(debug)
		window.console.log(k, v);
}

$.fn.serializeObject = function(){
	var o = {};
	var a = this.serializeArray();
	$.each(a, function(){
		if(o[this.name] !== undefined){
			if(!o[this.name].push){
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		}else{
			o[this.name] = this.value || '';
		}
	});
	return o;
}

function writeMessage(type, message){
    var $alertElement = $(".alert"),
        strongText = '',
        spamText = '',
        successClass = 'alert-success',
        errorClass = 'alert-danger',
        alertClass = 'alert-warning',
        klass = '';
    $alertElement.removeClass(successClass);
    $alertElement.removeClass(errorClass);
    switch(type){
        case 'success':
            strongText = 'Sucesso',
                spamText = message;
            klass = successClass;
            break;
        case 'error':
            strongText = 'Erro',
            spamText = message;
            klass = errorClass;
            break;
        case 'alert':
            strongText = 'Alerta',
                spamText = message;
            klass = alertClass;
            break;
        default:
            strongText = '',
                spamText = message;
            klass = '';
            break;
    }
    $alertElement.addClass(klass);
    $alertElement.find('strong').text(strongText);
    $alertElement.find('spam').text(spamText);
    $alertElement.removeClass('hidden');
}

/// Load JSON
/// Alert: N&atilde;o &eacute; cross browser
/// Example: loadJSON(&quot;assets/json/config.json&quot;, function(a){console.log(&#039;success&#039;,a)}, function(b){console.log(&#039;error&#039;, b)});
function loadJSON(url, success, error) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            try {
                var JSONObject = JSON.parse(xmlhttp.responseText);
                success(JSONObject);
            } catch (e) {
                error(e);
            }
        } else {
            var e = { "readyState": xmlhttp.readyState, "status": xmlhttp.status };
            if ([200, 0].indexOf(xmlhttp.status) == -1 && xmlhttp.readyState == 4) {
                error(e);
            }
        }
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}