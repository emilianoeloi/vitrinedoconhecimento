/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('PeriodController', ['$scope', 'Period', 'Course', function($scope, Period, Course) {
        
        $scope.periodList = Period.query();
        $scope.courseList = Course.query();

        $scope.checkSelectedCourse = function(id){
            if($scope.newPeriod){
                return ($scope.newPeriod && $scope.newPeriod.course && $scope.newPeriod.course.id == id);
            }else{
                return false;
            }
        }

        $scope.save = function() {
            if ($scope.newPeriod.id) {
                Period.update($scope.newPeriod);
            } else {
                Period.insert($scope.newPeriod);
            }
            $scope.newPeriod = {};
        }

        $scope.delete = function(id) {

            Course.remove(id);
            if ($scope.newPeriod.id == id)
                $scope.newPeriod = {};
        }

        $scope.edit = function(id) {
            Period.get({
                _id: id
            }, function(data) {
                console.log('edit',data);
                $scope.newPeriod = angular.copy(data);
                $scope.newPeriod.course = _.find($scope.courseList, function (course) {
                    return course.id === data.id;
                });
            });
        }

    }]);