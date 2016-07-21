import android.database.sqlite.SQLiteDatabase;

final class dqy
  extends dpv
{
  dqy(drp paramdrp)
  {
    super(paramdrp, q);
  }
  
  public final void a()
  {
    dri.c(drp.b, "Bootstrapping db:%s Current version is %d", new Object[] { b.getPath(), Integer.valueOf(b.getVersion()) });
    cty.a(b, "internal_sync_settings");
    b.execSQL("CREATE TABLE internal_sync_settings (_id INTEGER PRIMARY KEY,name TEXT,value TEXT,UNIQUE (name))");
    b.setVersion(2);
  }
}

/* Location:
 * Qualified Name:     dqy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */