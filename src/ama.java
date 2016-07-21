import android.view.View;

public abstract class ama
  extends aks
{
  boolean m = true;
  
  public abstract boolean a(alj paramalj);
  
  public abstract boolean a(alj paramalj, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final boolean a(alj paramalj, aku paramaku1, aku paramaku2)
  {
    int k = a;
    int n = b;
    paramaku1 = a;
    int i;
    if (paramaku2 == null)
    {
      i = paramaku1.getLeft();
      if (paramaku2 != null) {
        break label103;
      }
    }
    label103:
    for (int j = paramaku1.getTop();; j = b)
    {
      if ((paramalj.l()) || ((k == i) && (n == j))) {
        break label112;
      }
      paramaku1.layout(i, j, paramaku1.getWidth() + i, paramaku1.getHeight() + j);
      return a(paramalj, k, n, i, j);
      i = a;
      break;
    }
    label112:
    return a(paramalj);
  }
  
  public abstract boolean a(alj paramalj1, alj paramalj2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final boolean a(alj paramalj1, alj paramalj2, aku paramaku1, aku paramaku2)
  {
    int k = a;
    int n = b;
    int i;
    if (paramalj2.b()) {
      i = a;
    }
    for (int j = b;; j = b)
    {
      return a(paramalj1, paramalj2, k, n, i, j);
      i = a;
    }
  }
  
  public abstract boolean b(alj paramalj);
  
  public final boolean b(alj paramalj, aku paramaku1, aku paramaku2)
  {
    if ((paramaku1 != null) && ((a != a) || (b != b))) {
      return a(paramalj, a, b, a, b);
    }
    return b(paramalj);
  }
  
  public final boolean c(alj paramalj, aku paramaku1, aku paramaku2)
  {
    if ((a != a) || (b != b)) {
      return a(paramalj, a, b, a, b);
    }
    e(paramalj);
    return false;
  }
  
  public final boolean f(alj paramalj)
  {
    return (!m) || (paramalj.i());
  }
}

/* Location:
 * Qualified Name:     ama
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */