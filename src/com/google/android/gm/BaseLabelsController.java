package com.google.android.gm;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.google.android.gm.comm.longshadow.LongShadowUtils;
import com.google.android.gm.preference.PreferenceUtils;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Gmail.Settings;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseLabelsController
  implements LabelsActivityController
{
  protected String mAccount;
  protected final ActionBar mActionBar;
  protected final LabelsActivityController.ControllableLabelsActivity mActivity;
  protected final Context mContext;
  protected String mDefaultLabel;
  Gmail mGmail;
  private boolean mHomeIsBack = false;
  private List<String> mIncludedLabels;
  protected boolean mLabelListVisbile = true;
  private int mNumOfSyncDays;
  private final List<LabelSettingsObserver> mObservers;
  private List<String> mPartialLabels;
  Gmail.Settings mSettings;
  
  public BaseLabelsController(LabelsActivityController.ControllableLabelsActivity paramControllableLabelsActivity)
  {
    mActivity = paramControllableLabelsActivity;
    mObservers = Lists.newArrayList();
    mContext = mActivity.getContext();
    mActionBar = mActivity.getActionBar();
  }
  
  public ArrayList<String> getIncludedLabels()
  {
    return Lists.newArrayList(mIncludedLabels);
  }
  
  public int getNumberOfSyncDays()
  {
    return mNumOfSyncDays;
  }
  
  public ArrayList<String> getPartialLabels()
  {
    return Lists.newArrayList(mPartialLabels);
  }
  
  public boolean handleBackPressed()
  {
    mActionBar.setSubtitle(mAccount);
    mLabelListVisbile = true;
    toggleUpButton(false);
    mActivity.invalidateOptionsMenu();
    return false;
  }
  
  public boolean handleCreateOptionsMenu(Menu paramMenu)
  {
    mActivity.getMenuInflater().inflate(2131886088, paramMenu);
    return true;
  }
  
  public void handleLabelSelected(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("label", paramString);
    mActivity.setResult(-1, localIntent);
    showLabelSettings(paramString);
  }
  
  public boolean handleOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      return ApplicationMenuHandler.handleApplicationMenu(paramMenuItem, mContext, (ApplicationMenuHandler.HelpCallback)mActivity);
    } while (!mHomeIsBack);
    mActivity.onBackPressed();
    return true;
  }
  
  public void handlePause()
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        mSettings.setLabelsIncluded(mIncludedLabels);
        mSettings.setLabelsPartial(mPartialLabels);
        mGmail.setSettings(mAccount, mSettings);
        PreferenceUtils.validateNotificationsForAccount(mContext, mAccount);
        return null;
      }
    }.execute(new Void[0]);
  }
  
  public boolean handlePrepareOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public void handleSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("label-list-visible", mLabelListVisbile);
  }
  
  public void initialize(Bundle paramBundle)
  {
    paramBundle = mActivity.getIntent();
    mAccount = paramBundle.getStringExtra("account_key");
    mDefaultLabel = paramBundle.getStringExtra("label");
    mAccount = new AccountHelper(mActivity).validateAccountName(mAccount);
    if (mAccount == null)
    {
      mActivity.finish();
      return;
    }
    mGmail = LongShadowUtils.getContentProviderMailAccess(mActivity.getContentResolver());
    mSettings = mGmail.getSettings(mContext, mAccount);
    mIncludedLabels = mSettings.getLabelsIncluded();
    mPartialLabels = mSettings.getLabelsPartial();
    mNumOfSyncDays = ((int)mSettings.getConversationAgeDays());
    mActionBar.setSubtitle(mAccount);
    toggleUpButton(false);
  }
  
  public void notifyChanged()
  {
    Iterator localIterator = Lists.newArrayList(mObservers).iterator();
    while (localIterator.hasNext()) {
      ((LabelSettingsObserver)localIterator.next()).onChanged();
    }
  }
  
  public void registerObserver(LabelSettingsObserver paramLabelSettingsObserver)
  {
    mObservers.add(paramLabelSettingsObserver);
  }
  
  public void setIncludedLabels(ArrayList<String> paramArrayList)
  {
    mIncludedLabels = paramArrayList;
  }
  
  public void setPartialLabels(ArrayList<String> paramArrayList)
  {
    mPartialLabels = paramArrayList;
  }
  
  protected abstract void showLabelSettings(String paramString);
  
  protected void toggleUpButton(boolean paramBoolean)
  {
    mHomeIsBack = paramBoolean;
    mActivity.getActionBar().setDisplayHomeAsUpEnabled(paramBoolean);
    if (Gmail.isRunningICSOrLater()) {
      mActivity.getActionBar().setHomeButtonEnabled(paramBoolean);
    }
  }
  
  public void unregisterObserver(LabelSettingsObserver paramLabelSettingsObserver)
  {
    mObservers.remove(paramLabelSettingsObserver);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.BaseLabelsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */