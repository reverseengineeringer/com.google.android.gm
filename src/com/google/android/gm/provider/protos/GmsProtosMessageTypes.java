package com.google.android.gm.provider.protos;

import com.google.common.io.protocol.ProtoBuf;
import com.google.common.io.protocol.ProtoBufType;

public class GmsProtosMessageTypes
{
  public static final ProtoBufType CONVERSATION_HEADER;
  public static final ProtoBufType EMAIL_ADDRESS;
  public static final ProtoBufType REQUEST = new ProtoBufType();
  public static final ProtoBufType RESPONSE_BEGIN_CONVERSATION;
  public static final ProtoBufType RESPONSE_BEGIN_MESSAGE;
  public static final ProtoBufType RESPONSE_CHECK_CONVERSATION;
  public static final ProtoBufType RESPONSE_CHUNK = new ProtoBufType();
  public static final ProtoBufType RESPONSE_CONFIG_ACCEPTED;
  public static final ProtoBufType RESPONSE_CONFIG_INFO;
  public static final ProtoBufType RESPONSE_END_CONVERSATION;
  public static final ProtoBufType RESPONSE_END_MESSAGE;
  public static final ProtoBufType RESPONSE_FORWARD_SYNC_OPERATION;
  public static final ProtoBufType RESPONSE_MESSAGE;
  public static final ProtoBufType RESPONSE_MESSAGE_BATCH;
  public static final ProtoBufType RESPONSE_NO_CONVERSATION;
  public static final ProtoBufType RESPONSE_NO_MESSAGE;
  public static final ProtoBufType RESPONSE_PREAMBLE = new ProtoBufType();
  public static final ProtoBufType RESPONSE_QUERY;
  public static final ProtoBufType RESPONSE_START_SYNC;
  public static final ProtoBufType RESPONSE_SYNC_POSTAMBLE;
  public static final ProtoBufType RESPONSE_UPHILL_SYNC;
  public static final ProtoBufType SENDER_INSTRUCTIONS;
  
  static
  {
    RESPONSE_CONFIG_INFO = new ProtoBufType();
    RESPONSE_CONFIG_ACCEPTED = new ProtoBufType();
    RESPONSE_START_SYNC = new ProtoBufType();
    RESPONSE_UPHILL_SYNC = new ProtoBufType();
    RESPONSE_CHECK_CONVERSATION = new ProtoBufType();
    RESPONSE_FORWARD_SYNC_OPERATION = new ProtoBufType();
    RESPONSE_SYNC_POSTAMBLE = new ProtoBufType();
    RESPONSE_BEGIN_CONVERSATION = new ProtoBufType();
    RESPONSE_END_CONVERSATION = new ProtoBufType();
    RESPONSE_BEGIN_MESSAGE = new ProtoBufType();
    RESPONSE_END_MESSAGE = new ProtoBufType();
    RESPONSE_NO_CONVERSATION = new ProtoBufType();
    RESPONSE_NO_MESSAGE = new ProtoBufType();
    RESPONSE_MESSAGE = new ProtoBufType();
    RESPONSE_MESSAGE_BATCH = new ProtoBufType();
    RESPONSE_QUERY = new ProtoBufType();
    EMAIL_ADDRESS = new ProtoBufType();
    SENDER_INSTRUCTIONS = new ProtoBufType();
    CONVERSATION_HEADER = new ProtoBufType();
    REQUEST.addElement(531, 1, null).addElement(538, 8, new ProtoBufType("GET_CONFIG_INFO")).addElement(538, 2, new ProtoBufType("CONFIG").addElement(533, 1, null).addElement(1052, 2, null).addElement(1052, 3, null)).addElement(538, 6, new ProtoBufType("START_SYNC").addElement(531, 1, null).addElement(531, 2, null).addElement(531, 3, null).addElement(531, 4, null).addElement(536, 5, ProtoBuf.FALSE).addElement(536, 6, ProtoBuf.FALSE).addElement(536, 7, ProtoBuf.FALSE).addElement(536, 8, ProtoBuf.FALSE).addElement(536, 9, ProtoBuf.FALSE).addElement(536, 10, ProtoBuf.FALSE)).addElement(538, 4, new ProtoBufType("MAIN_SYNC").addElement(531, 1, null).addElement(533, 3, null).addElement(531, 2, null).addElement(533, 4, null).addElement(533, 5, null).addElement(536, 6, ProtoBuf.FALSE).addElement(533, 7, new Long(0L)).addElement(536, 8, ProtoBuf.FALSE).addElement(536, 9, ProtoBuf.FALSE).addElement(536, 10, ProtoBuf.FALSE).addElement(533, 11, new Long(0L)).addElement(533, 12, new Long(4L)).addElement(536, 13, ProtoBuf.FALSE)).addElement(538, 3, new ProtoBufType("CONVERSATION_SYNC").addElement(1050, 1, new ProtoBufType("CONVERSATION_SYNC_CONVERSATION").addElement(531, 1, null).addElement(531, 2, null).addElement(1043, 3, null)).addElement(1043, 2, null).addElement(536, 3, ProtoBuf.FALSE).addElement(1043, 4, null)).addElement(538, 7, new ProtoBufType("UPHILL_SYNC").addElement(531, 2, null).addElement(1050, 1, new ProtoBufType("UPHILL_SYNC_OPERATION").addElement(531, 1, null).addElement(538, 2, new ProtoBufType("UPHILL_SYNC_OPERATION_MESSAGE_LABEL_ADDED_OR_REMOVED").addElement(531, 1, null).addElement(533, 2, null).addElement(536, 3, null).addElement(540, 4, null)).addElement(538, 3, new ProtoBufType("UPHILL_SYNC_OPERATION_CONVERSATION_LABEL_ADDED_OR_REMOVED").addElement(531, 1, null).addElement(533, 2, null).addElement(536, 3, null).addElement(540, 4, null)).addElement(538, 4, new ProtoBufType("UPHILL_SYNC_OPERATION_MESSAGE_SAVED_OR_SENT").addElement(531, 1, null).addElement(531, 2, null).addElement(540, 3, null).addElement(540, 4, null).addElement(540, 5, null).addElement(540, 6, null).addElement(540, 7, null).addElement(1052, 8, null).addElement(1050, 9, new ProtoBufType("UPHILL_SYNC_OPERATION_MESSAGE_SAVED_OR_SENT_UPLOADED_ATTACHMENT").addElement(540, 1, null).addElement(540, 2, null).addElement(540, 3, null).addElement(537, 4, null)).addElement(536, 10, null).addElement(536, 11, null).addElement(536, 12, null).addElement(533, 13, null).addElement(536, 14, ProtoBuf.FALSE).addElement(540, 15, null)).addElement(531, 5, null))).addElement(538, 5, new ProtoBufType("QUERY").addElement(540, 1, null).addElement(531, 2, null).addElement(533, 3, null).addElement(533, 4, null));
    RESPONSE_CHUNK.addElement(539, 1, RESPONSE_PREAMBLE).addElement(539, 2, RESPONSE_CONFIG_INFO).addElement(539, 3, RESPONSE_CONFIG_ACCEPTED).addElement(539, 4, RESPONSE_START_SYNC).addElement(539, 5, RESPONSE_UPHILL_SYNC).addElement(539, 7, RESPONSE_FORWARD_SYNC_OPERATION).addElement(539, 8, RESPONSE_CHECK_CONVERSATION).addElement(539, 9, RESPONSE_BEGIN_CONVERSATION).addElement(539, 10, RESPONSE_BEGIN_MESSAGE).addElement(539, 11, RESPONSE_MESSAGE).addElement(539, 12, RESPONSE_END_CONVERSATION).addElement(539, 13, RESPONSE_END_MESSAGE).addElement(539, 16, RESPONSE_NO_CONVERSATION).addElement(539, 17, RESPONSE_NO_MESSAGE).addElement(539, 14, RESPONSE_SYNC_POSTAMBLE).addElement(539, 15, RESPONSE_QUERY).addElement(539, 18, RESPONSE_MESSAGE_BATCH);
    RESPONSE_PREAMBLE.addElement(533, 1, null).addElement(533, 2, null).addElement(536, 3, ProtoBuf.FALSE).addElement(536, 4, ProtoBuf.FALSE).addElement(540, 5, "").addElement(533, 6, new Long(0L));
    RESPONSE_CONFIG_INFO.addElement(533, 1, null).addElement(1052, 2, null).addElement(1052, 3, null);
    RESPONSE_CONFIG_ACCEPTED.addElement(531, 1, null);
    RESPONSE_START_SYNC.addElement(531, 1, null).addElement(531, 2, null).addElement(531, 3, null).addElement(1050, 4, new ProtoBufType("LABEL").addElement(533, 1, null).addElement(540, 2, null).addElement(540, 3, null).addElement(533, 4, null).addElement(533, 5, null).addElement(533, 6, null).addElement(540, 7, null)).addElement(540, 5, null).addElement(540, 6, null).addElement(540, 7, null).addElement(540, 8, null).addElement(540, 9, null).addElement(540, 10, null).addElement(540, 11, null).addElement(540, 12, null).addElement(540, 13, null).addElement(540, 14, null).addElement(540, 15, null);
    RESPONSE_UPHILL_SYNC.addElement(1050, 1, new ProtoBufType("MESSAGE_NOT_HANDLED").addElement(531, 1, null).addElement(540, 2, null)).addElement(1050, 2, new ProtoBufType("MESSAGE_SAVED_OR_SENT").addElement(531, 1, null).addElement(531, 2, null).addElement(531, 3, null)).addElement(531, 3, null);
    RESPONSE_CHECK_CONVERSATION.addElement(531, 1, null).addElement(531, 2, null).addElement(539, 3, CONVERSATION_HEADER);
    RESPONSE_FORWARD_SYNC_OPERATION.addElement(531, 1, null).addElement(538, 2, new ProtoBufType("THREAD_LABELED_OR_UNLABELED").addElement(533, 1, null).addElement(531, 2, null).addElement(533, 3, null).addElement(533, 4, null).addElement(1043, 5, null)).addElement(538, 3, new ProtoBufType("LABEL_CREATED").addElement(533, 1, null).addElement(540, 2, null).addElement(540, 3, null)).addElement(538, 4, new ProtoBufType("LABEL_RENAMED").addElement(533, 1, null).addElement(540, 2, null).addElement(540, 3, null)).addElement(538, 5, new ProtoBufType("LABEL_DELETED").addElement(533, 1, null)).addElement(539, 8, RESPONSE_CHECK_CONVERSATION).addElement(538, 9, new ProtoBufType("PREFERENCE_CHANGE").addElement(540, 1, null).addElement(540, 2, null).addElement(536, 3, ProtoBuf.FALSE));
    RESPONSE_SYNC_POSTAMBLE.addElement(531, 1, null).addElement(531, 2, null).addElement(536, 3, ProtoBuf.FALSE).addElement(531, 4, null).addElement(1050, 5, new ProtoBufType("LABEL_COUNT_CHANGED").addElement(533, 1, null).addElement(533, 2, null).addElement(533, 3, null).addElement(533, 4, null).addElement(540, 5, null));
    RESPONSE_BEGIN_CONVERSATION.addElement(531, 1, null).addElement(533, 2, null).addElement(531, 3, null);
    RESPONSE_BEGIN_MESSAGE.addElement(531, 1, null);
    RESPONSE_NO_CONVERSATION.addElement(531, 1, null);
    RESPONSE_NO_MESSAGE.addElement(531, 1, null);
    RESPONSE_MESSAGE.addElement(531, 1, null).addElement(539, 2, EMAIL_ADDRESS).addElement(531, 3, null).addElement(531, 4, null).addElement(540, 5, null).addElement(540, 6, null).addElement(533, 7, null).addElement(536, 8, null).addElement(1051, 9, EMAIL_ADDRESS).addElement(1051, 10, EMAIL_ADDRESS).addElement(1051, 11, EMAIL_ADDRESS).addElement(1051, 12, EMAIL_ADDRESS).addElement(540, 13, null).addElement(1045, 14, null).addElement(1050, 15, new ProtoBufType("ATTACHMENT").addElement(540, 1, null).addElement(540, 2, null).addElement(540, 3, null).addElement(540, 4, null).addElement(533, 5, null)).addElement(537, 16, null).addElement(531, 17, null).addElement(537, 18, null).addElement(540, 19, null);
    RESPONSE_MESSAGE_BATCH.addElement(281, 1, null).addElement(275, 2, null).addElement(275, 3, null).addElement(537, 4, null);
    RESPONSE_QUERY.addElement(533, 1, null).addElement(531, 2, null).addElement(1050, 3, new ProtoBufType("CONVERSATION").addElement(531, 1, null).addElement(531, 2, null).addElement(531, 3, null).addElement(540, 4, null).addElement(540, 5, null).addElement(533, 6, null).addElement(531, 7, null).addElement(533, 8, null).addElement(536, 9, null).addElement(539, 10, SENDER_INSTRUCTIONS).addElement(1045, 11, null));
    EMAIL_ADDRESS.addElement(540, 1, null).addElement(540, 2, null);
    SENDER_INSTRUCTIONS.addElement(533, 1, null).addElement(533, 2, null).addElement(1050, 3, new ProtoBufType("SENDER").addElement(536, 1, null).addElement(536, 2, null).addElement(533, 3, null).addElement(540, 4, null));
    CONVERSATION_HEADER.addElement(531, 1, null).addElement(531, 2, null).addElement(531, 3, null).addElement(540, 4, null).addElement(540, 5, null).addElement(533, 6, null).addElement(531, 7, null).addElement(533, 8, null).addElement(536, 9, null).addElement(539, 10, SENDER_INSTRUCTIONS).addElement(1045, 11, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.protos.GmsProtosMessageTypes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */