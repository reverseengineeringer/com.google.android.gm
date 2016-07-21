package com.google.android.gms.common.download;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import els;
import emj;
import enz;
import java.util.Arrays;

public final class DownloadDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<DownloadDetails> CREATOR = new els();
  final int a;
  public final String b;
  public final String c;
  public final long d;
  public final String e;
  public final String f;
  public final int g;
  public final int h;
  
  public DownloadDetails(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= paramInt3)
    {
      bool1 = true;
      enz.b(bool1, "The minVersion (" + paramInt2 + ") must be less than or equal to the maxVersion (" + paramInt3 + ").");
      if (paramLong <= 0L) {
        break label162;
      }
    }
    label162:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      enz.b(bool1, "sizeBytes (" + paramLong + ") must be greater than zero");
      a = paramInt1;
      b = ((String)enz.a(paramString1));
      c = ((String)enz.a(paramString2));
      d = paramLong;
      e = ((String)enz.a(paramString3));
      f = paramString4;
      g = paramInt2;
      h = paramInt3;
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DownloadDetails))
    {
      paramObject = (DownloadDetails)paramObject;
      if ((b.equals(b)) && (c.equals(c)) && (d == d) && (e.equals(e)) && (((f == null) && (f == null)) || ((f.equals(f)) && (g == g) && (h == h)))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { b, c, Long.valueOf(d), e, f, Integer.valueOf(g), Integer.valueOf(h) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.b(paramParcel, 7, g);
    emj.b(paramParcel, 8, h);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.download.DownloadDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */