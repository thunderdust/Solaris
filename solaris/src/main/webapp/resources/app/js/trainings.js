$(document).ready(function() {
	var initPage = function() {

        Solaris.dataTable = $('#score-table').DataTable({
        	responsive : true,
        	'serverSide' : true,
        	'ajax' : {
        		url : 'trainings/findScores',
        		type : 'POST',
        		contentType : 'application/json',
        		data : function(d){
        			// send only data required by backend API
                                d.searchParam = d.search.value;
        			delete(d.columns);
				delete(d.order);
				delete(d.search);
				console.log(JSON.stringify(d));
				return JSON.stringify(d);
        		},
        		// list of EmployeeEntity defined in EmployeeListEntity class
        		dataSrc : "scoreEntities",
        		xhrFields: {
				      withCredentials: true
				   }
        	},
        	columns : [
        	  { data: 'employeeId'},
        	  { data: 'testType'},
        	  { data: 'testId'},
        	  { data: 'score'},
        	  { data: 'date'}
        	],
        	select: "single",
                filter: false,
                paging: false
        });
	};
	initPage();
});
