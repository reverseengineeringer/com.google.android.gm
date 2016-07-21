import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.android.datetimepicker.date.TextViewWithCircularIndicator;
import java.util.ArrayList;

public final class apj
  extends ListView
  implements AdapterView.OnItemClickListener, aov
{
  final aos a;
  TextViewWithCircularIndicator b;
  private apl c;
  private int d;
  private int e;
  
  public apj(Context paramContext, aos paramaos)
  {
    super(paramContext);
    a = paramaos;
    a.a(this);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramaos = paramContext.getResources();
    d = paramaos.getDimensionPixelOffset(aoh.a);
    e = paramaos.getDimensionPixelOffset(aoh.i);
    setVerticalFadingEdgeEnabled(true);
    setFadingEdgeLength(e / 3);
    a(paramContext);
    setOnItemClickListener(this);
    setSelector(new StateListDrawable());
    setDividerHeight(0);
    a();
  }
  
  static int a(TextView paramTextView)
  {
    return Integer.valueOf(paramTextView.getText().toString()).intValue();
  }
  
  private final void a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int i = a.c();
    while (i <= a.d())
    {
      localArrayList.add(String.format("%d", new Object[] { Integer.valueOf(i) }));
      i += 1;
    }
    c = new apl(this, paramContext, aok.c, localArrayList);
    setAdapter(c);
  }
  
  public final void a()
  {
    c.notifyDataSetChanged();
    a(a.a().a - a.c(), d / 2 - e / 2);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    post(new apk(this, paramInt1, paramInt2));
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      paramAccessibilityEvent.setFromIndex(0);
      paramAccessibilityEvent.setToIndex(0);
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a.g();
    paramAdapterView = (TextViewWithCircularIndicator)paramView;
    if (paramAdapterView != null)
    {
      if (paramAdapterView != b)
      {
        if (b != null)
        {
          b.b = false;
          b.requestLayout();
        }
        b = true;
        paramAdapterView.requestLayout();
        b = paramAdapterView;
      }
      a.a(a(paramAdapterView));
      c.notifyDataSetChanged();
    }
  }
}

/* Location:
 * Qualified Name:     apj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */