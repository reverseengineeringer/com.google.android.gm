package com.android.mail.compose;

import android.content.Context;
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
import buc;
import bue;
import buo;
import but;
import ccp;
import cxa;

public class QuotedTextView
  extends LinearLayout
  implements View.OnClickListener
{
  public CharSequence a;
  public boolean b = true;
  public ccp c;
  private final WebView d;
  private final CheckBox e;
  private final Button f;
  
  public QuotedTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QuotedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QuotedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(bue.ac, this);
    d = ((WebView)findViewById(buc.dK));
    cxa.a(d);
    d.getSettings().setBlockNetworkLoads(true);
    e = ((CheckBox)findViewById(buc.bQ));
    e.setChecked(true);
    e.setOnClickListener(this);
    f = ((Button)findViewById(buc.ef));
    if (f != null) {
      f.setEnabled(false);
    }
  }
  
  public final void a()
  {
    if (f != null) {
      f.setVisibility(0);
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    setVisibility(0);
    a = paramCharSequence;
    d.loadDataWithBaseURL(null, a.toString(), "text/html", "utf-8", null);
    if (f != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        f.setVisibility(0);
        f.setEnabled(true);
        f.setOnClickListener(this);
      }
    }
    else {
      return;
    }
    f.setVisibility(8);
    f.setEnabled(false);
  }
  
  public final void a(boolean paramBoolean)
  {
    CheckBox localCheckBox;
    if (e != null)
    {
      localCheckBox = e;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localCheckBox.setVisibility(i);
      return;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    e.setChecked(paramBoolean);
    WebView localWebView = d;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localWebView.setVisibility(i);
      b = paramBoolean;
      return;
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    View localView = findViewById(buc.fD);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == buc.ef)
    {
      paramView = cxa.b(a.toString());
      if (c != null)
      {
        localccp = c;
        paramView = String.valueOf(paramView);
        if (paramView.length() != 0)
        {
          paramView = "\n".concat(paramView);
          localccp.b(paramView);
        }
      }
      else
      {
        b(false);
        f.setVisibility(8);
        paramView = findViewById(buc.dH);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        buo.a().a("quotedtextview", "respond_inline", "", 0L);
      }
    }
    while (i != buc.bQ) {
      for (;;)
      {
        ccp localccp;
        return;
        paramView = new String("\n");
      }
    }
    b(e.isChecked());
    buo.a().a("quotedtextview", "hide_quoted_text", "", 0L);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.QuotedTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */