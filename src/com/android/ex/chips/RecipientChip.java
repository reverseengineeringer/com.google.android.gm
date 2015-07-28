package com.android.ex.chips;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;

class RecipientChip
  extends ImageSpan
{
  private final long mContactId;
  private final long mDataId;
  private final CharSequence mDisplay;
  private RecipientEntry mEntry;
  private CharSequence mOriginalText;
  private boolean mSelected = false;
  private final CharSequence mValue;
  
  public RecipientChip(Drawable paramDrawable, RecipientEntry paramRecipientEntry, int paramInt)
  {
    super(paramDrawable, 0);
    mDisplay = paramRecipientEntry.getDisplayName();
    mValue = paramRecipientEntry.getDestination().trim();
    mContactId = paramRecipientEntry.getContactId();
    mDataId = paramRecipientEntry.getDataId();
    mEntry = paramRecipientEntry;
  }
  
  public long getContactId()
  {
    return mContactId;
  }
  
  public long getDataId()
  {
    return mDataId;
  }
  
  public RecipientEntry getEntry()
  {
    return mEntry;
  }
  
  public CharSequence getOriginalText()
  {
    if (!TextUtils.isEmpty(mOriginalText)) {
      return mOriginalText;
    }
    return mEntry.getDestination();
  }
  
  public CharSequence getValue()
  {
    return mValue;
  }
  
  public boolean isSelected()
  {
    return mSelected;
  }
  
  public void setOriginalText(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.trim();
    }
    mOriginalText = str;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    mSelected = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientChip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */