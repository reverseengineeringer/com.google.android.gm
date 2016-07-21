import android.util.Log;
import java.io.InputStream;

public final class bmz
{
  private static int a(bnf parambnf, int paramInt1, int paramInt2, boolean paramBoolean)
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
      paramInt1 = paramInt1 << 8 | parambnf.a(i) & 0xFF;
      i += j;
      paramInt2 -= 1;
    }
    return paramInt1;
  }
  
  public static int a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {}
    label47:
    label53:
    label184:
    label518:
    for (;;)
    {
      return 0;
      paramInputStream = new bnf(paramInputStream);
      int i;
      int j;
      int k;
      if (a(paramInputStream, -1L, 1))
      {
        if ((paramInputStream.a(0) == -1) && (paramInputStream.a(1) == -40))
        {
          i = 1;
          if (i == 0) {
            break label184;
          }
        }
      }
      else
      {
        i = 0;
        for (;;)
        {
          if (a(paramInputStream, -1L, i + 3))
          {
            j = i + 1;
            if ((paramInputStream.a(i) & 0xFF) == 255)
            {
              k = paramInputStream.a(j) & 0xFF;
              if (k != 255)
              {
                j += 1;
                i = j;
                if (k == 216) {
                  continue;
                }
                i = j;
                if (k == 1) {
                  continue;
                }
                if ((k == 217) || (k == 218))
                {
                  paramInputStream.c(j - 4);
                  i = 0;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i <= 8) {
          break label518;
        }
        k = a(paramInputStream, j, 4, false);
        if ((k != 1229531648) && (k != 1296891946))
        {
          Log.e("CameraExif", "Invalid byte order");
          return 0;
          i = 0;
          break label47;
          break;
          i = a(paramInputStream, j, 2, false);
          if ((i < 2) || (!a(paramInputStream, -1L, j + i - 1)))
          {
            Log.e("CameraExif", "Invalid length");
            return 0;
          }
          if ((k == 225) && (i >= 8) && (a(paramInputStream, j + 2, 4, false) == 1165519206) && (a(paramInputStream, j + 6, 2, false) == 0))
          {
            j += 8;
            paramInputStream.c(j - 4);
            i -= 8;
            continue;
          }
          i = j + i;
          paramInputStream.c(i - 4);
          break label53;
        }
        if (k == 1229531648) {}
        for (boolean bool = true;; bool = false)
        {
          k = a(paramInputStream, j + 4, 4, bool) + 2;
          if ((k >= 10) && (k <= i)) {
            break;
          }
          Log.e("CameraExif", "Invalid offset");
          return 0;
        }
        j += k;
        paramInputStream.c(j - 4);
        int m = a(paramInputStream, j - 2, 2, bool);
        i -= k;
        k = j;
        j = i;
        i = m;
        while ((i > 0) && (j >= 12))
        {
          if (a(paramInputStream, k, 2, bool) == 274)
          {
            switch (a(paramInputStream, k + 8, 2, bool))
            {
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 7: 
            default: 
              return 0;
            case 3: 
              return 180;
            case 6: 
              return 90;
            }
            return 270;
          }
          k += 12;
          paramInputStream.c(k - 4);
          j -= 12;
          i -= 1;
        }
        break;
        i = j;
        break label53;
        i = 0;
        continue;
        k = 0;
        j = i;
        i = k;
      }
    }
  }
  
  private static boolean a(bnf parambnf, long paramLong, int paramInt)
  {
    if (-1L >= 0L) {
      return paramInt < -1L;
    }
    return parambnf.b(paramInt);
  }
}

/* Location:
 * Qualified Name:     bmz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */