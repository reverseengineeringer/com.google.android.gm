import android.content.Intent;
import android.os.Bundle;

public class cbg
  extends cbk
{
  private boolean aa = false;
  
  protected final boolean g()
  {
    return false;
  }
  
  protected final boolean h()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aa = getIntent().getBooleanExtra("dontSendOrSave", false);
    if (!aa) {
      a(false, true, true);
    }
  }
}

/* Location:
 * Qualified Name:     cbg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */