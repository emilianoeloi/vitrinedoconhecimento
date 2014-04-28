/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcControllers.controller('CollegeClassController', ['$scope', 'CollegeClass', 'Period', 'MentorTeacher', function ($scope, CollegeClass, Period, MentorTeacher) {
    $scope.collegeClassList = CollegeClass.query();
    $scope.periodList = Period.query();
    $scope.mentorTeacherList = MentorTeacher.query();

    var loadCollegeClassList = function () {
        CollegeClass.query(function (data) {
            $scope.collegeClassList = data;
        });
    }

    $scope.save = function () {
        if ($scope.newCollegeClass.id) {
            CollegeClass.update($scope.newCollegeClass, loadCollegeClassList);
        } else {
            CollegeClass.insert($scope.newCollegeClass, loadCollegeClassList);
        }
        $scope.newCollegeClass = {};
    }

    $scope.delete = function (id) {
        CollegeClass.remove(id);
        if ($scope.newCollegeClass.id == id)
            $scope.newCollegeClass = {};
    }

    $scope.edit = function (id) {
        var editCollegeClass = CollegeClass.get({
            _id: id
        }, function (data) {
            $scope.newCollegeClass = angular.copy(data);
            $scope.newCollegeClass.period = _.find($scope.periodList, function (period) {
                return period.id === data.id;
            });
            $scope.newCollegeClass.mentorTeacher = _.find($scope.mentorTeacherList, function (mentorTeacher) {
                return mentorTeacher.id === data.id;
            });
            loadCollegeClassList();
        });

    }

}]);