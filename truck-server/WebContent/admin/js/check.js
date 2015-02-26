/* 
	function LTrim(str) {
		var i;
		for(i=0; i<str.length; i++) {
			if(str.charAt(i)!=" ") break;
		}
		str = str.substring(i,str.length);
		return str;
	}
	
	function RTrim(str) {
		var i;
		for(i=str.length-1; i>=0; i--) {
			if(str.charAt(i) != " ") break;
		}
		str = str.substring(0, i+1);
		return str;
	}
	
	function Trim(str) {
		return LTrim(RTrim(str));
	}
	
	function check() {
		if(Trim(document.myform.title.value) == "") {
			alert("请输入标题!");
			document.myform.title.focus();
			return false;
		}
		if(Trim(document.myform.title.value).length>40) {
			alert("标题最多只能输入40个字!");
			document.myform.title.focus();
			return false;
		}
		if(Trim(document.myform.author.value) == "") {
			alert("请输入作者!");
			document.myform.author.focus();
			return false;
		}
		if(Trim(document.myform.author.value).length>20) {
			alert("作者最多只能输入20个字!");
			document.myform.author.focus();
			return false;
		}
		if(Trim(document.myform.content.value) == "") {
			alert("请输入内容!");
			document.myform.content.focus();
			return false;
		}
		return true;
	}
 */