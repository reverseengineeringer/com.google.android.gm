package com.google.android.gm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import ddy;
import def;
import dfd;
import dri;

public class ReauthenticateActivity
  extends dfd
  implements def
{
  private String a;
  
  public final void a(boolean paramBoolean)
  {
    int i = 0;
    dri.c(dri.a, "Credential prompt successful: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      i = -1;
    }
    setResult(i);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a = getIntent().getData().getQueryParameter("account");
  }
  
  public void onResume()
  {
    super.onResume();
    ddy.a(this, a, this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ReauthenticateActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */