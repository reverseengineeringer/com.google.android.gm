import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import com.android.mail.browse.ConversationViewHeader;
import com.android.mail.providers.Conversation;

public final class bxr
  extends bxh
{
  public Conversation e;
  public final bxp f;
  
  public bxr(bxp parambxp, Conversation paramConversation)
  {
    e = paramConversation;
    f = parambxp;
  }
  
  public final int a()
  {
    return 0;
  }
  
  public final View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramContext = (ConversationViewHeader)paramLayoutInflater.inflate(bue.y, paramViewGroup, false);
    paramContext.a(f.i, f.b, f.l);
    paramContext.a(e.d);
    paramContext.a(e);
    paramContext.a(e.l, false);
    paramContext.setTag("overlay_item_root");
    return paramContext;
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    ((ConversationViewHeader)paramView).a(this);
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final View.OnKeyListener c()
  {
    return f.w;
  }
}

/* Location:
 * Qualified Name:     bxr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */