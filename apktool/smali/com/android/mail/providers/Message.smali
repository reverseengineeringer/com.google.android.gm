.class public Lcom/android/mail/providers/Message;
.super Ljava/lang/Object;
.source "Message.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/mail/providers/Message;",
            ">;"
        }
    .end annotation
.end field

.field private static INLINE_IMAGE_PATTERN:Ljava/util/regex/Pattern;


# instance fields
.field public accountUri:Landroid/net/Uri;

.field public alwaysShowImages:Z

.field public appendRefMessageContent:Z

.field public attachmentListUri:Landroid/net/Uri;

.field public attachmentsJson:Ljava/lang/String;

.field public bcc:Ljava/lang/String;

.field public bodyHtml:Ljava/lang/String;

.field public bodyText:Ljava/lang/String;

.field public cc:Ljava/lang/String;

.field public conversationUri:Landroid/net/Uri;

.field public dateReceivedMs:J

.field public draftType:I

.field public embedsExternalResources:Z

.field public eventIntentUri:Landroid/net/Uri;

.field public from:Ljava/lang/String;

.field public hasAttachments:Z

.field public id:J

.field public isSending:Z

.field private transient mAttachments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;"
        }
    .end annotation
.end field

.field private transient mBccAddresses:[Ljava/lang/String;

.field private transient mCcAddresses:[Ljava/lang/String;

.field private transient mFromAddresses:[Ljava/lang/String;

.field private transient mReplyToAddresses:[Ljava/lang/String;

.field private transient mToAddresses:[Ljava/lang/String;

.field public messageFlags:J

.field public quotedTextOffset:I

.field public read:Z

.field public refMessageId:Ljava/lang/String;

.field public replyTo:Ljava/lang/String;

.field public saveUri:Ljava/lang/String;

.field public sendUri:Ljava/lang/String;

.field public serverId:Ljava/lang/String;

.field public snippet:Ljava/lang/String;

.field public spamLinkType:I

.field public spamWarningLevel:I

.field public spamWarningString:Ljava/lang/String;

.field public starred:Z

.field public subject:Ljava/lang/String;

.field public to:Ljava/lang/String;

.field public uri:Landroid/net/Uri;

.field public viaDomain:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 47
    const-string v0, "<img\\s+[^>]*src="

    const/16 v1, 0xa

    invoke-static {v0, v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Message;->INLINE_IMAGE_PATTERN:Ljava/util/regex/Pattern;

    .line 299
    new-instance v0, Lcom/android/mail/providers/Message$1;

    invoke-direct {v0}, Lcom/android/mail/providers/Message$1;-><init>()V

    sput-object v0, Lcom/android/mail/providers/Message;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 290
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 193
    iput-object v0, p0, Lcom/android/mail/providers/Message;->mFromAddresses:[Ljava/lang/String;

    .line 194
    iput-object v0, p0, Lcom/android/mail/providers/Message;->mToAddresses:[Ljava/lang/String;

    .line 195
    iput-object v0, p0, Lcom/android/mail/providers/Message;->mCcAddresses:[Ljava/lang/String;

    .line 196
    iput-object v0, p0, Lcom/android/mail/providers/Message;->mBccAddresses:[Ljava/lang/String;

    .line 197
    iput-object v0, p0, Lcom/android/mail/providers/Message;->mReplyToAddresses:[Ljava/lang/String;

    .line 199
    iput-object v0, p0, Lcom/android/mail/providers/Message;->mAttachments:Ljava/util/List;

    .line 292
    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 10
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    const/4 v5, 0x0

    .line 313
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 193
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mFromAddresses:[Ljava/lang/String;

    .line 194
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mToAddresses:[Ljava/lang/String;

    .line 195
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mCcAddresses:[Ljava/lang/String;

    .line 196
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mBccAddresses:[Ljava/lang/String;

    .line 197
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mReplyToAddresses:[Ljava/lang/String;

    .line 199
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mAttachments:Ljava/util/List;

    .line 314
    if-eqz p1, :cond_1

    .line 315
    invoke-interface {p1, v7}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    iput-wide v8, p0, Lcom/android/mail/providers/Message;->id:J

    .line 316
    invoke-interface {p1, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->serverId:Ljava/lang/String;

    .line 317
    const/4 v4, 0x2

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 318
    .local v3, "messageUriStr":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    :goto_0
    iput-object v4, p0, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    .line 319
    const/4 v4, 0x3

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 320
    .local v2, "convUriStr":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    :goto_1
    iput-object v4, p0, Lcom/android/mail/providers/Message;->conversationUri:Landroid/net/Uri;

    .line 321
    const/4 v4, 0x4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->subject:Ljava/lang/String;

    .line 322
    const/4 v4, 0x5

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->snippet:Ljava/lang/String;

    .line 323
    const/4 v4, 0x6

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    .line 324
    const/4 v4, 0x7

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->to:Ljava/lang/String;

    .line 325
    const/16 v4, 0x8

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->cc:Ljava/lang/String;

    .line 326
    const/16 v4, 0x9

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->bcc:Ljava/lang/String;

    .line 327
    const/16 v4, 0xa

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->replyTo:Ljava/lang/String;

    .line 328
    const/16 v4, 0xb

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    iput-wide v8, p0, Lcom/android/mail/providers/Message;->dateReceivedMs:J

    .line 329
    const/16 v4, 0xc

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    .line 330
    const/16 v4, 0xd

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    .line 331
    const/16 v4, 0xe

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-eqz v4, :cond_4

    move v4, v6

    :goto_2
    iput-boolean v4, p0, Lcom/android/mail/providers/Message;->embedsExternalResources:Z

    .line 333
    const/16 v4, 0xf

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->refMessageId:Ljava/lang/String;

    .line 334
    const/16 v4, 0x10

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Message;->draftType:I

    .line 335
    const/16 v4, 0x11

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-eqz v4, :cond_5

    move v4, v6

    :goto_3
    iput-boolean v4, p0, Lcom/android/mail/providers/Message;->appendRefMessageContent:Z

    .line 337
    const/16 v4, 0x12

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-eqz v4, :cond_6

    move v4, v6

    :goto_4
    iput-boolean v4, p0, Lcom/android/mail/providers/Message;->hasAttachments:Z

    .line 338
    const/16 v4, 0x13

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 340
    .local v1, "attachmentsUri":Ljava/lang/String;
    iget-boolean v4, p0, Lcom/android/mail/providers/Message;->hasAttachments:Z

    if-eqz v4, :cond_7

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_7

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    :goto_5
    iput-object v4, p0, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    .line 342
    const/16 v4, 0x14

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    iput-wide v8, p0, Lcom/android/mail/providers/Message;->messageFlags:J

    .line 343
    const/16 v4, 0x16

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->saveUri:Ljava/lang/String;

    .line 345
    const/16 v4, 0x17

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->sendUri:Ljava/lang/String;

    .line 347
    const/16 v4, 0x18

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-eqz v4, :cond_8

    move v4, v6

    :goto_6
    iput-boolean v4, p0, Lcom/android/mail/providers/Message;->alwaysShowImages:Z

    .line 348
    const/16 v4, 0x19

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-eqz v4, :cond_9

    move v4, v6

    :goto_7
    iput-boolean v4, p0, Lcom/android/mail/providers/Message;->read:Z

    .line 349
    const/16 v4, 0x1a

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-eqz v4, :cond_a

    move v4, v6

    :goto_8
    iput-boolean v4, p0, Lcom/android/mail/providers/Message;->starred:Z

    .line 350
    const/16 v4, 0x1b

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Message;->quotedTextOffset:I

    .line 351
    const/16 v4, 0x1c

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->attachmentsJson:Ljava/lang/String;

    .line 352
    const/16 v4, 0x1e

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 353
    .local v0, "accountUriString":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    :cond_0
    iput-object v5, p0, Lcom/android/mail/providers/Message;->accountUri:Landroid/net/Uri;

    .line 354
    const/16 v4, 0x1f

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->eventIntentUri:Landroid/net/Uri;

    .line 356
    const/16 v4, 0x20

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->spamWarningString:Ljava/lang/String;

    .line 358
    const/16 v4, 0x21

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Message;->spamWarningLevel:I

    .line 359
    const/16 v4, 0x22

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Message;->spamLinkType:I

    .line 360
    const/16 v4, 0x23

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Message;->viaDomain:Ljava/lang/String;

    .line 361
    const/16 v4, 0x24

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-eqz v4, :cond_b

    :goto_9
    iput-boolean v6, p0, Lcom/android/mail/providers/Message;->isSending:Z

    .line 363
    .end local v0    # "accountUriString":Ljava/lang/String;
    .end local v1    # "attachmentsUri":Ljava/lang/String;
    .end local v2    # "convUriStr":Ljava/lang/String;
    .end local v3    # "messageUriStr":Ljava/lang/String;
    :cond_1
    return-void

    .restart local v3    # "messageUriStr":Ljava/lang/String;
    :cond_2
    move-object v4, v5

    .line 318
    goto/16 :goto_0

    .restart local v2    # "convUriStr":Ljava/lang/String;
    :cond_3
    move-object v4, v5

    .line 320
    goto/16 :goto_1

    :cond_4
    move v4, v7

    .line 331
    goto/16 :goto_2

    :cond_5
    move v4, v7

    .line 335
    goto/16 :goto_3

    :cond_6
    move v4, v7

    .line 337
    goto/16 :goto_4

    .restart local v1    # "attachmentsUri":Ljava/lang/String;
    :cond_7
    move-object v4, v5

    .line 340
    goto/16 :goto_5

    :cond_8
    move v4, v7

    .line 347
    goto/16 :goto_6

    :cond_9
    move v4, v7

    .line 348
    goto :goto_7

    :cond_a
    move v4, v7

    .line 349
    goto :goto_8

    .restart local v0    # "accountUriString":Ljava/lang/String;
    :cond_b
    move v6, v7

    .line 361
    goto :goto_9
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 6
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v5, 0x0

    .line 254
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 193
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mFromAddresses:[Ljava/lang/String;

    .line 194
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mToAddresses:[Ljava/lang/String;

    .line 195
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mCcAddresses:[Ljava/lang/String;

    .line 196
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mBccAddresses:[Ljava/lang/String;

    .line 197
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mReplyToAddresses:[Ljava/lang/String;

    .line 199
    iput-object v5, p0, Lcom/android/mail/providers/Message;->mAttachments:Ljava/util/List;

    .line 255
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lcom/android/mail/providers/Message;->id:J

    .line 256
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->serverId:Ljava/lang/String;

    .line 257
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    .line 258
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Message;->conversationUri:Landroid/net/Uri;

    .line 259
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->subject:Ljava/lang/String;

    .line 260
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->snippet:Ljava/lang/String;

    .line 261
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    .line 262
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->to:Ljava/lang/String;

    .line 263
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->cc:Ljava/lang/String;

    .line 264
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->bcc:Ljava/lang/String;

    .line 265
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->replyTo:Ljava/lang/String;

    .line 266
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lcom/android/mail/providers/Message;->dateReceivedMs:J

    .line 267
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    .line 268
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    .line 269
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcom/android/mail/providers/Message;->embedsExternalResources:Z

    .line 270
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->refMessageId:Ljava/lang/String;

    .line 271
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Message;->draftType:I

    .line 272
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/android/mail/providers/Message;->appendRefMessageContent:Z

    .line 273
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    :goto_2
    iput-boolean v0, p0, Lcom/android/mail/providers/Message;->hasAttachments:Z

    .line 274
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    .line 275
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lcom/android/mail/providers/Message;->messageFlags:J

    .line 276
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->saveUri:Ljava/lang/String;

    .line 277
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->sendUri:Ljava/lang/String;

    .line 278
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    :goto_3
    iput-boolean v0, p0, Lcom/android/mail/providers/Message;->alwaysShowImages:Z

    .line 279
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Message;->quotedTextOffset:I

    .line 280
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->attachmentsJson:Ljava/lang/String;

    .line 281
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Message;->accountUri:Landroid/net/Uri;

    .line 282
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Message;->eventIntentUri:Landroid/net/Uri;

    .line 283
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->spamWarningString:Ljava/lang/String;

    .line 284
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Message;->spamWarningLevel:I

    .line 285
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Message;->spamLinkType:I

    .line 286
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->viaDomain:Ljava/lang/String;

    .line 287
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_4

    :goto_4
    iput-boolean v1, p0, Lcom/android/mail/providers/Message;->isSending:Z

    .line 288
    return-void

    :cond_0
    move v0, v2

    .line 269
    goto/16 :goto_0

    :cond_1
    move v0, v2

    .line 272
    goto :goto_1

    :cond_2
    move v0, v2

    .line 273
    goto :goto_2

    :cond_3
    move v0, v2

    .line 278
    goto :goto_3

    :cond_4
    move v1, v2

    .line 287
    goto :goto_4
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/android/mail/providers/Message$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lcom/android/mail/providers/Message$1;

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/android/mail/providers/Message;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method private embedsExternalResources()Z
    .locals 2

    .prologue
    .line 451
    iget-boolean v0, p0, Lcom/android/mail/providers/Message;->embedsExternalResources:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/android/mail/providers/Message;->INLINE_IMAGE_PATTERN:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static tokenizeAddresses(Ljava/lang/String;)[Ljava/lang/String;
    .locals 4
    .param p0, "addresses"    # Ljava/lang/String;

    .prologue
    .line 416
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 417
    const/4 v3, 0x0

    new-array v1, v3, [Ljava/lang/String;

    .line 424
    :cond_0
    return-object v1

    .line 419
    :cond_1
    invoke-static {p0}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v2

    .line 420
    .local v2, "tokens":[Landroid/text/util/Rfc822Token;
    array-length v3, v2

    new-array v1, v3, [Ljava/lang/String;

    .line 421
    .local v1, "strings":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v3, v2

    if-ge v0, v3, :cond_0

    .line 422
    aget-object v3, v2, v0

    invoke-virtual {v3}, Landroid/text/util/Rfc822Token;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v0

    .line 421
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 203
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 208
    if-eq p0, p1, :cond_0

    if-eqz p1, :cond_1

    instance-of v0, p1, Lcom/android/mail/providers/Message;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    check-cast p1, Lcom/android/mail/providers/Message;

    .end local p1    # "o":Ljava/lang/Object;
    iget-object v1, p1, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-static {v0, v1}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAttachments()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 428
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mAttachments:Ljava/util/List;

    if-nez v0, :cond_0

    .line 429
    iget-object v0, p0, Lcom/android/mail/providers/Message;->attachmentsJson:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 430
    iget-object v0, p0, Lcom/android/mail/providers/Message;->attachmentsJson:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/providers/Attachment;->fromJSONArray(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->mAttachments:Ljava/util/List;

    .line 435
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mAttachments:Ljava/util/List;

    return-object v0

    .line 432
    :cond_1
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->mAttachments:Ljava/util/List;

    goto :goto_0
.end method

.method public declared-synchronized getBccAddresses()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 402
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mBccAddresses:[Ljava/lang/String;

    if-nez v0, :cond_0

    .line 403
    iget-object v0, p0, Lcom/android/mail/providers/Message;->bcc:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/providers/Message;->tokenizeAddresses(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->mBccAddresses:[Ljava/lang/String;

    .line 405
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mBccAddresses:[Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 402
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getBodyAsHtml()Ljava/lang/String;
    .locals 3

    .prologue
    .line 473
    const-string v0, ""

    .line 474
    .local v0, "body":Ljava/lang/String;
    iget-object v1, p0, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 475
    iget-object v0, p0, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    .line 479
    :cond_0
    :goto_0
    return-object v0

    .line 476
    :cond_1
    iget-object v1, p0, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 477
    new-instance v1, Landroid/text/SpannedString;

    iget-object v2, p0, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    invoke-direct {v1, v2}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    invoke-static {v1}, Landroid/text/Html;->toHtml(Landroid/text/Spanned;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public declared-synchronized getCcAddresses()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 395
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mCcAddresses:[Ljava/lang/String;

    if-nez v0, :cond_0

    .line 396
    iget-object v0, p0, Lcom/android/mail/providers/Message;->cc:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/providers/Message;->tokenizeAddresses(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->mCcAddresses:[Ljava/lang/String;

    .line 398
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mCcAddresses:[Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 395
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getFromAddresses()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 381
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mFromAddresses:[Ljava/lang/String;

    if-nez v0, :cond_0

    .line 382
    iget-object v0, p0, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/providers/Message;->tokenizeAddresses(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->mFromAddresses:[Ljava/lang/String;

    .line 384
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mFromAddresses:[Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 381
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getReplyToAddresses()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 409
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mReplyToAddresses:[Ljava/lang/String;

    if-nez v0, :cond_0

    .line 410
    iget-object v0, p0, Lcom/android/mail/providers/Message;->replyTo:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/providers/Message;->tokenizeAddresses(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->mReplyToAddresses:[Ljava/lang/String;

    .line 412
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mReplyToAddresses:[Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 409
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getToAddresses()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 388
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mToAddresses:[Ljava/lang/String;

    if-nez v0, :cond_0

    .line 389
    iget-object v0, p0, Lcom/android/mail/providers/Message;->to:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/providers/Message;->tokenizeAddresses(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Message;->mToAddresses:[Ljava/lang/String;

    .line 391
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->mToAddresses:[Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 388
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public isFlaggedCalendarInvite()Z
    .locals 4

    .prologue
    const-wide/16 v2, 0x10

    .line 376
    iget-wide v0, p0, Lcom/android/mail/providers/Message;->messageFlags:J

    and-long/2addr v0, v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public markAlwaysShowImages(Landroid/content/AsyncQueryHandler;ILjava/lang/Object;)V
    .locals 7
    .param p1, "handler"    # Landroid/content/AsyncQueryHandler;
    .param p2, "token"    # I
    .param p3, "cookie"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x0

    const/4 v1, 0x1

    .line 464
    iput-boolean v1, p0, Lcom/android/mail/providers/Message;->alwaysShowImages:Z

    .line 466
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4, v1}, Landroid/content/ContentValues;-><init>(I)V

    .line 467
    .local v4, "values":Landroid/content/ContentValues;
    const-string v0, "alwaysShowImages"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 469
    iget-object v3, p0, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    move-object v0, p1

    move v1, p2

    move-object v2, p3

    move-object v6, v5

    invoke-virtual/range {v0 .. v6}, Landroid/content/AsyncQueryHandler;->startUpdate(ILjava/lang/Object;Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)V

    .line 470
    return-void
.end method

.method public shouldShowImagePrompt()Z
    .locals 1

    .prologue
    .line 447
    iget-boolean v0, p0, Lcom/android/mail/providers/Message;->alwaysShowImages:Z

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/android/mail/providers/Message;->embedsExternalResources()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 296
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[message id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lcom/android/mail/providers/Message;->id:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

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

    .line 219
    iget-wide v3, p0, Lcom/android/mail/providers/Message;->id:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 220
    iget-object v0, p0, Lcom/android/mail/providers/Message;->serverId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 221
    iget-object v0, p0, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 222
    iget-object v0, p0, Lcom/android/mail/providers/Message;->conversationUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 223
    iget-object v0, p0, Lcom/android/mail/providers/Message;->subject:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 224
    iget-object v0, p0, Lcom/android/mail/providers/Message;->snippet:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 225
    iget-object v0, p0, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 226
    iget-object v0, p0, Lcom/android/mail/providers/Message;->to:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 227
    iget-object v0, p0, Lcom/android/mail/providers/Message;->cc:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 228
    iget-object v0, p0, Lcom/android/mail/providers/Message;->bcc:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 229
    iget-object v0, p0, Lcom/android/mail/providers/Message;->replyTo:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 230
    iget-wide v3, p0, Lcom/android/mail/providers/Message;->dateReceivedMs:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 231
    iget-object v0, p0, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 232
    iget-object v0, p0, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 233
    iget-boolean v0, p0, Lcom/android/mail/providers/Message;->embedsExternalResources:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 234
    iget-object v0, p0, Lcom/android/mail/providers/Message;->refMessageId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 235
    iget v0, p0, Lcom/android/mail/providers/Message;->draftType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 236
    iget-boolean v0, p0, Lcom/android/mail/providers/Message;->appendRefMessageContent:Z

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 237
    iget-boolean v0, p0, Lcom/android/mail/providers/Message;->hasAttachments:Z

    if-eqz v0, :cond_2

    move v0, v1

    :goto_2
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 238
    iget-object v0, p0, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 239
    iget-wide v3, p0, Lcom/android/mail/providers/Message;->messageFlags:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 240
    iget-object v0, p0, Lcom/android/mail/providers/Message;->saveUri:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 241
    iget-object v0, p0, Lcom/android/mail/providers/Message;->sendUri:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 242
    iget-boolean v0, p0, Lcom/android/mail/providers/Message;->alwaysShowImages:Z

    if-eqz v0, :cond_3

    move v0, v1

    :goto_3
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 243
    iget v0, p0, Lcom/android/mail/providers/Message;->quotedTextOffset:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 244
    iget-object v0, p0, Lcom/android/mail/providers/Message;->attachmentsJson:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 245
    iget-object v0, p0, Lcom/android/mail/providers/Message;->accountUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 246
    iget-object v0, p0, Lcom/android/mail/providers/Message;->eventIntentUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 247
    iget-object v0, p0, Lcom/android/mail/providers/Message;->spamWarningString:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 248
    iget v0, p0, Lcom/android/mail/providers/Message;->spamWarningLevel:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 249
    iget v0, p0, Lcom/android/mail/providers/Message;->spamLinkType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 250
    iget-object v0, p0, Lcom/android/mail/providers/Message;->viaDomain:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 251
    iget-boolean v0, p0, Lcom/android/mail/providers/Message;->isSending:Z

    if-eqz v0, :cond_4

    :goto_4
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 252
    return-void

    :cond_0
    move v0, v2

    .line 233
    goto :goto_0

    :cond_1
    move v0, v2

    .line 236
    goto :goto_1

    :cond_2
    move v0, v2

    .line 237
    goto :goto_2

    :cond_3
    move v0, v2

    .line 242
    goto :goto_3

    :cond_4
    move v1, v2

    .line 251
    goto :goto_4
.end method
