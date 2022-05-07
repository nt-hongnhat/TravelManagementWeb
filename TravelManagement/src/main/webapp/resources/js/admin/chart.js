function generateColor() {
    let r = parseInt(Math.random()*255)
    let g = parseInt(Math.random()*255)
    let b = parseInt(Math.random()*255)
    return `rgb(${r}, ${g}, ${b} )`
}

function drawChart(id, statLabels=[], nameChart, statInfo=[]) {
    const colors = []
    for(let i = 0; i < statInfo.length; i++)
        colors.push(generateColor())

    const data = {
        labels: statLabels,
        datasets: [{
            label: nameChart,
            data: statInfo,
            backgroundColor: colors,
            hoverOffset: 4
        }]
    };

    const config = {
        type: 'doughnut',
        data: data,
    };

    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
 }

function drawBarChart(id, statLabels=[], nameChart, statInfo=[]) {
    const data = {
        labels: statLabels,
        datasets: [{
            label: statLabels,
            data: statInfo,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 205, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(201, 203, 207, 0.2)'
            ],
            borderColor: [
                'rgb(255, 99, 132)',
                'rgb(255, 159, 64)',
                'rgb(255, 205, 86)',
                'rgb(75, 192, 192)',
                'rgb(54, 162, 235)',
                'rgb(153, 102, 255)',
                'rgb(201, 203, 207)'
            ],
            borderWidth: 1
        }]
    };

    const config = {
        type: 'bar',
        data: data,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        },
    };

    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
}