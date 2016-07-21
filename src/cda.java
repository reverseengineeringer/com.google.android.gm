import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;

public class cda
  extends CursorWrapper
{
  private static final String a = cvl.a;
  private final ThreadLocal<Integer> b = new cdb(this);
  private final Object c = new Object();
  
  public cda(Cursor paramCursor)
  {
    super(paramCursor);
  }
  
  private final void a()
  {
    int i = ((Integer)b.get()).intValue();
    if ((!super.moveToPosition(i)) && (i >= 0)) {
      cvm.e(a, "Unexpected failure to move to current position: pos=%d, super.getPosition()=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(super.getPosition()) });
    }
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    synchronized (c)
    {
      a();
      super.copyStringToBuffer(paramInt, paramCharArrayBuffer);
      return;
    }
  }
  
  public byte[] getBlob(int paramInt)
  {
    synchronized (c)
    {
      a();
      byte[] arrayOfByte = super.getBlob(paramInt);
      return arrayOfByte;
    }
  }
  
  public double getDouble(int paramInt)
  {
    synchronized (c)
    {
      a();
      double d = super.getDouble(paramInt);
      return d;
    }
  }
  
  public float getFloat(int paramInt)
  {
    synchronized (c)
    {
      a();
      float f = super.getFloat(paramInt);
      return f;
    }
  }
  
  public int getInt(int paramInt)
  {
    synchronized (c)
    {
      a();
      paramInt = super.getInt(paramInt);
      return paramInt;
    }
  }
  
  public long getLong(int paramInt)
  {
    synchronized (c)
    {
      a();
      long l = super.getLong(paramInt);
      return l;
    }
  }
  
  public int getPosition()
  {
    return ((Integer)b.get()).intValue();
  }
  
  public short getShort(int paramInt)
  {
    synchronized (c)
    {
      a();
      short s = super.getShort(paramInt);
      return s;
    }
  }
  
  public String getString(int paramInt)
  {
    synchronized (c)
    {
      a();
      String str = super.getString(paramInt);
      return str;
    }
  }
  
  public boolean isNull(int paramInt)
  {
    synchronized (c)
    {
      a();
      boolean bool = super.isNull(paramInt);
      return bool;
    }
  }
  
  public boolean move(int paramInt)
  {
    return moveToPosition(((Integer)b.get()).intValue() + paramInt);
  }
  
  public boolean moveToFirst()
  {
    return moveToPosition(0);
  }
  
  public boolean moveToLast()
  {
    return moveToPosition(getCount() - 1);
  }
  
  public boolean moveToNext()
  {
    return moveToPosition(((Integer)b.get()).intValue() + 1);
  }
  
  public boolean moveToPosition(int paramInt)
  {
    int i = getCount();
    if (paramInt >= i)
    {
      b.set(Integer.valueOf(i));
      return false;
    }
    if (paramInt < 0)
    {
      b.set(Integer.valueOf(-1));
      return false;
    }
    if (paramInt == ((Integer)b.get()).intValue()) {
      return true;
    }
    b.set(Integer.valueOf(paramInt));
    return true;
  }
  
  public boolean moveToPrevious()
  {
    return moveToPosition(((Integer)b.get()).intValue() - 1);
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    if ((paramBundle.getInt("options") & 0x1) != 0) {
      synchronized (c)
      {
        a();
        paramBundle = super.respond(paramBundle);
        return paramBundle;
      }
    }
    return super.respond(paramBundle);
  }
}

/* Location:
 * Qualified Name:     cda
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */