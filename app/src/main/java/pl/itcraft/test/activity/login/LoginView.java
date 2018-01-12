package pl.itcraft.test.activity.login;

import pl.itcraft.core.view.activity.CoreActivityView;

public interface LoginView extends CoreActivityView {

	void showWorking(String message);

	String getEmail();

	String getPassword();

	void showLoginSuccess();

	void showLoginError();
}
