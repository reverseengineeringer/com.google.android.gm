package com.android.mail.browse;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import buc;
import buo;
import but;
import bvz;
import bwx;
import bxq;
import bxu;
import cbk;
import com.android.mail.providers.Account;
import com.android.mail.providers.Message;
import cvl;
import cvm;
import gnr;
import gnu;
import hlg;

public class ConversationFooterView
  extends LinearLayout
  implements View.OnClickListener
{
  public static final String a = cvl.a;
  public bxq b;
  public bvz c;
  public bwx d;
  private View e;
  
  public ConversationFooterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ConversationFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ConversationFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final Account a()
  {
    if (c != null) {
      return c.a();
    }
    return null;
  }
  
  public final void a(bxq parambxq)
  {
    int i = 0;
    b = parambxq;
    if (b == null)
    {
      cvm.c(a, "ignoring conversation footer tap on unbound view", new Object[0]);
      return;
    }
    parambxq = b.e;
    if (parambxq == null)
    {
      cvm.c(a, "ignoring conversation footer tap on null header item", new Object[0]);
      return;
    }
    parambxq = f;
    if (parambxq == null)
    {
      cvm.c(a, "ignoring conversation footer tap on null message", new Object[0]);
      return;
    }
    View localView = e;
    if (parambxq.p()) {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public void onClick(View paramView)
  {
    if (b == null)
    {
      cvm.c(a, "ignoring conversation footer tap on unbound view", new Object[0]);
      return;
    }
    Object localObject = b.e;
    if (localObject == null)
    {
      cvm.c(a, "ignoring conversation footer tap on null header item", new Object[0]);
      return;
    }
    localObject = f;
    if (localObject == null)
    {
      cvm.c(a, "ignoring conversation footer tap on null message", new Object[0]);
      return;
    }
    int i = paramView.getId();
    if (i == buc.dU)
    {
      d.b_(paramView);
      cbk.c(getContext(), a(), (Message)localObject);
      paramView = "reply";
    }
    for (;;)
    {
      buo.a().a("conversation_footer_click", paramView, null, 0L);
      return;
      if (i == buc.dT)
      {
        d.b_(paramView);
        cbk.d(getContext(), a(), (Message)localObject);
        paramView = "reply_all";
      }
      else if (i == buc.bH)
      {
        d.b_(paramView);
        cbk.e(getContext(), a(), (Message)localObject);
        paramView = "forward";
      }
      else
      {
        paramView = "lolwut";
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    e = findViewById(buc.bF);
    View localView1 = findViewById(buc.dU);
    View localView2 = findViewById(buc.dT);
    View localView3 = findViewById(buc.bH);
    gnu.a(localView1, new gnr(hlg.i));
    gnu.a(localView2, new gnr(hlg.h));
    gnu.a(localView3, new gnr(hlg.q));
    localView1.setOnClickListener(this);
    localView2.setOnClickListener(this);
    localView3.setOnClickListener(this);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationFooterView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */