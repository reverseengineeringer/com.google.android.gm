import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import com.android.ex.chips.RecipientEditTextView;

public final class bjw
  implements biw
{
  public bjw(RecipientEditTextView paramRecipientEditTextView, bkn parambkn, bjz parambjz) {}
  
  private final void a(Bitmap paramBitmap)
  {
    c.a(b, paramBitmap);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      c.invalidate();
      return;
    }
    c.post(new bjx(this));
  }
  
  public final void c()
  {
    d();
  }
  
  public final void d()
  {
    byte[] arrayOfByte = a.a();
    a(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
  }
  
  public final void e()
  {
    a(c.n);
  }
}

/* Location:
 * Qualified Name:     bjw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */