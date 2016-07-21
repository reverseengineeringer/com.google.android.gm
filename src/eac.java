import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;

public final class eac
{
  public static Uri a(String paramString)
  {
    return new Uri.Builder().scheme("wear").path(paramString).build();
  }
  
  public static dzm a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "Accounts data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (dzm)hlt.a(new dzm(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.Accounts proto");
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = String.valueOf(c(paramString1));
    return String.valueOf(paramString1).length() + 22 + String.valueOf(paramString2).length() + paramString1 + "/" + paramString2 + "/" + paramLong;
  }
  
  public static dzt b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "Accounts data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (dzt)hlt.a(new dzt(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.Folder proto");
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    return String.valueOf(paramString).length() + 17 + "/" + paramString + "/selected_folder";
  }
  
  public static dzz c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "WearData.RefreshReq data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (dzz)hlt.a(new dzz(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.RefreshReq proto");
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    return String.valueOf(paramString).length() + 14 + "/" + paramString + "/conversation";
  }
  
  public static dzo d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "WearData.ArchiveReq data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (dzo)hlt.a(new dzo(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.ArchiveReq proto");
    }
    return null;
  }
  
  public static dzw e(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "WearData.OpenOnPhoneReq data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (dzw)hlt.a(new dzw(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.OpenOnPhoneReq proto");
    }
    return null;
  }
  
  public static eaa f(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "WearData.ReplyReq data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (eaa)hlt.a(new eaa(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.ReplyReq proto");
    }
    return null;
  }
  
  public static dzs g(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "WearData.DeleteReq data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (dzs)hlt.a(new dzs(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.DeleteReq proto");
    }
    return null;
  }
  
  public static dzq h(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "WearData.ComposeReq data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (dzq)hlt.a(new dzq(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.ComposeReq proto");
    }
    return null;
  }
  
  public static dzv i(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "WearData.OpenDefaultInboxReq data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (dzv)hlt.a(new dzv(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.OpenDefaultInboxReq proto");
    }
    return null;
  }
  
  public static dzn j(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.w("GmailWear", "WearData.AnalyticsEvent data is null");
      return null;
    }
    try
    {
      paramArrayOfByte = (dzn)hlt.a(new dzn(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (hls paramArrayOfByte)
    {
      Log.w("GmailWear", "Failed to parse WearData.AnalyticsEvent proto");
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     eac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */