function sign_up () {
    var username = document.getElementById("username");
    var email =document.getElementById("email");
    var password1 =document.getElementById("password1");
    var password2 =document.getElementById("password2");
    var Check = confirm("회원가입을 하시겠습니까?");

            if(username.length == "") {
            alert("아이디를 입력해주세요");
            return false;
            }
            if (email.length == "") {
            alert("이메일을 입력해주세요");
            return false;
            }
            if(password1.length != 0) {
            alert("비밀번호를 입력해주세요");
            return false;
            }
            if (password2.length == "") {
            alert("비밀번호를 다시 한 번 입력해주세요");
            return false;
            }
            if (password1 == password2 ) {
            alert("비밀번호가 서로 일치하지 않습니다.");
            return false;
            }
            if(confirm("회원가입을 하시겠습니까?")){
            alert("회원가입을 축하합니다");
            return true;
            }
//               if(Check) {
//                               if(username.length == "") {
//                               alert("아이디를 입력해주세요");
//                               return false;
//                               }
//                               if (email.length == "") {
//                               alert("이메일을 입력해주세요");
//                               return false;
//                               }
//                               if(password1.length == "") {
//                               alert("비밀번호를 입력해주세요");
//                               return false;
//                               }
//                               if (password2.length == "") {
//                               alert("비밀번호를 다시 한 번 입력해주세요");
//                               return false;
//                               }
//                               if (password1 == password2 ) {
//                               alert("비밀번호가 서로 일치하지 않습니다.");
//                               return false;
//                               }
//                               if(email.length != "") {
//                               alert("회원가입이 완료 되었습니다.")
//                               }
//               } else {
//               alert("회원가입이 취소 되었습니다.")
//               }
}
