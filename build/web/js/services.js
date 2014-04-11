/**
 * Created by emiliano.barbosa on 08/04/14.
 */
vdcServices.factory('CollegeClass', ['$resource',
    function($resource) {
        return $resource('api/collegeclasses/:_id', {}, {
            query: {
                method: 'GET',
                isArray: true
            },
            update: {
                method: 'PUT'
            },
            insert: {
                method: 'POST'
            },
            remove: {
                method: 'DELETE'
            },
            search: {
                method: 'GET'
            }
        });
    }]);

vdcServices.factory('Student', ['$resource',
    function($resource) {
        return $resource('api/students/:_id', {}, {
            query: {
                method: 'GET',
                isArray: true
            },
            update: {
                method: 'PUT'
            },
            insert: {
                method: 'POST'
            },
            remove: {
                method: 'DELETE'
            },
            search: {
                method: 'GET'
            }
        });
    }]);