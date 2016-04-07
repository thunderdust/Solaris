$(document).ready(function() {
	var initPage = function() {

		

        Solaris.dataTable = $('#employee-table').DataTable({
        	'serverSide' : true,
        	'ajax' : {
        		url : 'employees/findUserByRole',
        		type : 'POST',
        		contentType : 'application/json',
        		data : function(d){
        			// send only data required by backend API
        			delete(d.columns);
					delete(d.order);
					delete(d.search);
					d.role = $('#employee-role-filter').val();
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
        	  { data: 'firstName'},
        	  { data: 'lastName'},
        	  { data: 'gender'},
        	  { data: 'role'},
        	  { data: 'timeJoined'}
        	],
        	select: "single"
        });
        

        $('#employee-add-button').click(Solaris.addEmployee);
        //$('#employee-delete-button').click(BookStore.deleteEmployee);
		$('#employee-office-filter').change(function() { $('#employee-table').dataTable().fnReloadAjax(); });

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
	};

	initPage();
});

Solaris.addEmployee = function(evt) {
	var formData = $('#employee-form').serializeObject();
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
