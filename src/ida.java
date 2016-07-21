final class ida
{
  static int a(byte paramByte)
  {
    int i = Character.digit((char)paramByte, 16);
    if (i == -1) {
      throw new icu("Invalid URL encoding: not a valid digit (radix 16): " + paramByte);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     ida
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */