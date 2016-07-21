import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import com.google.android.gm.ComposeActivityGmail;

final class dir
  extends cog
{
  dir(diq paramdiq, String paramString, Fragment paramFragment, dbu paramdbu)
  {
    super(paramString, paramFragment);
  }
  
  public final void a()
  {
    b.dismiss();
    ComposeActivityGmail localComposeActivityGmail = (ComposeActivityGmail)b.getActivity();
    if (localComposeActivityGmail == null) {
      return;
    }
    if (a == null)
    {
      localComposeActivityGmail.g(b.b);
      return;
    }
    if ("NONE_FIXABLE".equals(a.a))
    {
      int i = b.a;
      boolean bool = b.b;
      dis localdis = new dis();
      Bundle localBundle = new Bundle(2);
      localBundle.putInt("numFiles", i);
      localBundle.putBoolean("showToast", bool);
      localdis.setArguments(localBundle);
      buo.a().a("acl_fixer", "none_fixable_dialog", "shown", 0L);
      localdis.show(localComposeActivityGmail.getFragmentManager(), "files-not-shared-dialog");
      return;
    }
    localComposeActivityGmail.a(null, a.b, b.a, b.b);
  }
}

/* Location:
 * Qualified Name:     dir
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */