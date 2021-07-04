'use strict'

const drawTable = document.querySelector("#drawTableBody");
const customDrawBtn = document.querySelector("#customDrawBtn");

customDrawBtn.addEventListener("click", customDraw);

function customDraw() {
    fetch('http://localhost:8080/draws')
        .then(res => {
            console.log(res);
            return res.json();
        })
        .then(data => {
            const tr = document.createElement('tr');
            const td1 = document.createElement('td');
            const td2 = document.createElement('td');
            const td3 = document.createElement('td');

            td1.textContent = data.drawDate;
            td3.textContent = data.draw1 + ',' + data.draw2 + ',' + data.draw3 + ',' + data.draw4 + ',' + data.draw5 + ',' + data.draw6;

            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            drawTable.appendChild(tr);
        })
        .catch(err => {
            console.log("Draw Fetch Error", err);
        })
}