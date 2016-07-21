import android.util.JsonWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

final class gqc
  extends gsv
{
  private final JsonWriter a;
  private final gqb b;
  
  gqc(gqb paramgqb, JsonWriter paramJsonWriter)
  {
    b = paramgqb;
    a = paramJsonWriter;
    paramJsonWriter.setLenient(true);
  }
  
  public final void a()
  {
    a.flush();
  }
  
  public final void a(double paramDouble)
  {
    a.value(paramDouble);
  }
  
  public final void a(float paramFloat)
  {
    a.value(paramFloat);
  }
  
  public final void a(int paramInt)
  {
    a.value(paramInt);
  }
  
  public final void a(long paramLong)
  {
    a.value(paramLong);
  }
  
  public final void a(String paramString)
  {
    a.name(paramString);
  }
  
  public final void a(BigDecimal paramBigDecimal)
  {
    a.value(paramBigDecimal);
  }
  
  public final void a(BigInteger paramBigInteger)
  {
    a.value(paramBigInteger);
  }
  
  public final void a(boolean paramBoolean)
  {
    a.value(paramBoolean);
  }
  
  public final void b()
  {
    a.endArray();
  }
  
  public final void b(String paramString)
  {
    a.value(paramString);
  }
  
  public final void c()
  {
    a.endObject();
  }
  
  public final void d()
  {
    a.nullValue();
  }
  
  public final void e()
  {
    a.beginArray();
  }
  
  public final void f()
  {
    a.beginObject();
  }
  
  public final void g()
  {
    a.setIndent("  ");
  }
}

/* Location:
 * Qualified Name:     gqc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */