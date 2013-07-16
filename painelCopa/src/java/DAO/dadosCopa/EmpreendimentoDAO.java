package DAO.dadosCopa;

import java.io.File;
import java.util.ArrayList;
import model.dadosCopa.Empreendimento;
import com.csvreader.CsvReader;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import model.Util;

public class EmpreendimentoDAO {

   // public static final String CAMINHO_ARQUIVOS = System.getProperty("jboss.server.config.url").replace("file:", "");

    public ArrayList<Empreendimento> getEmpreendimento() {
        File arquivoCSV = new File(Util.getDadosCopaPath()+"20130707_Empreendimento.csv");



        //File arquivoCSV = new File(CAMINHO_ARQUIVOS + "vispublica_copa2014"+ "20130424_Empreendimento.csv");

        ArrayList<Empreendimento> empreendimento = new ArrayList<Empreendimento>();

        try {
            CsvReader csvReader = new CsvReader(new FileInputStream(arquivoCSV), Charset.forName("UTF-8"));
            csvReader.setDelimiter(';');

            Empreendimento emp = new Empreendimento();


            while (csvReader.readRecord()) {

                emp = fromCsvToEmpreendimento(csvReader);

                if (emp != null) {
                    empreendimento.add(emp);
                }

            }

            //System.out.println("FIM");
            return empreendimento;

        } catch (Exception e) {
            System.out.println("ERRO");
            System.out.println(e.getMessage());
        }
        return null;

    }

    private Empreendimento fromCsvToEmpreendimento(CsvReader csvReader) throws Exception {
        Empreendimento e = new Empreendimento();


        try {
            Integer.parseInt(csvReader.get(0));
        } catch (NumberFormatException nfe) {
            return null;
        }


        e.setId(Integer.parseInt(csvReader.get(0).equals("") ? "-1" : csvReader.get(0)));
        e.setNome(csvReader.get(1).equals("") ? "-1" : csvReader.get(1));
        e.setIdSede(Integer.parseInt(csvReader.get(2).equals("") ? "-1" : csvReader.get(2)));
        e.setIdTema(Integer.parseInt(csvReader.get(3).equals("") ? "-1" : csvReader.get(3)));
        e.setIdAgrupador(Integer.parseInt(csvReader.get(4).equals("") ? "-1" : csvReader.get(4)));
        e.setIdAndamento(Integer.parseInt(csvReader.get(8).equals("") ? "-1" : csvReader.get(8)));
        e.setIdFaseGrupo(Integer.parseInt(csvReader.get(10).equals("") ? "-1" : csvReader.get(10)));
        e.setIdProjeto(Integer.parseInt(csvReader.get(14).equals("") ? "-1" : csvReader.get(14)));
        e.setIdInstituicao(Integer.parseInt(csvReader.get(15).equals("") ? "-1" : csvReader.get(15)));
        e.setValTotalPrevisto(Float.parseFloat(csvReader.get(16).equals("") ? "-1" : csvReader.get(16).replace(".", "").replace(",", ".")));

        return e;

    }
}
