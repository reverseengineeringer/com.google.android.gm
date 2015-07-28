package com.android.mail.browse;

import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.android.mail.providers.Message;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;

public class MessageInviteView
  extends LinearLayout
  implements View.OnClickListener
{
  private InviteCommandHandler mCommandHandler = new InviteCommandHandler();
  private final Context mContext;
  private Message mMessage;
  
  public MessageInviteView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageInviteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mContext = paramContext;
  }
  
  public void bind(Message paramMessage)
  {
    mMessage = paramMessage;
  }
  
  public void onClick(View paramView)
  {
    ContentValues localContentValues = null;
    switch (paramView.getId())
    {
    default: 
      paramView = localContentValues;
    }
    for (;;)
    {
      if (paramView != null)
      {
        localContentValues = new ContentValues();
        LogUtils.w("UnifiedEmail", "SENDING INVITE COMMAND, VALUE=%s", new Object[] { paramView });
        localContentValues.put("respond", paramView);
        mCommandHandler.sendCommand(localContentValues);
      }
      return;
      paramView = localContentValues;
      if (!Utils.isEmpty(mMessage.eventIntentUri))
      {
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setData(mMessage.eventIntentUri);
        mContext.startActivity(paramView);
        paramView = localContentValues;
        continue;
        paramView = Integer.valueOf(1);
        continue;
        paramView = Integer.valueOf(2);
        continue;
        paramView = Integer.valueOf(3);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131755151).setOnClickListener(this);
    findViewById(2131755152).setOnClickListener(this);
    findViewById(2131755153).setOnClickListener(this);
    findViewById(2131755154).setOnClickListener(this);
  }
  
  private class InviteCommandHandler
    extends AsyncQueryHandler
  {
    public InviteCommandHandler()
    {
      super();
    }
    
    public void sendCommand(ContentValues paramContentValues)
    {
      startUpdate(0, null, mMessage.uri, paramContentValues, null, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageInviteView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */