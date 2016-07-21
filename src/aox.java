import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public abstract class aox
  extends ListView
  implements AbsListView.OnScrollListener, aov
{
  public static int a = -1;
  private static SimpleDateFormat p = new SimpleDateFormat("yyyy", Locale.getDefault());
  public int b = 6;
  public boolean c = false;
  public int d = 7;
  public float e = 1.0F;
  public Context f;
  public Handler g = new Handler();
  public apb h = new apb();
  public apa i;
  public apb j = new apb();
  public int k;
  public long l;
  public int m = 0;
  public int n = 0;
  public aoz o = new aoz(this);
  private aos q;
  private boolean r;
  
  public aox(Context paramContext, aos paramaos)
  {
    super(paramContext);
    setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    setDrawSelectorOnTop(false);
    f = paramContext;
    setCacheColorHint(0);
    setDivider(null);
    setItemsCanFocus(true);
    setFastScrollEnabled(false);
    setVerticalScrollBarEnabled(false);
    setOnScrollListener(this);
    setFadingEdgeLength(0);
    setFriction(ViewConfiguration.getScrollFriction() * e);
    q = paramaos;
    q.a(this);
    b();
    a();
  }
  
  private final boolean a(apb paramapb, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      h.a(paramapb);
    }
    j.a(paramapb);
    int i3 = (a - q.c()) * 12 + b;
    int i2;
    for (int i1 = 0;; i1 = i2)
    {
      i2 = i1 + 1;
      paramapb = getChildAt(i1);
      if (paramapb != null)
      {
        i1 = paramapb.getTop();
        if (Log.isLoggable("MonthFragment", 3)) {
          new StringBuilder(40).append("child at ").append(i2 - 1).append(" has top ").append(i1);
        }
        if (i1 < 0) {}
      }
      else
      {
        if (paramapb != null) {
          getPositionForView(paramapb);
        }
        if (paramBoolean2) {
          i.a(h);
        }
        if (Log.isLoggable("MonthFragment", 3)) {
          new StringBuilder(25).append("GoTo position ").append(i3);
        }
        k = j.b;
        invalidateViews();
        m = 2;
        if (paramBoolean1)
        {
          smoothScrollToPositionFromTop(i3, a, 250);
          return true;
        }
        a(i3);
        return false;
      }
    }
  }
  
  public abstract apa a(Context paramContext, aos paramaos);
  
  public final void a()
  {
    a(q.a(), false, true);
  }
  
  public final void a(int paramInt)
  {
    clearFocus();
    post(new aoy(this, paramInt));
    onScrollStateChanged(this, 0);
  }
  
  protected final void b()
  {
    if (i == null) {
      i = a(getContext(), q);
    }
    for (;;)
    {
      setAdapter(i);
      return;
      i.a(h);
    }
  }
  
  protected void layoutChildren()
  {
    int i2 = getChildCount();
    int i1 = 0;
    Object localObject2;
    Object localObject1;
    int i3;
    if (i1 < i2)
    {
      localObject2 = getChildAt(i1);
      if ((localObject2 instanceof apc))
      {
        localObject1 = (apc)localObject2;
        i3 = J.i;
        if (i3 >= 0)
        {
          localObject1 = new apb(v, u, i3);
          label67:
          if (localObject1 == null) {
            break label145;
          }
          if (Build.VERSION.SDK_INT == 17)
          {
            localObject2 = J;
            i1 = i;
            if (i1 != Integer.MIN_VALUE) {
              ((ape)localObject2).a(j).a(i1, 128, null);
            }
          }
          label122:
          super.layoutChildren();
          if (!r) {
            break label158;
          }
          r = false;
        }
      }
    }
    label145:
    label158:
    label170:
    label249:
    label283:
    for (;;)
    {
      return;
      localObject1 = null;
      break label67;
      i1 += 1;
      break;
      localObject1 = null;
      break label122;
      if (localObject1 != null)
      {
        i3 = getChildCount();
        i1 = 0;
        if (i1 < i3)
        {
          localObject2 = getChildAt(i1);
          if ((localObject2 instanceof apc))
          {
            localObject2 = (apc)localObject2;
            if ((a == v) && (b == u) && (c <= E)) {
              break label249;
            }
          }
        }
        for (i2 = 0;; i2 = 1)
        {
          if (i2 != 0) {
            break label283;
          }
          i1 += 1;
          break label170;
          break;
          localObject2 = J;
          i2 = c;
          ((ape)localObject2).a(j).a(i2, 64, null);
        }
      }
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setItemCount(-1);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.addAction(4096);
    paramAccessibilityNodeInfo.addAction(8192);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    apc localapc = (apc)paramAbsListView.getChildAt(0);
    if (localapc == null) {
      return;
    }
    l = (paramAbsListView.getFirstVisiblePosition() * localapc.getHeight() - localapc.getBottom());
    m = n;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramAbsListView = o;
    b.g.removeCallbacks(paramAbsListView);
    a = paramInt;
    b.g.postDelayed(paramAbsListView, 40L);
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if ((paramInt != 4096) && (paramInt != 8192)) {
      return super.performAccessibilityAction(paramInt, paramBundle);
    }
    int i1 = getFirstVisiblePosition();
    paramBundle = new apb(i1 / 12 + q.c(), i1 % 12, 1);
    if (paramInt == 4096)
    {
      b += 1;
      if (b == 12)
      {
        b = 0;
        a += 1;
      }
    }
    for (;;)
    {
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).set(a, b, c);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(((Calendar)localObject).getDisplayName(2, 2, Locale.getDefault()));
      localStringBuffer.append(" ");
      localStringBuffer.append(p.format(((Calendar)localObject).getTime()));
      aom.a(this, localStringBuffer.toString());
      a(paramBundle, true, false);
      r = true;
      return true;
      if (paramInt == 8192)
      {
        localObject = getChildAt(0);
        if ((localObject != null) && (((View)localObject).getTop() >= -1))
        {
          b -= 1;
          if (b == -1)
          {
            b = 11;
            a -= 1;
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     aox
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */