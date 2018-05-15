package ir.hatamiarash.titar.db;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import ir.hatamiarash.titar.models.User;

public class DatabaseHandler {
	private static RealmConfiguration mRealmConfig;
	private Context mContext;
	private Realm realm;
	
	public DatabaseHandler(Context context) {
		this.mContext = context;
		Realm.init(context);
		this.realm = getNewRealmInstance();
	}
	
	public Realm getNewRealmInstance() {
		if (mRealmConfig == null) {
			mRealmConfig = new RealmConfiguration.Builder()
					.schemaVersion(1)
					.migration(new Migration())
					.build();
		}
		return Realm.getInstance(mRealmConfig);
	}
	
	public Realm getRealmInstance() {
		return realm;
	}
	
	public void addUser(User user) {
		realm.beginTransaction();
		realm.copyToRealm(user);
		realm.commitTransaction();
	}
	
	public User getUser(long id) {
		return realm.where(User.class)
				.equalTo("id", id)
				.findFirst();
	}
	
	public void updateUser(User user) {
		realm.beginTransaction();
		realm.copyToRealmOrUpdate(user);
		realm.commitTransaction();
	}
}
