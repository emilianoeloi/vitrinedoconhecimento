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