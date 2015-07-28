package com.android.mail.providers;

import android.net.Uri;
import android.text.TextUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReplyFromAccount
  implements Serializable
{
  private static final String LOG_TAG = ;
  private static final long serialVersionUID = 1L;
  public Account account;
  public String address;
  Uri baseAccountUri;
  public boolean isCustomFrom;
  public boolean isDefault;
  public String name;
  public String replyTo;
  
  public ReplyFromAccount(Account paramAccount, Uri paramUri, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    account = paramAccount;
    baseAccountUri = paramUri;
    address = paramString1;
    name = paramString2;
    replyTo = paramString3;
    isDefault = paramBoolean1;
    isCustomFrom = paramBoolean2;
  }
  
  public static ReplyFromAccount deserialize(Account paramAccount, String paramString)
  {
    try
    {
      paramAccount = deserialize(paramAccount, new JSONObject(paramString));
      return paramAccount;
    }
    catch (JSONException paramAccount)
    {
      LogUtils.wtf(LOG_TAG, paramAccount, "Could not deserialize replyfromaccount", new Object[0]);
    }
    return null;
  }
  
  public static ReplyFromAccount deserialize(Account paramAccount, JSONObject paramJSONObject)
  {
    try
    {
      paramAccount = new ReplyFromAccount(paramAccount, Utils.getValidUri(paramJSONObject.getString("baseAccountUri")), paramJSONObject.getString("address"), paramJSONObject.getString("name"), paramJSONObject.getString("replyTo"), paramJSONObject.getBoolean("isDefault"), paramJSONObject.getBoolean("isCustom"));
      return paramAccount;
    }
    catch (JSONException paramAccount)
    {
      LogUtils.wtf(LOG_TAG, paramAccount, "Could not deserialize replyfromaccount", new Object[0]);
    }
    return null;
  }
  
  public static boolean isCustomFrom(String paramString, List<ReplyFromAccount> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ReplyFromAccount localReplyFromAccount = (ReplyFromAccount)paramList.next();
      if ((TextUtils.equals(address, paramString)) && (isCustomFrom)) {
        return true;
      }
    }
    return false;
  }
  
  public JSONObject serialize()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("baseAccountUri", baseAccountUri);
      localJSONObject.put("address", address);
      localJSONObject.put("name", name);
      localJSONObject.put("replyTo", replyTo);
      localJSONObject.put("isDefault", isDefault);
      localJSONObject.put("isCustom", isCustomFrom);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      LogUtils.wtf(LOG_TAG, localJSONException, "Could not serialize account with name " + name, new Object[0]);
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.ReplyFromAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */