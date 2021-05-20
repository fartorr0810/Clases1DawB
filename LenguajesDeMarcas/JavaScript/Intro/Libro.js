class Libro {
    constructor(titulo, autor, ano, genero) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.genero = genero;
    }
    mostrarInfo(titulo, autor, ano, genero) {
        return "El libro se llama" + titulo + " y su autor es: " + autor + " publicado en el año" + ano + "  es del genero" + genero;
    }

    libro = new Libro(prompt("Introduce el titulo"), prompt("Introduce el titulo"), prompt("Introduce el titulo"), prompt("Introduce el titulo"));
    libro1 = new Libro(prompt("Introduce el titulo"), prompt("Introduce el titulo"), prompt("Introduce el titulo"), prompt("Introduce el titulo"));
    libro2 = new Libro(prompt("Introduce el titulo"), prompt("Introduce el titulo"), prompt("Introduce el titulo"), prompt("Introduce el titulo"));
    listalibros = [libro, libro1, libro2];
    comprobarlibros(listalibros) {
        listalibros.forEach(element => {
            while (this.libro.titulo = null || this.libro.ano || this.libro.autor || this.libro.genero) {
                if (this.libro.titulo = null) {
                    this.libro.titulo = prompt("Introduce un titulo valido");
                }
                if (this.libro.ano = null) {
                    this.libro.ano = prompt("Introduce un titulo valido");
                }
                if (this.libro.autor = null) {
                    this.libro.autor = prompt("Introduce un titulo valido");
                }
                if (this.libro.genero = null) {
                    this.libro.genero = prompt("Introduce un titulo valido");
                }
                if (this.libro.ano.lenght != 4) {
                    this.libro.ano = prompt("Introduce un titulo valido");

                }
            }
            while (this.libro1.titulo = null || this.libro1.ano || this.libro1.autor || this.libro1.genero) {
                if (this.libro1.titulo = null) {
                    this.libro1.titulo = prompt("Introduce un titulo valido");
                }
                if (this.libro1.ano = null) {
                    this.libro1.ano = prompt("Introduce un titulo valido");
                }
                if (this.libro1.autor = null) {
                    this.libro1.autor = prompt("Introduce un titulo valido");
                }
                if (this.libro1.genero = null) {
                    this.libro1.genero = prompt("Introduce un titulo valido");
                }
            }
            while (this.libro2.titulo = null || this.libro2.ano || this.libro2.autor || this.libro2.genero) {
                if (this.libro2.titulo = null) {
                    this.libro2.titulo = prompt("Introduce un titulo valido");
                }
                if (this.libro2.ano = null) {
                    this.libro1.ano = prompt("Introduce un titulo valido");
                }
                if (this.libro2.autor = null) {
                    this.libro2.autor = prompt("Introduce un titulo valido");
                }
                if (this.libro2.genero = null) {
                    this.libro2.genero = prompt("Introduce un titulo valido");
                }

            }
        });
    }
}