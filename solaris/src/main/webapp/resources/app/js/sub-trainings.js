var currentPageIndex;
var paragraphList;
/******** Variables for footer handling migrated from shared.js ***********/
var footerStatus = 'shown';
/******** Variables for footer handling migrated from shared.js ***********/

$(document).ready(function() {
    var initPage = function() {
        paragraphList = document.getElementsByClassName('solaris-paragraph');
        currentPageIndex = 0;
        hideAll();
        show(0);
    }

    initPage();

    // wait for data table loading 
    setTimeout(updateFooterByDocHeight(), 800);

});

function hideAll(){
	for (var i=0; i< paragraphList.length; i++){
		$('.solaris-paragraph').eq(i).hide();
    }
    //console.log('all hide');
}

function show(index) {

	for (var i=0; i< paragraphList.length; i++){
        if (i!=index){
            $('.solaris-paragraph').eq(i).hide();
        }
    }
    $('.solaris-paragraph').eq(index).fadeIn();
    currentPageIndex = index;
    //console.log('Showing '+ index);
    updateFooterByDocHeight();
}

function goPrevPage() {
	console.log(currentPageIndex);
	if (currentPageIndex - 1 > -1){
		show(currentPageIndex - 1);
	}
}

function goNextPage() {
	console.log(currentPageIndex);
	if (currentPageIndex + 1 < paragraphList.length){
		show(currentPageIndex + 1);
	}
}

function hideMenu(){
	$('#chapter-modal').modal('hide');
}



/******** Functions for footer handling migrated from shared.js ***********/


function showFooter() {
    // show footer if it is NOT already shown
    if (footerStatus!=='shown'){
        adjustFooterOpacity('fast', 1);
        footerStatus = 'shown';
    }
    $(window).bind('scroll', checkScroll);
};


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

    console.log("");
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


/******** Variables for footer handling migrated from shared.js ***********/
