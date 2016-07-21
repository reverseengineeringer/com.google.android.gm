package com.android.email.activity.setup;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import avv;
import bgz;

public class HeadlessAccountSettingsLoader
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    long l = -1L;
    if (localIntent.getData() != null) {
      l = bgz.a(localIntent.getData(), "ACCOUNT_ID");
    }
    if (paramBundle == null) {
      new avv(this, getApplicationContext(), localIntent.getData().getLastPathSegment()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Long[] { Long.valueOf(l) });
    }
  }
  
  public void onResume()
  {
    super.onResume();
    finish();
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.HeadlessAccountSettingsLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */