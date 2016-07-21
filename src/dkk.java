import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

final class dkk
  extends DataSetObserver
{
  dkk(dki paramdki) {}
  
  public final void onChanged()
  {
    super.onChanged();
    if (a.g != null) {
      a.g.a(a.a);
    }
    if (a.d == null) {
      return;
    }
    a.d.removeAllViews();
    int i = a.getArguments().getInt("max-accounts-displayed");
    if (i > 0) {}
    for (i = Math.min(i, a.a.getCount());; i = a.a.getCount())
    {
      int j = 0;
      while (j < i)
      {
        View localView = a.a.getView(j, null, a.d);
        a.d.addView(localView);
        j += 1;
      }
      break;
    }
  }
}

/* Location:
 * Qualified Name:     dkk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */