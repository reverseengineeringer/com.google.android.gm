package com.android.mail.ui;

import android.app.Fragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.android.mail.providers.Account;

public class WaitFragment
  extends Fragment
  implements View.OnClickListener, LoaderManager.LoaderCallbacks<Cursor>
{
  private Account mAccount;
  private ViewGroup mContainer;
  private boolean mDefault;
  private LayoutInflater mInflater;
  
  private View getContent()
  {
    mContainer.removeAllViews();
    if ((mAccount != null) && ((mAccount.syncStatus & 0x10) == 16))
    {
      View localView = mInflater.inflate(2130968691, mContainer, false);
      localView.findViewById(2131755266).setOnClickListener(this);
      localView.findViewById(2131755267).setOnClickListener(this);
      return localView;
    }
    if (mDefault) {
      return mInflater.inflate(2130968690, mContainer, false);
    }
    return mInflater.inflate(2130968694, mContainer, false);
  }
  
  public static WaitFragment newInstance(Account paramAccount)
  {
    return newInstance(paramAccount, false);
  }
  
  public static WaitFragment newInstance(Account paramAccount, boolean paramBoolean)
  {
    WaitFragment localWaitFragment = new WaitFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("account", paramAccount);
    localBundle.putBoolean("isDefault", paramBoolean);
    localWaitFragment.setArguments(localBundle);
    return localWaitFragment;
  }
  
  Account getAccount()
  {
    return mAccount;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = new Intent("android.settings.SYNC_SETTINGS");
      paramView.addFlags(268435456);
      startActivity(paramView);
      return;
    } while ((mAccount == null) || (mAccount.manualSyncUri == null));
    getLoaderManager().initLoader(0, null, this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    mAccount = ((Account)paramBundle.getParcelable("account"));
    mDefault = paramBundle.getBoolean("isDefault", false);
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new CursorLoader(getActivity(), mAccount.manualSyncUri, null, null, null, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    mInflater = paramLayoutInflater;
    mContainer = paramViewGroup;
    return getContent();
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor) {}
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public void updateAccount(Account paramAccount)
  {
    mAccount = paramAccount;
    mContainer.addView(getContent());
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.WaitFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */