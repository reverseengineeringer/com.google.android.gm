import android.app.ListActivity;
import android.os.Bundle;

public class dff
  extends ListActivity
{
  private final dgq a = new dgq();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.a(true);
  }
  
  protected void onResume()
  {
    super.onResume();
    a.a(true);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    a.a(false);
  }
  
  protected void onStart()
  {
    super.onStart();
    a.a(true);
  }
}

/* Location:
 * Qualified Name:     dff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */