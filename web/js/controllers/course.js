/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('CourseController', ['$scope', 'Course', function($scope, Course) {
        $scope.courseList = Course.query();

        $scope.save = function() {
            if ($scope.newCourse.id) {
                Course.update($scope.newCourse);
            } else {
                Course.insert($scope.newCourse);
            }
            $scope.newCourse = {};
        }

        $scope.delete = function(id) {

            Course.remove(id);
            if ($scope.newCourse.id == id)
                $scope.newCourse = {};
        }

        $scope.edit = function(id) {
            var editCourse = Course.get({
                _id: id
            }, function(data) {
                $scope.newCourse = angular.copy(data);
            });

        }

    }]);