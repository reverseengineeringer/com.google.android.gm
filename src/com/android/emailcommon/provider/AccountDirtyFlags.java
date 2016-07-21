package com.android.emailcommon.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bdq;
import bdv;

public class AccountDirtyFlags
  extends bdv
  implements Parcelable
{
  public static final Parcelable.Creator<AccountDirtyFlags> CREATOR = new bdq();
  public static Uri a;
  public static final String[] e = { "_id", "signatureDirty", "syncLookbackDirty", "passwordDirty" };
  public boolean b;
  public boolean c;
  public boolean d;
  
  public AccountDirtyFlags()
  {
    C = a;
  }
  
  public AccountDirtyFlags(Parcel paramParcel)
  {
    C = a;
    D = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      b = bool1;
      if (paramParcel.readByte() == 0) {
        break label69;
      }
      bool1 = true;
      label44:
      c = bool1;
      if (paramParcel.readByte() == 0) {
        break label74;
      }
    }
    label69:
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      d = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label44;
    }
  }
  
  public static AccountDirtyFlags a(Context paramContext, long paramLong)
  {
    return (AccountDirtyFlags)bdv.a(paramContext, AccountDirtyFlags.class, a, e, paramLong);
  }
  
  public static void a()
  {
    String str = String.valueOf(bdv.H);
    a = Uri.parse(String.valueOf(str).length() + 18 + str + "/accountDirtyFlags");
  }
  
  public final void a(Cursor paramCursor)
  {
    boolean bool2 = true;
    D = paramCursor.getLong(0);
    if (paramCursor.getInt(1) != 0)
    {
      bool1 = true;
      b = bool1;
      if (paramCursor.getInt(2) == 0) {
        break label70;
      }
      bool1 = true;
      label42:
      c = bool1;
      if (paramCursor.getInt(3) == 0) {
        break label75;
      }
    }
    label70:
    label75:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      d = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label42;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final ContentValues e()
  {
    ContentValues localContentValues = new ContentValues(3);
    localContentValues.put("_id", Long.valueOf(D));
    localContentValues.put("signatureDirty", Boolean.valueOf(b));
    localContentValues.put("syncLookbackDirty", Boolean.valueOf(c));
    localContentValues.put("passwordDirty", Boolean.valueOf(d));
    return localContentValues;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeLong(D);
    if (b)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!c) {
        break label60;
      }
      b1 = 1;
      label34:
      paramParcel.writeByte(b1);
      if (!d) {
        break label65;
      }
    }
    label60:
    label65:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label34;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.AccountDirtyFlags
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */