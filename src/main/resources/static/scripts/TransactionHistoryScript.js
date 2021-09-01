function getOrders()
{
	const url="http://localhost:8085/api/trades";
	fetch(url)//promise object to return data from Rest API
		.then(response => { return response.json();}) //resolve , data from resolve is passed to next then
		.then(stock => {	
		console.log(stock);		
			if (stock.length > 0) {
				 var temp = "";
				 stock.forEach((itemData) => {
                    if(itemData.statusCode==2){
                        temp += "<tr>";
                        temp += "<td>" + itemData.stockTicker + "</td>";
                        temp += "<td>" + itemData.price + "</td>";
                        temp += "<td>" + itemData.volume + "</td>";
                        temp += "<td>" + itemData.buyOrSell + "</td>";
                        temp += "<td>" + itemData.date + "</td></tr>";
					}});
				 document.getElementById('tbodyOrders').innerHTML = temp; 
				 }	
			})
		
}