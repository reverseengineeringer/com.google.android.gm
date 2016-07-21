import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public final class dok
  extends Preference
{
  public dok(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private dok(Context paramContext, byte paramByte)
  {
    this(paramContext, null);
  }
  
  private dok(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, null, 0);
    setLayoutResource(dga.S);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    ((TextView)paramView.findViewById(dfy.a)).setText(getTitle());
  }
  
  public final void setSummary(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     dok
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */