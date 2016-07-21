package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import wf;
import wg;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  public long a = -1L;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public final Runnable e = new wf(this);
  public final Runnable f = new wg(this);
  
  public ContentLoadingProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private final void a()
  {
    removeCallbacks(e);
    removeCallbacks(f);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */