import android.app.job.JobParameters;
import android.os.AsyncTask;
import com.android.email.service.ImapPurgeService;

public final class bas
  extends AsyncTask<JobParameters, Void, Void>
{
  private JobParameters b;
  
  public bas(ImapPurgeService paramImapPurgeService) {}
  
  private final Void a(JobParameters... paramVarArgs)
  {
    b = paramVarArgs[0];
    bap.a(a);
    a.jobFinished(b, false);
    return null;
  }
}

/* Location:
 * Qualified Name:     bas
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */