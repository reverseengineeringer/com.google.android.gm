import java.io.ByteArrayOutputStream;

public final class ioq
{
  public static String a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i < (paramArrayOfByte.length + 2) / 3)
    {
      short[] arrayOfShort1 = new short[3];
      short[] arrayOfShort2 = new short[4];
      int j = 0;
      if (j < 3)
      {
        if (i * 3 + j < paramArrayOfByte.length) {
          arrayOfShort1[j] = ((short)(paramArrayOfByte[(i * 3 + j)] & 0xFF));
        }
        for (;;)
        {
          j += 1;
          break;
          arrayOfShort1[j] = -1;
        }
      }
      arrayOfShort2[0] = ((short)(arrayOfShort1[0] >> 2));
      if (arrayOfShort1[1] == -1)
      {
        arrayOfShort2[1] = ((short)((arrayOfShort1[0] & 0x3) << 4));
        if (arrayOfShort1[1] != -1) {
          break label180;
        }
        arrayOfShort2[3] = 64;
        arrayOfShort2[2] = 64;
      }
      for (;;)
      {
        j = 0;
        while (j < 4)
        {
          localByteArrayOutputStream.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(arrayOfShort2[j]));
          j += 1;
        }
        arrayOfShort2[1] = ((short)(((arrayOfShort1[0] & 0x3) << 4) + (arrayOfShort1[1] >> 4)));
        break;
        label180:
        if (arrayOfShort1[2] == -1)
        {
          arrayOfShort2[2] = ((short)((arrayOfShort1[1] & 0xF) << 2));
          arrayOfShort2[3] = 64;
        }
        else
        {
          arrayOfShort2[2] = ((short)(((arrayOfShort1[1] & 0xF) << 2) + (arrayOfShort1[2] >> 6)));
          arrayOfShort2[3] = ((short)(arrayOfShort1[2] & 0x3F));
        }
      }
      i += 1;
    }
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    paramArrayOfByte = a(paramArrayOfByte);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramArrayOfByte.length())
    {
      localStringBuffer.append(paramString);
      if (i + 64 >= paramArrayOfByte.length())
      {
        localStringBuffer.append(paramArrayOfByte.substring(i));
        if (paramBoolean) {
          localStringBuffer.append(" )");
        }
      }
      for (;;)
      {
        i += 64;
        break;
        localStringBuffer.append(paramArrayOfByte.substring(i, i + 64));
        localStringBuffer.append("\n");
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ioq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */