import { Computador } from "./Computador.js";

const computador1 = new Computador('HP', 'Pavillon', '500 GB', 'Asus', 'Intel');
const computador2 = new Computador('Lenovo', 'L-4000', '1 TB', 'Asus', 'AMD');
const computador3 = new Computador('Samsung', 'S-500', '500 GB', 'Gigabyte', 'Intel');

function retornaMapComputadores(computador) {
    const mapComputadores = new Map();
    mapComputadores.set(computador.getId(), computador);

    return mapComputadores;
}

let mapComputadores = retornaMapComputadores(computador1);
mapComputadores = retornaMapComputadores(computador2);
mapComputadores = retornaMapComputadores(computador3);

const lista = document.getElementById('lista-computador');
lista.innerHTML = '';
mapComputadores.forEach(computador => {
    const ul = document.createElement('ul');
    const li = document.createElement('li');

    li.textContent = computador.marca;
    ul.appendChild(li);
});