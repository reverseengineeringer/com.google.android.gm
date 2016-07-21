import android.app.Dialog;
import android.app.Fragment;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;

public final class apw
  extends aoc
{
  public TimePickerDialog.OnTimeSetListener b;
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments();
    int i = paramBundle.getInt("hour");
    int j = paramBundle.getInt("minute");
    boolean bool = paramBundle.getBoolean("24hour");
    paramBundle = b;
    Fragment localFragment = getTargetFragment();
    if ((localFragment instanceof aqa)) {
      paramBundle = new apy((aqa)localFragment);
    }
    return new apx(this, getActivity(), paramBundle, i, j, bool);
  }
}

/* Location:
 * Qualified Name:     apw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */