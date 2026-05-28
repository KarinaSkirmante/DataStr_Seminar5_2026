package service;

import datastr.MyGraph;
import model.City;
import model.Country;

public class MainService {

	public static void main(String[] args) {
		
		System.out.println("------GRAFS AR STRING ELEMENTIEM-------");
		MyGraph<String> map = new MyGraph<String>();
		
		try
		{
			map.addVertice("Atlanta");
			map.addVertice("Austin");
			map.addVertice("Chicago");
			map.addVertice("Dallas");
			map.addVertice("Denver");
			map.addVertice("Houston");
			map.addVertice("Washington");
			map.addEdge("Austin", "Houston", 160);
			map.addEdge("Austin", "Dallas", 200);
			map.addEdge("Dallas", "Austin", 200);
			map.addEdge("Dallas", "Chicago", 900);
			map.addEdge("Houston", "Atlanta", 800);
			map.addEdge("Atlanta", "Houston", 800);
			map.addEdge("Atlanta", "Washington", 600);
			map.addEdge("Washington", "Atlanta", 600);
			map.addEdge("Denver", "Chicago", 1000);
			map.addEdge("Chicago", "Denver", 1000);
			map.print();
			System.out.println(map.searchPath("Austin", "Washington"));//mēģinām atrast ceļu no Austinas uz Washingtonas
			System.out.println(map.searchPath("Austin", "Denver"));//mēģinām atrast ceļu no Austinas uz Denver
			System.out.println(map.searchPath("Austin", "Riga"));//nav Rīga un ceļu nevar atrast
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		System.out.println("------GRAFS AR CITY ELEMENTIEM-------");
		MyGraph<City> map2 = new MyGraph<City>();
		try
		{
			City c1 = new City("Ventspils", 55.4f, "LV-3601", Country.Latvia);
			City c2 = new City("Kuldīga", 13f, "LV-3401", Country.Latvia);
			City c3 = new City("Liepāja", 68.02f, "LV-3201", Country.Latvia);
			
			map2.addVertice(c1);
			map2.addVertice(c2);
			map2.addVertice(c3);
			map2.addEdge(c1, c2, 50);
			map2.addEdge(c1, c3, 111);
			map2.addEdge(c2, c3, 84);
			map2.print();
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
