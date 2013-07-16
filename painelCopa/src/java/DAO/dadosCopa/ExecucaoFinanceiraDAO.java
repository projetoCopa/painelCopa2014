package DAO.dadosCopa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.dadosCopa.ExecucaoFinanceira;
import com.csvreader.CsvReader;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import model.Util;

public class ExecucaoFinanceiraDAO {

   // public static final String CAMINHO_ARQUIVOS = System.getProperty("jboss.server.config.url").replace("file:", "");

    public ArrayList<ExecucaoFinanceira> getExecucaoFinanceira() {
        File arquivoCSV = new File(Util.getDadosCopaPath()+"20130707_ExecucaoFinanceira.csv");

        //File arquivoCSV = new File(CAMINHO_ARQUIVOS + "vispublica_copa2014"+ "20130424_RecursoPrevisto.csv");

        ArrayList<ExecucaoFinanceira> execFinanceira = new ArrayList<ExecucaoFinanceira>();

        try {
            CsvReader csvReader = new CsvReader(new FileInputStream(arquivoCSV), Charset.forName("UTF-8"));
            csvReader.setDelimiter(';');

            ExecucaoFinanceira eF = new ExecucaoFinanceira();


            while (csvReader.readRecord()) {

                eF = fromCsvToExecucaoFinanceira(csvReader);
                
                if (eF == null){
                    int x=1;
                }

                if (eF != null) {
                    execFinanceira.add(eF);
                }

            }

            //System.out.println("FIM");
            return execFinanceira;

        } catch (Exception e) {
            System.out.println("ERRO");
            System.out.println(e.getMessage());
        }

        return null;
    }

    private ExecucaoFinanceira fromCsvToExecucaoFinanceira(CsvReader csvReader) throws IOException {
        ExecucaoFinanceira eFin = new ExecucaoFinanceira();
        eFin.setId(Integer.parseInt(csvReader.get(0).equals("") ? "-1" : csvReader.get(0)));
        eFin.setIdEmp(Integer.parseInt(csvReader.get(1).equals("") ? "-1" : csvReader.get(1)));
        eFin.setIdAndF(Integer.parseInt(csvReader.get(3).equals("") ? "-1" : csvReader.get(3)));
        eFin.setDataAss(csvReader.get(5).equals("") ? "-1" : csvReader.get(5));
        eFin.setDataInicio(csvReader.get(6).equals("") ? "-1" : csvReader.get(6));
        eFin.setDataFinal(csvReader.get(7).equals("") ? "-1" : csvReader.get(7));
        eFin.setIdInstContratante(Integer.parseInt(csvReader.get(8).equals("") ? "-1" : csvReader.get(8)));
        eFin.setIdInstContratado(Integer.parseInt(csvReader.get(10).equals("") ? "-1" : csvReader.get(10)));
        
        eFin.setValContrato(Float.parseFloat(csvReader.get(12).equals("") ? "-1" : csvReader.get(12).replace(".", "").replace(",", ".")));
        eFin.setValContrapartida(Float.parseFloat(csvReader.get(13).equals("") ? "-1" : csvReader.get(13).replace(".", "").replace(",", ".")));
        eFin.setValTotal(Float.parseFloat(csvReader.get(14).equals("") ? "-1" : csvReader.get(14).replace(".", "").replace(",", ".")));
    
        return eFin;

    }
}
