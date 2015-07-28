package com.google.android.gm;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class LabelsActivity
  extends GmailBaseActivity
  implements LabelListFragment.LabelListCallbacks, LabelSettingsObservable, LabelsActivityController.ControllableLabelsActivity
{
  private LabelsActivityController mController;
  
  public String getHelpContext()
  {
    return "gm_lsa";
  }
  
  public ArrayList<String> getIncludedLabels()
  {
    return mController.getIncludedLabels();
  }
  
  public int getNumberOfSyncDays()
  {
    return mController.getNumberOfSyncDays();
  }
  
  public ArrayList<String> getPartialLabels()
  {
    return mController.getPartialLabels();
  }
  
  public void notifyChanged()
  {
    mController.notifyChanged();
  }
  
  public void onBackPressed()
  {
    if (!mController.handleBackPressed()) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mController = ControllerFactory.forActivity(this);
    mController.initialize(paramBundle);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return (mController.handleCreateOptionsMenu(paramMenu)) || (super.onCreateOptionsMenu(paramMenu));
  }
  
  public void onLabelListResumed(LabelListFragment paramLabelListFragment)
  {
    mController.handleLabelListResumed(paramLabelListFragment);
  }
  
  public void onLabelSelected(String paramString)
  {
    mController.handleLabelSelected(paramString);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return (mController.handleOptionsItemSelected(paramMenuItem)) || (super.onOptionsItemSelected(paramMenuItem));
  }
  
  public void onPause()
  {
    super.onPause();
    mController.handlePause();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return (mController.handlePrepareOptionsMenu(paramMenu)) || (super.onPrepareOptionsMenu(paramMenu));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    mController.handleSaveInstanceState(paramBundle);
  }
  
  public void registerObserver(LabelSettingsObserver paramLabelSettingsObserver)
  {
    mController.registerObserver(paramLabelSettingsObserver);
  }
  
  public void setIncludedLabels(ArrayList<String> paramArrayList)
  {
    mController.setIncludedLabels(paramArrayList);
  }
  
  public void setPartialLabels(ArrayList<String> paramArrayList)
  {
    mController.setPartialLabels(paramArrayList);
  }
  
  public void unregisterObserver(LabelSettingsObserver paramLabelSettingsObserver)
  {
    mController.unregisterObserver(paramLabelSettingsObserver);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */