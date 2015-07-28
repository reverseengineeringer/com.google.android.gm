package com.google.android.gm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.android.mail.utils.AccountUtils;
import com.google.android.gm.ui.FolderSelectionActivityGmail;
import com.google.android.gm.ui.MailboxSelectionActivityGmail;

public class CreateShortcutActivityGmail
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = AccountUtils.getSyncingAccounts(this);
    Intent localIntent = getIntent();
    if ((paramBundle != null) && (paramBundle.length == 1))
    {
      localIntent.setClass(this, FolderSelectionActivityGmail.class);
      localIntent.setFlags(1107296256);
      localIntent.setAction("android.intent.action.CREATE_SHORTCUT");
      localIntent.putExtra("account-shortcut", paramBundle[0]);
    }
    for (;;)
    {
      startActivity(localIntent);
      finish();
      return;
      localIntent.setClass(this, MailboxSelectionActivityGmail.class);
      localIntent.setFlags(33554432);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.CreateShortcutActivityGmail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */