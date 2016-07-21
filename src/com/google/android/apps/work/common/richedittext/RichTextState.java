package com.google.android.apps.work.common.richedittext;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import dcr;
import ddd;

public class RichTextState
  implements Parcelable
{
  public static final Parcelable.Creator<RichTextState> CREATOR = new dcr();
  boolean a = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  public int g = -16777216;
  int h = -1;
  public String i = "sans-serif";
  boolean j = false;
  Layout.Alignment k = Layout.Alignment.ALIGN_NORMAL;
  
  public RichTextState(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      a = bool1;
      if (paramParcel.readByte() == 0) {
        break label204;
      }
      bool1 = true;
      label88:
      b = bool1;
      if (paramParcel.readByte() == 0) {
        break label209;
      }
      bool1 = true;
      label102:
      c = bool1;
      if (paramParcel.readByte() == 0) {
        break label214;
      }
      bool1 = true;
      label116:
      d = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
      bool1 = true;
      label130:
      e = bool1;
      if (paramParcel.readByte() == 0) {
        break label224;
      }
      bool1 = true;
      label144:
      f = bool1;
      g = paramParcel.readInt();
      h = paramParcel.readInt();
      i = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label229;
      }
    }
    label204:
    label209:
    label214:
    label219:
    label224:
    label229:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      j = bool1;
      k = ((Layout.Alignment)paramParcel.readSerializable());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label88;
      bool1 = false;
      break label102;
      bool1 = false;
      break label116;
      bool1 = false;
      break label130;
      bool1 = false;
      break label144;
    }
  }
  
  public RichTextState(Spanned paramSpanned, int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = paramSpanned.getSpans(paramInt1, paramInt2, Object.class);
    int i1 = arrayOfObject.length;
    int m = 0;
    if (m < i1)
    {
      Object localObject = arrayOfObject[m];
      int i2 = paramSpanned.getSpanStart(localObject);
      int i3 = paramSpanned.getSpanEnd(localObject);
      int n = paramSpanned.getSpanFlags(localObject);
      int i5;
      if (((n & 0x100) != 256) && (ddd.a(localObject)))
      {
        if (paramInt1 != paramInt2) {
          break label291;
        }
        int i4 = (n & 0x30) >> 4;
        i5 = n & 0x3;
        if (paramInt1 != paramSpanned.length()) {
          break label212;
        }
        n = 1;
        label180:
        if (paramInt1 != i2) {
          break label218;
        }
        if ((i4 != 2) && ((n == 0) || (i4 != 3))) {
          break label241;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        label212:
        n = 0;
        break label180;
        label218:
        if ((paramInt1 != i3) || ((i5 != 1) && ((n != 0) || (i5 != 3))))
        {
          for (;;)
          {
            label241:
            if ((localObject instanceof StyleSpan)) {
              switch (((StyleSpan)localObject).getStyle())
              {
              default: 
                break;
              case 1: 
                a = true;
                break;
                if ((i2 > paramInt1) || (i3 < paramInt2)) {
                  break;
                }
                break;
              case 2: 
                label291:
                b = true;
                break;
              }
            }
          }
          if ((localObject instanceof UnderlineSpan)) {
            c = true;
          } else if ((localObject instanceof StrikethroughSpan)) {
            d = true;
          } else if ((localObject instanceof SubscriptSpan)) {
            e = true;
          } else if ((localObject instanceof SuperscriptSpan)) {
            f = true;
          } else if ((localObject instanceof ForegroundColorSpan)) {
            g = ((ForegroundColorSpan)localObject).getForegroundColor();
          } else if ((localObject instanceof BackgroundColorSpan)) {
            h = ((BackgroundColorSpan)localObject).getBackgroundColor();
          } else if ((localObject instanceof TypefaceSpan)) {
            i = ((TypefaceSpan)localObject).getFamily();
          } else if ((localObject instanceof BulletSpan)) {
            j = true;
          } else if ((localObject instanceof AlignmentSpan)) {
            k = ((AlignmentSpan)localObject).getAlignment();
          }
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    String str1 = String.valueOf(Integer.toHexString(System.identityHashCode(this)));
    boolean bool1 = a;
    boolean bool2 = b;
    boolean bool3 = c;
    boolean bool4 = d;
    boolean bool5 = e;
    boolean bool6 = f;
    String str2 = String.valueOf(String.format("#%08X", new Object[] { Integer.valueOf(g & 0xFFFFFFFF) }));
    String str3 = String.valueOf(String.format("#%08X", new Object[] { Integer.valueOf(h & 0xFFFFFFFF) }));
    String str4 = i;
    boolean bool7 = j;
    String str5 = String.valueOf(k);
    return String.valueOf(str1).length() + 197 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + "RichTextState{" + str1 + " isBold=" + bool1 + " isItalic=" + bool2 + " isUnderline=" + bool3 + " isStrikethrough=" + bool4 + " isSubscript=" + bool5 + " isSuperscript=" + bool6 + " foregroundColor=" + str2 + " backgroundColor=" + str3 + " typefaceFamily=" + str4 + " isBullet=" + bool7 + " alignment=" + str5 + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    if (a)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!b) {
        break label145;
      }
      paramInt = 1;
      label26:
      paramParcel.writeByte((byte)paramInt);
      if (!c) {
        break label150;
      }
      paramInt = 1;
      label41:
      paramParcel.writeByte((byte)paramInt);
      if (!d) {
        break label155;
      }
      paramInt = 1;
      label56:
      paramParcel.writeByte((byte)paramInt);
      if (!e) {
        break label160;
      }
      paramInt = 1;
      label71:
      paramParcel.writeByte((byte)paramInt);
      if (!f) {
        break label165;
      }
      paramInt = 1;
      label86:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(g);
      paramParcel.writeInt(h);
      paramParcel.writeString(i);
      if (!j) {
        break label170;
      }
    }
    label145:
    label150:
    label155:
    label160:
    label165:
    label170:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeSerializable(k);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label26;
      paramInt = 0;
      break label41;
      paramInt = 0;
      break label56;
      paramInt = 0;
      break label71;
      paramInt = 0;
      break label86;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.work.common.richedittext.RichTextState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */