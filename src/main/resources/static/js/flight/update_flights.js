$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "/airports",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, airport) => {
                let option = "<option value = " + airport.id + ">" + airport.code + "</option>";
                $("#departure_row").append(option);
                $("#departure_row_fl").append(option);
            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/airports",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, airport) => {
                let option = "<option value = " + airport.id + ">" + airport.code + "</option>";
                $("#arrival_row").append(option);
                $("#arrival_row_fl").append(option);
            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/airplanes",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, airplane) => {
                let option = "<option value = " + airplane.id + ">" + airplane.name + "</option>";
                $("#airplane_row").append(option);
                $("#airplane_row_fl").append(option);
            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/captains",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, captain) => {
                let option = "<option value = " + captain.id + ">" + captain.name + "</option>";
                $("#captain_row").append(option);
                $("#captain_row_fl").append(option);
            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/second-pilots",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, pilot) => {
                let option = "<option value = " + pilot.id + ">" + pilot.name + "</option>";
                $("#pilot_row").append(option);
                $("#pilot_row_fl").append(option);
            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/stewardesses",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, stewardess) => {
                let option = "<option value = " + stewardess.id + ">" + stewardess.name + "</option>";
                $("#stewardess_row").append(option);
                $("#stewardess_row_fl").append(option);

            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/engineers",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, engineer) => {
                let option = "<option value = " + engineer.id + ">" + engineer.name + "</option>";
                $("#engineer_row").append(option);
                $("#engineer_row_fl").append(option);
            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/start-statuses",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, status) => {
                let option = "<option value = " + status.id + ">" + status.name + "</option>";
                $("#start_status_row").append(option);
                $("#start_row").append(option);
                $("#start_status_row_fl").append(option);
            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/progress-statuses",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, status) => {
                let option = "<option value = " + status.id + ">" + status.name + "</option>";
                $("#progress_status_row").append(option);
                $("#progress_row").append(option);
                $("#progress_status_row_fl").append(option);
            })
        }
    });
    $("#update_customer_form").submit(function (evt) {
        evt.preventDefault();
        try {
            let id = $("#id").val();
            let formData = {
                id: id,
                departureAirportId: $("#departure_row").val(),
                arrivalAirportId: $("#arrival_row").val(),
                planeId: $("#airplane_row").val(),
                captainId: $("#captain_row").val(),
                secondPilotId: $("#pilot_row").val(),
                stewardessId: $("#stewardess_row").val(),
                engineerId: $("#engineer_row").val(),
                flightProgressStatusId: $("#progress_status_row").val(),
                flightStartStatusId: $("#start_status_row").val()
            };
            $.ajax({
                url: '/flights/' + id,
                type: 'PUT',
                headers: {'Authorization': localStorage.getItem("token")},
                contentType: "application/json",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (response) {
                    console.log("SUCCESS");
                    window.location.href = "../../html/flight/flight.html";
                },
                error: function (error) {
                    alert(error["responseText"])
                }
            });
        } catch (error) {
            console.error(error)
        }
    });
    $("#update_customer_form_flight_man").submit(function (evt) {
        evt.preventDefault();
        try {
            let id = $("#id_fl").val();
            let formData = {
                id: id,
                departureAirportId: $("#departure_row_fl").val(),
                arrivalAirportId: $("#arrival_row_fl").val(),
                planeId: $("#airplane_row_fl").val(),
                captainId: $("#captain_row_fl").val(),
                secondPilotId: $("#pilot_row_fl").val(),
                stewardessId: $("#stewardess_row_fl").val(),
                engineerId: $("#engineer_row_fl").val(),
                flightProgressStatusId: $("#progress_status_row_fl").val(),
                flightStartStatusId: $("#start_status_row_fl").val()
            };
            $.ajax({
                url: '/flights/' + id,
                type: 'PUT',
                headers: {'Authorization': localStorage.getItem("token")},
                contentType: "application/json",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (response) {
                    console.log("SUCCESS");
                    window.location.href = "../../html/flight/flight.html";
                },
                error: function (error) {
                    alert(error["responseText"])
                }
            });
        } catch (error) {
            console.error(error)
        }
    });
    $("#update_customer_form_status").submit(function (evt) {
        evt.preventDefault();
        try {
            let id = $("#id_flight").val();
            let startStatusId = $("#start_row").val();
            let progressStatusId = $("#progress_row").val();
            $.ajax({
                url: '/flights/' + id + '/flight-init/' + startStatusId,
                type: 'PATCH',
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (response) {
                    console.log("SUCCESS");
                    window.location.href = "../../html/flight/flight.html";
                },

                error: function (error) {
                    alert(error["responseText"])
                }
            });
            $.ajax({
                url: '/flights/' + id + '/flight-progress/' + progressStatusId,
                type: 'PATCH',
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (response) {
                    console.log("SUCCESS");
                    window.location.href = "../../html/flight/flight.html";
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
        let id_of_button = (event.srcElement.id);
        let id = id_of_button.split("_")[2];
        if (localStorage.getItem("role") === "ROLE_ADMIN") {
            $.ajax({
                type: "GET",
                url: "/flights/" + id,
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (flight) {
                    $("#div_updating").show();
                    $("#id").val(flight.id);
                    $("#departure_row").val(flight.departureAirportId);
                    $("#arrival_row").val(flight.arrivalAirportId);
                    $("#airplane_row").val(flight.planeId);
                    $("#captain_row").val(flight.captainId);
                    $("#pilot_row").val(flight.secondPilotId);
                    $("#stewardess_row").val(flight.stewardessId);
                    $("#engineer_row").val(flight.engineerId);
                    $("#progress_status_row").val(flight.flightProgressStatusId);
                    $("#start_status_row").val(flight.flightStartStatusId);
                },
                error: function (error) {
                    console.log(error);
                    alert(error["responseText"]);
                }
            });
        } else if (localStorage.getItem("role") === "ROLE_PROGRESS-DISPATCHER") {
            alert("sf");
            $.ajax({
                type: "GET",
                url: "/flights/" + id,
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (flight) {
                    $("#div_updating_status").show();
                    $("#id_flight").val(flight.id);
                    $("#progress_row").val(flight.flightProgressStatusId);
                    $("#start_row").val(flight.flightStartStatusId);
                },
                error: function (error) {
                    console.log(error);
                    alert(error["responseText"]);
                }
            });
        } else {
            $.ajax({
                type: "GET",
                url: "/flights/" + id,
                headers: {'Authorization': localStorage.getItem("token")},
                success: function (flight) {
                    alert(flight.flightProgressStatusId);
                    $("#div_updating_flight_man").show();
                    $("#id_fl").val(flight.id);
                    $("#departure_row_fl").val(flight.departureAirportId);
                    $("#arrival_row_fl").val(flight.arrivalAirportId);
                    $("#airplane_row_fl").val(flight.planeId);
                    $("#captain_row_fl").val(flight.captainId);
                    $("#pilot_row_fl").val(flight.secondPilotId);
                    $("#stewardess_row_fl").val(flight.stewardessId);
                    $("#engineer_row_fl").val(flight.engineerId);
                    $("#progress_status_row_fl").val(flight.flightProgressStatusId);
                    $("#start_status_row_fl").val(flight.flightStartStatusId);
                    if (flight.flightProgressStatusName !== "Pending") {
                        $("#start_status_row_fl").attr("disabled", true);
                    } else
                        $("#start_status_row_fl").attr("disabled", false);
                },
                error: function (error) {
                    console.log(error);
                    alert(error["responseText"]);
                }
            });
        }
    });
});