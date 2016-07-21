public final class ii
  implements ir
{
  final String a;
  final int b;
  final String c;
  final boolean d;
  
  public ii(String paramString)
  {
    a = paramString;
    b = 0;
    c = null;
    d = true;
  }
  
  public ii(String paramString1, int paramInt, String paramString2)
  {
    a = paramString1;
    b = paramInt;
    c = null;
    d = false;
  }
  
  public final void a(gl paramgl)
  {
    if (d)
    {
      paramgl.a(a);
      return;
    }
    paramgl.a(a, b, c);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
    localStringBuilder.append("packageName:").append(a);
    localStringBuilder.append(", id:").append(b);
    localStringBuilder.append(", tag:").append(c);
    localStringBuilder.append(", all:").append(d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     ii
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */