import android.content.Context;
import android.content.res.Resources;
import com.android.mail.providers.Conversation;
import java.util.NavigableSet;

public final class bwy
  extends cni
{
  public final bzn a;
  public final mx b;
  public int c;
  
  public bwy(Context paramContext, bzn parambzn, mx parammx)
  {
    super(paramContext);
    a = parambzn;
    b = parammx;
  }
  
  public final int a(int[] paramArrayOfInt)
  {
    int i = 0;
    int k = paramArrayOfInt.length;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInt[i];
      i += 1;
    }
    return (paramArrayOfInt.length - 1) * f.f + j;
  }
  
  protected final void a()
  {
    super.a();
    Resources localResources = d.getResources();
    f.d = localResources.getDimensionPixelOffset(bua.Q);
    f.e = localResources.getDimensionPixelOffset(bua.O);
    f.g = localResources.getDimensionPixelOffset(bua.P);
  }
  
  public final void a(Conversation paramConversation, cus paramcus, int paramInt)
  {
    super.a(paramConversation, paramcus, paramInt);
    c = e.size();
  }
  
  public final void b()
  {
    super.b();
    c = 0;
  }
}

/* Location:
 * Qualified Name:     bwy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */