.class public Lcom/android/mail/providers/Conversation;
.super Ljava/lang/Object;
.source "Conversation.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation
.end field

.field public static final EMPTY:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation
.end field

.field public static final MOVE_CONVERSATIONS_URI:Landroid/net/Uri;


# instance fields
.field public accountUri:Landroid/net/Uri;

.field private cachedDisplayableFolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation
.end field

.field private cachedRawFolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation
.end field

.field public color:I

.field public convFlags:I

.field public conversationBaseUri:Landroid/net/Uri;

.field public conversationInfo:Lcom/android/mail/providers/ConversationInfo;

.field public dateMs:J

.field public hasAttachments:Z

.field public id:J

.field public isRemote:Z

.field public transient localDeleteOnUpdate:Z

.field public messageListUri:Landroid/net/Uri;

.field public muted:Z

.field private numDrafts:I

.field private numMessages:I

.field public personalLevel:I

.field public phishing:Z

.field public transient position:I

.field public priority:I

.field private rawFolders:Ljava/lang/String;

.field public read:Z

.field public senders:Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public sendingState:I

.field public snippet:Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public spam:Z

.field public starred:Z

.field public subject:Ljava/lang/String;

.field public uri:Landroid/net/Uri;

.field private transient viewed:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 166
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Conversation;->EMPTY:Ljava/util/Collection;

    .line 237
    new-instance v0, Lcom/android/mail/providers/Conversation$1;

    invoke-direct {v0}, Lcom/android/mail/providers/Conversation$1;-><init>()V

    sput-object v0, Lcom/android/mail/providers/Conversation;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 251
    const-string v0, "content://moveconversations"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Conversation;->MOVE_CONVERSATIONS_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 303
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 304
    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 9
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v6, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 259
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 260
    if-eqz p1, :cond_3

    .line 261
    invoke-interface {p1, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v7

    iput-wide v7, p0, Lcom/android/mail/providers/Conversation;->id:J

    .line 262
    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    .line 263
    const/4 v3, 0x6

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v7

    iput-wide v7, p0, Lcom/android/mail/providers/Conversation;->dateMs:J

    .line 264
    const/4 v3, 0x3

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    .line 266
    iget-object v3, p0, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    if-nez v3, :cond_0

    .line 267
    const-string v3, ""

    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    .line 269
    :cond_0
    const/4 v3, 0x7

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-eqz v3, :cond_4

    move v3, v4

    :goto_0
    iput-boolean v3, p0, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    .line 270
    const/4 v3, 0x2

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 271
    .local v2, "messageList":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    :goto_1
    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->messageListUri:Landroid/net/Uri;

    .line 272
    const/16 v3, 0xa

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    iput v3, p0, Lcom/android/mail/providers/Conversation;->sendingState:I

    .line 273
    const/16 v3, 0xb

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    iput v3, p0, Lcom/android/mail/providers/Conversation;->priority:I

    .line 274
    const/16 v3, 0xc

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-eqz v3, :cond_6

    move v3, v4

    :goto_2
    iput-boolean v3, p0, Lcom/android/mail/providers/Conversation;->read:Z

    .line 275
    const/16 v3, 0xd

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-eqz v3, :cond_7

    move v3, v4

    :goto_3
    iput-boolean v3, p0, Lcom/android/mail/providers/Conversation;->starred:Z

    .line 276
    const/16 v3, 0xe

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->rawFolders:Ljava/lang/String;

    .line 277
    const/16 v3, 0xf

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    iput v3, p0, Lcom/android/mail/providers/Conversation;->convFlags:I

    .line 278
    const/16 v3, 0x10

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    iput v3, p0, Lcom/android/mail/providers/Conversation;->personalLevel:I

    .line 279
    const/16 v3, 0x11

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-eqz v3, :cond_8

    move v3, v4

    :goto_4
    iput-boolean v3, p0, Lcom/android/mail/providers/Conversation;->spam:Z

    .line 280
    const/16 v3, 0x12

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-eqz v3, :cond_9

    move v3, v4

    :goto_5
    iput-boolean v3, p0, Lcom/android/mail/providers/Conversation;->phishing:Z

    .line 281
    const/16 v3, 0x13

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-eqz v3, :cond_a

    move v3, v4

    :goto_6
    iput-boolean v3, p0, Lcom/android/mail/providers/Conversation;->muted:Z

    .line 282
    const/16 v3, 0x14

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    iput v3, p0, Lcom/android/mail/providers/Conversation;->color:I

    .line 283
    const/16 v3, 0x15

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 284
    .local v0, "account":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_b

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    :goto_7
    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->accountUri:Landroid/net/Uri;

    .line 285
    const/4 v3, -0x1

    iput v3, p0, Lcom/android/mail/providers/Conversation;->position:I

    .line 286
    iput-boolean v5, p0, Lcom/android/mail/providers/Conversation;->localDeleteOnUpdate:Z

    .line 287
    const/4 v3, 0x5

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/android/mail/providers/ConversationInfo;->fromString(Ljava/lang/String;)Lcom/android/mail/providers/ConversationInfo;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    .line 289
    const/16 v3, 0x17

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 291
    .local v1, "conversationBase":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    :cond_1
    iput-object v6, p0, Lcom/android/mail/providers/Conversation;->conversationBaseUri:Landroid/net/Uri;

    .line 293
    iget-object v3, p0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    if-nez v3, :cond_2

    .line 294
    const/4 v3, 0x4

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->snippet:Ljava/lang/String;

    .line 295
    const/16 v3, 0x16

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/android/mail/providers/Conversation;->emptyIfNull(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->senders:Ljava/lang/String;

    .line 296
    const/16 v3, 0x8

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    iput v3, p0, Lcom/android/mail/providers/Conversation;->numMessages:I

    .line 297
    const/16 v3, 0x9

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    iput v3, p0, Lcom/android/mail/providers/Conversation;->numDrafts:I

    .line 299
    :cond_2
    const/16 v3, 0x18

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-eqz v3, :cond_c

    :goto_8
    iput-boolean v4, p0, Lcom/android/mail/providers/Conversation;->isRemote:Z

    .line 301
    .end local v0    # "account":Ljava/lang/String;
    .end local v1    # "conversationBase":Ljava/lang/String;
    .end local v2    # "messageList":Ljava/lang/String;
    :cond_3
    return-void

    :cond_4
    move v3, v5

    .line 269
    goto/16 :goto_0

    .restart local v2    # "messageList":Ljava/lang/String;
    :cond_5
    move-object v3, v6

    .line 271
    goto/16 :goto_1

    :cond_6
    move v3, v5

    .line 274
    goto/16 :goto_2

    :cond_7
    move v3, v5

    .line 275
    goto/16 :goto_3

    :cond_8
    move v3, v5

    .line 279
    goto/16 :goto_4

    :cond_9
    move v3, v5

    .line 280
    goto/16 :goto_5

    :cond_a
    move v3, v5

    .line 281
    goto/16 :goto_6

    .restart local v0    # "account":Ljava/lang/String;
    :cond_b
    move-object v3, v6

    .line 284
    goto :goto_7

    .restart local v1    # "conversationBase":Ljava/lang/String;
    :cond_c
    move v4, v5

    .line 299
    goto :goto_8
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 6
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v5, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 202
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 203
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lcom/android/mail/providers/Conversation;->id:J

    .line 204
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    .line 205
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    .line 206
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lcom/android/mail/providers/Conversation;->dateMs:J

    .line 207
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->snippet:Ljava/lang/String;

    .line 208
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    .line 209
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->messageListUri:Landroid/net/Uri;

    .line 210
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/providers/Conversation;->emptyIfNull(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->senders:Ljava/lang/String;

    .line 211
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Conversation;->numMessages:I

    .line 212
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Conversation;->numDrafts:I

    .line 213
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Conversation;->sendingState:I

    .line 214
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Conversation;->priority:I

    .line 215
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/android/mail/providers/Conversation;->read:Z

    .line 216
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    :goto_2
    iput-boolean v0, p0, Lcom/android/mail/providers/Conversation;->starred:Z

    .line 217
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->rawFolders:Ljava/lang/String;

    .line 218
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Conversation;->convFlags:I

    .line 219
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Conversation;->personalLevel:I

    .line 220
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    :goto_3
    iput-boolean v0, p0, Lcom/android/mail/providers/Conversation;->spam:Z

    .line 221
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_4

    move v0, v1

    :goto_4
    iput-boolean v0, p0, Lcom/android/mail/providers/Conversation;->phishing:Z

    .line 222
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_5

    move v0, v1

    :goto_5
    iput-boolean v0, p0, Lcom/android/mail/providers/Conversation;->muted:Z

    .line 223
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Conversation;->color:I

    .line 224
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->accountUri:Landroid/net/Uri;

    .line 225
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/mail/providers/Conversation;->position:I

    .line 226
    iput-boolean v2, p0, Lcom/android/mail/providers/Conversation;->localDeleteOnUpdate:Z

    .line 227
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/providers/ConversationInfo;->fromString(Ljava/lang/String;)Lcom/android/mail/providers/ConversationInfo;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    .line 228
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->conversationBaseUri:Landroid/net/Uri;

    .line 229
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_6

    :goto_6
    iput-boolean v1, p0, Lcom/android/mail/providers/Conversation;->isRemote:Z

    .line 230
    return-void

    :cond_0
    move v0, v2

    .line 208
    goto/16 :goto_0

    :cond_1
    move v0, v2

    .line 215
    goto :goto_1

    :cond_2
    move v0, v2

    .line 216
    goto :goto_2

    :cond_3
    move v0, v2

    .line 220
    goto :goto_3

    :cond_4
    move v0, v2

    .line 221
    goto :goto_4

    :cond_5
    move v0, v2

    .line 222
    goto :goto_5

    :cond_6
    move v1, v2

    .line 229
    goto :goto_6
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/android/mail/providers/Conversation$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lcom/android/mail/providers/Conversation$1;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method private clearCachedFolders()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 365
    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->cachedRawFolders:Ljava/util/ArrayList;

    .line 366
    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->cachedDisplayableFolders:Ljava/util/ArrayList;

    .line 367
    return-void
.end method

.method public static final contains(Ljava/util/Collection;Lcom/android/mail/providers/Conversation;)Z
    .locals 8
    .param p1, "needle"    # Lcom/android/mail/providers/Conversation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Lcom/android/mail/providers/Conversation;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p0, "haystack":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 423
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v6

    if-gtz v6, :cond_2

    :cond_0
    move v4, v5

    .line 436
    :cond_1
    :goto_0
    return v4

    .line 427
    :cond_2
    if-eqz p1, :cond_1

    .line 430
    iget-wide v2, p1, Lcom/android/mail/providers/Conversation;->id:J

    .line 431
    .local v2, "toFind":J
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 432
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    iget-wide v6, v0, Lcom/android/mail/providers/Conversation;->id:J

    cmp-long v6, v2, v6

    if-nez v6, :cond_3

    goto :goto_0

    .end local v0    # "c":Lcom/android/mail/providers/Conversation;
    :cond_4
    move v4, v5

    .line 436
    goto :goto_0
.end method

.method public static create(JLandroid/net/Uri;Ljava/lang/String;JLjava/lang/String;ZLandroid/net/Uri;Ljava/lang/String;IIIIZZLjava/lang/String;IIZZZLandroid/net/Uri;Lcom/android/mail/providers/ConversationInfo;Landroid/net/Uri;Z)Lcom/android/mail/providers/Conversation;
    .locals 3
    .param p0, "id"    # J
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "subject"    # Ljava/lang/String;
    .param p4, "dateMs"    # J
    .param p6, "snippet"    # Ljava/lang/String;
    .param p7, "hasAttachment"    # Z
    .param p8, "messageListUri"    # Landroid/net/Uri;
    .param p9, "senders"    # Ljava/lang/String;
    .param p10, "numMessages"    # I
    .param p11, "numDrafts"    # I
    .param p12, "sendingState"    # I
    .param p13, "priority"    # I
    .param p14, "read"    # Z
    .param p15, "starred"    # Z
    .param p16, "rawFolders"    # Ljava/lang/String;
    .param p17, "convFlags"    # I
    .param p18, "personalLevel"    # I
    .param p19, "spam"    # Z
    .param p20, "phishing"    # Z
    .param p21, "muted"    # Z
    .param p22, "accountUri"    # Landroid/net/Uri;
    .param p23, "conversationInfo"    # Lcom/android/mail/providers/ConversationInfo;
    .param p24, "conversationBase"    # Landroid/net/Uri;
    .param p25, "isRemote"    # Z

    .prologue
    .line 313
    new-instance v1, Lcom/android/mail/providers/Conversation;

    invoke-direct {v1}, Lcom/android/mail/providers/Conversation;-><init>()V

    .line 315
    .local v1, "conversation":Lcom/android/mail/providers/Conversation;
    iput-wide p0, v1, Lcom/android/mail/providers/Conversation;->id:J

    .line 316
    iput-object p2, v1, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    .line 317
    iput-object p3, v1, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    .line 318
    iput-wide p4, v1, Lcom/android/mail/providers/Conversation;->dateMs:J

    .line 319
    iput-object p6, v1, Lcom/android/mail/providers/Conversation;->snippet:Ljava/lang/String;

    .line 320
    iput-boolean p7, v1, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    .line 321
    iput-object p8, v1, Lcom/android/mail/providers/Conversation;->messageListUri:Landroid/net/Uri;

    .line 322
    invoke-static {p9}, Lcom/android/mail/providers/Conversation;->emptyIfNull(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/android/mail/providers/Conversation;->senders:Ljava/lang/String;

    .line 323
    iput p10, v1, Lcom/android/mail/providers/Conversation;->numMessages:I

    .line 324
    iput p11, v1, Lcom/android/mail/providers/Conversation;->numDrafts:I

    .line 325
    iput p12, v1, Lcom/android/mail/providers/Conversation;->sendingState:I

    .line 326
    move/from16 v0, p13

    iput v0, v1, Lcom/android/mail/providers/Conversation;->priority:I

    .line 327
    move/from16 v0, p14

    iput-boolean v0, v1, Lcom/android/mail/providers/Conversation;->read:Z

    .line 328
    move/from16 v0, p15

    iput-boolean v0, v1, Lcom/android/mail/providers/Conversation;->starred:Z

    .line 329
    move-object/from16 v0, p16

    iput-object v0, v1, Lcom/android/mail/providers/Conversation;->rawFolders:Ljava/lang/String;

    .line 330
    move/from16 v0, p17

    iput v0, v1, Lcom/android/mail/providers/Conversation;->convFlags:I

    .line 331
    move/from16 v0, p18

    iput v0, v1, Lcom/android/mail/providers/Conversation;->personalLevel:I

    .line 332
    move/from16 v0, p19

    iput-boolean v0, v1, Lcom/android/mail/providers/Conversation;->spam:Z

    .line 333
    move/from16 v0, p20

    iput-boolean v0, v1, Lcom/android/mail/providers/Conversation;->phishing:Z

    .line 334
    move/from16 v0, p21

    iput-boolean v0, v1, Lcom/android/mail/providers/Conversation;->muted:Z

    .line 335
    const/4 v2, 0x0

    iput v2, v1, Lcom/android/mail/providers/Conversation;->color:I

    .line 336
    move-object/from16 v0, p22

    iput-object v0, v1, Lcom/android/mail/providers/Conversation;->accountUri:Landroid/net/Uri;

    .line 337
    move-object/from16 v0, p23

    iput-object v0, v1, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    .line 338
    move-object/from16 v0, p24

    iput-object v0, v1, Lcom/android/mail/providers/Conversation;->conversationBaseUri:Landroid/net/Uri;

    .line 339
    move/from16 v0, p25

    iput-boolean v0, v1, Lcom/android/mail/providers/Conversation;->isRemote:Z

    .line 340
    return-object v1
.end method

.method private static emptyIfNull(Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "in"    # Ljava/lang/String;

    .prologue
    .line 522
    if-eqz p0, :cond_0

    .end local p0    # "in":Ljava/lang/String;
    :goto_0
    return-object p0

    .restart local p0    # "in":Ljava/lang/String;
    :cond_0
    const-string p0, ""

    goto :goto_0
.end method

.method public static getSubjectAndSnippetForDisplay(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "filteredSubject"    # Ljava/lang/String;
    .param p2, "snippet"    # Ljava/lang/String;

    .prologue
    .line 530
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const v1, 0x7f0c0098

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    .end local p1    # "filteredSubject":Ljava/lang/String;
    :cond_0
    invoke-direct {v0, p1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    return-object v0
.end method

.method public static listOf(Lcom/android/mail/providers/Conversation;)Ljava/util/Collection;
    .locals 1
    .param p0, "in"    # Lcom/android/mail/providers/Conversation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/providers/Conversation;",
            ")",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation

    .prologue
    .line 447
    if-nez p0, :cond_0

    sget-object v0, Lcom/android/mail/providers/Conversation;->EMPTY:Ljava/util/Collection;

    .line 448
    .local v0, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    :goto_0
    return-object v0

    .line 447
    .end local v0    # "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    :cond_0
    invoke-static {p0}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    goto :goto_0
.end method

.method public static toString(Ljava/util/Collection;)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 507
    .local p0, "collection":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    new-instance v3, Ljava/lang/StringBuilder;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " conversations:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 508
    .local v3, "out":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .line 509
    .local v1, "count":I
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 510
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    add-int/lit8 v1, v1, 0x1

    .line 513
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "      "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/android/mail/providers/Conversation;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 515
    .end local v0    # "c":Lcom/android/mail/providers/Conversation;
    :cond_0
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 170
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 386
    instance-of v1, p1, Lcom/android/mail/providers/Conversation;

    if-eqz v1, :cond_0

    move-object v0, p1

    .line 387
    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 388
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    iget-object v1, v0, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    iget-object v2, p0, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    invoke-virtual {v1, v2}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v1

    .line 390
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getNumMessages()I
    .locals 1

    .prologue
    .line 483
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    iget v0, v0, Lcom/android/mail/providers/ConversationInfo;->messageCount:I

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/android/mail/providers/Conversation;->numMessages:I

    goto :goto_0
.end method

.method public getRawFolders()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation

    .prologue
    .line 344
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->cachedRawFolders:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 346
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->rawFolders:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 347
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->rawFolders:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/providers/Folder;->getFoldersArray(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Conversation;->cachedRawFolders:Ljava/util/ArrayList;

    .line 352
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->cachedRawFolders:Ljava/util/ArrayList;

    :goto_0
    return-object v0

    .line 349
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method public getRawFoldersForDisplay(Lcom/android/mail/providers/Folder;)Ljava/util/ArrayList;
    .locals 4
    .param p1, "ignoreFolder"    # Lcom/android/mail/providers/Folder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/providers/Folder;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation

    .prologue
    .line 370
    invoke-virtual {p0}, Lcom/android/mail/providers/Conversation;->getRawFolders()Ljava/util/ArrayList;

    move-result-object v1

    .line 371
    .local v1, "folders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Folder;>;"
    iget-object v3, p0, Lcom/android/mail/providers/Conversation;->cachedDisplayableFolders:Ljava/util/ArrayList;

    if-nez v3, :cond_2

    .line 372
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/android/mail/providers/Conversation;->cachedDisplayableFolders:Ljava/util/ArrayList;

    .line 373
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 375
    .local v0, "folder":Lcom/android/mail/providers/Folder;
    if-eqz p1, :cond_1

    invoke-virtual {p1, v0}, Lcom/android/mail/providers/Folder;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 378
    :cond_1
    iget-object v3, p0, Lcom/android/mail/providers/Conversation;->cachedDisplayableFolders:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 381
    .end local v0    # "folder":Lcom/android/mail/providers/Folder;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_2
    iget-object v3, p0, Lcom/android/mail/providers/Conversation;->cachedDisplayableFolders:Ljava/util/ArrayList;

    return-object v3
.end method

.method public getRawFoldersString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 361
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->rawFolders:Ljava/lang/String;

    return-object v0
.end method

.method public getSnippet()Ljava/lang/String;
    .locals 1

    .prologue
    .line 456
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    iget-object v0, v0, Lcom/android/mail/providers/ConversationInfo;->firstSnippet:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    iget-object v0, v0, Lcom/android/mail/providers/ConversationInfo;->firstSnippet:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->snippet:Ljava/lang/String;

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 395
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->hashCode()I

    move-result v0

    return v0
.end method

.method public isImportant()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 402
    iget v1, p0, Lcom/android/mail/providers/Conversation;->priority:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isMostlyDead()Z
    .locals 1

    .prologue
    .line 409
    iget v0, p0, Lcom/android/mail/providers/Conversation;->convFlags:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isViewed()Z
    .locals 1

    .prologue
    .line 494
    iget-boolean v0, p0, Lcom/android/mail/providers/Conversation;->viewed:Z

    return v0
.end method

.method public markViewed()V
    .locals 1

    .prologue
    .line 498
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/providers/Conversation;->viewed:Z

    .line 499
    return-void
.end method

.method public setRawFolders(Ljava/lang/String;)V
    .locals 0
    .param p1, "raw"    # Ljava/lang/String;

    .prologue
    .line 356
    invoke-direct {p0}, Lcom/android/mail/providers/Conversation;->clearCachedFolders()V

    .line 357
    iput-object p1, p0, Lcom/android/mail/providers/Conversation;->rawFolders:Ljava/lang/String;

    .line 358
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 234
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[conversation id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", subject ="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 5
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 175
    iget-wide v3, p0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 176
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 177
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 178
    iget-wide v3, p0, Lcom/android/mail/providers/Conversation;->dateMs:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 179
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->snippet:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 180
    iget-boolean v0, p0, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 181
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->messageListUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 182
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->senders:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 183
    iget v0, p0, Lcom/android/mail/providers/Conversation;->numMessages:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 184
    iget v0, p0, Lcom/android/mail/providers/Conversation;->numDrafts:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 185
    iget v0, p0, Lcom/android/mail/providers/Conversation;->sendingState:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 186
    iget v0, p0, Lcom/android/mail/providers/Conversation;->priority:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 187
    iget-boolean v0, p0, Lcom/android/mail/providers/Conversation;->read:Z

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 188
    iget-boolean v0, p0, Lcom/android/mail/providers/Conversation;->starred:Z

    if-eqz v0, :cond_2

    move v0, v1

    :goto_2
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 189
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->rawFolders:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 190
    iget v0, p0, Lcom/android/mail/providers/Conversation;->convFlags:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 191
    iget v0, p0, Lcom/android/mail/providers/Conversation;->personalLevel:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 192
    iget-boolean v0, p0, Lcom/android/mail/providers/Conversation;->spam:Z

    if-eqz v0, :cond_3

    move v0, v1

    :goto_3
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 193
    iget-boolean v0, p0, Lcom/android/mail/providers/Conversation;->phishing:Z

    if-eqz v0, :cond_4

    move v0, v1

    :goto_4
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 194
    iget-boolean v0, p0, Lcom/android/mail/providers/Conversation;->muted:Z

    if-eqz v0, :cond_5

    move v0, v1

    :goto_5
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 195
    iget v0, p0, Lcom/android/mail/providers/Conversation;->color:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 196
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->accountUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 197
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    invoke-static {v0}, Lcom/android/mail/providers/ConversationInfo;->toString(Lcom/android/mail/providers/ConversationInfo;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 198
    iget-object v0, p0, Lcom/android/mail/providers/Conversation;->conversationBaseUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 199
    iget-boolean v0, p0, Lcom/android/mail/providers/Conversation;->isRemote:Z

    if-eqz v0, :cond_6

    :goto_6
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 200
    return-void

    :cond_0
    move v0, v2

    .line 180
    goto :goto_0

    :cond_1
    move v0, v2

    .line 187
    goto :goto_1

    :cond_2
    move v0, v2

    .line 188
    goto :goto_2

    :cond_3
    move v0, v2

    .line 192
    goto :goto_3

    :cond_4
    move v0, v2

    .line 193
    goto :goto_4

    :cond_5
    move v0, v2

    .line 194
    goto :goto_5

    :cond_6
    move v1, v2

    .line 199
    goto :goto_6
.end method
