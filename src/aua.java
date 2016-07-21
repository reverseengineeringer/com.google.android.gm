import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public final class aua
  extends arm
{
  private View g;
  
  private final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramLayoutInflater, paramViewGroup, paramInt, 0, 0, null);
  }
  
  private final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(arf.n, paramViewGroup, false);
    if (paramViewGroup.getChildCount() == 0) {
      paramLayoutInflater.findViewById(are.t).setVisibility(8);
    }
    paramLayoutInflater.findViewById(are.s).setOnClickListener(this);
    if (paramInt3 != 0) {
      paramLayoutInflater.findViewById(are.s).setTag(paramInt3, paramObject);
    }
    ((TextView)paramLayoutInflater.findViewById(are.aI)).setText(paramInt1);
    if (paramInt2 > 0) {
      ((ImageView)paramLayoutInflater.findViewById(are.aH)).setImageResource(paramInt2);
    }
    paramViewGroup.addView(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  private final void a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a) {
      if (!paramBoolean1) {
        break label179;
      }
    }
    label179:
    for (int i = arh.ah;; i = arh.ai)
    {
      a(paramLayoutInflater, paramViewGroup, i, ard.b, are.ap, Boolean.valueOf(true)).findViewById(are.s).setEnabled(paramBoolean1);
      a(paramLayoutInflater, paramViewGroup, arh.aG, ard.m, are.aE, "outlook.com");
      a(paramLayoutInflater, paramViewGroup, arh.aQ, ard.q, are.aE, "yahoo.com");
      if (d()) {
        a(paramLayoutInflater, paramViewGroup, arh.L, ard.a, are.ao, Boolean.valueOf(true));
      }
      View localView = a(paramLayoutInflater, paramViewGroup, arh.aE);
      localView.setVisibility(8);
      new aub(this, localView).execute(new Void[0]);
      a(paramLayoutInflater, paramViewGroup, arh.aE);
      if (paramBoolean2) {
        a(paramLayoutInflater, paramViewGroup, arh.bQ, ard.c, are.ax, Boolean.valueOf(true));
      }
      return;
    }
  }
  
  private final void e()
  {
    int k = 1;
    int j = 0;
    Object localObject1 = g.findViewById(are.av);
    Object localObject2 = (TextView)((View)localObject1).findViewById(are.D);
    View localView = ((View)localObject1).findViewById(are.aY);
    ((View)localObject1).setVisibility(0);
    if ((c) && (d != null) && (d.length > 1))
    {
      ((View)localObject1).setVisibility(0);
      switch (d.length)
      {
      default: 
        String str = getString(arh.aM, new Object[] { Integer.valueOf(d.length - 1) });
        ((TextView)localObject2).setText(TextUtils.expandTemplate(getString(arh.aw), new CharSequence[] { cwt.a(d[0], f), cwt.a(str, f) }));
        localView.setVisibility(0);
        if (((View)localObject1).getVisibility() == 0)
        {
          i = 1;
          label185:
          localObject1 = (TextView)g.findViewById(are.al);
          if (TextUtils.isEmpty(p)) {
            break label417;
          }
          ((TextView)localObject1).setText(p);
          ((TextView)localObject1).setVisibility(0);
          i = k;
          label227:
          localObject1 = g;
          if (i == 0) {
            break label427;
          }
        }
        break;
      }
    }
    label376:
    label396:
    label417:
    label427:
    for (int i = j;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      return;
      ((TextView)localObject2).setText(TextUtils.expandTemplate(getString(arh.av), new CharSequence[] { cwt.a(d[0], f), cwt.a(d[1], f) }));
      localView.setVisibility(8);
      break;
      if (!TextUtils.isEmpty(e))
      {
        ((TextView)localObject2).setText(TextUtils.expandTemplate(getString(arh.au), new CharSequence[] { cwt.a(e, f) }));
        localObject2 = (arn)getActivity();
        if ((localObject2 != null) && (((arn)localObject2).e()))
        {
          i = 1;
          if (i == 0) {
            break label396;
          }
        }
        for (i = 0;; i = 8)
        {
          localView.setVisibility(i);
          break;
          i = 0;
          break label376;
        }
      }
      ((View)localObject1).setVisibility(8);
      break;
      i = 0;
      break label185;
      ((TextView)localObject1).setVisibility(8);
      break label227;
    }
  }
  
  protected final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.m, arh.ar, false);
    g = paramLayoutInflater.findViewById(are.au);
    paramLayoutInflater.findViewById(are.aY).setOnClickListener(this);
    paramLayoutInflater.findViewById(are.aQ).setPadding(0, 0, 0, 0);
    return paramLayoutInflater;
  }
  
  protected final void a()
  {
    e();
  }
  
  protected final void a(View paramView, LayoutInflater paramLayoutInflater)
  {
    a((ViewGroup)paramView.findViewById(are.aJ), paramLayoutInflater, false, true);
    e();
  }
  
  public final void a(String paramString, int paramInt)
  {
    p = paramString;
    o = paramInt;
    e();
  }
  
  protected final void b(View paramView, LayoutInflater paramLayoutInflater)
  {
    a((ViewGroup)paramView.findViewById(are.aJ), paramLayoutInflater, true, false);
    e();
  }
  
  public final void c() {}
  
  protected final void c_()
  {
    b(8);
  }
  
  public final void onClick(View paramView)
  {
    arn localarn = (arn)getActivity();
    if (paramView.getId() == are.s)
    {
      if (paramView.getTag(are.ap) != null)
      {
        localarn.d_();
        return;
      }
      if (paramView.getTag(are.ao) != null)
      {
        localarn.b();
        return;
      }
      if (paramView.getTag(are.aE) != null)
      {
        localarn.a(awj.a(getActivity()).b((String)paramView.getTag(are.aE)));
        return;
      }
      if (paramView.getTag(are.ax) != null)
      {
        localarn.c();
        return;
      }
      localarn.a(null);
      return;
    }
    if (paramView.getId() == are.aY)
    {
      localarn.d();
      return;
    }
    super.onClick(paramView);
  }
}

/* Location:
 * Qualified Name:     aua
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */