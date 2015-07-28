package com.android.mail.ui;

public abstract interface SubjectDisplayChanger
{
  public abstract void clearSubject();
  
  public abstract String getUnshownSubject(String paramString);
  
  public abstract void setSubject(String paramString);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SubjectDisplayChanger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */