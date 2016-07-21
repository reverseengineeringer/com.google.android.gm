import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.android.gm.ui.GmailDrawerFragment;
import java.util.ArrayList;
import java.util.List;

public final class dxf
  extends BaseAdapter
{
  public final List<dxp> a = new ArrayList(3);
  private final dxj c = new dxj(this);
  private final dxh d = new dxh(this);
  
  public dxf(GmailDrawerFragment paramGmailDrawerFragment) {}
  
  public final int getCount()
  {
    return a.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return a.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return ((dxp)a.get(paramInt)).hashCode();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    fsl localfsl;
    fsc localfsc;
    dxj localdxj;
    dxh localdxh;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      paramViewGroup = (dxp)a.get(paramInt);
      localfsl = b.F;
      localfsc = b.E;
      localdxj = c;
      localdxh = d;
      if (paramInt != 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      localfsl.a(paramView, paramViewGroup, localfsc, localdxj, localdxh, bool, 0);
      paramView.setContentDescription(b.getString(dge.er, new Object[] { paramViewGroup.b(), Integer.valueOf(b) }));
      paramView.setOnClickListener(new dxg(this, paramViewGroup));
      return paramView;
      paramView = LayoutInflater.from(b.getActivity()).inflate(dga.C, paramViewGroup, false);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     dxf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */