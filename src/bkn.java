import android.net.Uri;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;

public class bkn
{
  public final int a;
  boolean b;
  public final String c;
  public final String d;
  final int e;
  final String f;
  public final long g;
  public final Long h;
  public final long i;
  final Uri j;
  public boolean k;
  public int l;
  String m;
  public final String n;
  public final String[] o;
  private byte[] p;
  
  public bkn(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong1, Long paramLong, long paramLong2, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, String paramString4, String[] paramArrayOfString)
  {
    a = paramInt1;
    b = paramBoolean1;
    c = paramString1;
    d = paramString2;
    e = paramInt2;
    f = paramString3;
    g = paramLong1;
    h = paramLong;
    i = paramLong2;
    j = paramUri;
    p = null;
    k = paramBoolean2;
    n = paramString4;
    l = 0;
    m = null;
    o = paramArrayOfString;
  }
  
  public static bkn a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, Long paramLong, long paramLong2, String paramString4, String paramString5)
  {
    String str = a(paramInt1, paramString1, paramString2);
    if (paramString4 != null) {}
    for (paramString1 = Uri.parse(paramString4);; paramString1 = null) {
      return new bkn(0, str, paramString2, paramInt2, paramString3, paramLong1, paramLong, paramLong2, paramString1, true, true, paramString5, null);
    }
  }
  
  public static bkn a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return new bkn(0, paramString1, paramString2, -1, null, -2L, null, -2L, null, true, paramBoolean, null, null);
  }
  
  public static bkn a(String paramString, boolean paramBoolean)
  {
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramString);
    if (arrayOfRfc822Token.length > 0) {
      paramString = arrayOfRfc822Token[0].getAddress();
    }
    for (;;)
    {
      return new bkn(0, paramString, paramString, -1, null, -1L, null, -1L, null, true, paramBoolean, null, null);
    }
  }
  
  public static bkn a(String[] paramArrayOfString)
  {
    return new bkn(1, "", "", 0, "", -1L, null, -1L, null, true, false, null, paramArrayOfString);
  }
  
  static String a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt > 20) {
      return paramString1;
    }
    return paramString2;
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == -1L) || (paramLong == -2L);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    try
    {
      p = paramArrayOfByte;
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final byte[] a()
  {
    try
    {
      byte[] arrayOfByte = p;
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    String str1 = c;
    String str2 = d;
    boolean bool = k;
    return String.valueOf(str1).length() + 18 + String.valueOf(str2).length() + str1 + " <" + str2 + ">, isValid=" + bool;
  }
}

/* Location:
 * Qualified Name:     bkn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */