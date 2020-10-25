var day;
var step;
var monthtable = [31];

function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}



function validateurl(url) {
    var reg = new RegExp( '(http|ftp|https)://[\\w-]+(\\.[\\w-]+)+([\\w-.,@?^=%&:/~+#-]*[\\w@?^=%&;/~+#-])?' );
    if (!reg.test(url))
        return false;
    else
        return true;
}
function validateemail(email) {
    var reg = new RegExp( '' );
    if(!reg.test(email))
        return false;
    else
        return true;
}


function start(){
    getalldayofmonth2();
    getcalendardays();
    console.log("start");

    var today = new Date();
    window.location.href = "#day" + today.getDate() + "box";
    console.log(today.getDate());
    savedatatest();
}

function getalldayofmonth(){
var days = document.getElementById("days");

fetch('getalldayofmonth')
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
            span = createNode('span');
            li.innerHTML = rate.id + ' ' + rate.status +' '+ rate.description; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(days, li);
        })
    });

}

function getalldayofmonthbyeach(){
for (step = 1; step < 32; step++) {
    day = document.getElementById("day" + step);
geteachday(day,step);

}
}

function geteachday(day, step){
fetch('getalldayofmonthbyeach?day=' + step)
    .then(response => response.text())
    .then(text => day.innerHTML = text);

console.log(step);
console.log(day);

}

function getalldayofmonth2(){
var i = 1;

fetch('getalldayofmonth')
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            document.getElementById( "day" + rate.id + "status").value = rate.status;
            document.getElementById( "day" + rate.id + "description").value = rate.description;
            document.getElementById( "day" + rate.id + "note").value = rate.note;

            var dayofmonth = {"id": rate.id, "status": rate.status,
                    "description":  rate.description,
                    "note": rate.note, "saved": rate.saved};

               //     console.log('month');
            monthtable[rate.id] = dayofmonth;
            //console.log(monthtable[rate.id].status);
            i++;
                  })
    });

}
function getcalendardays(){

    const now = new Date();
    someDateAsString = new Date(now.getFullYear(), now.getMonth(), 1);
    var calendarday = someDateAsString.getDay();

    const days = ["Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota","Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota","Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota","Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota","Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota"];

    for (step = 1; step < 32; step++) {
        document.getElementById("day" + step + "name").value = days[calendarday + step - 1] ;
    }

}

class DayOfMonth {
      constructor(id, status) {
        this.id = id;
        this.status = status;
      }
}

function savedata() {
var datetime = new Date().toLocaleString();
//console.clear();
    for (step = 1; step < 32; step++) {
    var day = {"id": step, "status": document.getElementById( "day" + step + "status").value,
        "description":  document.getElementById( "day" + step + "description").value,
        "note": document.getElementById( "day" + step + "note").value, "saved": datetime };

       // console.log(' saving ' );
        //console.log(monthtable[step]);
        //console.log(step);
        //console.log(' end saving -------------------');

    if ((document.getElementById( "day" + step + "status").value != monthtable[step].status)||
    (document.getElementById( "day" + step + "description").value != monthtable[step].description)||
    (document.getElementById( "day" + step + "note").value != monthtable[step].note) ) {
    console.log(' nierowne');
    console.log(step);
    saveeachday(day);

    }
    else {
    console.log(' rowne');

    }

}
fetch('sendemail');
window.location.reload(true);
document.getElementById("savestatus").innerHTML = "Saved on: " + datetime;

}


function saveeachday(day){
$.ajax({
    type: "PUT",
    url: "/save",
    data: JSON.stringify(day),
    headers: {
    'Accept': 'text/plain, application/json, application/*+json, */*',
    'Content-Type': 'application/json'
    },
         success: function(data) {

     }})
}


function savedatatest() {
var datetime = new Date().toLocaleString();

    for (step = 1; step < 32; step++) {
    var day = {"id": step, "status": document.getElementById( "day" + step + "status").value,
        "description":  document.getElementById( "day" + step + "description").value,
        "note": document.getElementById( "day" + step + "note").value, "saved": datetime };

    saveeachday(day);

}

}