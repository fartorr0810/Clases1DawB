/* 3.Realiza un script javascript y asócialo al html proporcionado de forma que al pulsar en el 
botón Modifica solicite un número y modifique el número de tarea indicada con el texto introducido 
en el campo de texto. Además al hacer click en un elemento de la lista cambiará de tachado a no tachado 
y viceversa. */
const lista = document.getElementById('lista');
const li = document.createElement('li');
li.textContent = ' elemento';
lista.appendChild(li);

let nodo = document.createElement("li");
nodo.innerHTML('Funciona porfavor :(( ');
let elementoaremplazar = document.querySelector("ul");
elementoaremplazar.parentNode.replaceChild(nodo, elementoaremplazar);
let elemento = document.querySelector("ol");
elemento.onmouseover = function(e) {
    document.getElementById("estado").innerHTML = ".done";
}
elemento.onmouseout = function(e) {
    document.getElementById("estado").innerHTML = ".done";

}