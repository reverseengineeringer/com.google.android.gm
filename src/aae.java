import android.content.Context;
import android.widget.ArrayAdapter;

final class aae
  extends ArrayAdapter<CharSequence>
{
  public aae(Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence)
  {
    super(paramContext, paramInt, 16908308, paramArrayOfCharSequence);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     aae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */