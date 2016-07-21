import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gm.ui.GmailDrawerFragment;

public final class dxb
  implements fsm
{
  private final dxk a;
  
  public dxb(dxk paramdxk)
  {
    a = paramdxk;
  }
  
  public final void a(fsn paramfsn, fyb paramfyb, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    int k = 0;
    dxc localdxc = (dxc)paramfsn;
    dxp localdxp = (dxp)paramfyb;
    TextView localTextView = b;
    int m = b;
    int i;
    if (e != null)
    {
      e.setTextColor(paramInt);
      if (TextUtils.isEmpty(paramfyb.c()))
      {
        e.setText(localdxp.a());
        i = 0;
        paramfyb = e;
        if (!paramBoolean) {
          break label223;
        }
        label84:
        paramfyb.setTypeface(null, j);
        label91:
        if (d != null)
        {
          d.setTextColor(paramInt);
          if (i == 0) {
            break label235;
          }
          d.setVisibility(0);
          d.setText(localdxp.a());
        }
        label132:
        paramfsn = localTextView.getContext();
        if ((!paramBoolean) && (m > 0)) {
          break label247;
        }
        localTextView.setVisibility(8);
        label154:
        if (a != null)
        {
          paramfyb = a;
          if (!paramBoolean) {
            break label267;
          }
        }
      }
    }
    label223:
    label235:
    label247:
    label267:
    for (paramInt = k;; paramInt = 8)
    {
      paramfyb.setVisibility(paramInt);
      if (dkn.a()) {
        GmailDrawerFragment.a(paramfsn, c, localdxp, a);
      }
      return;
      e.setText(paramfyb.c());
      i = 1;
      break;
      j = 0;
      break label84;
      i = 1;
      break label91;
      d.setVisibility(8);
      break label132;
      localTextView.setVisibility(0);
      localTextView.setText(cxa.a(paramfsn, m));
      break label154;
    }
  }
}

/* Location:
 * Qualified Name:     dxb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */