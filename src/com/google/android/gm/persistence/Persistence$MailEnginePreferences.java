package com.google.android.gm.persistence;

import android.content.Context;
import com.google.android.gm.provider.MailEngine.Preferences;

class Persistence$MailEnginePreferences
  implements MailEngine.Preferences
{
  private final Context mContext;
  
  Persistence$MailEnginePreferences(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public boolean getFullTextSearchEnabled(String paramString)
  {
    return Persistence.getInstance().fullTextSearchEnabled(mContext);
  }
  
  public boolean getPrefetchAttachments(String paramString)
  {
    return Persistence.getInstance().getPrefetchAttachments(mContext, paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.persistence.Persistence.MailEnginePreferences
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */