$(document).ready(function () {

    $("#update_customer_form").submit(function (evt) {
        evt.preventDefault();
        try {
            let id = $("#id").val();
            let formData = {
                id: id,
                name: $("#name_row").val(),
                flightsNumber: $("#flightsNumber_row").val(),
                speciality: $("#speciality_row").val()
            };
            $.ajax({
                url: '/engineers/' + id,
                type: 'PUT',
                headers: {'Authorization': localStorage.getItem("token")},
                contentType: "application/json",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (response) {
                    console.log("SUCCESS");
                    window.location.href = "../../html/engineer/engineer.html";
                },

                error: function (error) {
                    alert(error["responseText"])
                }
            });
        } catch (error) {
            console.error(error)
        }
    });

    $(document).on("click", "#div_customer_table table button.btn_id", function () {
        if (localStorage.getItem("role") === "ROLE_ADMIN" || localStorage.getItem("role") === "ROLE_FLIGHT-MANAGER") {
            let id_of_button = (event.srcElement.id);
            let id = id_of_button.split("_")[2];
            $.ajax({
                type: "GET",
                url: "/engineers/" + id,
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (engineer) {
                    $("#div_updating").show();
                    $("#id").val(engineer.id);
                    $("#name_row").val(engineer.name);
                    $("#flightsNumber_row").val(engineer.flightsNumber);
                    $("#speciality_row").val(engineer.speciality);
                },
                error: function (error) {
                    console.log(error);
                    alert(error["responseText"]);
                }
            });
        }
    });
});