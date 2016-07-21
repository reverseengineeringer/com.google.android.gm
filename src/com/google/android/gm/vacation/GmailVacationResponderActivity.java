package com.google.android.gm.vacation;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import buo;
import but;
import com.android.mail.providers.Account;
import csg;
import cxe;
import dfy;
import dga;
import dge;
import drj;
import drp;
import dve;
import dvf;
import dzd;
import dze;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class GmailVacationResponderActivity
  extends csg
{
  private Runnable A = new dze(this);
  public dve s;
  public dvf t;
  private EditText u;
  private EditText v;
  private CheckedTextView w;
  private CheckedTextView x;
  private dzd y;
  private String z;
  
  private static boolean a(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (TextUtils.getTrimmedLength(paramCharSequence) == 0);
  }
  
  public final boolean b(int paramInt)
  {
    if (paramInt == dfy.ae) {
      a(w);
    }
    for (;;)
    {
      return true;
      if (paramInt != dfy.af) {
        break;
      }
      a(x);
    }
    return super.b(paramInt);
  }
  
  protected final void g()
  {
    super.g();
    u = ((EditText)findViewById(dfy.ck));
    v = ((EditText)findViewById(dfy.V));
    w = ((CheckedTextView)findViewById(dfy.ae));
    x = ((CheckedTextView)findViewById(dfy.af));
  }
  
  protected final void h()
  {
    super.h();
    u.addTextChangedListener(this);
    v.addTextChangedListener(this);
    w.setOnClickListener(this);
    x.setOnClickListener(this);
  }
  
  protected final void i()
  {
    drp localdrp = drp.a(r.c);
    s = localdrp.M();
    z = o.d();
  }
  
  protected final void j()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(dfy.cu);
    getLayoutInflater().inflate(dga.D, localViewGroup, true);
  }
  
  protected final boolean k()
  {
    return true;
  }
  
  protected final void l()
  {
    p.setChecked(s.a);
    cxe.a(q, s.a);
    long l = s.e;
    if (l == 0L)
    {
      a(m);
      l = s.f;
      if (l > 0L) {
        break label145;
      }
      s();
    }
    for (this.l = false;; this.l = true)
    {
      u.setText(s.b);
      v.setText(s.g);
      w.setChecked(s.c);
      x.setChecked(s.d);
      o = false;
      return;
      m.setTimeInMillis(l);
      break;
      label145:
      n.setTimeInMillis(l);
      n.set(5, n.get(5) - 1);
    }
  }
  
  protected final void m()
  {
    boolean bool = p.isChecked();
    Object localObject1 = u.getText();
    Object localObject2 = v.getText();
    if ((bool) && (a((CharSequence)localObject1)) && (a((CharSequence)localObject2)))
    {
      if (y != null) {
        y.dismiss();
      }
      y = new dzd();
      y.show(getFragmentManager(), "EmptySubjectAndBodyDialog");
      return;
    }
    dve localdve;
    LinkedHashMap localLinkedHashMap;
    if (o)
    {
      t = new dvf();
      s.a = bool;
      s.e = m.getTimeInMillis();
      if (!l) {
        break label456;
      }
      n.set(5, n.get(5) + 1);
      s.f = n.getTimeInMillis();
      s.b = ((CharSequence)localObject1).toString();
      localObject1 = ((CharSequence)localObject2).toString();
      if (!s.g.equals(localObject1)) {
        s.g = ((String)localObject1);
      }
      s.c = w.isChecked();
      s.d = x.isChecked();
      localdve = s;
      localObject2 = t;
      localLinkedHashMap = a;
      if (b == null) {
        break label467;
      }
      localObject1 = b;
      label261:
      localLinkedHashMap.put("sx_vs", localObject1);
      localLinkedHashMap = a;
      if (g == null) {
        break label474;
      }
      localObject1 = g;
      label291:
      localLinkedHashMap.put("sx_vm", localObject1);
      localLinkedHashMap = a;
      if (!c) {
        break label481;
      }
      localObject1 = "1";
      label319:
      localLinkedHashMap.put("bx_vc", localObject1);
      localLinkedHashMap = a;
      if (!d) {
        break label488;
      }
      localObject1 = "1";
      label347:
      localLinkedHashMap.put("bx_vd", localObject1);
      a.put("lx_vst", String.valueOf(e));
      a.put("lx_vend", String.valueOf(f));
      localLinkedHashMap = a;
      if (!a) {
        break label495;
      }
    }
    label456:
    label467:
    label474:
    label481:
    label488:
    label495:
    for (localObject1 = "1";; localObject1 = "0")
    {
      localLinkedHashMap.put("bx_ve", localObject1);
      localObject1 = h;
      localObject2 = a;
      g.putAll((Map)localObject2);
      AsyncTask.execute(A);
      n();
      return;
      s.f = 0L;
      break;
      localObject1 = "";
      break label261;
      localObject1 = "";
      break label291;
      localObject1 = "0";
      break label319;
      localObject1 = "0";
      break label347;
    }
  }
  
  public final void n()
  {
    buo.a().a("vacation_responder", "done", null, 0L);
    super.n();
  }
  
  public final void o()
  {
    buo.a().a("vacation_responder", "discard", null, 0L);
    super.o();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getResources();
    if (TextUtils.isEmpty(z))
    {
      x.setVisibility(8);
      return;
    }
    paramBundle = paramBundle.getString(dge.ft, new Object[] { z });
    x.setText(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.vacation.GmailVacationResponderActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */