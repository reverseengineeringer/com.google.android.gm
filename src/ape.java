import android.content.Context;
import android.graphics.Rect;
import android.text.format.DateFormat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.Calendar;
import java.util.List;

public final class ape
  extends xa
{
  private final Rect k = new Rect();
  private final Calendar l = Calendar.getInstance();
  
  public ape(apc paramapc, View paramView)
  {
    super(paramView);
  }
  
  private final CharSequence b(int paramInt)
  {
    l.set(j.v, j.u, paramInt);
    CharSequence localCharSequence = DateFormat.format("dd MMMM yyyy", l.getTimeInMillis());
    Object localObject = localCharSequence;
    if (paramInt == j.A) {
      localObject = j.getContext().getString(aol.h, new Object[] { localCharSequence });
    }
    return (CharSequence)localObject;
  }
  
  protected final int a(float paramFloat1, float paramFloat2)
  {
    int i = j.a(paramFloat1, paramFloat2);
    if (i >= 0) {
      return i;
    }
    return Integer.MIN_VALUE;
  }
  
  protected final void a(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    paramAccessibilityEvent.setContentDescription(b(paramInt));
  }
  
  protected final void a(int paramInt, uk paramuk)
  {
    Rect localRect = k;
    int i2 = j.c();
    int n = j.d;
    int i = j.y;
    int m = (j.w - j.b()) / j.D;
    int i3 = paramInt - 1 + j.a();
    int i1 = i3 / j.D;
    i2 += j.a(i3 % j.D) * m;
    n += i1 * i;
    localRect.set(i2, n, m + i2, i + n);
    paramuk.c(b(paramInt));
    paramuk.b(k);
    paramuk.a(16);
    if (paramInt == j.A) {
      paramuk.e(true);
    }
  }
  
  protected final void a(List<Integer> paramList)
  {
    int i = 1;
    while (i <= j.E)
    {
      paramList.add(Integer.valueOf(i));
      i += 1;
    }
  }
  
  protected final boolean b(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return false;
    }
    j.b(paramInt1);
    return true;
  }
}

/* Location:
 * Qualified Name:     ape
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */