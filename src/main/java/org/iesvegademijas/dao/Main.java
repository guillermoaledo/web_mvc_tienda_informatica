package org.iesvegademijas.dao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FabricanteDAOImpl fabDao = new FabricanteDAOImpl();
		
		//System.out.println(fabDao.getCountProductos(2).get());
		
		System.out.println(fabDao.getAIIDTOPlusCountProductos());;
		
		
	}

}
