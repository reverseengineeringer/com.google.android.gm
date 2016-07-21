package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eci;
import ecj;
import ecl;
import emj;

public class SearchResults
  implements SafeParcelable, Iterable<eci>
{
  public static final ecl CREATOR = new ecl();
  final int a;
  public final String b;
  final int[] c;
  final byte[] d;
  public final Bundle[] e;
  public final Bundle[] f;
  public final Bundle[] g;
  public final int h;
  public final int[] i;
  public final String[] j;
  final byte[] k;
  final double[] l;
  final Bundle m;
  final int n;
  
  public SearchResults(int paramInt1, String paramString, int[] paramArrayOfInt1, byte[] paramArrayOfByte1, Bundle[] paramArrayOfBundle1, Bundle[] paramArrayOfBundle2, Bundle[] paramArrayOfBundle3, int paramInt2, int[] paramArrayOfInt2, String[] paramArrayOfString, byte[] paramArrayOfByte2, double[] paramArrayOfDouble, Bundle paramBundle, int paramInt3)
  {
    a = paramInt1;
    b = paramString;
    c = paramArrayOfInt1;
    d = paramArrayOfByte1;
    e = paramArrayOfBundle1;
    f = paramArrayOfBundle2;
    g = paramArrayOfBundle3;
    h = paramInt2;
    i = paramArrayOfInt2;
    j = paramArrayOfString;
    k = paramArrayOfByte2;
    l = paramArrayOfDouble;
    m = paramBundle;
    n = paramInt3;
  }
  
  public final boolean a()
  {
    return b != null;
  }
  
  public final ecj b()
  {
    return new ecj(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.a(paramParcel, 3, d, false);
    emj.a(paramParcel, 4, e, paramInt);
    emj.a(paramParcel, 5, f, paramInt);
    emj.a(paramParcel, 6, g, paramInt);
    emj.b(paramParcel, 7, h);
    emj.a(paramParcel, 8, i);
    emj.a(paramParcel, 9, j);
    emj.a(paramParcel, 10, k, false);
    double[] arrayOfDouble = l;
    if (arrayOfDouble != null)
    {
      paramInt = emj.a(paramParcel, 11);
      paramParcel.writeDoubleArray(arrayOfDouble);
      emj.b(paramParcel, paramInt);
    }
    emj.a(paramParcel, 12, m);
    emj.b(paramParcel, 13, n);
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.SearchResults
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */