$(document).ready(function() {
    // switchActiveTab('nav-customer');

	 var initPage = function() {
	 	Solaris.dataTable = $('#customer-table').DataTable({
	 		'serverSide' : true,
			'ajax' : {
				url : 'customers/show',
				type : 'POST',
				contentType : 'application/json',
				data : function(d) {
					// send only data required by backend API
					d.searchParam = d.search.value;
					delete (d.columns);
					delete (d.order);
					delete (d.search);
					console.log(JSON.stringify(d));
					return JSON.stringify(d);
				},
				// list of CustomerEntity defined in CustomerListEntity class
				dataSrc : "customerEntities"
			},
			columns : [
			  { data : 'name'}, 
			  { data : 'gender'}, 
			  { data : 'birthday'}, 
			  { data : 'email'}, 
			  { data : 'contactNumber'}, 
			  { data : 'orderCount'}, 
			  { data : 'referralCount'},
			  { data : 'address'},
			  { data : 'occupation'},
			  { data : 'salary'},
			  { data : 'registerDate'}
			],
			select : "single",
			filter: true
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
			//$('#customer-add-modal #myModalLabel').data().mode = 'update';
            // Change title
			$('#myModalLabel').html("Edit customer information");
			currentDataMode = 'update';
			$('#name').val(selectedData.name);
			$('#gender option[data-display=' + selectedData.gender + ']').attr('selected', 'selected');
			$('#birthday').val(selectedData.birthday);
			// email cannot be changed since its primary key in database
			$('#email').val(selectedData.email);
			$('#email').prop('readonly',true)
			$('#contact_number').val(selectedData.contactNumber);
			$('#order_count').val(selectedData.orderCount);
			$('#referral_count').val(selectedData.referralCount);
			$('#address').val(selectedData.address);
			$('#occupation').val(selectedData.occupation);
			$('#salary').val(selectedData.salary);
			$('#register_date').val(selectedData.registerDate);
		});

		 // reset data when modal hides
		$('#customer-add-modal').on(
			'hidden.bs.modal', function() {
				//$('#customer-add-modal #myModalLabel').data().mode = 'add';
				currentDataMode = 'add';
				$('#customer-form')[0].reset();
				// Reset title
				$('#myModalLabel').html("Add new customer");
				//Remove error input class, reset compulsory input border color
				resetCompulsoryInputStyle();
		});
		// set default add model 
		//$('#customer-add-modal #myModalLabel').data().mode = 'add';
		currentDataMode = 'add';

	   $('#customer-delete-button').click(Solaris.deleteCustomer);
	   $('#customer-brand-filter').change(function() {
	   	$('#customer-table').dataTable().fnReloadAjax();
	   });
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
			   compulsory_inputs[key].classList.add("error-border");
			   empty_count++;
		   } else {
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
	var url = 'customers/' + currentDataMode + 'Customer';
	console.log(url);

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
		console.log(currentDataMode + " customer successfully");
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
		console.log('customer deletion completed');
	});
};