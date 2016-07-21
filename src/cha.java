import com.android.mail.providers.Account;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class cha
  implements Serializable
{
  private static final String f = cvl.a;
  private static final long serialVersionUID = 1L;
  public final Account a;
  public final String b;
  public final String c;
  public final boolean d;
  public final boolean e;
  private final String g;
  
  public cha(Account paramAccount, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    a = paramAccount;
    b = paramString1;
    c = paramString2;
    g = paramString3;
    d = paramBoolean1;
    e = paramBoolean2;
  }
  
  public static cha a(Account paramAccount, String paramString)
  {
    try
    {
      paramAccount = a(paramAccount, new JSONObject(paramString));
      return paramAccount;
    }
    catch (JSONException paramAccount)
    {
      cvm.f(f, paramAccount, "Could not deserialize replyfromaccount", new Object[0]);
    }
    return null;
  }
  
  public static cha a(Account paramAccount, JSONObject paramJSONObject)
  {
    try
    {
      paramAccount = new cha(paramAccount, paramJSONObject.getString("address"), paramJSONObject.optString("name", null), paramJSONObject.getString("replyTo"), paramJSONObject.getBoolean("isDefault"), paramJSONObject.getBoolean("isCustom"));
      return paramAccount;
    }
    catch (JSONException paramAccount)
    {
      cvm.f(f, paramAccount, "Could not deserialize replyfromaccount", new Object[0]);
    }
    return null;
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    String str2;
    try
    {
      localJSONObject.put("address", b);
      localJSONObject.put("name", c);
      localJSONObject.put("replyTo", g);
      localJSONObject.put("isDefault", d);
      localJSONObject.put("isCustom", e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      str2 = f;
      str1 = String.valueOf(b);
      if (str1.length() == 0) {}
    }
    for (String str1 = "Could not serialize account with address ".concat(str1);; str1 = new String("Could not serialize account with address "))
    {
      cvm.f(str2, localJSONException, str1, new Object[0]);
      return localJSONObject;
    }
  }
}

/* Location:
 * Qualified Name:     cha
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */