$(document).ready(function() {
    $("#add_new").submit(function(evt) {
        evt.preventDefault();
        let formData = {
            name : $("#name").val(),
        };

        $.ajax({
            type: 'POST',
            url: "/categories",
            headers: {'Authorization': localStorage.getItem("token")},
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
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


    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname === "../../html/category/category.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});