/**
 * Created by emilianoeloi on 5/5/14.
 */
var itensMenu = document.querySelectorAll('.link-course');
for(var index in itensMenu) {
    try {
        itensMenu[index].addEventListener('click', function () {
            window.location.href = 'curso.html';
        });
    }catch(e){}
}
document.querySelector('form').addEventListener('submit', function(){
    window.location.href = 'pesquisa.html';
})

var projectLinks = document.querySelectorAll('.container a strong');
for(var index in projectLinks) {
    try {
        projectLinks[index].addEventListener('click', function () {
            window.location.href = 'projeto.html';
        });
    }catch(e){}
}