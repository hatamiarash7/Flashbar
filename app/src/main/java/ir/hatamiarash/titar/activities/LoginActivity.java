package ir.hatamiarash.titar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.hatamiarash.titar.R;
import ir.hatamiarash.titar.Titar;
import ir.hatamiarash.titar.analytics.Analytics;
import mehdi.sakout.fancybuttons.FancyButton;

public class LoginActivity extends AppCompatActivity {
	Titar application;
	Analytics analytics;
	
	@BindView(R.id.btnGoogle)
	FancyButton btnGoogle;
	@BindView(R.id.btnGithub)
	FancyButton btnGithub;
	
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_login);
		ButterKnife.bind(this);
		
		application = (Titar) getApplication();
		analytics = application.getAnalytics();
		analytics.reportScreen("Login Activity");
		analytics.reportEvent("Open Login Activity");
		
		btnGoogle.setCustomTextFont("IRANSansMobile.ttf");
		btnGoogle.setIconResource("\uf1a0");
		btnGoogle.setFontIconSize(20);
		btnGoogle.setIconPadding(20, 0, 0, 0);
		btnGithub.setCustomTextFont("IRANSansMobile.ttf");
		btnGithub.setIconResource("\uf09b");
		btnGithub.setFontIconSize(20);
		btnGithub.setIconPadding(20, 0, 0, 0);
	}
}
