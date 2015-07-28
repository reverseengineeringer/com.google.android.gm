package com.android.mail.compose;

class AttachmentsView$AttachmentFailureException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private final int errorRes;
  
  public AttachmentsView$AttachmentFailureException(String paramString)
  {
    super(paramString);
    errorRes = 2131492912;
  }
  
  public AttachmentsView$AttachmentFailureException(String paramString, int paramInt)
  {
    super(paramString);
    errorRes = paramInt;
  }
  
  public AttachmentsView$AttachmentFailureException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    errorRes = 2131492912;
  }
  
  public int getErrorRes()
  {
    return errorRes;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.AttachmentsView.AttachmentFailureException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */