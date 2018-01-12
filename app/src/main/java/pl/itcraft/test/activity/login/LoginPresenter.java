package pl.itcraft.test.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.TwitterAuthProvider;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import java.util.Arrays;
import pl.itcraft.core.view.activity.CoreActivityPresenter;

public class LoginPresenter extends CoreActivityPresenter<LoginView> {

	private CallbackManager   facebookAuthenticationManager = CallbackManager.Factory.create();
	private TwitterAuthClient twitterAuthenticationManager  = new TwitterAuthClient();

	protected LoginPresenter(Context context, LoginView view) {
		super(context, view);
	}

	@Override
	public void onViewResult(int requestCode, int resultCode, Intent data) {
		super.onViewResult(requestCode, resultCode, data);

		this.facebookAuthenticationManager.onActivityResult(requestCode, resultCode, data);
		this.twitterAuthenticationManager.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		LoginManager.getInstance().registerCallback(
			this.facebookAuthenticationManager, new FacebookCallback<LoginResult>() {
				@Override
				public void onSuccess(LoginResult loginResult) {
					final String token = loginResult.getAccessToken().getToken();
					if (token != null) {
						final AuthCredential credentials = FacebookAuthProvider.getCredential(token);
						FirebaseAuth.getInstance().signInWithCredential(credentials).addOnCompleteListener(
							task -> {
								if (task.isSuccessful()) {
									getView().showLoginSuccess();
								} else {
									getView().showLoginError();
								}
							});
					}
				}

				@Override
				public void onCancel() {
					// TODO:
				}

				@Override
				public void onError(FacebookException error) {
					getView().showLoginError();
				}
			});
	}

	void onLoginButtonClicked() {
		// TODO:
	}

	void onLoginWithFacebookButtonClicked() {
		LoginManager.getInstance()
			.logInWithReadPermissions((LoginActivity) this.getView(), Arrays.asList("public_profile", "email"));
	}

	void onLoginWithTwitterButtonClicked() {
		this.twitterAuthenticationManager.authorize(
			(LoginActivity) this.getView(), new Callback<TwitterSession>() {
				@Override
				public void success(Result<TwitterSession> result) {
					final TwitterAuthToken token       = result.data.getAuthToken();
					final AuthCredential   credentials = TwitterAuthProvider.getCredential(token.token, token.secret);
					FirebaseAuth.getInstance().signInWithCredential(credentials).addOnCompleteListener(
						task -> {
							if (task.isSuccessful()) {
								getView().showLoginSuccess();
							} else {
								getView().showLoginError();
							}
						});
				}

				@Override
				public void failure(TwitterException exception) {
					getView().showLoginError();
				}
			});
	}
}
