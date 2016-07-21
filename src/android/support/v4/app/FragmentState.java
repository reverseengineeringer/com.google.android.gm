package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ga;

public final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new ga();
  public final String a;
  public final int b;
  public final boolean c;
  public final int d;
  public final int e;
  public final String f;
  public final boolean g;
  public final boolean h;
  public final Bundle i;
  public Bundle j;
  public Fragment k;
  
  public FragmentState(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      c = bool1;
      d = paramParcel.readInt();
      e = paramParcel.readInt();
      f = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label110;
      }
      bool1 = true;
      label69:
      g = bool1;
      if (paramParcel.readInt() == 0) {
        break label115;
      }
    }
    label110:
    label115:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      h = bool1;
      i = paramParcel.readBundle();
      j = paramParcel.readBundle();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
    }
  }
  
  public FragmentState(Fragment paramFragment)
  {
    a = paramFragment.getClass().getName();
    b = p;
    c = x;
    d = F;
    e = G;
    f = H;
    g = K;
    h = J;
    i = r;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeString(a);
    paramParcel.writeInt(b);
    if (c)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(d);
      paramParcel.writeInt(e);
      paramParcel.writeString(f);
      if (!g) {
        break label106;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      if (!h) {
        break label111;
      }
    }
    label106:
    label111:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(i);
      paramParcel.writeBundle(j);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label65;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */