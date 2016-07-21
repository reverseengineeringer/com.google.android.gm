import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public final class dxd
  implements fso
{
  public final fsn a(View paramView)
  {
    dxc localdxc = new dxc();
    e = ((TextView)paramView.findViewById(dfy.c));
    f = ((ImageView)paramView.findViewById(dfy.L));
    d = ((TextView)paramView.findViewById(dfy.b));
    a = ((ImageView)paramView.findViewById(dfy.ag));
    ViewGroup localViewGroup = (ViewGroup)paramView;
    b = ((TextView)LayoutInflater.from(paramView.getContext()).inflate(dga.e, localViewGroup, false));
    localViewGroup.addView(b);
    if (dkn.a()) {
      c = ((ImageView)paramView.findViewById(dfy.M));
    }
    return localdxc;
  }
}

/* Location:
 * Qualified Name:     dxd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */