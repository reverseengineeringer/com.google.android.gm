import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;

final class doi
  implements Preference.OnPreferenceClickListener
{
  doi(dnz paramdnz) {}
  
  public final boolean onPreferenceClick(Preference paramPreference)
  {
    paramPreference = a;
    new AlertDialog.Builder(paramPreference.getActivity()).setMessage(paramPreference.getString(dge.eU, new Object[] { a })).setNegativeButton(dge.bG, null).setPositiveButton(dge.eA, new dof(paramPreference)).create().show();
    return true;
  }
}

/* Location:
 * Qualified Name:     doi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */