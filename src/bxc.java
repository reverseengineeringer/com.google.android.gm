import android.content.Context;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityEvent;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.providers.Conversation;
import java.util.List;

public final class bxc
  extends xa
{
  private final ConversationItemView j;
  
  public bxc(ConversationItemView paramConversationItemView)
  {
    super(paramConversationItemView);
    j = paramConversationItemView;
  }
  
  protected final int a(float paramFloat1, float paramFloat2)
  {
    if (j.a(paramFloat1)) {
      return 2;
    }
    return 1;
  }
  
  protected final void a(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramAccessibilityEvent.setContentDescription(j.c());
      return;
    }
    paramAccessibilityEvent.setContentDescription(j.d());
  }
  
  protected final void a(int paramInt, uk paramuk)
  {
    j.getContext();
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramuk.a(16);
      return;
      paramuk.c(j.c());
      paramuk.b(j.g);
      Object localObject = j;
      if ((!e.w()) && (d)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        int i = buc.cu;
        localObject = j;
        if (c != null) {
          break label152;
        }
        localObject = null;
        localObject = new ul(i, (CharSequence)localObject);
        uk.a.a(b, w);
        break;
      }
      label152:
      if (f) {
        if (c.s.l) {
          paramInt = buj.ec;
        }
      }
      for (;;)
      {
        localObject = a.getString(paramInt);
        break;
        paramInt = buj.g;
        continue;
        if (c.s.l) {
          paramInt = buj.ee;
        } else {
          paramInt = buj.i;
        }
      }
      paramuk.c(j.d());
      paramuk.b(j.h);
    }
  }
  
  protected final void a(List<Integer> paramList)
  {
    if ((j.g.right > 0) && (j.g.bottom > 0))
    {
      paramList.add(Integer.valueOf(1));
      paramList.add(Integer.valueOf(2));
    }
  }
  
  protected final boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 16) {
      switch (paramInt1)
      {
      }
    }
    while (paramInt2 != buc.cu)
    {
      return false;
      j.performClick();
      return true;
      j.a(null);
      return true;
    }
    j.g();
    return true;
  }
}

/* Location:
 * Qualified Name:     bxc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */