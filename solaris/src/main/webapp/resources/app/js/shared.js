var Solaris = {};
var footerStatus = 'shown';

jQuery.fn.serializeObject = function() {
	var arrayData, objectData;
	arrayData = this.serializeArray();
	objectData = {};

	$.each(arrayData, function() {
		var value;

		if (this.value != null) {
			value = this.value;
		} else {
			value = '';
		}

		if (objectData[this.name] != null) {
			if (!objectData[this.name].push) {
				objectData[this.name] = [ objectData[this.name] ];
			}

			objectData[this.name].push(value);
		} else {
			objectData[this.name] = value;
		}
	});

	return objectData;
};

$.extend( $.fn.dataTable.Responsive, {
    searching: false,
    ordering:  true
} );

/* Full opacity */
function showFooter() {
    // show footer if it is NOT already shown
	if (footerStatus!=='shown'){
		adjustFooterOpacity('fast', 1);
		footerStatus = 'shown';
	}
	$(window).bind('scroll', checkScroll);
};

/* Low opacity */
function hideFooter() {
	
	// hide footer if it is NOT already hidden
	if (footerStatus!=='hide'){
		adjustFooterOpacity('fast', 0.2);
		footerStatus = 'hide';
	}
	$(window).bind('scroll', checkScroll);
};

function adjustFooterOpacity(duration, opacity){
	// execute when footer exists
	if (!$.isEmptyObject($('.solaris-footer').eq(0))){
			$('.solaris-footer').fadeTo(duration, opacity);
	}
}

function checkScroll(){
	
	// Scroll to the page bottom 
	if ($(window).scrollTop() + $(window).height() > $(document).height() - 100){	
		$(window).unbind('scroll');
		showFooter();
	}
	else {
		$(window).unbind('scroll');
		hideFooter();
	}
};

function updateFooterByDocHeight(){

    // Fade footer ONLY when content is longer than window  
    if (document.documentElement.scrollHeight > document.documentElement.clientHeight){
        console.log('scrollable');
        adjustFooterOpacity('fast', 0.2);
        footerStatus = 'hidden';        
    }
    else {
        console.log('NOT scrollable');
        footerStatus = 'shown'; 
    }
    $(window).scroll(checkScroll);
}


$(document).ready(function() {
    // wait for data table loading 
	setTimeout(updateFooterByDocHeight(), 800);
});
		
