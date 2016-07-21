package com.android.email.activity.setup;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import are;
import arf;
import arh;
import aur;
import aus;
import aut;
import awj;
import bcb;
import com.android.emailcommon.provider.Credential;
import com.android.emailcommon.provider.HostAuth;

public class AuthenticationView
  extends LinearLayout
  implements View.OnClickListener
{
  public bcb a;
  public aus b;
  public EditText c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private TextView h;
  private View i;
  private TextView j;
  private View k;
  private CheckBox l;
  private View m;
  
  public AuthenticationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AuthenticationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AuthenticationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(arf.x, this, true);
  }
  
  private final void e()
  {
    h.setVisibility(8);
    m.setVisibility(8);
    i.setVisibility(8);
    k.setVisibility(8);
    l.setVisibility(8);
    j.setVisibility(8);
    if (d) {
      if (e)
      {
        j.setVisibility(0);
        h.setVisibility(0);
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(b())) {
        break;
      }
      k.setVisibility(0);
      i.setVisibility(0);
      if (!g) {
        l.setVisibility(0);
      }
    } while (!TextUtils.isEmpty(c.getText()));
    c.requestFocus();
    return;
    m.setVisibility(0);
    h.setVisibility(0);
  }
  
  public final void a(boolean paramBoolean, HostAuth paramHostAuth)
  {
    d = paramBoolean;
    if (d)
    {
      Credential localCredential = paramHostAuth.a(getContext());
      if (localCredential != null)
      {
        e = true;
        a = awj.a(getContext()).c(c);
      }
    }
    for (;;)
    {
      c.setText(g);
      if ((d) && (a != null)) {
        j.setText(getContext().getString(arh.cx, new Object[] { a.b }));
      }
      e();
      c();
      return;
      e = false;
      continue;
      e = false;
    }
  }
  
  public final boolean a()
  {
    if ((d & e)) {
      if (a == null) {}
    }
    while (!TextUtils.isEmpty(c.getText()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final String b()
  {
    return c.getText().toString();
  }
  
  public final void c()
  {
    boolean bool = a();
    if (bool != f)
    {
      b.l();
      f = bool;
    }
  }
  
  public final void d()
  {
    g = true;
    e();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == k)
    {
      c.setText(null);
      e();
      c();
    }
    while (paramView != m) {
      return;
    }
    b.m();
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    i = findViewById(are.aD);
    c = ((EditText)findViewById(are.aC));
    j = ((TextView)findViewById(are.ay));
    k = findViewById(are.L);
    l = ((CheckBox)findViewById(are.aR));
    m = findViewById(are.B);
    h = ((TextView)findViewById(are.F));
    k.setOnClickListener(this);
    l.setOnCheckedChangeListener(new aur(this));
    m.setOnClickListener(this);
    aut localaut = new aut(this);
    c.addTextChangedListener(localaut);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AuthenticationView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    d = a;
    e = b;
    a = awj.a(getContext()).c(d);
    paramParcelable = c;
    c.setText(paramParcelable);
    if ((a != null) && (!TextUtils.isEmpty(a.a))) {
      j.setText(getContext().getString(arh.cx, new Object[] { a.b }));
    }
    e();
  }
  
  public Parcelable onSaveInstanceState()
  {
    AuthenticationView.SavedState localSavedState = new AuthenticationView.SavedState(super.onSaveInstanceState());
    a = d;
    b = e;
    c = b();
    if (a != null) {}
    for (String str = a.a;; str = null)
    {
      d = str;
      return localSavedState;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.AuthenticationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */