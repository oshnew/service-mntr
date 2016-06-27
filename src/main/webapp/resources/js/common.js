
/**
 * 서버에 동기로 Ajax로 요청
 *  - Array로 리턴해주며 성공일 때는 isSuccess값이 true
 * 
 * @param methodType GET/POST 와 같은 요청메소드 타입
 * @param url 요청 URL
 * @param data 요청할 데이터(Javascript 'key-value array')
 */
function reqSyncAjax(methodType, url, data) {
	
	var rslt = {isSuccess:false};
			
	if(url.length == 0) {
		alert("요청 URL이 없습니다.");
		return rslt;
	}
	
	if(methodType.length == 0) {
		alert("메소드 타입이 없습니다.");
		return false;
	}
	
	$.ajax({
		url : url,
		data : data,
		type : methodType,
		async : false,
		dataType : 'json',
		error : function(error) {
			alert("요청이 실패했습니다.\n로그인이 필요한 화면에서 발생한 경우 재 로그인해주세요.");
			return rslt;
		},
		success : function(data) {
			if(data.isSuccess == true) { //성공
				alert("성공했습니다.");
				rslt = data; //서버에서 isSuccess값이 넘어옴
				return;
			}else {
				
				if(data.msg == null || data.msg == "undefined" ) {
					alert("실패했습니다.");
				}else {
					alert(data.msg);
				}
				
				return rslt;
			}
		}
	});
	
	return rslt;
	
}

/**
 * 유효한 패턴의 이메일인지 체크
 * 
 * @param email
 * @returns
 */
function isValidEmail(email) {
        //var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        //더 강화된 체크
        var re=/^[-0-9A-Za-z!#$%&'*+/=?^_`{|}~.]+@[-0-9A-Za-z!#$%&'*+/=?^_`{|}~.]+/;
        return re.test(email);
}

/**
 * @type : function
 * @access : public
 * @desc : 스트링의 자릿수를 Byte 단위로 환산하여 알려준다. 영문, 숫자는 1Byte이고 한글은 3Byte이다.(자/모 중에 하나만 있는 글자도 3Byte이다.)
 */
function fnc_getByteLength(value) {
	var byteLength = 0;

	if (fnc_isNull(value)) {
		return 0;
	}

	var c;

	for ( var i = 0; i < value.length; i++) {
		c = escape(value.charAt(i));

		if (c.length == 1) {
			byteLength++;
		} else if (c.indexOf("%u") != -1) {
			byteLength += 3;
		} else if (c.indexOf("%") != -1) {
			byteLength += c.length / 3;
		}
	}

	return byteLength;
}
