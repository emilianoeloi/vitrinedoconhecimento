/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('CollegeClassController', ['$scope', 'CollegeClass', function($scope, CollegeClass) {
        $scope.collegeClassList = CollegeClass.query();

        $scope.periods = [
            {periodDescription: '1 Período', id: '1'},
            {periodDescription: '2 Período', id: '2'},
            {periodDescription: '3 Período', id: '3'},
            {periodDescription: '4 Período', id: '4'},
            {periodDescription: '5 Período', id: '5'}
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