package com.google.android.gm.provider;

public abstract interface MailCoreLabelAccess
{
  public abstract MailCore.Label getLabelOrNull(String paramString);
  
  public abstract MailCore.Label getLabelOrThrow(String paramString);
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailCoreLabelAccess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */