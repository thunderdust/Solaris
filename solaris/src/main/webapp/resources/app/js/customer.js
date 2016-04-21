var resizeTask;
var timeoutThreshold = 30;
window.onresize = function(event) {
	console.log("Window resized");
	clearTimeout(resizeTask);
	resizeTask = setTimeout(reloadPage, timeoutThreshold);
}

function reloadPage() {
	// Reload from cache
	location.reload(false);
}

$(document).ready(function() {
    // switchActiveTab('nav-customer');

	 var initPage = function() {
	 	Solaris.dataTable = $('#customer-table').DataTable({
	 		'serverSide' : true,
			'ajax' : {
				url : 'customers/getAllCustomers',
				type : 'POST',
				contentType : 'application/json',
				data : function(d) {
					// send only data required by backend API
					delete (d.columns);
					delete (d.order);
					delete (d.search);
					return JSON.stringify(d);
				},
				// list of CustomerEntity defined in CustomerListEntity class
				dataSrc : "customerEntities",
				xhrFields : {
					withCredentials : true
				}
			},
			columns : [
			  { data : 'name'}, 
			  { data : 'gender'}, 
			  { data : 'birthday'}, 
			  { data : 'orderCount'}, 
			  { data : 'referralCount'}
			],
			select : "single"
	   });

		// disable delete button if nothing selected
		Solaris.dataTable.on('select', function() {
			$('#customer-delete-modal-btn').prop('disabled', false);
			$('#customer-edit-modal-btn').prop('disabled', false);
		});

		Solaris.dataTable.on('deselect', function() {
			$('#customer-delete-modal-btn').prop('disabled', true);
			$('#customer-edit-modal-btn').prop('disabled', true);
		});

		Solaris.dataTable.on('draw', function() {
			$('#customer-delete-modal-btn').prop('disabled', true);
			$('#customer-edit-modal-btn').prop('disabled', true);
		});

		/****************** [Add] modal setups ***************************/
		$('#customer-add-button').click(validateAddCustomerForm);
		
		/************************* Customer Edition setups ************************/

		// When edit button is clicked initialize the dialog
		$('#customer-edit-modal-btn').on('click', function() {
			var selectedData = Solaris.dataTable.row('.selected').data();
			console.log(selectedData);
			$('#name').val(selectedData.name);
			$('#customer-add-modal #myModalLabel').data().mode = 'update';
		});

		 // reset data when modal hides
		$('#customer-add-modal').on(
			'hidden.bs.modal', function() {
				$('#customer-add-modal #myModalLabel').data().mode = 'add';
				$('#customer-form')[0].reset();
		});
		// set default add model 
		$('#customer-add-modal #myModalLabel').data().mode = 'add';
		currentDataMode = 'add';

	   $('#customer-delete-button').click(Solaris.deleteCustomer);
	   $('#customer-brand-filter').change(function() {
	   	$('#customer-table').dataTable().fnReloadAjax();
	   });
	};

	initPage();
});

function validateAddCustomerForm() {
	var compulsory_inputs = document.getElementsByClassName('compulsory-input');
	var empty_count = 0;
	for ( var key in compulsory_inputs) {
		if (compulsory_inputs.hasOwnProperty(key) && key.length > 2) {
         // Check for empty fields
			if (!(compulsory_inputs[key]).value) {
				console.log(key);
			   // console.log((compulsory_inputs[key]).type);
			   var missing_input = compulsory_inputs[key];
			   missing_input.style.borderColor = "red";
			   empty_count++;
		   } else {
		   	compulsory_inputs[key].style.borderColor = "#ccc";
		   }
	   }
   }
	if (empty_count > 0) {
		alert("One or more required input fields are not filled, please check again.");
	} else {
		Solaris.addCustomer();
	}
};

Solaris.addCustomer = function(evt) {
	var formData = $('#customer-form').serializeObject();
	if (typeof (formData.card_reader_type) == 'string') {
		formData.card_reader_type = [ formData.card_reader_type ];
	}
	if (typeof (formData.image) == 'string') {
		formData.image = [ formData.image ];
	}
	/* Convert checkbox value to boolean value */
	if (formData.isTouchScreen != null) {
		formData.isTouchScreen = true;
	} else {
		formData.isTouchScreen = false;
	}
	if (formData.hasTrackPoint != null) {
		formData.hasTrackPoint = true;
	} else {
		formData.hasTrackPoint = false;
	}
   if (formData.hasFrontCamera != null) {
   	formData.hasFrontCamera = true;
   } else {
   	formData.hasFrontCamera = false;
   }
   if (formData.hasVGAPort != null) {
   	formData.hasVGAPort = true;
   } else {
   	formData.hasVGAPort = false;
   }
		 
	var url = 'customers/' + $('#customer-form #myModalLabel').data().mode + 'Customer';

	console.log(JSON.stringify(formData));
	$.ajax({
		url : url,
		data : JSON.stringify(formData),
		type : 'POST',
		contentType : "application/json",
		xhrFields : {
			withCredentials : true
		}
	}).done(function() {
		console.log("add new customer successfully");
		$('#customer-add-modal').modal('hide');
		$('#customer-table').dataTable().fnReloadAjax();
	   });
};

Solaris.deleteCustomer = function(evt) {
	var selectedEmail = Solaris.dataTable.data()[Solaris.dataTable.row('.selected')[0]].email;
	$.ajax({
		url : "customers/deleteCustomer?email=" + selectedEmail,
		type : 'DELETE',
		xhrFields : {
			withCredentials : true
		}
	}).done(function() {
		$('#customer-delete-modal').modal('hide');
		$('#customer-table').dataTable().fnReloadAjax();
	});
};