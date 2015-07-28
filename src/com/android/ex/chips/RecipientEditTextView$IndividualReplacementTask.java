package com.android.ex.chips;

import android.os.AsyncTask;
import android.os.Handler;
import android.text.Spannable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class RecipientEditTextView$IndividualReplacementTask
  extends AsyncTask<Object, Void, Void>
{
  private RecipientEditTextView$IndividualReplacementTask(RecipientEditTextView paramRecipientEditTextView) {}
  
  protected Void doInBackground(final Object... paramVarArgs)
  {
    paramVarArgs = (ArrayList)paramVarArgs[0];
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < paramVarArgs.size())
    {
      localObject2 = (RecipientChip)paramVarArgs.get(i);
      if (localObject2 != null) {
        ((ArrayList)localObject1).add(this$0.createAddressText(((RecipientChip)localObject2).getEntry()));
      }
      i += 1;
    }
    Object localObject2 = RecipientAlternatesAdapter.getMatchingRecipients(this$0.getContext(), (ArrayList)localObject1);
    Iterator localIterator = paramVarArgs.iterator();
    while (localIterator.hasNext())
    {
      final RecipientChip localRecipientChip = (RecipientChip)localIterator.next();
      if ((RecipientEntry.isCreatedRecipient(localRecipientChip.getEntry().getContactId())) && (this$0.getSpannable().getSpanStart(localRecipientChip) != -1))
      {
        localObject1 = RecipientEditTextView.access$2300(this$0, (RecipientEntry)((HashMap)localObject2).get(RecipientEditTextView.access$2200(this$0, localRecipientChip.getEntry().getDestination()).toLowerCase()));
        paramVarArgs = (Object[])localObject1;
        if (localObject1 == null)
        {
          paramVarArgs = (Object[])localObject1;
          if (!this$0.isPhoneQuery()) {
            paramVarArgs = localRecipientChip.getEntry();
          }
        }
        if (paramVarArgs != null) {
          RecipientEditTextView.access$500(this$0).post(new Runnable()
          {
            public void run()
            {
              this$0.replaceChip(localRecipientChip, paramVarArgs);
            }
          });
        }
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.IndividualReplacementTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */