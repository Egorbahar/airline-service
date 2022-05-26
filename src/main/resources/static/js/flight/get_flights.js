$(document).ready(function () {
    $('#hello').append("<b>Hi, " + localStorage.getItem("username") + "</b>");
    (function () {
        if(localStorage.getItem("role") === "ROLE_PROGRESS-DISPATCHER")
        {
            $("#add-flight").css("display", "none");
        }
        $.ajax({
            type: "GET",
            url: "/flights",
            headers: {'Authorization': localStorage.getItem("token")},
            success: function (response) {
                $.each(response, (i, flight) => {
                    let deleteButton = '<button ' +
                        'id=' +
                        '\"' + 'btn_delete_' + flight.id + '\"' +
                        ' type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#delete-modal"' +
                        '>&times</button>';
                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + flight.id + '\"' +
                        ' type="button" class="btn btn-info btn_id">' +
                        flight.id +
                        '</button>';
                    let tr_id = 'tr_' + flight.id;
                    let row = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + get_More_Info_Btn + '</td>' +
                        '<td class=\"td_dep_port\">' + flight.departureAirportCode + '</td>' +
                        '<td class=\"td_arriv_port\">' + flight.arrivalAirportCode + '</td>' +
                        '<td class=\"td_airpalne\">' + flight.planeName + '</td>' +
                        '<td class=\"td_captain\">' + flight.captainName + '</td>' +
                        '<td class=\"td_pilot\">' + flight.secondPilotName + '</td>' +
                        '<td class=\"td_stewardess\">' + flight.stewardessName + '</td>' +
                        '<td class=\"td_engineer\">' + flight.engineerName + '</td>' +
                        '<td class=\"td_start\">' + flight.flightStartStatusName + '</td>' +
                        '<td class=\"td_progress\">' + flight.flightProgressStatusName + '</td>' +
                        '<td>' + deleteButton +'</td>' +
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
        if (pathname === "../../html/flight/flight.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});