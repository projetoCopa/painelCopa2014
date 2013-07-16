package DAO.dadosCopa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.dadosCopa.RecursoCaptado;
import com.csvreader.CsvReader;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import model.Util;

public class RecursoCaptadoDAO {

    //public static final String CAMINHO_ARQUIVOS = System.getProperty("jboss.server.config.url").replace("file:", "");

    public ArrayList<RecursoCaptado> getRecursoCaptado() {
        File arquivoCSV = new File(Util.getDadosCopaPath()+"20130707_RecursoCaptado.csv");

        // File arquivoCSV = new File(CAMINHO_ARQUIVOS + "vispublica_copa2014"+ "20130424_RecursoCaptado.csv");

        ArrayList<RecursoCaptado> recurso = new ArrayList<RecursoCaptado>();

        try {
            CsvReader csvReader = new CsvReader(new FileInputStream(arquivoCSV), Charset.forName("UTF-8"));
            csvReader.setDelimiter(';');

            RecursoCaptado rec = new RecursoCaptado();


            while (csvReader.readRecord()) {

                rec = fromCsvToRecursoCaptado(csvReader);

                if (rec != null) {
                    recurso.add(rec);
                }

            }

            //System.out.println("FIM");
            return recurso;

        } catch (Exception e) {
            System.out.println("ERRO");
            System.out.println(e.getMessage());
        }

        return null;
    }

    private RecursoCaptado fromCsvToRecursoCaptado(CsvReader csvReader) throws IOException {
        RecursoCaptado rC = new RecursoCaptado();
        rC.setId(Integer.parseInt(csvReader.get(0)));
        rC.setIdInstCedente(Integer.parseInt(csvReader.get(7)));
        rC.setIdInstBeneficiario(Integer.parseInt(csvReader.get(8)));
        rC.setDescrObj(csvReader.get(9));
        rC.setDescrGar(csvReader.get(10));
        rC.setIdEmpreendimento(Integer.parseInt(csvReader.get(14)));
        rC.setIdFaseGrupo(Integer.parseInt(csvReader.get(15)));
        rC.setValTotal(Float.parseFloat(csvReader.get(16).equals("") ? "-1" : csvReader.get(16).replace(".", "").replace(",", ".")));

        return rC;

    }
}
