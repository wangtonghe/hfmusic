$(function(){
	$("#login_in").on("click",function(){
		$.get("/testmaven/user/login",{"id":1,"password":"123456"},function(data){
			if(data=='success'){
				console.log(data);
			}
			else{
				console.log("error");
			}
			
		})
	
	})

});