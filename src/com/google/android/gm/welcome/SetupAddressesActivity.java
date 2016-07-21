package com.google.android.gm.welcome;

import android.app.Activity;
import android.os.Bundle;
import buo;
import but;
import dga;

public class SetupAddressesActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(dga.W);
  }
  
  protected void onStart()
  {
    super.onStart();
    buo.a().a(this);
  }
  
  protected void onStop()
  {
    buo.a().b(this);
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.welcome.SetupAddressesActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */