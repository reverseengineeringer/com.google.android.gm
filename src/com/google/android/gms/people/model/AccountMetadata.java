package com.google.android.gms.people.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fxx;

public class AccountMetadata
  implements SafeParcelable
{
  public static final fxx CREATOR = new fxx();
  final int a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public AccountMetadata()
  {
    a = 2;
  }
  
  public AccountMetadata(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    a = paramInt;
    b = paramBoolean1;
    c = paramBoolean2;
    d = paramBoolean3;
    e = paramBoolean4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.model.AccountMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */