package com.google.android.gm.welcome;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import cvl;
import dri;
import eaq;
import ear;
import hbf;
import hef;
import hft;
import hii;
import java.util.Arrays;
import java.util.List;

public class WelcomeTourState
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<WelcomeTourState> CREATOR = new eaq();
  private static final String c = cvl.a;
  final boolean a;
  final List<WelcomeTourState.AccountState> b;
  private final hbf<WelcomeTourState.AccountState> d = new ear(this);
  
  public WelcomeTourState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      a = bool;
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      if (paramParcel != null) {
        break;
      }
      b = hii.a;
      return;
      bool = false;
    }
    if ((paramParcel instanceof WelcomeTourState.AccountState[]))
    {
      b = hef.a((WelcomeTourState.AccountState[])paramParcel);
      return;
    }
    b = hef.a((WelcomeTourState.AccountState[])Arrays.copyOf(paramParcel, paramParcel.length, WelcomeTourState.AccountState[].class));
  }
  
  public WelcomeTourState(boolean paramBoolean, WelcomeTourState.AccountState[] paramArrayOfAccountState)
  {
    String str2 = c;
    if (paramBoolean) {}
    for (String str1 = "new";; str1 = "upgrading")
    {
      dri.b(str2, "Welcome Tour mode will be shown for %s user", new Object[] { str1 });
      a = paramBoolean;
      b = hef.a(paramArrayOfAccountState);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof WelcomeTourState)) {}
    do
    {
      return false;
      paramObject = (WelcomeTourState)paramObject;
    } while ((!b.equals(b)) || (a != a));
    return true;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { b, Boolean.valueOf(a) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (a) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelableArray((WelcomeTourState.AccountState[])hft.a(b, WelcomeTourState.AccountState.class), 0);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.welcome.WelcomeTourState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */