package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egf;
import emj;
import enz;

public class AppDescription
  implements SafeParcelable
{
  public static final egf CREATOR = new egf();
  private static final String g = "[" + AppDescription.class.getSimpleName() + "]";
  final int a;
  int b;
  String c;
  String d;
  String e;
  boolean f;
  private final String h = "[" + getClass().getSimpleName() + "] %s - %s: %s";
  
  public AppDescription(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    a = paramInt1;
    c = paramString1;
    d = paramString2;
    e = enz.a(paramString3, g + " callingPkg cannot be null or empty!");
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      enz.b(bool, "Invalid callingUid! Cannot be 0!");
      b = paramInt2;
      f = paramBoolean;
      return;
    }
  }
  
  public AppDescription(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this(1, paramInt, paramString2, paramString3, paramString1, false);
    if (Log.isLoggable("GLSSession", 2)) {
      new StringBuilder("New ").append(getClass().getSimpleName()).append(" (sessiondId: ").append(c).append(", sessiondSig: ").append(d).append(", callingPkg: ").append(e).append(", callingUid: ").append(b).append(", ");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "<" + e + ", " + b + ">";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.AppDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */