package com.google.android.gms.common.people.data;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import eod;
import java.util.Arrays;

public final class AudienceMember
  implements SafeParcelable
{
  public static final eod CREATOR = new eod();
  final int a;
  final int b;
  final int c;
  final String d;
  final String e;
  final String f;
  final String g;
  @Deprecated
  final Bundle h;
  
  public AudienceMember(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
    d = paramString1;
    e = paramString2;
    f = paramString3;
    g = paramString4;
    if (paramBundle != null) {}
    for (;;)
    {
      h = paramBundle;
      return;
      paramBundle = new Bundle();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudienceMember)) {}
    do
    {
      return false;
      paramObject = (AudienceMember)paramObject;
    } while ((a != a) || (b != b) || (c != c) || (!enx.a(d, d)) || (!enx.a(e, e)));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(c), d, e });
  }
  
  public final String toString()
  {
    if (b == 2) {}
    for (int i = 1; i != 0; i = 0) {
      return String.format("Person [%s] %s", new Object[] { e, f });
    }
    if ((b == 1) && (c == -1)) {}
    for (i = 1; i != 0; i = 0) {
      return String.format("Circle [%s] %s", new Object[] { d, f });
    }
    return String.format("Group [%s] %s", new Object[] { d, f });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, 2, c);
    emj.a(paramParcel, 3, d, false);
    emj.a(paramParcel, 4, e, false);
    emj.a(paramParcel, 5, f, false);
    emj.a(paramParcel, 6, g, false);
    emj.a(paramParcel, 7, h);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.people.data.AudienceMember
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */