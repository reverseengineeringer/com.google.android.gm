import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import com.android.mail.browse.ConversationFooterView;

public final class bxq
  extends bxh
{
  public bxu e;
  
  public bxq(bxp parambxp, bxu parambxu)
  {
    e = parambxu;
  }
  
  public final int a()
  {
    return 1;
  }
  
  public final View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramContext = (ConversationFooterView)paramLayoutInflater.inflate(bue.k, paramViewGroup, false);
    c = f.b;
    d = f.k;
    paramContext.setTag("overlay_item_root");
    a(new View[] { paramContext, paramContext.findViewById(buc.dU), paramContext.findViewById(buc.dT), paramContext.findViewById(buc.bH) });
    return paramContext;
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    ((ConversationFooterView)paramView).a(this);
    d = paramView;
  }
  
  public final void b(View paramView)
  {
    ConversationFooterView localConversationFooterView = (ConversationFooterView)paramView;
    localConversationFooterView.a(this);
    ViewGroup localViewGroup;
    if (b != null)
    {
      localViewGroup = (ViewGroup)localConversationFooterView.getParent();
      if (localViewGroup != null) {
        break label76;
      }
      cvm.e(ConversationFooterView.a, "Unable to measure height of conversation header", new Object[0]);
    }
    label76:
    for (int i = localConversationFooterView.getHeight();; i = cxa.a(localConversationFooterView, localViewGroup))
    {
      if (b.a(i)) {
        d.b(i);
      }
      d = paramView;
      return;
    }
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final View.OnKeyListener c()
  {
    return f.w;
  }
  
  public final View f()
  {
    return d.findViewById(buc.dU);
  }
}

/* Location:
 * Qualified Name:     bxq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */