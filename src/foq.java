import android.app.ApplicationErrorReport.CrashInfo;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.feedback.ErrorReport;
import com.google.android.gms.feedback.FeedbackOptions;
import com.google.android.gms.feedback.FileTeleporter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class foq
  extends emr<for>
{
  private Context f;
  
  public foq(Context paramContext, Looper paramLooper, ejc paramejc, eje parameje, emc paramemc)
  {
    super(paramContext, paramLooper, 29, paramemc, paramejc, parameje);
    f = paramContext;
  }
  
  public static ErrorReport a(FeedbackOptions paramFeedbackOptions, File paramFile)
  {
    ErrorReport localErrorReport = new ErrorReport();
    if (paramFeedbackOptions != null)
    {
      if ((c != null) && (c.size() > 0)) {
        E = c;
      }
      if (!TextUtils.isEmpty(b)) {
        C = b;
      }
      if (!TextUtils.isEmpty(d)) {
        c = d;
      }
      if (paramFeedbackOptions.a() != null)
      {
        N = athrowMethodName;
        L = athrowLineNumber;
        M = athrowClassName;
        O = astackTrace;
        J = aexceptionClassName;
        P = aexceptionMessage;
        K = athrowFileName;
      }
      if (k != null) {
        Z = k;
      }
      if (!TextUtils.isEmpty(f)) {
        Q = f;
      }
      if (!TextUtils.isEmpty(h)) {
        b.packageName = h;
      }
      if ((g != null) && (paramFile != null))
      {
        T = g;
        T.a(paramFile);
      }
      if ((i != null) && (i.size() != 0) && (paramFile != null))
      {
        Iterator localIterator = i.iterator();
        while (localIterator.hasNext())
        {
          FileTeleporter localFileTeleporter = (FileTeleporter)localIterator.next();
          if (paramFile == null) {
            throw new NullPointerException("Cannot set null temp directory");
          }
          e = paramFile;
        }
        V = ((FileTeleporter[])i.toArray(new FileTeleporter[i.size()]));
      }
      if (l != null) {
        aa = l;
      }
      X = j;
    }
    return localErrorReport;
  }
  
  public final ErrorReport a(FeedbackOptions paramFeedbackOptions)
  {
    return a(paramFeedbackOptions, f.getCacheDir());
  }
  
  protected final String a()
  {
    return "com.google.android.gms.feedback.internal.IFeedbackService";
  }
  
  protected final String b()
  {
    return "com.google.android.gms.feedback.internal.IFeedbackService";
  }
}

/* Location:
 * Qualified Name:     foq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */