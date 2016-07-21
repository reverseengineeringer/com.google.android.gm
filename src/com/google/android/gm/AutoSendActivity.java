package com.google.android.gm;

import android.content.Intent;
import android.os.Bundle;
import cbg;

public class AutoSendActivity
  extends cbg
{
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if ((localIntent.getExtras() != null) && (localIntent.getExtras().containsKey("com.google.android.gm.extra.ACCOUNT"))) {
      localIntent.putExtra("fromAccountString", localIntent.getStringExtra("com.google.android.gm.extra.ACCOUNT"));
    }
    super.onCreate(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.AutoSendActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */