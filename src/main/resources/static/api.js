var day;
var step;

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


for (step = 1; step < 4; step++) {
    day = document.getElementById("day" + step);
geteachday(day,step);


}
}

function start(){
    getalldayofmonth2();
    console.log("start");
    getcalendardays();
    //getalldayofmonth();
    //getalldayofmonthbyeach();


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
            document.getElementById( "day" + i + "status").value = rate.status;
            document.getElementById( "day" + i + "description").value = rate.description;
            document.getElementById( "day" + i + "note").value = rate.note;
           // console.log(rate.status);
            //console.log(rate.description);
            //console.log(rate.note);
            //console.log("day" + i + "status");
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
        document.getElementById("day" + step + "name").value = days[calendarday + step - 1];
    }

}

class DayOfMonth {
      constructor(id, status) {
        this.id = id;
        this.status = status;
      }
}

function savedata() {
    var ob =  { id: 1, stauts: "yellow", description:  "a", note: "a"};

var data = new FormData();
data.append( "json", JSON.stringify( ob ) );

var day1 = {"id": "1", "status": "yellow", "description":  "aa", "note": "aaa"};
var day2 = {"id": "2", "status": "yellow2", "description":  "aa2", "note": "aaa2"};

saveeachday(day1);
saveeachday(day2);



}

function saveeachday(day){

$.ajax({
    type: "POST",
    url: "/save",
    data: JSON.stringify(day),
    headers: {
    'Accept': 'text/plain, application/json, application/*+json, */*',
    'Content-Type': 'application/json'
    },
         success: function(data) {
           if (data.status == 'OK')
             console.log('Person has been added');
           else
           console.log(data);
             console.log('Failed adding person: ' + data.status + ', ' + data.errorMessage);
     }})
}

function savedata2(){
tab = [];
for (step = 1; step < 3; step++) {
    tab.push( new DayOfMonth(step, document.getElementById( "day" + step + "status").value));


}
console.log(tab[0]);
//console.log(tab[1]);

const result = JSON.parse(tab[0]);

console.log(result);

fetch('save/' + result)
    .then((resp) => resp.json()) ;

}

