package com.google.android.apps.work.common.richedittext;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import dcn;

public class RichEditText$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new dcn();
  boolean a;
  int b;
  RichTextState c;
  
  public RichEditText$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = paramParcel.readInt();
      c = ((RichTextState)paramParcel.readParcelable(RichTextState.class.getClassLoader()));
      return;
    }
  }
  
  RichEditText$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return String.format("RichEditText.SavedState{%s richTextEnabled=%b pendingPosition=%d pendingChanges=%s}", new Object[] { Integer.toHexString(System.identityHashCode(this)), Boolean.valueOf(a), Integer.valueOf(b), c });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (a) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(b);
      paramParcel.writeParcelable(c, paramInt);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.work.common.richedittext.RichEditText.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */