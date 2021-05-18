/* 1.-Introduce en el apartado de script el código necesario para extraer:
-El número de párrafos de la página.
-El texto del segundo párrafo.
-El número de enlaces de la página.
-La dirección del primer enlace.
-La dirección del penúltimo enlace.
-El número de enlaces del primer párrafo.
    Para agregar texto en la página deberás introducir una etiqueta div con el id=info 
    y añadir en ella toda la información detallada mediante:

    Var info=document.getElementById(“info”);
    Info.innerHTML = “Texto informativo”; 
*/
function ContarEnlaces() {
    var contenedor = document.getElementById("Escapatrajo");
    var parrafos = contenedor.getElementsByTagName("p");
    for (i in parrafos) {
        var enlaces = parrafos[i].getElementsByTagName("a");
    }
    alert(enlaces.length);
}