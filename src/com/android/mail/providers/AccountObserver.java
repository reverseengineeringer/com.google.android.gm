package com.android.mail.providers;

import android.database.DataSetObserver;
import com.android.mail.ui.AccountController;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;

public abstract class AccountObserver
  extends DataSetObserver
{
  private static final String LOG_TAG = ;
  private AccountController mController;
  
  public Account initialize(AccountController paramAccountController)
  {
    if (paramAccountController == null) {
      LogUtils.wtf(LOG_TAG, "AccountObserver initialized with null controller!", new Object[0]);
    }
    mController = paramAccountController;
    mController.registerAccountObserver(this);
    return mController.getAccount();
  }
  
  public final void onChanged()
  {
    if (mController == null) {
      return;
    }
    onChanged(mController.getAccount());
  }
  
  public abstract void onChanged(Account paramAccount);
  
  public void unregisterAndDestroy()
  {
    if (mController == null) {
      return;
    }
    mController.unregisterAccountObserver(this);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.AccountObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */