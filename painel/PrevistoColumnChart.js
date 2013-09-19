            
function initPrevColumn (msg, empSelect) {
    if (msg == "nada_selecionado"){
        //Mensagem de nada selecionado
   
        if(typeof(prevChart) != 'undefined'){
            prevChart.destroy();
        }

                    
    }else{
        if(typeof(secondChart) != 'undefined') {
            secondChart.destroy();
        
            document.getElementById('columnChart').innerHTML = '<p>Este empreendimento não possui previsão de investimento, por favor selecione outro empreendimento para visualização.</p>';

        }
        document.getElementById('columnChart').innerHTML = '';
        
        var serie = new Array();
        var colors = Highcharts.getOptions().colors;
        for(var i = 0; i < empSelect.length; i++){
            //faz a consulta dos convenios pela api do siconv
            var idEmp = empSelect[i];
            
            prevJson = "";
            
            $.getJSON('/copa/ServletEmpPrev?EMP=' + idEmp, function(json) {
                prevJson = json;
            });      
           
        
             
        serie.push({
            name: 'Empreendimento ' + idEmp,
            color: colors[i],
            type: 'column',
            data:[
            prevJson.prev[0].recPrev/1000000,
            prevJson.prev[0].recContra/1000000
            ]
        });
            
 
    }
            
    if(prevJson.prev[0].recPrev == "-1.0"){
        document.getElementById('columnChart').innerHTML = '<p>Este empreendimento não possui previsão de investimento, por favor selecione outro empreendimento para visualização.</p>';

    }else{      
              
        prevChart = new Highcharts.Chart({
            chart: {
                renderTo: 'columnChart',
                type: 'column'
            },
            title: {
                text: 'Recursos por Empreendimento'
            },
           
            xAxis: {
                title: {
                    enabled: true,
                    text: 'Valores'
                },
                startOnTick: true,
                endOnTick: true,
                showLastLabel: true,
                categories: ['Valor Previsto','Valor Contratado']
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Milhões de Reais (R$)'
                }
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.x +'</b><br/>'+
                    this.series.name +': '+ this.y +'<br/>'
                }
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: serie,
            
            exporting: {
                enabled: false
            }
    
        });              
    }
}
}