import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;

final class cie
  implements ctd
{
  cie(cht paramcht) {}
  
  public final void a(Context paramContext)
  {
    cht localcht = a;
    DialogFragment localDialogFragment = (DialogFragment)i.findFragmentByTag("SyncErrorDialogFragment");
    paramContext = localDialogFragment;
    if (localDialogFragment == null) {
      paramContext = new cac();
    }
    paramContext.show(i, "SyncErrorDialogFragment");
  }
}

/* Location:
 * Qualified Name:     cie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */