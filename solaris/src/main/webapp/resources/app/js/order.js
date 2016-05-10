/*
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
*/

var currentDataMode = 'add';

$(document).ready(function() {
    // switchActiveTab('nav-order');
	 // $('#order-add-button').click(Solaris.addOrder);

	 var initPage = function() {
	 	Solaris.dataTable = $('#order-table').DataTable({
	 		'serverSide' : true,
			'ajax' : {
				url : 'orders/getAllOrders',
				type : 'POST',
				contentType : 'application/json',
				data : function(d) {
					// send only data required by backend API
					d.searchParam = d.search.value;
					delete (d.columns);
					delete (d.order);
					delete (d.search);
					//d.brand = $('#order-brand-filter').val();
					return JSON.stringify(d);
				},
				// list of LaptopEntity defined in LaptopListEntity class
				dataSrc : "orderEntities",
				xhrFields : {
					withCredentials : true
				}
			},
			columns : [
			  { data : 'clientName'}, 
			  { data : 'laptopName'}, 
			  { data : 'quantity'}, 
			  { data : 'price'}, 
			  { data : 'deliveryDeadline'}, 
			  { data : 'createdDate'} 
			],
			select : "single",
			filter : true
	   });

		// disable delete button if nothing selected
		Solaris.dataTable.on('select', function() {
			$('#order-delete-modal-btn').prop('disabled', false);
			$('#order-edit-modal-btn').prop('disabled', false);
		});

		Solaris.dataTable.on('deselect', function() {
			$('#order-delete-modal-btn').prop('disabled', true);
			$('#order-edit-modal-btn').prop('disabled', true);
		});

		Solaris.dataTable.on('draw', function() {
			$('#order-delete-modal-btn').prop('disabled', true);
			$('#order-edit-modal-btn').prop('disabled', true);
		});

		/****************** order [Add] modal setups ***************************/
		$('#order-add-button').click(validateAddOrderForm);
		
		/************************* order Edition setups ************************/

		// When edit button is clicked initialize the dialog
		$('#order-edit-modal-btn').on('click', function() {
			var selectedData = Solaris.dataTable.row('.selected').data();
			console.log('selected: ' + JSON.stringify(selectedData));
			//$('#order-add-modal #myModalLabel').data().mode = 'update';
			currentDataMode = 'update';
			$('#order_id').val(selectedData.id);
			$('#order_id').prop('readonly', true);
			$('#order_id_div').show();
			$('#client_name').val(selectedData.clientName);
			$('#client_email').val(selectedData.clientEmail);
			$('#laptop_name').val(selectedData.laptopName);
			$('#quantity').val(selectedData.quantity);
			$('#price').val(selectedData.price);
			$('#delivery_deadline').val(selectedData.deliveryDeadline);
			$('#created_date').val(selectedData.createdDate);
			$('#seller_id').val(selectedData.sellerId);
		});

		 // reset data when modal hides
		$('#order-add-modal').on(
			'hidden.bs.modal', function() {
				//$('#order-add-modal #myModalLabel').data().mode = 'add';
				currentDataMode = 'add';
				$('#order-form')[0].reset();
				//Remove error input class, reset compulsory input border color
				resetCompulsoryInputStyle();
		});
		// set default add model 
		//$('#order-add-modal #myModalLabel').data().mode = 'add';
		currentDataMode = 'add';

	   $('#order-delete-button').click(Solaris.deleteOrder);
	   $('#order-brand-filter').change(function() {
	   	$('#order-table').dataTable().fnReloadAjax();
	   });

	   //Hide order id input
	   $('#order_id_div').hide();
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

function validateAddOrderForm() {
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
		Solaris.addOrder();
	}
};

Solaris.addOrder = function(evt) {
	var formData = $('#order-form').serializeObject();
		 
	//var url = 'orders/' + $('#order-form #myModalLabel').data().mode + 'Order';
	var url = 'orders/' + currentDataMode + 'Order';
    console.log(url);
	console.log('Form data: ' + JSON.stringify(formData));
	$.ajax({
		url : url,
		data : JSON.stringify(formData),
		type : 'POST',
		contentType : "application/json",
		xhrFields : {
			withCredentials : true
		}
	}).done(function() {
		console.log(currentDataMode + " order successfully");
		$('#order-add-modal').modal('hide');
		//$('#order-table').dataTable().fnReloadAjax();
		location.reload(false);
	   });
};

Solaris.deleteOrder = function(evt) {
	var selectedId = Solaris.dataTable.data()[Solaris.dataTable.row('.selected')[0]].id;
	$.ajax({
		url : "orders/deleteOrder?id=" + selectedId,
		type : 'DELETE',
		xhrFields : {
			withCredentials : true
		}
	}).done(function() {
		$('#order-delete-modal').modal('hide');
		//$('#order-table').dataTable().fnReloadAjax();
		location.reload(false);
	});
};