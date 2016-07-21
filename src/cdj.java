import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.mail.providers.Folder;
import com.android.mail.ui.FolderItemView;

final class cdj
  extends cdi
{
  cdj(ckv paramckv, Folder paramFolder, int paramInt)
  {
    super(paramckv, paramFolder, paramInt, null);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (paramView = (FolderItemView)paramView;; paramView = (FolderItemView)d.inflate(bue.D, paramViewGroup, false))
    {
      paramView.a(a, null);
      Folder.a(a, (ImageView)paramView.findViewById(buc.bA));
      return paramView;
    }
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final boolean a(cus paramcus, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramcus != null)
    {
      bool1 = bool2;
      if (a != null)
      {
        bool1 = bool2;
        if (a.c != null)
        {
          bool1 = bool2;
          if (e == paramInt)
          {
            bool1 = bool2;
            if (a.c.equals(paramcus)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final int b()
  {
    return 0;
  }
  
  public final String toString()
  {
    String str = String.valueOf(a);
    int i = e;
    return String.valueOf(str).length() + 61 + "[DrawerItem VIEW_FOLDER, mFolder=" + str + ", mItemCategory=" + i + "]";
  }
}

/* Location:
 * Qualified Name:     cdj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */