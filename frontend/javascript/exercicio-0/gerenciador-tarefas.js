import { Tarefa } from "./Tarefa.js"; 

const form = document.getElementById("form");

form.addEventListener("submit", event => {
    event.preventDefault();
    const nome = document.getElementById('tarefa').value;
    console.log(nome);
    const tarefa = new Tarefa(nome);
    tarefas.push(tarefa);
    renderizarTarefas();
});

function renderizarTarefas() {
    const lista = document.getElementById('listaTarefas');
    lista.innerHTML = '';
    tarefas.forEach(tarefa => {
        const item = document.createElement('li');
        item.textContent = tarefa.nome;
        lista.appendChild(item);
    });
}