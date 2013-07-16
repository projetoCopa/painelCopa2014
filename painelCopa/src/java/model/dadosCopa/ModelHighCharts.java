/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dadosCopa;

import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class ModelHighCharts {
    private ArrayList<Integer> idEmp;
    private float somaP;

    public ModelHighCharts() {
        this.idEmp = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(ArrayList<Integer> idEmp) {
        this.idEmp = idEmp;
    }

    public float getSomaP() {
        return somaP;
    }

    public void setSomaP(float somaP) {
        this.somaP = somaP;
    }

    public float getSomaC() {
        return somaC;
    }

    public void setSomaC(float somaC) {
        this.somaC = somaC;
    }
    private float somaC;    
}
