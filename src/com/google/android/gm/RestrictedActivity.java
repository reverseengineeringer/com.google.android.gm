package com.google.android.gm;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.view.MenuInflater;

public abstract interface RestrictedActivity
{
  public abstract void finish();
  
  public abstract ActionBar getActionBar();
  
  public abstract ContentResolver getContentResolver();
  
  public abstract Context getContext();
  
  public abstract FragmentManager getFragmentManager();
  
  public abstract Intent getIntent();
  
  public abstract MenuInflater getMenuInflater();
  
  public abstract UiHandler getUiHandler();
  
  public abstract void invalidateOptionsMenu();
  
  public abstract void onBackPressed();
  
  public abstract void setContentView(int paramInt);
  
  public abstract void setResult(int paramInt, Intent paramIntent);
}

/* Location:
 * Qualified Name:     com.google.android.gm.RestrictedActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */