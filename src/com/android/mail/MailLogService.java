package com.android.mail;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import btt;
import cvl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MailLogService
  extends Service
{
  public static boolean a = false;
  public static final String b = cvl.a;
  public static final Map<String, btt> c = new HashMap();
  
  protected void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (!a) {
      return;
    }
    paramPrintWriter.print("**** MailLogService ***\n");
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramPrintWriter.append("Logging for tag: \"");
      paramPrintWriter.append(str);
      paramPrintWriter.append("\"\n");
      paramPrintWriter.append(((btt)c.get(str)).toString());
    }
    super.dump(paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.MailLogService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */