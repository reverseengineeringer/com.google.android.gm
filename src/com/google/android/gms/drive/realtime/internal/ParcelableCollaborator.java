package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fhi;

public class ParcelableCollaborator
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new fhi();
  final int a;
  final boolean b;
  final boolean c;
  final String d;
  final String e;
  final String f;
  final String g;
  final String h;
  
  public ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a = paramInt;
    b = paramBoolean1;
    c = paramBoolean2;
    d = paramString1;
    e = paramString2;
    f = paramString3;
    g = paramString4;
    h = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ParcelableCollaborator)) {
      return false;
    }
    paramObject = (ParcelableCollaborator)paramObject;
    return d.equals(d);
  }
  
  public int hashCode()
  {
    return d.hashCode();
  }
  
  public String toString()
  {
    return "Collaborator [isMe=" + b + ", isAnonymous=" + c + ", sessionId=" + d + ", userId=" + e + ", displayName=" + f + ", color=" + g + ", photoUrl=" + h + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.a(paramParcel, 8, h, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.ParcelableCollaborator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */