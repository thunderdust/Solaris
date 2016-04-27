var currentTab;

function onReady(callback) {
    var intervalID = window.setInterval(checkReady, 3500);
    function checkReady() {
        if (document.getElementsByTagName('body')[0] !== undefined) {
            window.clearInterval(intervalID);
            callback.call(this);
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