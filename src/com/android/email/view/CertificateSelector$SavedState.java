package com.android.email.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import bbr;

public class CertificateSelector$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new bbr();
  final String a;
  
  public CertificateSelector$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    a = paramParcel.readString();
  }
  
  CertificateSelector$SavedState(Parcelable paramParcelable, String paramString)
  {
    super(paramParcelable);
    a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(a);
  }
}

/* Location:
 * Qualified Name:     com.android.email.view.CertificateSelector.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */