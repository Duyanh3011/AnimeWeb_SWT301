document.getElementById("form").addEventListener("submit", function (e) {
    var pass = document.getElementById("Npass").value;
    var Cpass = document.getElementById("Cpass").value;

    if (pass !== Cpass) {
        alert("The password is not matching!!!");
        e.preventDefault();
    }


});

