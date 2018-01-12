package pl.itcraft.test.activity.splash;

import android.content.Context;
import pl.itcraft.core.view.activity.CoreActivityPresenter;

public class SplashActivityPresenter extends CoreActivityPresenter<SplashActivityView> {

	//region Constructor

	protected SplashActivityPresenter(
		Context context, SplashActivityView view) {
		super(context, view);
	}

	//endregion

}
