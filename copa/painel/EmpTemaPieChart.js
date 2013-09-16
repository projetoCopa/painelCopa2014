/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function initEmpreendimentoTema(dataSet, nSede, m) {

    empreendimentoTemaChart = new Highcharts.Chart({
        chart: {
            renderTo: 'pieChart',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false

        },
        title: {
            text: 'Quantidade de Empreendimentos por Tema - ' + nSede,
            x: -30
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b><br><b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                states: {
                    hover: {
                        brightness: 0.25

                    }
                },
                size: 230,
                allowPointSelect: true,
                slicedOffset: 20,
                cursor: 'pointer'
            },
            series: {
                point: {
                    slicedOffset: 20,
                    events: {
                        click: function() {
                            document.getElementById('temaSel').innerHTML = this.name;
                            url.idTema = this.id;
                            document.getElementById('inputUrl').value = montaUrl();
                            loadTable(this.id, 0);
                        }
                    }
                }
            }
        },
        series: [{
                type: 'pie',
                name: 'Nº Empreendimentos',
                data: dataSet

            }],
        exporting: {
            enabled: false
        }
    });

    if (m == 1) {
        for (i = 0; i < empreendimentoTemaChart.series[0].data.length; i++) {
            if (parseInt(url.idTema) == empreendimentoTemaChart.series[0].data[i].id) {
                document.getElementById('temaSel').innerHTML = empreendimentoTemaChart.series[0].data[i].name;
                //empreendimentoTemaChart.series[0].data[i].select(); //slice();
            }
        }
    }

}






