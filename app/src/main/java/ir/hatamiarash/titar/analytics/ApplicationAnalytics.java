package ir.hatamiarash.titar.analytics;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import ir.hatamiarash.titar.BuildConfig;

public class ApplicationAnalytics implements Analytics {
	private Tracker mTracker;
	
	@Override
	public void init(@NonNull final Context context) {
		GoogleAnalytics analytics = GoogleAnalytics.getInstance(context);
		mTracker = analytics.newTracker(BuildConfig.GOOGLE_ANALYTICS_TRACKER);
		mTracker.enableAdvertisingIdCollection(true);
		
		if (BuildConfig.DEBUG) {
			GoogleAnalytics.getInstance(context).setAppOptOut(true);
			Log.w("GoogleAnalytics", "DEBUG BUILD: ANALYTICS IS DISABLED");
		}
	}
	
	@Override
	public void reportScreen(@NonNull String name) {
		mTracker.setScreenName(name);
		mTracker.send(new HitBuilders.ScreenViewBuilder().build());
	}
	
	@Override
	public void reportAction(@NonNull String category, @NonNull String name) {
		mTracker.send(new HitBuilders.EventBuilder()
				.setCategory(category)
				.setAction(name)
				.build());
	}
	
	@Override
	public void reportEvent(@NonNull String event) {
		Answers.getInstance().logCustom(new CustomEvent(event));
	}
}