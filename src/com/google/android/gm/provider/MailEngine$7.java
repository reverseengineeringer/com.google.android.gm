package com.google.android.gm.provider;

import android.content.Context;

class MailEngine$7
  implements Runnable
{
  MailEngine$7(MailEngine paramMailEngine, Context paramContext) {}
  
  public void run()
  {
    String[] arrayOfString = val$context.fileList();
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i];
      if (!str.startsWith("gmail")) {}
      for (;;)
      {
        i += 1;
        break;
        LogUtils.d("Gmail", "Cleaning up old temp file (do we have a leak?): %s", new Object[] { str });
        val$context.deleteFile(str);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */