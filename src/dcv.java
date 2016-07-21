import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;

public final class dcv
  implements View.OnClickListener
{
  public dcv(RichTextToolbar paramRichTextToolbar) {}
  
  public final void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == dch.q) {
      if (a.b != null)
      {
        a.b.y();
        dcc.a(a.a, a.c, a.getResources().getText(dcj.g));
      }
    }
    do
    {
      return;
      if (i == dch.i)
      {
        if (a.b != null) {
          a.b.z();
        }
        a.b(false);
        return;
      }
    } while (!(paramView instanceof RadioButton));
    a.d();
  }
}

/* Location:
 * Qualified Name:     dcv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */