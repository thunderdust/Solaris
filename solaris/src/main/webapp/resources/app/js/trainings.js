$(document).ready(function() {
	var initPage = function() {

        Solaris.dataTable = $('#score-table').DataTable({
        	responsive : true,
        	'serverSide' : true,
        	'ajax' : {
        		url : 'trainings/findAllScores',
        		type : 'POST',
        		contentType : 'application/json',
        		data : function(d){
        			// send only data required by backend API
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
        	  { data: 'employeeName'},
        	  { data: 'testType'},
        	  { data: 'testId'},
        	  { data: 'score'},
        	  { data: 'date'}
        	],
        	select: "single"
        });
	};
	initPage();
});
