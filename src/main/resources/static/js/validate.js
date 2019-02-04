function checkUserName(txtbox) {
    if (txtbox.validity.valueMissing){
        txtbox.setCustomValidity("用户名不能为空！");
    }else if(txtbox.validity.patternMismatch){
        txtbox.setCustomValidity("6-15位字母或数字！");
    }
    else {
        txtbox.setCustomValidity("");
    }
}
function checkPassword(txtbox) {
    if (txtbox.value==""){
        txtbox.setCustomValidity("密码不能为空！");
    }else if(txtbox.validity.patternMismatch){
        txtbox.setCustomValidity("至少6位字母或数字!");
    }
    else {
        txtbox.setCustomValidity("");
    }
}

function checkSecondPassword(txtbox,first) {
    if (txtbox.value==""){
        txtbox.setCustomValidity("密码不能为空！");
    }else if(txtbox.validity.patternMismatch){
        txtbox.setCustomValidity("至少6位字母或数字!");
    }else if (txtbox.value!=$("#"+first).val()){
        txtbox.setCustomValidity("2次密码不一致！");
    }
    else {
        txtbox.setCustomValidity("");
    }
}

function checkEmail(emailbox) {
    if (emailbox.value==""){
        emailbox.setCustomValidity("email不能为空！");
    }else if(emailbox.validity.typeMismatch){
        emailbox.setCustomValidity("请输入正确格式!例子XXX@XX.COM");
    }
    else {
        emailbox.setCustomValidity("");
    }
}