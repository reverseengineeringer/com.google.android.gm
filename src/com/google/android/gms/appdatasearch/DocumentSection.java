package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebl;
import ebt;
import ece;
import emj;
import enz;
import java.util.BitSet;
import java.util.List;

public class DocumentSection
  implements SafeParcelable
{
  public static final ebl CREATOR;
  public static final int a;
  private static final RegisterSectionInfo g;
  final int b;
  public final String c;
  final RegisterSectionInfo d;
  public final int e;
  public final byte[] f;
  
  static
  {
    int i = 0;
    a = Integer.parseInt("-1");
    CREATOR = new ebl();
    ece localece = new ece("SsbContext");
    c = true;
    b = "blob";
    Object localObject = null;
    if (h != null)
    {
      int[] arrayOfInt = new int[h.cardinality()];
      int j = h.nextSetBit(0);
      for (;;)
      {
        localObject = arrayOfInt;
        if (j < 0) {
          break;
        }
        arrayOfInt[i] = j;
        j = h.nextSetBit(j + 1);
        i += 1;
      }
    }
    g = new RegisterSectionInfo(a, b, c, d, e, f, (Feature[])g.toArray(new Feature[g.size()]), (int[])localObject, i);
  }
  
  public DocumentSection(int paramInt1, String paramString, RegisterSectionInfo paramRegisterSectionInfo, int paramInt2, byte[] paramArrayOfByte)
  {
    boolean bool;
    if ((paramInt2 == a) || (ebt.a(paramInt2) != null))
    {
      bool = true;
      enz.b(bool, "Invalid section type " + paramInt2);
      b = paramInt1;
      c = paramString;
      d = paramRegisterSectionInfo;
      e = paramInt2;
      f = paramArrayOfByte;
      if ((e == a) || (ebt.a(e) != null)) {
        break label131;
      }
      paramString = "Invalid section type " + e;
    }
    for (;;)
    {
      if (paramString == null) {
        return;
      }
      throw new IllegalArgumentException(paramString);
      bool = false;
      break;
      label131:
      if ((c != null) && (f != null)) {
        paramString = "Both content and blobContent set";
      } else {
        paramString = null;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, c, false);
    emj.b(paramParcel, 1000, b);
    emj.a(paramParcel, 3, d, paramInt, false);
    emj.b(paramParcel, 4, e);
    emj.a(paramParcel, 5, f, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentSection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */