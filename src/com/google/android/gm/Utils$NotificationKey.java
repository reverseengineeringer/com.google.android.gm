package com.google.android.gm;

import android.text.TextUtils;

class Utils$NotificationKey
{
  public final String account;
  public final String label;
  
  public Utils$NotificationKey(String paramString1, String paramString2)
  {
    account = paramString1;
    label = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NotificationKey)) {}
    do
    {
      return false;
      paramObject = (NotificationKey)paramObject;
    } while ((!TextUtils.equals(account, account)) || (!TextUtils.equals(label, label)));
    return true;
  }
  
  public int hashCode()
  {
    return account.hashCode() ^ label.hashCode();
  }
  
  public String toString()
  {
    return account + " " + label;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.Utils.NotificationKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */