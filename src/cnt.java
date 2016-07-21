import android.database.DataSetObserver;

final class cnt
  extends DataSetObserver
{
  cnt(cnk paramcnk) {}
  
  public final void onChanged()
  {
    if (a.r != null)
    {
      a.g.b(a.r);
      a.r = null;
    }
    if (a.q != null)
    {
      a.h.a(a.q);
      a.q = null;
    }
  }
}

/* Location:
 * Qualified Name:     cnt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */