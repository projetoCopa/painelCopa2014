/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.dadosCopa;

import DAO.dadosCopa.EmpreendimentoDAO;
import DAO.dadosCopa.TemaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dadosCopa.Empreendimento;
import model.dadosCopa.Tema;

/**
 *
 * @author Barbara
 */
public class ServletSedeTema extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        ArrayList<Empreendimento> itemEmp = new ArrayList();
        ArrayList<Tema> itemTema = new ArrayList<Tema>();
        EmpreendimentoDAO emp = new EmpreendimentoDAO();
        TemaDAO td = new TemaDAO();
        //HashMap<Integer, ArrayList<EmpTema> = new HashMap<HashMap<Integer, ArrayList<EmpTema>>();
        //EmpTema seria uma classe com id Tema e quantidade de Emp
     
        itemEmp = emp.getEmpreendimento();
        itemTema = td.getTema();


        if (request.getParameter("SEDE") == null) {
            return;
        }
        

        HashMap<Integer, Integer> temaG = new HashMap<Integer, Integer>();


        for (int i = 0; i < itemEmp.size(); i++) {
            if (Integer.parseInt(request.getParameter("SEDE")) == itemEmp.get(i).getIdSede()) {
                if (temaG.get(itemEmp.get(i).getIdTema()) == null) {
                    temaG.put(itemEmp.get(i).getIdTema(), 1);
                } else {
                    int count = temaG.get(itemEmp.get(i).getIdTema()) + 1;
                    temaG.put(itemEmp.get(i).getIdTema(), count);
                }

            }
        }

        String js = "";

        js += "{\"tema\":[";

        for (Integer hashK : temaG.keySet()) {
            for (int i = 0; i < itemTema.size(); i++) {
                if (hashK == itemTema.get(i).getId()) {
                    js += "{\"nome\":\"" + itemTema.get(i).getNome() + "\",";
                    js += "\"qtdEmp\":" + temaG.get(hashK) + ",";
                    js += "\"id\":" + itemTema.get(i).getId() + "},\n";
                }
            }
        }

        js = js.substring(0, js.lastIndexOf(','));
        js += "]}";
       

        /* js += "tema[";

        for (Integer hashK : temaG.keySet()) {
            for (int i = 0; i < itemTema.size(); i++) {
                if (hashK == itemTema.get(i).getId()) {
                    js += "[\"" + itemTema.get(i).getNome() + "\",";
                    js += temaG.get(hashK) + "],\n";
                }
            }
        }

        js = js.substring(0, js.lastIndexOf(','));
        js += "]";
        */
        
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
