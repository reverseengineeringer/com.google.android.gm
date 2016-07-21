import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class bvb
  implements anl
{
  final String a;
  final String b;
  public byte[] c;
  
  public bvb(String paramString1, String paramString2)
  {
    a = paramString1;
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("Email must not be empty.");
    }
    b = paramString2;
  }
  
  public final InputStream a()
  {
    return new ByteArrayInputStream(c);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (bvb)paramObject;
      if (b == null) {
        break;
      }
    } while (b.equals(b));
    for (;;)
    {
      return false;
      if (b == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    if (b != null) {
      return b.hashCode();
    }
    return 0;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(super.toString());
    String str2 = a;
    String str3 = b;
    return String.valueOf(str1).length() + 17 + String.valueOf(str2).length() + String.valueOf(str3).length() + "[" + str1 + " mName=" + str2 + " mEmail=" + str3 + "]";
  }
}

/* Location:
 * Qualified Name:     bvb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */