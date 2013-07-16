package DAO.dadosCopa;

import model.Util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.dadosCopa.Desembolso;
import com.csvreader.CsvReader;
import java.io.FileInputStream;
import java.nio.charset.Charset;

public class DesembolsoDAO {

//    public static final String CAMINHO_ARQUIVOS = System.getProperty("jboss.server.config.url").replace("file:", "");
    public ArrayList<Desembolso> getDesembolso() {

        File arquivoCSV = new File(Util.getDadosCopaPath()+"20130707_Desembolso.csv");

        // File arquivoCSV = new File(CAMINHO_ARQUIVOS + "vispublica_copa2014"+ "20130424_Tema.csv");

        ArrayList<Desembolso> desembolso = new ArrayList<Desembolso>();

        try {
            CsvReader csvReader = new CsvReader(new FileInputStream(arquivoCSV), Charset.forName("UTF-8"));
            csvReader.setDelimiter(';');

            Desembolso ds = new Desembolso();


            while (csvReader.readRecord()) {

                ds = fromCsvToDesembolso(csvReader);

                if (ds != null) {
                    desembolso.add(ds);
                }

            }

            //System.out.println("FIM");
            return desembolso;

        } catch (Exception e) {
            // printStackTrace(e);
            System.out.println("ERRO");

            System.out.println(e.getMessage());
        }
        return null;
    }

    private Desembolso fromCsvToDesembolso(CsvReader csvReader) throws IOException {

        Desembolso d = new Desembolso();

        d.setId(Integer.parseInt(csvReader.get(0).equals("") ? "-1" : csvReader.get(0)));
        d.setIdRecCapt(Integer.parseInt(csvReader.get(1).equals("") ? "-1" : csvReader.get(1)));
        d.setData(csvReader.get(2).equals("") ? "-1" : csvReader.get(2));
        d.setValDesembolso(Float.parseFloat(csvReader.get(3).equals("") ? "-1" : csvReader.get(3).replace(".", "").replace(",", ".")));
        d.setIdExecF(Integer.parseInt(csvReader.get(7).equals("") ? "-1" : csvReader.get(7)));

        return d;

    }
    /*   public static void main(String[] args) {
    TemaDAO inst = new TemaDAO();
    System.out.println(inst.getTema().get(2).getNome());
    }*/
}
