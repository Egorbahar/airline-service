$(document).ready(function () {
    let id = 0;

    $(document).on("click", "#div_customer_table table button.btn_delete", function () {
        let btn_id = (event.srcElement.id);
        id = btn_id.split("_")[2];
        $.ajax({
            type: "GET",
            url: "/users/" + id,
            headers: {'Authorization': localStorage.getItem("token")},
            success: function (response) {
                if (response.username === localStorage.getItem("username")) {
                    alert("It is not possible to delete own credentials");
                    window.location.href = "../../html/user/user.html";
                } else {
                    $("div.modal-body")
                        .text("Are you sure you want to delete the entry with id = " + id + " ?");
                    $("#model-delete-btn").css({"display": "inline"});
                }
            },
            error: function (e, textStatus, errorThrown) {
                if (e.status === 403)
                    window.location.href = "../../html/access_denied.html";
                else {
                    console.log("ERROR : ", textStatus);
                    alert(e["responseText"]);
                }
            }
        });

    });

    $(document).on("click", "#model-delete-btn", function () {
        $.ajax({
            url: '/users/' + id,
            type: 'DELETE',
            headers: {'Authorization': localStorage.getItem("token")},
            success: function (response) {
                $("div.modal-body")
                    .text("Successfully removed");

                $("#model-delete-btn").css({"display": "none"});

                let row_id = "tr_" + id;
                $("#" + row_id).remove();
                $("#div_customer_updating").css({"display": "none"});
            },
            error: function (error) {
                $("#div_customer_updating").css({"display": "none"});
                alert(error["responseText"]);
            }
        });
    });
});