let form = document.getElementById("register-form");

form.onsubmit = async function(e) {
    e.preventDefault();

    let  username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let firstname = document.getElementById("first-name").value;
    let lastname = document.getElementById("last-name").value;
    let email = document.getElementById("user-email").value;
    let roleId = document.getElementById("roleId").value;

    let response = await fetch(`/api/register`, {
        method: 'POST',
        body: JSON.stringify({
            ersUsersId: 1,
            ersUsername: username,
            ersPassword: password,
            userFirstname: firstname,
            userLastName: lastname,
            userEmail: email,
            userRoleId: roleId
        })
    });

    let responseData = await response.json();
    console.log(responseData);

    if (responseData.success) {
        console.log("User Successfully Registered!");
        window.location = `/`;
    } else {
        let msgElem = document.getElementById("msg-elem");
        msgElem.innerText = responseData.description;
        msgElem.style = "display: block";
    }
}