import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.ConversationCheckedSet;

public final class cab
  extends FrameLayout
  implements caf
{
  public final ImageView a;
  public final ConversationItemView b;
  public int c;
  
  public cab(Context paramContext, Account paramAccount, bzn parambzn)
  {
    super(paramContext);
    a = new ImageView(paramContext);
    addView(a);
    ViewGroup.LayoutParams localLayoutParams = a.getLayoutParams();
    width = paramContext.getResources().getDimensionPixelSize(bua.ac);
    a.setLayoutParams(localLayoutParams);
    a.setScaleType(ImageView.ScaleType.CENTER);
    a.setVisibility(8);
    b = new ConversationItemView(paramContext, paramAccount, parambzn);
    addView(b);
    rg.c(this, 2);
  }
  
  public final void a()
  {
    a.setVisibility(8);
  }
  
  public final void a(Conversation paramConversation, ckv paramckv, ConversationCheckedSet paramConversationCheckedSet, Folder paramFolder, cjy paramcjy)
  {
    b.a(paramConversation, paramckv, paramConversationCheckedSet, paramFolder, paramcjy, false);
  }
  
  public final boolean e()
  {
    return b.a(null);
  }
}

/* Location:
 * Qualified Name:     cab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */