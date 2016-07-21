import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mail.providers.Folder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class coe
  extends BaseAdapter
{
  public final List<cuq> a = new ArrayList();
  private final LayoutInflater b;
  private final int c;
  private Folder d;
  
  public coe(Context paramContext, Cursor paramCursor, int paramInt, Folder paramFolder)
  {
    b = LayoutInflater.from(paramContext);
    c = paramInt;
    d = paramFolder;
    a(paramCursor, null);
  }
  
  public coe(Context paramContext, Cursor paramCursor, Set<String> paramSet, int paramInt)
  {
    b = LayoutInflater.from(paramContext);
    c = paramInt;
    a(paramCursor, paramSet);
  }
  
  private final void a(Cursor paramCursor, Set<String> paramSet)
  {
    if (paramCursor == null) {
      return;
    }
    Object localObject = new ArrayList(paramCursor.getCount());
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Folder localFolder;
    if (paramCursor.moveToFirst())
    {
      localFolder = new Folder(paramCursor);
      if ((paramSet == null) || (!paramSet.contains(c.a().toString()))) {
        break label232;
      }
    }
    label232:
    for (boolean bool = true;; bool = false)
    {
      cuq localcuq = new cuq(localFolder, bool);
      ((List)localObject).add(localcuq);
      if ((a(localFolder)) && (!hbc.a(localFolder, d)) && (localFolder.a())) {
        localArrayList2.add(localcuq);
      }
      if (paramCursor.moveToNext()) {
        break;
      }
      cup.a((List)localObject);
      paramCursor = ((List)localObject).iterator();
      while (paramCursor.hasNext())
      {
        paramSet = (cuq)paramCursor.next();
        localObject = a;
        if ((a((Folder)localObject)) && (!hbc.a(localObject, d)) && (!((Folder)localObject).a())) {
          localArrayList1.add(paramSet);
        }
      }
    }
    a.addAll(localArrayList2);
    a.addAll(localArrayList1);
  }
  
  public boolean a(Folder paramFolder)
  {
    return (paramFolder.a(1)) && (!paramFolder.d(32)) && (!hbc.a(paramFolder, d));
  }
  
  public int getCount()
  {
    return a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = b.inflate(c, paramViewGroup, false);
    }
    Object localObject = (cuq)getItem(paramInt);
    paramViewGroup = a;
    if (!TextUtils.isEmpty(c)) {}
    for (paramView = c;; paramView = d)
    {
      CheckedTextView localCheckedTextView = (CheckedTextView)localView.findViewById(buc.ae);
      if (localCheckedTextView != null)
      {
        localCheckedTextView.setClickable(false);
        localCheckedTextView.setText(paramView);
        localCheckedTextView.setChecked(b);
      }
      localObject = (TextView)localView.findViewById(buc.bB);
      if (localObject != null) {
        ((TextView)localObject).setText(paramView);
      }
      Folder.a(paramViewGroup, (ImageView)localView.findViewById(buc.bA));
      return localView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     coe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */