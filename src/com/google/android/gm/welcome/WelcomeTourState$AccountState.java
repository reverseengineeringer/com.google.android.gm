package com.google.android.gm.welcome;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dep;
import eas;
import hbc;
import java.util.Arrays;

public class WelcomeTourState$AccountState
  implements Parcelable, dep
{
  public static final Parcelable.Creator<AccountState> CREATOR = new eas();
  String a;
  public final Account b;
  final String c;
  public final int d;
  final int e;
  
  public WelcomeTourState$AccountState(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = ((Account)paramParcel.readParcelable(Account.class.getClassLoader()));
    c = paramParcel.readString();
    d = paramParcel.readInt();
    e = paramParcel.readInt();
  }
  
  public WelcomeTourState$AccountState(String paramString1, Account paramAccount, String paramString2, int paramInt1, int paramInt2)
  {
    a = paramString1;
    b = paramAccount;
    c = paramString2;
    d = paramInt1;
    e = paramInt2;
  }
  
  public final AccountState a(int paramInt)
  {
    return new AccountState(a, b, c, paramInt, e);
  }
  
  public final String a()
  {
    return b.name;
  }
  
  public final String b()
  {
    return c;
  }
  
  public final String c()
  {
    return b.type;
  }
  
  public final boolean d()
  {
    return d == 2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AccountState)) {}
    do
    {
      return false;
      paramObject = (AccountState)paramObject;
    } while ((!hbc.a(a, a)) || (!hbc.a(b, b)) || (!hbc.a(c, c)) || (d != d) || (e != e));
    return true;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { a, b, c, Integer.valueOf(d), Integer.valueOf(d), Integer.valueOf(e) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeParcelable(b, 0);
    paramParcel.writeString(c);
    paramParcel.writeInt(d);
    paramParcel.writeInt(e);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.welcome.WelcomeTourState.AccountState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */