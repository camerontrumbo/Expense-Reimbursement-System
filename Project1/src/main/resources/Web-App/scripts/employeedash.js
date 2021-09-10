const urlParams = new URLSearchParams(window.location.search);
const employeeId = urlParams.get("id");

window.onload = async function() {
    const sessionRes = await fetch(`/api/checkSession`);
    const sessionUserData = await sessionRes.json();

    if (!sessionUserData.success) {
        window.location = `/`;
    }

    populateData();
}

async function populateData() {
    const listResponse = await fetch(`/api/listEmployee?id=${employeeId}`);
    const listData = await listResponse.json();

    //For the reimbusements
    let reimbListElem = document.getElementById("table-container");
    reimbListElem.innerHTML =  ``;

    let table = document.createElement("table");
    table.className = `table table-striped`;

    let head = document.createElement("thead");
    let trhead = document.createElement("tr");

    let thReimbId = document.createElement("th");
    thReimbId.innerText = "Id";
    thReimbId.scope = `col`;

    let thAmount = document.createElement("th");
    thAmount.innerText = "Amount";
    thAmount.scope = `col`;

    let thSubmitted = document.createElement("th");
    thSubmitted.innerText = "Time Submitted";
    thSubmitted.scope = `col`;

    let thDescription = document.createElement("th");
    thDescription.innerText = "Description";
    thDescription.scope = `col`;

    let thAuthor = document.createElement("th");
    thAuthor.innerText = "Author Id";
    thAuthor.scope = `col`;

    let thStatusId = document.createElement("th");
    thStatusId.innerText = "Status";
    thStatusId.scope = `col`;

    let thType = document.createElement("th");
    thType.innerText = "Type";
    thType.scope = `col`;

    trhead.appendChild(thReimbId);
    trhead.appendChild(thAmount);
    trhead.appendChild(thSubmitted);
    trhead.appendChild(thDescription);
    trhead.appendChild(thAuthor);
    trhead.appendChild(thStatusId);
    trhead.appendChild(thType);

    head.appendChild(trhead);
    table.appendChild(head);
    reimbListElem.appendChild(table);

    //For the resolved reimb
    let reimbListResolvedElem = document.getElementById("resolved-table-container");
    reimbListResolvedElem.innerHTML =  ``;

    let tableR = document.createElement("table");
    tableR.className = `table table-striped`;

    let headR = document.createElement("thead");
    let trheadR = document.createElement("tr");

    let thReimbIdR = document.createElement("th");
    thReimbIdR.innerText = "ID";
    thReimbIdR.scope = `col`;

    let thAmountR = document.createElement("th");
    thAmountR.innerText = "Amount";
    thAmountR.scope = `col`;

    let thSubmittedR = document.createElement("th");
    thSubmittedR.innerText = "Time Submitted";
    thSubmittedR.scope = `col`;

    let thResolvedR = document.createElement("th");
    thResolvedR.innerText = "Time Resolved";
    thResolvedR.scope = `col`;

    let thDescriptionR = document.createElement("th");
    thDescriptionR.innerText = "Description";
    thDescriptionR.scope = `col`;

    let thAuthorR = document.createElement("th");
    thAuthorR.innerText = "Author Id";
    thAuthorR.scope = `col`;

    let thResolverR = document.createElement("th");
    thResolverR.innerText = "Resolver Id";
    thResolverR.scope = `col`;

    let thStatusIdR = document.createElement("th");
    thStatusIdR.innerText = "Status";
    thStatusIdR.scope = `col`;

    let thTypeR = document.createElement("th");
    thTypeR.innerText = "Type";
    thTypeR.scope = `col`;

    let thDetailR = document.createElement("th");
    thDetailR.innerText = "";
    thDetailR.scope = `col`;

    trheadR.appendChild(thReimbIdR);
    trheadR.appendChild(thAmountR);
    trheadR.appendChild(thSubmittedR);
    trheadR.appendChild(thResolvedR);
    trheadR.appendChild(thDescriptionR);
    trheadR.appendChild(thAuthorR);
    trheadR.appendChild(thResolverR);
    trheadR.appendChild(thStatusIdR);
    trheadR.appendChild(thTypeR);
    trheadR.appendChild(thDetailR);

    headR.appendChild(trheadR);
    tableR.appendChild(headR);
    reimbListResolvedElem.appendChild(tableR);

    listData.object.forEach(list => {
        if (list.reimbStatusId == 1) {
            thReimbId.innerText = "ID";
            let body = document.createElement("tbody");
            let tr = document.createElement("tr");

            let tdReimbId = document.createElement("th");
            tdReimbId.innerText = list.reimbId;
            tdReimbId.scope = `row`;

            let tdAmount = document.createElement("td");
            tdAmount.innerText = list.reimbAmount; 

            let tdSubmitted = document.createElement("td");
            tdSubmitted.innerText = list.reimbSubmitted;

            let tdDescription = document.createElement("td");
            tdDescription.innerText = list.reimbDescription;

            let tdAuthor = document.createElement("td");
            tdAuthor.innerText = list.reimbAuthor;

            let tdStatusId = document.createElement("td");
            if(list.reimbStatusId == 1) 
                tdStatusId.innerText = `Pending`;

            let tdType = document.createElement("td");
            if (list.reimbTypeId == 1) {
                tdType.innerText = `Food`;
            } else if (list.reimbTypeId == 2) {
                tdType.innerText = `Lodging`;
            } else if (list.reimbTypeId == 3) {
                tdType.innerText = `Travel`;
            } else {
                tdType.innerText = `Other`;
            }

            tr.appendChild(tdReimbId);
            tr.appendChild(tdAmount);
            tr.appendChild(tdSubmitted);
            tr.appendChild(tdDescription);
            tr.appendChild(tdAuthor);
            tr.appendChild(tdStatusId);
            tr.appendChild(tdType);

            body.appendChild(tr);
            table.appendChild(body);
        } else {
            thReimbId.innerText = "ID";
            let body = document.createElement("tbody");
            let tr = document.createElement("tr");

            let tdReimbId = document.createElement("th");
            tdReimbId.innerText = list.reimbId;
            tdReimbId.scope = `row`;

            let tdAmount = document.createElement("td");
            tdAmount.innerText = list.reimbAmount; 

            let tdSubmitted = document.createElement("td");
            tdSubmitted.innerText = list.reimbSubmitted;

            let tdResolved = document.createElement("td");
            tdResolved.innerText = list.reimbResolved;

            let tdDescription = document.createElement("td");
            tdDescription.innerText = list.reimbDescription;

            let tdAuthor = document.createElement("td");
            tdAuthor.innerText = list.reimbAuthor;

            let tdResolver = document.createElement("td");
            tdResolver.innerText = list.reimbResolver;

            let tdStatusId = document.createElement("td");
            if(list.reimbStatusId == 1) {
                tdStatusId.innerText = `Pending`;
            } else if(list.reimbStatusId == 2) {
                tdStatusId.innerText = `Denied`;
            } else {
                tdStatusId.innerText = `Approved`;
            }

            let tdType = document.createElement("td");
            if (list.reimbTypeId == 1) {
                tdType.innerText = `Food`;
            } else if (list.reimbTypeId == 2) {
                tdType.innerText = `Lodging`;
            } else if (list.reimbTypeId == 3) {
                tdType.innerText = `Travel`;
            } else {
                tdType.innerText = `Other`;
            }

            tr.appendChild(tdReimbId);
            tr.appendChild(tdAmount);
            tr.appendChild(tdSubmitted);
            tr.appendChild(tdResolved);
            tr.appendChild(tdDescription);
            tr.appendChild(tdAuthor);
            tr.appendChild(tdResolver);
            tr.appendChild(tdStatusId);
            tr.appendChild(tdType);

            body.appendChild(tr);
            tableR.appendChild(body);
            reimbListResolvedElem.appendChild(tableR);
        }
    });
}

let logoutbtn = document.getElementById("logoutbtn");
logoutbtn.onclick = async function() {
    let logoutRes = await fetch(`/api/logout`);
    let logoutData = await logoutRes.json();
    if (logoutData.success) {
        window.location = `/`;
    }
}

let createReimbForm = document.getElementById("createReimb-Form");
createReimbForm.onsubmit = async function(e) {
    e.preventDefault();

    let reimbAuthor = employeeId;
    let reimbAmount = document.getElementById("amount").value;
    let reimbDescription = document.getElementById("Descriptoin").value;
    
    let reimbTypeId = document.getElementById("type").value;

    let response = await fetch(`/api/createReimb`, {
        method: 'POST',
        body: JSON.stringify({
            reimbAmount: reimbAmount,
            reimbDescription: reimbDescription,
            reimbAuthor: reimbAuthor,
            reimbStatusId: 1,
            reimbTypeId: reimbTypeId
        })
    });

    let responseData = await response.json();

    if (responseData.success) {
        console.log("Reimbursement Successfully added!");
    }
    populateData();
}

let showFormBtn = document.getElementById("openbtn");
let formContain = document.getElementById("form-container");
let openBtn = document.getElementById("openbtn");
let showForm = false;
showFormBtn.onclick = function() {
    if (!showForm) {
        formContain.style = "display: block";
        openBtn.innerText = "-";
        showForm = true;
    } else {
        formContain.style = "display: none";
        openBtn.innerText = "+";
        showForm = false;
    }
}