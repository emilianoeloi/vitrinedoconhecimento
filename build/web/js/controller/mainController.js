/**
 * Created by emiliano.barbosa on 08/04/14.
 */
angularApp.controller('MainController', function($scope, MainService) {

    $scope.teacherList = MainService.listTeachers();

    $scope.searchTeacher = function() {

        $scope.answer = MainService.searchTeacher($scope.wordKey);

    }

    $scope.saveTeacher = function() {

        MainService.saveTeacher($scope.newTeacher);
        $scope.newTeacher = {};

    }

    $scope.deleteTeacher = function (id) {

        MainService.deleteTeacher(id);
        if ($scope.newTeacher.id == id) $scope.newTeacher = {};

    }

    $scope.editTeacher = function (id) {

        $scope.newTeacher = angular.copy(MainService.getTeacher(id));

    }
});