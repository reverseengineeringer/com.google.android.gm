package com.google.android.gm.ui;

import android.content.Intent;
import cnz;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.widget.BaseGmailWidgetProviderService;
import cus;
import java.util.ArrayList;

public class FolderSelectionActivityGmail
  extends cnz
{
  protected final ArrayList<Integer> A()
  {
    ArrayList localArrayList = super.A();
    if (n) {
      localArrayList.add(Integer.valueOf(512));
    }
    return localArrayList;
  }
  
  protected final void a(int paramInt, Account paramAccount, Folder paramFolder)
  {
    BaseGmailWidgetProviderService.a(this, paramInt, paramAccount, p, e, c.b, h, d);
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