$(document).ready(function () {
    $("#login-form").submit(function (event) {

        event.preventDefault();
        localStorage.setItem("token", "")
        localStorage.setItem("role", "")
        localStorage.setItem("userId", "")
        localStorage.setItem("username", "")

        let loginForm = {};
        let usernameSelector = $("#username");
        let passwordSelector = $("#password");
        loginForm["username"] = usernameSelector.val();
        loginForm["password"] = passwordSelector.val();
        $("#btn-login").prop("disabled", true);


        let formData = {
            username : usernameSelector.val(),
            password: passwordSelector.val()
        };

        $.ajax({
            type : "POST",
            url: "/authentication/auth",
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            success: function (data) {
                localStorage.setItem("token", data["token"])
                localStorage.setItem("role", data["role"])
                localStorage.setItem("userId", data["userId"])
                localStorage.setItem("username", $("#username").val())
                $("#btn-login").prop("disabled", false);
                window.location.href = "/html/menu.html";
            },
            error: function (e) {
                $('#feedback').html("Неверный логин или пароль");

                console.log("ERROR : ", e);
                $("#btn-login").prop("disabled", false);

            }
        });

    });
});