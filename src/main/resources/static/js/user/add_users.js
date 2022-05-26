$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/roles",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, role) => {
                let option = "<option value = " + role.id + ">" + role.name + "</option>";
                $("#role").append(option);
            })
        }
    });
    $("#add_new").submit(function (evt) {
        evt.preventDefault();
        let formData = {
            username: $("#username").val(),
            password: $("#password").val(),
            roleId: parseInt($("#role").val())
        };

        $.ajax({
            type: "POST",
            url: "/users",
            headers: {'Authorization': localStorage.getItem("token")},
            contentType: "application/json",
            data: JSON.stringify(formData),
            dataType: 'json',
            async: false,
            success: function (response) {
                $("div.modal-body")
                    .text("Successfully saved");

                $("button.btn.btn-secondary").text("Close");
            },
            error: function (error) {
                alert(error["responseText"])
                window.location.href = "../../html/user/add_user.html";
            }
        });
    });

    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname === "../../html/user/user.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});
