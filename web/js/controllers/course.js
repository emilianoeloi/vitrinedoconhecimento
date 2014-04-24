/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('CourseController', ['$scope', 'Course', function ($scope, Course) {
    $scope.courseList = Course.query();

    var reloadCourseList = function () {
        Course.query(function (data) {
            $scope.courseList = data;
        });
    }

    $scope.save = function () {

        if ($scope.newCourse.id) {
            Course.update($scope.newCourse, reloadCourseList);
        } else {
            Course.insert($scope.newCourse, reloadCourseList);
        }
        $scope.newCourse = {};

    }

    $scope.delete = function (id) {

        Course.remove(id);
        if ($scope.newCourse.id == id)
            $scope.newCourse = {};
    }

    $scope.edit = function (id) {
        var editCourse = Course.get({
            _id: id
        }, function (data) {
            $scope.newCourse = angular.copy(data);
            reloadCourseList();
        });
        Course.query(function (data) {
            $scope.courseList = data;
        });
    }

}]);