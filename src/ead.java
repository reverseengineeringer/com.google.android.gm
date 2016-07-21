import android.accounts.Account;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gm.welcome.WelcomeTourState.AccountState;
import java.util.ArrayList;

public final class ead
  extends deo<WelcomeTourState.AccountState>
{
  public View.OnClickListener g;
  
  public ead(Context paramContext, eiz parameiz, ArrayList<WelcomeTourState.AccountState> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, parameiz, paramArrayList);
    g = paramOnClickListener;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    View localView = paramView;
    if (paramView == null) {
      localView = c.inflate(dga.q, paramViewGroup, false);
    }
    paramView = (WelcomeTourState.AccountState)getItem(paramInt);
    super.a(localView, paramView);
    paramViewGroup = (TextView)localView.findViewById(dfy.bZ);
    Resources localResources = e.getResources();
    if (paramView.d())
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(dge.fG);
      paramViewGroup.setTextColor(localResources.getColor(dfv.B));
      localView.setTag(null);
      localView.setOnClickListener(null);
      localView.setClickable(false);
      return localView;
    }
    if (d == 1) {}
    for (paramInt = i; paramInt != 0; paramInt = 0)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(dge.fF);
      paramViewGroup.setTextColor(localResources.getColor(dfv.C));
      localView.setTag(b.name);
      localView.setOnClickListener(g);
      return localView;
    }
    paramViewGroup.setVisibility(8);
    localView.setTag(null);
    localView.setOnClickListener(null);
    localView.setClickable(false);
    return localView;
  }
}

/* Location:
 * Qualified Name:     ead
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */