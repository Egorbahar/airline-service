function signOut(message) {
    $.ajax({
        type: "GET",
        url: "/authentication/sign-out?token=" + localStorage.getItem("token"),
        success: function (response) {
            localStorage.setItem("token", "")
            localStorage.setItem("role", "")
            localStorage.setItem("userId", "")
        },
        error: function (e) {
            alert(localStorage.getItem("token"));
            alert("ERROR: ", e);
            console.log("ERROR: ", e);
        }
    });
}