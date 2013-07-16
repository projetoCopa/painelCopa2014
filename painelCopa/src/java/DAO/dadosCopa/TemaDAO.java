package DAO.dadosCopa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.dadosCopa.Tema;
import com.csvreader.CsvReader;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import model.Util;


public class TemaDAO {

//    public static final String CAMINHO_ARQUIVOS = System.getProperty("jboss.server.config.url").replace("file:", "");

    public ArrayList<Tema> getTema() {

        File arquivoCSV = new File(Util.getDadosCopaPath()+"20130707_Tema.csv");

        // File arquivoCSV = new File(CAMINHO_ARQUIVOS + "vispublica_copa2014"+ "20130424_Tema.csv");

        ArrayList<Tema> tema = new ArrayList<Tema>();

        try {
            CsvReader csvReader = new CsvReader(new FileInputStream(arquivoCSV), Charset.forName("UTF-8"));
            csvReader.setDelimiter(';');

            Tema tm = new Tema();


            while (csvReader.readRecord()) {

                tm = fromCsvToTema(csvReader);

                if (tm != null) {
                    tema.add(tm);
                }

            }

            //System.out.println("FIM");
            return tema;

        } catch (Exception e) {
            // printStackTrace(e);
            System.out.println("ERRO");

            System.out.println(e.getMessage());
        }
        return null;
    }

    private Tema fromCsvToTema(CsvReader csvReader) throws IOException {

        Tema t = new Tema();
        t.setId(Integer.parseInt(csvReader.get(0)));
        t.setNome(csvReader.get(1));
        return t;

    }
    
  /*   public static void main(String[] args) {
        TemaDAO inst = new TemaDAO();
        System.out.println(inst.getTema().get(2).getNome());
     }*/
   
}
