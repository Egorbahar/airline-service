$(document).ready(function () {

    if (localStorage.getItem("role") === "ROLE_ADMIN") {
        $("#add-category").show();
        console.log(localStorage.getItem("token"));
    } else {
        window.location.href = "/accessDenied.html";
    }
    $('#hello').append("<b>Привет, " + localStorage.getItem("username") + "</b>");
    (function () {
        $.ajax({
            type: "GET",
            url: "/start-statuses",
            headers: {'Authorization': localStorage.getItem("token")},
            success: function (response) {
                $.each(response, (i, start_status) => {
                    let deleteButton = '<button ' +
                        'id=' +
                        '\"' + 'btn_delete_' + start_status.id + '\"' +
                        ' type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#delete-modal"' +
                        '>&times</button>';
                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + start_status.id + '\"' +
                        ' type="button" class="btn btn-info btn_id">' +
                        start_status.id +
                        '</button>';
                    let tr_id = 'tr_' + start_status.id;
                    let row = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + get_More_Info_Btn + '</td>' +
                        '<td class=\"td_name\">' + start_status.name + '</td>' +
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
        if (pathname === "../../html/start/start_status.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});