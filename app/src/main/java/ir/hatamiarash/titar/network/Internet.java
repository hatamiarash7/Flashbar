package ir.hatamiarash.titar.network;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import ir.hatamiarash.titar.utils.MakeToast;
import ir.hatamiarash.titar.variables.TAGs;
import timber.log.Timber;

public class Internet {
	public static boolean CheckInternet(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		PackageManager PM = context.getPackageManager();
		if (PM.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
			if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
					connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
				return true;
		} else {
			if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
				return true;
		}
		MakeToast.Toast(context, "اتصال به اینترنت را بررسی نمایید", TAGs.WARNING);
		return false;
	}
	
	public static boolean CheckInternet2(Context context) {
		try {
			ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			PackageManager PM = context.getPackageManager();
			if (PM.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
				return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
						connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;
			} else {
				return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;
			}
		} catch (NullPointerException e) {
			Timber.e(e);
			return false;
		}
	}
}
