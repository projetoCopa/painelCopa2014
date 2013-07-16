/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dadosCopa;
/**
 *
 * @author Barbara
 */
public class Instituicao {
    
    private int idInst;
    private int idTipoInst;
    private String nomeInst;
    private Float cnpj;

    public int getIdInst() {
        return idInst;
    }

    public void setIdInst(int idInst) {
        this.idInst = idInst;
    }

    public int getIdTipoInst() {
        return idTipoInst;
    }

    public void setIdTipoInst(int idTipoInst) {
        this.idTipoInst = idTipoInst;
    }

    public String getNomeInst() {
        return nomeInst;
    }

    public void setNomeInst(String nomeInst) {
        this.nomeInst = nomeInst;
    }

    public Float getCnpj() {
        return cnpj;
    }

    public void setCnpj(Float cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
