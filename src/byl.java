import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class byl
  extends WebView
{
  private int a;
  public bym g;
  
  public byl(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public byl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return super.computeVerticalScrollOffset();
  }
  
  public int computeVerticalScrollRange()
  {
    return super.computeVerticalScrollRange();
  }
  
  public void invalidate()
  {
    super.invalidate();
    if (g != null)
    {
      int i = getContentHeight();
      if (i != a)
      {
        a = i;
        g.a();
      }
    }
  }
}

/* Location:
 * Qualified Name:     byl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */