package com.android.mail.text;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import cbk;
import com.android.mail.providers.Account;
import cvm;

public class EmailAddressSpan
  extends URLSpan
{
  private final Account a;
  private final String b;
  
  public EmailAddressSpan(Account paramAccount, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getContext();
    Account localAccount = a;
    String str = b;
    cvm.c(cbk.n, "[ComposeActivity init] composeToAddress", new Object[0]);
    cbk.a(paramView, localAccount, null, -1, str, null, null, null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.text.EmailAddressSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */