package br.com.gellog.teste;


import java.math.BigDecimal;

import br.com.gellog.dao.SimpleQueries;
import br.com.gellog.dao.TabelaFreteQueries;
import br.com.gellog.model.TabelaFreteModel;


public class Test {
	
	public static void main(String[] args) {
		
	
	//		 TabelaFreteModel tabela = new TabelaFreteModel(new BigDecimal(400), new BigDecimal(500.6), new BigDecimal(300.69), new BigDecimal(100.54), new BigDecimal(100.43), new BigDecimal(100.0), new BigDecimal(100.11), new BigDecimal(100), new BigDecimal(100));
			//TabelaFreteModel tabelaFreteModel =	new TabelaFreteModel(new BigDecimal(9.9), new BigDecimal(9.5), new BigDecimal(9.3), new BigDecimal(9.6), new BigDecimal(8.9), new BigDecimal(8.6), new BigDecimal(8.7), new BigDecimal(7.6), new BigDecimal(7.76));
			//tabelaFreteModel.setId(1);
			
			 System.out.println(new TabelaFreteQueries().lastResult());
			 //consulta.updateObject(tabelaFreteModel, 1);
			 
			 //consulta.simpleInsert(tabela);
			 
			 //System.out.println(consulta.idSearch(tabela, 1));
		
		//People people = new People("Thunder", "Cat");			 

		//PeopleQueries pQuery = new PeopleQueries();
		
		//pQuery.simpleInsert(people);
		
		
		//System.out.println(sQuery.tableSearch("People"));
		//System.out.println(pQuery.idSearch(4)+"=============================");
		//System.out.println(pQuery.nameSearch("Murilo")+"==============================");
		//System.out.println(pQuery.tableSearch());
		

	}
}
