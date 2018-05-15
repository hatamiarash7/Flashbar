package ir.hatamiarash.titar;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;

import co.ronash.pushe.Pushe;
import io.fabric.sdk.android.Fabric;
import ir.hatamiarash.titar.analytics.Analytics;
import ir.hatamiarash.titar.analytics.ApplicationAnalytics;
import ir.hatamiarash.titar.db.DatabaseHandler;
import ir.hatamiarash.titar.logs.CrashlyticsTree;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Titar extends Application {
	private static Titar titar;
	public static String HOST;
	
	@Nullable
	private Analytics analytics;
	
	@Override
	public void onCreate() {
		super.onCreate();
		titar = this;
		configLibraries();
		setFont();
		HOST = getResources().getString(R.string.url_host);
	}
	
	private void configLibraries() {
		Fabric fabric = new Fabric.Builder(this)
				.kits(new Crashlytics(), new Answers())
				.debuggable(true)
				.build();
		Fabric.with(fabric);
		
		Pushe.initialize(this, true);
		
		if (BuildConfig.DEBUG)
			Timber.plant(new Timber.DebugTree());
		else
			Timber.plant(new CrashlyticsTree());
	}
	
	private void setFont() {
		CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
				.setDefaultFontPath("fonts/IRANSansMobile.ttf")
				.setFontAttrId(R.attr.fontPath)
				.build());
	}
	
	public static Titar getInstance() {
		if (titar == null)
			titar = new Titar();
		return titar;
	}
	
	@NonNull
	public Analytics getAnalytics() {
		if (analytics == null) {
			analytics = new ApplicationAnalytics();
			analytics.init(this);
		}
		return analytics;
	}
	
	@NonNull
	public DatabaseHandler getDBHandler() {
		return new DatabaseHandler(getApplicationContext());
	}
}
