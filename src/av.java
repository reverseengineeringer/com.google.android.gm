import android.view.ViewPropertyAnimator;

public class av
  extends ap
{
  boolean c;
  
  public av(di paramdi, bi parambi)
  {
    super(paramdi, parambi);
  }
  
  final void a(ba paramba, boolean paramBoolean)
  {
    if ((c) || (m.getVisibility() != 0)) {}
    do
    {
      return;
      if ((rg.w(m)) && (!m.isInEditMode())) {
        break;
      }
      m.a(8, false);
    } while (paramba == null);
    return;
    m.animate().cancel();
    m.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(p.c).setListener(new aw(this, false, paramba));
  }
  
  final void b(ba paramba, boolean paramBoolean)
  {
    if ((c) || (m.getVisibility() != 0))
    {
      if ((rg.w(m)) && (!m.isInEditMode()))
      {
        m.animate().cancel();
        if (m.getVisibility() != 0)
        {
          m.setAlpha(0.0F);
          m.setScaleY(0.0F);
          m.setScaleX(0.0F);
        }
        m.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(p.d).setListener(new ax(this, false, paramba));
      }
    }
    else {
      return;
    }
    m.a(0, false);
    m.setAlpha(1.0F);
    m.setScaleY(1.0F);
    m.setScaleX(1.0F);
  }
  
  boolean b()
  {
    return true;
  }
  
  final void c()
  {
    float f1 = m.getRotation();
    Object localObject;
    if (b != null)
    {
      localObject = b;
      float f2 = -f1;
      if (l != f2)
      {
        l = f2;
        ((bh)localObject).invalidateSelf();
      }
    }
    if (f != null)
    {
      localObject = f;
      f1 = -f1;
      if (f1 != j)
      {
        j = f1;
        ((y)localObject).invalidateSelf();
      }
    }
  }
}

/* Location:
 * Qualified Name:     av
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */