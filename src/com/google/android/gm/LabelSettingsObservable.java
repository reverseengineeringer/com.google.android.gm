package com.google.android.gm;

import java.util.ArrayList;

public abstract interface LabelSettingsObservable
{
  public abstract ArrayList<String> getIncludedLabels();
  
  public abstract int getNumberOfSyncDays();
  
  public abstract ArrayList<String> getPartialLabels();
  
  public abstract void notifyChanged();
  
  public abstract void registerObserver(LabelSettingsObserver paramLabelSettingsObserver);
  
  public abstract void setIncludedLabels(ArrayList<String> paramArrayList);
  
  public abstract void setPartialLabels(ArrayList<String> paramArrayList);
  
  public abstract void unregisterObserver(LabelSettingsObserver paramLabelSettingsObserver);
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelSettingsObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */