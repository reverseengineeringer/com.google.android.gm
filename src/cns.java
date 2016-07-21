import android.widget.ListAdapter;
import com.android.mail.providers.Folder;

public abstract interface cns
  extends ListAdapter
{
  public abstract void a(ccy<Folder> paramccy);
  
  public abstract void b(ccy<Folder> paramccy);
  
  public abstract ccy<Folder> c();
  
  public abstract void d();
  
  public abstract void notifyDataSetChanged();
}

/* Location:
 * Qualified Name:     cns
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */