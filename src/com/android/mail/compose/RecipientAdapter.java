package com.android.mail.compose;

import android.content.Context;
import com.android.ex.chips.BaseRecipientAdapter;
import com.android.mail.providers.Account;

public class RecipientAdapter
  extends BaseRecipientAdapter
{
  public RecipientAdapter(Context paramContext, Account paramAccount)
  {
    super(paramContext);
    setAccount(paramAccount);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.RecipientAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */