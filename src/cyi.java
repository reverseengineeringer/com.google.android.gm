import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import java.util.List;

public final class cyi
  extends xa
{
  private final TextView j;
  private final Rect k = new Rect();
  
  public cyi(TextView paramTextView)
  {
    super(paramTextView);
    j = paramTextView;
  }
  
  private final Rect a(ClickableSpan paramClickableSpan, Rect paramRect)
  {
    Object localObject = j.getText();
    paramRect.setEmpty();
    if ((localObject instanceof Spanned))
    {
      localObject = (Spanned)localObject;
      int m = ((Spanned)localObject).getSpanStart(paramClickableSpan);
      int i = ((Spanned)localObject).getSpanEnd(paramClickableSpan);
      paramClickableSpan = j.getLayout();
      float f1 = paramClickableSpan.getPrimaryHorizontal(m);
      float f2 = paramClickableSpan.getPrimaryHorizontal(i);
      m = paramClickableSpan.getLineForOffset(m);
      i = paramClickableSpan.getLineForOffset(i);
      paramClickableSpan.getLineBounds(m, paramRect);
      left = ((int)f1);
      if (i == m) {
        right = ((int)f2);
      }
      paramRect.offset(j.getTotalPaddingLeft(), j.getTotalPaddingTop());
    }
    return paramRect;
  }
  
  private final CharSequence a(ClickableSpan paramClickableSpan)
  {
    CharSequence localCharSequence = j.getText();
    Object localObject = localCharSequence;
    if ((localCharSequence instanceof Spanned))
    {
      localObject = (Spanned)localCharSequence;
      localObject = ((Spanned)localObject).subSequence(((Spanned)localObject).getSpanStart(paramClickableSpan), ((Spanned)localObject).getSpanEnd(paramClickableSpan));
    }
    return (CharSequence)localObject;
  }
  
  private final ClickableSpan b(int paramInt)
  {
    Object localObject = j.getText();
    if ((localObject instanceof Spanned))
    {
      localObject = (ClickableSpan[])((Spanned)localObject).getSpans(paramInt, paramInt, ClickableSpan.class);
      if (localObject.length == 1) {
        return localObject[0];
      }
    }
    return null;
  }
  
  protected final int a(float paramFloat1, float paramFloat2)
  {
    Object localObject1 = j.getText();
    if ((localObject1 instanceof Spanned))
    {
      localObject1 = (Spanned)localObject1;
      Object localObject2 = j;
      if (((TextView)localObject2).getLayout() == null) {}
      for (int i = -1;; i = ((TextView)localObject2).getLayout().getOffsetForHorizontal(i, paramFloat1 + paramFloat2))
      {
        localObject2 = (ClickableSpan[])((Spanned)localObject1).getSpans(i, i, ClickableSpan.class);
        if (localObject2.length != 1) {
          break;
        }
        return ((Spanned)localObject1).getSpanStart(localObject2[0]);
        paramFloat2 = Math.max(0.0F, paramFloat2 - ((TextView)localObject2).getTotalPaddingTop());
        paramFloat2 = Math.min(((TextView)localObject2).getHeight() - ((TextView)localObject2).getTotalPaddingBottom() - 1, paramFloat2);
        float f = ((TextView)localObject2).getScrollY();
        i = ((TextView)localObject2).getLayout().getLineForVertical((int)(paramFloat2 + f));
        paramFloat1 = Math.max(0.0F, paramFloat1 - ((TextView)localObject2).getTotalPaddingLeft());
        paramFloat1 = Math.min(((TextView)localObject2).getWidth() - ((TextView)localObject2).getTotalPaddingRight() - 1, paramFloat1);
        paramFloat2 = ((TextView)localObject2).getScrollX();
      }
    }
    return Integer.MIN_VALUE;
  }
  
  protected final void a(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    ClickableSpan localClickableSpan = b(paramInt);
    if (localClickableSpan != null)
    {
      paramAccessibilityEvent.setContentDescription(a(localClickableSpan));
      return;
    }
    Log.e("LinkAccessibilityHelper", 40 + "LinkSpan is null for offset: " + paramInt);
    paramAccessibilityEvent.setContentDescription(j.getText());
  }
  
  protected final void a(int paramInt, uk paramuk)
  {
    ClickableSpan localClickableSpan = b(paramInt);
    if (localClickableSpan != null)
    {
      paramuk.c(a(localClickableSpan));
      paramuk.a(true);
      paramuk.f(true);
      a(localClickableSpan, k);
      if (k.isEmpty()) {
        break label110;
      }
      paramuk.b(a(localClickableSpan, k));
    }
    for (;;)
    {
      paramuk.a(16);
      return;
      Log.e("LinkAccessibilityHelper", 40 + "LinkSpan is null for offset: " + paramInt);
      paramuk.c(j.getText());
      break;
      label110:
      Log.e("LinkAccessibilityHelper", 41 + "LinkSpan bounds is empty for: " + paramInt);
      k.set(0, 0, 1, 1);
      paramuk.b(k);
    }
  }
  
  protected final void a(List<Integer> paramList)
  {
    int i = 0;
    Object localObject = j.getText();
    if ((localObject instanceof Spanned))
    {
      localObject = (Spanned)localObject;
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), ClickableSpan.class);
      int m = arrayOfClickableSpan.length;
      while (i < m)
      {
        paramList.add(Integer.valueOf(((Spanned)localObject).getSpanStart(arrayOfClickableSpan[i])));
        i += 1;
      }
    }
  }
  
  protected final boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 16)
    {
      ClickableSpan localClickableSpan = b(paramInt1);
      if (localClickableSpan != null)
      {
        localClickableSpan.onClick(j);
        return true;
      }
      Log.e("LinkAccessibilityHelper", 40 + "LinkSpan is null for offset: " + paramInt1);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     cyi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */