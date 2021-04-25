package br.com.gellog.view.util.jcomponents;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import br.com.gellog.controller.LoginController;
import br.com.gellog.view.frame.LoginFrame;

public class JLoginButton extends JButton implements ActionListener, PropertyChangeListener, FocusListener, Runnable {

	public JLoginButton() {
		super();
	}

	private static final long serialVersionUID = 1L;

	private ProgressMonitor progressMonitor;

	private JTextArea taskOutput;
	private Task task;
	private static int progress;
	private static String user, pass;

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		JLoginButton.user = user;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		JLoginButton.pass = pass;
	}

	class Task extends SwingWorker<Void, Void> {
		@Override
		public Void doInBackground() {
			Random random = new Random();
			progress = 0;
			setProgress(0);
			try {
				
				while (progress < 100 && !isCancelled()) {
					// Sleep for up to one second.
					Thread.sleep(random.nextInt(300));
					// Make random progress.
					progress += random.nextInt(15);
					setProgress(Math.min(progress, 100));
				}
			} catch (InterruptedException ignore) {
			}
			return null;
		}
		
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
		try {
			if ("progress" == evt.getPropertyName()) {
				int progress = (Integer) evt.getNewValue();
				progressMonitor.setProgress(progress);
				String message = String.format("Completado %d%%.\n", progress);
				progressMonitor.setNote(message);
				taskOutput.append(message);
				if (progressMonitor.isCanceled() || task.isDone()) {
					Toolkit.getDefaultToolkit().beep();
					if (progressMonitor.isCanceled()) {
						task.cancel(true);
						taskOutput.append("Tarefa Cancelada.\n");
					} else {
						taskOutput.append("Tarefa Completa.\n");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JLoginButton(final JSearchTextField user) {
		user.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				setUser(user.getText());

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public JLoginButton(final JSearchPasswordField pass) {

		pass.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				setPass(String.valueOf(pass.getPassword()));
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public JLoginButton(final JButton btnLogin) {
		// TODO Auto-generated constructor stub

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String title = "Gellog";
		UIManager.put("ProgressMonitor.progressText", title);
		progressMonitor = new ProgressMonitor(JLoginButton.this, "Carregando Dados", "Teste", 0, 100);
		progressMonitor.setProgress(0);
		task = new Task();
		task.addPropertyChangeListener(this);
		task.execute();
		JLoginButton myRunnable = new JLoginButton();
		Thread t = new Thread(myRunnable);
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		boolean login = new LoginController().login(user, pass);
		if (login) {
			LoginFrame.isFrameVisible(false);
			progress = 200;
			task.cancel(true);
		} else {
			progress = 200;
			task.cancel(true);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
	}
}