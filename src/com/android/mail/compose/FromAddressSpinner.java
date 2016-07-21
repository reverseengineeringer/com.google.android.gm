package com.android.mail.compose;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import ccl;
import ccm;
import cha;
import com.android.mail.providers.Account;
import com.android.mail.providers.Message;
import hef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FromAddressSpinner
  extends Spinner
  implements AdapterView.OnItemSelectedListener
{
  public cha a;
  public final List<cha> b = new ArrayList();
  public ccl c;
  private List<Account> d;
  
  public FromAddressSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FromAddressSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void a()
  {
    if (a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = b.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        cha localcha = (cha)localIterator.next();
        if ((TextUtils.equals(a.c, c)) && (TextUtils.equals(a.b, b)))
        {
          setSelection(i, true);
          return;
        }
        i += 1;
      }
    }
  }
  
  private final void b()
  {
    if ((d == null) || (d.size() == 0)) {
      return;
    }
    ccm localccm = new ccm(getContext());
    b.clear();
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      b.addAll(localAccount.g());
    }
    localIterator = b.iterator();
    while (localIterator.hasNext()) {
      localccm.add((cha)localIterator.next());
    }
    setAdapter(localccm);
    a();
    setOnItemSelectedListener(this);
  }
  
  public final cha a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        cha localcha = (cha)localIterator.next();
        if (paramString.equals(b)) {
          return localcha;
        }
      }
    }
    return null;
  }
  
  public final void a(int paramInt, Account paramAccount, Account[] paramArrayOfAccount, Message paramMessage)
  {
    Object localObject3 = d;
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((List)localObject2).add(nextc);
      }
    }
    int j = paramArrayOfAccount.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = paramArrayOfAccount[i];
      localObject3 = c;
      ((List)localObject1).add(localObject2);
      i += 1;
    }
    if (paramInt == -1) {}
    for (d = ((List)localObject1);; d = hef.a(paramArrayOfAccount))
    {
      b();
      return;
      paramArrayOfAccount = paramAccount;
      if (paramMessage != null)
      {
        paramArrayOfAccount = paramAccount;
        if (I != null)
        {
          localObject1 = ((List)localObject1).iterator();
          do
          {
            paramArrayOfAccount = paramAccount;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramArrayOfAccount = (Account)((Iterator)localObject1).next();
          } while (!g.equals(I));
        }
      }
    }
  }
  
  public final void a(cha paramcha)
  {
    a = paramcha;
    a();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    paramAdapterView = (cha)getItemAtPosition(paramInt);
    paramView = a;
    if (!b.equals(b))
    {
      paramInt = 1;
      if (a.c.equals(a.c)) {
        break label80;
      }
    }
    for (;;)
    {
      if ((paramInt | i) != 0)
      {
        a = paramAdapterView;
        c.q();
      }
      return;
      paramInt = 0;
      break;
      label80:
      i = 0;
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}

/* Location:
 * Qualified Name:     com.android.mail.compose.FromAddressSpinner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */