package com.android.mail.ui;

import android.database.DataSetObserver;
import com.android.mail.providers.Account;

public abstract interface AccountController
{
  public abstract Account getAccount();
  
  public abstract void registerAccountObserver(DataSetObserver paramDataSetObserver);
  
  public abstract void unregisterAccountObserver(DataSetObserver paramDataSetObserver);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AccountController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */