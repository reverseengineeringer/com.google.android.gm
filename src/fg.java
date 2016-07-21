import android.support.v4.app.Fragment;
import android.view.View;

public final class fg
  extends fn
{
  public fg(Fragment paramFragment) {}
  
  public final View a(int paramInt)
  {
    if (a.R == null) {
      throw new IllegalStateException("Fragment does not have a view");
    }
    return a.R.findViewById(paramInt);
  }
  
  public final boolean a()
  {
    return a.R != null;
  }
}

/* Location:
 * Qualified Name:     fg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */