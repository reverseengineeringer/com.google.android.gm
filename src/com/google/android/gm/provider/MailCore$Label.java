package com.google.android.gm.provider;

public class MailCore$Label
{
  public String canonicalName;
  public long id;
  
  public MailCore$Label(long paramLong, String paramString)
  {
    id = paramLong;
    canonicalName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Label)) {}
    do
    {
      return false;
      paramObject = (Label)paramObject;
    } while ((id != id) || (!canonicalName.equals(canonicalName)));
    return true;
  }
  
  public int hashCode()
  {
    return (int)id;
  }
  
  public String toString()
  {
    return id + "/" + canonicalName;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailCore.Label
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */