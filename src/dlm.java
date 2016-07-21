import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gm.gmailify.GmailifyOptInActivity;

public final class dlm
  extends dkv
  implements TextWatcher, CompoundButton.OnCheckedChangeListener
{
  private EditText f;
  
  public dlm()
  {
    super(dga.J, "4b-password");
  }
  
  private final String c()
  {
    return f.getText().toString();
  }
  
  final CharSequence a()
  {
    return getString(dge.di);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  final void i()
  {
    Activity localActivity = getActivity();
    if ((localActivity instanceof dln)) {
      ((dln)localActivity).b(c());
    }
    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(f.getWindowToken(), 0);
    super.i();
  }
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    EditText localEditText;
    if (paramCompoundButton.getId() == dfy.ce)
    {
      localEditText = f;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (paramCompoundButton = HideReturnsTransformationMethod.getInstance();; paramCompoundButton = PasswordTransformationMethod.getInstance())
    {
      localEditText.setTransformationMethod(paramCompoundButton);
      return;
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (f != null) {
      paramBundle.putString("password", c());
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((TextView)paramView.findViewById(dfy.aP)).setText(getString(dge.dh, new Object[] { h() }));
    f = ((EditText)paramView.findViewById(dfy.aO));
    f.addTextChangedListener(this);
    Activity localActivity = getActivity();
    if ((localActivity instanceof GmailifyOptInActivity)) {
      f.setText(c);
    }
    ((CheckBox)paramView.findViewById(dfy.ce)).setOnCheckedChangeListener(this);
    if (paramBundle != null) {
      f.setText(paramBundle.getString("password"));
    }
  }
}

/* Location:
 * Qualified Name:     dlm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */