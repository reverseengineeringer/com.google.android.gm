import android.view.View;
import android.widget.TextView;
import com.google.android.gm.ui.GmailDrawerFragment;
import java.util.List;

public final class dxl
  implements ftl
{
  private final dxk a;
  
  public dxl(dxk paramdxk)
  {
    a = paramdxk;
  }
  
  public final void a(ftm paramftm, fyb paramfyb, List<fyb> paramList)
  {
    dxm localdxm = (dxm)paramftm;
    dxp localdxp = (dxp)paramfyb;
    paramftm = e.getContext();
    int i = paramList.size();
    int j;
    switch (i)
    {
    default: 
      cvm.f(GmailDrawerFragment.D, "Unexpected number of recents received: %s", new Object[] { Integer.valueOf(i) });
      i = 0;
      j = 0;
      if (j > 0)
      {
        paramList = cxa.a(paramftm, j);
        a.setText(paramList);
        a.setVisibility(0);
        label113:
        if (i <= 0) {
          break label263;
        }
        paramList = cxa.a(paramftm, i);
        b.setText(paramList);
        b.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (c != null) {
        GmailDrawerFragment.a(paramftm, c, paramfyb, a);
      }
      if (k != null) {
        k.setText(localdxp.a());
      }
      return;
      i = 0;
      j = 0;
      break;
      j = get0b;
      i = 0;
      break;
      j = get0b;
      i = get1b;
      break;
      a.setVisibility(8);
      break label113;
      label263:
      b.setVisibility(8);
    }
  }
}

/* Location:
 * Qualified Name:     dxl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */