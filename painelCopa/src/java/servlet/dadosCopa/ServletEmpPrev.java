/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.dadosCopa;

import DAO.dadosCopa.EmpreendimentoDAO;
import DAO.dadosCopa.ExecucaoFinanceiraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dadosCopa.Empreendimento;
import model.dadosCopa.ExecucaoFinanceira;

/**
 *
 * @author Barbara
 */
public class ServletEmpPrev extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        ArrayList<Empreendimento> itemEmp = new ArrayList<Empreendimento>();
        ArrayList<ExecucaoFinanceira> itemExec = new ArrayList<ExecucaoFinanceira>();

        EmpreendimentoDAO emp = new EmpreendimentoDAO();
        ExecucaoFinanceiraDAO ef = new ExecucaoFinanceiraDAO();



        itemEmp = emp.getEmpreendimento();
        itemExec = ef.getExecucaoFinanceira();


        int t = Integer.parseInt(request.getParameter("EMP"));

        float valContrato = 0;


        for (int i = 0; i < itemExec.size(); i++) {
            if (t == itemExec.get(i).getIdEmp()) {
                valContrato = valContrato + itemExec.get(i).getValContrato();
            }

        }


        String js = "";

        js += "{\"prev\":[";

        for (int i = 0; i < itemEmp.size(); i++) {
            if (t == itemEmp.get(i).getId()) {
                js += "{\"emp\":\"" + itemEmp.get(i).getNome() + "\",";
                js += "\"recPrev\":\"" + itemEmp.get(i).getValTotalPrevisto() + "\",";
                js += "\"recContra\":\"" + valContrato + "\"}";


                //  js += "\"recExec\":\"" + valExec + "\"}";

            }
        }

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
