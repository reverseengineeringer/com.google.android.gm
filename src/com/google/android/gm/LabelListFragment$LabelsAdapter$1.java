package com.google.android.gm;

import android.database.DataSetObserver;

class LabelListFragment$LabelsAdapter$1
  extends DataSetObserver
{
  LabelListFragment$LabelsAdapter$1(LabelListFragment.LabelsAdapter paramLabelsAdapter) {}
  
  public void onChanged()
  {
    if (LabelListFragment.LabelsAdapter.access$200(this$1) != null)
    {
      LabelListFragment.LabelsAdapter.access$300(this$1);
      this$1.notifyDataSetChanged();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelListFragment.LabelsAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */