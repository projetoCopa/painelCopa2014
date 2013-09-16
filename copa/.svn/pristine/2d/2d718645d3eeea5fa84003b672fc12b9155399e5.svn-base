/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.dadosCopa;

import DAO.dadosCopa.AndamentoDAO;
import DAO.dadosCopa.EmpreendimentoDAO;
import DAO.dadosCopa.InstituicaoDAO;
import DAO.dadosCopa.TemaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dadosCopa.Empreendimento;
import model.dadosCopa.Tema;
import model.dadosCopa.Andamento;
import model.dadosCopa.Instituicao;

/**
 *
 * @author Barbara
 */
public class ServletTemaEmp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        ArrayList<Empreendimento> itemEmp = new ArrayList<Empreendimento>();
        ArrayList<Tema> itemTema = new ArrayList<Tema>();
        ArrayList<Andamento> itemAnd = new ArrayList<Andamento>();
        ArrayList<Instituicao> itemInst = new ArrayList<Instituicao>();
        EmpreendimentoDAO emp = new EmpreendimentoDAO();
        TemaDAO td = new TemaDAO();
        AndamentoDAO and = new AndamentoDAO();
        InstituicaoDAO inst = new InstituicaoDAO();
        //HashMap<Integer, ArrayList<EmpTema> = new HashMap<HashMap<Integer, ArrayList<EmpTema>>();
        //EmpTema seria uma classe com id Tema e quantidade de Emp

        itemEmp = emp.getEmpreendimento();
        itemTema = td.getTema();
        itemAnd = and.getAndamento();
        itemInst = inst.getInstituicao();

        String js = "";

        int t = 0;

        if (request.getParameter("SEDE") == null) {
            return;
        }


        js += "{\"emp\":[";

        for (int i = 0; i < itemEmp.size(); i++) {
            if (Integer.parseInt(request.getParameter("SEDE")) == itemEmp.get(i).getIdSede()) {
                if (request.getParameter("TEMA") == null) {
                    js += "{\"id\":\"" + itemEmp.get(i).getId() + "\",";
                    js += "\"nome\":\"" + itemEmp.get(i).getNome() + "\",";
                    if (itemEmp.get(i).getIdAndamento() != -1) {
                        for (int j = 0; j < itemAnd.size(); j++) {
                            if (itemEmp.get(i).getIdAndamento() == itemAnd.get(j).getId()) {
                                js += "\"andamento\":\"" + itemAnd.get(j).getDescr() + "\",";
                            }
                        }
                    } else {
                        js += "\"andamento\":\"Sem descrição\",";
                    }
                    if (itemEmp.get(i).getIdInstituicao() != -1) {
                        for (int w = 0; w < itemInst.size(); w++) {
                            if (itemEmp.get(i).getIdInstituicao() == itemInst.get(w).getIdInst()) {
                                js += "\"inst\":\"" + itemInst.get(w).getNomeInst() + "\"},\n";
                            }
                        }
                    } else {
                        js += "\"inst\":\"Sem Instituição\"},\n";
                    }
                } else {
                    if (Integer.parseInt(request.getParameter("TEMA")) == itemEmp.get(i).getIdTema()) {
                        js += "{\"id\":\"" + itemEmp.get(i).getId() + "\",";
                        js += "\"nome\":\"" + itemEmp.get(i).getNome() + "\",";
                        if (itemEmp.get(i).getIdAndamento() != -1) {
                            for (int j = 0; j < itemAnd.size(); j++) {
                                if (itemEmp.get(i).getIdAndamento() == itemAnd.get(j).getId()) {
                                    js += "\"andamento\":\"" + itemAnd.get(j).getDescr() + "\",";
                                }
                            }
                        } else {
                            js += "\"andamento\":\"Sem descrição\",";
                        }
                        if (itemEmp.get(i).getIdInstituicao() != -1) {
                            for (int w = 0; w < itemInst.size(); w++) {
                                if (itemEmp.get(i).getIdInstituicao() == itemInst.get(w).getIdInst()) {
                                    js += "\"inst\":\"" + itemInst.get(w).getNomeInst() + "\"},\n";
                                }
                            }
                        } else {
                            js += "\"inst\":\"Sem Instituição\"},\n";
                        }
                    }
                }



            }
        }

        js = js.substring(0, js.lastIndexOf(','));
        js += "]}";


        try {
            /* TODO output your page here. You may use following sample code. */
            out.println(js);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
