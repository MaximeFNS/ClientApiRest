package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class ServletClient
 */
@WebServlet("/GetVilles")
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_FORM = "/WEB-INF/formulaires/getVilles.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//URL
		URL url = new URL("http://localhost:8181/get?value=6");
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("GET");
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputline = "";
		
		while ((inputline = br.readLine())!= null) {
			
			sb.append(inputline);
		}
		
		Gson gson = new Gson();
		//String gsonstring = gson.toJson(sb);
		
		Type trouverVille = new TypeToken<ArrayList<Ville>>() {}.getType();
		
		List<Ville> liste = gson.fromJson(sb.toString(), trouverVille);
		
		System.out.println(sb.toString());
		
		
		session.setAttribute("villes", liste);
		
		RequestDispatcher d = request.getRequestDispatcher("getVilles.jsp");
		//this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
