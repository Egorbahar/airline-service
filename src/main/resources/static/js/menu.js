$(document).ready(function () {
    if (localStorage.getItem("role") === "" || localStorage.getItem("role") === undefined) {
        window.location.href = "/accessDenied.html";
    }
    let startStatusSelector = $("#bth-start-status");
    let progressStatusSelector = $("#bth-progress-status")
    let secondPilotSelector = $("#bth-second-pilot");
    let categorySelector = $("#bth-category");
    let airplaneSelector = $("#bth-airplane");
    let airportSelector = $("#bth-airport");
    let stewardessSelector = $("#bth-stewardess");
    let flightSelector = $("#bth-flight");
    let engineerSelector = $("#bth-engineer");
    let captainSelector = $("#bth-captain");
    let userSelector = $("#bth-user");
    secondPilotSelector.hide();
    categorySelector.hide();
    airplaneSelector.hide();
    airportSelector.hide();
    stewardessSelector.hide();
    flightSelector.hide();
    engineerSelector.hide();
    captainSelector.hide();
    userSelector.hide();
    startStatusSelector.hide();
    progressStatusSelector.hide();

    $('#hello').append("<b>Hi, " + localStorage.getItem("username") + "</b>");
    if (localStorage.getItem("role") === "ROLE_ADMIN") {
        stewardessSelector.show();
        captainSelector.show();
        airportSelector.show();
        airplaneSelector.show();
        categorySelector.show();
        flightSelector.show();
        engineerSelector.show();
        secondPilotSelector.show();
        userSelector.show();
        startStatusSelector.show();
        progressStatusSelector.show();
    }
    if (localStorage.getItem("role") === "ROLE_FLIGHT-MANAGER") {
        stewardessSelector.show();
        captainSelector.show();
        airportSelector.show();
        airplaneSelector.show();
        categorySelector.show();
        flightSelector.show();
        engineerSelector.show();
        secondPilotSelector.show();
    }

    if (localStorage.getItem("role") === "ROLE_PROGRESS-DISPATCHER") {
        flightSelector.show();
    }

    stewardessSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/stewardess/stewardess.html";

    });

    captainSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/captain/captain.html";

    });

    airportSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/airport/airport.html";

    });
    airplaneSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/airplane/airplane.html";

    });
    secondPilotSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/pilot/pilot.html";

    });
    categorySelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/category/category.html";
    });
    flightSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/flight/flight.html";
    });
    engineerSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/engineer/engineer.html";
    });
    userSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/user/user.html"
    });
    startStatusSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/start/start_status.html"
    });
    progressStatusSelector.click(function (event) {
        event.preventDefault();
        window.location.href = "../html/progress/progress_status.html"
    });
});