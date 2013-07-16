/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.dadosCopa;

import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import model.Util;
import model.dadosCopa.CidadeSede;

/**
 *
 * @author Barbara
 */
public class CidadeSedeDAO {
   //    public static final String CAMINHO_ARQUIVOS = System.getProperty("jboss.server.config.url").replace("file:", "");

    public ArrayList<CidadeSede> getCidadeSede() {

        File arquivoCSV = new File(Util.getDadosCopaPath()+"20130707_CidadeSede.csv");

        // File arquivoCSV = new File(CAMINHO_ARQUIVOS + "vispublica_copa2014"+ "20130424_Tema.csv");

        ArrayList<CidadeSede> cidadeS = new ArrayList<CidadeSede>();

        try {
            CsvReader csvReader = new CsvReader(new FileInputStream(arquivoCSV), Charset.forName("UTF-8"));
            csvReader.setDelimiter(';');

            CidadeSede cS = new CidadeSede();


            while (csvReader.readRecord()) {

                cS = fromCsvToCidadeSede(csvReader);

                if (cS != null) {
                    cidadeS.add(cS);
                }

            }

            //System.out.println("FIM");
            return cidadeS;

        } catch (Exception e) {
            // printStackTrace(e);
            System.out.println("ERRO");

            System.out.println(e.getMessage());
        }
        return null;
    }

    private CidadeSede fromCsvToCidadeSede(CsvReader csvReader) throws IOException {

        CidadeSede c = new CidadeSede();
        c.setIdCidadeSede(Integer.parseInt(csvReader.get(0)));
        c.setNomeCidade(csvReader.get(1));
        c.setIdUf(Integer.parseInt(csvReader.get(2).equals("") ? "-1" : csvReader.get(2)));
       
        return c;

    }
    
   /*
    * TESTE:
    * 
    * public static void main(String[] args) {
        CidadeSedeDAO cd = new CidadeSedeDAO();
        System.out.println(cd.getCidadeSede());
    }*/
}
