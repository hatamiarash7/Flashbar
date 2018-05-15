package ir.hatamiarash.titar.db;

import android.support.annotation.NonNull;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

class Migration implements RealmMigration {
	
	@Override
	public void migrate(@NonNull final DynamicRealm realm, long oldVersion, long newVersion) {
	}
}
