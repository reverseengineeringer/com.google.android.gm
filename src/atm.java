import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

final class atm
  implements CompoundButton.OnCheckedChangeListener
{
  atm(atl paramatl) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    EditText localEditText = a.a;
    if (paramBoolean) {}
    for (paramCompoundButton = HideReturnsTransformationMethod.getInstance();; paramCompoundButton = PasswordTransformationMethod.getInstance())
    {
      localEditText.setTransformationMethod(paramCompoundButton);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     atm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */