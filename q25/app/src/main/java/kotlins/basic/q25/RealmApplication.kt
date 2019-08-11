package kotlins.basic.q25

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmApplication : Application(){
    override fun onCreate() {
        super.onCreate()
 
        Realm.init(this) //設定(初期化)
        val realmConfiguration = RealmConfiguration.Builder()
            .schemaVersion(0)
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }
}