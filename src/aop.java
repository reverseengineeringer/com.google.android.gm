import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;

final class aop
  implements DatePickerDialog.OnDateSetListener
{
  private aor a;
  
  public aop(aor paramaor)
  {
    a = paramaor;
  }
  
  public final void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    a.a(paramInt1, paramInt2, paramInt3);
  }
}

/* Location:
 * Qualified Name:     aop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */