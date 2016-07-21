package com.google.android.gm.happiness;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import cjo;
import ckv;
import com.android.mail.providers.Account;
import com.android.mail.ui.toastbar.ActionableToastBar;
import cte;
import dfy;
import dmg;
import dmi;
import dmj;
import dmk;
import dml;
import dnm;
import dri;
import ghz;
import giy;
import gjg;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rg;
import vr;

public class HatsHolder
  extends cte
  implements View.OnClickListener, giy
{
  public static final String a = dri.a;
  public ckv b;
  public Account g;
  public ActionableToastBar h;
  public View i;
  public View j;
  public View k;
  public View l;
  public gjg m;
  public dmg n;
  private View o;
  private View p;
  private View q;
  
  public HatsHolder(Context paramContext)
  {
    super(paramContext);
  }
  
  public HatsHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HatsHolder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void a(View paramView1, View paramView2, Animator paramAnimator, Animator.AnimatorListener paramAnimatorListener)
  {
    measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i1 = getMeasuredHeight();
    paramView1.setVisibility(8);
    paramView2.setVisibility(0);
    measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i2 = getMeasuredHeight();
    paramView1.setVisibility(0);
    paramView2.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 1.0F, 0.0F }).setDuration(75L);
    paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F }).setDuration(150L);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1, i2 }).setDuration(300L);
    localValueAnimator.setInterpolator(new vr());
    localValueAnimator.addUpdateListener(new dmi(this));
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator).before(paramView2);
    localAnimatorSet.play(localObjectAnimator).with(localValueAnimator);
    if (paramAnimator != null) {
      localAnimatorSet.play(localValueAnimator).with(paramAnimator);
    }
    localAnimatorSet.addListener(new dmj(this, paramView1));
    if (paramAnimatorListener != null) {
      localAnimatorSet.addListener(paramAnimatorListener);
    }
    localAnimatorSet.start();
  }
  
  private final Animator e(boolean paramBoolean)
  {
    if (l == null) {
      return null;
    }
    if (paramBoolean) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(l, "alpha", new float[] { 0.0F, 1.0F });; localObjectAnimator = ObjectAnimator.ofFloat(l, "alpha", new float[] { 1.0F, 0.0F }))
    {
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.addListener(new dmk(this, paramBoolean));
      return localObjectAnimator;
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    rg.c(j, 0);
    rg.c(i, 0);
    rg.c(k, 0);
    h.a = true;
  }
  
  protected final void b()
  {
    o.setVisibility(0);
    p.setVisibility(8);
    q.setVisibility(8);
  }
  
  protected final void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    rg.c(j, 4);
    h.a = false;
  }
  
  protected final float d()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    int i1 = getMeasuredHeight();
    return bottomMargin + i1;
  }
  
  public final void d(boolean paramBoolean)
  {
    Object localObject = b.getFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag("hats-survey");
    if (localFragment != null) {
      ((FragmentManager)localObject).beginTransaction().remove(localFragment).commitAllowingStateLoss();
    }
    m = null;
    if (paramBoolean) {
      if ((l != null) && (l.getVisibility() == 0))
      {
        localObject = e(false);
        if (localObject != null) {
          ((Animator)localObject).start();
        }
      }
    }
    for (;;)
    {
      a(paramBoolean);
      return;
      if (l != null) {
        l.setVisibility(8);
      }
    }
  }
  
  protected final long e()
  {
    return -1L;
  }
  
  protected final long f()
  {
    return -1L;
  }
  
  public final boolean h()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == dfy.ba)
    {
      dri.b(a, "HaTS promo action clicked", new Object[0]);
      a(o, p, e(true), null);
    }
    do
    {
      return;
      if (i1 == dfy.bc)
      {
        dri.b(a, "HaTS promo dismiss clicked", new Object[0]);
        n.a("gcs_dismiss");
        if (m != null) {
          m.d();
        }
        d(true);
        return;
      }
    } while (i1 != dfy.bb);
    if (m != null) {
      m.d();
    }
    d(true);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    o = findViewById(dfy.be);
    p = findViewById(dfy.bd);
    q = findViewById(dfy.bf);
    setOnClickListener(this);
  }
  
  public void onSurveyCanceled()
  {
    dri.b(a, "HaTS canceled.", new Object[0]);
    m.a().dismiss();
    d(true);
    dnm.a(b.getApplicationContext(), g.c).e();
  }
  
  public void onSurveyComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    dri.b(a, "HaTS completed. JustAnswered: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    dmg localdmg = n;
    if (paramBoolean1) {}
    for (Object localObject = "gcs_close";; localObject = "gcs_quit")
    {
      localdmg.a((String)localObject);
      dnm.a(b.getApplicationContext(), g.c).e();
      if (!paramBoolean1) {
        break;
      }
      localObject = new dml(this);
      a(p, q, e(false), (Animator.AnimatorListener)localObject);
      return;
    }
    d(false);
  }
  
  public void onSurveyReady()
  {
    if ((g == null) || (!g.h().equals(b.n().a().h())))
    {
      dri.b(a, "HaTS invalidated. Account changed before survey was ready.", new Object[0]);
      return;
    }
    dri.b(a, "HaTS survey ready.", new Object[0]);
    n.a("gcs_show");
    b(false);
  }
  
  public void onSurveyResponse(String paramString1, String paramString2)
  {
    int i1 = 0;
    dri.b(a, "HaTS response: %s", new Object[] { paramString1 });
    paramString2 = n;
    Object localObject = Pattern.compile(ghz.a(a, "gmail_hats_response_tokens_regexp", "r.(o|s|i)-\\d+=(null|\\d+(\\.\\d+)*)")).matcher("");
    paramString1 = TextUtils.split(paramString1, "&");
    ArrayList localArrayList = new ArrayList(paramString1.length);
    int i2 = paramString1.length;
    while (i1 < i2)
    {
      CharSequence localCharSequence = paramString1[i1];
      ((Matcher)localObject).reset(localCharSequence);
      if (((Matcher)localObject).matches()) {
        localArrayList.add(localCharSequence);
      }
      i1 += 1;
    }
    dmg.a(localArrayList);
    paramString1 = String.valueOf("width=");
    localObject = String.valueOf(b);
    if (((String)localObject).length() != 0)
    {
      paramString1 = paramString1.concat((String)localObject);
      localArrayList.add(paramString1);
      paramString1 = String.valueOf("height=");
      localObject = String.valueOf(c);
      if (((String)localObject).length() == 0) {
        break label223;
      }
    }
    label223:
    for (paramString1 = paramString1.concat((String)localObject);; paramString1 = new String(paramString1))
    {
      localArrayList.add(paramString1);
      paramString2.a("gcs_response", localArrayList);
      return;
      paramString1 = new String(paramString1);
      break;
    }
  }
  
  public void onWindowError()
  {
    dri.b(a, "HaTS windows error.", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.happiness.HatsHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */