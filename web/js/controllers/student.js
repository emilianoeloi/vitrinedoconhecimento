/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('StudentController', ['$scope', 'Student', function($scope, Student) {
    $scope.studentList = Student.query();

    $scope.save = function () {
        if($scope.newStudent.id){
            Student.update($scope.newStudent);
        }else{
            Student.insert($scope.newStudent);
        }
        $scope.newStudent = {};
    }

    $scope.delete = function (id) {

        Student.remove({_id: id}, function(){ alert('excluido')} );
        if ($scope.newStudent.id == id) $scope.newStudent = {};
    }

    $scope.edit = function (id) {
        var editStudent = Student.get({
            _id: id
        }, function(data){ 
            $scope.newStudent = angular.copy(data);
        });
        
    }

}]);