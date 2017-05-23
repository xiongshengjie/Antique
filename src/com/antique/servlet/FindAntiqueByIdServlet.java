package com.antique.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.antique.domain.Antique;
import com.antique.service.AntiqueService;

/**
 * Servlet implementation class FindAntiqueById
 */
@WebServlet("/FindAntiqueById")
public class FindAntiqueByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAntiqueByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");

		Antique antique = new Antique();
		AntiqueService service = new AntiqueService();

		try {
			antique = service.findAntiqueById(id);
			request.setAttribute("p", antique);
			request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
