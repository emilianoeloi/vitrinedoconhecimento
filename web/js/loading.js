/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var loading = {
    'element': {},
    'init' : function(){
        var d = document.createElement('div');
        d.setAttribute('id','loading-block');
        d.innerHTML = 'Loading';
        d.style.position = 'fixed';
        d.style.border = '1px solid #c1c1c1';
        d.style.display = 'none';
        d.style.left = '50%';
        d.style.top = '100px';
        d.style.width = '200px';
        d.style.marginLeft = '-100px';
        d.style.zIndex = '9999';
        d.style.backgroundColor = '#fff';
        d.style.padding = '10px';
        document.body.appendChild(d);
        this.element = document.querySelector('#loading-block');
    },
    
    'start': function(){
        if(!this.element.id){
            this.init();
        }
        this.element.style.display = 'block';
    },
    'stop':function(){
        this.element.style.display = 'none';
    }
}

