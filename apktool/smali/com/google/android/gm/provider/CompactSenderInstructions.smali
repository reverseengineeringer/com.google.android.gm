.class public Lcom/google/android/gm/provider/CompactSenderInstructions;
.super Ljava/lang/Object;
.source "CompactSenderInstructions.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/CompactSenderInstructions$2;
    }
.end annotation


# static fields
.field private static final SENDER_LIST_CACHE:Lcom/google/android/gm/provider/ObjectCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gm/provider/ObjectCache",
            "<",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final SENDER_LIST_SPLITTER:Landroid/text/TextUtils$SimpleStringSplitter;


# instance fields
.field private mHasErrors:Z

.field private mHasSending:Z

.field private mSenderInstructions:Lcom/google/android/gm/provider/SenderInstructions;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 28
    new-instance v0, Landroid/text/TextUtils$SimpleStringSplitter;

    sget-object v1, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {v1}, Ljava/lang/Character;->charValue()C

    move-result v1

    invoke-direct {v0, v1}, Landroid/text/TextUtils$SimpleStringSplitter;-><init>(C)V

    sput-object v0, Lcom/google/android/gm/provider/CompactSenderInstructions;->SENDER_LIST_SPLITTER:Landroid/text/TextUtils$SimpleStringSplitter;

    .line 33
    new-instance v0, Lcom/google/android/gm/provider/ObjectCache;

    new-instance v1, Lcom/google/android/gm/provider/CompactSenderInstructions$1;

    invoke-direct {v1}, Lcom/google/android/gm/provider/CompactSenderInstructions$1;-><init>()V

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lcom/google/android/gm/provider/ObjectCache;-><init>(Lcom/google/android/gm/provider/ObjectCache$Callback;I)V

    sput-object v0, Lcom/google/android/gm/provider/CompactSenderInstructions;->SENDER_LIST_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 22
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 48
    new-instance v0, Lcom/google/android/gm/provider/SenderInstructions;

    invoke-direct {v0}, Lcom/google/android/gm/provider/SenderInstructions;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mSenderInstructions:Lcom/google/android/gm/provider/SenderInstructions;

    .line 51
    iput-boolean v1, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mHasSending:Z

    .line 54
    iput-boolean v1, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mHasErrors:Z

    return-void
.end method

.method private static appendElided(Ljava/lang/StringBuilder;)V
    .locals 1
    .param p0, "builder"    # Ljava/lang/StringBuilder;

    .prologue
    .line 248
    const-string v0, "e"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 249
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 250
    return-void
.end method

.method private static appendNumDrafts(Ljava/lang/StringBuilder;I)V
    .locals 1
    .param p0, "builder"    # Ljava/lang/StringBuilder;
    .param p1, "numDrafts"    # I

    .prologue
    .line 229
    if-eqz p1, :cond_0

    .line 230
    const-string v0, "d"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 231
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 232
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 233
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 235
    :cond_0
    return-void
.end method

.method private static appendNumMessages(Ljava/lang/StringBuilder;I)V
    .locals 1
    .param p0, "builder"    # Ljava/lang/StringBuilder;
    .param p1, "numMessages"    # I

    .prologue
    .line 220
    const/4 v0, 0x1

    if-le p1, v0, :cond_0

    .line 221
    const-string v0, "n"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 222
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 223
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 224
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 226
    :cond_0
    return-void
.end method

.method private static appendSendFailed(Ljava/lang/StringBuilder;Z)V
    .locals 1
    .param p0, "builder"    # Ljava/lang/StringBuilder;
    .param p1, "sendFailed"    # Z

    .prologue
    .line 213
    if-eqz p1, :cond_0

    .line 214
    const-string v0, "f"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 215
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 217
    :cond_0
    return-void
.end method

.method private static appendSender(Ljava/lang/StringBuilder;ZILjava/lang/String;Z)V
    .locals 1
    .param p0, "builder"    # Ljava/lang/StringBuilder;
    .param p1, "unread"    # Z
    .param p2, "priority"    # I
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "useShortNames"    # Z

    .prologue
    .line 239
    if-eqz p1, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 240
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 241
    invoke-virtual {p0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 242
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 243
    if-eqz p4, :cond_0

    invoke-static {p3}, Lcom/google/android/gm/provider/CompactSenderInstructions;->shortNameFromLongName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p3

    .end local p3    # "name":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 244
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 245
    return-void

    .line 239
    .restart local p3    # "name":Ljava/lang/String;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static appendSending(Ljava/lang/StringBuilder;Z)V
    .locals 1
    .param p0, "builder"    # Ljava/lang/StringBuilder;
    .param p1, "hasSending"    # Z

    .prologue
    .line 206
    if-eqz p1, :cond_0

    .line 207
    const-string v0, "s"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 208
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 210
    :cond_0
    return-void
.end method

.method private static constructString(Ljava/util/Collection;IIIZZ)Ljava/lang/String;
    .locals 8
    .param p1, "numMessages"    # I
    .param p2, "numDrafts"    # I
    .param p3, "numVisibleSenders"    # I
    .param p4, "hasSending"    # Z
    .param p5, "hasErrors"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gm/provider/SenderInstructions$Sender;",
            ">;IIIZZ)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .local p0, "senders":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/SenderInstructions$Sender;>;"
    const/4 v4, 0x1

    .line 178
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 180
    .local v0, "builder":Ljava/lang/StringBuilder;
    invoke-static {v0, p4}, Lcom/google/android/gm/provider/CompactSenderInstructions;->appendSending(Ljava/lang/StringBuilder;Z)V

    .line 181
    invoke-static {v0, p5}, Lcom/google/android/gm/provider/CompactSenderInstructions;->appendSendFailed(Ljava/lang/StringBuilder;Z)V

    .line 182
    invoke-static {v0, p1}, Lcom/google/android/gm/provider/CompactSenderInstructions;->appendNumMessages(Ljava/lang/StringBuilder;I)V

    .line 183
    invoke-static {v0, p2}, Lcom/google/android/gm/provider/CompactSenderInstructions;->appendNumDrafts(Ljava/lang/StringBuilder;I)V

    .line 185
    if-le p3, v4, :cond_1

    .line 186
    .local v4, "useShortNames":Z
    :goto_0
    const/4 v1, 0x0

    .line 187
    .local v1, "elided":Z
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    .line 188
    .local v3, "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    sget-object v5, Lcom/google/android/gm/provider/CompactSenderInstructions$2;->$SwitchMap$com$google$android$gm$provider$SenderInstructions$Visibility:[I

    iget-object v6, v3, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    invoke-virtual {v6}, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    goto :goto_1

    .line 190
    :pswitch_0
    iget-boolean v5, v3, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    iget v6, v3, Lcom/google/android/gm/provider/SenderInstructions$Sender;->priority:I

    iget-object v7, v3, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    invoke-static {v0, v5, v6, v7, v4}, Lcom/google/android/gm/provider/CompactSenderInstructions;->appendSender(Ljava/lang/StringBuilder;ZILjava/lang/String;Z)V

    .line 192
    const/4 v1, 0x0

    .line 193
    goto :goto_1

    .line 185
    .end local v1    # "elided":Z
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    .end local v4    # "useShortNames":Z
    :cond_1
    const/4 v4, 0x0

    goto :goto_0

    .line 195
    .restart local v1    # "elided":Z
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v3    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    .restart local v4    # "useShortNames":Z
    :pswitch_1
    if-nez v1, :cond_0

    .line 196
    invoke-static {v0}, Lcom/google/android/gm/provider/CompactSenderInstructions;->appendElided(Ljava/lang/StringBuilder;)V

    .line 197
    const/4 v1, 0x1

    goto :goto_1

    .line 202
    .end local v3    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5

    .line 188
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static instructionsStringFromProto(Lcom/google/common/io/protocol/ProtoBuf;)Ljava/lang/String;
    .locals 13
    .param p0, "senderInstructions"    # Lcom/google/common/io/protocol/ProtoBuf;

    .prologue
    const/4 v12, 0x3

    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v4, 0x0

    .line 114
    invoke-virtual {p0, v10}, Lcom/google/common/io/protocol/ProtoBuf;->getInt(I)I

    move-result v1

    .line 116
    .local v1, "numMessages":I
    invoke-virtual {p0, v11}, Lcom/google/common/io/protocol/ProtoBuf;->getInt(I)I

    move-result v2

    .line 118
    .local v2, "numDrafts":I
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 120
    .local v0, "senders":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/SenderInstructions$Sender;>;"
    const/4 v3, 0x0

    .line 121
    .local v3, "numVisibleSenders":I
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v9

    .line 122
    .local v9, "senderProtos":Ljava/util/List;, "Ljava/util/List<Lcom/google/common/io/protocol/ProtoBuf;>;"
    invoke-static {p0, v12, v9}, Lcom/google/android/gm/provider/ProtoBufHelpers;->getAllProtoBufs(Lcom/google/common/io/protocol/ProtoBuf;ILjava/util/Collection;)V

    .line 125
    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/google/common/io/protocol/ProtoBuf;

    .line 126
    .local v8, "senderProto":Lcom/google/common/io/protocol/ProtoBuf;
    invoke-virtual {v8, v10}, Lcom/google/common/io/protocol/ProtoBuf;->getBool(I)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 128
    new-instance v7, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    invoke-direct {v7}, Lcom/google/android/gm/provider/SenderInstructions$Sender;-><init>()V

    .line 129
    .local v7, "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    sget-object v5, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->HIDDEN:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    iput-object v5, v7, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    .line 130
    invoke-interface {v0, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 132
    .end local v7    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    :cond_0
    new-instance v7, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    invoke-direct {v7}, Lcom/google/android/gm/provider/SenderInstructions$Sender;-><init>()V

    .line 133
    .restart local v7    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    invoke-virtual {v8, v11}, Lcom/google/common/io/protocol/ProtoBuf;->getBool(I)Z

    move-result v5

    iput-boolean v5, v7, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    .line 135
    invoke-virtual {v8, v12}, Lcom/google/common/io/protocol/ProtoBuf;->getInt(I)I

    move-result v5

    iput v5, v7, Lcom/google/android/gm/provider/SenderInstructions$Sender;->priority:I

    .line 137
    const/4 v5, 0x4

    invoke-virtual {v8, v5}, Lcom/google/common/io/protocol/ProtoBuf;->getString(I)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v7, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    .line 139
    sget-object v5, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->VISIBLE:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    iput-object v5, v7, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    .line 140
    add-int/lit8 v3, v3, 0x1

    .line 141
    invoke-interface {v0, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .end local v7    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    .end local v8    # "senderProto":Lcom/google/common/io/protocol/ProtoBuf;
    :cond_1
    move v5, v4

    .line 145
    invoke-static/range {v0 .. v5}, Lcom/google/android/gm/provider/CompactSenderInstructions;->constructString(Ljava/util/Collection;IIIZZ)Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method public static instructionsStringFromXml(Lcom/google/wireless/gdata2/parser/xml/SimplePullParser;)Ljava/lang/String;
    .locals 11
    .param p0, "parser"    # Lcom/google/wireless/gdata2/parser/xml/SimplePullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/wireless/gdata2/parser/xml/SimplePullParser$ParseException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    const/4 v4, 0x0

    .line 77
    const/4 v7, 0x0

    .line 79
    .local v7, "namespace":Ljava/lang/String;
    const-string v5, "numMessages"

    invoke-virtual {p0, v10, v5}, Lcom/google/wireless/gdata2/parser/xml/SimplePullParser;->getIntAttribute(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 80
    .local v1, "numMessages":I
    const-string v5, "numDrafts"

    invoke-virtual {p0, v10, v5}, Lcom/google/wireless/gdata2/parser/xml/SimplePullParser;->getIntAttribute(Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .line 81
    .local v2, "numDrafts":I
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 83
    .local v0, "senders":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/SenderInstructions$Sender;>;"
    const/4 v3, 0x0

    .line 84
    .local v3, "numVisibleSenders":I
    invoke-virtual {p0}, Lcom/google/wireless/gdata2/parser/xml/SimplePullParser;->getDepth()I

    move-result v6

    .line 85
    .local v6, "depth":I
    :cond_0
    :goto_0
    invoke-virtual {p0, v6}, Lcom/google/wireless/gdata2/parser/xml/SimplePullParser;->nextTag(I)Ljava/lang/String;

    move-result-object v9

    .local v9, "tag":Ljava/lang/String;
    if-eqz v9, :cond_3

    .line 86
    const-string v5, "sender"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 87
    new-instance v8, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    invoke-direct {v8}, Lcom/google/android/gm/provider/SenderInstructions$Sender;-><init>()V

    .line 88
    .local v8, "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    const-string v5, "unread"

    invoke-virtual {p0, v7, v5}, Lcom/google/wireless/gdata2/parser/xml/SimplePullParser;->getIntAttribute(Ljava/lang/String;Ljava/lang/String;)I

    move-result v5

    if-eqz v5, :cond_1

    const/4 v5, 0x1

    :goto_1
    iput-boolean v5, v8, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    .line 89
    const-string v5, "priority"

    invoke-virtual {p0, v7, v5}, Lcom/google/wireless/gdata2/parser/xml/SimplePullParser;->getIntAttribute(Ljava/lang/String;Ljava/lang/String;)I

    move-result v5

    iput v5, v8, Lcom/google/android/gm/provider/SenderInstructions$Sender;->priority:I

    .line 90
    const-string v5, "name"

    invoke-virtual {p0, v7, v5}, Lcom/google/wireless/gdata2/parser/xml/SimplePullParser;->getStringAttribute(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v8, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    .line 91
    sget-object v5, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->VISIBLE:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    iput-object v5, v8, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    .line 92
    add-int/lit8 v3, v3, 0x1

    .line 93
    invoke-interface {v0, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    move v5, v4

    .line 88
    goto :goto_1

    .line 94
    .end local v8    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    :cond_2
    const-string v5, "elided"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 95
    new-instance v8, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    invoke-direct {v8}, Lcom/google/android/gm/provider/SenderInstructions$Sender;-><init>()V

    .line 96
    .restart local v8    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    sget-object v5, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->HIDDEN:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    iput-object v5, v8, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    .line 97
    invoke-interface {v0, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .end local v8    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    :cond_3
    move v5, v4

    .line 101
    invoke-static/range {v0 .. v5}, Lcom/google/android/gm/provider/CompactSenderInstructions;->constructString(Ljava/util/Collection;IIIZZ)Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method public static parseCompactSenderInstructions(Ljava/lang/String;Lcom/google/android/gm/provider/SenderInstructions;)V
    .locals 14
    .param p0, "compactInstructions"    # Ljava/lang/String;
    .param p1, "instructions"    # Lcom/google/android/gm/provider/SenderInstructions;

    .prologue
    .line 315
    sget-object v0, Lcom/google/android/gm/provider/CompactSenderInstructions;->SENDER_LIST_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/ObjectCache;->get()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/List;

    .line 317
    .local v12, "senderFragments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :try_start_0
    invoke-interface {v12}, Ljava/util/List;->clear()V

    .line 319
    sget-object v2, Lcom/google/android/gm/provider/CompactSenderInstructions;->SENDER_LIST_SPLITTER:Landroid/text/TextUtils$SimpleStringSplitter;

    monitor-enter v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 320
    :try_start_1
    sget-object v0, Lcom/google/android/gm/provider/CompactSenderInstructions;->SENDER_LIST_SPLITTER:Landroid/text/TextUtils$SimpleStringSplitter;

    invoke-virtual {v0, p0}, Landroid/text/TextUtils$SimpleStringSplitter;->setString(Ljava/lang/String;)V

    .line 322
    :goto_0
    sget-object v0, Lcom/google/android/gm/provider/CompactSenderInstructions;->SENDER_LIST_SPLITTER:Landroid/text/TextUtils$SimpleStringSplitter;

    invoke-virtual {v0}, Landroid/text/TextUtils$SimpleStringSplitter;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 323
    sget-object v0, Lcom/google/android/gm/provider/CompactSenderInstructions;->SENDER_LIST_SPLITTER:Landroid/text/TextUtils$SimpleStringSplitter;

    invoke-virtual {v0}, Landroid/text/TextUtils$SimpleStringSplitter;->next()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v12, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 325
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 362
    :catchall_1
    move-exception v0

    sget-object v2, Lcom/google/android/gm/provider/CompactSenderInstructions;->SENDER_LIST_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v2, v12}, Lcom/google/android/gm/provider/ObjectCache;->release(Ljava/lang/Object;)V

    throw v0

    .line 325
    :cond_0
    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 327
    const/4 v9, 0x0

    .local v9, "i":I
    move v10, v9

    .end local v9    # "i":I
    .local v10, "i":I
    :goto_1
    :try_start_4
    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v0

    if-ge v10, v0, :cond_a

    .line 328
    add-int/lit8 v9, v10, 0x1

    .end local v10    # "i":I
    .restart local v9    # "i":I
    invoke-interface {v12, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 329
    .local v8, "fragment0":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    :goto_2
    move v10, v9

    .line 360
    .end local v9    # "i":I
    .restart local v10    # "i":I
    goto :goto_1

    .line 331
    .end local v10    # "i":I
    .restart local v9    # "i":I
    :cond_2
    const-string v0, "e"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 333
    const-string v0, "n"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 334
    add-int/lit8 v9, v9, 0x1

    goto :goto_2

    .line 335
    :cond_3
    const-string v0, "d"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 336
    add-int/lit8 v10, v9, 0x1

    .end local v9    # "i":I
    .restart local v10    # "i":I
    invoke-interface {v12, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/google/android/gm/provider/SenderInstructions;->setNumDrafts(I)V

    move v9, v10

    .end local v10    # "i":I
    .restart local v9    # "i":I
    goto :goto_2

    .line 337
    :cond_4
    const-string v0, "l"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 338
    add-int/lit8 v10, v9, 0x1

    .end local v9    # "i":I
    .restart local v10    # "i":I
    invoke-interface {v12, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 339
    .local v1, "literal":Ljava/lang/String;
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_6

    const/4 v4, 0x1

    :goto_3
    const/4 v5, -0x1

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/SenderInstructions;->addMessage(Ljava/lang/String;ZZZI)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move v9, v10

    .line 362
    .end local v1    # "literal":Ljava/lang/String;
    .end local v8    # "fragment0":Ljava/lang/String;
    .end local v10    # "i":I
    .restart local v9    # "i":I
    :cond_5
    :goto_4
    sget-object v0, Lcom/google/android/gm/provider/CompactSenderInstructions;->SENDER_LIST_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v0, v12}, Lcom/google/android/gm/provider/ObjectCache;->release(Ljava/lang/Object;)V

    .line 364
    return-void

    .line 339
    .end local v9    # "i":I
    .restart local v1    # "literal":Ljava/lang/String;
    .restart local v8    # "fragment0":Ljava/lang/String;
    .restart local v10    # "i":I
    :cond_6
    const/4 v4, 0x0

    goto :goto_3

    .line 341
    .end local v1    # "literal":Ljava/lang/String;
    .end local v10    # "i":I
    .restart local v9    # "i":I
    :cond_7
    :try_start_5
    const-string v0, "s"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 343
    const-string v0, "f"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 346
    add-int/lit8 v0, v9, 0x2

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v2

    if-gt v0, v2, :cond_5

    .line 352
    move-object v13, v8

    .line 353
    .local v13, "unreadString":Ljava/lang/String;
    invoke-static {v13}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_8

    const/4 v5, 0x1

    .line 354
    .local v5, "unread":Z
    :goto_5
    add-int/lit8 v10, v9, 0x1

    .end local v9    # "i":I
    .restart local v10    # "i":I
    invoke-interface {v12, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 355
    .local v11, "priorityString":Ljava/lang/String;
    add-int/lit8 v9, v10, 0x1

    .end local v10    # "i":I
    .restart local v9    # "i":I
    invoke-interface {v12, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 356
    .local v3, "nameString":Ljava/lang/String;
    invoke-static {v11}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v7

    .line 357
    .local v7, "priority":I
    const/4 v4, 0x0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    const/4 v6, 0x1

    :goto_6
    move-object v2, p1

    invoke-virtual/range {v2 .. v7}, Lcom/google/android/gm/provider/SenderInstructions;->addMessage(Ljava/lang/String;ZZZI)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto/16 :goto_2

    .line 353
    .end local v3    # "nameString":Ljava/lang/String;
    .end local v5    # "unread":Z
    .end local v7    # "priority":I
    .end local v11    # "priorityString":Ljava/lang/String;
    :cond_8
    const/4 v5, 0x0

    goto :goto_5

    .line 357
    .restart local v3    # "nameString":Ljava/lang/String;
    .restart local v5    # "unread":Z
    .restart local v7    # "priority":I
    .restart local v11    # "priorityString":Ljava/lang/String;
    :cond_9
    const/4 v6, 0x0

    goto :goto_6

    .end local v3    # "nameString":Ljava/lang/String;
    .end local v5    # "unread":Z
    .end local v7    # "priority":I
    .end local v8    # "fragment0":Ljava/lang/String;
    .end local v9    # "i":I
    .end local v11    # "priorityString":Ljava/lang/String;
    .end local v13    # "unreadString":Ljava/lang/String;
    .restart local v10    # "i":I
    :cond_a
    move v9, v10

    .end local v10    # "i":I
    .restart local v9    # "i":I
    goto :goto_4
.end method

.method private static shortNameFromLongName(Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p0, "fullName"    # Ljava/lang/String;

    .prologue
    const/4 v11, 0x2

    const/4 v10, 0x1

    .line 260
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    .line 261
    const-string v9, "\""

    invoke-virtual {p0, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    const-string v9, "\""

    invoke-virtual {p0, v9}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v9

    if-lt v9, v11, :cond_0

    .line 264
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    invoke-virtual {p0, v10, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    .line 266
    :cond_0
    move-object v5, p0

    .line 272
    .local v5, "tempName":Ljava/lang/String;
    const/16 v9, 0x2c

    invoke-virtual {v5, v9}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 273
    .local v1, "commaIndex":I
    const/4 v9, -0x1

    if-eq v1, v9, :cond_2

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    if-eq v1, v9, :cond_2

    .line 274
    const/4 v9, 0x0

    invoke-virtual {v5, v9, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 275
    .local v4, "partBeforeComma":Ljava/lang/String;
    const-string v9, "\\s+"

    invoke-static {v4, v9}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 276
    .local v8, "wordsBeforeComma":[Ljava/lang/String;
    const/4 v3, 0x0

    .line 278
    .local v3, "numNonAbbrev":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v9, v8

    if-ge v2, v9, :cond_1

    .line 279
    aget-object v6, v8, v2

    .line 280
    .local v6, "word":Ljava/lang/String;
    const-string v9, "."

    invoke-virtual {v6, v9}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_4

    .line 281
    add-int/lit8 v3, v3, 0x1

    .line 282
    if-lt v3, v11, :cond_4

    .line 287
    .end local v6    # "word":Ljava/lang/String;
    :cond_1
    if-ne v3, v10, :cond_2

    .line 288
    add-int/lit8 v9, v1, 0x1

    invoke-virtual {v5, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    .line 294
    .end local v2    # "i":I
    .end local v3    # "numNonAbbrev":I
    .end local v4    # "partBeforeComma":Ljava/lang/String;
    .end local v8    # "wordsBeforeComma":[Ljava/lang/String;
    :cond_2
    const-string v0, "the "

    .line 295
    .local v0, "THE_WITH_SPACE":Ljava/lang/String;
    invoke-virtual {v5}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v9

    const-string v10, "the "

    invoke-virtual {v9, v10}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 296
    const-string v9, "the "

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    invoke-virtual {v5, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    .line 300
    :cond_3
    const-string v9, "\\s+"

    invoke-static {v5, v9}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 301
    .local v7, "words":[Ljava/lang/String;
    const/4 v2, 0x0

    .restart local v2    # "i":I
    :goto_1
    array-length v9, v7

    if-ge v2, v9, :cond_6

    .line 302
    aget-object v6, v7, v2

    .line 303
    .restart local v6    # "word":Ljava/lang/String;
    const-string v9, "."

    invoke-virtual {v6, v9}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_5

    .line 309
    .end local v6    # "word":Ljava/lang/String;
    :goto_2
    return-object v6

    .line 278
    .end local v0    # "THE_WITH_SPACE":Ljava/lang/String;
    .end local v7    # "words":[Ljava/lang/String;
    .restart local v3    # "numNonAbbrev":I
    .restart local v4    # "partBeforeComma":Ljava/lang/String;
    .restart local v6    # "word":Ljava/lang/String;
    .restart local v8    # "wordsBeforeComma":[Ljava/lang/String;
    :cond_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 301
    .end local v3    # "numNonAbbrev":I
    .end local v4    # "partBeforeComma":Ljava/lang/String;
    .end local v8    # "wordsBeforeComma":[Ljava/lang/String;
    .restart local v0    # "THE_WITH_SPACE":Ljava/lang/String;
    .restart local v7    # "words":[Ljava/lang/String;
    :cond_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .end local v6    # "word":Ljava/lang/String;
    :cond_6
    move-object v6, p0

    .line 309
    goto :goto_2
.end method


# virtual methods
.method public addMessage(Ljava/lang/String;ZZZZZ)V
    .locals 6
    .param p1, "fromAddress"    # Ljava/lang/String;
    .param p2, "draft"    # Z
    .param p3, "unread"    # Z
    .param p4, "sentByMe"    # Z
    .param p5, "sending"    # Z
    .param p6, "failedToSend"    # Z

    .prologue
    const/4 v4, 0x1

    .line 164
    if-eqz p5, :cond_2

    .line 165
    iput-boolean v4, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mHasSending:Z

    .line 169
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mSenderInstructions:Lcom/google/android/gm/provider/SenderInstructions;

    if-nez p1, :cond_3

    const/4 v1, 0x0

    :goto_1
    if-nez p4, :cond_1

    if-nez p5, :cond_1

    if-eqz p6, :cond_4

    :cond_1
    :goto_2
    const/4 v5, -0x1

    move v2, p2

    move v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/SenderInstructions;->addMessage(Ljava/lang/String;ZZZI)V

    .line 172
    return-void

    .line 166
    :cond_2
    if-eqz p6, :cond_0

    .line 167
    iput-boolean v4, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mHasErrors:Z

    goto :goto_0

    .line 169
    :cond_3
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->getNameFromAddressString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    :cond_4
    const/4 v4, 0x0

    goto :goto_2
.end method

.method public toInstructionString(I)Ljava/lang/String;
    .locals 6
    .param p1, "maxSenders"    # I

    .prologue
    .line 60
    iget-object v1, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mSenderInstructions:Lcom/google/android/gm/provider/SenderInstructions;

    invoke-virtual {v1, p1}, Lcom/google/android/gm/provider/SenderInstructions;->calculateVisibility(I)V

    .line 61
    iget-object v1, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mSenderInstructions:Lcom/google/android/gm/provider/SenderInstructions;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/SenderInstructions;->getSenders()Ljava/util/Collection;

    move-result-object v0

    .line 62
    .local v0, "senders":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/SenderInstructions$Sender;>;"
    invoke-interface {v0}, Ljava/util/Collection;->size()I

    move-result v1

    iget-object v2, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mSenderInstructions:Lcom/google/android/gm/provider/SenderInstructions;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/SenderInstructions;->getNumDrafts()I

    move-result v2

    iget-object v3, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mSenderInstructions:Lcom/google/android/gm/provider/SenderInstructions;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/SenderInstructions;->getNumVisible()I

    move-result v3

    iget-boolean v4, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mHasSending:Z

    iget-boolean v5, p0, Lcom/google/android/gm/provider/CompactSenderInstructions;->mHasErrors:Z

    invoke-static/range {v0 .. v5}, Lcom/google/android/gm/provider/CompactSenderInstructions;->constructString(Ljava/util/Collection;IIIZZ)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
