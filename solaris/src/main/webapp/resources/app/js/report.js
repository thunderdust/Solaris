var currentSectionIdTag = '#employee-report-section';
var currentActiveBtnIdTag = '#employee-report-section-btn';

$(document).ready(function () {
	setTheme();
	   
	hideAllSection();
	showReportSection(currentSectionIdTag);   
});

function drawAllCharts(){
	drawEmployeeCharts();
	drawProductCharts();
	drawSalesCharts(); 
	drawCustomerCharts();   
}

function showReportSection(id){
	$(currentSectionIdTag).hide();
	$(id).fadeIn();
	// Scroll to report charts div
	$('html, body').animate({
        scrollTop: $(id).offset().top
    }, 500);
	switch (id) {
		case '#employee-report-section':
			drawEmployeeCharts();
		case '#product-report-section':
			drawProductCharts();
		case '#sales-report-section':
			drawSalesCharts();
		case '#customer-report-section': 
			drawCustomerCharts(); 
		default:
		    drawAllCharts();
	}

	currentSectionIdTag = id;
	setActiveButton(currentSectionIdTag);
}

function hideAllSection(){
	var sections = $('.report-section-container');
	sections.hide();
}

function setActiveButton(id){
	if (currentActiveBtnIdTag) {
		$(currentActiveBtnIdTag).removeClass('active');
	}
	currentActiveBtnIdTag = id + '-btn';
	$(currentActiveBtnIdTag).addClass('active');
}


function setTheme(){

	/****************************** Build Theme **************************************/
        /**
		 * Dark theme for Highcharts JS
		 * @author Torstein Honsi
		 */

		Highcharts.theme = {
		   colors: ["#2b908f", "#90ee7e", "#f45b5b", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
		      "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
		   chart: {
		      backgroundColor: {
		         linearGradient: { x1: 0, y1: 0, x2: 1, y2: 1 },
		         stops: [
		            [0, '#2a2a2b'],
		            [1, '#3e3e40']
		         ]
		      },
		      style: {
		         fontFamily: "'Unica One', sans-serif"
		      },
		      plotBorderColor: '#606063'
		   },
		   title: {
		      style: {
		         color: '#E0E0E3',
		         textTransform: 'uppercase',
		         fontSize: '18px'
		      }
		   },
		   subtitle: {
		      style: {
		         color: '#E0E0E3'
		      }
		   },
		   xAxis: {
		      gridLineColor: '#707073',
		      labels: {
		         style: {
		            color: '#E0E0E3'
		         }
		      },
		      lineColor: '#707073',
		      minorGridLineColor: '#505053',
		      tickColor: '#707073',
		      title: {
		         style: {
		            color: '#A0A0A3'

		         }
		      }
		   },
		   yAxis: {
		      gridLineColor: '#707073',
		      labels: {
		         style: {
		            color: '#E0E0E3'
		         }
		      },
		      lineColor: '#707073',
		      minorGridLineColor: '#505053',
		      tickColor: '#707073',
		      tickWidth: 1,
		      title: {
		         style: {
		            color: '#A0A0A3'
		         }
		      }
		   },
		   tooltip: {
		      backgroundColor: 'rgba(0, 0, 0, 0.85)',
		      style: {
		         color: '#F0F0F0'
		      }
		   },
		   plotOptions: {
		      series: {
		         dataLabels: {
		            color: '#B0B0B3'
		         },
		         marker: {
		            lineColor: '#333'
		         }
		      },
		      boxplot: {
		         fillColor: '#505053'
		      },
		      candlestick: {
		         lineColor: 'white'
		      },
		      errorbar: {
		         color: 'white'
		      }
		   },
		   legend: {
		      itemStyle: {
		         color: '#E0E0E3',
		         fontWeight: 'normal',
		         marginBottom: '2px'
		      },
		      itemHoverStyle: {
		         color: '#FFF'
		      },
		      itemHiddenStyle: {
		         color: '#606063'
		      }
		   },
		   credits: {
		      style: {
		         color: '#666'
		      }
		   },
		   labels: {
		      style: {
		         color: '#707073'
		      }
		   },

		   drilldown: {
		      activeAxisLabelStyle: {
		         color: '#F0F0F3'
		      },
		      activeDataLabelStyle: {
		         color: '#F0F0F3'
		      }
		   },

		   navigation: {
		      buttonOptions: {
		         symbolStroke: '#DDDDDD',
		         theme: {
		            fill: '#505053'
		         }
		      }
		   },

		   // scroll charts
		   rangeSelector: {
		      buttonTheme: {
		         fill: '#505053',
		         stroke: '#000000',
		         style: {
		            color: '#CCC'
		         },
		         states: {
		            hover: {
		               fill: '#707073',
		               stroke: '#000000',
		               style: {
		                  color: 'white'
		               }
		            },
		            select: {
		               fill: '#000003',
		               stroke: '#000000',
		               style: {
		                  color: 'white'
		               }
		            }
		         }
		      },
		      inputBoxBorderColor: '#505053',
		      inputStyle: {
		         backgroundColor: '#333',
		         color: 'silver'
		      },
		      labelStyle: {
		         color: 'silver'
		      }
		   },

		   navigator: {
		      handles: {
		         backgroundColor: '#666',
		         borderColor: '#AAA'
		      },
		      outlineColor: '#CCC',
		      maskFill: 'rgba(255,255,255,0.1)',
		      series: {
		         color: '#7798BF',
		         lineColor: '#A6C7ED'
		      },
		      xAxis: {
		         gridLineColor: '#505053'
		      }
		   },

		   scrollbar: {
		      barBackgroundColor: '#808083',
		      barBorderColor: '#808083',
		      buttonArrowColor: '#CCC',
		      buttonBackgroundColor: '#606063',
		      buttonBorderColor: '#606063',
		      rifleColor: '#FFF',
		      trackBackgroundColor: '#404043',
		      trackBorderColor: '#404043'
		   },

		   // special colors for some of the
		   legendBackgroundColor: 'rgba(0, 0, 0, 0.5)',
		   background2: '#505053',
		   dataLabelsColor: '#B0B0B3',
		   textColor: '#C0C0C0',
		   contrastTextColor: '#F0F0F3',
		   maskColor: 'rgba(255,255,255,0.3)'
		};
		// End of theme
		// Apply the theme
        Highcharts.setOptions(Highcharts.theme);
}


function drawEmployeeCharts(){

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
};


function drawProductCharts(){

	/*************************   Product reports ************************************/

        // building product pie chart
        $('#product-pie-container').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: 'Product Brand Composition'
            },
            subtitle: {
	            text: 'Current brands distributions of product inventory'
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
                name: 'Brands',
                colorByPoint: true,
                data: [{
                    name: 'Lenovo',
                    y: 26,
                    sliced: true
                }, {
                    name: 'Samsung',
                    y: 15,
                    sliced: true
                }, {
                    name: 'Dell',
                    y: 15
                }, {
                    name: 'HP',
                    y: 10,
                    sliced: true
                }, {
                    name: 'Apple',
                    y: 9
                }, {
                    name: 'Asus',
                    y: 7,
                    selected: true
                }, {
                    name: 'Alienware',
                    y: 5
                }, {
                    name: 'Acer',
                    y: 2,
                    sliced: true
                }, {
                    name: 'Sony',
                    y: 2,
                    sliced: true
                }, {
                    name: 'Toshiba',
                    y: 2,
                    sliced: true
                }, {
                    name: 'Fujitsu',
                    y: 2,
                    sliced: true
                }, {
                    name: 'LG',
                    y: 1,
                    sliced: true
                },  {
                    name: 'Compaq',
                    y: 1,
                    sliced: true
                }, {
                    name: 'Benq',
                    y: 1,
                    sliced: true
                }, {
                    name: 'Sharp',
                    y: 1,
                    sliced: true
                }, {
                    name: 'NEC',
                    y: 1,
                    sliced: true
                }]
            }]
        });

        // product column chart 
        $('#product-column-container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: 'TOP 5 inventory brands'
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
	                text: 'Number of products in inventory'
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            pointFormat: 'Number of products from this brand in inventory: <b>{point.y}</b>'
	        },
	        series: [{
	            name: 'Population',
	            data: [
	                ['Lenovo', 26],
	                ['Samsung', 15],
	                ['Dell', 15],
	                ['HP', 10],
	                ['Apple', 9]
	            ],
	            dataLabels: {
	                enabled: true,
	                rotation: 0,
	                color: '#FFFFFF',
	                align: 'center',
	                format: '{point.y}', 
	                y: 0, // pixels down from the top
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        }]
        });      
};


function drawSalesCharts(){

};

function drawCustomerCharts(){

};