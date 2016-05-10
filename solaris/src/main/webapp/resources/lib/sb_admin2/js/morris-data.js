$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [
        {
            period: '2015 Q2',
            Deals: 4,
            Laptop: 5,
            Customer: 4
        }, {
            period: '2015 Q3',
            Deals: 10,
            Laptop: 14,
            Customer: 10
        }, {
            period: '2015 Q4',
            Deals: 11,
            Laptop: 16,
            Customer: 12
        }, {
            period: '2016 Q1',
            Deals: 12,
            Laptop: 18,
            Customer: 16
        }, {
            period: '2016 Q2',
            Deals: 15,
            Laptop: 22,
            Customer: 20
        }],
        xkey: 'period',
        ykeys: ['Deals', 'Laptop', 'Customer'],
        labels: ['Deals', 'Laptop Sold', 'Customer Registered'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "Download Sales",
            value: 12
        }, {
            label: "In-Store Sales",
            value: 30
        }, {
            label: "Mail-Order Sales",
            value: 20
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 90
        }, {
            y: '2007',
            a: 75,
            b: 65
        }, {
            y: '2008',
            a: 50,
            b: 40
        }, {
            y: '2009',
            a: 75,
            b: 65
        }, {
            y: '2010',
            a: 50,
            b: 40
        }, {
            y: '2011',
            a: 75,
            b: 65
        }, {
            y: '2012',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });

});
