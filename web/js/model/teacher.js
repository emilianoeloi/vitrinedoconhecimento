var selfTeacher;
var Teacher = function() {
    if (selfTeacher)
        return selfTeacher;
    selfTeacher = this;
    this.serviceUrl = Constants.api + "teachers";
    this.primaryKey = ['id'];
    this.entityName = "permission";
};
Teacher.prototype.list = function(success, error) {
    $.ajax({
        async: true,
        headers: {"token": localStorage.getItem('token')},
        type: 'GET',
        url: selfTeacher.serviceUrl,
        success: success,
        error: error
    });

};
Teacher.prototype.get = function(id, success, error) {
    $.ajax({
        async: true,
        headers: {"token": localStorage.getItem('token')},
        type: 'GET',
        url: selfTeacher.serviceUrl + '/' + id,
        success: success,
        error: error
    });
};
Teacher.prototype.insert = function(permission, success, error) {
    console.debug('permission', permission);
    $.ajax({
        async: true,
        headers: {"token": localStorage.getItem('token')},
        type: 'POST',
        url: selfTeacher.serviceUrl,
        data: {"permission": JSON.stringify(permission)},
        success: success,
        error: error
    });
};
Teacher.prototype.update = function(permission, success, error) {
    var id = permission.id;
    var permissionStr = JSON.stringify(permission);
    $.ajax({
        async: true,
        headers: {"token": localStorage.getItem('token')},
        type: 'PUT',
        url: selfTeacher.serviceUrl,
        data: {"permission": permissionStr},
        success: success,
        error: error
    });
};
Teacher.prototype.delete = function(id, success, error) {
    $.ajax({
        async: true,
        headers: {"token": localStorage.getItem('token')},
        type: 'DELETE',
        url: selfTeacher.serviceUrl + '/' + id,
        success: success,
        error: error
    });
};