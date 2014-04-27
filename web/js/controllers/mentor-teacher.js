/**
 * Created by emilianoeloi on 4/27/14.
 */
/**
 * Created by emilianoeloi on 4/27/14.
 */
vdcControllers.controller('MentorTeacherController', ['$scope', 'MentorTeacher', function($scope, MentorTeacher) {
    $scope.mentorTeacherList = MentorTeacher.query();

    var loadMentorTeacherList = function(){
        MentorTeacher.query(function(data){
            $scope.mentorTeacherList = data;
        });
    }

    $scope.save = function() {
        if ($scope.newMentorTeacher.id) {
            MentorTeacher.update($scope.newMentorTeacher, loadMentorTeacherList);
        } else {
            MentorTeacher.insert($scope.newMentorTeacher, loadMentorTeacherList);
        }
        $scope.newMentorTeacher = {};
    }

    $scope.delete = function(id) {

        MentorTeacher.remove(id);
        if ($scope.newMentorTeacher.id == id)
            $scope.newMentorTeacher = {};
    }

    $scope.edit = function(id) {
        var editMentorTeacher = MentorTeacher.get({
            _id: id
        }, function(data) {
            $scope.newMentorTeacher = angular.copy(data);
            loadMentorTeacherList();
        });

    }

}]);