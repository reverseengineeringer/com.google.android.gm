.class public Lcom/google/android/gm/provider/uiprovider/UILabelCursor;
.super Lcom/google/android/gm/provider/uiprovider/UICursorWapper;
.source "UILabelCursor.java"


# static fields
.field private static final ALLOW_MARK_NOT_SPAM_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final ARCHIVABLE_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final DELETE_PROHIBITED_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final DESTRUCTIVE_MUTE_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final HIDDEN_REPORT_PHISHING_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final HIDDEN_REPORT_SPAM_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private mCanonicalName:Ljava/lang/String;

.field private final mCanonicalNameIndex:I

.field private mConversationListUri:Landroid/net/Uri;

.field private final mEngine:Lcom/google/android/gm/provider/MailEngine;

.field private mGmailLabelColor:Ljava/lang/String;

.field private final mGmailLabelColorIndex:I

.field private final mIdColumnIndex:I

.field private final mNameColumnIndex:I

.field private final mNumConversationsIndex:I

.field private final mNumUnreadConversationsIndex:I

.field private final mSynchronizedLabelSet:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mSystemLabelIndex:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 26
    const-string v0, "^i"

    const-string v1, "^iim"

    invoke-static {v0, v1}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->ARCHIVABLE_LABELS:Ljava/util/Set;

    .line 29
    const-string v0, "^k"

    const-string v1, "^r"

    invoke-static {v0, v1}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->DELETE_PROHIBITED_LABELS:Ljava/util/Set;

    .line 32
    const-string v0, "^i"

    const-string v1, "^iim"

    invoke-static {v0, v1}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->DESTRUCTIVE_MUTE_LABELS:Ljava/util/Set;

    .line 35
    const-string v0, "^s"

    invoke-static {v0}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->HIDDEN_REPORT_SPAM_LABELS:Ljava/util/Set;

    .line 39
    sget-object v0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->HIDDEN_REPORT_SPAM_LABELS:Ljava/util/Set;

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->ALLOW_MARK_NOT_SPAM_LABELS:Ljava/util/Set;

    .line 41
    const-string v0, "^s"

    invoke-static {v0}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->HIDDEN_REPORT_PHISHING_LABELS:Ljava/util/Set;

    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "engine"    # Lcom/google/android/gm/provider/MailEngine;
    .param p3, "account"    # Ljava/lang/String;
    .param p4, "resultProjection"    # [Ljava/lang/String;

    .prologue
    .line 65
    invoke-direct {p0, p1, p4}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;-><init>(Landroid/database/Cursor;[Ljava/lang/String;)V

    .line 66
    iput-object p3, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mAccount:Ljava/lang/String;

    .line 67
    iput-object p2, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    .line 68
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->getSynchronizedLabelSet()Ljava/util/Set;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/collect/ImmutableSet;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mSynchronizedLabelSet:Ljava/util/Set;

    .line 71
    const-string v0, "_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mIdColumnIndex:I

    .line 73
    const-string v0, "name"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mNameColumnIndex:I

    .line 74
    const-string v0, "canonicalName"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalNameIndex:I

    .line 75
    const-string v0, "numConversations"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mNumConversationsIndex:I

    .line 76
    const-string v0, "numUnreadConversations"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mNumUnreadConversationsIndex:I

    .line 78
    const-string v0, "systemLabel"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mSystemLabelIndex:I

    .line 79
    const-string v0, "color"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mGmailLabelColorIndex:I

    .line 80
    return-void

    .line 68
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private cachePositionValues()V
    .locals 3

    .prologue
    .line 216
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 217
    iget v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalNameIndex:I

    invoke-super {p0, v1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    .line 219
    iget v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mIdColumnIndex:I

    invoke-super {p0, v1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v0

    .line 221
    .local v0, "labelId":I
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    if-eqz v1, :cond_1

    .line 222
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mAccount:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/google/android/gm/provider/UiProvider;->getLabelConversationListUri(Ljava/lang/String;I)Landroid/net/Uri;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mConversationListUri:Landroid/net/Uri;

    .line 231
    :goto_0
    iget v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mGmailLabelColorIndex:I

    invoke-super {p0, v1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mGmailLabelColor:Ljava/lang/String;

    .line 233
    .end local v0    # "labelId":I
    :cond_0
    return-void

    .line 227
    .restart local v0    # "labelId":I
    :cond_1
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mAccount:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/google/android/gm/provider/UiProvider;->getLabelConversationListFromNameUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mConversationListUri:Landroid/net/Uri;

    goto :goto_0
.end method


# virtual methods
.method public getInt(I)I
    .locals 10
    .param p1, "columnIndex"    # I

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 84
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->cachePositionValues()V

    .line 86
    packed-switch p1, :pswitch_data_0

    .line 153
    :pswitch_0
    const-string v7, "Gmail"

    const-string v8, "UILabelCursor.getInt(%d): Unexpected column"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v5, v6

    invoke-static {v7, v8, v5}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 155
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v6

    :goto_0
    :pswitch_1
    return v6

    .line 89
    :pswitch_2
    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->hashCode()I

    move-result v6

    goto :goto_0

    .line 91
    :pswitch_3
    iget v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mNumUnreadConversationsIndex:I

    invoke-super {p0, v5}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v6

    goto :goto_0

    .line 93
    :pswitch_4
    iget v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mNumConversationsIndex:I

    invoke-super {p0, v5}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v6

    goto :goto_0

    .line 98
    :pswitch_5
    const/16 v0, 0x205

    .line 99
    .local v0, "capabilities":I
    sget-object v5, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->ARCHIVABLE_LABELS:Ljava/util/Set;

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-interface {v5, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 100
    or-int/lit8 v0, v0, 0x10

    .line 102
    :cond_0
    sget-object v5, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->DELETE_PROHIBITED_LABELS:Ljava/util/Set;

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-interface {v5, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 103
    or-int/lit8 v0, v0, 0x20

    .line 105
    :cond_1
    sget-object v5, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->HIDDEN_REPORT_SPAM_LABELS:Ljava/util/Set;

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-interface {v5, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 106
    or-int/lit8 v0, v0, 0x40

    .line 108
    :cond_2
    sget-object v5, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->ALLOW_MARK_NOT_SPAM_LABELS:Ljava/util/Set;

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-interface {v5, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 109
    or-int/lit16 v0, v0, 0x80

    .line 111
    :cond_3
    sget-object v5, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->HIDDEN_REPORT_PHISHING_LABELS:Ljava/util/Set;

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-interface {v5, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 112
    or-int/lit16 v0, v0, 0x2000

    .line 114
    :cond_4
    sget-object v5, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->DESTRUCTIVE_MUTE_LABELS:Ljava/util/Set;

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-interface {v5, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 115
    or-int/lit16 v0, v0, 0x100

    .line 117
    :cond_5
    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-static {v5}, Lcom/google/android/gm/provider/Gmail;->isLabelUserSettable(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 118
    or-int/lit8 v0, v0, 0x8

    .line 120
    :cond_6
    const-string v5, "^im"

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_7

    const-string v5, "^iim"

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 122
    :cond_7
    or-int/lit16 v0, v0, 0x400

    :cond_8
    move v6, v0

    .line 124
    goto/16 :goto_0

    .line 126
    .end local v0    # "capabilities":I
    :pswitch_6
    iget-object v7, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mSynchronizedLabelSet:Ljava/util/Set;

    if-eqz v7, :cond_9

    iget-object v7, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mSynchronizedLabelSet:Ljava/util/Set;

    iget-object v8, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-interface {v7, v8}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_9

    move v1, v5

    .line 128
    .local v1, "labelSynced":Z
    :goto_1
    if-eqz v1, :cond_a

    :goto_2
    move v6, v5

    goto/16 :goto_0

    .end local v1    # "labelSynced":Z
    :cond_9
    move v1, v6

    .line 126
    goto :goto_1

    .restart local v1    # "labelSynced":Z
    :cond_a
    move v5, v6

    .line 128
    goto :goto_2

    .line 131
    .end local v1    # "labelSynced":Z
    :pswitch_7
    const/4 v3, 0x0

    .line 132
    .local v3, "syncStatus":I
    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    if-eqz v5, :cond_d

    .line 133
    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/MailEngine;->isBackgroundSyncInProgress()Z

    move-result v5

    if-eqz v5, :cond_b

    .line 134
    or-int/lit8 v3, v3, 0x4

    .line 136
    :cond_b
    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/MailEngine;->isLiveQueryInProgress()Z

    move-result v5

    if-eqz v5, :cond_c

    .line 137
    or-int/lit8 v3, v3, 0x2

    .line 139
    :cond_c
    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/MailEngine;->isHandlingUserRefresh()Z

    move-result v5

    if-eqz v5, :cond_d

    .line 140
    or-int/lit8 v3, v3, 0x1

    :cond_d
    move v6, v3

    .line 145
    goto/16 :goto_0

    .line 147
    .end local v3    # "syncStatus":I
    :pswitch_8
    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    if-eqz v5, :cond_e

    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/MailEngine;->getLastSyncResult()I

    move-result v2

    .local v2, "status":I
    :goto_3
    move v6, v2

    .line 148
    goto/16 :goto_0

    .end local v2    # "status":I
    :cond_e
    move v2, v6

    .line 147
    goto :goto_3

    .line 150
    :pswitch_9
    iget v7, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mSystemLabelIndex:I

    invoke-super {p0, v7}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v7

    if-eqz v7, :cond_f

    move v4, v5

    .line 151
    .local v4, "systemLabel":Z
    :goto_4
    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/google/android/gm/provider/UiProvider;->getFolderType(ZLjava/lang/String;)I

    move-result v6

    goto/16 :goto_0

    .end local v4    # "systemLabel":Z
    :cond_f
    move v4, v6

    .line 150
    goto :goto_4

    .line 86
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_5
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method public getLong(I)J
    .locals 5
    .param p1, "columnIndex"    # I

    .prologue
    .line 161
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->cachePositionValues()V

    .line 163
    sparse-switch p1, :sswitch_data_0

    .line 170
    const-string v0, "Gmail"

    const-string v1, "UILabelCursor.getLong(%d): Unexpected column"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 171
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v0

    :goto_0
    return-wide v0

    .line 166
    :sswitch_0
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    int-to-long v0, v0

    goto :goto_0

    .line 168
    :sswitch_1
    const-wide/16 v0, 0x0

    goto :goto_0

    .line 163
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0xe -> :sswitch_1
    .end sparse-switch
.end method

.method public getString(I)Ljava/lang/String;
    .locals 7
    .param p1, "columnIndex"    # I

    .prologue
    const/4 v0, 0x0

    .line 177
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->cachePositionValues()V

    .line 179
    packed-switch p1, :pswitch_data_0

    .line 203
    :pswitch_0
    const-string v2, "Gmail"

    const-string v3, "UILabelCursor.getString(%d): Unexpected column"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 205
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    :pswitch_1
    return-object v0

    .line 181
    :pswitch_2
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mAccount:Ljava/lang/String;

    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 183
    :pswitch_3
    iget v2, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mNameColumnIndex:I

    invoke-super {p0, v2}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 185
    :pswitch_4
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mConversationListUri:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 189
    :pswitch_5
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mAccount:Ljava/lang/String;

    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mConversationListUri:Landroid/net/Uri;

    invoke-static {v2, v3}, Lcom/google/android/gm/provider/UiProvider;->getLabelRefreshUri(Ljava/lang/String;Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 191
    :pswitch_6
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mAccount:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mGmailLabelColor:Ljava/lang/String;

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/Label;->getBackgroundColor(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 193
    .local v0, "backgroundColor":Ljava/lang/String;
    goto :goto_0

    .line 195
    .end local v0    # "backgroundColor":Ljava/lang/String;
    :pswitch_7
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mAccount:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mGmailLabelColor:Ljava/lang/String;

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/Label;->getTextColor(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .local v1, "textColor":Ljava/lang/String;
    move-object v0, v1

    .line 197
    goto :goto_0

    .line 179
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_6
        :pswitch_7
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method protected resetCursorRowState()V
    .locals 1

    .prologue
    .line 211
    invoke-super {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->resetCursorRowState()V

    .line 212
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;->mCanonicalName:Ljava/lang/String;

    .line 213
    return-void
.end method
