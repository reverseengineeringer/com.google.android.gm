package com.google.android.gm.preference;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import com.google.android.gm.AccountHelper;
import com.google.android.gm.persistence.Persistence;
import java.io.IOException;

class GmailPreferenceActivity$1
  implements AccountManagerCallback<Account[]>
{
  GmailPreferenceActivity$1(GmailPreferenceActivity paramGmailPreferenceActivity) {}
  
  public void run(AccountManagerFuture<Account[]> paramAccountManagerFuture)
  {
    try
    {
      GmailPreferenceActivity localGmailPreferenceActivity = this$0;
      GmailPreferenceActivity.access$002(this$0, AccountHelper.mergeAccountLists(GmailPreferenceActivity.access$000(this$0), (Account[])paramAccountManagerFuture.getResult(), true));
      Persistence.getInstance().cacheConfiguredGoogleAccounts(localGmailPreferenceActivity, false, GmailPreferenceActivity.access$000(this$0));
      this$0.invalidateHeaders();
      return;
    }
    catch (OperationCanceledException paramAccountManagerFuture) {}catch (IOException paramAccountManagerFuture) {}catch (AuthenticatorException paramAccountManagerFuture) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.GmailPreferenceActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */