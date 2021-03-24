let numerooo1 = prompt("numero1");
let numerooo2 = prompt("numero1");
let numerooo3 = prompt("numero1");
document.getElementById("1").textContent = numerooo1;
document.getElementById("2").textContent = numerooo2;
document.getElementById("3").textContent = numerooo3;

if (numerooo1 > numerooo2) {
    if (numerooo1 > numerooo3) {
        if (numerooo2 > numerooo3) {
            console.log(numerooo1);
            console.log(numerooo2);
            console.log(numerooo3);
            document.write(numerooo1, numerooo2, numerooo3);

        }
    }
} else if (numerooo2 > numerooo1) {
    if (numerooo2 > numerooo3) {
        if (numerooo3 > numerooo1) {
            console.log(numerooo2);
            console.log(numerooo1);
            console.log(numerooo3);
            document.write(numerooo2, numerooo1, numerooo3);

        } else {
            console.log(numerooo2);
            console.log(numerooo3);
            console.log(numerooo1);
            document.write(numerooo2, numerooo3, numerooo1);

        }
    } else if (numerooo3 > numerooo1) {
        if (numerooo3 > numerooo1) {
            if (numerooo2 > numerooo1) {
                console.log(numerooo3);
                console.log(numerooo2);
                console.log(numerooo1);
                document.write(numerooo3, numerooo2, numerooo1);

            } else {
                console.log(numerooo3);
                console.log(numerooo1);
                console.log(numerooo2);
                document.write(numerooo3, numerooo1, numerooo2);

            }
        }
    }
}