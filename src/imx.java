public final class imx
  extends IllegalArgumentException
{
  public imx(imj paramimj)
  {
    super(String.valueOf(paramimj).length() + 26 + "'" + paramimj + "' is not an absolute name");
  }
}

/* Location:
 * Qualified Name:     imx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */