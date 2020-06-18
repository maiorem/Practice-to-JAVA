

var members=[];


function Member(uid, upw, uname) {
    var id=uid;
    var pw=upw;
    var name=uname;

    this.getId=function(){
        return id;
    };

    this.setId=function(uid) {
        id=uid;
    };

    this.getPw=function() {
        return pw;
    };

    this.setPw=function(upw) {
        pw=upw;
    };
    this.getName=function() {
        return name;
    };

    this.setName=function(uname) {
        name=uname;
    };


}



// 입력받아 객체 생성
function createUser() {
    var uid=document.getElementById('id').value;
    var upw=document.getElementById('pw').value;
    var uname=document.getElementById('name').value;

    if(uid==null || uid.length<1) {
        alert('아이디는 필수 입력사항입니다.');
        return false;
    }
    if(upw==null || upw.length<1) {
        alert('비밀번호는 필수 입력사항입니다.');
        
        return false;
    }
    if(uname==null || uname.length<1) {
        alert('이름은 필수 입력사항입니다.');
        
        return false;
    }

    if(checkId(uid)) {
        alert('이미 존재하는 아이디입니다.');
        
        return false;
    }

    members.push(new Member(uid, upw, uname)); // 배열에 저장
    userList();

    document.getElementById('createform').reset();

    setLocalStorage();

    return false;

}

//중복아이디 체크
function checkId(id) {
    var check=false;
    for (let i=0; i<members.length; i++) {
        if(id==members[i].getId()) {
            check=true;
        }
    }
    return check;
}

function editSet(idx){

    
    document.getElementById('edituser').style.display='block';

    document.getElementById('idx').value=idx;
    document.getElementById('edid').value=members[idx].getId();
    document.getElementById('edpw').value=members[idx].getPw();
    document.getElementById('ename').value=members[idx].getName();
    

}


function editUser() {
    
    var idx = document.getElementById('idx').value;
    var eid = document.getElementById('edid').value;
    var epw = document.getElementById('edpw').value;
    var ename = document.getElementById('ename').value;  

    if(epw==null || epw.length<1) {
        alert('비밀번호는 필수 입력사항입니다.');
        
        return false;
    }

    if(ename==null || ename.length<1) {
        alert('이름은 필수 입력사항입니다.');
       
        return false;
    }
   
    members[parseInt(idx)].setId(eid);
    members[parseInt(idx)].setPw(epw);
    members[parseInt(idx)].setName(ename);

    document.getElementById('editform').reset();

    
    userList();
   
    setLocalStorage();

    document.getElementById('edituser').style.display='none';

    return false;

}

function deleteUser(idx){

    if(confirm('정말로 삭제하시겠습니까?')){
        alert(members[idx].getName()+'님의 정보를 삭제합니다.');
        members.splice(idx,1);
        userList();
        setLocalStorage();
        
    }
}


// 유저리스트 테이블 세팅
function userList() {

    var list='';
    list+='<table id="listTable"  border=1px>';
    list+='<tr>';
    list+='    <td>index</td>';
    list+='    <td>아이디(이메일)</td>';
    list+='    <td>비밀번호</td>';
    list+='    <td>이름</td>';
    list+='     <td>관리</td>';
    list+='</tr>'
    
    for(let i=0; i<members.length; i++) {
        list+='<tr>';
        list+='<td>';
        list+=i;
        list+='</td>'
        list+='<td>';
        list+=members[i].getId();
        list+='</td>';
        list+='<td>';
        list+=members[i].getPw();
        list+='</td>';
        list+='<td>';
        list+=members[i].getName();
        list+='</td>';
        list+='<td>';
        list+='<a href="javascript:editSet('+i+')">수정</a> | <a href="javascript:deleteUser('+i+')">삭제</a>';
        list+='</td>'
        list+='</tr>'
    }

    list+='</table>';
    var userListTable=document.getElementById('listTable');
    userListTable.innerHTML=list;

}

// 초기 데이터 저장
function initialstore(){
        
    var data = localStorage.getItem('members');
    if(data==null){
        var jdata=JSON.stringify(members);
        localStorage.setItem('members', jdata);
    } else {
        members = JSON.parse(data);
    }

}



//로컬저장소에 저장
function setLocalStorage() {
    var jsondata=JSON.stringify(members);
    localStorage.setItem('members', jsondata);
}


window.onload = function() {

    // 새로고침 해도 이전 저장 데이터 테이블로 세팅해 두기
    initialstore(); 
    userList();     
    
    document.getElementById('createform').onsubmit=createUser; //회원등록
    
    document.getElementById('editform').onsubmit=editUser; //회원수정
        
}
