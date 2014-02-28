<html>
<head>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	
	<script>
		$( document ).ready(function() {
			console.log( "document loaded" );
			$.ajaxSetup ({
	        	cache: false
	    	});
	    	var ajax_load = "<p>LOADING...</p>";
	     
	    	$("#submitButton").click(function(){
	    		var houseCode = $("#houseCode").val();
	    		var unitCode = $("#unitCode").val();
	    		var actionCode = $("#actionCode").val();
	    		var loadUrl = "/X10RestServer/rest/light/" + actionCode + "/" + houseCode + "/" + unitCode;
	    		console.log(loadUrl);
	       		$("#result").html(ajax_load).load(loadUrl);
	    	});
		});
	
		
	</script>
</head>
<body>
	<input type="text" id="houseCode" />
	<input type="text" id="unitCode" />
	<input type="text" id="actionCode" />
	<input type="button" id="submitButton"/>
	<div id="result"></div>
</body>
</html>
