fetch('http://localhost:8080/api/holdings')
    .then(response => response.json())
    .then(data => makeTable(data))
    .catch(error => console.log(`Oh no! ${error}`))

const titlecase = (name) => {
    let title = name.charAt(0).toUpperCase() + name.slice(1);
    return title;
}

const makeTable = (results) => {
    console.log(results);
    const body = document.querySelector('tbody');
    results.forEach((holding, index) => {
        const htmlTemplate = `
    <tr class="holding" id="holding-${index}">
      <td>${titlecase(holding.ticker)}</td>
      <td>${titlecase(holding.position)}</td>
      <td>${holding.volume}</td>
      <td>${holding.price}</td>
      <td>${holding.lastClose}</td>
      <td>${holding.pl}</td>
      <td>${holding.advice}</td>
    </tr>
    `;
        body.innerHTML += htmlTemplate;
    })

}