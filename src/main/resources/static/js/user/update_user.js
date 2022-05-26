$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/roles",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, role) => {
                let option = "<option value = " + role.id + ">" + role.name + "</option>";
                $("#role_row").append(option);
            })
        }
    });
    $("#update_customer_form").submit(function (evt) {
        evt.preventDefault();
        try {
            let id = $("#id").val();
            let formData = {
                id: id,
                username: $("#name_row").val(),
                password: $("#password_row").val(),
                roleId: $("#role_row").val()
            };
            if (formData.password === $("#password_repeat_row").val()) {
                $.ajax({
                    url: '/users/' + id,
                    type: 'PUT',
                    headers: {'Authorization': localStorage.getItem("token")},
                    contentType: "application/json",
                    data: JSON.stringify(formData),
                    dataType: 'json',
                    success: function (response) {
                        console.log("SUCCESS");
                        window.location.href = "../../html/user/user.html";
                    },

                    error: function (error) {
                        alert(error["responseText"])
                    }
                });
            } else {
                alert("Passwords do not match")
            }
        } catch (error) {
            console.error(error)
        }
    });

    $(document).on("click", "#div_customer_table table button.btn_id", function () {
        if (localStorage.getItem("role") === "ROLE_ADMIN") {
            let id_of_button = (event.srcElement.id);
            let id = id_of_button.split("_")[2];

            $.ajax({
                type: "GET",
                url: "/users/" + id,
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (user) {
                    if (user.username === localStorage.getItem("username")) {
                        $("#role_row").attr("disabled", true);
                    } else {
                        $("#role_row").attr("disabled", false);
                    }
                    $("#div_updating").show();
                    $("#id").val(user.id);
                    $("#name_row").val(user.username);
                    $("#role_row").val(user.roleId);
                },
                error: function (error) {
                    console.log(error);
                    alert(error["responseText"]);
                }
            });
        }
    });
});