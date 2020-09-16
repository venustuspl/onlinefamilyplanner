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
var day;
var step;

for (step = 1; step < 3; step++) {
    day = document.getElementById("day" + step);

fetch('getalldayofmonthbyeach?day=' + step)
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
            span = createNode('span');
            li.innerHTML = rate.id + ' ' + rate.status +' '+ rate.description; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(day, li);
        })
    });

}
}

function start(){
    getalldayofmonth();
    getalldayofmonthbyeach();

}

function geteachday(){

}