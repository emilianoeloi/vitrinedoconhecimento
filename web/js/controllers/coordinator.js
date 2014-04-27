/**
 * Created by emilianoeloi on 4/27/14.
 */
vdcControllers.controller('CoordinatorController', ['$scope', 'Coordinator', 'Course', function($scope, Coordinator, Course) {
    $scope.coordinatorList = Coordinator.query();
    $scope.courseList = Course.query();

    var loadCoordinatorList = function(){
        Coordinator.query(function(data){
            $scope.coordinatorList = data;
        });
    }

    $scope.save = function() {
        if ($scope.newCoordinator.id) {
            Coordinator.update($scope.newCoordinator, loadCoordinatorList);
        } else {
            Coordinator.insert($scope.newCoordinator, loadCoordinatorList);
        }
        $scope.newCoordinator = {};
    }

    $scope.delete = function(id) {

        Coordinator.remove(id);
        if ($scope.newCoordinator.id == id)
            $scope.newCoordinator = {};
    }

    $scope.edit = function(id) {
        var editCoordinator = Coordinator.get({
            _id: id
        }, function(data) {
            $scope.newCoordinator = angular.copy(data);
            $scope.newCoordinator.course = _.find($scope.courseList, function (course) {
                return course.id === data.id;
            });
            loadCoordinatorList();
        });

    }

}]);