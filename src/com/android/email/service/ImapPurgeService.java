package com.android.email.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import bas;
import com.android.mail.ui.MailActivity;
import cvm;

public class ImapPurgeService
  extends JobService
{
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    if (!MailActivity.s)
    {
      new bas(this).execute(new JobParameters[] { paramJobParameters });
      return true;
    }
    cvm.b(cvm.a, "App is in use, delaying imap purge", new Object[0]);
    jobFinished(paramJobParameters, true);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.ImapPurgeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */