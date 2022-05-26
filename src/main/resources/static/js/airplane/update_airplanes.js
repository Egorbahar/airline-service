$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/categories",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, category) => {
                let option = "<option value = " + category.id + ">" + category.name + "</option>";
                $("#category_row").append(option);
            })
        }
    });
    $("#update_customer_form").submit(function (evt) {
        evt.preventDefault();
        try {
            let id = $("#id").val();
            let formData = {
                id: id,
                name: $("#name_row").val(),
                windSpeed: $("#wind_row").val(),
                categoryId: parseInt($("#category_row").val())
            };
            $.ajax({
                url: '/airplanes/' + id,
                type: 'PUT',
                headers: {'Authorization': localStorage.getItem("token")},
                contentType: "application/json",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (response) {
                    console.log("SUCCESS");
                    window.location.href = "../../html/airplane/airplane.html";
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
                url: "/airplanes/" + id,
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (airplane) {
                    alert(airplane.categoryId);
                    $("#div_updating").show();
                    $("#id").val(airplane.id);
                    $("#name_row").val(airplane.name);
                    $("#wind_row").val(airplane.windSpeed);
                    $("#category_row").val(airplane.categoryId);
                },
                error: function (error) {
                    console.log(error);
                    alert(error["responseText"]);
                }
            });
        }
    });
});