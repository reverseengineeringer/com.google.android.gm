package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edm;
import emj;
import enx;
import enz;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential
  implements SafeParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR = new edm();
  final int a;
  final String b;
  final String c;
  final String d;
  final String e;
  final Uri f;
  final List<IdToken> g;
  final String h;
  final String i;
  final String j;
  final String k;
  
  public Credential(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, List<IdToken> paramList, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = ((String)enz.a(paramString3));
    e = paramString4;
    f = paramUri;
    if (paramList == null) {}
    for (paramString1 = Collections.emptyList();; paramString1 = Collections.unmodifiableList(paramList))
    {
      g = paramString1;
      h = paramString5;
      i = paramString6;
      j = paramString7;
      k = paramString8;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Credential)) {
        return false;
      }
      paramObject = (Credential)paramObject;
    } while ((TextUtils.equals(d, d)) && (TextUtils.equals(e, e)) && (enx.a(f, f)) && (TextUtils.equals(h, h)) && (TextUtils.equals(i, i)) && (TextUtils.equals(j, j)));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { d, e, f, h, i, j });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1001, b, false);
    emj.a(paramParcel, 1, d, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, e, false);
    emj.a(paramParcel, 3, f, paramInt, false);
    emj.a(paramParcel, 1002, c, false);
    emj.b(paramParcel, 4, g, false);
    emj.a(paramParcel, 5, h, false);
    emj.a(paramParcel, 6, i, false);
    emj.a(paramParcel, 7, j, false);
    emj.a(paramParcel, 8, k, false);
    emj.b(paramParcel, m);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */