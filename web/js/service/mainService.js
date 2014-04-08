/**
 * Created by emiliano.barbosa on 08/04/14.
 */
angularApp.service('MainService', function(TeacherService) {
    this.searchTeacher = function(wordKey) {
        return TeacherService.searchByName(wordKey);
    };
    this.saveTeacher = function(teacher) {
        if(TeacherService.get(teacher.id) != null){
            return TeacherService.update(teacher);
        }else{
            return TeacherService.insert(teacher);
        }
    };
    this.listTeachers = function(){
        return TeacherService.list();
    }
    this.deleteTeacher = function(id){
        return TeacherService.delete(id);
    }
    this.getTeacher = function(id){
        return TeacherService.get(id);
    }
});