var currentPageIndex;
var totalPage = 6;
var paragraphList;

$(document).ready(function() {
    var initPage = function() {
        paragraphList = document.getElementsByClassName('solaris-paragraph');
        currentPageIndex = 0;
        hideAll();
        show(0);
    }

    initPage();
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
}

function goPrevPage() {
	console.log(currentPageIndex);
	if (currentPageIndex - 1 > -1){
		show(currentPageIndex - 1);
	}
}

function goNextPage() {
	console.log(currentPageIndex);
	if (currentPageIndex + 1 < totalPage){
		show(currentPageIndex + 1);
	}
}

function hideMenu(){
	$('#sales-chapter-modal').modal('hide');
}
