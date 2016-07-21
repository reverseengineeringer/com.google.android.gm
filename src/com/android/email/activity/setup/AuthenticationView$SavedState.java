package com.android.email.activity.setup;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import auu;

public class AuthenticationView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new auu();
  public boolean a;
  public boolean b;
  public String c;
  public String d;
  
  public AuthenticationView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      a = bool1;
      if (paramParcel.readInt() != 1) {
        break label59;
      }
    }
    label59:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      b = bool1;
      c = paramParcel.readString();
      d = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public AuthenticationView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    if (a)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!b) {
        break label58;
      }
    }
    label58:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(c);
      paramParcel.writeString(d);
      return;
      paramInt = 0;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.AuthenticationView.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */