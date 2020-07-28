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
		
		
		Document doc = Jsoup.connect("https://www.lidl.es/es/verano/c2159")
				       .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:78.0) Gecko/20100101 Firefox/78.0")
				       .get();
		
		String title = doc.title();
		
		Elements anclasConClaseProducto = doc.select("a.product span.desc-height strong ");
		Element anclaProducto = null;
		for (int i = 0; i < anclasConClaseProducto.size(); i++) {
			
			anclaProducto = anclasConClaseProducto.get(i);
			System.out.println( anclaProducto.text() );
			
		}
		
		
		Elements anclas = doc.getElementsByTag("a");
		Element primeraAncla = anclas.get(0);   // conseguimos la 1º ancla		
		String nuevaURL = primeraAncla.attr("href");
				
		Document doc2 = Jsoup.connect(nuevaURL).get();
		String title2 = doc2.title();
				
		
		
		
		
		request.setAttribute("titulo", title);
		request.setAttribute("titulo2", title2);
		
		request.getRequestDispatcher("views/ejemplos/crawler.jsp").forward(request, response);
		
		
	}

}
