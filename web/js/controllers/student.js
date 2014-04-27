/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('StudentController', ['$scope', 'Student', 'Project', function($scope, Student, Project) {
    $scope.studentList = Student.query();
    $scope.projectList = Project.query();

    var loadStudentList = function(){
        Student.query(function(data){
            $scope.studentList = data;
        });
    }

    $scope.save = function() {
        if ($scope.newStudent.id) {
            Student.update($scope.newStudent, loadStudentList);
        } else {
            Student.insert($scope.newStudent, loadStudentList);
        }
        $scope.newStudent = {};
    }

    $scope.delete = function(id) {

        Student.remove(id);
        if ($scope.newStudent.id == id)
            $scope.newStudent = {};
    }

    $scope.edit = function(id) {
        var editStudent = Student.get({
            _id: id
        }, function(data) {
            $scope.newStudent = angular.copy(data);
            $scope.newStudent.project = _.find($scope.projectList, function (project) {
                return project.id === data.id;
            });
            loadStudentList();
        });

    }

}]);