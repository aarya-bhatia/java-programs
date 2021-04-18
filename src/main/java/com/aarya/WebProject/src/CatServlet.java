//package com.aarya.WebProject.src;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class CatServlet
// */
//@WebServlet("/CatServlet")
//public class CatServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public CatServlet() {
//        super();
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter writer = response.getWriter();
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		List<Cat> cats = CatDao.getCats();
//		if(cats.size() == 0) {
//			writer.print("[]");
//			writer.flush();
//		}
//		else {
//			StringBuilder out = new StringBuilder("[");
//			Iterator<Cat> it = cats.iterator();
//			while(it.hasNext()) {
//
//				if(out.length() > 1) {
//					out.append(",");
//				}
//
//				String catJSON = it.next().toJSON();
//				out.append(catJSON);
//			}
//
//			out.append("]");
//
//			writer.print(out.toString());
//			writer.flush();
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("NAME");
//		char gender = request.getParameter("GENDER").charAt(0);
//		String owner = request.getParameter("OWNER");
//		String birth = request.getParameter("BIRTH");
//		Cat cat = new Cat(name, gender, owner, birth);
//		try {
//			CatDao.insertCat(cat);
//			response.setStatus(HttpServletResponse.SC_OK);
//		} catch(NullPointerException ex) {
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//		}
//	}
//
//}
