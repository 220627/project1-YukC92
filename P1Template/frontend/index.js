const url = "http://localhost:3000"; 

document.getElementById("loginButton").onclick = loginFunction; //this button will return
document.getElementById("filterReimbButton").onclick = getReimb;
document.getElementById("getAllReimbBtn").onclick = getAllReimb;

async function loginFunction() {

    let user = document.getElementById("username").value;
    let pass = document.getElementById("password").value;

    let userCreds = {
        username: user,
        password: pass
    }; 

    console.log(userCreds);

 
    let response = await fetch(url + "/login", {
        method: "POST",
        body: JSON.stringify(userCreds),
        credentials: "include"

    })

    console.log(response.status)

    if (response.status === 202) {

        let data = await response.json();

        document.getElementById("loginRow").innerText = "Welcome " + data.username;

    } else {

        document.getElementById("welcomeHead").innerText = "Login Failed! Try again..."
        document.getElementById("welcomeHead").style.color = "red";

    }

}

async function getAllReimb() {
    let response = await fetch(url + "/reimbursements");

    console.log(response);
    
    if (response.status === 202) {
        
        let data = await response.json();
        
        for(let reimbursement of data) {

            //create a table row for the incoming employee
            let row = document.createElement("tr");

            //create a data cell (td) for each employee field
            let cell1 = document.createElement("td");
            //fill the cell with the appropriate data
            cell1.innerHTML = reimbursement.reimb_id;
            //add.the new cell to the row
            row.appendChild(cell1);

            let cell2 = document.createElement("td")
            cell2.innerHTML = reimbursement.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td")
            cell3.innerHTML = reimbursement.submitted;
            row.appendChild(cell3);

            let cell4 = document.createElement("td")
            cell4.innerHTML = reimbursement.resolved;
            row.appendChild(cell4);

            let cell5 = document.createElement("td")
            cell5.innerHTML = reimbursement.description;
            row.appendChild(cell5);

            let cell6 = document.createElement("td")
            cell6.innerHTML = reimbursement.author.username;
            row.appendChild(cell6);

            let cell7 = document.createElement("td")
            cell7.innerHTML = reimbursement.resolver.username;
            row.appendChild(cell7);

            let cell8 = document.createElement("td")
            cell8.innerHTML = reimbursement.status.status;
            row.appendChild(cell8);

            let cell9 = document.createElement("td")
            cell9.innerHTML = reimbursement.type.type;
            row.appendChild(cell9);

            if (reimbursement.action == 1 && reimbursement.status.status_id == 1) {
                let cell10 = document.createElement("td");
                let approveBtn = document.createElement("button");
                approveBtn.setAttribute('id', 'approve');
                approveBtn.innerHTML = 'Approve';
                approveBtn.onclick = approve;
                approveBtn.setAttribute('reimb_id', reimbursement.reimb_id);
                cell10.appendChild(approveBtn);
                let denyBtn = document.createElement("button");
                denyBtn.setAttribute('id', 'deny');
                denyBtn.innerHTML = 'Deny';
                denyBtn.onclick = deny;
                denyBtn.setAttribute('reimb_id', reimbursement.reimb_id);
                cell10.appendChild(denyBtn);
                row.appendChild(cell10);
            }

            document.getElementById("reimbBody").appendChild(row);

        }

    } else {
        alert("Sorry! For manager only!")
    }   
}

async function getReimb() {
    let status = document.getElementById('status').value;
    
    let response = await fetch(url + "/reimbursements/" + status);

    
    console.log(response);
    
    if (response.status === 202) {
        
        let data = await response.json();
        
        for(let reimbursement of data) {

            //create a table row for the incoming employee
            let row = document.createElement("tr");

            //create a data cell (td) for each employee field
            let cell1 = document.createElement("td");
            //fill the cell with the appropriate data
            cell1.innerHTML = reimbursement.reimb_id;
            //add.the new cell to the row
            row.appendChild(cell1);

            let cell2 = document.createElement("td")
            cell2.innerHTML = reimbursement.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td")
            cell3.innerHTML = reimbursement.submitted;
            row.appendChild(cell3);

            let cell4 = document.createElement("td")
            cell4.innerHTML = reimbursement.resolved;
            row.appendChild(cell4);

            let cell5 = document.createElement("td")
            cell5.innerHTML = reimbursement.description;
            row.appendChild(cell5);

            let cell6 = document.createElement("td")
            cell6.innerHTML = reimbursement.author.username;
            row.appendChild(cell6);

            let cell7 = document.createElement("td")
            cell7.innerHTML = reimbursement.resolver.username;
            row.appendChild(cell7);

            let cell8 = document.createElement("td")
            cell8.innerHTML = reimbursement.status.status;
            row.appendChild(cell8);

            let cell9 = document.createElement("td")
            cell9.innerHTML = reimbursement.type.type;
            row.appendChild(cell9);

            if (reimbursement.action == 1 && reimbursement.status.status_id == 1) {
                let cell10 = document.createElement("td");
                let approveBtn = document.createElement("button");
                approveBtn.setAttribute('id', 'approve');
                approveBtn.innerHTML = 'Approve';
                approveBtn.onclick = approve;
                approveBtn.setAttribute('reimb_id', reimbursement.reimb_id);
                cell10.appendChild(approveBtn);
                let denyBtn = document.createElement("button");
                denyBtn.setAttribute('id', 'deny');
                denyBtn.innerHTML = 'Deny';
                denyBtn.onclick = deny;
                denyBtn.setAttribute('reimb_id', reimbursement.reimb_id);
                cell10.appendChild(denyBtn);
                row.appendChild(cell10);
            }


            document.getElementById("reimbBody").appendChild(row);

        }

    } else {
        alert("something went wrong! make sure your Java is running")
    }   
}

async function approve(el) {

    var buttons = el.target.parentElement.getElementsByTagName('button');

    for (var i = 0; i < buttons.length; i++) {
        buttons[i].setAttribute('disabled', 'disabled');
    }

    let reimb_id = el.target.getAttribute('reimb_id');
    
    let response = await fetch(url + "/reimbursements/" + reimb_id + "/approve", {
        method: "PUT",
        body: JSON.stringify(userCreds),
        credentials: "include"
    })
}

async function deny(el) {
    el.target.setAttribute('disabled', 'disabled');
    let reimb_id = el.target.getAttribute('reimb_id');
    
    let response = await fetch(url + "/reimbursements/" + reimb_id + "/deny", {
        method: "PUT",
        body: JSON.stringify(userCreds),
        credentials: "include"
    })
}