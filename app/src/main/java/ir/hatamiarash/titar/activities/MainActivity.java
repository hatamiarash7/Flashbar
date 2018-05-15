package ir.hatamiarash.titar.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.andrognito.flashbar.Flashbar;
import com.andrognito.flashbar.anim.FlashAnim;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.hatamiarash.titar.R;
import ir.hatamiarash.titar.Titar;
import ir.hatamiarash.titar.analytics.Analytics;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
	Titar application;
	Analytics analytics;
	Flashbar flashbar;
	
	@BindView(R.id.login)
	Button login;
	@BindView(R.id.register)
	Button register;
	
	@OnClick(R.id.login)
	public void login() {
		startActivity(new Intent(this, LoginActivity.class));
	}
	
	@OnClick(R.id.register)
	public void register() {
		startActivity(new Intent(this, RegisterActivity.class));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		
		application = (Titar) getApplication();
		analytics = application.getAnalytics();
		
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		analytics.reportScreen("Main Activity");
		analytics.reportEvent("Open Main Activity");
		
		flashbar = new Flashbar.Builder(this)
				.gravity(Flashbar.Gravity.BOTTOM)
				.title("سلام دنیا")
				.message("به تیتار خوش آمدید")
				.backgroundColorRes(R.color.Red)
				.messageTypeface(Typeface.createFromAsset(getAssets(), "fonts/IRANSansMobile.ttf"))
				.titleTypeface(Typeface.createFromAsset(getAssets(), "fonts/IRANSansMobile_Bold.ttf"))
				.showOverlay()
				.enterAnimation(FlashAnim.with(this)
						.animateBar()
						.duration(750)
						.alpha()
						.slideFromLeft())
				.exitAnimation(FlashAnim.with(this)
						.animateBar()
						.duration(400)
						.slideFromRight())
				.enableSwipeToDismiss()
				.listenBarTaps(new Flashbar.OnTapListener() {
					@Override
					public void onTap(Flashbar flashbar) {
						flashbar.dismiss();
					}
				})
				.listenOutsideTaps(new Flashbar.OnTapListener() {
					@Override
					public void onTap(Flashbar flashbar) {
						flashbar.dismiss();
					}
				})
				.build();
		flashbar.show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		return id == R.id.action_settings || super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
	}
}
