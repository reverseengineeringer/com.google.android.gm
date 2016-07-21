package com.android.mail.browse;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;

public class EmlTempFileDeletionService
  extends IntentService
{
  public EmlTempFileDeletionService()
  {
    super("EmlTempFileDeletionService");
  }
  
  public EmlTempFileDeletionService(String paramString)
  {
    super(paramString);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if ("android.intent.action.DELETE".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getData();
      getContentResolver().delete(paramIntent, null, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.EmlTempFileDeletionService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */