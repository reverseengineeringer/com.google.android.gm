import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class emj
{
  public static int a(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  public static void a(Parcel paramParcel, double paramDouble)
  {
    a(paramParcel, 3, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void a(Parcel paramParcel, int paramInt, byte paramByte)
  {
    a(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt2 << 16 | paramInt1);
  }
  
  public static void a(Parcel paramParcel, int paramInt, long paramLong)
  {
    a(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void a(Parcel paramParcel, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramInt = a(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    b(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return;
    }
    paramInt = a(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    b(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable == null)
    {
      if (paramBoolean) {
        a(paramParcel, paramInt1, 0);
      }
      return;
    }
    paramInt1 = a(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    b(paramParcel, paramInt1);
  }
  
  public static void a(Parcel paramParcel, int paramInt, Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    a(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
  }
  
  public static void a(Parcel paramParcel, int paramInt, Long paramLong)
  {
    if (paramLong == null) {
      return;
    }
    a(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong.longValue());
  }
  
  public static void a(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      if (paramBoolean) {
        a(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = a(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    b(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, List<String> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        a(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = a(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    b(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    a(paramParcel, paramInt, 4);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
    {
      if (paramBoolean) {
        a(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = a(paramParcel, paramInt);
    paramParcel.writeByteArray(paramArrayOfByte);
    b(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    paramInt = a(paramParcel, paramInt);
    paramParcel.writeIntArray(paramArrayOfInt);
    b(paramParcel, paramInt);
  }
  
  public static <T extends Parcelable> void a(boolean paramBoolean)
  {
    ;
    if (localObject == null) {
      return;
    }
    int k = a(paramBoolean, i);
    int m = localObject.length;
    paramBoolean.writeInt(m);
    int i = 0;
    if (i < m)
    {
      Parcelable localParcelable = localObject[i];
      if (localParcelable == null) {
        paramBoolean.writeInt(0);
      }
      for (;;)
      {
        i += 1;
        break;
        int j;
        a(paramBoolean, localParcelable, j);
      }
    }
    b(paramBoolean, k);
  }
  
  public static void a(Parcel paramParcel, int paramInt, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    paramInt = a(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    b(paramParcel, paramInt);
  }
  
  private static <T extends Parcelable> void a(Parcel paramParcel, T paramT, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramT.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  public static void b(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  public static void b(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    a(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static <T extends Parcelable> void b(Parcel paramParcel, int paramInt, List<T> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        a(paramParcel, paramInt, 0);
      }
      return;
    }
    int i = a(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      Parcelable localParcelable = (Parcelable)paramList.get(paramInt);
      if (localParcelable == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        a(paramParcel, localParcelable, 0);
      }
    }
    b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     emj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */