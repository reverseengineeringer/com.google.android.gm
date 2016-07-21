package com.google.android.gm;

import android.content.Intent;
import android.os.IBinder;
import bap;
import com.android.mail.ui.MailActivity;
import cvm;
import fjt;
import fkc;

public class GcmImapPurgeService
  extends fjt
{
  public final int a(fkc paramfkc)
  {
    if (MailActivity.s)
    {
      cvm.c(cvm.a, "Can't perform purge, scheduling retry", new Object[0]);
      return 1;
    }
    bap.a(this);
    return 0;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GcmImapPurgeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */