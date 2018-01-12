package pl.itcraft.test.activity.splash;

import android.view.View;
import pl.itcraft.core.app.CoreApp;
import pl.itcraft.core.view.activity.CoreActivity;
import pl.itcraft.test.R;
import pl.itcraft.test.activity.login.LoginActivity;

public class SplashActivity extends CoreActivity<SplashActivityPresenter> implements SplashActivityView {

	//region Getters and Setters

	@Override
	protected int getLayoutRes() {
		return R.layout.activity_splash;
	}

	//endregion

	public void continueClicked(View view) {
//		throw new RuntimeException("This is a crash");
		CoreApp.getNavigation().openActivity(LoginActivity.class);
	}
}
