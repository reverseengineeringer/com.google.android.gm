.class public final Lcom/google/android/gm/provider/Gmail;
.super Ljava/lang/Object;
.source "Gmail.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/Gmail$1;,
        Lcom/google/android/gm/provider/Gmail$ConversationCursor;,
        Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;,
        Lcom/google/android/gm/provider/Gmail$MessageModification;,
        Lcom/google/android/gm/provider/Gmail$MessageCursor;,
        Lcom/google/android/gm/provider/Gmail$DetachedMessageCursor;,
        Lcom/google/android/gm/provider/Gmail$CursorError;,
        Lcom/google/android/gm/provider/Gmail$CursorStatus;,
        Lcom/google/android/gm/provider/Gmail$Attachment;,
        Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;,
        Lcom/google/android/gm/provider/Gmail$AttachmentRendition;,
        Lcom/google/android/gm/provider/Gmail$PersonalLevel;,
        Lcom/google/android/gm/provider/Gmail$LabelMap;,
        Lcom/google/android/gm/provider/Gmail$MailCursorObserver;,
        Lcom/google/android/gm/provider/Gmail$MailCursor;,
        Lcom/google/android/gm/provider/Gmail$Settings;,
        Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;,
        Lcom/google/android/gm/provider/Gmail$CommaStringSplitter;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z

.field private static final ASSIGNABLE_BUILTIN_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final ATTACHMENT_INFO_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

.field public static final COMMA_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

.field static CONVERSATION_PROJECTION:[Ljava/lang/String;

.field static CONVERSATION_PROJECTION_LIMITED:[Ljava/lang/String;

.field private static final DISPLAYABLE_SYSTEM_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

.field static LABEL_PROJECTION:[Ljava/lang/String;

.field public static final LOCAL_PRIORITY_LABELS:Lcom/google/common/collect/BiMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/BiMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field static MESSAGE_PROJECTION:[Ljava/lang/String;

.field private static final NAME_ADDRESS_PATTERN:Ljava/util/regex/Pattern;

.field public static final PRIORITY_MARKERS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final SENDER_LIST_SEPARATOR:Ljava/lang/Character;

.field public static SETTINGS_PROJECTION:[Ljava/lang/String;

.field public static final SPACE_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

.field static final STATUS_PROJECTION:[Ljava/lang/String;

.field private static final SYSTEM_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final UNNAMED_ADDRESS_PATTERN:Ljava/util/regex/Pattern;

.field private static final USER_SETTABLE_BUILTIN_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field static sAccountUriMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/net/Uri;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final sPriorityToLength:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public static sSenderFragments:[Ljava/lang/String;

.field public static final sSenderListSplitter:Landroid/text/TextUtils$SimpleStringSplitter;


# instance fields
.field private final mContentResolver:Landroid/content/ContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 14

    .prologue
    const/4 v13, 0x4

    const/4 v12, 0x3

    const/4 v11, 0x2

    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 74
    const-class v0, Lcom/google/android/gm/provider/Gmail;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v7

    :goto_0
    sput-boolean v0, Lcom/google/android/gm/provider/Gmail;->$assertionsDisabled:Z

    .line 169
    const-string v0, "\n"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    .line 174
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->sAccountUriMap:Ljava/util/Map;

    .line 180
    const-string v0, " "

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->SPACE_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    .line 201
    const-string v0, ","

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->COMMA_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    .line 205
    const-string v0, "\n"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->ATTACHMENT_INFO_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    .line 208
    const/16 v0, 0xa

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    .line 237
    const-string v0, "\"(.*)\""

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->NAME_ADDRESS_PATTERN:Ljava/util/regex/Pattern;

    .line 238
    const-string v0, "([^<]+)@"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->UNNAMED_ADDRESS_PATTERN:Ljava/util/regex/Pattern;

    .line 261
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->sPriorityToLength:Ljava/util/Map;

    .line 262
    new-instance v0, Landroid/text/TextUtils$SimpleStringSplitter;

    sget-object v1, Lcom/google/android/gm/provider/Gmail;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {v1}, Ljava/lang/Character;->charValue()C

    move-result v1

    invoke-direct {v0, v1}, Landroid/text/TextUtils$SimpleStringSplitter;-><init>(C)V

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->sSenderListSplitter:Landroid/text/TextUtils$SimpleStringSplitter;

    .line 264
    const/16 v0, 0x8

    new-array v0, v0, [Ljava/lang/String;

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->sSenderFragments:[Ljava/lang/String;

    .line 273
    const-string v0, "^all"

    const-string v1, "^b"

    const-string v2, "^r"

    const-string v3, "^g"

    const-string v4, "^i"

    const-string v5, "^f"

    const/16 v6, 0xe

    new-array v6, v6, [Ljava/lang/String;

    const-string v9, "^s"

    aput-object v9, v6, v8

    const-string v9, "^t"

    aput-object v9, v6, v7

    const-string v9, "^k"

    aput-object v9, v6, v11

    const-string v9, "^u"

    aput-object v9, v6, v12

    const-string v9, "^io_im"

    aput-object v9, v6, v13

    const/4 v9, 0x5

    const-string v10, "^iim"

    aput-object v10, v6, v9

    const/4 v9, 0x6

    const-string v10, "^^cached"

    aput-object v10, v6, v9

    const/4 v9, 0x7

    const-string v10, "^^out"

    aput-object v10, v6, v9

    const/16 v9, 0x8

    const-string v10, "^^important"

    aput-object v10, v6, v9

    const/16 v9, 0x9

    const-string v10, "^^unimportant"

    aput-object v10, v6, v9

    const/16 v9, 0xa

    const-string v10, "^imi"

    aput-object v10, v6, v9

    const/16 v9, 0xb

    const-string v10, "^imn"

    aput-object v10, v6, v9

    const/16 v9, 0xc

    const-string v10, "^io_ns"

    aput-object v10, v6, v9

    const/16 v9, 0xd

    const-string v10, "^im"

    aput-object v10, v6, v9

    invoke-static/range {v0 .. v6}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->SYSTEM_LABELS:Ljava/util/Set;

    .line 300
    const-string v0, "^g"

    const-string v1, "^i"

    const-string v2, "^s"

    const-string v3, "^k"

    invoke-static {v0, v1, v2, v3}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->DISPLAYABLE_SYSTEM_LABELS:Ljava/util/Set;

    .line 308
    invoke-static {}, Lcom/google/common/collect/ImmutableBiMap;->builder()Lcom/google/common/collect/ImmutableBiMap$Builder;

    move-result-object v0

    const-wide/16 v1, -0x1f4

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const-string v2, "^imi"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableBiMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableBiMap$Builder;

    move-result-object v0

    const-wide/16 v1, -0x1f5

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const-string v2, "^imn"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableBiMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableBiMap$Builder;

    move-result-object v0

    const-wide/16 v1, -0x1f3

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const-string v2, "^im"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableBiMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableBiMap$Builder;

    move-result-object v0

    const-wide/16 v1, -0x1f6

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const-string v2, "^io_ns"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableBiMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableBiMap$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableBiMap$Builder;->build()Lcom/google/common/collect/ImmutableBiMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->LOCAL_PRIORITY_LABELS:Lcom/google/common/collect/BiMap;

    .line 316
    const-string v0, "^imi"

    const-string v1, "^imn"

    const-string v2, "^im"

    const-string v3, "^io_ns"

    invoke-static {v0, v1, v2, v3}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->PRIORITY_MARKERS:Ljava/util/Set;

    .line 579
    const-string v0, "^i"

    const-string v1, "^u"

    const-string v2, "^k"

    const-string v3, "^s"

    const-string v4, "^t"

    const-string v5, "^g"

    const/4 v6, 0x6

    new-array v6, v6, [Ljava/lang/String;

    const-string v9, "^^important"

    aput-object v9, v6, v8

    const-string v9, "^^unimportant"

    aput-object v9, v6, v7

    const-string v9, "^imi"

    aput-object v9, v6, v11

    const-string v9, "^imn"

    aput-object v9, v6, v12

    const-string v9, "^io_ns"

    aput-object v9, v6, v13

    const/4 v9, 0x5

    const-string v10, "^o"

    aput-object v10, v6, v9

    invoke-static/range {v0 .. v6}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->USER_SETTABLE_BUILTIN_LABELS:Ljava/util/Set;

    .line 610
    const-string v0, "^im"

    const-string v1, "^io_im"

    const-string v2, "^iim"

    const-string v3, "^p"

    invoke-static {v0, v1, v2, v3}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->ASSIGNABLE_BUILTIN_LABELS:Ljava/util/Set;

    .line 872
    const/16 v0, 0xe

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v8

    const-string v1, "subject"

    aput-object v1, v0, v7

    const-string v1, "snippet"

    aput-object v1, v0, v11

    const-string v1, "fromAddress"

    aput-object v1, v0, v12

    const-string v1, "date"

    aput-object v1, v0, v13

    const/4 v1, 0x5

    const-string v2, "personalLevel"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "labelIds"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "numMessages"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "maxMessageId"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "hasAttachments"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "hasMessagesWithErrors"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "forceAllUnread"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "synced"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "conversationLabels"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->CONVERSATION_PROJECTION:[Ljava/lang/String;

    .line 890
    const/16 v0, 0xb

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v8

    const-string v1, "subject"

    aput-object v1, v0, v7

    const-string v1, "snippet"

    aput-object v1, v0, v11

    const-string v1, "fromAddress"

    aput-object v1, v0, v12

    const-string v1, "personalLevel"

    aput-object v1, v0, v13

    const/4 v1, 0x5

    const-string v2, "labelIds"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "numMessages"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "maxMessageId"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "hasAttachments"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "hasMessagesWithErrors"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "forceAllUnread"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->CONVERSATION_PROJECTION_LIMITED:[Ljava/lang/String;

    .line 905
    const/16 v0, 0x1e

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v8

    const-string v1, "messageId"

    aput-object v1, v0, v7

    const-string v1, "conversation"

    aput-object v1, v0, v11

    const-string v1, "subject"

    aput-object v1, v0, v12

    const-string v1, "snippet"

    aput-object v1, v0, v13

    const/4 v1, 0x5

    const-string v2, "fromAddress"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "customFromAddress"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "toAddresses"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "ccAddresses"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "bccAddresses"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "replyToAddresses"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "dateSentMs"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "dateReceivedMs"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "listInfo"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "personalLevel"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "body"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "bodyEmbedsExternalResources"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "labelIds"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "joinedAttachmentInfos"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "refMessageId"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "error"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "forward"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "includeQuotedText"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "quoteStartPos"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "labelCount"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "messageLabels"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "isStarred"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "isDraft"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "isInOutbox"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "isUnread"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->MESSAGE_PROJECTION:[Ljava/lang/String;

    .line 939
    const/16 v0, 0xc

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v8

    const-string v1, "canonicalName"

    aput-object v1, v0, v7

    const-string v1, "name"

    aput-object v1, v0, v11

    const-string v1, "numConversations"

    aput-object v1, v0, v12

    const-string v1, "numUnreadConversations"

    aput-object v1, v0, v13

    const/4 v1, 0x5

    const-string v2, "color"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "systemLabel"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "hidden"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "labelCountDisplayBehavior"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "labelSyncPolicy"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "lastTouched"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "sortOrder"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->LABEL_PROJECTION:[Ljava/lang/String;

    .line 952
    new-array v0, v13, [Ljava/lang/String;

    const-string v1, "labelsIncluded"

    aput-object v1, v0, v8

    const-string v1, "labelsPartial"

    aput-object v1, v0, v7

    const-string v1, "conversationAgeDays"

    aput-object v1, v0, v11

    const-string v1, "maxAttachmentSize"

    aput-object v1, v0, v12

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    .line 959
    new-array v0, v11, [Ljava/lang/String;

    const-string v1, "status"

    aput-object v1, v0, v8

    const-string v1, "account"

    aput-object v1, v0, v7

    sput-object v0, Lcom/google/android/gm/provider/Gmail;->STATUS_PROJECTION:[Ljava/lang/String;

    return-void

    :cond_0
    move v0, v8

    .line 74
    goto/16 :goto_0
.end method

.method public constructor <init>(Landroid/content/ContentResolver;)V
    .locals 0
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;

    .prologue
    .line 966
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 967
    iput-object p1, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    .line 968
    return-void
.end method

.method static synthetic access$1000(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ljava/lang/String;

    .prologue
    .line 74
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->toNonnullString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static addOrRemoveLabelOnMessage(Landroid/content/ContentResolver;Ljava/lang/String;JJLjava/lang/String;Z)V
    .locals 3
    .param p0, "contentResolver"    # Landroid/content/ContentResolver;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J
    .param p4, "messageId"    # J
    .param p6, "label"    # Ljava/lang/String;
    .param p7, "add"    # Z

    .prologue
    const/4 v2, 0x0

    .line 1163
    if-eqz p7, :cond_0

    .line 1164
    invoke-static {p1, p4, p5}, Lcom/google/android/gm/provider/Gmail;->getMessageLabelsUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v0

    .line 1165
    .local v0, "uri":Landroid/net/Uri;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 1166
    .local v1, "values":Landroid/content/ContentValues;
    const-string v2, "canonicalName"

    invoke-virtual {v1, v2, p6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1167
    invoke-virtual {p0, v0, v1}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 1173
    .end local v1    # "values":Landroid/content/ContentValues;
    :goto_0
    return-void

    .line 1169
    .end local v0    # "uri":Landroid/net/Uri;
    :cond_0
    invoke-static {p1, p4, p5, p6}, Lcom/google/android/gm/provider/Gmail;->getMessageLabelUri(Ljava/lang/String;JLjava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 1171
    .restart local v0    # "uri":Landroid/net/Uri;
    invoke-virtual {p0, v0, v2, v2}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0
.end method

.method private static addStyledFragment(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Landroid/text/style/CharacterStyle;Z)V
    .locals 5
    .param p0, "builder"    # Landroid/text/SpannableStringBuilder;
    .param p1, "fragment"    # Ljava/lang/String;
    .param p2, "style"    # Landroid/text/style/CharacterStyle;
    .param p3, "withSpaces"    # Z

    .prologue
    const/16 v4, 0x20

    const/4 v3, 0x1

    .line 1643
    if-eqz p3, :cond_0

    .line 1644
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    .line 1645
    .local v0, "pos":I
    invoke-virtual {p0, p1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1646
    invoke-static {p2}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v2

    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    const/16 v4, 0x21

    invoke-virtual {p0, v2, v0, v3, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 1668
    :goto_0
    return-void

    .line 1649
    .end local v0    # "pos":I
    :cond_0
    const/4 v1, 0x0

    .line 1651
    .local v1, "start":I
    :cond_1
    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 1652
    .restart local v0    # "pos":I
    const/4 v2, -0x1

    if-ne v0, v2, :cond_2

    .line 1653
    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2, p2, v3}, Lcom/google/android/gm/provider/Gmail;->addStyledFragment(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Landroid/text/style/CharacterStyle;Z)V

    goto :goto_0

    .line 1656
    :cond_2
    add-int/2addr v0, v1

    .line 1657
    if-ge v1, v0, :cond_3

    .line 1658
    invoke-virtual {p1, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2, p2, v3}, Lcom/google/android/gm/provider/Gmail;->addStyledFragment(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Landroid/text/style/CharacterStyle;Z)V

    .line 1659
    invoke-virtual {p0, v4}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    .line 1661
    :cond_3
    add-int/lit8 v1, v0, 0x1

    .line 1662
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-lt v1, v2, :cond_1

    goto :goto_0
.end method

.method public static deviceHasLargeDataPartition(Landroid/content/Context;)Z
    .locals 9
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1621
    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    .line 1623
    .local v0, "dataDir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->getTotalSpace()J

    move-result-wide v3

    .line 1625
    .local v3, "totalSpaceBytes":J
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    const-string v6, "gmail_large_data_partition_min_threshold_bytes"

    const-wide/32 v7, 0x3b9aca00

    invoke-static {v5, v6, v7, v8}, Lcom/google/android/gsf/Gservices;->getLong(Landroid/content/ContentResolver;Ljava/lang/String;J)J

    move-result-wide v1

    .line 1629
    .local v1, "largeDataPartitionThreshold":J
    cmp-long v5, v3, v1

    if-ltz v5, :cond_0

    const/4 v5, 0x1

    :goto_0
    return v5

    :cond_0
    const/4 v5, 0x0

    goto :goto_0
.end method

.method private static declared-synchronized getAccountUriCache(Ljava/lang/String;)Ljava/util/Map;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation

    .prologue
    .line 337
    const-class v2, Lcom/google/android/gm/provider/Gmail;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/google/android/gm/provider/Gmail;->sAccountUriMap:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 338
    .local v0, "uriMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/net/Uri;>;"
    if-nez v0, :cond_0

    .line 339
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    .end local v0    # "uriMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/net/Uri;>;"
    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    .line 340
    .restart local v0    # "uriMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/net/Uri;>;"
    sget-object v1, Lcom/google/android/gm/provider/Gmail;->sAccountUriMap:Ljava/util/Map;

    invoke-interface {v1, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 342
    :cond_0
    monitor-exit v2

    return-object v0

    .line 337
    .end local v0    # "uriMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/net/Uri;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static getAttachmentUri(Ljava/lang/String;JLcom/google/android/gm/provider/uiprovider/UIAttachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "messageId"    # J
    .param p3, "attachment"    # Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    .param p4, "rendition"    # Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    .param p5, "saveToSd"    # Z

    .prologue
    .line 2855
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2856
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "account is empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2866
    :cond_0
    invoke-interface {p3}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->supportsOrigin()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {p3}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getOrigin()Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->LOCAL_FILE:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    if-ne v0, v1, :cond_1

    sget-object v0, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    if-ne p4, v0, :cond_1

    .line 2868
    invoke-interface {p3}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getOriginExtras()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 2870
    :goto_0
    return-object v0

    :cond_1
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getMessagesUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "attachments"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-interface {p3}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getPartId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {p4}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p5}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    goto :goto_0
.end method

.method static getAttachmentsForConversationUri(Ljava/lang/String;J)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J

    .prologue
    .line 412
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getConversationsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "attachments"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getBaseUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 4
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 364
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getAccountUriCache(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v1

    .line 365
    .local v1, "uriMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/net/Uri;>;"
    const-string v2, "baseUri"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 366
    .local v0, "baseUri":Landroid/net/Uri;
    if-nez v0, :cond_0

    .line 367
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "content://gmail-ls/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 368
    const-string v2, "baseUri"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 370
    :cond_0
    return-object v0
.end method

.method private static getCachedUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .locals 4
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "param"    # Ljava/lang/String;

    .prologue
    .line 346
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getAccountUriCache(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v1

    .line 347
    .local v1, "uriMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/net/Uri;>;"
    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 348
    .local v0, "cachedUri":Landroid/net/Uri;
    if-nez v0, :cond_0

    .line 349
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "content://gmail-ls/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 350
    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 352
    :cond_0
    return-object v0
.end method

.method public static getCanonicalLabelForNotification(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 644
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "^^unseen-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getCanonicalLabelForTagLabel(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 652
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "^^unseen-"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 654
    const-string v0, "^^unseen-"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    .line 656
    .end local p0    # "canonicalName":Ljava/lang/String;
    :cond_0
    return-object p0
.end method

.method static getConversationLabelUri(Ljava/lang/String;JLjava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J
    .param p3, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 401
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getConversationUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "labels"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p3}, Lcom/google/android/gm/provider/Gmail;->urlEncodeLabel(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getConversationUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 393
    const-string v0, "/conversation/"

    invoke-static {p0, v0}, Lcom/google/android/gm/provider/Gmail;->getCachedUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getConversationsUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 377
    const-string v0, "/conversations/"

    invoke-static {p0, v0}, Lcom/google/android/gm/provider/Gmail;->getCachedUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getDefaultConversationAgeDays(Landroid/content/Context;)J
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1609
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->deviceHasLargeDataPartition(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1610
    const-string v2, "gmail_default_label_sync_days_large_data_partition"

    .line 1611
    .local v2, "gServiceKey":Ljava/lang/String;
    const-wide/16 v0, 0x1e

    .line 1617
    .local v0, "defaultSyncWindowDays":J
    :goto_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    invoke-static {v3, v2, v0, v1}, Lcom/google/android/gsf/Gservices;->getLong(Landroid/content/ContentResolver;Ljava/lang/String;J)J

    move-result-wide v3

    return-wide v3

    .line 1613
    .end local v0    # "defaultSyncWindowDays":J
    .end local v2    # "gServiceKey":Ljava/lang/String;
    :cond_0
    const-string v2, "gmail_default_label_sync_days"

    .line 1614
    .restart local v2    # "gServiceKey":Ljava/lang/String;
    const-wide/16 v0, 0x4

    .restart local v0    # "defaultSyncWindowDays":J
    goto :goto_0
.end method

.method public static getEmailFromAddressString(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "addressString"    # Ljava/lang/String;

    .prologue
    .line 556
    move-object v1, p0

    .line 557
    .local v1, "result":Ljava/lang/String;
    sget-object v2, Landroid/util/Patterns;->EMAIL_ADDRESS:Ljava/util/regex/Pattern;

    invoke-virtual {v2, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 558
    .local v0, "match":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 559
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->start()I

    move-result v2

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->end()I

    move-result v3

    invoke-virtual {p0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 562
    :cond_0
    return-object v1
.end method

.method public static getLabelIdsFromLabelIdsString(Landroid/text/TextUtils$StringSplitter;)Ljava/util/Set;
    .locals 4
    .param p0, "splitter"    # Landroid/text/TextUtils$StringSplitter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/text/TextUtils$StringSplitter;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 632
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v2

    .line 633
    .local v2, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-interface {p0}, Landroid/text/TextUtils$StringSplitter;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 634
    .local v1, "labelIdString":Ljava/lang/String;
    invoke-static {v1}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 636
    .end local v1    # "labelIdString":Ljava/lang/String;
    :cond_0
    return-object v2
.end method

.method public static getLabelIdsFromLabelMap(Ljava/util/Map;)Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 703
    .local p0, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v1

    .line 704
    .local v1, "ids":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-interface {p0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gm/provider/Label;

    .line 705
    .local v2, "label":Lcom/google/android/gm/provider/Label;
    invoke-virtual {v2}, Lcom/google/android/gm/provider/Label;->getId()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 707
    .end local v2    # "label":Lcom/google/android/gm/provider/Label;
    :cond_0
    return-object v1
.end method

.method public static getLabelIdsStringFromLabelIds(Ljava/util/Set;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .local p0, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    const/16 v4, 0x2c

    .line 693
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 694
    .local v2, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 695
    invoke-interface {p0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 696
    .local v1, "labelId":Ljava/lang/Long;
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 697
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 699
    .end local v1    # "labelId":Ljava/lang/Long;
    :cond_0
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public static getLabelUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 428
    const-string v0, "/label/"

    invoke-static {p0, v0}, Lcom/google/android/gm/provider/Gmail;->getCachedUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method static getLabelsUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 421
    const-string v0, "/labels/"

    invoke-static {p0, v0}, Lcom/google/android/gm/provider/Gmail;->getCachedUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getMessageByIdUri(Ljava/lang/String;J)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "localMessageId"    # J

    .prologue
    .line 460
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getMessagesUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method static getMessageLabelUri(Ljava/lang/String;JLjava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "localMessageId"    # J
    .param p3, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 450
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getMessagesUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "labels"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p3}, Lcom/google/android/gm/provider/Gmail;->urlEncodeLabel(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method static getMessageLabelsUri(Ljava/lang/String;J)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "localMessageId"    # J

    .prologue
    .line 476
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getMessagesUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "labels"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getMessagesForConversationUri(Ljava/lang/String;J)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J

    .prologue
    .line 384
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getConversationsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "messages"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method static getMessagesUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 435
    const-string v0, "/messages/"

    invoke-static {p0, v0}, Lcom/google/android/gm/provider/Gmail;->getCachedUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getNameFromAddressString(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "addressString"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    .line 534
    sget-object v3, Lcom/google/android/gm/provider/Gmail;->NAME_ADDRESS_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v3, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 535
    .local v1, "namedAddressMatch":Ljava/util/regex/Matcher;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 536
    invoke-virtual {v1, v5}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    .line 537
    .local v0, "name":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 547
    .end local v0    # "name":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 538
    .restart local v0    # "name":Ljava/lang/String;
    :cond_0
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->end()I

    move-result v3

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {p0, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    .line 542
    .end local v0    # "name":Ljava/lang/String;
    :cond_1
    sget-object v3, Lcom/google/android/gm/provider/Gmail;->UNNAMED_ADDRESS_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v3, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 543
    .local v2, "unnamedAddressMatch":Ljava/util/regex/Matcher;
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->find()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 544
    invoke-virtual {v2, v5}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_2
    move-object v0, p0

    .line 547
    goto :goto_0
.end method

.method private getRawCursorForConversationId(Ljava/lang/String;J)Landroid/database/Cursor;
    .locals 6
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J

    .prologue
    const/4 v3, 0x0

    .line 1096
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1097
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v2, "account is empty"

    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1099
    :cond_0
    invoke-static {p1, p2, p3}, Lcom/google/android/gm/provider/Gmail;->getMessagesForConversationUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v1

    .line 1100
    .local v1, "uri":Landroid/net/Uri;
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v2, Lcom/google/android/gm/provider/Gmail;->MESSAGE_PROJECTION:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method private static getSelectionArguments(Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;)[Ljava/lang/String;
    .locals 3
    .param p0, "becomeActiveNetworkCursor"    # Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;

    .prologue
    .line 1024
    sget-object v0, Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;->NO:Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;

    if-ne v0, p0, :cond_0

    .line 1025
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "SELECTION_ARGUMENT_DO_NOT_BECOME_ACTIVE_NETWORK_CURSOR"

    aput-object v2, v0, v1

    .line 1028
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static declared-synchronized getSenderSnippet(Ljava/lang/String;Landroid/text/SpannableStringBuilder;Landroid/text/SpannableStringBuilder;ILandroid/text/style/CharacterStyle;Landroid/text/style/CharacterStyle;Landroid/text/style/CharacterStyle;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZZZ)V
    .locals 42
    .param p0, "instructions"    # Ljava/lang/String;
    .param p1, "senderBuilder"    # Landroid/text/SpannableStringBuilder;
    .param p2, "statusBuilder"    # Landroid/text/SpannableStringBuilder;
    .param p3, "maxChars"    # I
    .param p4, "unreadStyle"    # Landroid/text/style/CharacterStyle;
    .param p5, "readStyle"    # Landroid/text/style/CharacterStyle;
    .param p6, "draftsStyle"    # Landroid/text/style/CharacterStyle;
    .param p7, "meString"    # Ljava/lang/CharSequence;
    .param p8, "draftString"    # Ljava/lang/CharSequence;
    .param p9, "draftPluralString"    # Ljava/lang/CharSequence;
    .param p10, "sendingString"    # Ljava/lang/CharSequence;
    .param p11, "sendFailedString"    # Ljava/lang/CharSequence;
    .param p12, "forceAllUnread"    # Z
    .param p13, "forceAllRead"    # Z
    .param p14, "allowDraft"    # Z
    .param p15, "showNumMessages"    # Z
    .param p16, "onlyShowUnread"    # Z

    .prologue
    .line 1722
    const-class v38, Lcom/google/android/gm/provider/Gmail;

    monitor-enter v38

    :try_start_0
    sget-boolean v37, Lcom/google/android/gm/provider/Gmail;->$assertionsDisabled:Z

    if-nez v37, :cond_0

    if-eqz p12, :cond_0

    if-eqz p13, :cond_0

    new-instance v37, Ljava/lang/AssertionError;

    invoke-direct/range {v37 .. v37}, Ljava/lang/AssertionError;-><init>()V

    throw v37
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    move-exception v37

    monitor-exit v38

    throw v37

    .line 1723
    :cond_0
    if-nez p12, :cond_1

    if-eqz p13, :cond_2

    :cond_1
    const/16 v35, 0x1

    .line 1724
    .local v35, "unreadStatusIsForced":Z
    :goto_0
    move/from16 v8, p12

    .line 1728
    .local v8, "forcedUnreadStatus":Z
    :try_start_1
    sget-object v31, Lcom/google/android/gm/provider/Gmail;->sPriorityToLength:Ljava/util/Map;

    .line 1729
    .local v31, "priorityToLength":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    invoke-interface/range {v31 .. v31}, Ljava/util/Map;->clear()V

    .line 1731
    const/high16 v16, -0x80000000

    .line 1732
    .local v16, "maxFoundPriority":I
    const/16 v26, 0x0

    .line 1733
    .local v26, "numMessages":I
    const/16 v22, 0x0

    .line 1734
    .local v22, "numDrafts":I
    const-string v5, ""

    .line 1735
    .local v5, "draftsFragment":Ljava/lang/CharSequence;
    const-string v33, ""

    .line 1736
    .local v33, "sendingFragment":Ljava/lang/CharSequence;
    const-string v32, ""

    .line 1738
    .local v32, "sendFailedFragment":Ljava/lang/CharSequence;
    sget-object v37, Lcom/google/android/gm/provider/Gmail;->sSenderListSplitter:Landroid/text/TextUtils$SimpleStringSplitter;

    move-object/from16 v0, v37

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/text/TextUtils$SimpleStringSplitter;->setString(Ljava/lang/String;)V

    .line 1739
    const/16 v24, 0x0

    .line 1740
    .local v24, "numFragments":I
    sget-object v10, Lcom/google/android/gm/provider/Gmail;->sSenderFragments:[Ljava/lang/String;

    .line 1741
    .local v10, "fragments":[Ljava/lang/String;
    array-length v4, v10

    .local v4, "currentSize":I
    move/from16 v25, v24

    .line 1742
    .end local v24    # "numFragments":I
    .local v25, "numFragments":I
    :goto_1
    sget-object v37, Lcom/google/android/gm/provider/Gmail;->sSenderListSplitter:Landroid/text/TextUtils$SimpleStringSplitter;

    invoke-virtual/range {v37 .. v37}, Landroid/text/TextUtils$SimpleStringSplitter;->hasNext()Z

    move-result v37

    if-eqz v37, :cond_3

    .line 1743
    add-int/lit8 v24, v25, 0x1

    .end local v25    # "numFragments":I
    .restart local v24    # "numFragments":I
    sget-object v37, Lcom/google/android/gm/provider/Gmail;->sSenderListSplitter:Landroid/text/TextUtils$SimpleStringSplitter;

    invoke-virtual/range {v37 .. v37}, Landroid/text/TextUtils$SimpleStringSplitter;->next()Ljava/lang/String;

    move-result-object v37

    aput-object v37, v10, v25

    .line 1744
    move/from16 v0, v24

    if-ne v0, v4, :cond_34

    .line 1745
    mul-int/lit8 v37, v4, 0x2

    move/from16 v0, v37

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v37, v0

    sput-object v37, Lcom/google/android/gm/provider/Gmail;->sSenderFragments:[Ljava/lang/String;

    .line 1746
    const/16 v37, 0x0

    sget-object v39, Lcom/google/android/gm/provider/Gmail;->sSenderFragments:[Ljava/lang/String;

    const/16 v40, 0x0

    move/from16 v0, v37

    move-object/from16 v1, v39

    move/from16 v2, v40

    invoke-static {v10, v0, v1, v2, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1747
    mul-int/lit8 v4, v4, 0x2

    .line 1748
    sget-object v10, Lcom/google/android/gm/provider/Gmail;->sSenderFragments:[Ljava/lang/String;

    move/from16 v25, v24

    .end local v24    # "numFragments":I
    .restart local v25    # "numFragments":I
    goto :goto_1

    .line 1723
    .end local v4    # "currentSize":I
    .end local v5    # "draftsFragment":Ljava/lang/CharSequence;
    .end local v8    # "forcedUnreadStatus":Z
    .end local v10    # "fragments":[Ljava/lang/String;
    .end local v16    # "maxFoundPriority":I
    .end local v22    # "numDrafts":I
    .end local v25    # "numFragments":I
    .end local v26    # "numMessages":I
    .end local v31    # "priorityToLength":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    .end local v32    # "sendFailedFragment":Ljava/lang/CharSequence;
    .end local v33    # "sendingFragment":Ljava/lang/CharSequence;
    .end local v35    # "unreadStatusIsForced":Z
    :cond_2
    const/16 v35, 0x0

    goto :goto_0

    .line 1752
    .restart local v4    # "currentSize":I
    .restart local v5    # "draftsFragment":Ljava/lang/CharSequence;
    .restart local v8    # "forcedUnreadStatus":Z
    .restart local v10    # "fragments":[Ljava/lang/String;
    .restart local v16    # "maxFoundPriority":I
    .restart local v22    # "numDrafts":I
    .restart local v25    # "numFragments":I
    .restart local v26    # "numMessages":I
    .restart local v31    # "priorityToLength":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    .restart local v32    # "sendFailedFragment":Ljava/lang/CharSequence;
    .restart local v33    # "sendingFragment":Ljava/lang/CharSequence;
    .restart local v35    # "unreadStatusIsForced":Z
    :cond_3
    const/4 v11, 0x0

    .local v11, "i":I
    move v12, v11

    .end local v11    # "i":I
    .local v12, "i":I
    :goto_2
    move/from16 v0, v25

    if-ge v12, v0, :cond_11

    .line 1753
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget-object v9, v10, v12

    .line 1754
    .local v9, "fragment0":Ljava/lang/String;
    const-string v37, ""

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_5

    :cond_4
    :goto_3
    move v12, v11

    .line 1789
    .end local v11    # "i":I
    .restart local v12    # "i":I
    goto :goto_2

    .line 1756
    .end local v12    # "i":I
    .restart local v11    # "i":I
    :cond_5
    const-string v37, "e"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-nez v37, :cond_4

    .line 1758
    const-string v37, "n"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_6

    .line 1759
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget-object v37, v10, v11

    invoke-static/range {v37 .. v37}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Ljava/lang/Integer;->intValue()I

    move-result v26

    move v11, v12

    .end local v12    # "i":I
    .restart local v11    # "i":I
    goto :goto_3

    .line 1760
    :cond_6
    const-string v37, "d"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_8

    .line 1761
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget-object v23, v10, v11

    .line 1762
    .local v23, "numDraftsString":Ljava/lang/String;
    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v22

    .line 1763
    const/16 v37, 0x1

    move/from16 v0, v22

    move/from16 v1, v37

    if-ne v0, v1, :cond_7

    move-object/from16 v5, p8

    :goto_4
    move v11, v12

    .line 1765
    .end local v12    # "i":I
    .restart local v11    # "i":I
    goto :goto_3

    .line 1763
    .end local v11    # "i":I
    .restart local v12    # "i":I
    :cond_7
    new-instance v37, Ljava/lang/StringBuilder;

    invoke-direct/range {v37 .. v37}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v37

    move-object/from16 v1, p9

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v37

    const-string v39, " ("

    move-object/from16 v0, v37

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    move-object/from16 v0, v37

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    const-string v39, ")"

    move-object/from16 v0, v37

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_4

    .line 1765
    .end local v12    # "i":I
    .end local v23    # "numDraftsString":Ljava/lang/String;
    .restart local v11    # "i":I
    :cond_8
    const-string v37, "l"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_a

    .line 1766
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget-object v37, v10, v11

    invoke-static/range {v37 .. v37}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v37

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1925
    .end local v9    # "fragment0":Ljava/lang/String;
    :cond_9
    :goto_5
    monitor-exit v38

    return-void

    .line 1768
    .end local v12    # "i":I
    .restart local v9    # "fragment0":Ljava/lang/String;
    .restart local v11    # "i":I
    :cond_a
    :try_start_2
    const-string v37, "s"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_b

    .line 1769
    move-object/from16 v33, p10

    goto/16 :goto_3

    .line 1770
    :cond_b
    const-string v37, "f"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_c

    .line 1771
    move-object/from16 v32, p11

    goto/16 :goto_3

    .line 1773
    :cond_c
    move-object/from16 v36, v9

    .line 1774
    .local v36, "unreadString":Ljava/lang/String;
    if-eqz v35, :cond_f

    move/from16 v34, v8

    .line 1776
    .local v34, "unread":Z
    :goto_6
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget-object v30, v10, v11

    .line 1777
    .local v30, "priorityString":Ljava/lang/String;
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget-object v18, v10, v12

    .line 1778
    .local v18, "nameString":Ljava/lang/CharSequence;
    invoke-interface/range {v18 .. v18}, Ljava/lang/CharSequence;->length()I

    move-result v37

    if-nez v37, :cond_d

    move-object/from16 v18, p7

    .line 1779
    :cond_d
    invoke-static/range {v30 .. v30}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v29

    .line 1784
    .local v29, "priority":I
    if-eqz p16, :cond_e

    if-eqz v34, :cond_4

    .line 1785
    :cond_e
    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v37

    invoke-interface/range {v18 .. v18}, Ljava/lang/CharSequence;->length()I

    move-result v39

    invoke-static/range {v39 .. v39}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v39

    move-object/from16 v0, v31

    move-object/from16 v1, v37

    move-object/from16 v2, v39

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1786
    move/from16 v0, v16

    move/from16 v1, v29

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v16

    goto/16 :goto_3

    .line 1774
    .end local v18    # "nameString":Ljava/lang/CharSequence;
    .end local v29    # "priority":I
    .end local v30    # "priorityString":Ljava/lang/String;
    .end local v34    # "unread":Z
    :cond_f
    invoke-static/range {v36 .. v36}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v37

    if-eqz v37, :cond_10

    const/16 v34, 0x1

    goto :goto_6

    :cond_10
    const/16 v34, 0x0

    goto :goto_6

    .line 1790
    .end local v9    # "fragment0":Ljava/lang/String;
    .end local v11    # "i":I
    .end local v36    # "unreadString":Ljava/lang/String;
    .restart local v12    # "i":I
    :cond_11
    if-eqz v26, :cond_20

    if-eqz p15, :cond_20

    new-instance v37, Ljava/lang/StringBuilder;

    invoke-direct/range {v37 .. v37}, Ljava/lang/StringBuilder;-><init>()V

    const-string v39, " \u00a0"

    move-object/from16 v0, v37

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    add-int v39, v26, v22

    invoke-static/range {v39 .. v39}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v39

    move-object/from16 v0, v37

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v27

    .line 1795
    .local v27, "numMessagesFragment":Ljava/lang/String;
    :goto_7
    const/4 v6, 0x0

    .line 1796
    .local v6, "fixedFragment":Landroid/text/SpannableStringBuilder;
    const/4 v7, 0x0

    .line 1797
    .local v7, "fixedFragmentLength":I
    invoke-interface {v5}, Ljava/lang/CharSequence;->length()I

    move-result v37

    if-eqz v37, :cond_13

    if-eqz p14, :cond_13

    .line 1798
    if-nez v6, :cond_12

    .line 1799
    new-instance v6, Landroid/text/SpannableStringBuilder;

    .end local v6    # "fixedFragment":Landroid/text/SpannableStringBuilder;
    invoke-direct {v6}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 1801
    .restart local v6    # "fixedFragment":Landroid/text/SpannableStringBuilder;
    :cond_12
    invoke-virtual {v6, v5}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1802
    if-eqz p6, :cond_13

    .line 1803
    invoke-static/range {p6 .. p6}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v37

    const/16 v39, 0x0

    invoke-virtual {v6}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v40

    const/16 v41, 0x21

    move-object/from16 v0, v37

    move/from16 v1, v39

    move/from16 v2, v40

    move/from16 v3, v41

    invoke-virtual {v6, v0, v1, v2, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 1808
    :cond_13
    invoke-interface/range {v33 .. v33}, Ljava/lang/CharSequence;->length()I

    move-result v37

    if-eqz v37, :cond_16

    .line 1809
    if-nez v6, :cond_14

    .line 1810
    new-instance v6, Landroid/text/SpannableStringBuilder;

    .end local v6    # "fixedFragment":Landroid/text/SpannableStringBuilder;
    invoke-direct {v6}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 1812
    .restart local v6    # "fixedFragment":Landroid/text/SpannableStringBuilder;
    :cond_14
    invoke-virtual {v6}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v37

    if-eqz v37, :cond_15

    const-string v37, ", "

    move-object/from16 v0, v37

    invoke-virtual {v6, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1813
    :cond_15
    move-object/from16 v0, v33

    invoke-virtual {v6, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1815
    :cond_16
    invoke-interface/range {v32 .. v32}, Ljava/lang/CharSequence;->length()I

    move-result v37

    if-eqz v37, :cond_19

    .line 1816
    if-nez v6, :cond_17

    .line 1817
    new-instance v6, Landroid/text/SpannableStringBuilder;

    .end local v6    # "fixedFragment":Landroid/text/SpannableStringBuilder;
    invoke-direct {v6}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 1819
    .restart local v6    # "fixedFragment":Landroid/text/SpannableStringBuilder;
    :cond_17
    invoke-virtual {v6}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v37

    if-eqz v37, :cond_18

    const-string v37, ", "

    move-object/from16 v0, v37

    invoke-virtual {v6, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1820
    :cond_18
    move-object/from16 v0, v32

    invoke-virtual {v6, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1823
    :cond_19
    if-eqz v6, :cond_1a

    .line 1824
    invoke-virtual {v6}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v7

    .line 1826
    :cond_1a
    sub-int p3, p3, v7

    .line 1828
    invoke-virtual/range {v27 .. v27}, Ljava/lang/String;->length()I

    move-result v37

    if-nez v37, :cond_1b

    const/high16 v37, -0x80000000

    move/from16 v0, v16

    move/from16 v1, v37

    if-eq v0, v1, :cond_21

    :cond_1b
    const/16 v19, 0x1

    .line 1830
    .local v19, "normalMessagesExist":Z
    :goto_8
    const/16 v17, -0x1

    .line 1831
    .local v17, "maxPriorityToInclude":I
    invoke-virtual/range {v27 .. v27}, Ljava/lang/String;->length()I

    move-result v21

    .line 1832
    .local v21, "numCharsUsed":I
    const/16 v28, 0x0

    .line 1833
    .local v28, "numSendersUsed":I
    :goto_9
    move/from16 v0, v17

    move/from16 v1, v16

    if-ge v0, v1, :cond_1d

    .line 1834
    add-int/lit8 v37, v17, 0x1

    invoke-static/range {v37 .. v37}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v37

    move-object/from16 v0, v31

    move-object/from16 v1, v37

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_23

    .line 1835
    add-int/lit8 v37, v17, 0x1

    invoke-static/range {v37 .. v37}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v37

    move-object/from16 v0, v31

    move-object/from16 v1, v37

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    check-cast v37, Ljava/lang/Integer;

    invoke-virtual/range {v37 .. v37}, Ljava/lang/Integer;->intValue()I

    move-result v37

    add-int v15, v21, v37

    .line 1836
    .local v15, "length":I
    if-lez v21, :cond_1c

    add-int/lit8 v15, v15, 0x2

    .line 1839
    :cond_1c
    move/from16 v0, p3

    if-le v15, v0, :cond_22

    const/16 v37, 0x2

    move/from16 v0, v28

    move/from16 v1, v37

    if-lt v0, v1, :cond_22

    .line 1848
    .end local v15    # "length":I
    :cond_1d
    const/16 v20, 0x0

    .line 1849
    .local v20, "numCharsToRemovePerWord":I
    move/from16 v0, v21

    move/from16 v1, p3

    if-le v0, v1, :cond_1e

    .line 1850
    sub-int v37, v21, p3

    div-int v20, v37, v28

    .line 1853
    :cond_1e
    const/4 v13, 0x0

    .line 1854
    .local v13, "lastFragment":Ljava/lang/String;
    const/4 v14, 0x0

    .line 1855
    .local v14, "lastStyle":Landroid/text/style/CharacterStyle;
    const/4 v11, 0x0

    .end local v12    # "i":I
    .restart local v11    # "i":I
    move v12, v11

    .end local v11    # "i":I
    .restart local v12    # "i":I
    :goto_a
    move/from16 v0, v25

    if-ge v12, v0, :cond_32

    .line 1856
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget-object v9, v10, v12

    .line 1857
    .restart local v9    # "fragment0":Ljava/lang/String;
    const-string v37, ""

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_24

    :cond_1f
    :goto_b
    move v12, v11

    .line 1917
    .end local v11    # "i":I
    .restart local v12    # "i":I
    goto :goto_a

    .line 1790
    .end local v6    # "fixedFragment":Landroid/text/SpannableStringBuilder;
    .end local v7    # "fixedFragmentLength":I
    .end local v9    # "fragment0":Ljava/lang/String;
    .end local v13    # "lastFragment":Ljava/lang/String;
    .end local v14    # "lastStyle":Landroid/text/style/CharacterStyle;
    .end local v17    # "maxPriorityToInclude":I
    .end local v19    # "normalMessagesExist":Z
    .end local v20    # "numCharsToRemovePerWord":I
    .end local v21    # "numCharsUsed":I
    .end local v27    # "numMessagesFragment":Ljava/lang/String;
    .end local v28    # "numSendersUsed":I
    :cond_20
    const-string v27, ""

    goto/16 :goto_7

    .line 1828
    .restart local v6    # "fixedFragment":Landroid/text/SpannableStringBuilder;
    .restart local v7    # "fixedFragmentLength":I
    .restart local v27    # "numMessagesFragment":Ljava/lang/String;
    :cond_21
    const/16 v19, 0x0

    goto :goto_8

    .line 1842
    .restart local v15    # "length":I
    .restart local v17    # "maxPriorityToInclude":I
    .restart local v19    # "normalMessagesExist":Z
    .restart local v21    # "numCharsUsed":I
    .restart local v28    # "numSendersUsed":I
    :cond_22
    move/from16 v21, v15

    .line 1843
    add-int/lit8 v28, v28, 0x1

    .line 1845
    .end local v15    # "length":I
    :cond_23
    add-int/lit8 v17, v17, 0x1

    goto :goto_9

    .line 1859
    .end local v12    # "i":I
    .restart local v9    # "fragment0":Ljava/lang/String;
    .restart local v11    # "i":I
    .restart local v13    # "lastFragment":Ljava/lang/String;
    .restart local v14    # "lastStyle":Landroid/text/style/CharacterStyle;
    .restart local v20    # "numCharsToRemovePerWord":I
    :cond_24
    const-string v37, "e"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_26

    .line 1860
    if-eqz v13, :cond_25

    .line 1861
    const/16 v37, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v37

    invoke-static {v0, v13, v14, v1}, Lcom/google/android/gm/provider/Gmail;->addStyledFragment(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Landroid/text/style/CharacterStyle;Z)V

    .line 1862
    const-string v37, " "

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1863
    const-string v37, ".."

    const/16 v39, 0x1

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    move/from16 v2, v39

    invoke-static {v0, v1, v14, v2}, Lcom/google/android/gm/provider/Gmail;->addStyledFragment(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Landroid/text/style/CharacterStyle;Z)V

    .line 1864
    const-string v37, " "

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1866
    :cond_25
    const/4 v13, 0x0

    goto :goto_b

    .line 1867
    :cond_26
    const-string v37, "n"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_27

    .line 1868
    add-int/lit8 v11, v11, 0x1

    goto :goto_b

    .line 1869
    :cond_27
    const-string v37, "d"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_28

    .line 1870
    add-int/lit8 v11, v11, 0x1

    goto :goto_b

    .line 1871
    :cond_28
    const-string v37, "s"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-nez v37, :cond_1f

    .line 1872
    const-string v37, "f"

    move-object/from16 v0, v37

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-nez v37, :cond_1f

    .line 1874
    move-object/from16 v36, v9

    .line 1875
    .restart local v36    # "unreadString":Ljava/lang/String;
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget-object v30, v10, v11

    .line 1876
    .restart local v30    # "priorityString":Ljava/lang/String;
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget-object v18, v10, v12

    .line 1877
    .local v18, "nameString":Ljava/lang/String;
    if-eqz v35, :cond_2c

    move/from16 v34, v8

    .line 1883
    .restart local v34    # "unread":Z
    :goto_c
    if-eqz p16, :cond_29

    if-eqz v34, :cond_1f

    .line 1884
    :cond_29
    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->length()I

    move-result v37

    if-nez v37, :cond_2e

    .line 1885
    invoke-virtual/range {p7 .. p7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v18

    .line 1889
    :goto_d
    if-eqz v20, :cond_2a

    .line 1890
    const/16 v37, 0x0

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->length()I

    move-result v39

    sub-int v39, v39, v20

    const/16 v40, 0x0

    invoke-static/range {v39 .. v40}, Ljava/lang/Math;->max(II)I

    move-result v39

    move-object/from16 v0, v18

    move/from16 v1, v37

    move/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v18

    .line 1893
    :cond_2a
    invoke-static/range {v30 .. v30}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v29

    .line 1894
    .restart local v29    # "priority":I
    move/from16 v0, v29

    move/from16 v1, v17

    if-gt v0, v1, :cond_30

    .line 1895
    if-eqz v13, :cond_2b

    move-object/from16 v0, v18

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-nez v37, :cond_2b

    .line 1896
    const-string v37, ","

    move-object/from16 v0, v37

    invoke-virtual {v13, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    const/16 v39, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    move/from16 v2, v39

    invoke-static {v0, v1, v14, v2}, Lcom/google/android/gm/provider/Gmail;->addStyledFragment(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Landroid/text/style/CharacterStyle;Z)V

    .line 1898
    const-string v37, " "

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1900
    :cond_2b
    move-object/from16 v13, v18

    .line 1901
    if-eqz v34, :cond_2f

    move-object/from16 v14, p4

    :goto_e
    goto/16 :goto_b

    .line 1877
    .end local v29    # "priority":I
    .end local v34    # "unread":Z
    :cond_2c
    invoke-static/range {v36 .. v36}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v37

    if-eqz v37, :cond_2d

    const/16 v34, 0x1

    goto :goto_c

    :cond_2d
    const/16 v34, 0x0

    goto :goto_c

    .line 1887
    .restart local v34    # "unread":Z
    :cond_2e
    invoke-static/range {v18 .. v18}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v18

    goto :goto_d

    .restart local v29    # "priority":I
    :cond_2f
    move-object/from16 v14, p5

    .line 1901
    goto :goto_e

    .line 1903
    :cond_30
    if-eqz v13, :cond_31

    .line 1904
    const/16 v37, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v37

    invoke-static {v0, v13, v14, v1}, Lcom/google/android/gm/provider/Gmail;->addStyledFragment(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Landroid/text/style/CharacterStyle;Z)V

    .line 1909
    const-string v37, " "

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1910
    const-string v37, ".."

    const/16 v39, 0x1

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    move/from16 v2, v39

    invoke-static {v0, v1, v14, v2}, Lcom/google/android/gm/provider/Gmail;->addStyledFragment(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Landroid/text/style/CharacterStyle;Z)V

    .line 1911
    const-string v37, " "

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1913
    :cond_31
    const/4 v13, 0x0

    goto/16 :goto_b

    .line 1918
    .end local v9    # "fragment0":Ljava/lang/String;
    .end local v11    # "i":I
    .end local v18    # "nameString":Ljava/lang/String;
    .end local v29    # "priority":I
    .end local v30    # "priorityString":Ljava/lang/String;
    .end local v34    # "unread":Z
    .end local v36    # "unreadString":Ljava/lang/String;
    .restart local v12    # "i":I
    :cond_32
    if-eqz v13, :cond_33

    .line 1919
    const/16 v37, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v37

    invoke-static {v0, v13, v14, v1}, Lcom/google/android/gm/provider/Gmail;->addStyledFragment(Landroid/text/SpannableStringBuilder;Ljava/lang/String;Landroid/text/style/CharacterStyle;Z)V

    .line 1921
    :cond_33
    move-object/from16 v0, p1

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1922
    if-eqz v7, :cond_9

    .line 1923
    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_5

    .end local v6    # "fixedFragment":Landroid/text/SpannableStringBuilder;
    .end local v7    # "fixedFragmentLength":I
    .end local v12    # "i":I
    .end local v13    # "lastFragment":Ljava/lang/String;
    .end local v14    # "lastStyle":Landroid/text/style/CharacterStyle;
    .end local v17    # "maxPriorityToInclude":I
    .end local v19    # "normalMessagesExist":Z
    .end local v20    # "numCharsToRemovePerWord":I
    .end local v21    # "numCharsUsed":I
    .end local v25    # "numFragments":I
    .end local v27    # "numMessagesFragment":Ljava/lang/String;
    .end local v28    # "numSendersUsed":I
    .restart local v24    # "numFragments":I
    :cond_34
    move/from16 v25, v24

    .end local v24    # "numFragments":I
    .restart local v25    # "numFragments":I
    goto/16 :goto_1
.end method

.method static getSettings(Landroid/content/Context;Landroid/database/Cursor;)Lcom/google/android/gm/provider/Gmail$Settings;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 1521
    new-instance v1, Lcom/google/android/gm/provider/Gmail$Settings;

    invoke-direct {v1}, Lcom/google/android/gm/provider/Gmail$Settings;-><init>()V

    .line 1522
    .local v1, "settings":Lcom/google/android/gm/provider/Gmail$Settings;
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    .line 1527
    const/4 v3, 0x0

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/google/android/gm/provider/Gmail;->SPACE_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v3

    # setter for: Lcom/google/android/gm/provider/Gmail$Settings;->mLabelsIncluded:Ljava/util/Set;
    invoke-static {v1, v3}, Lcom/google/android/gm/provider/Gmail$Settings;->access$202(Lcom/google/android/gm/provider/Gmail$Settings;Ljava/util/Set;)Ljava/util/Set;

    .line 1529
    const/4 v3, 0x1

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/google/android/gm/provider/Gmail;->SPACE_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v3

    # setter for: Lcom/google/android/gm/provider/Gmail$Settings;->mLabelsPartial:Ljava/util/Set;
    invoke-static {v1, v3}, Lcom/google/android/gm/provider/Gmail$Settings;->access$302(Lcom/google/android/gm/provider/Gmail$Settings;Ljava/util/Set;)Ljava/util/Set;

    .line 1531
    const/4 v3, 0x2

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1532
    .local v2, "syncDuration":Ljava/lang/String;
    if-eqz v2, :cond_0

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    :goto_0
    # setter for: Lcom/google/android/gm/provider/Gmail$Settings;->mConversationAgeDays:J
    invoke-static {v1, v3, v4}, Lcom/google/android/gm/provider/Gmail$Settings;->access$402(Lcom/google/android/gm/provider/Gmail$Settings;J)J

    .line 1535
    const/4 v3, 0x3

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1537
    .local v0, "attachmentSize":Ljava/lang/String;
    if-eqz v0, :cond_1

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    :goto_1
    # setter for: Lcom/google/android/gm/provider/Gmail$Settings;->mMaxAttachmentSizeMb:J
    invoke-static {v1, v3, v4}, Lcom/google/android/gm/provider/Gmail$Settings;->access$502(Lcom/google/android/gm/provider/Gmail$Settings;J)J

    .line 1539
    return-object v1

    .line 1532
    .end local v0    # "attachmentSize":Ljava/lang/String;
    :cond_0
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getDefaultConversationAgeDays(Landroid/content/Context;)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    goto :goto_0

    .line 1537
    .restart local v0    # "attachmentSize":Ljava/lang/String;
    :cond_1
    const-wide/16 v3, 0x0

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    goto :goto_1
.end method

.method static getSettingsUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 485
    const-string v0, "/settings/"

    invoke-static {p0, v0}, Lcom/google/android/gm/provider/Gmail;->getCachedUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getStatusUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 492
    const-string v0, "/status/"

    invoke-static {p0, v0}, Lcom/google/android/gm/provider/Gmail;->getCachedUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static isDisplayableSystemLabel(Ljava/lang/String;)Z
    .locals 1
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 524
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->DISPLAYABLE_SYSTEM_LABELS:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isImportant(Ljava/util/Map;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 516
    .local p0, "set":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    const-string v0, "^io_im"

    invoke-interface {p0, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isLabelProviderSettable(Ljava/lang/String;)Z
    .locals 1
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 621
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->ASSIGNABLE_BUILTIN_LABELS:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->isLabelUserSettable(Ljava/lang/String;)Z

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

.method public static isLabelUserDefined(Ljava/lang/String;)Z
    .locals 1
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 572
    if-eqz p0, :cond_0

    const-string v0, "^"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isLabelUserSettable(Ljava/lang/String;)Z
    .locals 1
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 602
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->USER_SETTABLE_BUILTIN_LABELS:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->isLabelUserDefined(Ljava/lang/String;)Z

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

.method public static isRunningICSOrLater()Z
    .locals 2

    .prologue
    .line 2880
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isSystemLabel(Ljava/lang/String;)Z
    .locals 1
    .param p0, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 507
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->SYSTEM_LABELS:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static newConversationLabelIdsSplitter()Landroid/text/TextUtils$StringSplitter;
    .locals 1

    .prologue
    .line 670
    new-instance v0, Lcom/google/android/gm/provider/Gmail$CommaStringSplitter;

    invoke-direct {v0}, Lcom/google/android/gm/provider/Gmail$CommaStringSplitter;-><init>()V

    return-object v0
.end method

.method public static newMessageLabelIdsSplitter()Landroid/text/TextUtils$StringSplitter;
    .locals 2

    .prologue
    .line 663
    new-instance v0, Landroid/text/TextUtils$SimpleStringSplitter;

    const/16 v1, 0x20

    invoke-direct {v0, v1}, Landroid/text/TextUtils$SimpleStringSplitter;-><init>(C)V

    return-object v0
.end method

.method private settingsToValues(Lcom/google/android/gm/provider/Gmail$Settings;)Landroid/content/ContentValues;
    .locals 5
    .param p1, "settings"    # Lcom/google/android/gm/provider/Gmail$Settings;

    .prologue
    const/16 v4, 0x20

    .line 1560
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1561
    .local v0, "values":Landroid/content/ContentValues;
    # invokes: Lcom/google/android/gm/provider/Gmail$Settings;->hasLabelsIncludedChanged()Z
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$Settings;->access$600(Lcom/google/android/gm/provider/Gmail$Settings;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1562
    const-string v1, "labelsIncluded"

    invoke-static {v4}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v2

    # getter for: Lcom/google/android/gm/provider/Gmail$Settings;->mLabelsIncluded:Ljava/util/Set;
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$Settings;->access$200(Lcom/google/android/gm/provider/Gmail$Settings;)Ljava/util/Set;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1567
    :cond_0
    # invokes: Lcom/google/android/gm/provider/Gmail$Settings;->hasLabelsPartialChanged()Z
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$Settings;->access$700(Lcom/google/android/gm/provider/Gmail$Settings;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1568
    const-string v1, "labelsPartial"

    invoke-static {v4}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v2

    # getter for: Lcom/google/android/gm/provider/Gmail$Settings;->mLabelsPartial:Ljava/util/Set;
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$Settings;->access$300(Lcom/google/android/gm/provider/Gmail$Settings;)Ljava/util/Set;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1573
    :cond_1
    # invokes: Lcom/google/android/gm/provider/Gmail$Settings;->hasConversationAgeDaysChanged()Z
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$Settings;->access$800(Lcom/google/android/gm/provider/Gmail$Settings;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1574
    const-string v1, "conversationAgeDays"

    # getter for: Lcom/google/android/gm/provider/Gmail$Settings;->mConversationAgeDays:J
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$Settings;->access$400(Lcom/google/android/gm/provider/Gmail$Settings;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1578
    :cond_2
    # invokes: Lcom/google/android/gm/provider/Gmail$Settings;->hasMaxAttachmentSizeMbChanged()Z
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$Settings;->access$900(Lcom/google/android/gm/provider/Gmail$Settings;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1579
    const-string v1, "maxAttachmentSize"

    # getter for: Lcom/google/android/gm/provider/Gmail$Settings;->mMaxAttachmentSizeMb:J
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$Settings;->access$500(Lcom/google/android/gm/provider/Gmail$Settings;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1583
    :cond_3
    return-object v0
.end method

.method private static toNonnullString(Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 974
    if-nez p0, :cond_0

    .line 975
    const-string p0, ""

    .line 977
    .end local p0    # "source":Ljava/lang/String;
    :cond_0
    return-object p0
.end method

.method private static urlEncodeLabel(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 497
    :try_start_0
    const-string v1, "utf-8"

    invoke-static {p0, v1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 498
    :catch_0
    move-exception v0

    .line 499
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public addOrRemoveLabelOnConversationBulk(Ljava/lang/String;[Landroid/content/ContentValues;)V
    .locals 1
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "values"    # [Landroid/content/ContentValues;

    .prologue
    .line 1118
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/google/android/gm/provider/Gmail;->addOrRemoveLabelOnConversationBulk(Ljava/lang/String;[Landroid/content/ContentValues;Z)V

    .line 1119
    return-void
.end method

.method public addOrRemoveLabelOnConversationBulk(Ljava/lang/String;[Landroid/content/ContentValues;Z)V
    .locals 4
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "values"    # [Landroid/content/ContentValues;
    .param p3, "suppressUiNotifications"    # Z

    .prologue
    .line 1137
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1138
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "account is empty"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1140
    :cond_0
    const-string v1, "/conversations/labels"

    invoke-static {p1, v1}, Lcom/google/android/gm/provider/Gmail;->getCachedUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 1141
    .local v0, "uri":Landroid/net/Uri;
    if-eqz p3, :cond_1

    .line 1142
    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "suppressUINotifications"

    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 1146
    :cond_1
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {v1, v0, p2}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    .line 1147
    return-void
.end method

.method addOrRemoveLabelOnMessageBulk(Ljava/lang/String;[Landroid/content/ContentValues;Z)V
    .locals 4
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "values"    # [Landroid/content/ContentValues;
    .param p3, "suppressUiNotifications"    # Z

    .prologue
    .line 1177
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1178
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "account is empty"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1180
    :cond_0
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->getMessagesUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "labels"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 1182
    .local v0, "uri":Landroid/net/Uri;
    if-eqz p3, :cond_1

    .line 1183
    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "suppressUINotifications"

    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 1186
    :cond_1
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {v1, v0, p2}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    .line 1187
    return-void
.end method

.method public getBackupSettings(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$Settings;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;

    .prologue
    .line 1506
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1507
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "account is empty"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1509
    :cond_0
    invoke-static {p1, p2}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngine(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v1

    .line 1510
    .local v1, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    sget-object v2, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getPublicSettingsCursor([Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 1512
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-static {p1, v0}, Lcom/google/android/gm/provider/Gmail;->getSettings(Landroid/content/Context;Landroid/database/Cursor;)Lcom/google/android/gm/provider/Gmail$Settings;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 1514
    if-eqz v0, :cond_1

    .line 1515
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_1
    return-object v2

    .line 1514
    :catchall_0
    move-exception v2

    if-eqz v0, :cond_2

    .line 1515
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v2
.end method

.method public getConversationCursorForCursor(Ljava/lang/String;Landroid/database/Cursor;)Lcom/google/android/gm/provider/Gmail$ConversationCursor;
    .locals 2
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 1012
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1013
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "account is empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1015
    :cond_0
    new-instance v0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;-><init>(Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;Lcom/google/android/gm/provider/Gmail$1;)V

    return-object v0
.end method

.method public getDetachedConversationCursorForQuery(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;)Lcom/google/android/gm/provider/Gmail$ConversationCursor;
    .locals 7
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "query"    # Ljava/lang/String;
    .param p3, "becomeActiveNetworkCursor"    # Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;

    .prologue
    .line 1044
    invoke-static {p3}, Lcom/google/android/gm/provider/Gmail;->getSelectionArguments(Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;)[Ljava/lang/String;

    move-result-object v4

    .line 1045
    .local v4, "selectionArgs":[Ljava/lang/String;
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->getConversationsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcom/google/android/gm/provider/Gmail;->CONVERSATION_PROJECTION:[Ljava/lang/String;

    const/4 v5, 0x0

    move-object v3, p2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 1048
    .local v6, "cursor":Landroid/database/Cursor;
    new-instance v0, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;

    invoke-direct {v0, p0, p1, v6}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;-><init>(Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;)V

    return-object v0
.end method

.method public getDetachedMessageCursorForConversationId(Ljava/lang/String;J)Lcom/google/android/gm/provider/Gmail$MessageCursor;
    .locals 3
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J

    .prologue
    .line 1091
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gm/provider/Gmail;->getRawCursorForConversationId(Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v0

    .line 1092
    .local v0, "cursor":Landroid/database/Cursor;
    new-instance v1, Lcom/google/android/gm/provider/Gmail$DetachedMessageCursor;

    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    invoke-direct {v1, v2, p1, v0}, Lcom/google/android/gm/provider/Gmail$DetachedMessageCursor;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;)V

    return-object v1
.end method

.method public getLabelMap(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$LabelMap;
    .locals 1
    .param p1, "account"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2509
    invoke-static {}, Lcom/google/android/gm/provider/MailProvider;->getMailProvider()Lcom/google/android/gm/provider/MailProvider;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v0

    return-object v0
.end method

.method public getMessageCursorForConversationId(Ljava/lang/String;J)Lcom/google/android/gm/provider/Gmail$MessageCursor;
    .locals 4
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J

    .prologue
    .line 1077
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gm/provider/Gmail;->getRawCursorForConversationId(Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v0

    .line 1078
    .local v0, "cursor":Landroid/database/Cursor;
    new-instance v1, Lcom/google/android/gm/provider/Gmail$MessageCursor;

    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    const/4 v3, 0x0

    invoke-direct {v1, v2, p1, v0, v3}, Lcom/google/android/gm/provider/Gmail$MessageCursor;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;Lcom/google/android/gm/provider/Gmail$1;)V

    return-object v1
.end method

.method public getMessageCursorForMessageId(Ljava/lang/String;J)Lcom/google/android/gm/provider/Gmail$MessageCursor;
    .locals 7
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "messageId"    # J

    .prologue
    const/4 v3, 0x0

    .line 1060
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1061
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v2, "account is empty"

    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1063
    :cond_0
    invoke-static {p1, p2, p3}, Lcom/google/android/gm/provider/Gmail;->getMessageByIdUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v1

    .line 1064
    .local v1, "uri":Landroid/net/Uri;
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v2, Lcom/google/android/gm/provider/Gmail;->MESSAGE_PROJECTION:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 1066
    .local v6, "cursor":Landroid/database/Cursor;
    new-instance v0, Lcom/google/android/gm/provider/Gmail$MessageCursor;

    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    invoke-direct {v0, v2, p1, v6, v3}, Lcom/google/android/gm/provider/Gmail$MessageCursor;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;Lcom/google/android/gm/provider/Gmail$1;)V

    return-object v0
.end method

.method public getSettings(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$Settings;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 1491
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1492
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "account is empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1494
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {p2}, Lcom/google/android/gm/provider/Gmail;->getSettingsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 1497
    .local v6, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-static {p1, v6}, Lcom/google/android/gm/provider/Gmail;->getSettings(Landroid/content/Context;Landroid/database/Cursor;)Lcom/google/android/gm/provider/Gmail$Settings;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 1499
    if-eqz v6, :cond_1

    .line 1500
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_1
    return-object v0

    .line 1499
    :catchall_0
    move-exception v0

    if-eqz v6, :cond_2

    .line 1500
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0
.end method

.method public restoreSettings(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$Settings;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "settings"    # Lcom/google/android/gm/provider/Gmail$Settings;

    .prologue
    .line 1590
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1591
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "account is empty"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1593
    :cond_0
    new-instance v1, Lcom/google/android/gm/provider/Gmail$Settings;

    invoke-direct {v1}, Lcom/google/android/gm/provider/Gmail$Settings;-><init>()V

    .line 1594
    .local v1, "newSettings":Lcom/google/android/gm/provider/Gmail$Settings;
    invoke-virtual {p3}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsIncluded()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/google/android/gm/provider/Gmail$Settings;->setLabelsIncluded(Ljava/util/Collection;)V

    .line 1595
    invoke-virtual {p3}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsPartial()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/google/android/gm/provider/Gmail$Settings;->setLabelsPartial(Ljava/util/Collection;)V

    .line 1596
    invoke-virtual {p3}, Lcom/google/android/gm/provider/Gmail$Settings;->getConversationAgeDays()J

    move-result-wide v3

    invoke-virtual {v1, v3, v4}, Lcom/google/android/gm/provider/Gmail$Settings;->setConversationAgeDays(J)V

    .line 1597
    invoke-virtual {p3}, Lcom/google/android/gm/provider/Gmail$Settings;->getMaxAttachmentSizeMb()J

    move-result-wide v3

    invoke-virtual {v1, v3, v4}, Lcom/google/android/gm/provider/Gmail$Settings;->setMaxAttachmentSizeMb(J)V

    .line 1598
    invoke-static {p1, p2}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngine(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    .line 1599
    .local v0, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-direct {p0, v1}, Lcom/google/android/gm/provider/Gmail;->settingsToValues(Lcom/google/android/gm/provider/Gmail$Settings;)Landroid/content/ContentValues;

    move-result-object v2

    .line 1600
    .local v2, "values":Landroid/content/ContentValues;
    invoke-virtual {v2}, Landroid/content/ContentValues;->size()I

    move-result v3

    if-lez v3, :cond_1

    .line 1601
    invoke-virtual {v0, v2}, Lcom/google/android/gm/provider/MailEngine;->setPublicSettings(Landroid/content/ContentValues;)Z

    .line 1603
    :cond_1
    return-void
.end method

.method public setSettings(Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$Settings;)V
    .locals 4
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "settings"    # Lcom/google/android/gm/provider/Gmail$Settings;

    .prologue
    const/4 v3, 0x0

    .line 1546
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1547
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "account is empty"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1549
    :cond_0
    invoke-direct {p0, p2}, Lcom/google/android/gm/provider/Gmail;->settingsToValues(Lcom/google/android/gm/provider/Gmail$Settings;)Landroid/content/ContentValues;

    move-result-object v0

    .line 1551
    .local v0, "values":Landroid/content/ContentValues;
    invoke-virtual {v0}, Landroid/content/ContentValues;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 1553
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->getSettingsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2, v0, v3, v3}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1555
    const-string v1, "Sync settings "

    invoke-static {v1}, Lcom/google/android/gm/persistence/GmailBackupAgent;->dataChanged(Ljava/lang/String;)V

    .line 1557
    :cond_1
    return-void
.end method
