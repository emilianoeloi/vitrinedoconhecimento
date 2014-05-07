/**
 * Created by emilianoeloi on 4/27/14.
 */
vdcControllers.controller('IdeaController', ['$scope', 'Idea', 'Course', function($scope, Idea, Course) {
    $scope.ideaList = Idea.query();
    $scope.courseList = Course.query();

    var loadIdeaList = function(){
        Idea.query(function(data){
            $scope.ideaList = data;
        });
    }

    $scope.save = function() {
        if ($scope.newIdea.id) {
            Idea.update($scope.newIdea, loadIdeaList);
        } else {
            Idea.insert($scope.newIdea, loadIdeaList);
        }
        $scope.newIdea = {};
    }

    $scope.delete = function(id) {

        Idea.remove(id);
        if ($scope.newIdea.id == id)
            $scope.newIdea = {};
    }

    $scope.edit = function(id) {
        var editIdea = Idea.get({
            _id: id
        }, function(data) {
            $scope.newIdea = angular.copy(data);
            $scope.newIdea.course = _.find($scope.courseList, function (course) {
                return course.id === data.id;
            });
            loadIdeaList();
        });

    }

}]);