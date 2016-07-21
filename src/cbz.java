import android.text.Spanned;
import android.widget.EditText;

final class cbz
  implements Runnable
{
  cbz(cby paramcby, Spanned paramSpanned) {}
  
  public final void run()
  {
    b.c.A.removeTextChangedListener(b.c);
    b.c.a(a, false);
    b.c.A.addTextChangedListener(b.c);
    cby localcby = b;
    c.A.setEnabled(true);
    c.A.setHint(buj.O);
    b = true;
  }
}

/* Location:
 * Qualified Name:     cbz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */