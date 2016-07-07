package com.gijoehosaphat.keepscreenon;

import android.app.Activity;
import android.app.Application;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class KeepScreenOnModule extends ReactContextBaseJavaModule {

  private Activity mActivity = null;
  private ReactApplicationContext mContext = null;

  public KeepScreenOnModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.mActivity = getCurrentActivity();
    this.mContext = reactContext;
  }

  @Override
  public String getName() {
    return "KeepScreenOn";
  }

  @ReactMethod
  public void setKeepScreenOn(Boolean bKeepScreenOn) {
    if (bKeepScreenOn == true) {
      this.mActivity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
          KeepScreenOnModule.this.mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
      });
    } else if (bKeepScreenOn == false) {
      this.mActivity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
          KeepScreenOnModule.this.mActivity.getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
      });
    }
  }
}
