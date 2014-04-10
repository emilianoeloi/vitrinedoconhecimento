/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcServices.factory('Teacher', ['$resource',
    function($resource){
        return $resource('api/teachers/:_id', {}, {
            query: {
                method:'GET',
                isArray:true
            },
            update: {
                method:'PUT'
            },
            insert: {
                method: 'POST'
            },
            remove: {
                method: 'DELETE'
            }
        });
    }]);

vdcServices.factory('CollegeClass', ['$resource',
    function($resource){
        return $resource('api/collegeclasses/:_id', {}, {
            query: {
                method:'GET',
                isArray:true
            },
            update: {
                method:'PUT'
            },
            insert: {
                method: 'POST'
            },
            remove: {
                method: 'DELETE'
            }
        });
    }]);