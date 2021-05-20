/* 5 -Escriba  un  programa  que  pida  un  número  entero  mayor  que cero y calcule su factorial.
El  factorial  es  el  resultado  de  multiplicar  ese  número  por  sus anteriores hasta la
 unidad. */

let numeruu = prompt("Introduce un numero para calcular factorial");
let acum = 1;
for (let i = numeruu; i > 0; i--) {
    acum = acum * i;
}
console.log(acum);

/* 
6 -Escribe  un  programa  que  permita  ir  introduciendo  una  serie indeterminada
de  números  mientras  su  suma  no  supere  50. Cuando  esto  ocurra, 
 se  debe  mostrar  el  total  acumulado  y  el contador de cuantos números se han introducido */

let numeruuu = 0;
let acumm;
do {
    numeruuu = prompt("Ve metiendo numeros")
    acumm = acumm + 1;
} while (acumm < 50);