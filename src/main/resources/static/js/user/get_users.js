$(document).ready(function () {
    if (localStorage.getItem("role") === "ROLE_ADMIN") {
        $("#add-user").show();
        console.log(localStorage.getItem("token"));
    } else {
        window.location.href = "/accessDenied.html";
    }
    $('#hello').append("<b>Hi, " + localStorage.getItem("username") + "</b>");
    (function () {
        $.ajax({
            type: "GET",
            url: "/users",
            headers: {'Authorization': localStorage.getItem("token")},
            success: function (response) {
                $.each(response, (i, user) => {
                    let deleteButton = '<button ' + 'id=' + '\"' + 'btn_delete_' + user.id + '\"' + ' type="button" ' +
                        'class="btn btn-danger btn_delete" data-toggle="modal" data-target="#delete-modal"' + '>&times</button>';
                    let get_More_Info_Btn = '<button' + ' id=' + '\"' + 'btn_id_' + user.id + '\"' + ' type="button"' +
                        ' class="btn btn-info btn_id">' + user.id + '</button>';
                    let tr_id = 'tr_' + user.id;
                    let row = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + get_More_Info_Btn + '</td>' +
                        '<td class=\"td_username\">' + user.username + '</td>' +
                        '<td class=\"td_role\">' + user.roleName + '</td>' +
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
        if (pathname === "../../html/user/user.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});