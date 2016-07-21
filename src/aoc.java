import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class aoc
  extends DialogFragment
{
  public aob a;
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    if (a != null) {
      a.a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}

/* Location:
 * Qualified Name:     aoc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */