package com.google.android.gm;

import com.google.android.gm.provider.Label;

class LabelListFragment$LabelListItem
{
  final String mHeaderText;
  final Label mLabel;
  
  public LabelListFragment$LabelListItem(Label paramLabel)
  {
    mLabel = paramLabel;
    mHeaderText = null;
  }
  
  public LabelListFragment$LabelListItem(String paramString)
  {
    mHeaderText = paramString;
    mLabel = null;
  }
  
  public int getItemType()
  {
    if (mHeaderText != null) {
      return 0;
    }
    return 1;
  }
  
  public boolean isHeader()
  {
    return getItemType() == 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelListFragment.LabelListItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */