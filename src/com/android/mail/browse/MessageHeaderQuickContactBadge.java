package com.android.mail.browse;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.QuickContactBadge;
import btn;
import buc;
import buo;
import but;
import byz;
import com.android.emailcommon.mail.Address;

public class MessageHeaderQuickContactBadge
  extends byz
{
  private QuickContactBadge f;
  
  public MessageHeaderQuickContactBadge(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageHeaderQuickContactBadge(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MessageHeaderQuickContactBadge(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(Address paramAddress, btn parambtn)
  {
    if (f != null)
    {
      if ((parambtn == null) || (a == null)) {
        break label30;
      }
      f.assignContactUri(a);
    }
    label30:
    while (paramAddress == null) {
      return;
    }
    f.assignContactFromEmail(a, true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    f = ((QuickContactBadge)((View)getParent()).findViewById(buc.cn));
  }
  
  public void onClick(View paramView)
  {
    buo.a().a("quick_contact", "clicked", null, 0L);
    if (f != null) {
      f.onClick(paramView);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageHeaderQuickContactBadge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */