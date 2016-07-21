import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mail.providers.Account;
import com.google.android.gm.ads.AdSenderHeaderView;
import com.google.android.gm.ads.AppRatingAndLogoView;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.Advertisement.AppInstallAdData;

public final class dgx
  extends bxh
{
  public final Account e;
  public Advertisement f;
  private final dhy g;
  
  public dgx(Account paramAccount, Advertisement paramAdvertisement, dhy paramdhy)
  {
    e = paramAccount;
    f = paramAdvertisement;
    g = paramdhy;
  }
  
  public final int a()
  {
    return 6;
  }
  
  public final View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(dga.j, paramViewGroup, false);
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    boolean bool = true;
    paramView = (AdSenderHeaderView)paramView;
    Object localObject = g;
    int i;
    if ((a == null) || (a != this))
    {
      a = this;
      b = ((dhy)localObject);
      localObject = a.f;
      c.setImageBitmap(k);
      c.setContentDescription(f);
      d.setText(f);
      e.setText(i);
      paramView.a((Advertisement)localObject);
      localObject = a.f.D;
      if (((Advertisement.AppInstallAdData)localObject).a())
      {
        i = ((Advertisement.AppInstallAdData)localObject).d();
        if ((!((Advertisement.AppInstallAdData)localObject).b()) || ((i != 2) && (i != 3))) {
          break label210;
        }
        i = 1;
        f.setVisibility(0);
        if (i == 0) {
          h.setVisibility(8);
        }
        if (TextUtils.isEmpty(c)) {
          break label215;
        }
        paramBoolean = true;
        label183:
        paramView = g;
        if (i != 0) {
          break label220;
        }
      }
    }
    for (;;)
    {
      paramView.a(bool, a, b, paramBoolean);
      return;
      label210:
      i = 0;
      break;
      label215:
      paramBoolean = false;
      break label183;
      label220:
      bool = false;
    }
  }
  
  public final boolean b()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     dgx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */