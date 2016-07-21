package com.android.mail.browse;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import buc;
import bzi;
import caq;
import com.android.mail.providers.Message;
import cvl;
import cvm;
import cxa;

public class MessageInviteView
  extends LinearLayout
  implements View.OnClickListener
{
  private static final String b = cvl.a;
  Message a;
  private final Context c;
  private final bzi d = new bzi(this);
  
  public MessageInviteView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageInviteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c = paramContext;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == buc.co)
    {
      if (cxa.b(a.J)) {
        break label191;
      }
      paramView = new Intent("android.intent.action.VIEW");
      paramView.setData(a.J);
    }
    for (;;)
    {
      try
      {
        c.startActivity(paramView);
        paramView = null;
      }
      catch (ActivityNotFoundException paramView)
      {
        ContentValues localContentValues;
        new caq().show(((Activity)getContext()).getFragmentManager(), "calendar-not-installed");
        paramView = null;
        continue;
      }
      if (paramView != null)
      {
        localContentValues = new ContentValues();
        cvm.b(b, "SENDING INVITE COMMAND, VALUE=%s", new Object[] { paramView });
        localContentValues.put("respond", paramView);
        paramView = d;
        paramView.startUpdate(0, null, a.a.f, localContentValues, null, null);
      }
      return;
      if (i == buc.f) {
        paramView = Integer.valueOf(1);
      } else if (i == buc.fl) {
        paramView = Integer.valueOf(2);
      } else if (i == buc.aU) {
        paramView = Integer.valueOf(3);
      } else {
        label191:
        paramView = null;
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(buc.co).setOnClickListener(this);
    findViewById(buc.f).setOnClickListener(this);
    findViewById(buc.fl).setOnClickListener(this);
    findViewById(buc.aU).setOnClickListener(this);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageInviteView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */