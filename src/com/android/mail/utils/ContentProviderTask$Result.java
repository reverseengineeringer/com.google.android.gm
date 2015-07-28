package com.android.mail.utils;

import android.content.ContentProviderResult;

public class ContentProviderTask$Result
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

/* Location:
 * Qualified Name:     com.android.mail.utils.ContentProviderTask.Result
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */