/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.dadosCopa;

import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import model.Util;
import model.dadosCopa.Andamento;

/**
 *
 * @author Barbara
 */
public class AndamentoDAO {
    // public static final String CAMINHO_ARQUIVOS = System.getProperty("jboss.server.config.url").replace("file:", "");

    public ArrayList<Andamento> getAndamento() {
        File arquivoCSV = new File(Util.getDadosCopaPath()+"20130707_Andamento.csv");
        



        //File arquivoCSV = new File(CAMINHO_ARQUIVOS + "vispublica_copa2014"+ "20130424_Empreendimento.csv");

        ArrayList<Andamento> andamento = new ArrayList<Andamento>();

        try {
            CsvReader csvReader = new CsvReader(new FileInputStream(arquivoCSV), Charset.forName("UTF-8"));
            csvReader.setDelimiter(';');

            Andamento and = new Andamento();


            while (csvReader.readRecord()) {

                and = fromCsvToAndamento(csvReader);

                if (and != null) {
                    andamento.add(and);
                }

            }

            //System.out.println("FIM");
            return andamento;

        } catch (Exception e) {
            System.out.println("ERRO");
            System.out.println(e.getMessage());
        }
        return null;

    }

    private Andamento fromCsvToAndamento(CsvReader csvReader) throws Exception {
        Andamento a = new Andamento();


        try {
            Integer.parseInt(csvReader.get(0));
        } catch (NumberFormatException nfe) {
            return null;
        }


        a.setId(Integer.parseInt(csvReader.get(0).equals("") ? "-1" : csvReader.get(0)));
        a.setDescr(csvReader.get(1).equals("") ? "-1" : csvReader.get(1));
        
        return a;

    }
    
    
    /*
     * TESTE:
     * 
     *  public static void main(String[] args) {
        AndamentoDAO inst = new AndamentoDAO();
        System.out.println(inst.getAndamento().get(0).getId());
    }
     */
   
    
}
