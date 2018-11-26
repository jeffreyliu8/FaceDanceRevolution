package com.askjeffreyliu.facedancerevolution;


import android.app.Application;
import android.content.ContextWrapper;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.pixplicity.easyprefs.library.Prefs;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        if (BuildConfig.DEBUG) {
            FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
//                .methodCount(0)         // (Optional) How many method line to show. Default 2
//                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                    .logStrategy(new LogCatStrategy()) // (Optional) Changes the log strategy to print out. Default LogCat
                    .tag(getString(R.string.app_name))   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                    .build();

            Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        } else {
//            Fabric.with(this, new Crashlytics());
//            Crashlytics.setUserIdentifier(FirebaseAuth.getInstance().getUid());
//            if (FirebaseAuth.getInstance().getCurrentUser() != null) {
//                Crashlytics.setUserName(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber());
//                Crashlytics.setUserEmail(FirebaseAuth.getInstance().getCurrentUser().getEmail());
//            }
        }


        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();


    }


}
