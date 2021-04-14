let nombre = "Paco";

function SaludarDesdeFuncion() {
    for (let i = 0; i < 5; index++) {
        console.log("Hola desde una funcion");
    }
}
console.log(SaludarDesdeFuncion)

function saludar(nombre) {
    console.log("Hola" + nombre);
}
console.log(saludar(nombre));

function suma(num1, num2) {
    if (num1 == 3) {
        return num1;
    } else {
        return num1 + num2;
    }
}
console.log(suma(2, 3))