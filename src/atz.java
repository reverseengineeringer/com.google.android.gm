import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.email.activity.setup.MultilineSelectionGroup;

public final class atz
  extends arm
  implements avw
{
  private MultilineSelectionGroup g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView t;
  
  private final void a(LayoutInflater paramLayoutInflater, boolean paramBoolean1, boolean paramBoolean2)
  {
    g.a(4);
    g.b(-1);
    g.c = this;
    g.a(false);
    if (paramBoolean1) {
      g.a(paramLayoutInflater, 0, are.ap, arh.d, arh.c);
    }
    g.a(paramLayoutInflater, 1, are.aE, arh.f, arh.e);
    if (d()) {
      g.a(paramLayoutInflater, 2, are.ao, arh.b, arh.a);
    }
    if ((!cxd.f()) && (paramBoolean2))
    {
      g.a(paramLayoutInflater, 3, are.ax, arh.bQ, arh.bP);
      if ((g.b()) && (!c)) {
        c();
      }
    }
  }
  
  protected final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.l, arh.ar, true);
    g = ((MultilineSelectionGroup)paramLayoutInflater.findViewById(are.j));
    h = ((TextView)paramLayoutInflater.findViewById(are.aO));
    i = ((TextView)paramLayoutInflater.findViewById(are.at));
    j = ((TextView)paramLayoutInflater.findViewById(are.C));
    t = ((TextView)paramLayoutInflater.findViewById(are.aY));
    t.setOnClickListener(this);
    return paramLayoutInflater;
  }
  
  public final void a()
  {
    if ((b) && (!c))
    {
      arn localarn = (arn)getActivity();
      TextView localTextView = t;
      if ((localarn != null) && (localarn.e())) {}
      for (boolean bool = true;; bool = false)
      {
        localTextView.setEnabled(bool);
        return;
      }
    }
    t.setVisibility(8);
  }
  
  protected final void a(View paramView, LayoutInflater paramLayoutInflater)
  {
    int k;
    if (TextUtils.isEmpty(e))
    {
      k = arh.at;
      b(getString(k));
      a(paramLayoutInflater, false, true);
      if ((!c) || (d == null) || (d.length <= 1)) {
        break label303;
      }
      switch (d.length)
      {
      default: 
        paramView = cwt.a(getString(arh.aM, new Object[] { Integer.valueOf(d.length - 2) }), f);
        paramView = TextUtils.expandTemplate(getString(arh.aL), new CharSequence[] { cwt.a(d[0], f), cwt.a(d[1], f), paramView });
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramView)) {
        break label350;
      }
      i.setVisibility(8);
      return;
      k = arh.as;
      break;
      paramView = TextUtils.expandTemplate(getString(arh.aO), new CharSequence[] { cwt.a(d[0], f), cwt.a(d[1], f) });
      continue;
      paramView = TextUtils.expandTemplate(getString(arh.aN), new CharSequence[] { cwt.a(d[0], f), cwt.a(d[1], f), cwt.a(d[2], f) });
      continue;
      label303:
      if (!TextUtils.isEmpty(e)) {
        paramView = TextUtils.expandTemplate(getString(arh.K), new CharSequence[] { cwt.a(e, f) });
      } else {
        paramView = null;
      }
    }
    label350:
    i.setText(paramView);
  }
  
  public final void a(String paramString, int paramInt)
  {
    int k = 8;
    p = paramString;
    o = paramInt;
    if ((b) && (o == 3))
    {
      j.setTextColor(getResources().getColor(arb.a));
      h.setVisibility(8);
      return;
    }
    h.setText(p);
    if (TextUtils.isEmpty(p))
    {
      h.setVisibility(8);
      paramString = i;
      if (TextUtils.isEmpty(i.getText())) {}
      for (paramInt = k;; paramInt = 0)
      {
        paramString.setVisibility(paramInt);
        return;
      }
    }
    h.setVisibility(0);
    i.setVisibility(8);
  }
  
  protected final void b(View paramView, LayoutInflater paramLayoutInflater)
  {
    i.setVisibility(8);
    j.setVisibility(8);
    t.setVisibility(8);
    paramView.findViewById(are.k).setVisibility(8);
    a(paramLayoutInflater, a, false);
  }
  
  public final void c()
  {
    if (b) {
      g.b(3);
    }
  }
  
  protected final void c_()
  {
    if (!g.b()) {}
    for (boolean bool = true;; bool = false)
    {
      a_(bool);
      return;
    }
  }
  
  public final void e()
  {
    c_();
  }
  
  public final void onClick(View paramView)
  {
    int k = paramView.getId();
    arn localarn = (arn)getActivity();
    if (localarn != null) {
      if (k == are.aW)
      {
        k = g.a;
        localarn = (arn)getActivity();
        if (localarn != null) {}
        switch (k)
        {
        case -1: 
        default: 
          k = 1;
        }
      }
    }
    for (;;)
    {
      if (k == 0) {
        super.onClick(paramView);
      }
      return;
      localarn.d_();
      break;
      localarn.a(null);
      break;
      localarn.b();
      break;
      localarn.c();
      break;
      if (k == are.aY)
      {
        localarn.d();
        k = 1;
      }
      else
      {
        k = 0;
      }
    }
  }
  
  public final void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    g.a();
    c_();
  }
}

/* Location:
 * Qualified Name:     atz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */