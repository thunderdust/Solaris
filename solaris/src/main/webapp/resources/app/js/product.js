$(document).ready(function() {
	//switchActiveTab('nav-product');
	$('#product-add-button').click(Solaris.addProduct);
});

Solaris.addProduct = function(evt){
	var formData = $('#product-add-form').serializeObject();
	/* for multiple selection data field, modify single selection to an array with 1 object inside*/
	if (typeof(formData.card_reader_type)=='string'){
		formData.card_reader_type = [formData.card_reader_type];
	}
	if (typeof(formData.image)=='string'){
		formData.image = [formData.image];
	}
	/* Convert checkbox value to boolean value */
	if (formData.isTouchScreen!= null){
		formData.isTouchScreen = true;
	}
	else {
		formData.isTouchScreen = false;
	}

	if (formData.hasTrackPoint!= null){
		formData.hasTrackPoint = true;
	}
	else {
		formData.hasTrackPoint = false;
	}

	if (formData.hasFrontCamera!= null){
		formData.hasFrontCamera = true;
	}
	else {
		formData.hasFrontCamera = false;
	}

	if (formData.hasVGAPort!= null){
		formData.hasVGAPort = true;
	}
	else {
		formData.hasVGAPort = false;
	}

	if (formData.hasHDMIPort!= null){
		formData.hasHDMIPort = true;
	}
	else {
		formData.hasHDMIPort = false;
	}

	if (formData.hasBag!= null){
		formData.hasBag = true;
	}
	else {
		formData.hasBag = false;
	}

	if (formData.officeSuiteVersion !=null && formData.officeSuiteVersion == 'NULL'){
		formData.officeSuiteVersion = null;
	}

	formData.imagePath = [$('#imagePath').val()];

	var url = 'products-add/addLaptop';
	console.log(JSON.stringify(formData));

	$.ajax({
		url: url,
		data: JSON.stringify(formData),
		type: 'POST',
		contentType: "application/json",
		xhrFields: {
	      withCredentials: true
	   }
	}).done(function(){
		console.log("add new product successfully");
		// notify message
	});
}

// JS is only used to add the <div>s
var switches = document.querySelectorAll('input[type="checkbox"].ios-switch');

for (var i=0, sw; sw = switches[i++]; ) {
	var div = document.createElement('div');
	div.className = 'switch';
	sw.parentNode.insertBefore(div, sw.nextSibling);
}