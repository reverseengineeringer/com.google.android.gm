import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.android.mail.providers.Folder;
import com.android.mail.ui.FolderItemView;

final class cnv
  extends ArrayAdapter<Folder>
  implements cns
{
  private final cus b;
  private final Folder c;
  
  public cnv()
  {
    super(b.g(), bue.D);
    Folder localFolder;
    c = localFolder;
    b = c;
    a(null);
  }
  
  public final void a(ccy<Folder> paramccy)
  {
    clear();
    add(c);
    if ((paramccy != null) && (paramccy.getCount() > 0))
    {
      paramccy.moveToFirst();
      do
      {
        add((Folder)paramccy.f());
      } while (paramccy.moveToNext());
    }
  }
  
  public final void b(ccy<Folder> paramccy) {}
  
  public final ccy<Folder> c()
  {
    throw new UnsupportedOperationException("drawers don't have hierarchical folders");
  }
  
  public final void d() {}
  
  public final int getItemViewType(int paramInt)
  {
    if (getItemc.equals(b)) {
      return 0;
    }
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (Folder)getItem(paramInt);
    ListView localListView;
    if (paramView != null)
    {
      paramView = (FolderItemView)paramView;
      paramView.a(paramViewGroup, b);
      if (c.equals(a.i))
      {
        localListView = a.getListView();
        if (a.l == null) {
          break label192;
        }
      }
    }
    label192:
    for (int i = a.l.getCount();; i = 0)
    {
      localListView.setItemChecked(i + paramInt + localListView.getHeaderViewsCount(), true);
      paramInt = j;
      if (a.j != null)
      {
        paramInt = j;
        if (k != a.j.k) {
          paramInt = 1;
        }
      }
      if (paramInt != 0) {
        paramView.a(a.j.k);
      }
      Folder.a(paramViewGroup, (ImageView)paramView.findViewById(buc.bA));
      return paramView;
      paramView = (FolderItemView)LayoutInflater.from(a.b.g()).inflate(bue.D, null);
      break;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     cnv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */