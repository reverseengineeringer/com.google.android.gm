import android.database.sqlite.SQLiteDatabase;
import java.util.Stack;

public final class duy
{
  final SQLiteDatabase a;
  private final ThreadLocal<Stack<dvc>> b;
  private final ThreadLocal<Boolean> c = new duz(this);
  
  public duy(SQLiteDatabase paramSQLiteDatabase)
  {
    a = paramSQLiteDatabase;
    b = new dva(this);
  }
  
  private final Stack<dvc> e()
  {
    return (Stack)b.get();
  }
  
  public final void a()
  {
    e().push(new dvc(null));
    a.beginTransactionNonExclusive();
  }
  
  public final void a(dvb paramdvb)
  {
    e().push(new dvc(paramdvb));
    a.beginTransactionWithListenerNonExclusive(paramdvb);
  }
  
  public final void b()
  {
    c.set(Boolean.TRUE);
  }
  
  public final void c()
  {
    a.setTransactionSuccessful();
    epeekb = true;
  }
  
  public final void d()
  {
    a.endTransaction();
    Object localObject = (dvc)e().pop();
    int i;
    if ((b) && (!c))
    {
      i = 1;
      if (a != null)
      {
        if (i == 0) {
          break label100;
        }
        a.a(((Boolean)c.get()).booleanValue());
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = e();
        if (!((Stack)localObject).empty()) {
          peekc = true;
        }
      }
      return;
      i = 0;
      break;
      label100:
      a.a();
    }
  }
}

/* Location:
 * Qualified Name:     duy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */