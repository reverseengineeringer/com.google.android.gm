package com.google.android.gm;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;

public abstract class GmailBaseListActivity
  extends ListActivity
  implements RestrictedActivity
{
  private final UiHandler mUiHandler = new UiHandler();
  
  public Context getContext()
  {
    return this;
  }
  
  public UiHandler getUiHandler()
  {
    return mUiHandler;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mUiHandler.setEnabled(true);
  }
  
  protected void onResume()
  {
    super.onResume();
    mUiHandler.setEnabled(true);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    mUiHandler.setEnabled(false);
  }
  
  protected void onStart()
  {
    super.onStart();
    mUiHandler.setEnabled(true);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GmailBaseListActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */