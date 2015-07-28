package com.google.android.gm.preference;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceActivity.Header;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.android.mail.providers.Folder;
import com.google.android.gm.AccountHelper;
import com.google.android.gm.AccountHelper.AddAccountCallback;
import com.google.android.gm.ApplicationMenuHandler;
import com.google.android.gm.ApplicationMenuHandler.HelpCallback;
import com.google.android.gm.LabelsActivity;
import com.google.android.gm.Utils;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.provider.UiProvider;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class GmailPreferenceActivity
  extends PreferenceActivity
  implements SharedPreferences.OnSharedPreferenceChangeListener, AccountHelper.AddAccountCallback, ApplicationMenuHandler.HelpCallback
{
  private static boolean sCreatedAccount = false;
  private List<String> mAccounts;
  private boolean mRestartAccountQuery = false;
  private boolean mSynced = false;
  
  private void addAccountHeaders(List<PreferenceActivity.Header> paramList)
  {
    mAccounts = Persistence.getInstance().getCachedConfiguredGoogleAccounts(this, false);
    if (!mSynced)
    {
      asyncInitAccounts();
      mSynced = true;
    }
    for (;;)
    {
      return;
      Iterator localIterator = mAccounts.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        PreferenceActivity.Header localHeader = new PreferenceActivity.Header();
        title = str;
        fragment = "com.google.android.gm.preference.AccountPreferenceFragment";
        Bundle localBundle = new Bundle();
        localBundle.putString("account", str);
        fragmentArguments = localBundle;
        paramList.add(1, localHeader);
      }
    }
  }
  
  private void asyncInitAccounts()
  {
    AccountHelper.getSyncingAccounts(this, new AccountManagerCallback()
    {
      public void run(AccountManagerFuture<android.accounts.Account[]> paramAnonymousAccountManagerFuture)
      {
        try
        {
          GmailPreferenceActivity localGmailPreferenceActivity = GmailPreferenceActivity.this;
          GmailPreferenceActivity.access$002(GmailPreferenceActivity.this, AccountHelper.mergeAccountLists(mAccounts, (android.accounts.Account[])paramAnonymousAccountManagerFuture.getResult(), true));
          Persistence.getInstance().cacheConfiguredGoogleAccounts(localGmailPreferenceActivity, false, mAccounts);
          invalidateHeaders();
          return;
        }
        catch (OperationCanceledException paramAnonymousAccountManagerFuture) {}catch (IOException paramAnonymousAccountManagerFuture) {}catch (AuthenticatorException paramAnonymousAccountManagerFuture) {}
      }
    });
  }
  
  private final PreferenceActivity.Header getInitialHeader(long paramLong, List<PreferenceActivity.Header> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PreferenceActivity.Header localHeader = (PreferenceActivity.Header)paramList.next();
      if ((id == paramLong) && (fragment != null)) {
        return localHeader;
      }
    }
    return null;
  }
  
  private void launchLabelSettings(Intent paramIntent)
  {
    Object localObject = (Folder)paramIntent.getParcelableExtra("extra_folder");
    paramIntent = getParcelableExtra"extra_account"name;
    localObject = uri.getLastPathSegment();
    Intent localIntent = new Intent(this, LabelsActivity.class);
    localIntent.putExtra("account_key", paramIntent);
    localIntent.putExtra("label", (String)localObject);
    startActivity(localIntent);
    finish();
  }
  
  private void launchManageLabels(Intent paramIntent)
  {
    paramIntent = getParcelableExtra"extra_account"name;
    Intent localIntent = new Intent(this, LabelsActivity.class);
    localIntent.putExtra("account_key", paramIntent);
    startActivity(localIntent);
    finish();
  }
  
  private void loadHeaders(List<PreferenceActivity.Header> paramList)
  {
    loadHeadersFromResource(2131165189, paramList);
    addAccountHeaders(paramList);
  }
  
  private void loadInitialHeader(long paramLong)
  {
    Object localObject = Lists.newArrayList();
    loadHeaders((List)localObject);
    localObject = getInitialHeader(paramLong, (List)localObject);
    if (localObject != null)
    {
      if (!isMultiPane())
      {
        startActivity(onBuildStartFragmentIntent(fragment, new Bundle(), titleRes, 0));
        finish();
      }
    }
    else {
      return;
    }
    switchToHeader((PreferenceActivity.Header)localObject);
  }
  
  public String getHelpContext()
  {
    return "gm_settings";
  }
  
  public void onBuildHeaders(List<PreferenceActivity.Header> paramList)
  {
    loadHeaders(paramList);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    long l2 = -1L;
    long l1;
    if (paramBundle.hasExtra("initial_fragment_id"))
    {
      l1 = paramBundle.getLongExtra("initial_fragment_id", -1L);
      paramBundle.removeExtra("initial_fragment_id");
    }
    for (;;)
    {
      if (l1 != -1L)
      {
        int j = 1;
        int i = j;
        if (l1 == 2131755291L)
        {
          i = j;
          if (paramBundle.getBooleanExtra("reporting_problem", false))
          {
            Utils.launchGoogleFeedback(this);
            i = 0;
            finish();
          }
        }
        if (i != 0) {
          loadInitialHeader(l1);
        }
      }
      paramBundle = getActionBar();
      if (paramBundle != null) {
        paramBundle.setDisplayOptions(4, 4);
      }
      PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
      return;
      if (paramBundle.hasExtra("extra_folder"))
      {
        launchLabelSettings(paramBundle);
        return;
      }
      if (paramBundle.hasExtra("extra_manage_folders"))
      {
        launchManageLabels(paramBundle);
        l1 = l2;
      }
      else
      {
        Object localObject = paramBundle.getData();
        l1 = l2;
        if (localObject != null)
        {
          localObject = ((Uri)localObject).getQueryParameter("preference_fragment_id");
          l1 = l2;
          if (localObject != null) {
            l1 = Long.parseLong((String)localObject);
          }
        }
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131886093, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return ApplicationMenuHandler.handleApplicationMenu(paramMenuItem, this, this);
    case 2131755327: 
      AccountHelper.showAddAccount(this, this);
      return true;
    }
    finish();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    mRestartAccountQuery = true;
  }
  
  public void onResult(android.accounts.Account paramAccount)
  {
    if (paramAccount != null) {
      sCreatedAccount = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((sCreatedAccount) || (mRestartAccountQuery)) {}
    for (int i = 1;; i = 0)
    {
      sCreatedAccount = false;
      if (i != 0) {
        asyncInitAccounts();
      }
      return;
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    UiProvider.notifyAccountListChanged(this);
  }
  
  public void onStop()
  {
    super.onStop();
    PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.GmailPreferenceActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */