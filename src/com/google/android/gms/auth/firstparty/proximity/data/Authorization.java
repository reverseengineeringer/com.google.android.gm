package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ega;
import emj;
import enz;
import java.util.Arrays;

public class Authorization
  implements SafeParcelable
{
  public static final ega CREATOR = new ega();
  final int a;
  public final String b;
  public final String c;
  public final byte[] d;
  
  public Authorization(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    a = paramInt;
    b = enz.a(paramString1);
    c = enz.a(paramString2);
    d = ((byte[])enz.a(paramArrayOfByte));
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
      } while (!(paramObject instanceof Authorization));
      paramObject = (Authorization)paramObject;
    } while ((!TextUtils.equals(b, b)) || (!TextUtils.equals(c, c)) || (!Arrays.equals(d, d)));
    return true;
  }
  
  public int hashCode()
  {
    return ((b.hashCode() + 527) * 31 + c.hashCode()) * 31 + Arrays.hashCode(d);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.proximity.data.Authorization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */