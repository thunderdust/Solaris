    $(document).ready(function () {


    	// Apply the theme
        Highcharts.setOptions(Highcharts.theme); 
        
    	/*************************   Employee reports ************************************/

        // building employee pie chart
        $('#employee-pie-container').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: 'Role Composition'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            series: [{
                name: 'Roles',
                colorByPoint: true,
                data: [{
                    name: 'General Manager',
                    y: 5
                }, {
                    name: 'Sales Manager',
                    y: 15,
                    sliced: true
                }, {
                    name: 'Sales Representative',
                    y: 55,
                    selected: true
                }, {
                    name: 'After-sales Service Agent',
                    y: 20
                }, {
                    name: 'Accountant',
                    y: 5
                }]
            }]
        });

        // Employee column chart 
        $('#employee-column-container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: 'Role numbers'
	        },
	        subtitle: {
	            text: 'As of May 2016'
	        },
	        xAxis: {
	            type: 'category',
	            labels: {
	                rotation: -45,
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: 'Number of employees'
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            pointFormat: 'Number of employees for this role: <b>{point.y}</b>'
	        },
	        series: [{
	            name: 'Population',
	            data: [
	                ['General Manager', 1],
	                ['Sales Manager', 3],
	                ['Sales Representative', 11],
	                ['After-sales Service Agent', 4],
	                ['Accountant', 1]
	            ],
	            dataLabels: {
	                enabled: true,
	                rotation: 0,
	                color: '#FFFFFF',
	                align: 'center',
	                format: '{point.y}', // one decimal
	                y: 0, // 10 pixels down from the top
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        }]
        });
	});