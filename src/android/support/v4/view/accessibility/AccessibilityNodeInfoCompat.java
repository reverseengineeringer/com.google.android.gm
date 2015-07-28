package android.support.v4.view.accessibility;

import android.os.Build.VERSION;

public class AccessibilityNodeInfoCompat
{
  private static final AccessibilityNodeInfoImpl IMPL = new AccessibilityNodeInfoStubImpl();
  private final Object mInfo;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityNodeInfoJellybeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityNodeInfoIcsImpl();
      return;
    }
  }
  
  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    mInfo = paramObject;
  }
  
  public void addAction(int paramInt)
  {
    IMPL.addAction(mInfo, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (AccessibilityNodeInfoCompat)paramObject;
        if (mInfo != null) {
          break;
        }
      } while (mInfo == null);
      return false;
    } while (mInfo.equals(mInfo));
    return false;
  }
  
  public Object getInfo()
  {
    return mInfo;
  }
  
  public int hashCode()
  {
    if (mInfo == null) {
      return 0;
    }
    return mInfo.hashCode();
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    IMPL.setClassName(mInfo, paramCharSequence);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(mInfo, paramBoolean);
  }
  
  static class AccessibilityNodeInfoIcsImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
  {
    public void addAction(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatIcs.addAction(paramObject, paramInt);
    }
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setClassName(paramObject, paramCharSequence);
    }
    
    public void setScrollable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setScrollable(paramObject, paramBoolean);
    }
  }
  
  static abstract interface AccessibilityNodeInfoImpl
  {
    public abstract void addAction(Object paramObject, int paramInt);
    
    public abstract void setClassName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setScrollable(Object paramObject, boolean paramBoolean);
  }
  
  static class AccessibilityNodeInfoJellybeanImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
  {}
  
  static class AccessibilityNodeInfoStubImpl
    implements AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
  {
    public void addAction(Object paramObject, int paramInt) {}
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setScrollable(Object paramObject, boolean paramBoolean) {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */