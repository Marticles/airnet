$("#login_button").click(function () {
    var name = $('#name').val();
    var password = $('#password').val();
    $.ajax({
        url: "/check_user",
        type: "POST",
        data: {
            "name": name,
            "password": password
        },
        dataType: "json",
        success: function (data) {
        },
        error: function (error) {
            if (error.responseText == "success") {
                window.location.href = "/";
            } else {
                $('#error_modal').modal('show');
            }
            console.log(error);
        }
    });

})

$("#reg_button").click(function () {
    var name = $('#name').val();
    var email = $('#email').val();
    var password = $('#password').val();
    $.ajax({
        url: "/register",
        type: "POST",
        data:{
            "name":name,
            "email":email,
            "password":password
        },
        dataType: "json",
        success: function(data){
        },
        error:function(error){
            if (error.responseText == "success") {
                window.location.href = "/login";
            } else {
                window.location.href = "/register";
            }
            console.log(error);
        }
    });

})