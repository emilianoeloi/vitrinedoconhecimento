/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('CollegeClassController', ['$scope', 'CollegeClass', 'Period', function($scope, CollegeClass, Period) {
        $scope.collegeClassList = CollegeClass.query();
        $scope.periodList = Period.query();

        $scope.save = function() {
            if ($scope.newCollegeClass.id) {
                CollegeClass.update($scope.newCollegeClass);
            } else {
                CollegeClass.insert($scope.newCollegeClass);
            }
            $scope.newCollegeClass = {};
        }

        $scope.delete = function(id) {

            CollegeClass.remove(id);
            if ($scope.newCollegeClass.id == id)
                $scope.newCollegeClass = {};
        }

        $scope.edit = function(id) {
            var editCollegeClass = CollegeClass.get({
                _id: id
            }, function(data) {
                $scope.newCollegeClass = angular.copy(data);
                $scope.newCollegeClass.period = _.find($scope.periodList, function (period) {
                    return period.id === data.id;
                });
            });

        }

    }]);