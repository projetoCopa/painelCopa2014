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
import model.dadosCopa.Instituicao;

/**
 *
 * @author Barbara
 */
public class InstituicaoDAO {
       // public static final String CAMINHO_ARQUIVOS = System.getProperty("jboss.server.config.url").replace("file:", "");

    public ArrayList<Instituicao> getInstituicao() {
        File arquivoCSV = new File(Util.getDadosCopaPath()+"20130707_Instituicao.csv");



        //File arquivoCSV = new File(CAMINHO_ARQUIVOS + "vispublica_copa2014"+ "20130424_Empreendimento.csv");

        ArrayList<Instituicao> instituicao = new ArrayList<Instituicao>();

        try {
            CsvReader csvReader = new CsvReader(new FileInputStream(arquivoCSV), Charset.forName("UTF-8"));
            csvReader.setDelimiter(';');

            Instituicao inst = new Instituicao();


            while (csvReader.readRecord()) {

                inst = fromCsvToAndamento(csvReader);

                if (inst != null) {
                    instituicao.add(inst);
                }

            }

            //System.out.println("FIM");
            return instituicao;

        } catch (Exception e) {
            System.out.println("ERRO");
            System.out.println(e.getMessage());
        }
        return null;

    }

    private Instituicao fromCsvToAndamento(CsvReader csvReader) throws Exception {
        Instituicao i = new Instituicao();


        try {
            Integer.parseInt(csvReader.get(0));
        } catch (NumberFormatException nfe) {
            return null;
        }

        i.setIdInst(Integer.parseInt(csvReader.get(0).equals("") ? "-1" : csvReader.get(0)));
        i.setIdTipoInst(Integer.parseInt(csvReader.get(1).equals("") ? "-1" : csvReader.get(1)));
        i.setNomeInst(csvReader.get(2).equals("") ? "-1" : csvReader.get(2));
        //i.setCnpj(Float.parseFloat(csvReader.get(3).equals("") ? "-1" : csvReader.get(3).replace(".", "").replace(",", ".")));
   
        
        
        return i;

    }
    
  /*  TESTE:
   * 
   * public static void main(String[] args) {
        InstituicaoDAO inst = new InstituicaoDAO();
        System.out.println(inst.getInstituicao().get(0).getIdInst());
    }*/
}
