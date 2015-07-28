package com.google.android.gm;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.google.android.gm.persistence.Persistence;

public class TwoPaneLabelsController
  extends BaseLabelsController
{
  public TwoPaneLabelsController(LabelsActivityController.ControllableLabelsActivity paramControllableLabelsActivity)
  {
    super(paramControllableLabelsActivity);
  }
  
  public void handleLabelListResumed(LabelListFragment paramLabelListFragment)
  {
    toggleUpButton(true);
  }
  
  public void initialize(Bundle paramBundle)
  {
    super.initialize(paramBundle);
    mActivity.setContentView(2130968688);
    if (paramBundle == null)
    {
      if (mDefaultLabel == null) {
        mDefaultLabel = Persistence.getAccountInbox(mContext, mAccount);
      }
      showManageLabelList();
      showLabelSettings(mDefaultLabel);
    }
  }
  
  protected void showLabelSettings(String paramString)
  {
    FragmentTransaction localFragmentTransaction = mActivity.getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4099);
    localFragmentTransaction.replace(2131755262, LabelSettingsFragment.newInstance(mAccount, paramString));
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  protected void showManageLabelList()
  {
    FragmentTransaction localFragmentTransaction = mActivity.getFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131755208, LabelListFragment.newInstance(mAccount, mDefaultLabel, 1));
    localFragmentTransaction.commitAllowingStateLoss();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.TwoPaneLabelsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */