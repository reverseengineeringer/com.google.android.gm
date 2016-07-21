package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecp;
import ecq;
import ecr;
import emj;
import java.util.Iterator;

public class SuggestionResults
  implements SafeParcelable, Iterable<ecp>
{
  public static final ecr CREATOR = new ecr();
  final int a;
  public final String b;
  public final String[] c;
  public final String[] d;
  
  public SuggestionResults(int paramInt, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    a = paramInt;
    b = paramString;
    c = paramArrayOfString1;
    d = paramArrayOfString2;
  }
  
  public final boolean a()
  {
    return b != null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Iterator<ecp> iterator()
  {
    if (a()) {
      return null;
    }
    return new ecq(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.a(paramParcel, 3, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.SuggestionResults
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */