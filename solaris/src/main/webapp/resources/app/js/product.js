$(document).ready(function() {
	//switchActiveTab('nav-product');
	//$('#product-add-button').click(Solaris.addProduct);

	initPage();


	/* After certain short time of window resize, reload page to let the table adjust itself. */
	var resizeTask;
	var timeoutThreshold = 30;
	window.onresize = function(event) {
		console.log("Window resized");
		clearTimeout(resizeTask);
		resizeTask = setTimeout(reloadPage, timeoutThreshold);
	}
});

function reloadPage() {
		// Reload from cache
		location.reload(false);
}

function validateAddProductForm() {

	var compulsory_inputs = document.getElementsByClassName('compulsory-input');
	var empty_count = 0;
	for ( var key in compulsory_inputs) {
		// Exlude the index keys objects 
		// && key.length >2 && key!="item" && key!="length" && key!="namedItem"
		if (compulsory_inputs.hasOwnProperty(key) && key.length > 2) {
			// Check for empty fields 
			if (!(compulsory_inputs[key]).value) {
				console.log(key);
				//console.log((compulsory_inputs[key]).type);
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
		Solaris.addProduct();
	}
}

var initPage = function() {

	Solaris.dataTable = $('#product-table').DataTable({
		'serverSide' : true,
		'ajax' : {
			url : 'products/getAllLaptops',
			type : 'POST',
			contentType : "application/json",
			data : function(d) {
				// send only data required by backend API
				delete (d.columns);
				delete (d.order);
				delete (d.search);
				d.brand = $('#product-brand-filter').val();
				return JSON.stringify(d);
			},
			// list of LaptopEntity defined in LaptopListEntity class
			dataSrc : "laptopEntities",
			xhrFields : {
				withCredentials : true
			}
		},
		columns : [ {
			data : 'name'
		}, {
			data : 'brand'
		}, {
			data : 'cpu'
		}, {
			data : 'gpu'
		}, {
			data : 'hddSize'
		}, {
			data : 'price'
		} ],
		select : "single"
	});

	$('#product-add-button').click(validateAddProductForm);
	$('#product-delete-button').click(Solaris.deleteProduct);
	$('#product-brand-filter').change(function() {
		$('#product-table').dataTable().fnReloadAjax();
	});

	// disable delete button if nothing selected
	Solaris.dataTable.on('select', function() {
		$('#product-open-delete-modal-btn').prop('disabled', false);
		$('#product-edit-modal-btn').prop('disabled', false);
	});

	Solaris.dataTable.on('deselect', function() {
		$('#product-delete-modal-btn').prop('disabled', true);
		$('#product-edit-modal-btn').prop('disabled', true);
	});

	Solaris.dataTable.on('draw', function() {
		$('#product-delete-modal-btn').prop('disabled', true);
		$('#product-edit-modal-btn').prop('disabled', true);
	});

	// When edit button is clicked initialize the dialog
	$('#product-edit-modal-btn').on(
			'click',
			function() {
				var selectedData = Solaris.dataTable.row('.selected').data();
				$('#id').prop('readonly', true)
				$('#product-add-modal #myModalLabel').data().mode = 'update';
				$('#product-add-modal #myModalLabel').html('Edit Product');
				$('#id').val(selectedData.id);
				$('#first-name').val(selectedData.firstName);
				$('#last-name').val(selectedData.lastName);
				$('#email').val(selectedData.email);
				$('#roles').val(selectedData.roles);
				$(
						'#office option[data-display='
								+ selectedData.officeName + ']').attr(
						'selected', 'selected');
				// $('#password').val(selectedData.password);
			});

	// reset data when modal hides
	$('#product-add-modal').on('hidden.bs.modal', function() {
		$('#id').prop('readonly', false);
		$('#product-add-modal #myModalLabel').data().mode = 'add';
		$('#product-add-modal #myModalLabel').html('Add new product');
		$('#product-form')[0].reset();
	});
	// default method for the add model is add (instead of edit)
	//$('#product-add-modal #myModalLabel').data().mode = 'add';
}

Solaris.addProduct = function(evt) {
	var formData = $('#product-add-form').serializeObject();
	/* for multiple selection data field, modify single selection to an array with 1 object inside*/
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

	if (formData.hasHDMIPort != null) {
		formData.hasHDMIPort = true;
	} else {
		formData.hasHDMIPort = false;
	}

	if (formData.hasBag != null) {
		formData.hasBag = true;
	} else {
		formData.hasBag = false;
	}

	if (formData.officeSuiteVersion != null
			&& formData.officeSuiteVersion == 'NULL') {
		formData.officeSuiteVersion = null;
	}

	formData.imagePath = [ $('#imagePath').val() ];
	var url = 'products/' + $('#product-add-modal #myModalLabel').data().mode
			+ 'Laptop';

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
		console.log("add new product successfully");
		// notify message
	});
}

// JS is only used to add the <div>s
var switches = document.querySelectorAll('input[type="checkbox"].ios-switch');

for (var i = 0, sw; sw = switches[i++];) {
	var div = document.createElement('div');
	div.className = 'switch';
	sw.parentNode.insertBefore(div, sw.nextSibling);
}