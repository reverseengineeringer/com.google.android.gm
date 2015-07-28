package com.google.android.gm;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LabelManager;

public class OnePaneLabelsController
  extends BaseLabelsController
{
  private boolean mFromShortcut;
  
  public OnePaneLabelsController(LabelsActivityController.ControllableLabelsActivity paramControllableLabelsActivity)
  {
    super(paramControllableLabelsActivity);
  }
  
  public void handleLabelListResumed(LabelListFragment paramLabelListFragment)
  {
    if (paramLabelListFragment.isManageLabelMode())
    {
      mActionBar.setTitle(2131492944);
      mActionBar.setSubtitle(2131493201);
    }
    for (;;)
    {
      toggleUpButton(true);
      return;
      mActionBar.setTitle(2131493200);
      mActionBar.setSubtitle(mAccount);
    }
  }
  
  public void initialize(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.initialize(paramBundle);
    mActivity.setContentView(2130968669);
    if (mDefaultLabel != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      mFromShortcut = bool1;
      if (paramBundle != null) {
        break label62;
      }
      if (!mFromShortcut) {
        break;
      }
      showLabelSettings(mDefaultLabel);
      return;
    }
    showManageLabelList();
    return;
    label62:
    mLabelListVisbile = paramBundle.getBoolean("label-list-visible", true);
    if (!mLabelListVisbile) {}
    for (bool1 = bool2;; bool1 = false)
    {
      toggleUpButton(bool1);
      return;
    }
  }
  
  protected void showLabelSettings(String paramString)
  {
    Label localLabel = LabelManager.getLabel(mContext, mAccount, paramString);
    if (localLabel == null)
    {
      mActivity.onBackPressed();
      return;
    }
    FragmentTransaction localFragmentTransaction = mActivity.getFragmentManager().beginTransaction();
    if (!mFromShortcut)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.setTransition(4097);
    }
    localFragmentTransaction.replace(2131755198, LabelSettingsFragment.newInstance(mAccount, paramString));
    localFragmentTransaction.commitAllowingStateLoss();
    mActionBar.setTitle(localLabel.getName());
    mActionBar.setSubtitle(2131493201);
    mLabelListVisbile = false;
    toggleUpButton(true);
    mActivity.invalidateOptionsMenu();
  }
  
  protected void showManageLabelList()
  {
    FragmentTransaction localFragmentTransaction = mActivity.getFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131755198, LabelListFragment.newInstance(mAccount, null, 1, 1));
    localFragmentTransaction.commitAllowingStateLoss();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.OnePaneLabelsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */