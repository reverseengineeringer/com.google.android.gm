package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import ev;
import ez;
import fb;
import fr;
import java.util.ArrayList;

public final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new fb();
  final int[] a;
  final int b;
  final int c;
  final String d;
  final int e;
  final int f;
  final CharSequence g;
  final int h;
  final CharSequence i;
  final ArrayList<String> j;
  final ArrayList<String> k;
  
  public BackStackState(Parcel paramParcel)
  {
    a = paramParcel.createIntArray();
    b = paramParcel.readInt();
    c = paramParcel.readInt();
    d = paramParcel.readString();
    e = paramParcel.readInt();
    f = paramParcel.readInt();
    g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    h = paramParcel.readInt();
    i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    j = paramParcel.createStringArrayList();
    k = paramParcel.createStringArrayList();
  }
  
  public BackStackState(ev paramev)
  {
    ez localez = c;
    int n;
    for (int m = 0; localez != null; m = n)
    {
      n = m;
      if (i != null) {
        n = m + i.size();
      }
      localez = a;
    }
    a = new int[m + e * 7];
    if (!l) {
      throw new IllegalStateException("Not on back stack");
    }
    localez = c;
    m = 0;
    if (localez != null)
    {
      int[] arrayOfInt = a;
      n = m + 1;
      arrayOfInt[m] = c;
      arrayOfInt = a;
      int i1 = n + 1;
      if (d != null) {}
      for (m = d.p;; m = -1)
      {
        arrayOfInt[n] = m;
        arrayOfInt = a;
        m = i1 + 1;
        arrayOfInt[i1] = e;
        arrayOfInt = a;
        n = m + 1;
        arrayOfInt[m] = f;
        arrayOfInt = a;
        m = n + 1;
        arrayOfInt[n] = g;
        arrayOfInt = a;
        n = m + 1;
        arrayOfInt[m] = h;
        if (i == null) {
          break label314;
        }
        i1 = i.size();
        arrayOfInt = a;
        m = n + 1;
        arrayOfInt[n] = i1;
        n = 0;
        while (n < i1)
        {
          a[m] = i.get(n)).p;
          n += 1;
          m += 1;
        }
      }
      for (;;)
      {
        localez = a;
        break;
        label314:
        arrayOfInt = a;
        m = n + 1;
        arrayOfInt[n] = 0;
      }
    }
    b = j;
    c = k;
    d = n;
    e = p;
    f = q;
    g = r;
    h = s;
    i = t;
    j = u;
    k = v;
  }
  
  public final ev a(fr paramfr)
  {
    ev localev = new ev(paramfr);
    int i1 = 0;
    int m = 0;
    while (m < a.length)
    {
      ez localez = new ez();
      Object localObject = a;
      int n = m + 1;
      c = localObject[m];
      if (fr.a) {
        new StringBuilder("Instantiate ").append(localev).append(" op #").append(i1).append(" base fragment #").append(a[n]);
      }
      localObject = a;
      m = n + 1;
      n = localObject[n];
      if (n >= 0) {}
      for (d = ((Fragment)f.get(n));; d = null)
      {
        localObject = a;
        n = m + 1;
        e = localObject[m];
        localObject = a;
        m = n + 1;
        f = localObject[n];
        localObject = a;
        n = m + 1;
        g = localObject[m];
        localObject = a;
        m = n + 1;
        h = localObject[n];
        localObject = a;
        n = m + 1;
        int i3 = localObject[m];
        m = n;
        if (i3 <= 0) {
          break;
        }
        i = new ArrayList(i3);
        int i2 = 0;
        for (;;)
        {
          m = n;
          if (i2 >= i3) {
            break;
          }
          if (fr.a) {
            new StringBuilder("Instantiate ").append(localev).append(" set remove fragment #").append(a[n]);
          }
          localObject = (Fragment)f.get(a[n]);
          i.add(localObject);
          i2 += 1;
          n += 1;
        }
      }
      f = e;
      g = f;
      h = g;
      i = h;
      localev.a(localez);
      i1 += 1;
    }
    j = b;
    k = c;
    n = d;
    p = e;
    l = true;
    q = f;
    r = g;
    s = h;
    t = i;
    u = j;
    v = k;
    localev.a(1);
    return localev;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(a);
    paramParcel.writeInt(b);
    paramParcel.writeInt(c);
    paramParcel.writeString(d);
    paramParcel.writeInt(e);
    paramParcel.writeInt(f);
    TextUtils.writeToParcel(g, paramParcel, 0);
    paramParcel.writeInt(h);
    TextUtils.writeToParcel(i, paramParcel, 0);
    paramParcel.writeStringList(j);
    paramParcel.writeStringList(k);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.BackStackState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */