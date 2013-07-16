/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dadosCopa;

/**
 *
 * @author Pimenta
 */
public class ExecucaoFinanceira {
    private int id;
    private int idEmp;
    private int idAndF; //andamento financeiro
    private int tipoExec;
    private String dataAss;
    private String dataInicio;
    private String dataFinal;
    private int idInstContratante;
    private int idInstContratado;
    private float valContrato;
    private float valContrapartida;
    private float valTotal;

    public String getDataAss() {
        return dataAss;
    }

    public void setDataAss(String dataAss) {
        this.dataAss = dataAss;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAndF() {
        return idAndF;
    }

    public void setIdAndF(int idAndF) {
        this.idAndF = idAndF;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public int getIdInstContratado() {
        return idInstContratado;
    }

    public void setIdInstContratado(int idInstContratado) {
        this.idInstContratado = idInstContratado;
    }

    public int getIdInstContratante() {
        return idInstContratante;
    }

    public void setIdInstContratante(int idInstContratante) {
        this.idInstContratante = idInstContratante;
    }

    public int getTipoExec() {
        return tipoExec;
    }

    public void setTipoExec(int tipoExec) {
        this.tipoExec = tipoExec;
    }

    public float getValContrapartida() {
        return valContrapartida;
    }

    public void setValContrapartida(float valContrapartida) {
        this.valContrapartida = valContrapartida;
    }

    public float getValContrato() {
        return valContrato;
    }

    public void setValContrato(float valContrato) {
        this.valContrato = valContrato;
    }

    public float getValTotal() {
        return valTotal;
    }

    public void setValTotal(float valTotal) {
        this.valTotal = valTotal;
    }
    
}
