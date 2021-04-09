package br.com.gellog.teste;


import java.math.BigDecimal;

import br.com.gellog.dao.DAOQueries;
import br.com.gellog.dao.PeopleQueries;
import br.com.gellog.model.People;
import br.com.gellog.model.TabelaFrete;


public class Test {
	
	public static void main(String[] args) {
	
			 TabelaFrete tabela = new TabelaFrete(new BigDecimal(400), new BigDecimal(500.6), new BigDecimal(300.69), new BigDecimal(100.54), new BigDecimal(100.43), new BigDecimal(100.0), new BigDecimal(100.11), new BigDecimal(100), new BigDecimal(100));
		
			 DAOQueries consulta = new DAOQueries();
			 
			 consulta.simpleInsert(tabela);
			 
			 System.out.println(consulta.idSearch(tabela, 1));
		
		//People people = new People("Thunder", "Cat");			 

		//PeopleQueries pQuery = new PeopleQueries();
		
		//pQuery.simpleInsert(people);
		
		
		//System.out.println(sQuery.tableSearch("People"));
		//System.out.println(pQuery.idSearch(4)+"=============================");
		//System.out.println(pQuery.nameSearch("Murilo")+"==============================");
		//System.out.println(pQuery.tableSearch());
		

	}
}
