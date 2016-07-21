package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enz;
import fgc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomPropertyKey
  implements SafeParcelable
{
  public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new fgc();
  private static final Pattern d = Pattern.compile("[\\w.!@$%^&*()/-]+");
  final int a;
  public final String b;
  final int c;
  
  public CustomPropertyKey(int paramInt1, String paramString, int paramInt2)
  {
    enz.a(paramString, "key");
    enz.b(d.matcher(paramString).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
    boolean bool1 = bool2;
    if (paramInt2 != 0) {
      if (paramInt2 != 1) {
        break label69;
      }
    }
    label69:
    for (bool1 = bool2;; bool1 = false)
    {
      enz.b(bool1, "visibility must be either PUBLIC or PRIVATE");
      a = paramInt1;
      b = paramString;
      c = paramInt2;
      return;
    }
  }
  
  public CustomPropertyKey(String paramString)
  {
    this(1, paramString, 1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (!(paramObject instanceof CustomPropertyKey));
      paramObject = (CustomPropertyKey)paramObject;
    } while ((!b.equals(b)) || (c != c));
    return true;
  }
  
  public int hashCode()
  {
    return (b + c).hashCode();
  }
  
  public String toString()
  {
    return "CustomPropertyKey(" + b + "," + c + ")";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.metadata.CustomPropertyKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */