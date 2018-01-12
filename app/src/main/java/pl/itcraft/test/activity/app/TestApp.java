package pl.itcraft.test.activity.app;

import com.crashlytics.android.Crashlytics;
import com.facebook.FacebookSdk;
import com.twitter.sdk.android.core.Twitter;
import io.fabric.sdk.android.Fabric;
import pl.itcraft.core.BuildConfig;
import pl.itcraft.core.app.CoreApp;

public class TestApp extends CoreApp {
	@Override
	protected int provideVersionCode() {
		return BuildConfig.VERSION_CODE;
	}

	@Override
	protected String provideVersionName() {
		return BuildConfig.VERSION_NAME;
	}

	@Override
	protected boolean provideDebugMode() {
		return BuildConfig.DEBUG;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		this.initializeCrashlytics();
		this.initializeFacebook();
		this.initializeTwitter();
	}

	private void initializeCrashlytics() {
//		if (!BuildConfig.DEBUG) {
		Fabric.with(this, new Crashlytics());
//		}
	}

	private void initializeFacebook() {
		FacebookSdk.sdkInitialize(this);
	}

	private void initializeTwitter() {
		Twitter.initialize(this);
	}
}
