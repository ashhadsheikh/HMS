package administrator;

import javax.swing.table.DefaultTableModel;

public class UserAccounts {
	UserAccount account;
	public boolean PasswordCheck(String user, String pass) {
		account=new UserAccount(user, pass);
		return AdministratorsDB.getDbHandler().checkLoginInformation(account);
	}
	public void updateAccount(String user, String pass, String new_user) {
		account=new UserAccount(user, pass);
		AdministratorsDB.getDbHandler().updateAccount(account, new_user);
	}

	public void addAccount(String user, String pass) {
		account=new UserAccount(user, pass);
		AdministratorsDB.getDbHandler().addAccount(account);
	}
	public boolean deleteAccount(String user) {
		return AdministratorsDB.getDbHandler().deleteAccount(user);
	}
	public DefaultTableModel userAccounts() {
		return AdministratorsDB.getDbHandler().userAccounts();
	}
}
