function setTitle(title){
    document.title = Constants.appName + ': ' + title;
    document.querySelector(".page-header").innerHTML = title;
}
function getCurrentPage(){
    var str = '';
    var pathname = window.location.pathname;
    str = pathname.replace(Constants.web, '');
    return str;
}
function writeMenu(data){
    var template = '<li class="{{active}}"><a href="{{href}}">{{text}}</a></li>';
    var menu = [];
    for(var index in data){
        var menuItem = data[index];
        var active = '';
        if(getCurrentPage() == menuItem.href ){
            active = 'active';
            setTitle(menuItem.text);
        }
        menu.push(template.replaceAll('{{text}}', menuItem.text)
            .replaceAll('{{href}}', menuItem.href)
            .replaceAll('{{active}}', active));
    }
    document.querySelector('#menu-side-bar').innerHTML = menu.join('');
}
window.onload = function(){

    loadJSON(Constants.dataFiles.menu, writeMenu, function(){});
}