var currentTab;

$(document).ready(function() {
    var initPage = function() {
        $('#send_campus_promotion_btn').click(Solaris.senndPromotionEmail);
    }

    initPage();
});

function onReady(callback) {
    var intervalID = window.setInterval(checkReady, 3500);
    function checkReady() {
        if (document.getElementsByTagName('body')[0] !== undefined) {
            window.clearInterval(intervalID);
            callback.call(this);
            // Enable buttons
            $('#find_enterprise').prop('disabled', false);
            $('#find_exhibition').prop('disabled', false);
            $('#find_retailer').prop('disabled', false);
            $('#find_campus').prop('disabled', false);
            $('#find_referral').prop('disabled', false);
        }
    }
}

function show() {
    document.getElementsByClassName('find_new_tab')[currentTab].style.display = 'block';
    document.getElementById('loading').style.display = 'none';
}

onReady(function () {
    currentTab = 0;
    show();
    showTab(currentTab);
});

function showTab(index){
    currentTab = index;
    var tabs = document.getElementsByClassName('find_new_tab');
    for (var i=0; i< tabs.length; i++){
        if (i!=index){
            tabs[i].style.display = 'none';
        }
    }
    $('.find_new_tab').eq(index).slideDown();
}

Solaris.senndPromotionEmail = function (evt){

    $.ajax({
        url: "sendEmail?email=" + 'thunderdust2011@gmail.com',
        type : 'POST',
        xhrFields: {
          withCredentials: true
       }
    }).done(function(){
        console.log('Email sending is done');
    });


}