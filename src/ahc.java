import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SpinnerAdapter;

final class ahc
  extends ajn
{
  CharSequence a;
  ListAdapter b;
  final Rect c = new Rect();
  
  public ahc(agz paramagz, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    n = paramagz;
    c();
    m = 0;
    o = new ahd(this, paramagz);
  }
  
  final void a()
  {
    Object localObject = e.getBackground();
    int i;
    int m;
    int n;
    int i1;
    int j;
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(d.d);
      if (ane.a(d))
      {
        i = d.d.right;
        m = d.getPaddingLeft();
        n = d.getPaddingRight();
        i1 = d.getWidth();
        if (d.c != -2) {
          break label246;
        }
        j = d.a((SpinnerAdapter)b, e.getBackground());
        int k = d.getContext().getResources().getDisplayMetrics().widthPixels - d.d.left - d.d.right;
        if (j <= k) {
          break label294;
        }
        j = k;
      }
    }
    label171:
    label246:
    label294:
    for (;;)
    {
      a(Math.max(j, i1 - m - n));
      if (ane.a(d)) {
        i = i1 - n - g + i;
      }
      for (;;)
      {
        h = i;
        return;
        i = -d.d.left;
        break;
        localObject = d.d;
        d.d.right = 0;
        left = 0;
        i = 0;
        break;
        if (d.c == -1)
        {
          a(i1 - m - n);
          break label171;
        }
        a(d.c);
        break label171;
        i += m;
      }
    }
  }
  
  public final void a(ListAdapter paramListAdapter)
  {
    super.a(paramListAdapter);
    b = paramListAdapter;
  }
  
  public final void b()
  {
    boolean bool = e.isShowing();
    a();
    e();
    super.b();
    f.setChoiceMode(1);
    int i = d.getSelectedItemPosition();
    Object localObject = f;
    if ((e.isShowing()) && (localObject != null))
    {
      a = false;
      ((ajq)localObject).setSelection(i);
      if ((Build.VERSION.SDK_INT >= 11) && (((ajq)localObject).getChoiceMode() != 0)) {
        ((ajq)localObject).setItemChecked(i, true);
      }
    }
    if (bool) {}
    do
    {
      return;
      localObject = d.getViewTreeObserver();
    } while (localObject == null);
    ahe localahe = new ahe(this);
    ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(localahe);
    a(new ahf(this, localahe));
  }
}

/* Location:
 * Qualified Name:     ahc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */