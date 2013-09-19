/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function initEmpTable(message, dataT, m) {
    if (message == "nada_selecionado") {
        //Mensagem de nada selecionado
        if (typeof(table) != 'undefined') {
            table.destroy();
        }
        document.getElementById('EmpTable').innerHTML = '<p>Selecione um tema para visualização.</p>';
        document.getElementById('columnChart').innerHTML = '<p>Selecione um empreendimento para visualização.</p>';

    } else {
        //initPrevColumn('nada_selecionado',null);

        var data = new google.visualization.DataTable();
        data.addColumn('number', 'Nº');
        data.addColumn('string', 'Empreendimento');
        data.addColumn('string', 'Andamento');
        data.addColumn('string', 'Instituição');
        data.addRows(dataT);
        var table = new google.visualization.Table(document.getElementById('EmpTable'));

        var view = new google.visualization.DataView(data);
        view.setColumns([0, 1, 2, 3]);

        table.draw(view, {
            showRowNumber: false
        });

        google.visualization.events.addListener(table, 'select', function() {

            if (typeof(erroTip) != 'undefined') {
                return;
            }

            var selection = table.getSelection();
            var msg = '';
            empSelect = new Array();
            for (var i = 0; i < selection.length; i++) {
                var item = selection[i];
                empSelect.push(data.getValue(item.row, 0));
            }

            //passa os empreendimentos selecionados para a URL
            url.empSel = empSelect;
            document.getElementById('inputUrl').value = montaUrl();

            if (selection.length == 0) {
                msg = 'nada_selecionado';
            }
            initPrevColumn(msg, empSelect);
        });
        document.getElementById('columnChart').innerHTML = '<p>Selecione um empreendimento para visualização.</p>';

        if (m == 0) {
            table.setSelection([{row: 0}]);
            google.visualization.events.trigger(table, 'select', {});

        }else{
            empSelect = new Array();
            for(i=0; i< url.empSel.length;i++){
                for(var j=0;j<dataT.length; j++){
                    if(dataT[j][0] == url.empSel[i]){
                        empSelect.push({row: j});
                    }
                }
            }
            table.setSelection(empSelect);
            google.visualization.events.trigger(table, 'select', {});
            }
    }
}
