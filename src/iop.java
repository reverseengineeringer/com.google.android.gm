import java.io.ByteArrayOutputStream;

public final class iop
{
  private String a;
  private boolean b;
  private boolean c;
  
  public iop(String paramString)
  {
    a = paramString;
    b = false;
    c = false;
  }
  
  public final String a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j = 0;
    while (j < (paramArrayOfByte.length + 4) / 5)
    {
      short[] arrayOfShort = new short[5];
      int i = 0;
      int k = 5;
      if (i < 5)
      {
        if (j * 5 + i < paramArrayOfByte.length) {
          arrayOfShort[i] = ((short)(paramArrayOfByte[(j * 5 + i)] & 0xFF));
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfShort[i] = 0;
          k -= 1;
        }
      }
      switch (k)
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        int m = (byte)(arrayOfShort[0] >> 3 & 0x1F);
        int n = (byte)((arrayOfShort[0] & 0x7) << 2 | arrayOfShort[1] >> 6 & 0x3);
        int i1 = (byte)(arrayOfShort[1] >> 1 & 0x1F);
        int i2 = (byte)((arrayOfShort[1] & 0x1) << 4 | arrayOfShort[2] >> 4 & 0xF);
        int i3 = (byte)((arrayOfShort[2] & 0xF) << 1 | arrayOfShort[3] >> 7 & 0x1);
        int i4 = (byte)(arrayOfShort[3] >> 2 & 0x1F);
        int i5 = (byte)((arrayOfShort[3] & 0x3) << 3 | arrayOfShort[4] >> 5 & 0x7);
        int i6 = (byte)(arrayOfShort[4] & 0x1F);
        k = 0;
        while (k < 8 - i)
        {
          char c1 = a.charAt(new int[] { m, n, i1, i2, i3, i4, i5, i6 }[k]);
          char c2 = c1;
          if (c) {
            c2 = Character.toLowerCase(c1);
          }
          localByteArrayOutputStream.write(c2);
          k += 1;
        }
        i = 6;
        continue;
        i = 4;
        continue;
        i = 3;
        continue;
        i = 1;
        continue;
        i = 0;
      }
      if (b)
      {
        i = 8 - i;
        while (i < 8)
        {
          localByteArrayOutputStream.write(61);
          i += 1;
        }
      }
      j += 1;
    }
    return new String(localByteArrayOutputStream.toByteArray());
  }
}

/* Location:
 * Qualified Name:     iop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */