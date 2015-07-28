package com.android.mail;

import android.database.DataSetObserver;

public abstract interface ContactInfoSource
{
  public abstract ContactInfo getContactInfo(String paramString);
  
  public abstract void registerObserver(DataSetObserver paramDataSetObserver);
  
  public abstract void unregisterObserver(DataSetObserver paramDataSetObserver);
}

/* Location:
 * Qualified Name:     com.android.mail.ContactInfoSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */