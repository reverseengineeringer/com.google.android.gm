import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public final class ade
  extends ActionMode
{
  final Context a;
  final acz b;
  
  public ade(Context paramContext, acz paramacz)
  {
    a = paramContext;
    b = paramacz;
  }
  
  public final void finish()
  {
    b.c();
  }
  
  public final View getCustomView()
  {
    return b.i();
  }
  
  public final Menu getMenu()
  {
    return aen.a(a, (lk)b.b());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return b.a();
  }
  
  public final CharSequence getSubtitle()
  {
    return b.g();
  }
  
  public final Object getTag()
  {
    return b.b;
  }
  
  public final CharSequence getTitle()
  {
    return b.f();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return b.c;
  }
  
  public final void invalidate()
  {
    b.d();
  }
  
  public final boolean isTitleOptional()
  {
    return b.h();
  }
  
  public final void setCustomView(View paramView)
  {
    b.a(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    b.b(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    b.a(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    b.b = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    b.a(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    b.b(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    b.a(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     ade
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */