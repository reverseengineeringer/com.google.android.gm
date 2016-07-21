import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.google.android.gm.ui.teasers.CalendarPromotionView;

public final class dya
  extends bxs
{
  public dya(bxp parambxp, Conversation paramConversation)
  {
    super(parambxp, paramConversation);
  }
  
  public final View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(dga.r, paramViewGroup, false);
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    paramView = (CalendarPromotionView)paramView.findViewById(dfy.al);
    b = this;
    c = e.b.a().c;
    a = e.j;
    paramView.a(f);
  }
}

/* Location:
 * Qualified Name:     dya
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */