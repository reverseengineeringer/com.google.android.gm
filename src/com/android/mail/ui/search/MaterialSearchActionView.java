package com.android.mail.ui.search;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import btz;
import bub;
import buc;
import buj;
import buo;
import but;
import com.android.mail.ui.MailActivity;
import crj;
import crm;
import crr;
import cxd;
import cxe;
import java.util.Locale;

public class MaterialSearchActionView
  extends LinearLayout
  implements TextWatcher, View.OnClickListener, View.OnKeyListener
{
  public crr a;
  public InputMethodManager b;
  public boolean c;
  public EditText d;
  private final Drawable e;
  private final Drawable f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private boolean o;
  private boolean p;
  private ImageView q;
  private ImageView r;
  
  public MaterialSearchActionView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialSearchActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    e = new ColorDrawable(paramContext.getColor(17170443));
    f = new ColorDrawable(paramContext.getColor(btz.F));
    g = bub.j;
    h = bub.k;
    i = bub.r;
    j = bub.s;
    k = bub.ah;
    l = bub.ai;
    m = paramContext.getColor(btz.J);
    n = paramContext.getColor(17170443);
  }
  
  private final void a(CharSequence paramCharSequence)
  {
    Resources localResources = getResources();
    if ((!c) || (paramCharSequence.length() > 0))
    {
      if (p) {
        r.setImageResource(j);
      }
      for (;;)
      {
        r.setContentDescription(localResources.getString(buj.es));
        o = true;
        return;
        r.setImageResource(i);
      }
    }
    if (p) {
      r.setImageResource(l);
    }
    for (;;)
    {
      r.setContentDescription(localResources.getString(buj.ey));
      o = false;
      return;
      r.setImageResource(k);
    }
  }
  
  public final void a()
  {
    d.setText("");
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    p = paramBoolean;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (paramBoolean)
    {
      setBackgroundDrawable(f);
      q.setImageResource(h);
      d.setTextColor(n);
      if (cxe.a(this))
      {
        int[] arrayOfInt = new int[2];
        getLocationInWindow(arrayOfInt);
        width = (arrayOfInt[0] + getWidth() - paramInt);
      }
    }
    for (;;)
    {
      a(d.getText());
      setLayoutParams(localLayoutParams);
      return;
      width = paramInt;
      continue;
      setBackgroundDrawable(e);
      q.setImageResource(g);
      d.setTextColor(m);
      width = -1;
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == q)
    {
      paramView = a;
      if (crj.c(h))
      {
        a.setResult(-1);
        a.finish();
      }
    }
    do
    {
      return;
      d.a();
      paramView.a(0, true);
      return;
      if (paramView == r)
      {
        if (o)
        {
          d.setText("");
          a.a(1, true);
          return;
        }
        paramView = a;
        Intent localIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        localIntent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault().getLanguage());
        try
        {
          a.startActivityForResult(localIntent, 4);
          return;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          String str = a.getResources().getString(buj.fF);
          Toast.makeText(a, str, 1).show();
          return;
        }
      }
    } while (paramView != d);
    a.a(1, true);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    b = ((InputMethodManager)getContext().getSystemService("input_method"));
    q = ((ImageView)findViewById(buc.en));
    q.setOnClickListener(this);
    d = ((EditText)findViewById(buc.ep));
    d.addTextChangedListener(this);
    d.setOnClickListener(this);
    d.setOnKeyListener(this);
    if (!cxd.e()) {
      d.setCustomSelectionActionModeCallback(new crm(this));
    }
    r = ((ImageView)findViewById(buc.eo));
    r.setOnClickListener(this);
    a(d.getText());
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 66))
    {
      paramView = a.b();
      buo.a().a("search", "search_source", String.valueOf(paramView).concat("_user_input"), 0L);
      a.a(d.getText().toString(), "user_input");
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    crr localcrr = a;
    String str = paramCharSequence.toString();
    e.a(str);
    a(paramCharSequence);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      d.setSelection(d.length());
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.search.MaterialSearchActionView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */