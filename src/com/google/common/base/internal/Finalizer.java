package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Finalizer
  implements Runnable
{
  private static final Logger a = Logger.getLogger(Finalizer.class.getName());
  private static final Field e = b();
  private final WeakReference<Class<?>> b;
  private final PhantomReference<Object> c;
  private final ReferenceQueue<Object> d;
  
  private Finalizer(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference)
  {
    d = paramReferenceQueue;
    b = new WeakReference(paramClass);
    c = paramPhantomReference;
  }
  
  private final Method a()
  {
    Object localObject = (Class)b.get();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((Class)localObject).getMethod("finalizeReferent", new Class[0]);
      return (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new AssertionError(localNoSuchMethodException);
    }
  }
  
  private final boolean a(Reference<?> paramReference)
  {
    Method localMethod = a();
    if (localMethod == null) {
      return false;
    }
    for (;;)
    {
      paramReference.clear();
      if (paramReference == c) {
        break;
      }
      try
      {
        localMethod.invoke(paramReference, new Object[0]);
        Reference localReference = d.poll();
        paramReference = localReference;
        if (localReference != null) {
          continue;
        }
        return true;
      }
      catch (Throwable paramReference)
      {
        for (;;)
        {
          a.log(Level.SEVERE, "Error cleaning up after reference.", paramReference);
        }
      }
    }
  }
  
  private static Field b()
  {
    try
    {
      Field localField = Thread.class.getDeclaredField("inheritableThreadLocals");
      localField.setAccessible(true);
      return localField;
    }
    catch (Throwable localThrowable)
    {
      a.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
    }
    return null;
  }
  
  public static void startFinalizer(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference)
  {
    if (!paramClass.getName().equals("com.google.common.base.FinalizableReference")) {
      throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
    }
    paramClass = new Thread(new Finalizer(paramClass, paramReferenceQueue, paramPhantomReference));
    paramClass.setName(Finalizer.class.getName());
    paramClass.setDaemon(true);
    try
    {
      if (e != null) {
        e.set(paramClass, null);
      }
      paramClass.start();
      return;
    }
    catch (Throwable paramReferenceQueue)
    {
      for (;;)
      {
        a.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", paramReferenceQueue);
      }
    }
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        boolean bool = a(d.remove());
        if (!bool) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.base.internal.Finalizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */