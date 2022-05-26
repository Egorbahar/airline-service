$(document).ready(function () {

    if (localStorage.getItem("role") === "ROLE_ADMIN") {
        $("#add-category").show();
    } else {
        window.location.href = "/accessDenied.html";
    }
    $('#hello').append("<b>Привет, " + localStorage.getItem("username") + "</b>");
    (function () {
        $.ajax({
            type: "GET",
            url: "/progress-statuses",
            headers: {'Authorization': localStorage.getItem("token")},
            success: function (response) {
                $.each(response, (i, progress_status) => {
                    let deleteButton = '<button ' +
                        'id=' +
                        '\"' + 'btn_delete_' + progress_status.id + '\"' +
                        ' type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#delete-modal"' +
                        '>&times</button>';
                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + progress_status.id + '\"' +
                        ' type="button" class="btn btn-info btn_id">' +
                        progress_status.id +
                        '</button>';
                    let tr_id = 'tr_' + progress_status.id;
                    let row = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + get_More_Info_Btn + '</td>' +
                        '<td class=\"td_name\">' + progress_status.name + '</td>' +
                        '<td>' + deleteButton + '</td>' +
                        '</tr>';
                    $('#customerTable tbody').append(row);
                });

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
    })();

    (function () {
        let pathname = window.location.pathname;
        if (pathname === "../../html/progress/progress_status.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});