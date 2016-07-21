import android.graphics.drawable.Drawable;
import android.widget.TextView;

class yt
  extends yv
{
  public void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramTextView.getLayoutDirection() == 1)
    {
      paramInt2 = 1;
      if (paramInt2 == 0) {
        break label36;
      }
      paramInt3 = 0;
      label17:
      if (paramInt2 == 0) {
        break label42;
      }
    }
    for (;;)
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, paramInt1, 0);
      return;
      paramInt2 = 0;
      break;
      label36:
      paramInt3 = paramInt1;
      break label17;
      label42:
      paramInt1 = 0;
    }
  }
  
  public void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    int i;
    if (paramTextView.getLayoutDirection() == 1)
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
      paramDrawable2 = null;
      label18:
      if (i == 0) {
        break label43;
      }
    }
    for (;;)
    {
      paramTextView.setCompoundDrawables(paramDrawable2, null, paramDrawable1, null);
      return;
      i = 0;
      break;
      label38:
      paramDrawable2 = paramDrawable1;
      break label18;
      label43:
      paramDrawable1 = null;
    }
  }
}

/* Location:
 * Qualified Name:     yt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */