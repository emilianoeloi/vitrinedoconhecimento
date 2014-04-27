/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('ProjectController', ['$scope', 'Project', 'CollegeClass', function($scope, Project, CollegeClass) {
    $scope.projectList = Project.query();
    $scope.collegeClassList = CollegeClass.query();

    var loadProjectList = function(){
        Project.query(function(data){
            $scope.projectList = data;
        });
    }

    $scope.save = function() {
        if ($scope.newProject.id) {
            Project.update($scope.newProject, loadProjectList);
        } else {
            Project.insert($scope.newProject, loadProjectList);
        }
        $scope.newProject = {};
    }

    $scope.delete = function(id) {

        Project.remove(id);
        if ($scope.newProject.id == id)
            $scope.newProject = {};
    }

    $scope.edit = function(id) {
        var editProject = Project.get({
            _id: id
        }, function(data) {
            $scope.newProject = angular.copy(data);
            $scope.newProject.collegeClass = _.find($scope.collegeClassList, function (collegeClass) {
                return collegeClass.id === data.id;
            });
            loadProjectList();
        });

    }

}]);