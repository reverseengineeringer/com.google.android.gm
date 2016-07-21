import android.graphics.drawable.Drawable;
import android.widget.TextView;

class ys
  implements yw
{
  public void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, 0, 0, 0);
  }
  
  public void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramTextView.setCompoundDrawables(paramDrawable1, null, null, null);
  }
}

/* Location:
 * Qualified Name:     ys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */