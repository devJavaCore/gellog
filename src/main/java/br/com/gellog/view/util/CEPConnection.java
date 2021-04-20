package br.com.gellog.view.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;



public class CEPConnection {
	private String logradouro;      
	private String bairro;
	private String cidade;
	private String uf;

	 public void buscarCep(String cep) 
	    {
	        String json;        

	        try {
	            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
	            URLConnection urlConnection = url.openConnection();
	            InputStream is = urlConnection.getInputStream();
	            BufferedReader br = new BufferedReader(new InputStreamReader(is));

	            StringBuilder jsonSb = new StringBuilder();

	            br.lines().forEach(l -> jsonSb.append(l.trim()));
	            json = jsonSb.toString();
	            
	            // JOptionPane.showMessageDialog(null, json);
	            
	            json = json.replaceAll("[{},:]", "");
	            json = json.replaceAll("\"", "\n");                       
	            String array[] = new String[30];
	            array = json.split("\n");
	            
	            // JOptionPane.showMessageDialog(null, array);
	                             
	            logradouro = array[7];            
	            bairro = array[15];
	            cidade = array[19]; 
	            uf = array[23];
	            
	            
	           /* 
	            jTxtLogradouro.setText(logradouro);
	            jTxtBairro.setText(bairro);
	            jTxtCidade.setText(cidade);
	            jTxtEstado.setText(uf);
	            */
	            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
	            
	        } catch (Exception e) {
	        	logradouro = null;            
	            bairro = null;
	            cidade = null; 
	            uf = null;
	            JOptionPane.showMessageDialog(null,"Cep Invalido!", "Consulta Cep", JOptionPane.DEFAULT_OPTION);
	        }
	    }

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	 
}