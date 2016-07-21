package com.google.android.apps.work.common.richedittext;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import ddc;

public class RichTextToolbar$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new ddc();
  boolean a;
  
  public RichTextToolbar$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  RichTextToolbar$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return String.format("RichTextToolbar.SavedState{%s isExpanded=%B}", new Object[] { Integer.toHexString(System.identityHashCode(this)), Boolean.valueOf(a) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (a) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.work.common.richedittext.RichTextToolbar.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */