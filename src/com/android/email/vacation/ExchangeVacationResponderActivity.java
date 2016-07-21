package com.android.email.vacation;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import are;
import arf;
import arh;
import bbp;
import buo;
import but;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.mail.providers.Account;
import csg;
import cui;
import cxe;
import java.util.Calendar;

public class ExchangeVacationResponderActivity
  extends csg
{
  private TextView s;
  private EditText t;
  private SwitchCompat u;
  private View v;
  private EditText w;
  private CheckedTextView x;
  private String y;
  private ExchangeOofSettings z;
  
  private final void t()
  {
    if (u.isChecked())
    {
      v.setVisibility(0);
      return;
    }
    v.setVisibility(8);
  }
  
  private final void u()
  {
    s.setText(getString(arh.cC, new Object[] { y }));
    v();
  }
  
  private final void v()
  {
    boolean bool = u.isChecked();
    CheckedTextView localCheckedTextView = x;
    if ((bool) && (x.isChecked())) {}
    for (bool = true;; bool = false)
    {
      localCheckedTextView.setChecked(bool);
      if (!x.isChecked()) {
        break;
      }
      u.setText(getString(arh.cE, new Object[] { y }));
      return;
    }
    u.setText(getString(arh.cD, new Object[] { y }));
  }
  
  public final boolean b(int paramInt)
  {
    if (paramInt == are.ah)
    {
      a(x);
      v();
      return true;
    }
    return super.b(paramInt);
  }
  
  protected final void g()
  {
    super.g();
    s = ((TextView)findViewById(are.ac));
    t = ((EditText)findViewById(are.ad));
    u = ((SwitchCompat)findViewById(are.ag));
    v = findViewById(are.ae);
    w = ((EditText)v.findViewById(are.af));
    x = ((CheckedTextView)v.findViewById(are.ah));
  }
  
  protected final void h()
  {
    super.h();
    t.addTextChangedListener(this);
    w.addTextChangedListener(this);
    u.setOnCheckedChangeListener(this);
    x.setOnClickListener(this);
  }
  
  protected final void i()
  {
    y = cui.b(r.c);
  }
  
  protected final void j()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(are.aX);
    getLayoutInflater().inflate(arf.z, localViewGroup, true);
  }
  
  protected final boolean k()
  {
    return false;
  }
  
  protected final void l()
  {
    u();
    p.setChecked(z.b());
    cxe.a(q, z.b());
    CheckedTextView localCheckedTextView;
    if (z.a == 2)
    {
      m.setTimeInMillis(z.b);
      n.setTimeInMillis(z.c);
      t.setText(z.g);
      u.setChecked(z.h);
      if (z.h)
      {
        localCheckedTextView = x;
        if (z.k) {
          break label164;
        }
      }
    }
    label164:
    for (boolean bool = true;; bool = false)
    {
      localCheckedTextView.setChecked(bool);
      w.setText(z.j);
      t();
      return;
      a(m);
      s();
      break;
    }
  }
  
  protected final void m()
  {
    ExchangeOofSettings localExchangeOofSettings = new ExchangeOofSettings();
    boolean bool = p.isChecked();
    d = true;
    int i;
    if (bool)
    {
      i = 2;
      a = i;
      b = m.getTimeInMillis();
      c = n.getTimeInMillis();
      e = bool;
      f = 0;
      g = t.getText().toString();
      if (!u.isChecked()) {
        break label204;
      }
      h = true;
      j = w.getText().toString();
      i = 0;
      if (x.isChecked()) {
        break label183;
      }
      k = true;
      m = j;
      l = i;
      buo.a().a("vacation_responder_eas", "extra_message", "outside_domain", 0L);
    }
    for (;;)
    {
      AsyncTask.execute(new bbp(this, localExchangeOofSettings));
      n();
      return;
      i = 0;
      break;
      label183:
      buo.a().a("vacation_responder_eas", "extra_message", "only_contacts_outside_domain", 0L);
      continue;
      label204:
      buo.a().a("vacation_responder_eas", "extra_message", "not_used", 0L);
    }
  }
  
  public final void n()
  {
    buo.a().a("vacation_responder_eas", "done", null, 0L);
    super.n();
  }
  
  public final void o()
  {
    buo.a().a("vacation_responder_eas", "discard", null, 0L);
    super.o();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == are.ag)
    {
      t();
      return;
    }
    super.onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    z = ((ExchangeOofSettings)getIntent().getParcelableExtra("extra_eas_oof_settings"));
    super.onCreate(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    u();
  }
}

/* Location:
 * Qualified Name:     com.android.email.vacation.ExchangeVacationResponderActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */