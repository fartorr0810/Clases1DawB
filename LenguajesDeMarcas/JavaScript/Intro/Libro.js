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
    const libro = new Libro("La fiesta de las hamburgesas", "JFK KENNEDY", 1121, "Terror");
}