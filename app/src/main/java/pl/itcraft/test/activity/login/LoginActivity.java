package pl.itcraft.test.activity.login;

import android.view.View;
import android.widget.EditText;
import pl.itcraft.core.app.CoreApp;
import pl.itcraft.core.managers.snack.SnackBuilder.Mode;
import pl.itcraft.core.view.activity.CoreActivity;
import pl.itcraft.test.R;

public class LoginActivity extends CoreActivity<LoginPresenter> implements LoginView {


	@Override
	protected int getLayoutRes() {
		return R.layout.activity_login;
	}

	@Override
	public String getEmail() {
		return ((EditText) this.findViewById(R.id.email)).getText().toString();
	}

	@Override
	public String getPassword() {
		return ((EditText) this.findViewById(R.id.password)).getText().toString();
	}

	@Override
	public void showWorking(String message) {
		CoreApp.getSnackManager().prepareSnack(message, Mode.INFO).show();
	}

	@Override
	public void showLoginSuccess() {
		CoreApp.getSnackManager().prepareSnack("Logged in successfully!", Mode.INFO).show();
	}

	@Override
	public void showLoginError() {
		CoreApp.getSnackManager().prepareSnack("Cannot log in.", Mode.ERROR).show();
	}

	public void loginClicked(View view) {
		this.getPresenter().onLoginButtonClicked();
	}

	public void loginWithFacebookClicked(View view) {
		this.getPresenter().onLoginWithFacebookButtonClicked();
	}

	public void loginWithTwitterClicked(View view) {
		this.getPresenter().onLoginWithTwitterButtonClicked();
	}
}
