import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.android.mail.providers.Folder;
import com.android.mail.ui.MiniDrawerView;

public final class cox
  implements View.OnClickListener
{
  public final Folder a;
  public final ImageView b;
  
  public cox(MiniDrawerView paramMiniDrawerView, Folder paramFolder, ImageView paramImageView)
  {
    a = paramFolder;
    b = paramImageView;
    Folder.a(a, b);
    b.setOnClickListener(this);
  }
  
  public final void onClick(View paramView)
  {
    c.a.a(a, "mini-drawer");
  }
}

/* Location:
 * Qualified Name:     cox
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */