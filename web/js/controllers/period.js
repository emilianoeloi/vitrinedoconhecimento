/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('PeriodController', ['$scope', 'Period', 'Course', function($scope, Period, Course) {
        
        $scope.periodList = Period.query();
        $scope.courseList = Course.query();
        
        /*$scope.courses = [
            {name: 'Gastronomia', id: '1'},
            {name: 'ADS', id: '2'},
            {name: 'Pilotagem', id: '3'}
        ];*/

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
            var editPeriod = Period.get({
                _id: id
            }, function(data) {
                $scope.newPeriod = angular.copy(data);
            });

        }

    }]);