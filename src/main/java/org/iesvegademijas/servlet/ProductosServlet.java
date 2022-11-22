package org.iesvegademijas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesvegademijas.dao.FabricanteDAO;
import org.iesvegademijas.dao.FabricanteDAOImpl;
import org.iesvegademijas.dao.ProductoDAO;
import org.iesvegademijas.dao.ProductoDAOImpl;
import org.iesvegademijas.model.Fabricante;
import org.iesvegademijas.model.Producto;

//@WebServlet("/productos/*") 
public class ProductosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
				
		String pathInfo = request.getPathInfo(); //
			
		if (pathInfo == null || "/".equals(pathInfo)) {
			ProductoDAO prodDAO = new ProductoDAOImpl();
			
			var listProd = prodDAO.getAll();
			
			String filtrarPor = (request.getParameter("filtrar-por") != null) ? request.getParameter("filtrar-por") : "";
			
			filtrarPor = filtrarPor.toLowerCase();
			
			listProd = prodDAO.buscarPorNombre(listProd, filtrarPor);
			
			request.setAttribute("listaProductos",listProd);		
			
			
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos.jsp");
			
			        		       
		} else {
			
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
				ProductoDAO prodDAO = new ProductoDAOImpl();
				// GET
				// /productos/create									
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/crear-producto.jsp");
				
				var lfab = prodDAO.getFabricantes();
				
				request.setAttribute("listaFabricantes", lfab);
        												
			
			} else if (pathParts.length == 2) {
				ProductoDAO prodDAO = new ProductoDAOImpl();
				FabricanteDAO fabDao = new FabricanteDAOImpl();
				// GET
				// /productos/{id}
				try {
					request.setAttribute("producto",prodDAO.find(Integer.parseInt(pathParts[1])));
					
					request.setAttribute("fabricante", fabDao.find(prodDAO.find(Integer.parseInt(pathParts[1])).get().getCodigo_fabricante()));
					
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detalle-producto.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos.jsp");
				}
				
			} else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
				ProductoDAO prodDAO = new ProductoDAOImpl();
				
				// GET
				// /productos/edit/{id}
				try {
					request.setAttribute("producto",prodDAO.find(Integer.parseInt(pathParts[2])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editar-producto.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos.jsp");
				}
				
				
			} else {
				
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos.jsp");
			
			}
			
		}
		
		dispatcher.forward(request, response);
			 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String __method__ = request.getParameter("__method__");
		
		if (__method__ == null) {
			// Crear uno nuevo
			ProductoDAO prodDAO = new ProductoDAOImpl();
			
			String nombre = request.getParameter("nombre");
			String precioStr = request.getParameter("precio");
			String codigo_fabricanteStr = request.getParameter("codigo_fabricante");
			
			try {
				
				double precio = Double.parseDouble(precioStr);
				int codigo_fabricante = Integer.parseInt(codigo_fabricanteStr);
				Producto nuevoProd = new Producto();
				nuevoProd.setNombre(nombre);
				nuevoProd.setPrecio(precio);
				nuevoProd.setCodigo_fabricante(codigo_fabricante);
				prodDAO.create(nuevoProd);	
				
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}		
			
		} else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
			doPut(request, response);
			
		
		} else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
			doDelete(request, response);
			
			
			
		} else {
			
			System.out.println("Opción POST no soportada.");
			
		}
		
		response.sendRedirect("/tienda_informatica/productos");
		//response.sendRedirect("/tienda_informatica/productos");
		
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductoDAO prodDAO = new ProductoDAOImpl();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String precioStr = request.getParameter("precio");
		String codigo_fabricanteStr = request.getParameter("codigo_fabricante");
		Producto prod = new Producto();
		
		try {
			
			int id = Integer.parseInt(codigo);
			double precio = Double.parseDouble(precioStr);
			int codigo_fabricante = Integer.parseInt(codigo_fabricanteStr);
			prod.setCodigo(id);
			prod.setNombre(nombre);
			prod.setPrecio(precio);
			prod.setCodigo_fabricante(codigo_fabricante);
			prodDAO.update(prod);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		ProductoDAO prodDAO = new ProductoDAOImpl();
		String codigo = request.getParameter("codigo");
		
		try {
			
			int id = Integer.parseInt(codigo);
		
		prodDAO.delete(id);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
}
