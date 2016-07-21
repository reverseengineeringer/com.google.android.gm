import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.android.datetimepicker.time.RadialPickerLayout;
import java.util.ArrayList;

final class aqg
  implements View.OnKeyListener
{
  aqg(aqb paramaqb) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1)
    {
      paramKeyEvent = a;
      if ((paramInt == 111) || (paramInt == 4))
      {
        paramKeyEvent.dismiss();
        return true;
      }
      if (paramInt == 61)
      {
        if (l)
        {
          if (paramKeyEvent.a()) {
            paramKeyEvent.a(true);
          }
          return true;
        }
      }
      else
      {
        if (paramInt == 66)
        {
          if (l)
          {
            if (!paramKeyEvent.a()) {
              return true;
            }
            paramKeyEvent.a(false);
          }
          if (b != null) {
            b.a(d.c, d.d);
          }
          paramKeyEvent.dismiss();
          return true;
        }
        if (paramInt != 67) {
          break label231;
        }
        if ((l) && (!m.isEmpty()))
        {
          paramInt = paramKeyEvent.b();
          if (paramInt != paramKeyEvent.e(0)) {
            break label191;
          }
          paramView = e;
          aom.a(d, String.format(k, new Object[] { paramView }));
          paramKeyEvent.b(true);
        }
      }
      label191:
      label231:
      while ((paramInt != 7) && (paramInt != 8) && (paramInt != 9) && (paramInt != 10) && (paramInt != 11) && (paramInt != 12) && (paramInt != 13) && (paramInt != 14) && (paramInt != 15) && (paramInt != 16) && ((i) || ((paramInt != paramKeyEvent.e(0)) && (paramInt != paramKeyEvent.e(1))))) {
        for (;;)
        {
          return false;
          if (paramInt == paramKeyEvent.e(1)) {
            paramView = f;
          } else {
            paramView = String.format("%d", new Object[] { Integer.valueOf(aqb.d(paramInt)) });
          }
        }
      }
      if (!l)
      {
        if (d == null)
        {
          Log.e("TimePickerDialog", "Unable to initiate keyboard mode, TimePicker was null.");
          return true;
        }
        m.clear();
        paramKeyEvent.b(paramInt);
        return true;
      }
      if (paramKeyEvent.c(paramInt)) {
        paramKeyEvent.b(false);
      }
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     aqg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */