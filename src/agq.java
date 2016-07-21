import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class agq
{
  private final ImageView a;
  private final agj b;
  
  public agq(ImageView paramImageView, agj paramagj)
  {
    a = paramImageView;
    b = paramagj;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (b != null) {}
      for (Drawable localDrawable = b.a(a.getContext(), paramInt, false);; localDrawable = jr.a(a.getContext(), paramInt))
      {
        if (localDrawable != null) {
          aij.b(localDrawable);
        }
        a.setImageDrawable(localDrawable);
        return;
      }
    }
    a.setImageDrawable(null);
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = amp.a(a.getContext(), paramAttributeSet, ack.R, paramInt);
    try
    {
      Drawable localDrawable = paramAttributeSet.b(ack.S);
      if (localDrawable != null) {
        a.setImageDrawable(localDrawable);
      }
      paramInt = paramAttributeSet.e(ack.T, -1);
      if (paramInt != -1)
      {
        localDrawable = b.a(a.getContext(), paramInt, false);
        if (localDrawable != null) {
          a.setImageDrawable(localDrawable);
        }
      }
      localDrawable = a.getDrawable();
      if (localDrawable != null) {
        aij.b(localDrawable);
      }
      return;
    }
    finally
    {
      a.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     agq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */