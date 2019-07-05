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
function ajax2(url, method){
	var promiseObj = new Promise(function(resolve, reject){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200)
			{
				var response = this.responseText;
				resolve(response);
			}
			else if(this.readyState == 4 && this.status != 200)
			{
				reject(response);
			}
		}
        xhr.open(method, url, true);
        xhr.send();
    });
    return promiseObj;
}