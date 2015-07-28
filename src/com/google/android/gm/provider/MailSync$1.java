package com.google.android.gm.provider;

import android.content.Context;
import java.io.FilterInputStream;
import java.io.IOException;

class MailSync$1
  extends FilterInputStream
{
  public void close()
    throws IOException
  {
    try
    {
      super.close();
      return;
    }
    finally
    {
      MailSync.access$000(this$0).deleteFile(val$tempFile);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */