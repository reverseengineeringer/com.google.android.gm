package com.android.mail.utils;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public class ContentProviderTask
  extends AsyncTask<Void, Void, Result>
{
  private static final String LOG_TAG = ;
  private String mAuthority;
  private ArrayList<ContentProviderOperation> mOps;
  private ContentResolver mResolver;
  
  protected Result doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = new Result(null);
    try
    {
      paramVarArgs.setSuccess(mResolver.applyBatch(mAuthority, mOps));
      return paramVarArgs;
    }
    catch (Exception localException)
    {
      LogUtils.w(LOG_TAG, localException, "exception executing ContentProviderOperationsTask", new Object[0]);
      paramVarArgs.setFailure(localException);
    }
    return paramVarArgs;
  }
  
  public void run(ContentResolver paramContentResolver, String paramString, ArrayList<ContentProviderOperation> paramArrayList)
  {
    mResolver = paramContentResolver;
    mAuthority = paramString;
    mOps = paramArrayList;
    executeOnExecutor(THREAD_POOL_EXECUTOR, new Void[] { (Void)null });
  }
  
  public static class Result
  {
    Exception exception;
    ContentProviderResult[] results;
    
    private void setFailure(Exception paramException)
    {
      results = null;
      exception = paramException;
    }
    
    private void setSuccess(ContentProviderResult[] paramArrayOfContentProviderResult)
    {
      exception = null;
      results = paramArrayOfContentProviderResult;
    }
  }
  
  public static class UpdateTask
    extends ContentProviderTask
  {
    public void run(ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      paramContentValues = ContentProviderOperation.newUpdate(paramUri).withValues(paramContentValues).withSelection(paramString, paramArrayOfString).build();
      super.run(paramContentResolver, paramUri.getAuthority(), Lists.newArrayList(new ContentProviderOperation[] { paramContentValues }));
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.ContentProviderTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */