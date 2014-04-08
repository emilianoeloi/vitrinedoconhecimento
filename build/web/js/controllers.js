/**
 * Created by emiliano.barbosa on 08/04/14.
 */
var vdcControllers = angular.module('vdcControllers', []);

vdcControllers.controller('TeacherController', ['$scope', 'Teacher', function($scope, Teacher) {
    $scope.teacherList = Teacher.query();

    $scope.save = function () {
        var teacherFound = Teacher.get({
            _id: $scope.newTeacher.id
        });
        if(teacherFound !== null){
            Teacher.update($scope.newTeacher);
        }else{
            Teacher.insert($scope.newTeacher);
        }
        $scope.newTeacher = {};
    }

    $scope.delete = function (id) {

        Teacher.remove(id);
        if ($scope.newTeacher.id == id) $scope.newTeacher = {};
    }

    $scope.edit = function (id) {
        $scope.newTeacher = angular.copy(Teacher.get({
            _id: id
        }));
    }

}]);