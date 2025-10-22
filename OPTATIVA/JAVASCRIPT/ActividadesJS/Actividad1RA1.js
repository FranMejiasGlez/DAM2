let nombre = "Fran";
let edad = 27;
let esEstudiante = true;
console.log("Nombre: ", nombre, " Edad: ", edad, " Es estudiante: ", esEstudiante);

let num1 = 5;
let num2 = 10;
let suma = num1 + num2;
console.log("La suma de", num1, "y", num2, "es:", suma);
let resta = num2 - num1;
console.log("La resta de", num2, "y", num1, "es:", resta);
let multiplicacion = num1 * num2;
console.log("La multiplicación de", num1, "y", num2, "es:", multiplicacion);
let division = num2 / num1;
console.log("La división de", num2, "y", num1, "es:", division);

let mensajeCompleto = "Mi nombre es " + nombre + " y tengo " + edad+ " años";
console.log(mensajeCompleto);

console.log(`Nombre es: ${typeof nombre}, Edad es: ${typeof edad}, esEstudiante es: ${typeof esEstudiante}, mensajeCompleto es: ${typeof mensajeCompleto}`);
