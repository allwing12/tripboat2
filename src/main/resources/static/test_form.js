// 1 . 각 필요한 요소를 불러와 변수에 할당
let userName = document.querySelector('#username')
let failMsg = document.querySelector('.failure-message')
let sucMsg = document.querySelector('.success-message')
let misMsg = document.querySelector('.mismatch-message')
const userPw =  document.querySelector('#password1');
const pwTest = document.querySelector('#password2');
// 2. 아이디 입력창에 키를 눌렀을때 조건문
userName.onkeyup = function () {

if (id4Length(userName.value)) {// 함수의 값과 일치하면
   sucMsg.classList.remove('hide') // sucMsg 클래스 hide 제거
   failMsg.classList.add('hide')// failMsg 클래스 hide 추가
}else {
   sucMsg.classList.add('hide')// sucMsg 클래스 hide 추가
   failMsg.classList.remove('hide')// failMsg 클래스 hide 제거g
    }
}

// 3. 함수의 매개변수로 들어오는 값이 4글자 이상인경우 true
function id4Length(value) {
  return value.length >= 4
}

// 4.  비밀번호1 , 비밀번호2 값을 받아 같으면 true
function isMatch (password1, password2) {
  return password1 === password2;
}

//5. 비밀번호창에 키를 눌렀을때
pwTest.onkeyup = function () {
  if(isMatch(userPw.value,pwTest.value)){ // 함수조건 만족시
    misMsg.classList.add('hide')  // 메세지 안보임
  } else {
    misMsg.classList.remove('hide') // misMag 내용출력
  }
}