package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebf;
import emj;
import enx;
import java.util.Arrays;

public class CorpusId
  implements SafeParcelable
{
  public static final ebf CREATOR = new ebf();
  final int a;
  public final String b;
  public final String c;
  final Bundle d;
  
  public CorpusId(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof CorpusId))
    {
      paramObject = (CorpusId)paramObject;
      bool1 = bool2;
      if (enx.a(b, b))
      {
        bool1 = bool2;
        if (enx.a(c, c))
        {
          bool1 = bool2;
          if (enx.a(d, d)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { b, c, d });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CorpusId[package=").append(b).append(", corpus=").append(c).append("userHandle=");
    if (d != null) {}
    for (String str = d.toString();; str = "null") {
      return str + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.a(paramParcel, 3, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.CorpusId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */