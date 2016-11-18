
	function callServer() {
		// javaScript로 서버쪽 프로그램을 호출
		// ajax를 이용해서 처리해 보아요!!
		// 순수 javaScript가 아닌 jQuery로 ajax를 이용
		$.ajax({ // ajax이용 { }-> 객체
			// 호출할 서버쪽 프로그램의 url 어떤프로그램
			url : "http://localhost:8080/ajaxProject_/add" ,
			// type : 전송방식
			type : "get", // get방식을 호출 서버에서 doget() 호출
			// data : 서버로 전송할 데이터
			data : {
				first : $("#first").val(), 
				second : $("#second").val()
			},
			success : function(data){ // ajax 호출이 성공하면 함수 호출하면서 서버가 보내준 데이터 넣어줌
				$("span").text(data);
			},
			error :  function(data){
				alert("먼가 이상해요!!");
			}
		});
	}