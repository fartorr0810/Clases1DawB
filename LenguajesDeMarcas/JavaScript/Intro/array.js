/* Crea un Arrayque contenga los valores 1,2,3,4,5.
 */
let listaaa = [1, 2, 3, 4, 5];





/* Muestra por consola la posición en la que se encuentra el número
4.
*/
console.log(listaaa[4]);

/*Muestra por consola la suma del segundo y tercer elemento del Array.Deberá ser
5.*/
console.log(listaaa[1] + listaaa[2]);
/*• Crea un Arraycon 4 cadenas y muestra por consola el número de caracteres de la segunda palabra del Array.*/
let cadenas = ["Huevos", "Salsicha", "Leche", "Mikado"];
console.log(cadenas[1].length);
/* Utiliza TEMPLATE STRINGS para mostrar el mensaje de“ La palabra XXXXXX tiene xx letras * / */
//--ejer6--
let numbers = [1, 2, 3, 4, 5, 6];
for (let index = 0; index < numbers.length; index++) {
    console.log(numbers[index]);
}
let number = 4;
console.log(number.type);
console.log(numbers.type);
numbers.shift;

numbers.pop;

let result = "";
for (let index = numbers.reverse.length; index > 0; index--) {
    result += numbers[index];
}
console.log(result);

/* Reemplazaloselementos3y4delarraypor10,23y54.Muéstraloporconsola */
numbers.splice(2, 2, 10, 23, 52);
for (let index = 0; index < numbers.length; index++) {
    console.log(numbers[index]);
}