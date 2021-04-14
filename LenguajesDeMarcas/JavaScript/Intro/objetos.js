const persona = {
    nombre: 'Paco',
    edad: 20,
    hijos: ['Barman', 'Ironman', 'Yoda', 'Hulk']
}
for (const i in persona) {
    console.log(persona[i]);
}
let personaas = "Hola " + persona.nombre + " Tienes" + persona.edad + " años y tus hijos se llaman " + persona.hijos[0] + "," + persona.hijos[1] + "," + persona.hijos[2];
for (const i in persona) {

}
console.log(personaas);