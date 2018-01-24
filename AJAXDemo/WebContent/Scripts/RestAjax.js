var req;

function getRequestObject(){
	window.alert("request obj");
	if(window.ActiveXObject){
		return new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else
		return null;
}

function sendRequest(){
	req=getRequestObject();
	var restId=document.getElementById("restId").value;
	
	var url="/AJAXDemo/saveRest";
	req.open("POST",url,true);
	
	req.onreadystatechange=processRequest;
	req.setRequestHeader("content-type","application/x-www-form-urlencoded");
	req.send("restId="+restId);
}

//callback method
function processRequest(){
	if(req.readyState==4){// completed
		if(req.status==200){ // sucess
			window.alert("Response received");
			if(req.responseText.trim() == "exist"){
				document.getElementById("restIdError").innerHTML="Restaurant Data exist";
			}else if(req.responseText.trim() == "notExist"){
				document.getElementById("restIdError").innerHTML="";
			}
		}
	}
}