import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;

public final class dom
  extends Preference
{
  public dom(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private dom(Context paramContext, byte paramByte)
  {
    this(paramContext, null);
  }
  
  private dom(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, null, 0);
    setLayoutResource(dga.Y);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    paramView.findViewById(16908304).setOnClickListener(new don(this));
  }
  
  public final void setTitle(int paramInt)
  {
    throw new UnsupportedOperationException("TextOnlyPreference supports summary, not title");
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("TextOnlyPreference supports summary, not title");
  }
}

/* Location:
 * Qualified Name:     dom
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */