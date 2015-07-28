package com.android.mail.compose;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.android.mail.providers.Message;
import com.android.mail.utils.Utils;
import java.text.DateFormat;
import java.util.Date;

class QuotedTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private static final int HEADER_SEPARATOR_LENGTH = "<br type='attribution'>".length();
  private static String sQuoteBegin;
  private boolean mIncludeText = true;
  private CharSequence mQuotedText;
  private WebView mQuotedTextWebView;
  private Button mRespondInlineButton;
  private RespondInlineListener mRespondInlineListener;
  private CheckBox mShowHideCheckBox;
  private ShowHideQuotedTextListener mShowHideListener;
  
  public QuotedTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QuotedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public QuotedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130968673, this);
    mQuotedTextWebView = ((WebView)findViewById(2131755236));
    Utils.restrictWebView(mQuotedTextWebView);
    mQuotedTextWebView.getSettings().setBlockNetworkLoads(true);
    mShowHideCheckBox = ((CheckBox)findViewById(2131755232));
    mShowHideCheckBox.setChecked(true);
    mShowHideCheckBox.setOnClickListener(this);
    sQuoteBegin = paramContext.getResources().getString(2131493126);
    findViewById(2131755233).setOnClickListener(this);
    mRespondInlineButton = ((Button)findViewById(2131755234));
    if (mRespondInlineButton != null) {
      mRespondInlineButton.setEnabled(false);
    }
  }
  
  public static boolean containsQuotedText(String paramString)
  {
    return paramString.indexOf(sQuoteBegin) >= 0;
  }
  
  public static int findQuotedTextIndex(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return -1;
    }
    return paramCharSequence.toString().indexOf(sQuoteBegin);
  }
  
  private String getHtmlText(Message paramMessage)
  {
    if (bodyHtml != null) {
      return bodyHtml;
    }
    if (bodyText != null) {
      return Html.toHtml(new SpannedString(bodyText));
    }
    return "";
  }
  
  public static int getQuotedTextOffset(String paramString)
  {
    return paramString.indexOf("<br type='attribution'>") + HEADER_SEPARATOR_LENGTH;
  }
  
  private void populateData()
  {
    String str1 = getContext().getResources().getString(2131492870);
    String str2 = getContext().getResources().getString(2131492871);
    str1 = "<head><style type=\"text/css\">* body { background-color: " + str1 + "; color: " + str2 + "; }</style></head>" + mQuotedText.toString();
    mQuotedTextWebView.loadDataWithBaseURL(null, str1, "text/html", "utf-8", null);
  }
  
  private void respondInline()
  {
    Object localObject = Utils.convertHtmlToPlainText(getQuotedText().toString());
    if (mRespondInlineListener != null) {
      mRespondInlineListener.onRespondInline("\n" + (String)localObject);
    }
    updateCheckedState(false);
    mRespondInlineButton.setVisibility(8);
    localObject = findViewById(2131755228);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void setQuotedText(CharSequence paramCharSequence)
  {
    mQuotedText = paramCharSequence;
    populateData();
    if (mRespondInlineButton != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        mRespondInlineButton.setVisibility(0);
        mRespondInlineButton.setEnabled(true);
        mRespondInlineButton.setOnClickListener(this);
      }
    }
    else {
      return;
    }
    mRespondInlineButton.setVisibility(8);
    mRespondInlineButton.setEnabled(false);
  }
  
  private void updateQuotedTextVisibility(boolean paramBoolean)
  {
    WebView localWebView = mQuotedTextWebView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localWebView.setVisibility(i);
      mIncludeText = paramBoolean;
      return;
    }
  }
  
  public void allowQuotedText(boolean paramBoolean)
  {
    View localView = findViewById(2131755231);
    if (localView != null) {
      if (!paramBoolean) {
        break label23;
      }
    }
    label23:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void allowRespondInline(boolean paramBoolean)
  {
    Button localButton;
    if (mRespondInlineButton != null)
    {
      localButton = mRespondInlineButton;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      return;
    }
  }
  
  public CharSequence getQuotedText()
  {
    return mQuotedText;
  }
  
  public CharSequence getQuotedTextIfIncluded()
  {
    if (mIncludeText) {
      return mQuotedText;
    }
    return null;
  }
  
  public boolean isTextIncluded()
  {
    return mIncludeText;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131755234: 
      respondInline();
      return;
    case 2131755232: 
      updateCheckedState(mShowHideCheckBox.isChecked());
      return;
    }
    if (!mShowHideCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      updateCheckedState(bool);
      return;
    }
  }
  
  public void setQuotedText(int paramInt, Message paramMessage, boolean paramBoolean)
  {
    setVisibility(0);
    String str = getHtmlText(paramMessage);
    StringBuffer localStringBuffer = new StringBuffer();
    DateFormat localDateFormat = DateFormat.getDateTimeInstance(2, 3);
    Date localDate = new Date(dateReceivedMs);
    Resources localResources = getContext().getResources();
    if ((paramInt == 0) || (paramInt == 1))
    {
      localStringBuffer.append(sQuoteBegin);
      localStringBuffer.append(String.format(localResources.getString(2131492905), new Object[] { localDateFormat.format(localDate), Utils.cleanUpString(from, true) }));
      localStringBuffer.append("<br type='attribution'>");
      localStringBuffer.append("<blockquote class=\"quote\" style=\"margin:0 0 0 .8ex;border-left:1px #ccc solid;padding-left:1ex\">");
      localStringBuffer.append(str);
      localStringBuffer.append("</blockquote>");
      localStringBuffer.append("</div>");
    }
    for (;;)
    {
      setQuotedText(localStringBuffer);
      allowQuotedText(paramBoolean);
      allowRespondInline(true);
      return;
      if (paramInt == 2)
      {
        localStringBuffer.append(sQuoteBegin);
        localStringBuffer.append(String.format(localResources.getString(2131492906), new Object[] { Utils.cleanUpString(from, true), localDateFormat.format(localDate), Utils.cleanUpString(subject, false), Utils.cleanUpString(to, true) }));
        paramMessage = cc;
        localStringBuffer.append(String.format(localResources.getString(2131492907), new Object[] { Utils.cleanUpString(paramMessage, true) }));
        localStringBuffer.append("<br type='attribution'>");
        localStringBuffer.append("<blockquote class=\"quote\" style=\"margin:0 0 0 .8ex;border-left:1px #ccc solid;padding-left:1ex\">");
        localStringBuffer.append(str);
        localStringBuffer.append("</blockquote>");
        localStringBuffer.append("</div>");
      }
    }
  }
  
  public void setQuotedTextFromDraft(CharSequence paramCharSequence, boolean paramBoolean)
  {
    boolean bool = false;
    setVisibility(0);
    setQuotedText(paramCharSequence);
    if (!paramBoolean) {
      bool = true;
    }
    allowQuotedText(bool);
    allowRespondInline(true);
  }
  
  public void setRespondInlineListener(RespondInlineListener paramRespondInlineListener)
  {
    mRespondInlineListener = paramRespondInlineListener;
  }
  
  public void setUpperDividerVisible(boolean paramBoolean)
  {
    View localView = findViewById(2131755229);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void updateCheckedState(boolean paramBoolean)
  {
    mShowHideCheckBox.setChecked(paramBoolean);
    updateQuotedTextVisibility(paramBoolean);
    if (mShowHideListener != null) {
      mShowHideListener.onShowHideQuotedText(paramBoolean);
    }
  }
  
  public static abstract interface RespondInlineListener
  {
    public abstract void onRespondInline(String paramString);
  }
  
  public static abstract interface ShowHideQuotedTextListener
  {
    public abstract void onShowHideQuotedText(boolean paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.QuotedTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */