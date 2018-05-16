function checkInput(){
	var name = addInfor.name.value;
	var pw = addInfor.password.value;
	var mail = addInfor.email.value;
	
	if(name == ""){
		alert("이름적어라...");
		name.focus();
		return false;
	}else if(pw == ""){
		alert("비번써라..");
		pw.focus();
		return false;
	}else if(mail == ""){
		alert("메일써라..");
		mail.focus();
		return false;
	}
	
};