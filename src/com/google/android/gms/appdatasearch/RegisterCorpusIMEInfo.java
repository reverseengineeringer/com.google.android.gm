package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecc;
import emj;

public class RegisterCorpusIMEInfo
  implements SafeParcelable
{
  public static final ecc CREATOR = new ecc();
  final int a;
  public final int b;
  public final String[] c;
  public final String d;
  public final String e;
  public final String[] f;
  public final String g;
  
  public RegisterCorpusIMEInfo(int paramInt1, int paramInt2, String[] paramArrayOfString1, String paramString1, String paramString2, String[] paramArrayOfString2, String paramString3)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramArrayOfString1;
    d = paramString1;
    e = paramString2;
    f = paramArrayOfString2;
    g = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.a(paramParcel, 3, d, false);
    emj.a(paramParcel, 4, e, false);
    emj.a(paramParcel, 6, g, false);
    emj.a(paramParcel, 7, f);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.RegisterCorpusIMEInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */