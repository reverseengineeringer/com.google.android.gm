import android.text.TextUtils.SimpleStringSplitter;

final class dpz
  extends TextUtils.SimpleStringSplitter
{
  public dpz()
  {
    super(',');
  }
  
  public final void setString(String paramString)
  {
    super.setString(paramString.substring(1));
  }
}

/* Location:
 * Qualified Name:     dpz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */