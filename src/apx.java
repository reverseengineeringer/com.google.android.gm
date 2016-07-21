import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;

final class apx
  extends TimePickerDialog
{
  apx(apw paramapw, Context paramContext, TimePickerDialog.OnTimeSetListener paramOnTimeSetListener, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramOnTimeSetListener, paramInt1, paramInt2, paramBoolean);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      super.onClick(paramDialogInterface, paramInt);
      return;
    }
    cancel();
  }
}

/* Location:
 * Qualified Name:     apx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */