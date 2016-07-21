import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.people.accountswitcherview.ExpanderView;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView;
import com.google.android.gms.people.accountswitcherview.ShrinkingItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class frx
  extends FrameLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, fth, ftk
{
  public fsy a;
  private fry b;
  private fsa c;
  private frz d;
  private fyb e;
  private List<fyb> f;
  private FrameLayout g;
  private SelectedAccountNavigationView h;
  private fsl i;
  private ShrinkingItem j;
  private boolean k;
  private ViewGroup l;
  private ExpanderView m;
  private fsb n;
  private boolean o;
  private int p;
  private int q;
  private boolean r;
  private View s;
  
  private final void a(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    p = paramView.getTop();
  }
  
  private final void a(fyb paramfyb, boolean paramBoolean)
  {
    Object localObject1 = e;
    e = paramfyb;
    if (f != null)
    {
      f = fsl.a(f, (fyb)localObject1, e);
      if (!paramBoolean) {
        h.a(e);
      }
      paramfyb = i;
      localObject1 = f;
      if ((d) || ((localObject1 != null) && (((List)localObject1).size() <= 1)))
      {
        if (b == null) {
          b = new ArrayList();
        }
        b.clear();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (fyb)((Iterator)localObject1).next();
            b.add(localObject2);
          }
        }
        paramfyb.notifyDataSetChanged();
        return;
      }
      f = true;
      Object localObject2 = e;
      if (e != null)
      {
        if (f != null)
        {
          f.cancel(true);
          f = null;
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break label229;
        }
        e.a(null);
      }
      for (;;)
      {
        paramfyb.notifyDataSetChanged();
        return;
        label229:
        b = ((List)localObject1);
        c.addAll((Collection)localObject1);
        f = new frw((fru)localObject2);
        f.execute(new Void[0]);
      }
    }
    h.a(null);
  }
  
  private final void a(boolean paramBoolean, Interpolator paramInterpolator)
  {
    int i1;
    if (paramBoolean) {
      i1 = 1;
    }
    for (int i2 = 0; a(11); i2 = 1)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(j, "animatedHeightFraction", new float[] { i2, i1 });
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.setInterpolator(paramInterpolator);
      localObjectAnimator.start();
      return;
      i1 = 0;
    }
    paramInterpolator = j;
    a = i1;
    paramInterpolator.requestLayout();
  }
  
  public static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  private final void b(int paramInt)
  {
    g.offsetTopAndBottom(paramInt);
    q = g.getTop();
  }
  
  private final void c(int paramInt)
  {
    l.setPadding(l.getPaddingLeft(), paramInt, l.getPaddingRight(), l.getPaddingBottom());
    a.a = paramInt;
    h.a(paramInt);
  }
  
  public final void a(SelectedAccountNavigationView paramSelectedAccountNavigationView)
  {
    switch (h.b)
    {
    default: 
      return;
    case 0: 
      paramSelectedAccountNavigationView = new AlphaAnimation(0.0F, 1.0F);
      paramSelectedAccountNavigationView.setDuration(200L);
      g.setAnimation(paramSelectedAccountNavigationView);
      a(false, new AccelerateInterpolator(0.8F));
      g.setVisibility(0);
      j.setVisibility(8);
      return;
    }
    paramSelectedAccountNavigationView = new AlphaAnimation(1.0F, 0.0F);
    paramSelectedAccountNavigationView.setDuration(200L);
    paramSelectedAccountNavigationView.setStartOffset(133L);
    a(true, new DecelerateInterpolator(0.8F));
    g.setVisibility(8);
    j.setVisibility(0);
  }
  
  public final void a(fyb paramfyb)
  {
    a(paramfyb, true);
  }
  
  public final int getNestedScrollAxes()
  {
    return 2;
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = true;
    if (paramView == l) {
      if (n == null) {}
    }
    while (paramView != m) {
      return;
    }
    int i1;
    if (h.b == 1)
    {
      i1 = 0;
      h.c(i1);
      paramView = m;
      if (h.b != 1) {
        break label82;
      }
    }
    for (;;)
    {
      paramView.a(bool);
      a(h);
      return;
      i1 = 1;
      break;
      label82:
      bool = false;
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (s != null)
    {
      s.setOnApplyWindowInsetsListener(null);
      s = null;
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (i.getItemViewType(paramInt) == 0) {
      if (d != null)
      {
        paramAdapterView = d;
        i.a(paramInt);
        if (!paramAdapterView.a()) {}
      }
    }
    do
    {
      do
      {
        return;
        a(i.a(paramInt), false);
      } while (b == null);
      return;
      if (i.getItemViewType(paramInt) != 1) {
        break;
      }
    } while (c == null);
    return;
    i.getItemViewType(paramInt);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (k) {}
    for (Object localObject = l;; localObject = h)
    {
      if (p != ((View)localObject).getTop()) {
        ((View)localObject).offsetTopAndBottom(p - ((View)localObject).getTop());
      }
      if (q != g.getTop()) {
        g.offsetTopAndBottom(q - g.getTop());
      }
      return;
    }
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt2 < getChildCount())
      {
        if (!getChildAt(paramInt2).equals(g)) {
          break label119;
        }
        if (!k) {
          break label103;
        }
        paramInt2 = l.getMeasuredHeight();
        g.setPadding(g.getPaddingLeft(), paramInt2, g.getPaddingRight(), g.getPaddingBottom());
        if (!o) {
          break label114;
        }
      }
      for (;;)
      {
        g.measure(paramInt1, paramInt2 + View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        return;
        label103:
        paramInt2 = h.getMeasuredHeight();
        break;
        label114:
        paramInt2 = 0;
      }
      label119:
      paramInt2 += 1;
    }
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (k) {}
    for (paramView = l; (!paramBoolean) && (paramFloat2 < 0.0F) && (paramView.getBottom() < 0); paramView = h)
    {
      a(paramView, -paramView.getTop());
      b(-paramView.getTop());
      return true;
    }
    if ((paramBoolean) && (paramFloat2 > 0.0F))
    {
      if (paramView.getTop() > -paramView.getMeasuredHeight()) {
        a(paramView, -paramView.getMeasuredHeight() - paramView.getTop());
      }
      if (g.getTop() > -paramView.getMeasuredHeight()) {
        b(-paramView.getMeasuredHeight() - g.getTop());
      }
    }
    return false;
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (k)
    {
      paramView = l;
      if (h.b != 1) {
        break label32;
      }
    }
    for (;;)
    {
      return;
      paramView = h;
      break;
      label32:
      if ((paramInt2 > 0) && (paramView.getBottom() > 0)) {
        if (paramView.getBottom() > paramInt2) {
          paramInt1 = -paramInt2;
        }
      }
      while (paramInt1 != 0)
      {
        if (paramView.getTop() + paramInt1 < -paramView.getMeasuredHeight())
        {
          a(paramView, -paramView.getMeasuredHeight() - paramView.getTop());
          label87:
          if (g.getTop() + paramInt1 >= -paramView.getMeasuredHeight()) {
            break label150;
          }
          b(-paramView.getMeasuredHeight() - g.getTop());
        }
        for (;;)
        {
          paramArrayOfInt[0] = 0;
          paramArrayOfInt[1] = paramInt1;
          return;
          paramInt1 = -paramView.getBottom();
          break;
          a(paramView, paramInt1);
          break label87;
          label150:
          b(paramInt1);
        }
        paramInt1 = 0;
      }
    }
  }
  
  public final void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (k)
    {
      paramView = l;
      if ((paramInt4 >= 0) || (paramView.getTop() >= 0)) {
        break label122;
      }
      paramInt1 = paramInt4;
      if (paramInt4 > paramView.getTop()) {}
    }
    label105:
    label115:
    label122:
    for (paramInt1 = paramView.getTop();; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        if (paramView.getTop() - paramInt1 <= 0) {
          break label105;
        }
        a(paramView, -paramView.getTop());
      }
      for (;;)
      {
        if (g.getTop() - paramInt1 <= paramView.getMeasuredHeight()) {
          break label115;
        }
        b(paramView.getMeasuredHeight() - g.getTop());
        return;
        paramView = h;
        break;
        a(paramView, -paramInt1);
      }
      b(-paramInt1);
      return;
    }
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return o;
  }
  
  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt2;
    if (r)
    {
      c(paramInt2);
      i1 = 0;
    }
    super.setPadding(paramInt1, i1, paramInt3, paramInt4);
  }
  
  public final void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt2;
    if (r)
    {
      c(paramInt2);
      i1 = 0;
    }
    super.setPaddingRelative(paramInt1, i1, paramInt3, paramInt4);
  }
}

/* Location:
 * Qualified Name:     frx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */