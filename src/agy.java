import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class agy
  extends agv
{
  private static final int[] c = { 16843074 };
  private final SeekBar d;
  
  agy(SeekBar paramSeekBar, agj paramagj)
  {
    super(paramSeekBar, paramagj);
    d = paramSeekBar;
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = amp.a(d.getContext(), paramAttributeSet, c, paramInt);
    Drawable localDrawable = paramAttributeSet.b(0);
    if (localDrawable != null) {
      d.setThumb(localDrawable);
    }
    a.recycle();
  }
}

/* Location:
 * Qualified Name:     agy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */