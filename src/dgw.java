import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gm.ads.AdHeaderView;
import com.google.android.gm.ads.AdWtaTooltipView;
import com.google.android.gm.provider.Advertisement;

public final class dgw
  extends bxh
{
  public final Advertisement e;
  public final dhv f;
  public final boolean g;
  
  public dgw(Advertisement paramAdvertisement, boolean paramBoolean, dhv paramdhv)
  {
    e = paramAdvertisement;
    g = paramBoolean;
    f = paramdhv;
  }
  
  public final int a()
  {
    return 5;
  }
  
  public final View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    int i = 0;
    paramContext = (AdHeaderView)paramLayoutInflater.inflate(dga.i, paramViewGroup, false);
    paramLayoutInflater = e.g;
    boolean bool = g;
    int j = e.c();
    paramViewGroup = e.K;
    dhv localdhv = f;
    a.setText(paramLayoutInflater);
    TextView localTextView = a;
    if (TextUtils.isEmpty(paramLayoutInflater)) {
      i = 8;
    }
    localTextView.setVisibility(i);
    b.a(j, paramViewGroup);
    b.a = localdhv;
    if (b.a(bool)) {
      paramContext.c();
    }
    return paramContext;
  }
  
  public final void a(View paramView, boolean paramBoolean) {}
  
  public final boolean b()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     dgw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */