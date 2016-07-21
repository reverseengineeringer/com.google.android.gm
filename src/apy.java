import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;

public final class apy
  implements TimePickerDialog.OnTimeSetListener
{
  private aqa a;
  
  public apy(aqa paramaqa)
  {
    a = paramaqa;
  }
  
  public final void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    a.a(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     apy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */