import android.app.Activity;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.android.mail.browse.SpamWarningView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Message;
import com.android.mail.ui.MailActivity;

public final class bzv
  extends ClickableSpan
{
  public bzv(SpamWarningView paramSpamWarningView, Account paramAccount, Message paramMessage, Resources paramResources) {}
  
  public final void onClick(View paramView)
  {
    ((btr)((MailActivity)d.getContext()).getApplication()).a().a((Activity)d.getContext(), a, b.ag, null);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(c.getColor(btz.O));
  }
}

/* Location:
 * Qualified Name:     bzv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */