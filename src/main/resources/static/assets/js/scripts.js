jQuery(document).ready(function() {

    /*
        Fullscreen background
    */
    $.backstretch("/assets/img/backgrounds/1.jpg");

    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });

    $('.login-form').on('submit', function(e) {

    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});

    });

	function checkSubmit() {
		var name=$("#form-username").val();
		var mail=$("#form-email").val();
		var password=$("#form-password").val();
		var repassword=$("#form-repassword").val();
		var pattern=/^\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}$/;
		if (password!=repassword){
			alert("两次密码不一致");
			return false;
		} else if (name.length==0){
			alert("未填写姓名");
			return false;
		}else if (!pattern.test(mail)){
			alert("邮箱格式有误");
			return false;
		}else
			return true;
	}



});
