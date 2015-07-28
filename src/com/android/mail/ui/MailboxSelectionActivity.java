package com.android.mail.ui;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.android.mail.providers.MailAppProvider;
import com.android.mail.providers.UIProvider;
import com.android.mail.utils.LogTag;
import java.util.ArrayList;

public class MailboxSelectionActivity
  extends ListActivity
  implements View.OnClickListener, LoaderManager.LoaderCallbacks<Cursor>
{
  private static final String[] COLUMN_NAMES = { "name" };
  protected static final String LOG_TAG = LogTag.getLogTag();
  private final int[] VIEW_IDS = { 2131755211 };
  private SimpleCursorAdapter mAdapter;
  private int mAppWidgetId = 0;
  private boolean mConfigureWidget = false;
  private View mContent;
  private boolean mCreateShortcut = false;
  private Handler mHandler = new Handler();
  private boolean mResumed = false;
  private View mWait;
  boolean mWaitingForAddAccountResult = false;
  
  private void completeSetupWithAccounts(final Cursor paramCursor)
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        MailboxSelectionActivity.this.updateAccountList(paramCursor);
      }
    });
  }
  
  private WaitFragment getWaitFragment()
  {
    return (WaitFragment)getFragmentManager().findFragmentByTag("wait-fragment");
  }
  
  private int replaceFragment(Fragment paramFragment, int paramInt, String paramString)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.addToBackStack(null);
    localFragmentTransaction.setTransition(paramInt);
    localFragmentTransaction.replace(2131755076, paramFragment, paramString);
    return localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void restoreState(Bundle paramBundle)
  {
    if (paramBundle.containsKey("createShortcut")) {
      mCreateShortcut = paramBundle.getBoolean("createShortcut");
    }
    if (paramBundle.containsKey("createWidget")) {
      mConfigureWidget = paramBundle.getBoolean("createWidget");
    }
    if (paramBundle.containsKey("widgetId")) {
      mAppWidgetId = paramBundle.getInt("widgetId");
    }
    if (paramBundle.containsKey("waitingForAddAccountResult")) {
      mWaitingForAddAccountResult = paramBundle.getBoolean("waitingForAddAccountResult");
    }
  }
  
  private void selectAccount(com.android.mail.providers.Account paramAccount)
  {
    if ((mCreateShortcut) || (mConfigureWidget))
    {
      Intent localIntent = new Intent(this, getFolderSelectionActivity());
      localIntent.setFlags(1107296256);
      if (mCreateShortcut) {}
      for (String str = "android.intent.action.CREATE_SHORTCUT";; str = "android.appwidget.action.APPWIDGET_CONFIGURE")
      {
        localIntent.setAction(str);
        if (mConfigureWidget) {
          localIntent.putExtra("appWidgetId", mAppWidgetId);
        }
        localIntent.putExtra("account-shortcut", paramAccount);
        startActivity(localIntent);
        finish();
        return;
      }
    }
    finish();
  }
  
  private void setupWithAccounts()
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = null;
        try
        {
          Cursor localCursor = val$resolver.query(MailAppProvider.getAccountsUri(), UIProvider.ACCOUNTS_PROJECTION, null, null, null);
          paramAnonymousVarArgs = localCursor;
          MailboxSelectionActivity.this.completeSetupWithAccounts(localCursor);
          return null;
        }
        finally
        {
          if (paramAnonymousVarArgs != null) {
            paramAnonymousVarArgs.close();
          }
        }
      }
    }.execute(new Void[0]);
  }
  
  private void showWaitFragment(com.android.mail.providers.Account paramAccount)
  {
    WaitFragment localWaitFragment = getWaitFragment();
    if (localWaitFragment != null) {
      localWaitFragment.updateAccount(paramAccount);
    }
    for (;;)
    {
      mContent.setVisibility(8);
      return;
      mWait.setVisibility(0);
      replaceFragment(WaitFragment.newInstance(paramAccount, true), 4097, "wait-fragment");
    }
  }
  
  private void updateAccountList(Cursor paramCursor)
  {
    int j = 1;
    int i;
    if (!mConfigureWidget)
    {
      i = j;
      if (!mCreateShortcut) {}
    }
    else
    {
      if ((paramCursor != null) && (paramCursor.getCount() != 0)) {
        break label113;
      }
      Intent localIntent = MailAppProvider.getNoAccountIntent(this);
      if (localIntent != null) {
        startActivityForResult(localIntent, 2);
      }
      i = 0;
      mWaitingForAddAccountResult = true;
    }
    for (;;)
    {
      if (i != 0)
      {
        mContent.setVisibility(0);
        if (mResumed) {
          setVisible(true);
        }
        mAdapter = new SimpleCursorAdapter(this, 2130968661, paramCursor, COLUMN_NAMES, VIEW_IDS, 0)
        {
          public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
          {
            paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
            ((TextView)paramAnonymousView.findViewById(2131755211)).setText(com.android.mail.providers.AccountgetItemname);
            return paramAnonymousView;
          }
        };
        setListAdapter(mAdapter);
      }
      return;
      label113:
      i = j;
      if (mConfigureWidget)
      {
        i = j;
        if (paramCursor.getCount() == 1)
        {
          mWait.setVisibility(8);
          paramCursor.moveToFirst();
          selectAccount(new com.android.mail.providers.Account(paramCursor));
          i = 0;
        }
      }
    }
  }
  
  protected Class<?> getFolderSelectionActivity()
  {
    return FolderSelectionActivity.class;
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2)
    {
      if (paramInt2 != -1) {
        finish();
      }
    }
    else {
      return;
    }
    getLoaderManager().initLoader(0, null, this);
    showWaitFragment(null);
  }
  
  public void onBackPressed()
  {
    mWaitingForAddAccountResult = false;
    if (getWaitFragment() != null)
    {
      finish();
      return;
    }
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    setResult(0);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968662);
    mContent = findViewById(2131755016);
    mWait = findViewById(2131755076);
    if (paramBundle != null) {
      restoreState(paramBundle);
    }
    for (;;)
    {
      if ((mCreateShortcut) || (mConfigureWidget))
      {
        setTitle(getResources().getString(2131493084));
        paramBundle = getActionBar();
        if (paramBundle != null) {
          paramBundle.setIcon(2130903041);
        }
      }
      ((Button)findViewById(2131755215)).setOnClickListener(this);
      setVisible(false);
      setResult(0);
      return;
      if ("android.intent.action.CREATE_SHORTCUT".equals(getIntent().getAction())) {
        mCreateShortcut = true;
      }
      mAppWidgetId = getIntent().getIntExtra("appWidgetId", 0);
      if (mAppWidgetId != 0) {
        mConfigureWidget = true;
      }
    }
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new CursorLoader(this, MailAppProvider.getAccountsUri(), UIProvider.ACCOUNTS_PROJECTION, null, null, null);
  }
  
  protected void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    selectAccount(new com.android.mail.providers.Account((Cursor)mAdapter.getItem(paramInt)));
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    if ((paramCursor != null) && (paramCursor.moveToFirst()))
    {
      paramLoader = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      do
      {
        com.android.mail.providers.Account localAccount = new com.android.mail.providers.Account(paramCursor);
        if (localAccount.isAccountReady()) {
          localArrayList.add(localAccount);
        }
        paramLoader.add(localAccount);
      } while (paramCursor.moveToNext());
      if (localArrayList.size() > 0)
      {
        mWait.setVisibility(8);
        getLoaderManager().destroyLoader(0);
        mContent.setVisibility(0);
        updateAccountList(paramCursor);
      }
    }
    else
    {
      return;
    }
    if (paramLoader.size() > 0) {}
    for (paramLoader = (com.android.mail.providers.Account)paramLoader.get(0);; paramLoader = null)
    {
      showWaitFragment(paramLoader);
      return;
    }
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    mResumed = false;
  }
  
  public void onResume()
  {
    super.onResume();
    mResumed = true;
    if (!mWaitingForAddAccountResult) {
      setupWithAccounts();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("createShortcut", mCreateShortcut);
    paramBundle.putBoolean("createWidget", mConfigureWidget);
    if (mAppWidgetId != 0) {
      paramBundle.putInt("widgetId", mAppWidgetId);
    }
    paramBundle.putBoolean("waitingForAddAccountResult", mWaitingForAddAccountResult);
  }
  
  public void onStart()
  {
    super.onStart();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailboxSelectionActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */