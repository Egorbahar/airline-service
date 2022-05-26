$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/categories",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, category) => {
                let option = "<option value = " + category.id + ">" + category.name + "</option>";
                $("#category").append(option);
            })
        }
    });
    $("#add_new").submit(function (evt) {
        evt.preventDefault();
        let formData = {
            name: $("#name").val(),
            windSpeed: $("#wind").val(),
            categoryId: parseInt($("#category").val())
        };

        $.ajax({
            type: "POST",
            url: "/airplanes",
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
            }
        });
    });

    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname === "../../html/airplane/airplane.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});
