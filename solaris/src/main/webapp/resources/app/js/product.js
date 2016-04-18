$(document).ready(function() {
	//switchActiveTab('nav-product');
	//$('#product-add-button').click(Solaris.addProduct);
	$('#product-add-button').click(validateAddProductForm);

	initPage();
});

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

	// disable delete button if nothing selected
	BookStore.dataTable.on('select', function() {
		$('#product-open-delete-modal-btn').prop('disabled', false);
		$('#product-edit-modal-btn').prop('disabled', false);
	});

	BookStore.dataTable.on('deselect', function() {
		$('#product-delete-modal-btn').prop('disabled', true);
		$('#product-edit-modal-btn').prop('disabled', true);
	});

	BookStore.dataTable.on('draw', function() {
		$('#product-delete-modal-btn').prop('disabled', true);
		$('#product-edit-modal-btn').prop('disabled', true);
	});

	// When edit button is clicked initialize the dialog
	$('#product-edit-modal-btn').on(
			'click',
			function() {
				var selectedData = BookStore.dataTable.row('.selected').data();
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
	$('#product-add-modal #myModalLabel').data().mode = 'add';
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

	var url = 'products-add/addLaptop';
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