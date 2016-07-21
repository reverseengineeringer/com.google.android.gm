package com.google.android.gms.people.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import eny;
import enz;
import fyd;

public final class AvatarReference
  implements SafeParcelable
{
  public static final fyd CREATOR = new fyd();
  final int a;
  final int b;
  final String c;
  
  public AvatarReference(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool);
      a = paramInt1;
      b = paramInt2;
      c = paramString;
      return;
    }
  }
  
  public AvatarReference(int paramInt, String paramString)
  {
    this(1, paramInt, paramString);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return enx.a(this).a("source", Integer.valueOf(b)).a("location", c).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.model.AvatarReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */