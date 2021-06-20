'use strict'

const loginBtn  = document.querySelector("#loginBtn");
const userId    = document.querySelector("#userid");
const password  =document.querySelector("#password");

(function() {
    loginBtn.addEventListener("click", loginValidation);

})();

function loginValidation (e) {
    e.preventDefault();

    if(!userId.value) {
        alert("ID를 입력해주세요.");
        return;
    }

    if(!password.value) {
        alert("PW를 입력해주세요.");
        return;
    }

    alert("ID/암호가 틀렸습니다.");
}



