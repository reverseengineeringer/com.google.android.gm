import android.widget.ProgressBar;

public final class bnn
{
  public final ProgressBar a;
  private final ProgressBar b;
  private boolean c;
  
  public bnn(ProgressBar paramProgressBar1, ProgressBar paramProgressBar2)
  {
    a = paramProgressBar1;
    b = paramProgressBar2;
    a(true);
  }
  
  private final void b(boolean paramBoolean)
  {
    int j = 8;
    ProgressBar localProgressBar = b;
    if (paramBoolean)
    {
      i = 0;
      localProgressBar.setVisibility(i);
      localProgressBar = a;
      if (!paramBoolean) {
        break label46;
      }
    }
    label46:
    for (int i = j;; i = 0)
    {
      localProgressBar.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8))
    {
      b.setVisibility(paramInt);
      a.setVisibility(paramInt);
      return;
    }
    b(c);
  }
  
  public final void a(boolean paramBoolean)
  {
    c = paramBoolean;
    b(c);
  }
}

/* Location:
 * Qualified Name:     bnn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */