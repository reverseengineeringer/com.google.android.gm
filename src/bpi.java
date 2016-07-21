import android.content.ContentValues;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public final class bpi
{
  private final OutputStream a;
  private int b = -1;
  private final Deque<String> c = new ArrayDeque();
  private int d = 0;
  
  public bpi()
  {
    this(new ByteArrayOutputStream(), (byte)0);
  }
  
  public bpi(OutputStream paramOutputStream)
  {
    this(paramOutputStream, (byte)0);
  }
  
  private bpi(OutputStream paramOutputStream, byte paramByte)
  {
    a = paramOutputStream;
    a.write(3);
    a.write(1);
    a.write(106);
    a.write(0);
  }
  
  private static void a(OutputStream paramOutputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[5];
    int j = 0;
    int i = paramInt;
    for (paramInt = j;; paramInt = j)
    {
      j = paramInt + 1;
      arrayOfByte[paramInt] = ((byte)(i & 0x7F));
      i >>>= 7;
      if (i == 0)
      {
        while (j > 1)
        {
          j -= 1;
          paramOutputStream.write(arrayOfByte[j] | 0x80);
        }
        paramOutputStream.write(arrayOfByte[0]);
        return;
      }
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (b == -1) {
      return;
    }
    int k = b >> 6;
    int j = b & 0x3F;
    if (k != d)
    {
      d = k;
      a.write(0);
      a.write(k);
    }
    Object localObject = a;
    int i;
    if (paramBoolean)
    {
      i = j;
      ((OutputStream)localObject).write(i);
      if (bpk.a(k)) {
        break label199;
      }
      b(29 + "Unrecognized page " + k);
      localObject = "unknown";
      label114:
      if (!paramBoolean) {
        break label261;
      }
    }
    label199:
    label261:
    for (String str = "/>";; str = ">")
    {
      b(String.valueOf(localObject).length() + 1 + String.valueOf(str).length() + "<" + (String)localObject + str);
      if (!paramBoolean) {
        c.addFirst(localObject);
      }
      b = -1;
      return;
      i = j | 0x40;
      break;
      if (!bpk.a(k, j))
      {
        b(43 + "Unknown tag " + j + " on page " + k);
        localObject = "unknown";
        break label114;
      }
      localObject = bpk.b(k, j);
      break label114;
    }
  }
  
  private final void b(String paramString)
  {
    if (!cvm.a("Exchange", 2)) {
      return;
    }
    int i = paramString.indexOf('\n');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    paramString = new char[c.size() * 2];
    Arrays.fill(paramString, ' ');
    cvm.a("Exchange", "%s%s", new Object[] { new String(paramString), str });
    btf.a("Exchange", str);
  }
  
  public final bpi a(int paramInt)
  {
    a(false);
    b = paramInt;
    return this;
  }
  
  public final bpi a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      b(paramInt, paramString);
    }
    return this;
  }
  
  public final bpi a(InputStream paramInputStream, int paramInt)
  {
    c(paramInt);
    b(19 + "opaque: " + paramInt);
    byte[] arrayOfByte = new byte['䀀'];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, 0, Math.min(16384, paramInt));
      if (j == -1) {
        throw new IOException(74 + "Invalid opaque data block; read " + i + " bytes but expected " + paramInt);
      }
      a.write(arrayOfByte, 0, j);
      i += j;
    }
    return this;
  }
  
  public final bpi a(String paramString)
  {
    if (paramString == null)
    {
      int i = b;
      throw new IOException(44 + "Null text write for pending tag: " + i);
    }
    a(false);
    OutputStream localOutputStream = a;
    localOutputStream.write(3);
    localOutputStream.write(paramString.getBytes("UTF-8"));
    localOutputStream.write(0);
    b(paramString);
    return this;
  }
  
  public final void a()
  {
    if ((c.size() != 0) || (b != -1)) {
      throw new IOException("Done received with unclosed tags");
    }
    a.flush();
  }
  
  public final void a(ContentValues paramContentValues, String paramString, int paramInt)
  {
    paramContentValues = paramContentValues.getAsString(paramString);
    if (!TextUtils.isEmpty(paramContentValues))
    {
      b(paramInt, paramContentValues);
      return;
    }
    b(paramInt);
  }
  
  public final bpi b()
  {
    if (b >= 0)
    {
      a(true);
      return this;
    }
    a.write(1);
    String str = (String)c.removeFirst();
    b(String.valueOf(str).length() + 3 + "</" + str + ">");
    return this;
  }
  
  public final bpi b(int paramInt)
  {
    a(paramInt);
    b();
    return this;
  }
  
  public final bpi b(int paramInt, String paramString)
  {
    a(paramInt);
    a(paramString);
    b();
    return this;
  }
  
  public final bpi c(int paramInt)
  {
    if (paramInt < 0) {
      throw new IOException(47 + "Invalid negative opaque data length " + paramInt);
    }
    if (paramInt == 0) {
      return this;
    }
    a(false);
    a.write(195);
    a(a, paramInt);
    return this;
  }
  
  public final byte[] c()
  {
    if ((a instanceof ByteArrayOutputStream)) {
      return ((ByteArrayOutputStream)a).toByteArray();
    }
    throw new IllegalStateException();
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (!(paramObject instanceof bpi));
    paramObject = (bpi)paramObject;
    return Arrays.equals(c(), ((bpi)paramObject).c());
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(c());
  }
  
  public final String toString()
  {
    if ((a instanceof ByteArrayOutputStream)) {
      return ((ByteArrayOutputStream)a).toString();
    }
    throw new IllegalStateException();
  }
}

/* Location:
 * Qualified Name:     bpi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */