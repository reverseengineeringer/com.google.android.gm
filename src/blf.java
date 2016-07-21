import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.android.ex.editstyledtext.EditStyledText;

public final class blf
  extends InputConnectionWrapper
{
  EditStyledText a;
  
  public blf(InputConnection paramInputConnection, EditStyledText paramEditStyledText)
  {
    super(paramInputConnection, true);
    a = paramEditStyledText;
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    a.b.c();
    return super.commitText(paramCharSequence, paramInt);
  }
  
  public final boolean finishComposingText()
  {
    if ((!a.b.b) && (!a.a()) && (!a.b.a)) {
      a.b();
    }
    return super.finishComposingText();
  }
}

/* Location:
 * Qualified Name:     blf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */