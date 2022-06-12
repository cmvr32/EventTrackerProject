window.addEventListener('load', function(evt){
	console.log('script.js loaded');
	init();
});

function init(){
	console.log('In init()');
	loadFlightList();
	document.flightForm.lookup.addEventListener('click', function(evt){
	evt.preventDefault();
	let flightId = document.flightForm.flightId.value;
	if(!isNaN(flightId) && flightId > 0) {
		getFlight(flightId);
	}	
});

	document.newFlightForm.addFlightButton.addEventListener('click', function(evt){
		evt.preventDefault();
		createFlight(e);
	})

}

function createFlight(e) {
	e.preventDefault();
	let form = document.newFlightForm;
	let newFlight = {
		location: form.location.value,
		date: form.date.value,
		acftNumber: form.acftNumber.value,
		flightType: form.flightType.value,
		missionTpe: form.missionType,
		dayInHours: form.dayInHours.value,
		nightInHours: form.nightInHours.value,
		nightVisionGoggles: form.nightVissionGoggles,
		duration: form.duration.value,
		pc: form.pcId.value,
		pi: form.piId.value,
		ce: form.ceId.value,
		me: form.moId.value,
		fi: form.fiId.value
	};
	console.log("flight added");
	sendNewFlight(newFlight);
}

function sendNewFlight(newFlight) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', `api/flights`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let flight = JSON.parse(xhr.responseText);
				displayFlight(flight);
			}
			else {
				displayError('Error creating film: ' + xhr.status + " " + xhr.statusText);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newFlight));
	console.log("new flight sent");
}

function loadFlightList(){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "api/flights")
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4) {
			if(xhr.status < 400){
			
				let flights = JSON.parse(xhr.responseText);
				console.log(flights)
				displayFlightList(flights);
				
			}
			else {
				//TODO describe how to show errors.
			}
		}
	};
	xhr.send();
}


function getFlight(flightId) {
	let xhr = new XMLHttpRequest();
	//xhr.open('GET', 'api/flights/' + flightId);
	xhr.open('GET', `api/flights/${flightId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 && xhr.responseText) {
				// * On success, if a response was received parse the film data
				//   and pass the film object to displayFilm().
				let flight = JSON.parse(xhr.responseText);
				console.log("getting flight");
				displayFlight(flight);
			}
			else {
				// * On failure, or if no response text was received, put "Film not found" 
				//   in the filmData div.
				displayError('Flight not found.');
			}
		}
	};
	xhr.send();
}

function displayError(message) {
	let dataDiv = document.getElementById('flightData');
	dataDiv.textContent = '';
	dataDiv.textContent = message;
}

function displayFlightList(flightList) {
	let tbody = document.getElementById('flightRows');
	tbody.textContent ='';
	for (let flight of flightList) {
		let tr = document.createElement('tr');
		tbody.appendChild(tr);
		//flight ID
		let td = document.createElement('td');
		td.textContent = flight.id;
		tr.appendChild(td);
		tr.addEventListener('click', showFlightDetails);
		//flight Location
		td = document.createElement('td');
		td.textContent = flight.location;
		tr.appendChild(td);
		//flight DATE
		td = document.createElement('td');
		td.textContent = flight.date;
		tr.appendChild(td);
		//flight ACFT#
		td = document.createElement('td');
		td.textContent = flight.acftNumber;
		tr.appendChild(td);
		//flight FlightType
		td = document.createElement('td');
		td.textContent = flight.flightType;
		tr.appendChild(td);
		//flight MissionType
		td = document.createElement('td');
		td.textContent = flight.missionType;
		tr.appendChild(td);
		//flight Day In Hours
		td = document.createElement('td');
		td.textContent = flight.dayInHours;
		tr.appendChild(td);
		//flight Night In Hours
		td = document.createElement('td');
		td.textContent = flight.nightInHours;
		tr.appendChild(td);
		//flight Night Vision Goggles
		td = document.createElement('td');
		td.textContent = flight.nightVisionGoggles;
		tr.appendChild(td);
		//flight Duration
		td = document.createElement('td');
		td.textContent = flight.durationInHours;
		tr.appendChild(td);
		//flight Pilot In Command
		td = document.createElement('td');
		td.textContent = flight.pcId;
		tr.appendChild(td);
		//flight Pilot
		td = document.createElement('td');
		td.textContent = flight.piId;
		tr.appendChild(td);
		//flight Crew Chief
		td = document.createElement('td');
		td.textContent = flight.ceId;
		tr.appendChild(td);
		//flight Medic
		td = document.createElement('td');
		td.textContent = flight.moId;
		tr.appendChild(td);
		//flight Instructor
		td = document.createElement('td');
		td.textContent = flight.fiId;
		tr.appendChild(td);	
	}
	
}

function showFlightDetails(evt) {
	evt.preventDefault();
	let row = evt.target;
	console.log(row);
	let flightId = row.parentElements.firstChildElement.textContent;
	console.log('details for flight id ' + flightId);
	
}

function displayFlight(flight) {

	let dataDiv = document.getElementById('flightData');
	dataDiv.textContent = '';
	//Display Title
	let h1 = document.createElement('h1');
	h1.textContent = flight.date;
	dataDiv.appendChild(h1);
	//Start of a list
	elem = document.createElement('ul');
	dataDiv.appendChild(elem);
	//flight location
	elem = document.createElement('li');
	elem.textContent = flight.location;
	dataDiv.appendChild(elem);
	//flight acft#
	elem = document.createElement('li');
	elem.textContent = flight.acftNumber;
	dataDiv.appendChild(elem);
	//flight flight type
	elem = document.createElement('li');
	elem.textContent = flight.flightType;
	dataDiv.appendChild(elem);
	//flight mission type
	elem = document.createElement('li');
	elem.textContent = flight.missionType;
	dataDiv.appendChild(elem);
	//flight dayInHours
	elem = document.createElement('li');
	elem.textContent = flight.dayInHours;
	dataDiv.appendChild(elem);
	//flight nightInHours
	elem = document.createElement('li');
	elem.textContent = flight.nightInHours;
	dataDiv.appendChild(elem);
	//flight nightVisionGoggles
	elem = document.createElement('li');
	elem.textContent = flight.nightVisionGoggles;
	dataDiv.appendChild(elem);
	//flight duration
	elem = document.createElement('li');
	elem.textContent = flight.duration + " hours";
	dataDiv.appendChild(elem);
	//flight PC
	elem = document.createElement('li');
	elem.textContent = flight.pcId;
	dataDiv.appendChild(elem);
	//flight PI
	elem = document.createElement('li');
	elem.textContent = flight.piId;
	dataDiv.appendChild(elem);
	//flight CE
	elem = document.createElement('li');
	elem.textContent = flight.ceId;
	dataDiv.appendChild(elem);
	//flight ME
	elem = document.createElement('li');
	elem.textContent = flight.moId;
	dataDiv.appendChild(elem);
	//flight FI
	elem = document.createElement('li');
	elem.textContent = flight.fiId;
	dataDiv.appendChild(elem);
	
}

