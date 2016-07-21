import android.app.ApplicationErrorReport;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.libraries.social.silentfeedback.nobinder.SilentFeedbackService;

public final class goi
  implements ejc
{
  public goi(SilentFeedbackService paramSilentFeedbackService, eiz parameiz, Intent paramIntent) {}
  
  public final void a(int paramInt) {}
  
  public final void a(Bundle paramBundle)
  {
    eiz localeiz = a;
    paramBundle = b;
    fjm localfjm = new fjm();
    if (paramBundle == null) {}
    for (paramBundle = localfjm.a();; paramBundle = localfjm.a())
    {
      fjg.b(localeiz, paramBundle).a(new goj(this));
      return;
      b = " ";
      e = true;
      String str;
      if (paramBundle.hasExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.exceptionClass"))
      {
        str = paramBundle.getStringExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.exceptionClass");
        f.crashInfo.exceptionClassName = str;
      }
      if (paramBundle.hasExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.stackTrace"))
      {
        str = paramBundle.getStringExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.stackTrace");
        f.crashInfo.stackTrace = str;
      }
      if (paramBundle.hasExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingClass"))
      {
        str = paramBundle.getStringExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingClass");
        f.crashInfo.throwClassName = str;
      }
      if (paramBundle.hasExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingFile"))
      {
        str = paramBundle.getStringExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingFile");
        f.crashInfo.throwFileName = str;
      }
      if (paramBundle.hasExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingLine"))
      {
        int i = paramBundle.getIntExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingLine", -1);
        f.crashInfo.throwLineNumber = i;
      }
      if (paramBundle.hasExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingMethod"))
      {
        str = paramBundle.getStringExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingMethod");
        f.crashInfo.throwMethodName = str;
      }
      if (paramBundle.hasExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.categoryTag")) {
        c = paramBundle.getStringExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.categoryTag");
      }
    }
  }
}

/* Location:
 * Qualified Name:     goi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */