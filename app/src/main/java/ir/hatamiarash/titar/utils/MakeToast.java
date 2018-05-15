package ir.hatamiarash.titar.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import ir.hatamiarash.titar.R;
import ir.hatamiarash.titar.variables.TAGs;

public class MakeToast {
	public static void Toast(Context context, String Message, String TAG) {
		if (TAG.equals(TAGs.WARNING))
			CustomToast.custom(context, Message, R.drawable.ic_alert, ContextCompat.getColor(context, R.color.White), ContextCompat.getColor(context, R.color.md_deep_orange_400), Toast.LENGTH_SHORT, true, true).show();
		if (TAG.equals(TAGs.SUCCESS))
			CustomToast.custom(context, Message, R.drawable.ic_success, ContextCompat.getColor(context, R.color.White), ContextCompat.getColor(context, R.color.Green), Toast.LENGTH_SHORT, true, true).show();
		if (TAG.equals(TAGs.ERROR))
			CustomToast.custom(context, Message, R.drawable.ic_error, ContextCompat.getColor(context, R.color.White), ContextCompat.getColor(context, R.color.Red), Toast.LENGTH_SHORT, true, true).show();
	}
	
	public static void Toast(Context context, String Message, String TAG, int DURATION) {
		if (TAG.equals(TAGs.WARNING))
			CustomToast.custom(context, Message, R.drawable.ic_alert, ContextCompat.getColor(context, R.color.White), ContextCompat.getColor(context, R.color.md_deep_orange_400), DURATION, true, true).show();
		if (TAG.equals(TAGs.SUCCESS))
			CustomToast.custom(context, Message, R.drawable.ic_success, ContextCompat.getColor(context, R.color.White), ContextCompat.getColor(context, R.color.Green), DURATION, true, true).show();
		if (TAG.equals(TAGs.ERROR))
			CustomToast.custom(context, Message, R.drawable.ic_error, ContextCompat.getColor(context, R.color.White), ContextCompat.getColor(context, R.color.Red), DURATION, true, true).show();
	}
}
