import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;

final class cz
  implements cx
{
  public final void a(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    Matrix localMatrix = (Matrix)da.a.get();
    if (localMatrix == null)
    {
      localMatrix = new Matrix();
      da.a.set(localMatrix);
    }
    for (;;)
    {
      da.a(paramViewGroup, paramView, localMatrix);
      paramView = (RectF)da.b.get();
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = new RectF();
      }
      paramViewGroup.set(paramRect);
      localMatrix.mapRect(paramViewGroup);
      paramRect.set((int)(left + 0.5F), (int)(top + 0.5F), (int)(right + 0.5F), (int)(bottom + 0.5F));
      return;
      localMatrix.set(da.c);
    }
  }
}

/* Location:
 * Qualified Name:     cz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */