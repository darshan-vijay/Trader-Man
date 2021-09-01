
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
{
    for(item of data1)
    {
        pieData.push(item.volume) 
        labelData.push(item.stockTicker)
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
                    if(stock==labelData[i])
                    {
                        sum+=pieData[i]*data1[i].price
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


