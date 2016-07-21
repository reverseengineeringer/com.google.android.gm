import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Locale;

public final class iec
{
  static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final BitSet b = b("=_?");
  private static final BitSet c = b("=_?\"#$%&'(),.:;<>@[\\]^`{|}~");
  private static final BitSet d = b("()<>@,;:\\\"/[]?=");
  private static final BitSet e = b("()<>@.,;:\\\"[]");
  
  private static char a(int paramInt)
  {
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 65);
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    if (paramArrayOfByte.length == 0) {
      return ied.b;
    }
    if (paramInt == iee.a) {}
    int i;
    for (BitSet localBitSet = b;; localBitSet = c)
    {
      i = 0;
      paramInt = j;
      while (paramInt < paramArrayOfByte.length)
      {
        int k = paramArrayOfByte[paramInt] & 0xFF;
        j = i;
        if (k != 32)
        {
          j = i;
          if (!localBitSet.get(k)) {
            j = i + 1;
          }
        }
        paramInt += 1;
        i = j;
      }
    }
    if (i * 100 / paramArrayOfByte.length > 30) {
      return ied.a;
    }
    return ied.b;
  }
  
  public static String a(String paramString)
  {
    int m = paramString.length();
    int j = 0;
    int i = 0;
    int k = i;
    if (j < m)
    {
      char c1 = paramString.charAt(j);
      if (e.get(c1)) {
        i = 1;
      }
      while (ihb.a(c1))
      {
        j += 1;
        break;
      }
      k = 0;
    }
    if (k != 0) {
      return paramString;
    }
    if (a(paramString, 0)) {
      return b(paramString, iee.b, 0);
    }
    paramString = paramString.replaceAll("[\\\\\"]", "\\\\$0");
    return String.valueOf(paramString).length() + 2 + "\"" + paramString + "\"";
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (a(paramString, paramInt2)) {
      str = b(paramString, paramInt1, paramInt2);
    }
    return str;
  }
  
  private static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, Charset paramCharset, byte[] paramArrayOfByte)
  {
    int k = 0;
    BitSet localBitSet;
    int j;
    if (paramInt1 == iee.a)
    {
      localBitSet = b;
      j = 0;
      i = 0;
      label21:
      if (j >= paramArrayOfByte.length) {
        break label89;
      }
      int m = paramArrayOfByte[j] & 0xFF;
      if ((m == 32) || (localBitSet.get(m))) {
        break label80;
      }
      i += 3;
    }
    for (;;)
    {
      j += 1;
      break label21;
      localBitSet = c;
      break;
      label80:
      i += 1;
    }
    label89:
    if (paramString1.length() + i + 2 <= 75 - paramInt2)
    {
      if (paramInt1 == iee.a)
      {
        paramString2 = b;
        paramCharset = new StringBuilder();
        paramInt2 = paramArrayOfByte.length;
        paramInt1 = k;
        label132:
        if (paramInt1 >= paramInt2) {
          break label235;
        }
        i = paramArrayOfByte[paramInt1] & 0xFF;
        if (i != 32) {
          break label176;
        }
        paramCharset.append('_');
      }
      for (;;)
      {
        paramInt1 += 1;
        break label132;
        paramString2 = c;
        break;
        label176:
        if (!paramString2.get(i))
        {
          paramCharset.append('=');
          paramCharset.append(a(i >>> 4));
          paramCharset.append(a(i & 0xF));
        }
        else
        {
          paramCharset.append((char)i);
        }
      }
      label235:
      paramString2 = String.valueOf(paramCharset.toString());
      paramCharset = String.valueOf("?=");
      return String.valueOf(paramString1).length() + 0 + String.valueOf(paramString2).length() + String.valueOf(paramCharset).length() + paramString1 + paramString2 + paramCharset;
    }
    int i = paramString2.offsetByCodePoints(paramString2.length() / 2, -1);
    paramArrayOfByte = paramString2.substring(0, i);
    paramArrayOfByte = a(paramString1, paramArrayOfByte, paramInt1, paramInt2, paramCharset, a(paramArrayOfByte, paramCharset));
    paramString2 = paramString2.substring(i);
    paramString1 = a(paramString1, paramString2, paramInt1, 0, paramCharset, a(paramString2, paramCharset));
    return String.valueOf(paramArrayOfByte).length() + 1 + String.valueOf(paramString1).length() + paramArrayOfByte + " " + paramString1;
  }
  
  private static String a(String paramString1, String paramString2, int paramInt, Charset paramCharset, byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte.length + 2) / 3 * 4 + paramString1.length() + 2 <= 75 - paramInt)
    {
      paramString2 = new StringBuilder();
      int j = paramArrayOfByte.length;
      paramInt = i;
      while (paramInt < j - 2)
      {
        i = (paramArrayOfByte[paramInt] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 2)] & 0xFF;
        paramString2.append((char)a[(i >> 18 & 0x3F)]);
        paramString2.append((char)a[(i >> 12 & 0x3F)]);
        paramString2.append((char)a[(i >> 6 & 0x3F)]);
        paramString2.append((char)a[(i & 0x3F)]);
        paramInt += 3;
      }
      if (paramInt == j - 2)
      {
        i = paramArrayOfByte[paramInt];
        paramInt = (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (i & 0xFF) << 16;
        paramString2.append((char)a[(paramInt >> 18 & 0x3F)]);
        paramString2.append((char)a[(paramInt >> 12 & 0x3F)]);
        paramString2.append((char)a[(paramInt >> 6 & 0x3F)]);
        paramString2.append('=');
      }
      for (;;)
      {
        paramString2 = String.valueOf(paramString2.toString());
        paramCharset = String.valueOf("?=");
        return String.valueOf(paramString1).length() + 0 + String.valueOf(paramString2).length() + String.valueOf(paramCharset).length() + paramString1 + paramString2 + paramCharset;
        if (paramInt == j - 1)
        {
          paramInt = (paramArrayOfByte[paramInt] & 0xFF) << 16;
          paramString2.append((char)a[(paramInt >> 18 & 0x3F)]);
          paramString2.append((char)a[(paramInt >> 12 & 0x3F)]);
          paramString2.append('=');
          paramString2.append('=');
        }
      }
    }
    i = paramString2.offsetByCodePoints(paramString2.length() / 2, -1);
    paramArrayOfByte = paramString2.substring(0, i);
    paramArrayOfByte = a(paramString1, paramArrayOfByte, paramInt, paramCharset, a(paramArrayOfByte, paramCharset));
    paramString2 = paramString2.substring(i);
    paramString1 = a(paramString1, paramString2, 0, paramCharset, a(paramString2, paramCharset));
    return String.valueOf(paramArrayOfByte).length() + 1 + String.valueOf(paramString1).length() + paramArrayOfByte + " " + paramString1;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if ((paramInt < 0) || (paramInt > 50)) {
      throw new IllegalArgumentException();
    }
    int i = 0;
    boolean bool1 = bool2;
    int j;
    if (i < paramString.length())
    {
      j = paramString.charAt(i);
      if ((j == 9) || (j == 32)) {
        paramInt = 0;
      }
    }
    do
    {
      i += 1;
      break;
      paramInt += 1;
      if (paramInt > 77)
      {
        bool1 = true;
        return bool1;
      }
    } while ((j >= 32) && (j < 127));
    return true;
  }
  
  private static byte[] a(String paramString, Charset paramCharset)
  {
    paramString = paramCharset.encode(paramString);
    paramCharset = new byte[paramString.limit()];
    paramString.get(paramCharset);
    return paramCharset;
  }
  
  private static String b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if ((paramInt2 < 0) || (paramInt2 > 50)) {
      throw new IllegalArgumentException();
    }
    Charset localCharset = c(paramString);
    Object localObject = localCharset.name();
    localObject = (ihc)ihb.b.get(((String)localObject).toLowerCase(Locale.US));
    if (localObject != null) {}
    for (localObject = b; localObject == null; localObject = null) {
      throw new IllegalArgumentException("Unsupported charset");
    }
    byte[] arrayOfByte = a(paramString, localCharset);
    if (a(arrayOfByte, paramInt1) == ied.a)
    {
      str = String.valueOf("=?");
      return a(String.valueOf(str).length() + 3 + String.valueOf(localObject).length() + str + (String)localObject + "?B?", paramString, paramInt2, localCharset, arrayOfByte);
    }
    String str = String.valueOf("=?");
    return a(String.valueOf(str).length() + 3 + String.valueOf(localObject).length() + str + (String)localObject + "?Q?", paramString, paramInt1, paramInt2, localCharset, arrayOfByte);
  }
  
  private static BitSet b(String paramString)
  {
    BitSet localBitSet = new BitSet(128);
    for (int i = 33; i < 127; i = (char)(i + 1)) {
      if (paramString.indexOf(i) == -1) {
        localBitSet.set(i);
      }
    }
    return localBitSet;
  }
  
  private static Charset c(String paramString)
  {
    int j = 1;
    int k = paramString.length();
    int i = 0;
    while (i < k)
    {
      int m = paramString.charAt(i);
      if (m > 255) {
        return ihb.e;
      }
      if (m > 127) {
        j = 0;
      }
      i += 1;
    }
    if (j != 0) {
      return ihb.c;
    }
    return ihb.d;
  }
}

/* Location:
 * Qualified Name:     iec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */