<%-- 
    INDEX SEM LOGIN : painelCopa.jsp

    Document   : painelCopa
    Created on : 23/05/2013, 10:56:28
    Author     : Barbara
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painel Copa 2014</title>
        <script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"></script>
        <script src="/copa/js/jquery-1.7.2.min.js" type="text/javascript"></script>    
        <script src="/copa/js/opentip-jquery.js" type="text/javascript"></script>
        <script type="text/javascript" src="/copa/js/d3.v3.min.js"></script>
        <link href="/copa/css/opentip.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="http://code.highcharts.com/modules/exporting.js"></script>
        <script type="text/javascript" charset="utf-8" src="EmpTemaPieChart.js"></script>
        <script type="text/javascript" charset="utf-8" src="EmpTable.js"></script>
        <script type="text/javascript" charset="utf-8" src="PrevistoColumnChart.js"></script>
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <link href="painelCopa.css" rel="stylesheet" type="text/css" />
        <script src="/copa/js/jq-ui.min.js"></script>
        <link href="/copa/css/jq-ui.css" rel="stylesheet" type="text/css" /> 
        <script src="http://code.highcharts.com/highcharts.js"></script>
    </head>
    <body>
        <div class="container" id="container" style="min-height: 1285px;">     
            <div id="cabecalhoMinisterio">
                <div class="containerVisPublicaPage">
                    <a href="http://www.brasil.gov.br" id="linkBrasil" target="_blank" ></a>
                    <a href="http://www.acessoainformacao.gov.br" id="linkAcessoInformacao" target="_blank" ></a>
                </div>
            </div>

            <div class="conteinerPainelCopa ">
                <div class="headerPainel">
                    <span class="titlePainel">Copa 2014: Valores Investidos nos Empreendimentos</span> 
                    <a href="sobre.jsp" target="_blank" >
                        <span>Sobre o Painel</span>
                        <img src="/copa/painel/images/icon_info_agenda.png">
                    </a>
                </div>

                <div class="url" id="url">
                    <div class="urlText">Para compartilhar o painel, copie a url abaixo:</div>
                    <input type="text" name="inputUrl" id="inputUrl" class="text ui-widget-content ui-corner-all inputUrlLabel">
                </div>

                <div class="mapWrapper">
                    <div class="mapTitle">Selecione o Estado:</div>
                    <%@include file="mapa.jsp" %>
                    <div class="legend">
                        <div class="greenLegend">
                            <p>Estado que possui Cidade-Sede</p>
                        </div>
                    </div>
                </div>
                <div class="pie" > 
                    <div class="pieTitle">Selecione o Tema:</div>
                    <div class="pieChart" id="pieChart"></div>
                </div> 
                <div id="sedeTema" class="sedeTema">
                    <div class="sedeSelecionada">
                        <span id="titleSede" class="titleSede" >Cidade Sede: </span>
                        <span id="sedeSel" class="sedeSel">Nacional</span>
                    </div>
                    <div class="temaSelecionado">
                        <span id="titleTema" class="titleTema" >Tema: </span>
                        <span id="temaSel" class="temaSel">(Selecione o Tema)</span>
                    </div>
                </div>
                <div class="msg" id="msg">
                    <p>Selecione um ou mais empreendimentos na tabela abaixo para visualizar os valores dos recursos.</p>
                    <p>Para selecionar mais de um empreendimento segure o bot�o Ctrl e clique nos empreendimentos desejados.</p>
                </div>
                <div class="EmpTable" id='EmpTable'> </div>
                <div class="columnChart" id="columnChart">
                    <p>Selecione um empreendimento para visualiza��o.</p>
                </div>
                <div class="creativeCommons" id="creativeCommons">
                    <a rel="license" href="http://creativecommons.org/licenses/by-nc/3.0/br/deed.pt_BR" target="_blank"><img alt="Licen�a Creative Commons" style="border-width:0" src="http://i.creativecommons.org/l/by-nc/3.0/br/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" href="http://purl.org/dc/dcmitype/InteractiveResource" property="dct:title" rel="dct:type">Este trabalho</span> est� licenciado sob uma <a rel="license" href="http://creativecommons.org/licenses/by-nc/3.0/br/deed.pt_BR" target="_blank">licen�a Creative Commons Atribui��o-N�oComercial 3.0 Brasil</a>.
                </div>        
            </div>

            <script type='text/javascript'>
                $.ajaxSetup({
                    async: false
                });


                //tabela:
                google.load('visualization', '1', {packages: ['table']});


                idSede = 13;
                nSede = "Nacional";

                dataMap = {
                    estados: [
                        {path: "pathAM", texto: "Manaus", id: "6"}
                        ,
                        {path: "pathPR", texto: "Curitiba", id: "4"}
                        ,
                        {path: "pathMT", texto: "Cuiab�", id: "3"}
                        ,
                        {path: "pathMG", texto: "Belo Horizonte", id: "1"}
                        ,
                        {path: "pathRS", texto: "Porto Alegre", id: "8"}
                        ,
                        {path: "pathBA", texto: "Salvador", id: "11"}
                        ,
                        {path: "pathCE", texto: "Fortaleza", id: "5"}
                        ,
                        {path: "pathRN", texto: "Natal", id: "7"}
                        ,
                        {path: "pathDF", texto: "Bras�lia", id: "2"}
                        ,
                        {path: "pathPE", texto: "Recife", id: "9"}
                        ,
                        {path: "pathSP", texto: "S�o Paulo", id: "12"}
                        ,
                        {path: "pathRJ", texto: "Rio de Janeiro", id: "10"}
                        ,
                        {path: null, texto: "Nacional", id: "13"}


                    ]
                };

                function tip(path) {
                    // Start when document loaded
                    var myInput = $('#' + path);
                    var inputOpentip = new Opentip(myInput, {target: '#' + path, tipJoint: "bottom", showOn: "creation"});

                    var index = 0;
                    for (var i = 0; i < dataMap.estados.length; i++) {
                        if (dataMap.estados[i].path == path) {
                            index = i;
                            break;
                        }
                    }
                    inputOpentip.setContent("Cidade Sede: " + dataMap.estados[index].texto);
                }

                $(document).ready(function() {

                    $("#modalInfo").dialog({
                        width: 620,
                        resizable: false,
                        autoOpen: false,
                        modal: true
                    });

                    //Captura as parametros da Url e mapeia para uma estrutura js
                    urlToJs();
                    //inicia o painel com os parametros
                    montaPainelUrl();

                    document.getElementById('inputUrl').value = montaUrl();

                });


                url = {
                    idSede: '',
                    idTema: '',
                    empSel: []
                };


                function onClickMap(n) {

                    url.idTema = '';
                    url.empSel = new Array();

                    path = n.id;

                    for (var i = 0; i < dataMap.estados.length; i++) {
                        if (dataMap.estados[i].path == path) {

                            nSede = dataMap.estados[i].texto;
                            break;
                        }
                    }

                    document.getElementById('sedeSel').innerHTML = nSede;
                    document.getElementById('temaSel').innerHTML = '(Selecione o Tema)';


                    d3.select(".estadoClicked").classed("estadoClicked", false);
                    d3.select("path#" + n.id).classed("estadoClicked", true);

                }

                function reloadPieChart(e, m) {

                    url.idSede = e;
                    //url.idTema = '';
                    //url.empSel = new Array();
                    document.getElementById('inputUrl').value = montaUrl();

                    dataJson = "";

                    $.getJSON('/copa/ServletSedeTema?SEDE=' + e, function(json) {
                        dataJson = json;
                    });

                    idSede = e;

                    var dataSet = new Array();

                    for (var i = 0; i < dataJson.tema.length; i++) {
                        dataSet.push({
                            name: dataJson.tema[i].nome,
                            y: dataJson.tema[i].qtdEmp,
                            id: dataJson.tema[i].id
                        });

                    }

                    initEmpreendimentoTema(dataSet, nSede, m);

                    loadTable(null, m);

                }


                function loadTable(idTema, m) {

                    EmpJson = "";

                    if (idTema == "" || idTema === null) {
                        $.getJSON('/copa/ServletTemaEmp?SEDE=' + idSede, function(json) {
                            EmpJson = json;
                        });
                    } else {

                        $.getJSON('/copa/ServletTemaEmp?SEDE=' + idSede + '&TEMA=' + idTema, function(json) {
                            EmpJson = json;
                        });
                    }

                    var dataTableRow = new Array();

                    for (var i = 0; i < EmpJson.emp.length; i++) {
                        var dataTableC = new Array();
                        dataTableC.push(parseInt(EmpJson.emp[i].id));
                        dataTableC.push(EmpJson.emp[i].nome);
                        dataTableC.push(EmpJson.emp[i].andamento);
                        dataTableC.push(EmpJson.emp[i].inst);

                        dataTableRow.push(dataTableC);
                    }


                    initEmpTable("", dataTableRow, m);


                }
                
                $(function() {
                    $('#modalInfoLink').click(function(e) {
                        e.preventDefault();

                        var left = ($(window).width() - 500) / 2,
                                top = ($(window).height() - 400) / 2,
                                popup = window.open("sobre.jsp", "popup", "width=500, height=400, top=" + top + ", left=" + left);

                        return false;
                    });
                })

                function getParameterUrl(name) {
                    var url = window.location.search.replace("?", "");
                    var itens = url.split("&");

                    for (var n in itens) {
                        if (itens[n].match(name)) {
                            return decodeURIComponent(itens[n].replace(name + "=", ""));
                        }
                    }
                    return null;
                }


                function urlToJs() {
                    if (getParameterUrl('idSede') != null) {
                        url.idSede = getParameterUrl('idSede');
                    }
                    if (getParameterUrl('idTema') != null) {
                        url.idTema = getParameterUrl('idTema');
                    }
                    if (getParameterUrl('empSel') != null) {
                        var itens = getParameterUrl('empSel').split(",");
                        for (var i = 0; i < itens.length; i++) {
                            url.empSel[i] = itens[i];
                        }

                    }
                }


                function montaUrl() {
                    var textUrl = window.location.href.split("?")[0];

                    if (url.idSede == '' || url.idSede == null) {
                        textUrl += '?idSede=13';
                    } else {
                        textUrl += '?idSede=' + url.idSede;
                    }
                    if (url.idTema == '' || url.idTema == null) {
                        textUrl += '';
                    } else {
                        textUrl += '&idTema=' + url.idTema;

                    }
                    textUrl += '&empSel=' + url.empSel;
                    return textUrl;
                }

                function montaPainelUrl() {

                    m = 0;
                    if (url.idSede == "") {
                        reloadPieChart(13, m);
                    } else {
                        for (var i = 0; i < dataMap.estados.length; i++) {
                            if (dataMap.estados[i].id == url.idSede) {
                                p = dataMap.estados[i].path;
                                nSede = dataMap.estados[i].texto;
                                break;
                            }
                        }

                        document.getElementById('sedeSel').innerHTML = nSede;
                        // document.getElementById('temaSel').innerHTML = '(Selecione o Tema)';
                        d3.select("path#" + p).classed("estadoClicked", true);
                        m = 1;
                        reloadPieChart(url.idSede, m);
                    }
                    if (url.idTema == "") {
                        loadTable(null, m);
                    } else {
                        loadTable(url.idTema, m);
                    }
                    if (url.empSel == "") {
                        loadTable(null, 0);
                    } else {
                        initPrevColumn('', url.empSel);
                    }






                }

            </script>

            <div id="modalInfo" class="modalInfo" title="Informa��o do Painel da Copa 2014">
                <p>O objetivo do painel � apresentar de forma gr�fica e interativa os investimentos nos empreendimentos de cada cidade-sede dos jogos da copa.</p>

                <p>O painel permite analisar o percentual dos investimentos por tema de atua��o e os recursos previsto e contratado na realiza��o de cada empreendimento.</p>

                <p>O Painel Copa 2014 foi desenvolvido pela COPPE/UFRJ em parceria com a UNIFEI (Universidade Federal de Itajub�) e o Minist�rio do Planejamento, Or�amento e Gest�o.</p>

                <p>Para o desenvolvimento do painel foram utilizadas as seguintes t�cnicas e tecnologias:</p>

                <ul>
                    <li>O Mapa foi constru�do com a tecnologia SVG (Scalable Vector Graphics - Gr�ficos Vetoriais Escal�veis)</li>

                    <li>Para a elabora��o do Gr�fico de Pizza e do Gr�fico de Colunas foi utilizado a tecnologia Highcharts</li>

                    <li>A Tabela foi gerada com a tecnologia Google Visualization API</li>
                </ul>

                <p>Os dados apresentados est�o dispon�veis para download no site Copa 2014 - Transpar�ncia em 1� lugar, atrav�s do link abaixo:</p>

                <a href="http://www.portaldatransparencia.gov.br/copa2014/dados/download.seam" target="_blank">http://www.portaldatransparencia.gov.br/copa2014/dados/download.seam</a>

                <p>O C�digo Fonte Desta Aplica��o esta dispon�vel em: </p>

                <a href="https://github.com/projetoCopa/painelCopa2014" target="_blank">https://github.com/projetoCopa/painelCopa2014</a>


            </div>
    </body>
</html>