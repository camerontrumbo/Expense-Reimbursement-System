let form = document.getElementById("login-form");

window.onload = async function() {
    const sessionRes = await fetch(`/api/checkSession`);
    const sessionUserData = await sessionRes.json();

    if (sessionUserData.success) {
        console.log("in if statement");
        if (sessionUserData.object.userRoleId == 1) {
            window.location = `/employeedashboard?id=${sessionUserData.object.userRoleId}`;
        } else if (sessionUserData.object.userRoleId == 2) {
            window.location = `/managerdashboard?id=${sessionUserData.object.userRoleId}`;
        }
    }
}

form.onsubmit = async function(e) {
    e.preventDefault();

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let response = await fetch(`/api/login`, {
        method: "POST",
        body: JSON.stringify({
            ersUsername: username,
            ersPassword: password
        })
    });

    let responseData = await response.json();
    console.log(responseData);
    
    if (responseData.success) {
        if (responseData.object.userRoleId == 1) {
            window.location = `/employeedashboard?id=${responseData.object.ersUsersId}`;
        } else if (responseData.object.userRoleId == 2) {
            window.location = `/managerdashboard?id=${responseData.object.ersUsersId}`;
        }
    } else {
        let msgElem = document.getElementById("login-message");
        msgElem.innerText = responseData.description;
        msgElem.style = "display: block";
    }
}