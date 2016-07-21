import android.view.View;

public final class cqk
{
  public final View a;
  
  private cqk(View paramView)
  {
    a = paramView;
  }
  
  public static cqk a(View paramView)
  {
    paramView.setClickable(true);
    return new cqk(paramView);
  }
}

/* Location:
 * Qualified Name:     cqk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */