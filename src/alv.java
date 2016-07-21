import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

final class alv
  extends ajh
  implements View.OnLongClickListener
{
  zg a;
  private final int[] c = { 16842964 };
  private TextView d;
  private ImageView e;
  private View i;
  
  public alv(als paramals, Context paramContext, zg paramzg, boolean paramBoolean)
  {
    super(paramContext, null, aca.e);
    a = paramzg;
    paramals = amp.a(paramContext, null, c, aca.e);
    if (paramals.e(0)) {
      setBackgroundDrawable(paramals.a(0));
    }
    a.recycle();
    c(8388627);
    a();
  }
  
  public final void a()
  {
    Object localObject1 = a;
    Object localObject2 = ((zg)localObject1).d();
    if (localObject2 != null)
    {
      localObject1 = ((View)localObject2).getParent();
      if (localObject1 != this)
      {
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView((View)localObject2);
        }
        addView((View)localObject2);
      }
      i = ((View)localObject2);
      if (d != null) {
        d.setVisibility(8);
      }
      if (e != null)
      {
        e.setVisibility(8);
        e.setImageDrawable(null);
      }
      return;
    }
    if (i != null)
    {
      removeView(i);
      i = null;
    }
    Object localObject3 = ((zg)localObject1).b();
    localObject2 = ((zg)localObject1).c();
    int j;
    if (localObject3 != null)
    {
      Object localObject4;
      if (e == null)
      {
        localObject4 = new ImageView(getContext());
        aji localaji = new aji(-2, -2);
        h = 16;
        ((ImageView)localObject4).setLayoutParams(localaji);
        addView((View)localObject4, 0);
        e = ((ImageView)localObject4);
      }
      e.setImageDrawable((Drawable)localObject3);
      e.setVisibility(0);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label365;
      }
      j = 1;
      label209:
      if (j == 0) {
        break label370;
      }
      if (d == null)
      {
        localObject3 = new ahi(getContext(), null, aca.f);
        ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
        localObject4 = new aji(-2, -2);
        h = 16;
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        addView((View)localObject3);
        d = ((TextView)localObject3);
      }
      d.setText((CharSequence)localObject2);
      d.setVisibility(0);
    }
    for (;;)
    {
      if (e != null) {
        e.setContentDescription(((zg)localObject1).f());
      }
      if ((j != 0) || (TextUtils.isEmpty(((zg)localObject1).f()))) {
        break label397;
      }
      setOnLongClickListener(this);
      return;
      if (e == null) {
        break;
      }
      e.setVisibility(8);
      e.setImageDrawable(null);
      break;
      label365:
      j = 0;
      break label209;
      label370:
      if (d != null)
      {
        d.setVisibility(8);
        d.setText(null);
      }
    }
    label397:
    setOnLongClickListener(null);
    setLongClickable(false);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(zg.class.getName());
  }
  
  public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (Build.VERSION.SDK_INT >= 14) {
      paramAccessibilityNodeInfo.setClassName(zg.class.getName());
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    paramView = new int[2];
    getLocationOnScreen(paramView);
    Object localObject = getContext();
    int j = getWidth();
    int k = getHeight();
    int m = getResourcesgetDisplayMetricswidthPixels;
    localObject = Toast.makeText((Context)localObject, a.f(), 0);
    ((Toast)localObject).setGravity(49, paramView[0] + j / 2 - m / 2, k);
    ((Toast)localObject).show();
    return true;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((b.d > 0) && (getMeasuredWidth() > b.d)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(b.d, 1073741824), paramInt2);
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    if (isSelected() != paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      super.setSelected(paramBoolean);
      if ((j != 0) && (paramBoolean)) {
        sendAccessibilityEvent(4);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     alv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */