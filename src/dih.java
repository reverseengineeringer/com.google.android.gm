import android.content.Context;
import android.text.TextUtils;

final class dih
  extends dgr
{
  private final String a;
  
  public dih(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, paramString1, paramString2);
    a = paramString3;
  }
  
  public final String a()
  {
    String str2 = super.a();
    String str1 = str2;
    if (!TextUtils.isEmpty(a))
    {
      str1 = ghz.a(getContext().getContentResolver(), "gmail-plid-message-id-key", "&mid=");
      String str3 = Long.toHexString(Long.parseLong(a));
      str2 = String.valueOf(str2);
      str1 = String.valueOf(str2).length() + 0 + String.valueOf(str1).length() + String.valueOf(str3).length() + str2 + str1 + str3;
    }
    return str1;
  }
}

/* Location:
 * Qualified Name:     dih
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */