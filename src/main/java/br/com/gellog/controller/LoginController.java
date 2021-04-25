package br.com.gellog.controller;

import java.awt.HeadlessException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import br.com.gellog.dao.LoginDAO;
import br.com.gellog.dao.SimpleQueries;
import br.com.gellog.model.Login;
import br.com.gellog.model.TabelaLogin;
import br.com.gellog.view.util.CreateAndShowGUI;

public class LoginController {
	private List<Login> loginCheck;
	static private Login ultimoLogado;
	public boolean login(final String user, final String password) {
		loginCheck = new LoginDAO().loginResult(user, password);
		try {	
				if (loginCheck != null) {
					new SimpleQueries().simpleInsert(new TabelaLogin(loginCheck));
					ultimoLogado = loginCheck.get(0);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new CreateAndShowGUI().createAndShowGUI();
						}
					});
					return true;
				}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Falha ao Logar", JOptionPane.WARNING_MESSAGE);
		return false;
	}
	public static Login getUltimoLogado() {
		return ultimoLogado;
	}
}