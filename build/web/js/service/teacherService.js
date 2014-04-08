/**
 * Created by emiliano.barbosa on 08/04/14.
 */
angularApp.service('TeacherService', function() {
    var uid = 1;
    var teacherList = [{
        id: 0,
        'name': 'Emiliano',
        'email': 'emilianoeloi@gmail.com',
        'phone': '(31)94510018'
    }];

    this.list = function() {
        return teacherList;
    };

    this.insert = function(teacher) {
        uid++;
        teacherList.push(teacher);
        return teacher;
    };

    this.update = function(teacher) {
        for (i in teacherList) {
            if (teacherList[i].id == teacher.id) {
                teacherList[i] = teacher;
            }
        }
        return teacher;
    };

    this.delete = function(id) {
        for (i in teacherList) {
            if (teacherList[i].id == id) {
                teacherList.splice(i, 1);
            }
        }
    };

    this.get = function(id) {
        for (i in teacherList) {
            if (teacherList[i].id == id) {
                return teacherList[i];
            }
        }
    };

    this.searchByName = function(name){
        var teachersFound = [];
        for (i in teacherList) {
            if (teacherList[i].name.indexOf(name) > -1) {
                teachersFound.push( teacherList[i] );
            }
        }
        return teachersFound;
    };

});