$(document).ready(function() {
	var initPage = function() {

        Solaris.dataTable = $('#employee-table').DataTable({
        	responsive : true,
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
        	  { data: 'gender'},
        	  { data: 'contact_number'}
        	],
        	select: "single"
        });

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
        
        /****************** Account add setups ***************************/
        $('#employee-add-button').click(validateAddEmployeeForm);
        // reset data when modal hides
        $('#employee-add-modal').on('hidden.bs.modal', function() {
        	$('#login_id').prop('readonly',false);
            $('#employee-add-modal #myModalLabel').data().mode = 'add';
            $('#employee-add-modal #myModalLabel').html('Add new employee');
            $('#employee-form')[0].reset();
            //Remove error input class, reset compulsory input border color
            resetCompulsoryInputStyle();
        });
        // set default add model 
		$('#employee-add-modal #myModalLabel').data().mode = 'add';
        /****************** Account add setups ***************************/
        


        /****************** Account Edition setups **********************/
        $('#employee-edit-modal-btn').on('click', function(){
			var selectedData = Solaris.dataTable.row('.selected').data();
		 	$('#login_id').prop('readonly',true)
            $('#employee-add-modal #myModalLabel').data().mode = 'update';
            $('#employee-add-modal #myModalLabel').html('Edit employee');
            $('#login_id').val(selectedData.id);
            $('#first-name').val(selectedData.firstName);
            $('#last-name').val(selectedData.lastName);
            $('#email').val(selectedData.email);
            $('#contact_number').val(selectedData.contact_number);
            $('#roles').val(selectedData.roles);
            //$('#office option[data-display='+selectedData.officeName+']').attr('selected', 'selected');
            //$('#password').val(selectedData.password);
		 });
        /****************** Account Edition setups **********************/


        /****************** Account Deletion setups **********************/
        $('#employee-delete-button').click(Solaris.deleteEmployee);
		/****************** Account Deletion setups **********************/


		//$('#employee-office-filter').change(function() { $('#employee-table').dataTable().fnReloadAjax(); });

		
        
        /* After certain short time of window resize, reload page to let the table adjust itself. 
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
		*/
	};

	initPage();
});

function resetCompulsoryInputStyle(){
	var compulsory_inputs = document.getElementsByClassName('compulsory-input');
	for ( var key in compulsory_inputs) {
		if (compulsory_inputs.hasOwnProperty(key) && key.length > 2) {
			compulsory_inputs[key].classList.remove("error-border");
	   }
   }
}

function validateAddEmployeeForm() {
	var compulsory_inputs = document.getElementsByClassName('compulsory-input');
	var empty_count = 0;
	for ( var key in compulsory_inputs) {
		if (compulsory_inputs.hasOwnProperty(key) && key.length > 2) {
         // Check for empty fields
			if (!(compulsory_inputs[key]).value) {
				console.log(key);
			   // console.log((compulsory_inputs[key]).type);
			   var missing_input = compulsory_inputs[key];
			   compulsory_inputs[key].classList.add("error-border");
			   empty_count++;
		   } else {
		   }
	   }
   }
	if (empty_count > 0) {
		alert("One or more required input fields are not filled, please check again.");
	} else {
		Solaris.addEmployee();
	}
};

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
