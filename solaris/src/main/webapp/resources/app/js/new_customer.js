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
    document.getElementsByClassName('find_new_tab')[0].style.display = 'block';
    document.getElementById('loading').style.display = 'none';
}

onReady(function () {
    show();
});