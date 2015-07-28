package com.google.android.gm.provider;

import android.text.TextUtils.SimpleStringSplitter;

class Gmail$CommaStringSplitter
  extends TextUtils.SimpleStringSplitter
{
  public Gmail$CommaStringSplitter()
  {
    super(',');
  }
  
  public void setString(String paramString)
  {
    super.setString(paramString.substring(1));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Gmail.CommaStringSplitter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */