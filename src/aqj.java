import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.android.emailcommon.provider.Attachment;
import java.util.List;

public final class aqj
{
  public static final String[] a = { "_id", "size", "fileName", "mimeType", "accountKey", "flags" };
  public final long b;
  public final long c;
  public final String d;
  public final String e;
  public final long f;
  public final int g;
  public final boolean h;
  public final boolean i;
  public final boolean j;
  public final int k;
  
  private aqj(Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3, int paramInt)
  {
    c = paramLong2;
    e = bgt.a(paramString1, paramString2);
    d = paramString1;
    b = paramLong1;
    f = paramLong3;
    g = paramInt;
    int i2 = 1;
    int i1 = 1;
    if (!bhn.a()) {
      i1 = 0;
    }
    if ((!bco.a(e, bgt.a)) || (bco.a(e, bgt.b))) {
      i2 = 0;
    }
    paramString1 = bgt.a(d);
    int n;
    if ((!TextUtils.isEmpty(paramString1)) && (bhn.a(bgt.c, paramString1)))
    {
      i1 = 0;
      i2 = 0;
      n = 1;
    }
    for (;;)
    {
      int m = n;
      if ((paramInt & 0x200) != 0)
      {
        i1 = 0;
        i2 = 0;
        m = n | 0x20;
      }
      paramString1 = bgt.a(d);
      if ((!TextUtils.isEmpty(paramString1)) && (bhn.a(bgt.d, paramString1))) {
        if (Settings.Secure.getInt(paramContext.getContentResolver(), "install_non_market_apps", 0) == 1)
        {
          paramInt = 1;
          i1 = i2 & paramInt;
          if (paramInt != 0) {
            break label347;
          }
          m |= 0x8;
          i3 = i1;
          i2 = i1;
        }
      }
      for (;;)
      {
        paramString2 = bgt.a(0L, b);
        paramString1 = paramString2;
        if (0L > 0L) {
          paramString1 = bgt.a(paramContext.getContentResolver(), paramString2);
        }
        paramString2 = new Intent("android.intent.action.VIEW");
        paramString2.setDataAndType(paramString1, e);
        paramString2.addFlags(524289);
        paramInt = m;
        if (paramContext.getPackageManager().queryIntentActivities(paramString2, 0).isEmpty())
        {
          i2 = 0;
          paramInt = m | 0x4;
        }
        h = i2;
        i = i3;
        j = i1;
        k = paramInt;
        return;
        paramInt = 0;
        break;
        label347:
        i3 = i1;
        i2 = i1;
        continue;
        int i4 = i1;
        i1 = 0;
        i3 = i2;
        i2 = i4;
      }
      int i3 = i2;
      n = 0;
      i2 = i1;
      i1 = i3;
    }
  }
  
  public aqj(Context paramContext, Attachment paramAttachment)
  {
    this(paramContext, D, k, i, j, u, s);
  }
  
  public final boolean a()
  {
    return (h) || (i);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
    } while (b == b);
    return false;
  }
  
  public final int hashCode()
  {
    return (int)(b ^ b >>> 32);
  }
  
  public final String toString()
  {
    long l1 = b;
    String str1 = d;
    String str2 = e;
    long l2 = c;
    return String.valueOf(str1).length() + 56 + String.valueOf(str2).length() + "{Attachment " + l1 + ":" + str1 + "," + str2 + "," + l2 + "}";
  }
}

/* Location:
 * Qualified Name:     aqj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */