package br.com.gellog.controller;

import java.util.List;

import br.com.gellog.dao.MotoristaDAO;
import br.com.gellog.dao.VeiculoDAO;
import br.com.gellog.model.Motorista;
import br.com.gellog.model.Veiculo;

public class VeiculoController {
	private static Veiculo veiculo;
	static public void veiculo(String modelo, String placa, String tipo, String descricao) {
		veiculo = new Veiculo(modelo, placa, tipo, descricao);
		
		veiculo.setMotorista((Motorista) new MotoristaDAO().motoristaLastResult());
		
		new VeiculoDAO().adiconaVeiculo(veiculo);
	}
	
	static public void updateVeiculo(String modelo, String placa, String tipo, String descricao, Motorista motorista) {
		
		veiculo = new Veiculo(modelo, placa, tipo, descricao);
	
		veiculo.setMotorista(motorista);
		
		new VeiculoDAO().adiconaVeiculo(veiculo);
	}
	
	public static List<Veiculo> getVeiculos(int id) {

		return new VeiculoDAO().veiculoPorMotoristaId(id);
	}

	public static List<Veiculo> getVeiculosTipo(String tipo) {

		return new VeiculoDAO().comparaTipo(tipo);
	}

	public static void deletaVeiculo(Motorista motorista) {
		List<Veiculo> veiculos = new VeiculoDAO().veiculoPorMotoristaId(motorista.getId());
		for (Veiculo veic : veiculos) {
			new VeiculoDAO().deleteById(veic, veic.getId());
		}
	}
}
