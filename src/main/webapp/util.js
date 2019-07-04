/**
 * 
 */
function ajax(url,method,callback){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
    	if(this.readyState == 4 && this.status == 200)
        {
			var response = this.responseText;
			callback(response);
        }
	}
	xhr.open("GET", url, true);
	xhr.send();
}