//Clase Raton
class Raton {
    constructor(nombre, precio, marca, tipoConexion, dpi, botones, color, inalambrico, stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.tipoConexion = tipoConexion;
        this.dpi = dpi;
        this.botones = botones;
        this.color = color;
        this.inalambrico = inalambrico;
        this.stock = stock;
        this.fechaAgregado = new Date();
    }

    // Getters 
    getNombre() {
        return this.nombre;
    }

    getPrecio() {
        return this.precio;
    }

    getMarca() {
        return this.marca;
    }

    getEspecificaciones() {
        return ` 
            🎨 Color: ${this.color}
            ⚡ DPI: ${this.dpi}
            🔘 Botones: ${this.botones}
            📡 Conexión: ${this.tipoConexion} ${this.inalambrico ? '(Inalámbrico)' : '(Cableado)'}
            📦 Stock: ${this.stock} uds`
    };
    setStockEliminar() {
        this.stock--;
    }
    setStockAgregar() {
        this.stock++;
    }
    tieneStock() {
        return this.stock > 0;
    }

    agregarStock(cantidad) {
        this.stock += cantidad;
    }

    vender(cantidad = 1) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }

    getInfoCompleta() {
        return `
            🖱️ ${this.nombre}
            💰 Precio: $${this.precio}
            🏷️ Marca: ${this.marca}
            🎨 Color: ${this.color}
            ⚡ DPI: ${this.dpi}
            🔘 Botones: ${this.botones}
            📡 Conexión: ${this.tipoConexion} ${this.inalambrico ? '(Inalámbrico)' : '(Cableado)'}
            📦 Stock: ${this.stock} uds
        `;
    }
}


// Array de ratones para la tienda - DEBE IR DESPUÉS DE LA CLASE
const inventarioRatones = [
    new Raton("Logitech G502 Hero", 39.99, "Logitech", "USB", 25600, 11, "Negro", false, 12),
    new Raton("Razer DeathAdder V2", 19.99, "Razer", "USB", 20000, 8, "Negro, Verde", false, 8),
    new Raton("Logitech MX Master 3", 69.99, "Logitech", "Wireless", 4000, 7, "Gris, Grafito", true, 15),
    new Raton("SteelSeries Rival 3", 9.99, "SteelSeries", "USB", 8500, 6, "Blanco", false, 20),
    new Raton("Corsair Dark Core RGB/SE", 29.99, "Corsair", "Wireless", 18000, 8, "Negro RGB", true, 6),
    new Raton("Microsoft Classic Intellimouse", 19.99, "Microsoft", "USB", 3200, 5, "Blanco", false, 30),
    new Raton("Razer Viper Ultimate", 9.99, "Razer", "Wireless", 20000, 8, "Negro, Mercurio", true, 4),
    new Raton("HP X1000", 19.99, "HP", "USB", 1600, 3, "Negro", false, 50),
    new Raton("Logitech G Pro Wireless", 100.00, "Logitech", "Wireless", 25600, 8, "Negro", true, 7),
    new Raton("Redragon Cobra M711", 24.99, "Redragon", "USB", 10000, 7, "Negro, RGB", false, 25)
];

const carrito = [];

//Verificar el presupuesto
const PRESUPUESTO_MAXIMO = 100;

function aniadirCarrito(Raton) {

    //Llevar la cuenta de cuanto dinero tiene el carrito.
    var totalActual = 0;
    carrito.forEach(Raton => {
        totalActual += Raton.getPrecio();
    });

    // Verificar si agregar este producto superaría el presupuesto
    if (totalActual + Raton.getPrecio() > PRESUPUESTO_MAXIMO) {
        alert(`Presupuesto máximo de ${PRESUPUESTO_MAXIMO} €. Te quedan ${(PRESUPUESTO_MAXIMO - totalActual).toFixed(2)} € disponibles.`);
        return; //Return para que no se agrege aunque ese ultimo producto se pase del presupuesto
    }
    //Si existe stock del producto se agrega 
    if (Raton.tieneStock()) {
        carrito.push(Raton);
        Raton.setStockEliminar();
        calcularTotal();
        mostrarCarrito();
        mostrarRatones();
    } else {
        alert("No hay stock de este producto.");
    }
}


function eliminarDeCarrito(raton) {
    const indice = carrito.indexOf(raton);
    carrito.splice(indice, 1);
    raton.setStockAgregar();
    calcularTotal();
    mostrarCarrito();
    mostrarRatones();
}

function vaciarCarrito() {
    if (carrito.length > 0) {
        carrito.length = 0;
        document.getElementById('total').textContent = `0.00 €`;
        mostrarCarrito();
    } else {
        alert("El carrito ya está vacío.")
    }
}

function mostrarRatones() {
    const container = document.getElementById('ratones-container');
    container.innerHTML = '';
    inventarioRatones.forEach(Raton => {

        const tarjeta = document.createElement('div')
        tarjeta.className = 'tarjeta';
        tarjeta.innerHTML = `
            <h1>${Raton.getNombre()}</h1>
            <h2>${Raton.getMarca()}</h2>
            <p>${Raton.getPrecio() + " €"}</p>
            <p>${Raton.getEspecificaciones()}</p>
        `;
        const botonAniadir = document.createElement("button");
        botonAniadir.textContent = "Añadir al carrito";
        botonAniadir.onclick = () => aniadirCarrito(Raton);
        tarjeta.appendChild(botonAniadir);
        container.appendChild(tarjeta);

    });
}

function mostrarCarrito() {
    const container = document.getElementById('carrito');
    container.innerHTML = '';
    carrito.forEach(Raton => {

        const tarjeta = document.createElement('div');
        tarjeta.className = 'ElementoCarrito';
        tarjeta.innerHTML = `
            <h2>${Raton.getNombre()}</h2>
            <h3>${Raton.getMarca()}</h3>
            <p>${Raton.getPrecio() + " €"}</p>
            <p>${Raton.getEspecificaciones()}</p>
        `;

        const botonEliminar = document.createElement("button");

        botonEliminar.textContent = "Eliminar carrito";

        botonEliminar.onclick = () => eliminarDeCarrito(Raton);
        tarjeta.appendChild(botonEliminar);

        container.appendChild(tarjeta);

    });

}
function calcularTotal() {
    var total = 0;
    carrito.forEach(Raton => {
        total = total + Raton.getPrecio();

    });
    total = total.toFixed(2);
    document.getElementById('total').textContent = `${total}  €`;
}



//Mostrar lista de productos y lista en carrito
document.addEventListener('DOMContentLoaded', function () {
    mostrarRatones();
});
document.addEventListener('DOMContentLoaded', function () {
    mostrarCarrito();
});