package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edh;
import edj;
import emj;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class PasswordSpecification
  implements SafeParcelable
{
  public static final edj CREATOR = new edj();
  public static final PasswordSpecification a = new edh().a().a("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").b("abcdefghijkmnopqrstxyz").b("ABCDEFGHJKLMNPQRSTXY").b("3456789").b();
  public static final PasswordSpecification b = new edh().a().a("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").b("abcdefghijklmnopqrstuvwxyz").b("ABCDEFGHIJKLMNOPQRSTUVWXYZ").b("1234567890").b();
  final int c;
  final String d;
  final List<String> e;
  final List<Integer> f;
  final int g;
  final int h;
  private final int[] i;
  private final Random j;
  
  public PasswordSpecification(int paramInt1, String paramString, List<String> paramList, List<Integer> paramList1, int paramInt2, int paramInt3)
  {
    c = paramInt1;
    d = paramString;
    e = Collections.unmodifiableList(paramList);
    f = Collections.unmodifiableList(paramList1);
    g = paramInt2;
    h = paramInt3;
    i = a();
    j = new SecureRandom();
  }
  
  private final int[] a()
  {
    int[] arrayOfInt = new int[95];
    Arrays.fill(arrayOfInt, -1);
    Iterator localIterator = e.iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
      int n = arrayOfChar.length;
      int m = 0;
      while (m < n)
      {
        arrayOfInt[(arrayOfChar[m] - ' ')] = k;
        m += 1;
      }
      k += 1;
    }
    return arrayOfInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, d, false);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 2, e, false);
    List localList = f;
    if (localList != null)
    {
      int m = emj.a(paramParcel, 3);
      int n = localList.size();
      paramParcel.writeInt(n);
      paramInt = 0;
      while (paramInt < n)
      {
        paramParcel.writeInt(((Integer)localList.get(paramInt)).intValue());
        paramInt += 1;
      }
      emj.b(paramParcel, m);
    }
    emj.b(paramParcel, 4, g);
    emj.b(paramParcel, 5, h);
    emj.b(paramParcel, k);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.PasswordSpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */