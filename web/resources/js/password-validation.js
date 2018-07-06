let password = document.getElementById("password");
let confirm_password = document.getElementById("password-confirm");

function validatePassword() {
    if (password.value !== confirm_password.value) {
        confirm_password.setCustomValidity("Passwords don't match");
    } else {
        confirm_password.setCustomValidity('');
    }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;