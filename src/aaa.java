import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

final class aaa
  extends CursorAdapter
{
  private final int d;
  private final int e;
  
  aaa(zy paramzy, Context paramContext, Cursor paramCursor, ListView paramListView, zs paramzs)
  {
    super(paramContext, paramCursor, false);
    paramzy = getCursor();
    d = paramzy.getColumnIndexOrThrow(c.I);
    e = paramzy.getColumnIndexOrThrow(c.J);
  }
  
  public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((CheckedTextView)paramView.findViewById(16908308)).setText(paramCursor.getString(d));
    paramView = a;
    int i = paramCursor.getPosition();
    if (paramCursor.getInt(e) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setItemChecked(i, bool);
      return;
    }
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return c.b.inflate(b.I, paramViewGroup, false);
  }
}

/* Location:
 * Qualified Name:     aaa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */