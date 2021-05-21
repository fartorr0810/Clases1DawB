/* 
Crea un método que devuelva la información de 
la película utilizando los template strings con el formato indicado más abajo.

•Título: Memento. Director: Christopher Nolan. Reparto: .
Año: 2000. Género: thriller.
•Título: Apocalypse Now. Director: Francis Ford Coppola. Reparto: Martin Sheen,
Marlon Brando, Robert Duvall. Año: 1979. Género: bélica.
•Título: Gladiator. Director: Ridley Scott. Repartro: Giannina Facio,
 Russell Crowe, Joaquin Phoenix. 

Una vez introducidas ordena el array utilizando el 
método de comparación creado.
Muestra todas las películas haciendo uso del método de la clase. */
class Pelicula {
    constructor(titulo, director, reparto, ano, genero) {
        this.titulo = titulo;
        this.director = director;
        this.reparto = reparto;
        this.ano = ano;
        this.genero = genero;
    }
    Compararpeli(p2) {
        let result;
        if (this.ano > p2.ano) {
            result = 1;
            alert("Peli 1 mayor");
        } else if (this.ano < p2.ano) {
            result = -1
        } else if (this.ano = p2.ano) {
            result = 0;
        }
        return result;
    }
    AnadirActor(actor) {
        this.reparto.push(actor);
        //alert('Se anadio bien');
    }
    EliminarActor(actor) {
        let i = this.reparto.indexOf(actor);
        if (i !== -1) {
            this.reparto.splice(i, 1);
            //alert('Actor Eliminado');
        }
    }
}


function OrdenarArray(peliculas) {
    peliculas.sort();
}

function ImprimirElementosLista(peliculas) {
    for (let index = 0; index < peliculas.length; index++) {
        const element = peliculas[index];
        console.log(element);
    }
}

const peli1 = new Pelicula('Apocaypse Now', 'Francis Ford Coppola', ['Carrie-Anne Moss', 'Guy Pearce', 'Joe Pantoliano'], 1979, 'Belica');
const peli2 = new Pelicula('Gladiator', 'Ridley Scott', ['Giannina Facio', 'Russell Crowe', 'Joaquin Phoenix'], 2012, 'Belica');
const peli3 = new Pelicula('Memento', 'Christhofer Nolan', ['Carrie-Anne Moss', 'Guy Pearce', 'Joe Pantoliano'], 2000, 'Thriller');
let peliculas = [peli1, peli2, peli3];
console.log(peli1.Compararpeli(peli2));
peli1.AnadirActor('Juan');
peli1.EliminarActor('Guy Pearce');
console.log(OrdenarArray(peliculas));
console.log(ImprimirElementosLista(peliculas));