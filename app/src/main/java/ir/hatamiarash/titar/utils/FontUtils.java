/*
 * Copyright (c) 2018 - All Rights Reserved - Arash Hatami
 */

package ir.hatamiarash.titar.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;

public class FontUtils {
	public static final String FontPath = "fonts/IRANSansMobile.ttf";
	public static final String FontPathBold = "fonts/IRANSansMobile_Bold.ttf";
	private static FontUtils instance;
	private static Typeface persianTypeface;
	
	private FontUtils(Context context) {
		persianTypeface = Typeface.createFromAsset(context.getAssets(), FontPath);
	}
	
	public static synchronized FontUtils getInstance(Context context) {
		if (instance == null)
			instance = new FontUtils(context);
		return instance;
	}
	
	public static synchronized SpannableString getSpannedString(Context context, String TEXT) {
		persianTypeface = Typeface.createFromAsset(context.getAssets(), FontPath);
		SpannableString result = new SpannableString(TEXT);
		result.setSpan(new TypefaceSpan(persianTypeface), 0, result.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return result;
	}
	
	Typeface getPersianTypeface() {
		return persianTypeface;
	}
}