import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public final class goc
{
  public static void a(Context paramContext, Throwable paramThrowable, String paramString)
  {
    paramThrowable = b(paramContext, paramThrowable, paramString);
    if (paramThrowable != null) {
      paramContext.startService(paramThrowable);
    }
  }
  
  private static void a(Throwable paramThrowable, StringBuilder paramStringBuilder, Set<Throwable> paramSet, String paramString)
  {
    while ((paramThrowable != null) && (!paramSet.contains(paramThrowable)))
    {
      paramSet.add(paramThrowable);
      if (paramString != null) {
        paramStringBuilder.append(paramString);
      }
      paramStringBuilder.append(paramThrowable.getClass().getName());
      paramStringBuilder.append(':');
      paramString = paramThrowable.getStackTrace();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        paramStringBuilder.append("\n\tat ");
        paramStringBuilder.append(localObject);
        i += 1;
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramString = paramThrowable.getSuppressed();
        j = paramString.length;
        i = 0;
        while (i < j)
        {
          a(paramString[i], paramStringBuilder, paramSet, "\nSuppressed: ");
          i += 1;
        }
      }
      if (paramThrowable.getCause() == null) {
        break;
      }
      paramThrowable = paramThrowable.getCause();
      paramString = "\nCaused by: ";
    }
  }
  
  private static Intent b(Context paramContext, Throwable paramThrowable, String paramString)
  {
    Object localObject2 = paramThrowable.getStackTrace();
    if (paramThrowable.getStackTrace().length == 0) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = paramContext.getPackageManager().getPackageInfo(paramContext.getApplicationContext().getPackageName(), 4);
        localObject1 = services;
        int j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label295;
        }
        localIntent = localObject1[i];
        if (name.matches("com\\.google\\.android\\.libraries\\.social\\.silentfeedback\\.\\w*\\.SilentFeedbackService"))
        {
          localObject1 = name;
          if (localObject1 != null) {
            break label113;
          }
          Log.e("SilentFeedback", "Could not find SilentFeedbackService, not sending crash info.");
          return null;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.e("SilentFeedback", "Could not find our own package. This should never happen. Not sending crash info.", paramContext);
        return null;
      }
      i += 1;
      continue;
      label113:
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName(paramContext.getApplicationContext(), (String)localObject1));
      localIntent.setPackage(paramContext.getApplicationContext().getPackageName());
      Object localObject1 = new StringBuilder();
      a(paramThrowable, (StringBuilder)localObject1, new HashSet(), null);
      localObject2 = localObject2[0];
      if (((StackTraceElement)localObject2).getFileName() != null) {}
      for (paramContext = ((StackTraceElement)localObject2).getFileName();; paramContext = "Unknown Source")
      {
        localIntent.putExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.exceptionClass", paramThrowable.getClass().getName());
        localIntent.putExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.stackTrace", ((StringBuilder)localObject1).toString());
        localIntent.putExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingClass", ((StackTraceElement)localObject2).getClassName());
        localIntent.putExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingFile", paramContext);
        localIntent.putExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingLine", ((StackTraceElement)localObject2).getLineNumber());
        localIntent.putExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.throwingMethod", ((StackTraceElement)localObject2).getMethodName());
        if (paramString != null) {
          localIntent.putExtra("com.google.android.libraries.social.silentfeedback.SilentFeedbackService.categoryTag", paramString);
        }
        return localIntent;
      }
      label295:
      localObject1 = null;
    }
  }
}

/* Location:
 * Qualified Name:     goc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */