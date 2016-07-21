import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import com.android.mail.browse.ConversationMessage;

public abstract class bxh
{
  public int a;
  public boolean b;
  public int c;
  public View d;
  private int e;
  
  public abstract int a();
  
  public abstract View a(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public void a(View paramView) {}
  
  public abstract void a(View paramView, boolean paramBoolean);
  
  public final void a(View... paramVarArgs)
  {
    View.OnKeyListener localOnKeyListener = c();
    if (localOnKeyListener != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        View localView = paramVarArgs[i];
        if (localView != null) {
          localView.setOnKeyListener(localOnKeyListener);
        }
        i += 1;
      }
    }
  }
  
  public final boolean a(int paramInt)
  {
    cvm.b("ConvLayout", "IN setHeight=%dpx of overlay item: %s", new Object[] { Integer.valueOf(paramInt), this });
    if (e != paramInt)
    {
      e = paramInt;
      b = true;
      return true;
    }
    return false;
  }
  
  public boolean a(ConversationMessage paramConversationMessage)
  {
    return false;
  }
  
  public void b(View paramView) {}
  
  public void b(ConversationMessage paramConversationMessage) {}
  
  public abstract boolean b();
  
  public View.OnKeyListener c()
  {
    return null;
  }
  
  public int d()
  {
    return 80;
  }
  
  public int e()
  {
    return e;
  }
  
  public View f()
  {
    return d;
  }
}

/* Location:
 * Qualified Name:     bxh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */