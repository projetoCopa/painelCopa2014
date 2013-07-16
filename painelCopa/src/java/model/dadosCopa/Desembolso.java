/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dadosCopa;

/**
 *
 * @author Pimenta
 */
public class Desembolso {
    private int id;
    private int idRecCapt;
    private String data;
    private float valDesembolso;
    private int idExecF;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdExecF() {
        return idExecF;
    }

    public void setIdExecF(int idExecF) {
        this.idExecF = idExecF;
    }

    public int getIdRecCapt() {
        return idRecCapt;
    }

    public void setIdRecCapt(int idRecCapt) {
        this.idRecCapt = idRecCapt;
    }

    public float getValDesembolso() {
        return valDesembolso;
    }

    public void setValDesembolso(float valDesembolso) {
        this.valDesembolso = valDesembolso;
    }
    
}
