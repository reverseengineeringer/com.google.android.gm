package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import fjd;
import java.util.Arrays;

public class Permission
  implements SafeParcelable
{
  public static final Parcelable.Creator<Permission> CREATOR = new fjd();
  final int a;
  String b;
  int c;
  String d;
  String e;
  int f;
  boolean g;
  
  public Permission(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, boolean paramBoolean)
  {
    a = paramInt1;
    b = paramString1;
    c = paramInt2;
    d = paramString2;
    e = paramString3;
    f = paramInt3;
    g = paramBoolean;
  }
  
  private static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (Permission)paramObject;
      if ((!enx.a(b, b)) || (c != c) || (f != f)) {
        break;
      }
      bool1 = bool2;
    } while (g == g);
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { b, Integer.valueOf(c), Integer.valueOf(f), Boolean.valueOf(g) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    int j = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    String str;
    if (!a(c))
    {
      str = null;
      emj.a(paramParcel, 2, str, false);
      if (a(c)) {
        break label153;
      }
      paramInt = -1;
      label53:
      emj.b(paramParcel, 3, paramInt);
      emj.a(paramParcel, 4, d, false);
      emj.a(paramParcel, 5, e, false);
      switch (f)
      {
      default: 
        paramInt = 0;
        label114:
        if (paramInt != 0) {
          break;
        }
      }
    }
    for (paramInt = i;; paramInt = f)
    {
      emj.b(paramParcel, 6, paramInt);
      emj.a(paramParcel, 7, g);
      emj.b(paramParcel, j);
      return;
      str = b;
      break;
      label153:
      paramInt = c;
      break label53;
      paramInt = 1;
      break label114;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.Permission
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */