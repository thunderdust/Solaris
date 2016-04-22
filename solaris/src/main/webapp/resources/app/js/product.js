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
    // switchActiveTab('nav-product');
	 // $('#product-add-button').click(Solaris.addProduct);

	 var initPage = function() {
	 	Solaris.dataTable = $('#product-table').DataTable({
	 		'serverSide' : true,
			'ajax' : {
				url : 'products/getAllLaptops',
				type : 'POST',
				contentType : 'application/json',
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
			columns : [
			  { data : 'name'}, 
			  { data : 'brand'}, 
			  { data : 'cpu'}, 
			  { data : 'gpu'}, 
			  { data : 'hddSize'}, 
			  { data : 'price'} 
			],
			select : "single"
	   });

		// disable delete button if nothing selected
		Solaris.dataTable.on('select', function() {
			$('#product-delete-modal-btn').prop('disabled', false);
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

		/****************** Product [Add] modal setups ***************************/
		$('#product-add-button').click(validateAddProductForm);
		
		/************************* Product Edition setups ************************/

		// When edit button is clicked initialize the dialog
		$('#product-edit-modal-btn').on('click', function() {
			var selectedData = Solaris.dataTable.row('.selected').data();
			console.log(selectedData);
			$('#name').val(selectedData.name);
			//$('#name').prop('readonly', true);
			$('#product-add-modal #myModalLabel').data().mode = 'update';
			$('#brand option[data-display=' + selectedData.brand + ']').attr('selected', 'selected');
			$('#publish_date').val(selectedData.publishDate);
			$('#price').val(selectedData.price);
			$('#laptop_width').val(selectedData.laptop_width);
			$('#laptop_length').val(selectedData.laptop_length);
			$('#laptop_height').val(selectedData.laptop_height);
			$('#laptop_weight').val(selectedData.laptop_weight);
			$('#screen_size').val(selectedData.screenSize);
			$('#operating_system').val(selectedData.os);
         $('#antivirus').val(selectedData.antivirusSoftware);
			$('#cpu').val(selectedData.cpu);
			$('#ram_size').val(selectedData.ramSize);
			$('#hdd_model').val(selectedData.hddModel);
			$('#hdd_size').val(selectedData.hddSize);
			$('#resolution_horizontal').val(selectedData.resolutionHorizontal);
			$('#resolution_vertical').val(selectedData.resolutionVertical);
			if (selectedData.touchScreen) {
				$('#touch_screen').prop('checked', true);
			} else {
				$('#touch_screen').prop('checked', false);
			}
			$('#gpu').val(selectedData.gpu);
			$('#graphics_card_type option[data-display=' + selectedData.graphicsCardType + ']').attr('selected', 'selected');
			$('#graphic_memory').val(selectedData.graphicMemory);
			$('#battery_cell').val(selectedData.batteryCells);
			$('#battery_life').val(selectedData.batteryLife);
			$('#optical_drive').val(selectedData.opticalDrive);
			$('#optical_drive_speed').val(selectedData.opticalDriveSpeed);
			if (selectedData.hasTrackPoint) {
				$('#track_point').prop('checked', true);
			} else {
				$('#track_point').prop('checked', false);
			}

			if (selectedData.hasFrontCamera) {
				$('#has_camera').prop('checked', true);
			} else {
				$('#has_camera').prop('checked', false);
			}
			$('#camera_pixel').val(selectedData.cameraPixel);
			$('#gpu').val(selectedData.gpu);
			$('#usb_port_type option[data-display=' + selectedData.usbPortType + ']').attr('selected', 'selected');
			$('#usb_2_slot').val(selectedData.usb_2_slot);
			$('#usb_3_slot').val(selectedData.usb_3_slot);
			
			if (selectedData.hasVGAPort) {
				$('#vga').prop('checked', true);
			} else {
				$('#vga').prop('checked', false);
			}

			if (selectedData.hasHDMIPort) {
				$('#hdmi').prop('checked', true);
			} else {
				$('#hdmi').prop('checked', false);
			}

			// card reader types with multiple selections
			var card_reader_type_array = selectedData.cardReaderTypes;
			for (var i = 0; i < card_reader_type_array.length; i++) {
				$('#card_reader_type option[data-display=' + card_reader_type_array[i] + ']').attr('selected', 'selected');
			}

			$('#bluetooth').val(selectedData.bluetooth);

			if (selectedData.hasBag) {
				$('#bag').prop('checked', true);
			} else {
				$('#bag').prop('checked', false);
			}

			// Image !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			$('#warranty').val(selectedData.warranty);
		});

		 // reset data when modal hides
		$('#product-add-modal').on(
			'hidden.bs.modal', function() {
				$('#product-add-modal #myModalLabel').data().mode = 'add';
				$('#product-form')[0].reset();
				//Remove error input class, reset compulsory input border color
				resetCompulsoryInputStyle();
		});
		// set default add model 
		$('#product-add-modal #myModalLabel').data().mode = 'add';
		currentDataMode = 'add';

	   $('#product-delete-button').click(Solaris.deleteProduct);
	   $('#product-brand-filter').change(function() {
	   	$('#product-table').dataTable().fnReloadAjax();
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

function validateAddProductForm() {
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
		Solaris.addProduct();
	}
};

Solaris.addProduct = function(evt) {
	var formData = $('#product-form').serializeObject();
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
       
   var imageFiles = document.getElementById('imagePath').files;
   if (imageFiles.length>0){
   	var imageFilePathArr = [];
   	for (var i=0; i<imageFiles.length; i++){
   		// Only get image name from the fake file path
   		var parts = imageFiles[i].name.split("\\");
   		imageFilePathArr[i] = parts[parts.length-1];
       }
       formData.imagePath = imageFilePathArr;
   }
   else {
       	 formData.imagePath = null;
   }
		 
	var url = 'products/' + $('#product-form #myModalLabel').data().mode + 'Laptop';
	//var url = 'products/' + 'addLaptop';

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
		$('#product-add-modal').modal('hide');
		$('#product-table').dataTable().fnReloadAjax();
	   });
};

Solaris.deleteProduct = function(evt) {
	var selectedName = Solaris.dataTable.data()[Solaris.dataTable.row('.selected')[0]].name;
	$.ajax({
		url : "products/deleteLaptop?name=" + selectedName,
		type : 'DELETE',
		xhrFields : {
			withCredentials : true
		}
	}).done(function() {
		$('#product-delete-modal').modal('hide');
		$('#product-table').dataTable().fnReloadAjax();
	});
};

// JS is only used to add the <div>s
var switches = document.querySelectorAll('input[type="checkbox"].ios-switch');
for (var i = 0, sw; sw = switches[i++];) {
	var div = document.createElement('div');
	div.className = 'switch';
	sw.parentNode.insertBefore(div, sw.nextSibling);
}