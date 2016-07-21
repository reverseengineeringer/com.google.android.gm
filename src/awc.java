import android.content.Context;
import android.os.Bundle;
import java.io.IOException;

final class awc
  extends cot<Bundle>
{
  private final String a;
  private final String b;
  
  public awc(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    a = paramString1;
    b = paramString2;
  }
  
  private final Bundle a()
  {
    try
    {
      Object localObject1 = new Bundle(4);
      Object localObject2 = awu.a(a);
      Context localContext = getContext();
      String str1 = a;
      String str2 = b;
      bcb localbcb = awj.a(localContext).c(str1);
      if (localbcb == null)
      {
        cvm.e(awu.a, "invalid provider %s", new Object[] { str1 });
        localObject1 = String.valueOf(str1);
        if (((String)localObject1).length() != 0) {}
        for (localObject1 = "Invalid provider ".concat((String)localObject1);; localObject1 = new String("Invalid provider ")) {
          throw new bcs(18, (String)localObject1);
        }
      }
      localObject2 = ((awu)localObject2).a(((awu)localObject2).a(localContext, localbcb, str2), str1, "access");
      cvm.b(bbw.a, "authentication %s", new Object[] { localObject2 });
      if (localObject2 != null)
      {
        ((Bundle)localObject1).putString("provider", a);
        ((Bundle)localObject1).putString("accessToken", a);
        ((Bundle)localObject1).putString("refreshToken", b);
        ((Bundle)localObject1).putLong("expiresInSeconds", c);
        return (Bundle)localObject1;
      }
    }
    catch (bdi localbdi)
    {
      return null;
    }
    catch (IOException localIOException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     awc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */