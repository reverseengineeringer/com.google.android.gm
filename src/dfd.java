import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;

public class dfd
  extends Activity
  implements dng
{
  private static dfd d;
  private NfcAdapter a;
  dst b = new dfe(this);
  private NdefMessage c;
  private final dgq e = new dgq();
  
  public final String F_()
  {
    return getString(dge.bQ);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a = NfcAdapter.getDefaultAdapter(this);
    if (a != null)
    {
      paramBundle = dmv.a().b(this);
      if (paramBundle != null) {
        drp.a(this, paramBundle, b);
      }
    }
    e.a(true);
  }
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      if ((a != null) && (c != null)) {
        a.disableForegroundNdefPush(this);
      }
      d = null;
      return;
    }
    finally {}
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      d = this;
      if ((a != null) && (c != null)) {
        a.enableForegroundNdefPush(this, c);
      }
      e.a(true);
      return;
    }
    finally {}
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    e.a(false);
  }
  
  protected void onStart()
  {
    super.onStart();
    e.a(true);
  }
}

/* Location:
 * Qualified Name:     dfd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */