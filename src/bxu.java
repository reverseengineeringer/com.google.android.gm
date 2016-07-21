import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.browse.MessageHeaderView;

public final class bxu
  extends bxh
{
  public final bxp e;
  public ConversationMessage f;
  public boolean g;
  public boolean h;
  public boolean i;
  public CharSequence j;
  public CharSequence k;
  public CharSequence l;
  public final btq m;
  public CharSequence n;
  private long o;
  
  public bxu(bxp parambxp, btq parambtq, ConversationMessage paramConversationMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    e = parambxp;
    m = parambtq;
    f = paramConversationMessage;
    g = paramBoolean1;
    i = paramBoolean2;
    h = false;
  }
  
  public final int a()
  {
    return 2;
  }
  
  public final View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramContext = (MessageHeaderView)paramLayoutInflater.inflate(bue.r, paramViewGroup, false);
    paramContext.a(e.b, e.o);
    a = e.e;
    b = e.h;
    e = e.c;
    f = e.d;
    g = e.r;
    h = e.s;
    i = e.t;
    j = e.u;
    j.a(paramContext);
    k = e.n;
    paramContext.setTag("overlay_item_root");
    a(new View[] { paramContext, paramContext.findViewById(buc.fC), paramContext.findViewById(buc.bP), paramContext.findViewById(buc.bk), paramContext.findViewById(buc.dR), paramContext.findViewById(buc.dS), paramContext.findViewById(buc.df), paramContext.findViewById(buc.eB) });
    return paramContext;
  }
  
  public final void a(View paramView)
  {
    paramView = (MessageHeaderView)paramView;
    paramView.a(false);
    paramView.f();
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    ((MessageHeaderView)paramView).a(this, paramBoolean);
    d = paramView;
  }
  
  public final boolean a(ConversationMessage paramConversationMessage)
  {
    return hbc.a(f, paramConversationMessage);
  }
  
  public final void b(View paramView)
  {
    MessageHeaderView localMessageHeaderView = (MessageHeaderView)paramView;
    if ((c == null) || (c != this) || (localMessageHeaderView.isActivated() == localMessageHeaderView.d())) {}
    for (;;)
    {
      d = paramView;
      return;
      localMessageHeaderView.a(false);
    }
  }
  
  public final void b(ConversationMessage paramConversationMessage)
  {
    f = paramConversationMessage;
    n = null;
  }
  
  public final boolean b()
  {
    return !g;
  }
  
  public final View.OnKeyListener c()
  {
    return e.w;
  }
  
  public final View f()
  {
    return d.findViewById(buc.fC);
  }
  
  public final void g()
  {
    long l1 = 1209600000L;
    Object localObject;
    long l2;
    if (f.n != o)
    {
      o = f.n;
      localObject = m;
      l2 = o;
      if (!DateUtils.isToday(l2)) {
        break label147;
      }
      localObject = ((btq)localObject).a(l2, 1);
      j = ((CharSequence)localObject);
      localObject = m;
      l2 = o;
      if (!DateUtils.isToday(l2)) {
        break label180;
      }
      localObject = ((btq)localObject).a(l2, 1);
    }
    for (;;)
    {
      k = ((CharSequence)localObject);
      localObject = m;
      l1 = o;
      a.setLength(0);
      DateUtils.formatDateRange(c, b, l1, l1, 524309);
      l = a.toString();
      return;
      label147:
      if (btq.a(l2))
      {
        localObject = ((btq)localObject).a(l2, 65552);
        break;
      }
      localObject = ((btq)localObject).a(l2, 131088);
      break;
      label180:
      if (btq.a(l2))
      {
        localObject = c;
        long l3 = System.currentTimeMillis();
        long l4 = Math.abs(l3 - l2);
        if (1209600000L > 604800000L) {
          l1 = 604800000L;
        }
        for (;;)
        {
          if (l4 >= l1) {
            break label262;
          }
          localObject = DateUtils.getRelativeTimeSpanString(l2, l3, 86400000L, 65552);
          break;
          if (1209600000L < 86400000L) {
            l1 = 86400000L;
          }
        }
        label262:
        localObject = DateUtils.getRelativeTimeSpanString((Context)localObject, l2, false);
      }
      else
      {
        localObject = ((btq)localObject).a(l2, 131088);
      }
    }
  }
}

/* Location:
 * Qualified Name:     bxu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */