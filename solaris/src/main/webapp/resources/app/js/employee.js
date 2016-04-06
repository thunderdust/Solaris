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
		//$('#employee-table').dataTable().fnReloadAjax();
	});
};
