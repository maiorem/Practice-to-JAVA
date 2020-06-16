
// 사용자 입력 폼 Casting
// 기본적인 유효성 검사

// form casting
// onsubmit
var form=document.getElementById('form');

form.setAttribute('action', 'http://www.naver.com');

// onsubmint
form.onsubmit=function() {

    // input casing
    var uid=document.getElementById('id');
    var upw=document.getElementById('pw');

    if(uid.value==null || uid.value.length<1) {
        alert('아이디를 반드시 입력해주세요.');
        return false;
    }

    if(upw.value==null || upw.value.length<1) {
        alert('비밀번호를 반드시 입력해주세요.');
        return false;
    }
    

}