import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

public final class aoo
  extends aoc
{
  DatePickerDialog.OnDateSetListener b;
  long c = -1L;
  long d = -1L;
  int e = -1;
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    Object localObject = getArguments();
    int i = ((Bundle)localObject).getInt("year");
    int j = ((Bundle)localObject).getInt("month");
    int k = ((Bundle)localObject).getInt("day");
    if (paramBundle != null)
    {
      e = paramBundle.getInt("first_day_of_week");
      c = paramBundle.getLong("min_date");
      d = paramBundle.getLong("max_date");
    }
    paramBundle = b;
    localObject = getTargetFragment();
    if ((localObject instanceof aor)) {
      paramBundle = new aop((aor)localObject);
    }
    paramBundle = new DatePickerDialog(getActivity(), paramBundle, i, j, k);
    localObject = paramBundle.getDatePicker();
    if (c != -1L) {
      ((DatePicker)localObject).setMinDate(c);
    }
    if (d != -1L) {
      ((DatePicker)localObject).setMaxDate(d);
    }
    if (e != -1) {
      ((DatePicker)localObject).setFirstDayOfWeek(e);
    }
    return paramBundle;
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putLong("min_date", c);
    paramBundle.putLong("max_date", d);
    paramBundle.putInt("first_day_of_week", e);
  }
}

/* Location:
 * Qualified Name:     aoo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */