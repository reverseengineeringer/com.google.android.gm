package com.android.ex.photo.util;

import android.util.Log;

public class Exif
{
  public static int getOrientation(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if (paramArrayOfByte == null) {
      return 0;
    }
    int i = 0;
    int n;
    int i1;
    int m;
    do
    {
      do
      {
        for (;;)
        {
          n = 0;
          k = n;
          j = i;
          if (i + 3 >= paramArrayOfByte.length) {
            break label119;
          }
          j = i + 1;
          if ((paramArrayOfByte[i] & 0xFF) != 255) {
            break label460;
          }
          i1 = paramArrayOfByte[j] & 0xFF;
          if (i1 != 255) {
            break;
          }
          i = j;
        }
        m = j + 1;
        i = m;
      } while (i1 == 216);
      i = m;
    } while (i1 == 1);
    int k = n;
    int j = m;
    if (i1 != 217)
    {
      if (i1 != 218) {
        break label155;
      }
      j = m;
      k = n;
    }
    for (;;)
    {
      label119:
      if (k > 8)
      {
        i = pack(paramArrayOfByte, j, 4, false);
        if ((i != 1229531648) && (i != 1296891946))
        {
          Log.e("CameraExif", "Invalid byte order");
          return 0;
          label155:
          i = pack(paramArrayOfByte, m, 2, false);
          if ((i < 2) || (m + i > paramArrayOfByte.length))
          {
            Log.e("CameraExif", "Invalid length");
            return 0;
          }
          if ((i1 == 225) && (i >= 8) && (pack(paramArrayOfByte, m + 2, 4, false) == 1165519206) && (pack(paramArrayOfByte, m + 6, 2, false) == 0))
          {
            j = m + 8;
            k = i - 8;
            continue;
          }
          i = m + i;
          break;
        }
        if (i == 1229531648) {}
        for (;;)
        {
          m = pack(paramArrayOfByte, j + 4, 4, bool) + 2;
          if ((m >= 10) && (m <= k)) {
            break;
          }
          Log.e("CameraExif", "Invalid offset");
          return 0;
          bool = false;
        }
        i = j + m;
        j = k - m;
        m = pack(paramArrayOfByte, i - 2, 2, bool);
        k = i;
        i = m;
        while ((i > 0) && (j >= 12))
        {
          if (pack(paramArrayOfByte, k, 2, bool) == 274)
          {
            switch (pack(paramArrayOfByte, k + 8, 2, bool))
            {
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 7: 
            default: 
              Log.i("CameraExif", "Unsupported orientation");
              return 0;
            case 3: 
              return 180;
            case 6: 
              return 90;
            }
            return 270;
          }
          k += 12;
          j -= 12;
          i -= 1;
        }
      }
      Log.i("CameraExif", "Orientation not found");
      return 0;
      label460:
      k = n;
    }
  }
  
  private static int pack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 1;
    int i = paramInt1;
    if (paramBoolean)
    {
      i = paramInt1 + (paramInt2 - 1);
      j = -1;
    }
    paramInt1 = 0;
    while (paramInt2 > 0)
    {
      paramInt1 = paramInt1 << 8 | paramArrayOfByte[i] & 0xFF;
      i += j;
      paramInt2 -= 1;
    }
    return paramInt1;
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.util.Exif
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */