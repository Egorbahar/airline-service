$(document).ready(function () {
    let id = 0;

    $(document).on("click", "#div_customer_table table button.btn_delete", function () {
        let btn_id = (event.srcElement.id);
        id = btn_id.split("_")[2];

        $("div.modal-body")
            .text("Are you sure you want to delete the entry with id = " + id + " ?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function () {
        $.ajax({
            url: '/progress-statuses/' + id,
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