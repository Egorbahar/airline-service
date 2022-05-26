$(document).ready(function () {
    let startStatusMap = new Map();
    let progressStatusMap = new Map();
    $.ajax({
        type: "GET",
        url: "/airports",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, airport) => {
                let option = "<option value = " + airport.id + ">" + airport.code + "</option>";
                $("#dep_port").append(option);
                $("#arrival_port").append(option);
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
                $("#airplane").append(option);
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
                $("#captain").append(option);
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
                $("#pilot").append(option);
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
                $("#stewardess").append(option);
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
                $("#engineer").append(option);
            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/start-statuses",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, status) => {
                startStatusMap.set(status.name, status.id);
            })
        }
    });
    $.ajax({
        type: "GET",
        url: "/progress-statuses",
        headers: {'Authorization': localStorage.getItem("token")},
        success: function (response) {
            $.each(response, (i, status) => {
                progressStatusMap.set(status.name, status.id);
            })
        }
    });
    $("#add_new").submit(function (evt) {
        evt.preventDefault();
        let formData = {
            departureAirportId: parseInt($("#dep_port").val()),
            arrivalAirportId: parseInt($("#arrival_port").val()),
            planeId: parseInt($("#airplane").val()),
            captainId: parseInt($("#captain").val()),
            secondPilotId: parseInt($("#pilot").val()),
            stewardessId: parseInt($("#stewardess").val()),
            engineerId: parseInt($("#engineer").val()),
            flightStartStatusId: startStatusMap.get("Awaiting"),
            flightProgressStatusId: progressStatusMap.get("Pending")
        };
        if (formData.departureAirportId === formData.arrivalAirportId) {
            alert("You can't add two identical airports")
            window.location.href = '../flight/add_flight.html';
        } else {
            $.ajax({
                type: "POST",
                url: "/flights",
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
        }
    });
    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname === "../../html/user/user.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});
