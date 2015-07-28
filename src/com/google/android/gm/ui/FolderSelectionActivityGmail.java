package com.google.android.gm.ui;

import android.content.Intent;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.ui.FolderSelectionActivity;
import com.android.mail.widget.BaseGmailWidgetProvider;

public class FolderSelectionActivityGmail
  extends FolderSelectionActivity
{
  protected void createWidget(int paramInt, Account paramAccount, Folder paramFolder)
  {
    BaseGmailWidgetProvider.updateWidget(this, paramInt, paramAccount, paramFolder);
    paramAccount = new Intent();
    paramAccount.putExtra("appWidgetId", paramInt);
    setResult(-1, paramAccount);
    finish();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.FolderSelectionActivityGmail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */