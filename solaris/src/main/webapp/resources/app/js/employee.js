$(document).ready(function() {
	var initPage = function() {

		$('#employee-add-button').click(Solaris.addEmployee);
		
        
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
	// modify role object to become an object if only one is selected
	if (typeof(formData.roles) === 'string') {
		formData.roles = [formData.roles];
	}
	
	var url = 'employees/' + $('#employee-add-modal #myModalLabel').data().mode + 'UserAccount';
	console.log(url);

	$.ajax({
		url : url,
		data : JSON.stringify(formData),
		type : 'POST',
		contentType : "application/json",
		xhrFields: {
	      withCredentials: true
	   }
	}).done(function() {
		$('#employee-add-modal').modal('hide');
		//$('#employee-table').dataTable().fnReloadAjax();
		console.log('DONE');
		
	});
};
