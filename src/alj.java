import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class alj
{
  private static final List<Object> p = Collections.EMPTY_LIST;
  public final View a;
  public int b;
  public int c;
  public long d;
  public int e;
  public int f;
  public alj g;
  public alj h;
  int i;
  List<Object> j;
  List<Object> k;
  ala l;
  boolean m;
  int n;
  public RecyclerView o;
  private int q;
  
  public final void a()
  {
    c = -1;
    f = -1;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    i = (i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    if (c == -1) {
      c = b;
    }
    if (f == -1) {
      f = b;
    }
    if (paramBoolean) {
      f += paramInt;
    }
    b += paramInt;
    if (a.getLayoutParams() != null) {
      a.getLayoutParams()).c = true;
    }
  }
  
  final void a(ala paramala, boolean paramBoolean)
  {
    l = paramala;
    m = paramBoolean;
  }
  
  public final void a(Object paramObject)
  {
    if (paramObject == null) {
      b(1024);
    }
    while ((i & 0x400) != 0) {
      return;
    }
    if (j == null)
    {
      j = new ArrayList();
      k = Collections.unmodifiableList(j);
    }
    j.add(paramObject);
  }
  
  public final void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = q - 1;
      q = i1;
      if (q >= 0) {
        break label61;
      }
      q = 0;
      Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
    }
    label61:
    do
    {
      return;
      i1 = q + 1;
      break;
      if ((!paramBoolean) && (q == 1))
      {
        i |= 0x10;
        return;
      }
    } while ((!paramBoolean) || (q != 0));
    i &= 0xFFFFFFEF;
  }
  
  public final boolean a(int paramInt)
  {
    return (i & paramInt) != 0;
  }
  
  public final void b(int paramInt)
  {
    i |= paramInt;
  }
  
  public final boolean b()
  {
    return (i & 0x80) != 0;
  }
  
  public final int c()
  {
    if (f == -1) {
      return b;
    }
    return f;
  }
  
  public final boolean d()
  {
    return l != null;
  }
  
  public final void e()
  {
    l.b(this);
  }
  
  public final boolean f()
  {
    return (i & 0x20) != 0;
  }
  
  public final void g()
  {
    i &= 0xFFFFFFDF;
  }
  
  public final void h()
  {
    i &= 0xFEFF;
  }
  
  public final boolean i()
  {
    return (i & 0x4) != 0;
  }
  
  public final boolean j()
  {
    return (i & 0x2) != 0;
  }
  
  public final boolean k()
  {
    return (i & 0x1) != 0;
  }
  
  public final boolean l()
  {
    return (i & 0x8) != 0;
  }
  
  public final boolean m()
  {
    return (i & 0x100) != 0;
  }
  
  public final void n()
  {
    if (j != null) {
      j.clear();
    }
    i &= 0xFBFF;
  }
  
  public final List<Object> o()
  {
    if ((i & 0x400) == 0)
    {
      if ((j == null) || (j.size() == 0)) {
        return p;
      }
      return k;
    }
    return p;
  }
  
  public final void p()
  {
    i = 0;
    b = -1;
    c = -1;
    d = -1L;
    f = -1;
    q = 0;
    g = null;
    h = null;
    n();
    n = 0;
  }
  
  public final boolean q()
  {
    return ((i & 0x10) == 0) && (!rg.b(a));
  }
  
  public final boolean r()
  {
    return (i & 0x2) != 0;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + b + " id=" + d + ", oldPos=" + c + ", pLpos:" + f);
    String str;
    if (d())
    {
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
      if (m)
      {
        str = "[changeScrap]";
        localStringBuilder2.append(str);
      }
    }
    else
    {
      if (i()) {
        localStringBuilder1.append(" invalid");
      }
      if (!k()) {
        localStringBuilder1.append(" unbound");
      }
      if (j()) {
        localStringBuilder1.append(" update");
      }
      if (l()) {
        localStringBuilder1.append(" removed");
      }
      if (b()) {
        localStringBuilder1.append(" ignored");
      }
      if (m()) {
        localStringBuilder1.append(" tmpDetached");
      }
      if (!q()) {
        localStringBuilder1.append(" not recyclable(" + q + ")");
      }
      if (((i & 0x200) == 0) && (!i())) {
        break label296;
      }
    }
    label296:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        localStringBuilder1.append(" undefined adapter position");
      }
      if (a.getParent() == null) {
        localStringBuilder1.append(" no parent");
      }
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
      str = "[attachedScrap]";
      break;
    }
  }
}

/* Location:
 * Qualified Name:     alj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */