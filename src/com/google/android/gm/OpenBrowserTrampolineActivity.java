package com.google.android.gm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import dfh;

public class OpenBrowserTrampolineActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    super.onCreate(paramBundle, paramPersistableBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {
      dfh.a(getApplicationContext(), paramBundle.getData(), false);
    }
    finish();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.OpenBrowserTrampolineActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */