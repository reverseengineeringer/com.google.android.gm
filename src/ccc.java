import android.view.View;
import android.view.View.OnClickListener;
import com.android.ex.chips.RecipientEditTextView;

final class ccc
  implements View.OnClickListener
{
  private final RecipientEditTextView a;
  
  public ccc(RecipientEditTextView paramRecipientEditTextView)
  {
    a = paramRecipientEditTextView;
  }
  
  public final void onClick(View paramView)
  {
    a.requestFocus();
  }
}

/* Location:
 * Qualified Name:     ccc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */