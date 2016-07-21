import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionBarContainer;

public final class aeu
  extends aet
{
  public aeu(ActionBarContainer paramActionBarContainer)
  {
    super(paramActionBarContainer);
  }
  
  public final void getOutline(Outline paramOutline)
  {
    if (a.e) {
      if (a.d != null) {
        a.d.getOutline(paramOutline);
      }
    }
    while (a.b == null) {
      return;
    }
    a.b.getOutline(paramOutline);
  }
}

/* Location:
 * Qualified Name:     aeu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */