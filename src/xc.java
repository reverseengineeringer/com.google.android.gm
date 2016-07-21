import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

public final class xc
  extends vu
{
  private final ListView f;
  
  public xc(ListView paramListView)
  {
    super(paramListView);
    f = paramListView;
  }
  
  public final void a(int paramInt)
  {
    ListView localListView = f;
    if (Build.VERSION.SDK_INT >= 19) {
      localListView.scrollListBy(paramInt);
    }
    int i;
    View localView;
    do
    {
      do
      {
        return;
        i = localListView.getFirstVisiblePosition();
      } while (i == -1);
      localView = localListView.getChildAt(0);
    } while (localView == null);
    localListView.setSelectionFromTop(i, localView.getTop() - paramInt);
  }
  
  public final boolean b(int paramInt)
  {
    ListView localListView = f;
    int i = localListView.getCount();
    if (i == 0) {}
    int j;
    int k;
    do
    {
      return false;
      j = localListView.getChildCount();
      k = localListView.getFirstVisiblePosition();
      if (paramInt <= 0) {
        break;
      }
    } while ((k + j >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight()));
    do
    {
      return true;
      if (paramInt >= 0) {
        break;
      }
    } while ((k > 0) || (localListView.getChildAt(0).getTop() < 0));
    return false;
  }
}

/* Location:
 * Qualified Name:     xc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */