import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public final class bko
  extends ArrayAdapter<bkn>
{
  private final bim a;
  private final StateListDrawable b;
  
  public bko(Context paramContext, bkn parambkn, bim parambim, StateListDrawable paramStateListDrawable)
  {
    super(paramContext, bim.b(biq.c), new bkn[] { parambkn });
    a = parambim;
    b = paramStateListDrawable;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a.a(paramView, paramViewGroup, (bkn)getItem(paramInt), paramInt, biq.c, null, b);
  }
}

/* Location:
 * Qualified Name:     bko
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */