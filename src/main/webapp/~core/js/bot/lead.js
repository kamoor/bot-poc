/**
 * Code to register a new user
 */

$(document).ready(function() {
	
	xcode =0;
	
	var leadSubmitCallBk = function(data){
		console.log("Lead submission completed");
		$("#msg").html(data.status);
	}
	
	
	var leadSubmitCallBkErr = function(){
		alert("Error... ");
	}
	
	/**
	 * Try to submit form
	 */
	var submitLead = function(){
		var formObj = {
				
				"lname": $("#fname").val(),
				"fname": $("#lname").val(),
				"email": $("#email").val(),
				"street": $("#street").val(),
				"city": $("#city").val(),
				"state": $("#state").val(),
				"zip": $("#zip").val(),
				"vin": $("#vin").val(),
				"debug":xcode
				
		};
		Rest.post("/v1/process-lead", formObj, leadSubmitCallBk,leadSubmitCallBkErr );
		$("#debug").html("0");
		xcode=0;
		
		
	}

	var handleMouseMove = function(){
		
		if(event.clientY > 0 && event.clientX > 0){
			xcode+= (Math.round(Math.sqrt(Math.pow(0 - event.clientY, 2) + Math.pow(0 - event.clientX, 2))) * 13);
		}else{
			xcode+= 100 *13;
		}
		$("#debug").html("x-cod: " +xcode );
	}
	
	
	
	$("#lead-btn").click(submitLead);
	$("#leadForm").mousemove(handleMouseMove);
	
	$(".reg-input").keypress(handleMouseMove);
	
});
