package com.android.mail.compose;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import com.android.mail.providers.Account;
import com.android.mail.providers.ReplyFromAccount;
import com.android.mail.utils.AccountUtils;
import com.android.mail.utils.LogTag;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class FromAddressSpinner
  extends Spinner
  implements AdapterView.OnItemSelectedListener
{
  private static final String LOG_TAG = ;
  private ReplyFromAccount mAccount;
  private OnAccountChangedListener mAccountChangedListener;
  private List<Account> mAccounts;
  private final List<ReplyFromAccount> mReplyFromAccounts = Lists.newArrayList();
  
  public FromAddressSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FromAddressSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void selectCurrentAccount()
  {
    if (mAccount == null) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = mReplyFromAccounts.iterator();
      while (localIterator.hasNext())
      {
        ReplyFromAccount localReplyFromAccount = (ReplyFromAccount)localIterator.next();
        if ((TextUtils.equals(mAccount.name, name)) && (TextUtils.equals(mAccount.address, address)))
        {
          setSelection(i, true);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void asyncInitFromSpinner(int paramInt, Account paramAccount, Account[] paramArrayOfAccount)
  {
    if (paramInt == -1) {}
    for (mAccounts = AccountUtils.mergeAccountLists(mAccounts, paramArrayOfAccount, true);; mAccounts = ImmutableList.of(paramAccount))
    {
      initFromSpinner();
      return;
    }
  }
  
  public ReplyFromAccount getCurrentAccount()
  {
    return mAccount;
  }
  
  public ReplyFromAccount getMatchingReplyFromAccount(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = mReplyFromAccounts.iterator();
      while (localIterator.hasNext())
      {
        ReplyFromAccount localReplyFromAccount = (ReplyFromAccount)localIterator.next();
        if (paramString.equals(name)) {
          return localReplyFromAccount;
        }
      }
    }
    return null;
  }
  
  public List<ReplyFromAccount> getReplyFromAccounts()
  {
    return mReplyFromAccounts;
  }
  
  protected void initFromSpinner()
  {
    if ((mAccounts == null) || (mAccounts.size() == 0)) {
      return;
    }
    FromAddressSpinnerAdapter localFromAddressSpinnerAdapter = new FromAddressSpinnerAdapter(getContext());
    mReplyFromAccounts.clear();
    Iterator localIterator = mAccounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      mReplyFromAccounts.addAll(localAccount.getReplyFroms());
    }
    localFromAddressSpinnerAdapter.addAccounts(mReplyFromAccounts);
    setAdapter(localFromAddressSpinnerAdapter);
    selectCurrentAccount();
    setOnItemSelectedListener(this);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ReplyFromAccount)getItemAtPosition(paramInt);
    if (!name.equals(mAccount.name))
    {
      mAccount = paramAdapterView;
      mAccountChangedListener.onAccountChanged();
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void setCurrentAccount(ReplyFromAccount paramReplyFromAccount)
  {
    mAccount = paramReplyFromAccount;
    selectCurrentAccount();
  }
  
  public void setOnAccountChangedListener(OnAccountChangedListener paramOnAccountChangedListener)
  {
    mAccountChangedListener = paramOnAccountChangedListener;
  }
  
  public static abstract interface OnAccountChangedListener
  {
    public abstract void onAccountChanged();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.FromAddressSpinner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */