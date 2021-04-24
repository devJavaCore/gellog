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
	private List<Login> loginList;
	static private Login ultimoLogado;
	public boolean login(final String user, final String password) {
		loginList = new LoginDAO().resultList();
		try {
			for (Login login : loginList) {
				if (login.getUserName().equals(user) && login.getPassword().equals(password)) {
					new SimpleQueries().simpleInsert(new TabelaLogin(login));
					ultimoLogado = login;
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new CreateAndShowGUI().createAndShowGUI();
						}
					});
					return true;
				}

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