$(document).ready(function () {
    $("#update_customer_form").submit(function (evt) {
        evt.preventDefault();
        try {
            let id = $("#id").val();
            let formData = {
                id: id,
                name: $("#name_row").val(),
            };
            $.ajax({
                url: '/categories/' + id,
                type: 'PUT',
                headers: {'Authorization': localStorage.getItem("token")},
                contentType: "application/json",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (response) {
                    console.log("SUCCESS");
                    window.location.href = "../../html/category/category.html";
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
                url: "/categories/" + id,
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (category) {
                    $("#div_updating").show();
                    $("#id").val(category.id);
                    $("#name_row").val(category.name);
                },
                error: function (error) {
                    console.log(error);
                    alert(error["responseText"]);
                }
            });
        }
    });
});