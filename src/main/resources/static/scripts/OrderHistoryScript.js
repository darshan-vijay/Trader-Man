function getOrders()
{
	const url="http://localhost:8085/api/trades";
	fetch(url)//promise object to return data from Rest API
		.then(response => { return response.json();}) //resolve , data from resolve is passed to next then
		.then(stock => {			
			if (stock.length > 0) {
				 var temp = "";
				 stock.forEach((itemData) => {
                    temp += "<tr>";
                    temp += "<td>" + itemData.stockTicker + "</td>";
                    temp += "<td>" + itemData.price + "</td>";
                    temp += "<td>" + itemData.volume + "</td>";
                    temp += "<td>" + itemData.buyOrSell + "</td>";
                    if(itemData.statusCode==3){temp += "<td>" + "Failure" + "</td>";}
          			else if(itemData.statusCode==0 || itemData.statusCode==1 ){temp += "<td>" + "On Process" + "</td>";}
          			else if(itemData.statusCode==2){temp += "<td>" + "Success" + "</td>";}
                    temp += "<td>" + itemData.date + "</td>";
					if(itemData.statusCode==0){temp+= "<td><button type='button' onclick='populateDialog(" + itemData.id + ")' class='btn btn-primary' data-bs-toggle='modal' data-bs-target='#exampleModal'>Edit</button></td></tr>";}
					else if(itemData.statusCode==2){temp += "<td>" + "Order Successful" + "</td>";}
					else if(itemData.statusCode==1){temp += "<td>" + "Order Processing" + "</td>";}
					else if(itemData.statusCode==3){temp += "<td>" + "Order Failed" + "</td>";}
					});
				 document.getElementById('tbodyOrders').innerHTML = temp; 
				 }	
			})
		
}


function populateDialog(clicked_id){
//alert(clicked_id)	;	
		const url=`http://localhost:8085/api/${clicked_id}`;
	fetch(url)
		.then(response => { return response.json();})
		.then(stock => {	
            //document.getElementById('modalStockTicker').value = stock.stockTicker;	
            //document.getElementById('modalPrice').value = stock.price;					 
            document.getElementById('modalVolume').value = stock.volume;
            //document.getElementById('modalBuyOrSell').value = stock.buyOrSell;
			});	
}
function update()
{
	//read data from the form
	const data = { 	buyOrSell: itemData.buyOrSell,
					id: itemData.id,
					price: itemData.price,
					stockTicker: itemData.stockTicker,
					volume: document.getElementById('modalVolume').value,};
	fetch('http://localhost:8085/api/update', {
		method: 'PUT',
		headers: {
		'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	})
	.then((response) => response.json())
	.then((data) => {
		console.log('Success:', data);
		getOrders();
	})
	.catch((error) => {
		console.error('Error:', error);
	});
}