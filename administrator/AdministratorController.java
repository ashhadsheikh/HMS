package administrator;

import javax.swing.table.DefaultTableModel;
public class AdministratorController {
	UserAccounts userAccounts;
	private static AdministratorController controller;
	private AdministratorController() {
		// TODO Auto-generated constructor stub
		userAccounts=new UserAccounts();
	}
	public static AdministratorController getController() {
		if (controller == null)
			controller = new AdministratorController();
		return controller;
	}
	
	public boolean PasswordCheck(String user, String pass) {
		return userAccounts.PasswordCheck(user,pass);
	}


	public void updateAccount(String user, String pass, String new_user) {
		userAccounts.updateAccount(user, pass, new_user);
	}
	public boolean deleteAccount(String user) {
		return userAccounts.deleteAccount(user);
	}


	public void addAccount(String user, String pass) {
		userAccounts.addAccount(user, pass);
	}
	public DefaultTableModel userAccounts() {
		return userAccounts.userAccounts();
	}

}
