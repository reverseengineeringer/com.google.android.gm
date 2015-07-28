package com.android.mail.compose;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.AttachmentUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

class AttachmentComposeView
  extends LinearLayout
{
  private static final String LOG_TAG = ;
  private final Attachment mAttachment;
  
  public AttachmentComposeView(Context paramContext, Attachment paramAttachment)
  {
    super(paramContext);
    mAttachment = paramAttachment;
    if (LogUtils.isLoggable(LOG_TAG, 3)) {}
    try
    {
      String str = paramAttachment.toJSON().toString(2);
      paramAttachment = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramAttachment = paramAttachment.toString();
      }
    }
    LogUtils.d(LOG_TAG, "attachment view: %s", new Object[] { paramAttachment });
    LayoutInflater.from(getContext()).inflate(2130968591, this);
    populateAttachmentData(paramContext);
  }
  
  private void populateAttachmentData(Context paramContext)
  {
    ((TextView)findViewById(2131755012)).setText(mAttachment.name);
    if (mAttachment.size > 0)
    {
      ((TextView)findViewById(2131755055)).setText(AttachmentUtils.convertToHumanReadableSize(paramContext, mAttachment.size));
      return;
    }
    ((TextView)findViewById(2131755055)).setVisibility(8);
  }
  
  public void addDeleteListener(View.OnClickListener paramOnClickListener)
  {
    ((ImageButton)findViewById(2131755056)).setOnClickListener(paramOnClickListener);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.AttachmentComposeView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */