package com.android.mail.ui;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract interface RestrictedActivity
{
  public abstract View findViewById(int paramInt);
  
  public abstract void finish();
  
  public abstract ActionBar getActionBar();
  
  public abstract Context getActivityContext();
  
  public abstract Context getApplicationContext();
  
  public abstract ComponentName getComponentName();
  
  public abstract ContentResolver getContentResolver();
  
  public abstract FragmentManager getFragmentManager();
  
  public abstract Intent getIntent();
  
  public abstract LoaderManager getLoaderManager();
  
  public abstract MenuInflater getMenuInflater();
  
  public abstract ToastBarOperation getPendingToastOperation();
  
  public abstract void invalidateOptionsMenu();
  
  public abstract boolean isChangingConfigurations();
  
  public abstract boolean isFinishing();
  
  public abstract void onBackPressed();
  
  public abstract boolean onOptionsItemSelected(MenuItem paramMenuItem);
  
  public abstract boolean onSearchRequested(String paramString);
  
  public abstract void setContentView(int paramInt);
  
  public abstract void setDefaultKeyMode(int paramInt);
  
  public abstract void setPendingToastOperation(ToastBarOperation paramToastBarOperation);
  
  public abstract ActionMode startActionMode(ActionMode.Callback paramCallback);
  
  public abstract void startActivity(Intent paramIntent);
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.RestrictedActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */