$(document).ready(function () {
	setTheme();
	drawCharts(); 
});


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
};


function drawCharts(){

	// Spider web
	$('#sales-web-container').highcharts({

        chart: {
            polar: true,
            type: 'line'
        },

        title: {
            text: 'Target Achievement Overview',
            x: -80
        },

        pane: {
            size: '80%'
        },

        xAxis: {
            categories: ['Product Sales Amount', 'Order Amount', 'Sales Amount (k)', 'Customer Amount', 'Cusomter Growth'],
            tickmarkPlacement: 'on',
            lineWidth: 0
        },

        yAxis: {
            gridLineInterpolation: 'polygon',
            lineWidth: 0,
            min: 0,
            allowDecimals: true,
        },

        tooltip: {
            shared: true,
            pointFormat: '<span style="color:{series.color}">{series.name}: <b>{point.y:,.1f}</b><br/>'
        },

        legend: {
            align: 'right',
            verticalAlign: 'top',
            y: 70,
            layout: 'vertical',
            marginBottom: '10px'
        },

        series: [{
            name: 'Target Amount',
            data: [25, 25, 27, 40, 25],
            pointPlacement: 'on'
        }, {
            name: 'Current Amount',
            data: [18, 19, 25.1, 30, 15],
            pointPlacement: 'on'
        }]

    });

    // Sales Heatmap chart
    $('#sales-heatmap-container').highcharts({

        chart: {
            type: 'heatmap',
            marginTop: 60,
            marginBottom: 40,
            plotBorderWidth: 1
        },


        title: {
            text: 'Sales Frequency over weekdays'
        },

        subtitle: {
            text: 'Number of sales made on each weekdays monthly'
        },

        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May']
        },

        yAxis: {
            categories: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'],
            title: null
        },

        colorAxis: {
            min: 0,
            minColor: '#FFFFFF',
            maxColor: '#FF0000'
        },

        legend: {
            align: 'right',
            layout: 'vertical',
            margin: 0,
            verticalAlign: 'top',
            y: 50,
            symbolHeight: 280
        },

        tooltip: {
            formatter: function () {
                return '<b>' + this.series.xAxis.categories[this.point.x] + '</b> sold <br><b>' +
                    this.point.value + '</b> items on <br><b>' + this.series.yAxis.categories[this.point.y] + '</b>';
            }
        },

        series: [{
            name: 'Sales Frequency over weekdays',
            borderWidth: 1,
            data: [
	            	/* Jan */   [0, 0, 0], [0, 1, 0], [0, 2, 1], [0, 3, 1], [0, 4, 0], 
	                /* Feb */   [1, 0, 1], [1, 1, 1], [1, 2, 2], [1, 3, 0], [1, 4, 0], 
	                /* Mar */   [2, 0, 0], [2, 1, 0], [2, 2, 1], [2, 3, 0], [2, 4, 1], 
	                /* Apr */   [3, 0, 1], [3, 1, 3], [3, 2, 3], [3, 3, 4], [3, 4, 1], 
	                /* May */   [4, 0, 1], [4, 1, 2], [4, 2, 5], [4, 3, 7], [4, 4, 3]
                  ],
            dataLabels: {
                enabled: true,
                color: '#000000'
            }
        }]

    });

    // Customer stacked column chart 
    $('#customer-stacked-container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'monthly customer number summary'
        },
        xAxis: {
            categories: Highcharts.getOptions().lang.shortMonths
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Total customer count'
            },
            stackLabels: {
                enabled: true,
                style: {
                    fontWeight: 'bold',
                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                }
            }
        },
        legend: {
            align: 'right',
            x: -30,
            verticalAlign: 'top',
            y: 25,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        tooltip: {
            headerFormat: '<b>{point.x}</b><br/>',
            pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                    style: {
                        textShadow: '0 0 3px black'
                    }
                }
            }
        },
        series: [{
            name: 'customer with single order',
            data: [2, 4, 6, 11, 23]
        }, {
            name: 'customer with multiple orders',
            data: [0, 1, 3, 4, 7]
        }]
    });

};

