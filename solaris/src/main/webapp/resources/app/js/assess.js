$(document).ready(function() {
    // Go back to assessment page when test result modal dismissed
	$('#assessment-result-modal').on(
		'hidden.bs.modal', function() {
			$(location).attr('href', '/solaris/trainings');
	});
});


function resetForm() {
	$('.test-form')[0].reset();
	//$('#assessment-result-modal').modal('show');
}

function validateTest(){
	 
     var unanswered_questions = "";
     var answers = [];

	 if (!$("input[name='Q1']:checked").val()) {
	 	unanswered_questions += "Q1 ";
	 	$('.quiz_head').eq(0).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q1']:checked").val());
	 }

	 if (!$("input[name='Q2']:checked").val()) {
	 	unanswered_questions += "Q2 ";
	 	$('.quiz_head').eq(1).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q2']:checked").val());
	 }

	 if (!$("input[name='Q3']:checked").val()) {
	 	unanswered_questions += "Q3 ";
	 	$('.quiz_head').eq(2).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q3']:checked").val());
	 }

	 if (!$("input[name='Q4']:checked").val()) {
	 	unanswered_questions += "Q4 ";
	 	$('.quiz_head').eq(3).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q4']:checked").val());
	 }

	 if (!$("input[name='Q5']:checked").val()) {
	 	unanswered_questions += "Q5 ";
	 	$('.quiz_head').eq(4).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q5']:checked").val());
	 }

	 if (!$("input[name='Q6']:checked").val()) {
	 	unanswered_questions += "Q6 ";
	 	$('.quiz_head').eq(5).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q6']:checked").val());
	 }

	 if (!$("input[name='Q7']:checked").val()) {
	 	unanswered_questions += "Q7 ";
	 	$('.quiz_head').eq(6).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q7']:checked").val());
	 }

	 if (!$("input[name='Q8']:checked").val()) {
	 	unanswered_questions += "Q8 ";
	 	$('.quiz_head').eq(7).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q8']:checked").val());
	 }

	 if (!$("input[name='Q9']:checked").val()) {
	 	unanswered_questions += "Q9 ";
	 	$('.quiz_head').eq(8).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q9']:checked").val());
	 }

	 if (!$("input[name='Q10']:checked").val()) {
	 	unanswered_questions += "Q10 ";
	 	$('.quiz_head').eq(9).css('border', '1px solid #f0c814');
	 }
	 else{
	 	answers.push($("input[name='Q10']:checked").val());
	 }

	 if (unanswered_questions!==""){
	 	alert(unanswered_questions + "are not answered !");
	 }
	 else {
	 	var test_type = $('input[name=testType]').val();
	 	var test_id = $('input[name=testId]').val();
	 	assessAnswers(answers, test_type, test_id);
	 	console.log("test type: " + test_type);
	    console.log("test id: " + test_id);
	 }
}


function assessAnswers(answers, test_type, test_id){

	total_count = answers.length;
	console.log("total: " + total_count);
	var correct_count = 0;
	
	// Assess answers
	for(var i=0; i<total_count;i++){
		// Remove pre-set borders
		$('.quiz_head').eq(i).css('border', '0px');
		if (answers[i]=="A"){
			correct_count++;
		}
		else {
			$('.quiz_head').eq(i).css('border', '1px solid #DC143C');
		}
	}

	console.log(Math.round( correct_count * 100.0 / total_count)+ " %");
	var data = {};
	//data["employeeId"] = employee_id;
	data["testId"] = test_id;
	data["testType"] = test_type;
	data["score"] = correct_count*10/total_count;
	data["date"] = "";
	insertScoreRecord(data);
	console.log("data: " + JSON.stringify(data));

}

function insertScoreRecord(data){
	var url = "/solaris/trainings/assessments/addscore";
	console.log(JSON.stringify(data));
	$.ajax({
		url : url,
		data : JSON.stringify(data),
		type : 'POST',
		contentType : "application/json",
		xhrFields : {
			withCredentials : true
		}
	}).done(function() {
		console.log("successful");
		$('#test_score').text(data["score"]);
		$('#assessment-result-modal').modal('show');
	   });

}