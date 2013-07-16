package model.dadosCopa;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Barbara
 */
public class RecursoCaptado {
    private int id;
    private int idInstCedente;
    private int idInstBeneficiario;
    private String descrObj;
    private String descrGar;
    private int idEmpreendimento;
    private int idFaseGrupo;
    private float valTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInstCedente() {
        return idInstCedente;
    }

    public void setIdInstCedente(int idInstCedente) {
        this.idInstCedente = idInstCedente;
    }

    public int getIdInstBeneficiario() {
        return idInstBeneficiario;
    }

    public void setIdInstBeneficiario(int idInstBeneficiario) {
        this.idInstBeneficiario = idInstBeneficiario;
    }

    public String getDescrObj() {
        return descrObj;
    }

    public void setDescrObj(String descrObj) {
        this.descrObj = descrObj;
    }

    public String getDescrGar() {
        return descrGar;
    }

    public void setDescrGar(String descrGar) {
        this.descrGar = descrGar;
    }

    public int getIdEmpreendimento() {
        return idEmpreendimento;
    }

    public void setIdEmpreendimento(int idEmpreendimento) {
        this.idEmpreendimento = idEmpreendimento;
    }

    public int getIdFaseGrupo() {
        return idFaseGrupo;
    }

    public void setIdFaseGrupo(int idFaseGrupo) {
        this.idFaseGrupo = idFaseGrupo;
    }

    public float getValTotal() {
        return valTotal;
    }

    public void setValTotal(float valTotal) {
        this.valTotal = valTotal;
    }
    
    
}