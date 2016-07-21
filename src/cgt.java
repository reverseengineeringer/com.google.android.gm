import android.net.Uri;
import com.android.mail.providers.Account;
import com.android.mail.providers.Settings;
import org.json.JSONException;
import org.json.JSONObject;

final class cgt
{
  final Account a;
  final Uri b;
  
  public cgt(Account paramAccount, Uri paramUri)
  {
    a = paramAccount;
    b = paramUri;
  }
  
  public cgt(JSONObject paramJSONObject)
  {
    a = Account.a(paramJSONObject.getString("acct"));
    if (a == null)
    {
      paramJSONObject = String.valueOf(paramJSONObject);
      throw new IllegalArgumentException(String.valueOf(paramJSONObject).length() + 98 + "AccountCacheEntry de-serializing failed. Account object could not be created from the JSONObject: " + paramJSONObject);
    }
    if (a.z == Settings.a)
    {
      paramJSONObject = String.valueOf(paramJSONObject);
      throw new IllegalArgumentException(String.valueOf(paramJSONObject).length() + 92 + "AccountCacheEntry de-serializing failed. Settings could not be created from the JSONObject: " + paramJSONObject);
    }
    paramJSONObject = paramJSONObject.optString("queryUri", null);
    if (paramJSONObject != null)
    {
      b = Uri.parse(paramJSONObject);
      return;
    }
    b = null;
  }
  
  public final JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("acct", a.a()).putOpt("queryUri", b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalArgumentException(localJSONException);
    }
  }
}

/* Location:
 * Qualified Name:     cgt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */