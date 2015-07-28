package com.google.android.gm;

import android.text.TextUtils;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LogUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class LabelOperations
{
  private static final Pattern OPERATION_LABEL_ADD_SEPERATOR_PATTERN = Pattern.compile("\\^\\*\\*\\^");
  private final Map<String, Operation> mOperations = Maps.newHashMap();
  
  public LabelOperations() {}
  
  public LabelOperations(Label paramLabel, boolean paramBoolean)
  {
    this();
    if (paramLabel != null)
    {
      add(paramLabel, paramBoolean);
      return;
    }
    LogUtils.e("Gmail", "LabelOperation created with null Label object", new Object[0]);
  }
  
  public static LabelOperations deserialize(String paramString)
  {
    LabelOperations localLabelOperations = new LabelOperations();
    if (paramString != null)
    {
      paramString = TextUtils.split(paramString, " ");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = TextUtils.split(paramString[i], OPERATION_LABEL_ADD_SEPERATOR_PATTERN);
        if (arrayOfString.length == 2) {
          localLabelOperations.add(Label.parseJoinedString(arrayOfString[0]), Boolean.valueOf(arrayOfString[1]).booleanValue());
        }
        i += 1;
      }
    }
    return localLabelOperations;
  }
  
  public static String serialize(LabelOperations paramLabelOperations)
  {
    if (paramLabelOperations == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramLabelOperations = mOperations.entrySet().iterator();
    while (paramLabelOperations.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramLabelOperations.next();
      localStringBuffer.append(getValuemLabel.serialize() + "^**^" + Boolean.toString(getValuemAdd) + " ");
    }
    return localStringBuffer.toString();
  }
  
  public void add(Label paramLabel, boolean paramBoolean)
  {
    Operation localOperation = new Operation(paramLabel, paramBoolean, null);
    mOperations.put(paramLabel.getCanonicalName(), localOperation);
  }
  
  public void clear()
  {
    mOperations.clear();
  }
  
  public int count()
  {
    return mOperations.size();
  }
  
  protected LabelOperations createNewInstance()
  {
    return new LabelOperations();
  }
  
  public List<Operation> getOperationList()
  {
    ArrayList localArrayList = Lists.newArrayList();
    Iterator localIterator = mOperations.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  public boolean hasApplyArchive()
  {
    return hasRemoveOperation("^i");
  }
  
  public boolean hasApplyMute()
  {
    return hasApplyOperation("^g");
  }
  
  public boolean hasApplyOperation(Label paramLabel)
  {
    return hasApplyOperation(paramLabel.getCanonicalName());
  }
  
  public boolean hasApplyOperation(String paramString)
  {
    if (hasOperation(paramString)) {
      return mOperations.get(paramString)).mAdd;
    }
    return false;
  }
  
  public boolean hasApplyRead()
  {
    return hasRemoveOperation("^u");
  }
  
  public boolean hasApplySpam()
  {
    return hasApplyOperation("^s");
  }
  
  public boolean hasApplyStar()
  {
    return hasOperation("^t");
  }
  
  public boolean hasApplyTrash()
  {
    return hasApplyOperation("^k");
  }
  
  public boolean hasApplyUnread()
  {
    return hasApplyOperation("^u");
  }
  
  public boolean hasMarkImportant()
  {
    return (hasApplyOperation("^^important")) || (hasRemoveOperation("^^unimportant"));
  }
  
  public boolean hasMarkNotImportant()
  {
    return (hasApplyOperation("^^unimportant")) || (hasRemoveOperation("^^important"));
  }
  
  public boolean hasMoveToInbox()
  {
    return hasApplyOperation("^i");
  }
  
  public boolean hasOperation(Label paramLabel)
  {
    return hasOperation(paramLabel.getCanonicalName());
  }
  
  public boolean hasOperation(String paramString)
  {
    return mOperations.containsKey(paramString);
  }
  
  public boolean hasRemoveOperation(Label paramLabel)
  {
    return hasRemoveOperation(paramLabel.getCanonicalName());
  }
  
  public boolean hasRemoveOperation(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (hasOperation(paramString))
    {
      bool1 = bool2;
      if (!mOperations.get(paramString)).mAdd) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public LabelOperations undoOperation()
  {
    LabelOperations localLabelOperations = createNewInstance();
    Iterator localIterator = mOperations.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Operation localOperation = (Operation)((Map.Entry)localIterator.next()).getValue();
      Label localLabel = mLabel;
      if (!mAdd) {}
      for (boolean bool = true;; bool = false)
      {
        localLabelOperations.add(localLabel, bool);
        break;
      }
    }
    return localLabelOperations;
  }
  
  public class Operation
  {
    public final boolean mAdd;
    public final Label mLabel;
    
    private Operation(Label paramLabel, boolean paramBoolean)
    {
      mLabel = paramLabel;
      mAdd = paramBoolean;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelOperations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */