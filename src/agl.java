import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;

final class agl
  extends ny<Integer, PorterDuffColorFilter>
{
  public agl()
  {
    super(6);
  }
  
  static int a(int paramInt, PorterDuff.Mode paramMode)
  {
    return (paramInt + 31) * 31 + paramMode.hashCode();
  }
}

/* Location:
 * Qualified Name:     agl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */