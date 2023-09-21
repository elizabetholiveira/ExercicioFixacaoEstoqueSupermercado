const formulariopost = document.getElementById("formulariopost");

formulariopost.addEventListener("submit", event => {
  event.preventDefault();

  const formData = new FormData(formulariopost);
  const data = {};
  
  formData.forEach((value, key) => {
    data[key] = value;
  });

  fetch("http://localhost:8080/api/estoque", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(res => res.json())
  .then(data => {
    console.log(data);
    mensagem(); 
  })
  .catch(error => console.error(error));
});

function mensagem() {
  alert("Item adicionado com sucesso!");
  window.location.reload(true);
}

fetch("http://localhost:8080/api/estoque").then((data)=>{
    return data.json();
    }).then((todos) => {
    let data1 = "";
    todos.map((values) => {
        data1 += `
        <tbody>
            <tr>
            <th scope="row">${values.id}</td>
            <td>${values.name}</td>
            <td>${values.price}</td>
            <tr>
        </tbody>
        `
    })
    document.getElementById("tudo").innerHTML = data1;
    console.log(todos);
})

function pesquisarProduto() {
    const idInput = document.getElementById("idInput").value;

    fetch(`http://localhost:8080/api/estoque/${idInput}`)
        .then(response => response.json())
        .then(produto => {
            const buscaid = document.getElementById("buscaid");
            buscaid.innerHTML = `
                <tr>
                    <th scope="row">${produto.id}</th>
                    <td>${produto.name}</td>
                    <td>${produto.price}</td>
                </tr>
            `;
        })
        .catch(error => console.error(error));
}