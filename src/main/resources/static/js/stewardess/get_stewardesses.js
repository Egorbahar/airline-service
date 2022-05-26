$(document).ready(function () {

    if (localStorage.getItem("role") === "ROLE_ADMIN" || localStorage.getItem("role") === "ROLE_FLIGHT-MANAGER") {
        $("#add-category").show();
        console.log(localStorage.getItem("token"));
    } else {
        window.location.href = "/accessDenied.html";
    }
    $('#hello').append("<b>Привет, " + localStorage.getItem("username") + "</b>");
    (function () {
        $.ajax({
            type: "GET",
            url: "/stewardesses",
            headers: {'Authorization': localStorage.getItem("token")},
            success: function (response) {
                $.each(response, (i, stewardess) => {
                    let deleteButton = '<button ' +
                        'id=' +
                        '\"' + 'btn_delete_' + stewardess.id + '\"' +
                        ' type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#delete-modal"' +
                        '>&times</button>';
                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + stewardess.id + '\"' +
                        ' type="button" class="btn btn-info btn_id">' +
                        stewardess.id +
                        '</button>';
                    let tr_id = 'tr_' + stewardess.id;
                    let row = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + get_More_Info_Btn + '</td>' +
                        '<td class=\"td_name\">' + stewardess.name + '</td>' +
                        '<td class=\"td_flightNumber\">' + stewardess.flightsNumber + '</td>' +
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
        if (pathname === "../../html/stewardess/stewardess.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});