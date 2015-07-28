package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.mail.providers.Address;
import com.android.mail.providers.Message;

public class SpamWarningView
  extends RelativeLayout
  implements View.OnClickListener
{
  private final int mHighWarningColor = getResources().getColor(2131296295);
  private final int mLowWarningColor = getResources().getColor(2131296288);
  private ImageView mSpamWarningIcon;
  private TextView mSpamWarningLink;
  private TextView mSpamWarningText;
  
  public SpamWarningView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SpamWarningView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
  }
  
  public void onFinishInflate()
  {
    setOnClickListener(this);
    mSpamWarningIcon = ((ImageView)findViewById(2131755160));
    mSpamWarningText = ((TextView)findViewById(2131755161));
    mSpamWarningLink = ((TextView)findViewById(2131755162));
    mSpamWarningLink.setOnClickListener(this);
  }
  
  public void showSpamWarning(Message paramMessage, Address paramAddress)
  {
    setVisibility(0);
    paramAddress = paramAddress.getAddress();
    String str = paramAddress.substring(paramAddress.indexOf('@') + 1);
    mSpamWarningText.setText(Html.fromHtml(String.format(spamWarningString, new Object[] { paramAddress, str })));
    if (spamWarningLevel == 2)
    {
      mSpamWarningText.setTextColor(mHighWarningColor);
      mSpamWarningIcon.setImageResource(2130837549);
    }
    for (;;)
    {
      switch (spamLinkType)
      {
      default: 
        return;
        mSpamWarningText.setTextColor(mLowWarningColor);
        mSpamWarningIcon.setImageResource(2130837548);
      }
    }
    mSpamWarningLink.setVisibility(8);
    return;
    mSpamWarningLink.setVisibility(0);
    mSpamWarningLink.setText(2131493107);
    return;
    mSpamWarningLink.setVisibility(0);
    mSpamWarningLink.setText(2131492932);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SpamWarningView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */