import android.app.ApplicationErrorReport;
import android.app.ApplicationErrorReport.CrashInfo;
import com.google.android.gms.feedback.FeedbackOptions;

public final class fjm
  extends fjl
{
  public final ApplicationErrorReport f = new ApplicationErrorReport();
  private String g;
  
  public fjm()
  {
    f.crashInfo = new ApplicationErrorReport.CrashInfo();
    f.crashInfo.throwLineNumber = -1;
  }
  
  public final FeedbackOptions a()
  {
    enz.a(f.crashInfo.exceptionClassName);
    enz.a(f.crashInfo.throwFileName);
    enz.a(f.crashInfo.throwClassName);
    enz.a(f.crashInfo.throwMethodName);
    enz.a(f.crashInfo.stackTrace);
    return FeedbackOptions.d(FeedbackOptions.a(super.a(), f.crashInfo), g);
  }
}

/* Location:
 * Qualified Name:     fjm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */