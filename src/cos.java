import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcEvent;
import com.android.mail.ui.MailActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class cos
  implements NfcAdapter.CreateNdefMessageCallback
{
  private static NdefMessage a(String paramString)
  {
    try
    {
      arrayOfByte = URLEncoder.encode(paramString, "UTF-8").getBytes("UTF-8");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        paramString = paramString.getBytes();
      }
    }
    arrayOfByte = new byte[paramString.length + 1];
    arrayOfByte[0] = 6;
    System.arraycopy(paramString, 0, arrayOfByte, 1, paramString.length);
    return new NdefMessage(new NdefRecord[] { new NdefRecord(1, NdefRecord.RTD_URI, new byte[0], arrayOfByte) });
  }
  
  public final NdefMessage createNdefMessage(NfcEvent paramNfcEvent)
  {
    if (MailActivity.t == null) {
      return null;
    }
    return a(MailActivity.t);
  }
}

/* Location:
 * Qualified Name:     cos
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */