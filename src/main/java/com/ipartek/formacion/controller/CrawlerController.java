package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class CrawlerController
 */
@WebServlet("/crawler")
public class CrawlerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Document doc = Jsoup.connect("http://example.com/").get();
		String title = doc.title();
		
		// puedes usar doc.selec() para hacer consultas mas complejas
		// @see https://jsoup.org/cookbook/extracting-data/selector-syntax
		
		Elements anclas = doc.getElementsByTag("a");
		Element primeraAncla = anclas.get(0);
		
		String nuevaURL = primeraAncla.attr("href");
		Document doc2 = Jsoup.connect(nuevaURL).get();
		String title2 = doc2.title();
		
		
		request.setAttribute("titulo", title);
		request.setAttribute("titulo2", title2);
		
		request.getRequestDispatcher("views/ejemplos/crawler.jsp").forward(request, response);
		
		
	}

}
