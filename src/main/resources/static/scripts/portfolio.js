
// var ctx = document.getElementById("portfolioChart");

// var myChart = new Chart(ctx, {
//     type: 'doughnut',
		
//     data:
//     {
//         labels: labelData,
//         datasets: [{
//             label: 'Stocks',
//             data: pieData,
//         }]
//     }
// }
// );

function getPieData(data1)
{	let data2=[];
    for(item of data1)
    {	if(item.statusCode == "2"){
    	data2.push(item)
        pieData.push(item.volume) 
        labelData.push(item.stockTicker)
        }
    }
        console.log(pieData)
        console.log(labelData)

        let labelDataUniq= labelData.filter(
            (stock,index)=>{
                return labelData.indexOf(stock)===index;
            }

        );

        console.log(labelDataUniq)
        for(stock of labelDataUniq)
        {
            let sum=0
            for(var i=0;i<labelData.length;i++)
                {
                    if(stock==labelData[i] && data2[i].buyOrSell =="buy")
                    {
                    
                        sum+=pieData[i]*data2[i].price
                    }
                    if(stock==labelData[i] && data2[i].buyOrSell =="sell")
                    {
                    
                        sum-=pieData[i]*data2[i].price
                    }
                    
                }
                pieDataUnique.push(sum)
                labelDataUnique.push(stock)
        }
        console.log(pieDataUnique)
        
        console.log(labelDataUnique)
        //myChart.data.labels.push(labelDataUniq);
        myChart.height = 500;
        myChart.update()
}


