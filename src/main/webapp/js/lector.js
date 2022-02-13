window.onload = getRandomLector;

let getRandomLectorRequest = new XMLHttpRequest();
// 0
// The request is not initialized.
// After you have created the XMLHttpRequest object, but before you have called the open() method.

function getRandomLector () {
	getRandomLectorRequest.open("GET", "Controller?command=Random", true);
	// 1
	// The request has been set up.
	// After you have called the open() method, but before you have called send().
	getRandomLectorRequest.onreadystatechange = showRandomLector;
	// mag NIET showRandomLector() zijn
	// want dat wordt het maar 1 keer uitgevoerd
	// en het moet telkens wanneer de readystate van het xhr veranderd worden uitgevoerd
	getRandomLectorRequest.send();
	// 2
	// The request has been sent.
	// After you have called send().
}

// 3
// The request is in process.
// After the browser has established a communication with the server, but before the server has completed the response.

// 4
// The request is completed.
// After the request has been completed, and the response data has been completely received from the server.

// callback function
function showRandomLector () {
	if (getRandomLectorRequest.readyState == 4) {
		if (getRandomLectorRequest.status == 200) {
			let lector = JSON.parse(getRandomLectorRequest.responseText);

			let lectorDiv = document.getElementById("lector");
			let lectorParagraph = lectorDiv.childNodes[0];
			let lectorText = document.createTextNode(lector.name + " " + lector.firstname); // kan ook lector["name"]

			if (lectorParagraph == null) {
				lectorParagraph = document.createElement('p');
				lectorParagraph.appendChild(lectorText);
				lectorDiv.appendChild(lectorParagraph);
			} else {
				lectorParagraph.removeChild(lectorParagraph.childNodes[0]);
				lectorParagraph.appendChild(lectorText);
			}
			setTimeout(getRandomLector, 1000);
		}
	}
}

let addlectorbutton = document.getElementById('addlectorbutton');
addlectorbutton.onclick = addLector;
// mag NIET addLector() zijn hier
// anders wordt het maar 1 keer uitgevoerd, namelijk na het laden van de html pagina
// en het moet telkens wanneer er op de button wordt gedrukt uitgevoerd worden

let addLectorRequest = new XMLHttpRequest();

function addLector () {
	let name = document.getElementById("lectorname").value;
	let firstname = document.getElementById("lectorfirstname").value;
	// encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
	let information = "name=" + encodeURIComponent(name)+"&firstname="+ encodeURIComponent(firstname);
	addLectorRequest.open("POST", "Controller?command=Add", true);
	// belangrijk dat dit gezet wordt anders kan de servlet de informatie niet interpreteren!!!
	// protocol header information
	addLectorRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	addLectorRequest.send(information);
}
