package ir.hatamiarash.titar.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;
import com.github.ybq.android.spinkit.style.Wave;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.hatamiarash.titar.R;
import ir.hatamiarash.titar.network.Internet;
import ir.hatamiarash.titar.utils.FontUtils;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static ir.hatamiarash.titar.Titar.HOST;

public class SplashActivity extends AppCompatActivity {
	@BindView(R.id.logo)
	public ImageView logo;
	@BindView(R.id.spinner)
	public ProgressBar spinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		ButterKnife.bind(this);
		
		Wave animation = new Wave();
		spinner.setIndeterminateDrawable(animation);
		logo.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.splash_logo));
		CheckConnection();
	}
	
	private void CheckConnection() {
		if (Internet.CheckInternet2(getApplicationContext())) {
			new CheckInternet().execute(getResources().getString(R.string.url_check, HOST));
		} else {
			new MaterialStyledDialog.Builder(SplashActivity.this)
					.setTitle(FontUtils.getSpannedString(getApplicationContext(), "خطا"))
					.setDescription(FontUtils.getSpannedString(getApplicationContext(), "اتصال به اینترنت را بررسی نمایید."))
					.setStyle(Style.HEADER_WITH_TITLE)
					.setHeaderColor(R.color.Red)
					.withDarkerOverlay(true)
					.withDialogAnimation(true)
					.setCancelable(false)
					.setPositiveText("باشه")
					.setNegativeText("خروج")
					.onPositive(new MaterialDialog.SingleButtonCallback() {
						@Override
						public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
							CheckConnection();
						}
					})
					.onNegative(new MaterialDialog.SingleButtonCallback() {
						@Override
						public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
							android.os.Process.killProcess(android.os.Process.myPid());
						}
					})
					.show();
		}
	}
	
	class CheckInternet extends AsyncTask<String, Void, Boolean> {
		@Override
		protected Boolean doInBackground(String... strings) {
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(strings[0]).openConnection();
				connection.setConnectTimeout(2000);
				return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
			} catch (SocketTimeoutException | MalformedURLException e) {
				Timber.e(e);
				return false;
			} catch (IOException e) {
				Timber.e(e);
				return false;
			} catch (Exception e) {
				Timber.e(e);
				return false;
			}
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			if (result) {
				Intent i = new Intent(SplashActivity.this, MainActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				finish();
			} else {
				new MaterialStyledDialog.Builder(SplashActivity.this)
						.setTitle(FontUtils.getSpannedString(getApplicationContext(), "خطا"))
						.setDescription(FontUtils.getSpannedString(getApplicationContext(), "اتصال به اینترنت را بررسی نمایید."))
						.setStyle(Style.HEADER_WITH_TITLE)
						.setHeaderColor(R.color.Red)
						.withDarkerOverlay(true)
						.withDialogAnimation(true)
						.setCancelable(false)
						.setPositiveText("باشه")
						.setNegativeText("خروج")
						.onPositive(new MaterialDialog.SingleButtonCallback() {
							@Override
							public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
								CheckConnection();
							}
						})
						.onNegative(new MaterialDialog.SingleButtonCallback() {
							@Override
							public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
								android.os.Process.killProcess(android.os.Process.myPid());
							}
						})
						.show();
			}
		}
	}
	
	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
	}
}