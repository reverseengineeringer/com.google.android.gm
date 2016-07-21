import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.providers.Conversation;
import com.android.mail.ui.LeaveBehindItem;
import java.util.ArrayList;
import java.util.HashSet;

final class ckc
  extends AnimatorListenerAdapter
{
  ckc(cjy paramcjy) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if ((paramAnimator instanceof AnimatorSet))
    {
      paramAnimator = ((ObjectAnimator)((AnimatorSet)paramAnimator).getChildAnimations().get(0)).getTarget();
      cjy localcjy = a;
      HashSet localHashSet = a.d;
      if ((!localHashSet.isEmpty()) && ((paramAnimator instanceof ConversationItemView))) {
        localcjy.a(c.s.b, localHashSet);
      }
      localcjy = a;
      localHashSet = a.a;
      if ((!localHashSet.isEmpty()) && ((paramAnimator instanceof ConversationItemView))) {
        localcjy.a(c.s.b, localHashSet);
      }
      localcjy = a;
      localHashSet = a.e;
      if ((!localHashSet.isEmpty()) && ((paramAnimator instanceof ConversationItemView))) {
        localcjy.a(c.s.b, localHashSet);
      }
      localcjy = a;
      localHashSet = a.c;
      if ((!localHashSet.isEmpty()) && ((paramAnimator instanceof ConversationItemView))) {
        localcjy.a(c.s.b, localHashSet);
      }
      if ((a.d()) && ((paramAnimator instanceof LeaveBehindItem)))
      {
        paramAnimator = (LeaveBehindItem)paramAnimator;
        a.d(h.b);
        paramAnimator.a();
        if (!a.d())
        {
          paramAnimator = a.p();
          if (paramAnimator != null)
          {
            if ((n == null) || (n.isRunning())) {
              break label337;
            }
            paramAnimator.b();
          }
        }
      }
    }
    label337:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramAnimator.a(0);
      }
      a.notifyDataSetChanged();
      a.x();
      return;
      paramAnimator = ((ObjectAnimator)paramAnimator).getTarget();
      break;
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    if (!a.c.isEmpty())
    {
      a.a.clear();
      a.b.clear();
      a.d.clear();
    }
  }
}

/* Location:
 * Qualified Name:     ckc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */