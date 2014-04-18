/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('CollegeClassController', ['$scope', 'CollegeClass', function($scope, CollegeClass) {
        $scope.collegeClassList = CollegeClass.query();

        $scope.periods = [
            {name: '1 Período', id: '1'},
            {name: '2 Período', id: '2'},
            {name: '3 Período', id: '3'},
            {name: '4 Período', id: '4'},
            {name: '5 Período', id: '5'}
        ];
        
        $scope.courses = [
            {name: 'Gastronomia', id: '1'},
            {name: 'ADS', id: '2'},
            {name: 'Pilotagem', id: '3'}
        ];

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
            });

        }

    }]);