package com.google.android.gm.utils;

import android.database.Cursor;
import android.graphics.Color;
import com.google.android.gm.provider.MailStore.CustomLabelColorPreference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LabelColorUtils
{
  public static ConcurrentHashMap<String, ConcurrentHashMap<String, String[]>> ACCOUNT_CUSTOM_LABEL_COLORS;
  public static String CUSTOM_BACKGROUND_COLOR = "background_color";
  public static String CUSTOM_COLOR_INDEX = "color_index";
  public static String CUSTOM_TEXT_COLOR = "text_color";
  private static final String[] DEFAULT_COLORS;
  public static int DEFAULT_COLOR_ID = -1;
  private static final String[][] LABEL_COLORS;
  private static final int[] MUTED_COLORS = { -16751053, -16751053 };
  private static final String[] MUTED_COLOR_STRINGS = { "#ff006633", "#ff006633" };
  private static final int NUM_COLORS = LABEL_COLORS.length;
  
  static
  {
    ACCOUNT_CUSTOM_LABEL_COLORS = new ConcurrentHashMap();
    DEFAULT_COLORS = new String[] { "#eeeeee", "#888888" };
    String[] arrayOfString1 = { "#f1f5ec", "#006633" };
    String[] arrayOfString2 = { "#dee5f2", "#5a6986" };
    String[] arrayOfString3 = { "#e0ecff", "#206cff" };
    String[] arrayOfString4 = { "#dfe2ff", "#0000cc" };
    String[] arrayOfString5 = { "#e0d5f9", "#5229a3" };
    String[] arrayOfString6 = { "#fde9f4", "#854f61" };
    String[] arrayOfString7 = { "#fadcb3", "#b36d00" };
    String[] arrayOfString8 = { "#f3e7b3", "#ab8b00" };
    String[] arrayOfString9 = { "#f9ffef", "#64992c" };
    String[] arrayOfString10 = { "#5a6986", "#dee5f2" };
    String[] arrayOfString11 = { "#206cff", "#e0ecff" };
    String[] arrayOfString12 = { "#0000cc", "#dfe2ff" };
    String[] arrayOfString13 = { "#5229a3", "#e0d5f9" };
    String[] arrayOfString14 = { "#854f61", "#fde9f4" };
    String[] arrayOfString15 = { "#ec7000", "#fff0e1" };
    String[] arrayOfString16 = { "#b36d00", "#fadcb3" };
    String[] arrayOfString17 = { "#636330", "#ffffd4" };
    String[] arrayOfString18 = { "#64992c", "#f9ffef" };
    String[] arrayOfString19 = { "#006633", "#f1f5ec" };
    LABEL_COLORS = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, { "#ffe3e3", "#cc0000" }, { "#fff0e1", "#ec7000" }, arrayOfString7, arrayOfString8, { "#ffffd4", "#636330" }, arrayOfString9, { "#f1f5ec", "#006633" }, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, { "#cc0000", "#ffe3e3" }, arrayOfString15, arrayOfString16, { "#ab8b00", "#f3e7b3" }, arrayOfString17, arrayOfString18, arrayOfString19 };
  }
  
  public static void addOrUpdateCustomLabelColor(String paramString1, String paramString2, MailStore.CustomLabelColorPreference paramCustomLabelColorPreference)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)ACCOUNT_CUSTOM_LABEL_COLORS.get(paramString1);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null)
    {
      localConcurrentHashMap1 = new ConcurrentHashMap();
      ACCOUNT_CUSTOM_LABEL_COLORS.put(paramString1, localConcurrentHashMap1);
    }
    localConcurrentHashMap1.put(paramString2, new String[] { backgroundColor, textColor });
  }
  
  public static int getDefaultLabelBackgroundColor()
  {
    return Color.parseColor(LABEL_COLORS[0][0]);
  }
  
  public static int[] getLabelColorInts(int paramInt, String paramString)
  {
    paramString = getLabelColorStrings(paramInt, paramString);
    return new int[] { Color.parseColor(paramString[0]), Color.parseColor(paramString[1]) };
  }
  
  public static int[] getLabelColorInts(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = getLabelColorInts(Integer.parseInt(paramString1), paramString2);
      return paramString1;
    }
    catch (NumberFormatException paramString1) {}
    return null;
  }
  
  public static String[] getLabelColorStrings(int paramInt, String paramString)
  {
    Object localObject;
    if (paramInt == DEFAULT_COLOR_ID)
    {
      localObject = DEFAULT_COLORS;
      return (String[])localObject;
    }
    if (paramInt < 0)
    {
      paramString = (Map)ACCOUNT_CUSTOM_LABEL_COLORS.get(paramString);
      if (paramString != null) {}
      for (paramString = (String[])paramString.get(paramInt + "");; paramString = DEFAULT_COLORS)
      {
        localObject = paramString;
        if (paramString != null) {
          break;
        }
        return DEFAULT_COLORS;
      }
    }
    if (paramInt >= NUM_COLORS) {
      return DEFAULT_COLORS;
    }
    return LABEL_COLORS[paramInt];
  }
  
  public static int[] getMutedColorInts()
  {
    return MUTED_COLORS;
  }
  
  public static void instantiateCustomLabelColors(String paramString, Cursor paramCursor)
  {
    if (paramCursor.moveToFirst())
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      int i = paramCursor.getColumnIndexOrThrow(CUSTOM_COLOR_INDEX);
      int j = paramCursor.getColumnIndexOrThrow(CUSTOM_BACKGROUND_COLOR);
      int k = paramCursor.getColumnIndexOrThrow(CUSTOM_TEXT_COLOR);
      do
      {
        localConcurrentHashMap.put(paramCursor.getString(i), new String[] { paramCursor.getString(j), paramCursor.getString(k) });
      } while (paramCursor.moveToNext());
      ACCOUNT_CUSTOM_LABEL_COLORS.put(paramString, localConcurrentHashMap);
    }
    paramCursor.close();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.utils.LabelColorUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */