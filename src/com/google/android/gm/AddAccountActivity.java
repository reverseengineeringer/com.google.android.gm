package com.google.android.gm;

import android.os.Bundle;
import ddy;
import dem;
import dfd;

public class AddAccountActivity
  extends dfd
{
  public boolean a = false;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!a) {
      new ddy(this).a(new dem(this, this));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.AddAccountActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */