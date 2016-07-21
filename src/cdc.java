import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mail.providers.Account;
import com.android.mail.ui.AccountItemView;

public final class cdc
  extends cdi
{
  private final boolean f;
  private final anf g;
  private final bvd h;
  
  public cdc(ckv paramckv, Account paramAccount, boolean paramBoolean, anf paramanf, bvd parambvd)
  {
    super(paramckv, null, 0, paramAccount);
    f = paramBoolean;
    g = paramanf;
    h = parambvd;
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup)
  {
    Account localAccount;
    Object localObject;
    bvd localbvd;
    label86:
    int i;
    if (paramView != null)
    {
      paramView = (AccountItemView)paramView;
      paramViewGroup = c.g();
      localAccount = b;
      boolean bool = f;
      localObject = g;
      localbvd = h;
      if (TextUtils.isEmpty(b)) {
        break label230;
      }
      a.setText(b);
      b.setText(c);
      b.setVisibility(0);
      if (!bool) {
        break label316;
      }
      d.setVisibility(0);
      a.setTypeface(Typeface.defaultFromStyle(1));
      i = paramView.getResources().getColor(btz.Z);
      a.setTextColor(i);
      b.setTextColor(i);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)c.findViewById(buc.H);
      localObject = new buv(paramViewGroup.getResources(), (anf)localObject, localbvd);
      i = paramViewGroup.getResources().getDimensionPixelSize(bua.a);
      ((buv)localObject).a(i, i);
      ((buv)localObject).a(b, c);
      localImageView.setImageDrawable((Drawable)localObject);
      return paramView;
      paramView = (AccountItemView)d.inflate(bue.b, paramViewGroup, false);
      break;
      label230:
      if ((!TextUtils.isEmpty(a)) && (!TextUtils.equals(a, c)))
      {
        a.setText(a);
        b.setText(c);
        b.setVisibility(0);
        break label86;
      }
      a.setText(c);
      b.setVisibility(8);
      break label86;
      label316:
      d.setVisibility(8);
      a.setTypeface(Typeface.DEFAULT);
      i = paramView.getResources().getColor(btz.ab);
      a.setTextColor(i);
      b.setTextColor(i);
    }
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final boolean a(cus paramcus, int paramInt)
  {
    return false;
  }
  
  public final int b()
  {
    return 5;
  }
  
  public final String toString()
  {
    String str = String.valueOf(b);
    return String.valueOf(str).length() + 36 + "[DrawerItem VIEW_ACCOUNT, mAccount=" + str + "]";
  }
}

/* Location:
 * Qualified Name:     cdc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */