import android.text.Spanned;

final class cby
  implements Runnable
{
  final String a;
  boolean b;
  
  public cby(cbk paramcbk, String paramString)
  {
    a = paramString;
  }
  
  public final void run()
  {
    Spanned localSpanned = cvb.a(a, c.Y);
    c.runOnUiThread(new cbz(this, localSpanned));
  }
}

/* Location:
 * Qualified Name:     cby
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */