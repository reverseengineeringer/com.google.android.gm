package com.android.ex.editstyledtext;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View.BaseSavedState;

public class EditStyledText$SavedStyledTextState
  extends View.BaseSavedState
{
  public int a;
  
  EditStyledText$SavedStyledTextState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    String str = String.valueOf(Integer.toHexString(System.identityHashCode(this)));
    int i = a;
    return String.valueOf(str).length() + 47 + "EditStyledText.SavedState{" + str + " bgcolor=" + i + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(a);
  }
}

/* Location:
 * Qualified Name:     com.android.ex.editstyledtext.EditStyledText.SavedStyledTextState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */