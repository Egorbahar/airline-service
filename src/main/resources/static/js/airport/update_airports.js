$(document).ready(function () {

    $("#update_customer_form").submit(function (evt) {
        evt.preventDefault();
        try {
            let id = $("#id").val();
            let formData = {
                id: id,
                code: $("#code_row").val(),
                cityName: $("#city_row").val(),
                visibility: $("#visibility_row").val()
            };
            $.ajax({
                url: '/airports/' + id,
                type: 'PUT',
                headers: {'Authorization': localStorage.getItem("token")},
                contentType: "application/json",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (response) {
                    console.log("SUCCESS");
                    window.location.href = "../../html/airport/airport.html";
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
        if (localStorage.getItem("role") === "ROLE_ADMIN") {
            let id_of_button = (event.srcElement.id);
            let id = id_of_button.split("_")[2];
            $.ajax({
                type: "GET",
                url: "/airports/" + id,
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (airport) {
                    $("#div_updating").show();
                    $("#id").val(airport.id);
                    $("#code_row").val(airport.code);
                    $("#city_row").val(airport.cityName);
                    $("#visibility_row").val(airport.visibility);
                },
                error: function (error) {
                    console.log(error);
                    alert(error["responseText"]);
                }
            });
        }
    });
});