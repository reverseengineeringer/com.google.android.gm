import android.view.KeyEvent;

final class po
  extends pn
{
  public final int a(int paramInt)
  {
    return KeyEvent.normalizeMetaState(paramInt);
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    return KeyEvent.metaStateHasModifiers(paramInt1, paramInt2);
  }
  
  public final boolean b(int paramInt)
  {
    return KeyEvent.metaStateHasNoModifiers(paramInt);
  }
}

/* Location:
 * Qualified Name:     po
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */