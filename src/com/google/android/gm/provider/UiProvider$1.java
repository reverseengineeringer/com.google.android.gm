package com.google.android.gm.provider;

import android.accounts.Account;
import android.content.Context;
import com.google.android.gm.AccountHelper.AccountResultsCallback;
import java.util.Set;

class UiProvider$1
  implements AccountHelper.AccountResultsCallback
{
  UiProvider$1(UiProvider paramUiProvider, Context paramContext) {}
  
  public void exec(Account[] paramArrayOfAccount)
  {
    if (paramArrayOfAccount.length > 0)
    {
      int j = paramArrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        Account localAccount = paramArrayOfAccount[i];
        LogUtils.d("Gmail", "Getting MailEngine for account: %s", new Object[] { name });
        UiProvider.access$200(this$0).add(name);
        MailEngine.getOrMakeMailEngineAsync(val$context, name, this$0);
        i += 1;
      }
    }
    UiProvider.access$300(this$0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.UiProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */