    function ign_up () {
        var username = $("#username").val();
        var email = $("#email").val();
        var password1 = $("#password1").val();
        var password2 =$("password2").val();

            if(username.length == 0){
                alert("아이디를 입력해 주세요");
                    $("#username").focus();
                    return false;
                }

            if(password1.length == 0){
                alert("비밀번호를 입력해 주세요");
                $("#password1").focus();
                    return false;
                }

            if(password1 != password2){
                alert("비밀번호가 서로 다릅니다. 비밀번호를 확인해 주세요.");
                $("#password2").focus();
                return false;
                }

            if(email.length == 0){
                alert("이메일을 입력해주세요");
                $("#email").focus();
                    return false;
                    }

            if(confirm("회원가입을 하시겠습니까?")){
                alert("회원가입을 축하합니다");
                return true;
                }
            }