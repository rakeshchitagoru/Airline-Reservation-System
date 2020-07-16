	function ARS_datePicker(){
		var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1;
	var yyyy = today.getFullYear();
	 if(dd<10){
	        dd='0'+dd
	    } 
	    if(mm<10){
	        mm='0'+mm
	    } 
	
	today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("idDepartureDate").setAttribute("min", today);
	}


	var flag=false;


	function ARS_checkDestination(){

	  var source = document.getElementById("source").value;
	  var destination = document.getElementById("destination").value;

	if(source==destination)
	{
		document.getElementById('message').style.color = 'red';
		document.getElementById('message').innerHTML = 'Departure City and Arrival City must be different';
		
		}
	else
		{
		flag=true;
		document.getElementById('message').innerHTML = '';
		}
	}
	
	
	var checkPassword = function() {
		if (document.getElementById('pass').value == document
				.getElementById('cPass').value) {
			document.getElementById('message').style.color = 'green';
			document.getElementById('message').innerHTML = 'matched';
		} else {
			document.getElementById('message').style.color = 'red';
			document.getElementById('message').innerHTML = 'not matching';
		}
	}
