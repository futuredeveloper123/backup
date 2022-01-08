//html  태그를 전부 읽어서 메모리에 로드 하고 나면 
window.addEventListener("load", function(event){
  //DOM 객체 찾아오기
  //사용해야 할 태그 들을 id를 이용해서 찾아오는 것  
  var joinform = document.getElementById("joinform");
  
  var email = document.getElementById("email");
  var pw = document.getElementById("pw");
  var pw1 = document.getElementById("pw1");
  var nickname = document.getElementById("nickname");
  var image = document.getElementById("image");
  
  var msg = document.getElementById("msg");
  var emailmsg = document.getElementById("emailmsg");
  var pwmsg = document.getElementById("pwmsg");
  var nicknamemsg = document.getElementById("nicknamemsg");
  
  var joinbtn = document.getElementById("joinbtn");
  var mainbtn = document.getElementById("mainbtn");
  var loginbtn = document.getElementById("loginbtn");
	
//이벤트 처리,,,,,mainbtn 의 클릭 이벤트 처리 .....
//눌렀을 때 뭔가 하고싶으면 이따우로 
mainbtn.addEventListener("click", function(event){
//서버에게 요청 
   location.href="../";
  });
  
  loginbtn.addEventListener("click", function(event){
   location.href="login";
  });
  
//이미지 라는 항목의 데이터가 변경되면 -여기서 이미지는  파일 ~~!!!!
  image.addEventListener("change", function(event) {
//파일의 내용을 읽어서  img에 출력 //이미지 미리보기 구현 
  if (this.files && this.files[0]) {
  var filename = this.files[0].name;
  var reader = new FileReader();
  reader.addEventListener("load", function(e) {
  img.src = e.target.result;
  });
  reader.readAsDataURL(this.files[0]);
  }
  })
//email란에서 포커스가 떠나면 중복 검사를 수행 
 email.addEventListener('focusout',function(e){
 //ajax 요청할 url과 객체를 생성 
	 var url ="emailcheck?email=" + email.value;
 var request=new XMLHttpRequest();
 
 // 요청 생성 
 request.open("get",url,true);
 //요청 전송 
 request.send('');
 //ajax요청 응답이 오면 
 request.addEventListener('load',function show(e){
// alert(request.responseText);
var data =JSON.parse(request.responseText);
if(data result == ture){
emailmsg.innerHTML='can use email';
emailmsg.style.color='Blue';
}else{
emailmsg.innerHTML='can't use email';
emailmsg.style.color='Red';
}
 })
 });
 alert("focus out event")
 });
///nickname란에서 포커스가 떠나면 중복 검사를 수행 
 nickname.addEventListener('focusout',function(e){
// alert("focus out event")
 var url ="nicknamecheck?nickname=" + nickname.value;
 var request=new XMLHttpRequest();
 // 요청 생성 
 request.open("get",url,true);
 //요청 전송 
 request.send('');
 //ajax요청 응답이 오면 
 request.addEventListener('load',function show(e){
// alert(request.responseText);
var data =JSON.parse(request.responseText);
if(data result == ture){
nicknamemsg.innerHTML='can use nickname';
nicknameemsg.style.color='Blue';
}else{
nicknamemsg.innerHTML='can't use nickname';
nicknamemsg.style.color='Red';
}
})
});
//회원가입을 누르면 
  joinbtn.addEventListener("click", function(event){
//회원가입 여부를 저장하기 위한 변수 
  var flag = false;
emailmsg.innerHTML="";
pwmsg.innerHTML="";
nicknamemsg.innerHTML="";
//클라이언트에서 데이터 유효성 검사   
if (email.value.trim().length < 1) {
  emailmsg.innerHTML = '이메일은 필수 입력입니다.<br/>';
  flag = true;
  } else {
  var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
  if (!emailRegExp.test(email.value.trim())) {
  emailmsg.innerHTML = '잘못된 이메일 형식입니다.<br/>';
  }
  }
//정규표현식을 공부해야함 잘하려면 이런거 ,,,,
  if (pw.value.trim().length < 1) {
  pwmsg.innerHTML += '비밀번호는 필수 입력입니다.<br/>';
  flag = true;
  } else {
  var pwRegExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$/;
  if (!pwRegExp.test(pw.value.trim())) {
  pwmsg.innerHTML = '비밀번호는 숫자와 영문 대소문자 그리고 특수문자가 포함되어야 합니다.<br/>';
  flag = true;
  } else {
  if (pw.value.trim() !== pw1.value.trim()) {
  pwmsg.innerHTML += '2개의 비밀번호는 같아야 합니다.<br/>';
  flag = true;
  }
  }
  }
  if (nickname.value.trim().length < 1) {
  nicknamemsg.innerHTML += '별명은 필수 입력입니다.<br/>';
  flag = true;
  } else {
  var nicknameRegExp = /^[a-zA-z가-힣0-9]{2,5}$/;
  if (!nicknameRegExp.test(nickname.value.trim())) {
  nicknamemsg.innerHTML = '닉네임은 영문 한글 숫자로 2자 이상 5자 이하이어야 합니다.<br/>';
  flag = true;
  }
  }
  //클라이언트 유혀성 검사에 실패하면 전송하지 말고 중지 !!!!
  if (flag == true) {
  return;
  event.preventDefault();
  }
//ajax 요청할 url과 객체를 생성 
  var url="join";
      var request=new XMLHttpRequest();
//요청 생성 
   request.open("post", url, true);
//폼의 데이터를 전송할 수 있는 파라미터로 생성    
var formdata = new FormData(joinform);
//요청 전송 
   request.send(formdata);
//ajax요청 응답이 오면    
request.addEventListener('load', function show(e){
//결과를 json파싱 
   var map = JSON.parse(e.target.responseText);
//회원가입에 성공하면 서버에게 요청    
if(map.result == true){
     location.href = "../";
   }else{
//회원가입에 실패한 경우 
     if(map.emailcheck == false){
     emailmsg.innerHTML = "사용 불 가능한 이메일입니다.";
     emailmsg.style.color = "Red";
     }else{
     emailmsg.innerHTML = "사용 가능한 이메일입니다.";
     emailmsg.style.color = "Blue";
     }
     if(map.nicknamecheck == false){
     nicknamemsg.innerHTML = "사용 불 가능한 닉네임입니다.";
     nicknamemsg.style.color = "Red";
     }else{
     nicknamemsg.innerHTML = "사용 가능한 닉네임입니다.";
     nicknamemsg.style.color = "Blue";
     }
   }
    })
  });
});