import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public final class cap
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new aag(getActivity()).a(buj.cq);
    CharSequence localCharSequence = getArguments().getCharSequence("attendees-text");
    a.h = localCharSequence;
    return paramBundle.a();
  }
}

/* Location:
 * Qualified Name:     cap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */