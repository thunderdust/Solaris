$(document).ready(function() {
	var initPage = function() {

        Solaris.dataTable = $('#employee-table').DataTable({
        	'serverSide' : true,
        	'ajax' : {
        		url : 'employees/findAllUsers',
        		type : 'POST',
        		contentType : 'application/json',
        		data : function(d){
        			// send only data required by backend API
        			delete(d.columns);
					delete(d.order);
					delete(d.search);
					d.roles = $('#employee-role-filter').val();
					console.log(JSON.stringify(d));
					return JSON.stringify(d);
        		},
        		// list of EmployeeEntity defined in EmployeeListEntity class
        		dataSrc : "employeeEntities",
        		xhrFields: {
				      withCredentials: true
				   }
        	},
        	columns : [
        	  { data: 'id'},
        	  { data: 'firstName'},
        	  { data: 'lastName'},
        	  { data: 'gender'}
        	],
        	select: "single"
        });
        

        $('#employee-add-button').click(Solaris.addEmployee);
        $('#employee-delete-button').click(Solaris.deleteEmployee);
		//$('#employee-office-filter').change(function() { $('#employee-table').dataTable().fnReloadAjax(); });

        // disable delete button if nothing selected
		Solaris.dataTable.on('select', function () {
			$('#employee-open-delete-modal-btn').prop('disabled', false);
			$('#employee-edit-modal-btn').prop('disabled', false);
	    });
		
		Solaris.dataTable.on('deselect', function () {
			$('#employee-open-delete-modal-btn').prop('disabled', true);
			$('#employee-edit-modal-btn').prop('disabled', true);
	    });
		
		Solaris.dataTable.on('draw', function() {
			$('#employee-open-delete-modal-btn').prop('disabled', true);
			$('#employee-edit-modal-btn').prop('disabled', true);
		});

		// reset data when modal hides
        $('#employee-add-modal').on('hidden.bs.modal', function() {
        	$('#id').prop('readonly',false);
            $('#employee-add-modal #myModalLabel').data().mode = 'add';
            $('#employee-add-modal #myModalLabel').html('Add new employee');
            $('#employee-form')[0].reset();
        });

		 $('#employee-add-modal #myModalLabel').data().mode = 'add';
        
        /* After certain short time of window resize, reload page to let the table adjust itself. */
        var resizeTask;
        var timeoutThreshold = 30;
		window.onresize = function(event){
			console.log("Window resized");
			clearTimeout(resizeTask);
			resizeTask = setTimeout(reloadPage, timeoutThreshold);
		}

		function reloadPage(){
			// Reload from cache
			location.reload(false);
		}
	};

	initPage();
});

Solaris.addEmployee = function(evt) {
	var formData = $('#employee-form').serializeObject();
	// convert single role string to an object 
	if (typeof(formData.roles === 'string')){
		formData.roles = [formData.roles];
	}
	var url = 'employees/' + $('#employee-add-modal #myModalLabel').data().mode + 'UserAccount';
	console.log(url);
	console.log(JSON.stringify(formData));

	$.ajax({
		url : url,
		data : JSON.stringify(formData),
		type : 'POST',
		contentType : "application/json",
		xhrFields: {
	      withCredentials: true
	   }
	}).done(function() {
		console.log('DONE');
		$('#employee-add-modal').modal('hide');
		$('#employee-table').dataTable().fnReloadAjax();
	});
};

Solaris.deleteEmployee = function(event){
	var selectedEmployeeID = Solaris.dataTable.data()[Solaris.dataTable.row('.selected')[0]].id;
	$.ajax({
		url: "employees/deleteUser?userID=" + selectedEmployeeID,
		type : 'DELETE',
		xhrFields: {
	      withCredentials: true
	   }
	}).done(function(){
		// Once deletion is done, hide confrim prompt and refresh data
		$('#employee-delete-modal').modal('hide');
		$('#employee-table').dataTable().fnReloadAjax();
	});
}
