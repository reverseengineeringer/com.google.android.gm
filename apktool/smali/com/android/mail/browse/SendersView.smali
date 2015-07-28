.class public Lcom/android/mail/browse/SendersView;
.super Ljava/lang/Object;
.source "SendersView.java"


# static fields
.field private static final DOES_NOT_EXIST:Ljava/lang/Integer;

.field private static final PRIORITY_LENGTH_MAP_CACHE:Lcom/android/mail/utils/ObjectCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/android/mail/utils/ObjectCache",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;>;"
        }
    .end annotation
.end field

.field public static SENDERS_VERSION_SEPARATOR:Ljava/lang/String;

.field public static SENDERS_VERSION_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

.field private static sConfigurationChangedReceiver:Landroid/content/BroadcastReceiver;

.field private static sDraftCountFormatString:Ljava/lang/String;

.field private static sDraftPluralString:Ljava/lang/CharSequence;

.field private static sDraftSingularString:Ljava/lang/CharSequence;

.field private static sDraftsStyleSpan:Landroid/text/style/CharacterStyle;

.field public static sElidedString:Ljava/lang/CharSequence;

.field private static sMeString:Ljava/lang/String;

.field private static sMessageCountSpacerString:Ljava/lang/String;

.field private static sMessageInfoStyleSpan:Landroid/text/style/CharacterStyle;

.field private static sReadStyleSpan:Landroid/text/style/CharacterStyle;

.field private static sSendersSplitToken:Ljava/lang/String;

.field private static sSendingString:Ljava/lang/CharSequence;

.field private static sSendingStyleSpan:Landroid/text/style/CharacterStyle;

.field private static sUnreadStyleSpan:Landroid/text/style/CharacterStyle;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 56
    const/4 v0, -0x5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/SendersView;->DOES_NOT_EXIST:Ljava/lang/Integer;

    .line 58
    const-string v0, "^**^"

    sput-object v0, Lcom/android/mail/browse/SendersView;->SENDERS_VERSION_SEPARATOR:Ljava/lang/String;

    .line 59
    const-string v0, "\\^\\*\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/SendersView;->SENDERS_VERSION_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    .line 80
    new-instance v0, Lcom/android/mail/utils/ObjectCache;

    new-instance v1, Lcom/android/mail/browse/SendersView$1;

    invoke-direct {v1}, Lcom/android/mail/browse/SendersView$1;-><init>()V

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lcom/android/mail/utils/ObjectCache;-><init>(Lcom/android/mail/utils/ObjectCache$Callback;I)V

    sput-object v0, Lcom/android/mail/browse/SendersView;->PRIORITY_LENGTH_MAP_CACHE:Lcom/android/mail/utils/ObjectCache;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$002(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .locals 0
    .param p0, "x0"    # Ljava/lang/CharSequence;

    .prologue
    .line 53
    sput-object p0, Lcom/android/mail/browse/SendersView;->sDraftSingularString:Ljava/lang/CharSequence;

    return-object p0
.end method

.method static synthetic access$100(Landroid/content/Context;)V
    .locals 0
    .param p0, "x0"    # Landroid/content/Context;

    .prologue
    .line 53
    invoke-static {p0}, Lcom/android/mail/browse/SendersView;->getSenderResources(Landroid/content/Context;)V

    return-void
.end method

.method public static createMessageInfo(Landroid/content/Context;Lcom/android/mail/providers/Conversation;)Landroid/text/SpannableStringBuilder;
    .locals 17
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 129
    move-object/from16 v0, p1

    iget-object v1, v0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    .line 130
    .local v1, "conversationInfo":Lcom/android/mail/providers/ConversationInfo;
    move-object/from16 v0, p1

    iget v10, v0, Lcom/android/mail/providers/Conversation;->sendingState:I

    .line 131
    .local v10, "sendingStatus":I
    new-instance v8, Landroid/text/SpannableStringBuilder;

    invoke-direct {v8}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 132
    .local v8, "messageInfo":Landroid/text/SpannableStringBuilder;
    const/4 v5, 0x0

    .line 135
    .local v5, "hasSenders":Z
    iget-object v12, v1, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v12}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/mail/providers/MessageInfo;

    .line 136
    .local v7, "m":Lcom/android/mail/providers/MessageInfo;
    iget-object v12, v7, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_0

    .line 137
    const/4 v5, 0x1

    .line 141
    .end local v7    # "m":Lcom/android/mail/providers/MessageInfo;
    :cond_1
    invoke-static/range {p0 .. p0}, Lcom/android/mail/browse/SendersView;->getSenderResources(Landroid/content/Context;)V

    .line 142
    if-eqz v1, :cond_b

    .line 143
    iget v2, v1, Lcom/android/mail/providers/ConversationInfo;->messageCount:I

    .line 144
    .local v2, "count":I
    iget v3, v1, Lcom/android/mail/providers/ConversationInfo;->draftCount:I

    .line 145
    .local v3, "draftCount":I
    const/4 v12, 0x2

    if-ne v10, v12, :cond_c

    const/4 v11, 0x1

    .line 146
    .local v11, "showSending":Z
    :goto_0
    const/4 v12, 0x1

    if-le v2, v12, :cond_2

    .line 147
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v12, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, ""

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v12}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 149
    :cond_2
    sget-object v12, Lcom/android/mail/browse/SendersView;->sMessageInfoStyleSpan:Landroid/text/style/CharacterStyle;

    invoke-static {v12}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v12

    const/4 v13, 0x0

    invoke-virtual {v8}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v14

    const/4 v15, 0x0

    invoke-virtual {v8, v12, v13, v14, v15}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 151
    if-lez v3, :cond_5

    .line 155
    if-nez v5, :cond_3

    const/4 v12, 0x1

    if-le v2, v12, :cond_4

    .line 156
    :cond_3
    sget-object v12, Lcom/android/mail/browse/SendersView;->sSendersSplitToken:Ljava/lang/String;

    invoke-virtual {v8, v12}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 158
    :cond_4
    new-instance v4, Landroid/text/SpannableStringBuilder;

    invoke-direct {v4}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 159
    .local v4, "draftString":Landroid/text/SpannableStringBuilder;
    const/4 v12, 0x1

    if-ne v3, v12, :cond_d

    .line 160
    sget-object v12, Lcom/android/mail/browse/SendersView;->sDraftSingularString:Ljava/lang/CharSequence;

    invoke-virtual {v4, v12}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 165
    :goto_1
    sget-object v12, Lcom/android/mail/browse/SendersView;->sDraftsStyleSpan:Landroid/text/style/CharacterStyle;

    invoke-static {v12}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v12

    const/4 v13, 0x0

    invoke-virtual {v4}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v14

    const/16 v15, 0x21

    invoke-virtual {v4, v12, v13, v14, v15}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 167
    invoke-virtual {v8, v4}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 169
    .end local v4    # "draftString":Landroid/text/SpannableStringBuilder;
    :cond_5
    if-eqz v11, :cond_8

    .line 172
    const/4 v12, 0x1

    if-gt v2, v12, :cond_6

    if-lez v3, :cond_7

    .line 173
    :cond_6
    sget-object v12, Lcom/android/mail/browse/SendersView;->sSendersSplitToken:Ljava/lang/String;

    invoke-virtual {v8, v12}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 175
    :cond_7
    new-instance v9, Landroid/text/SpannableStringBuilder;

    invoke-direct {v9}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 176
    .local v9, "sending":Landroid/text/SpannableStringBuilder;
    sget-object v12, Lcom/android/mail/browse/SendersView;->sSendingString:Ljava/lang/CharSequence;

    invoke-virtual {v9, v12}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 177
    sget-object v12, Lcom/android/mail/browse/SendersView;->sSendingStyleSpan:Landroid/text/style/CharacterStyle;

    const/4 v13, 0x0

    invoke-virtual {v9}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v14

    const/4 v15, 0x0

    invoke-virtual {v9, v12, v13, v14, v15}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 178
    invoke-virtual {v8, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 181
    .end local v9    # "sending":Landroid/text/SpannableStringBuilder;
    :cond_8
    const/4 v12, 0x1

    if-gt v2, v12, :cond_a

    if-lez v3, :cond_9

    if-nez v5, :cond_a

    :cond_9
    if-eqz v11, :cond_b

    .line 182
    :cond_a
    new-instance v12, Landroid/text/SpannableStringBuilder;

    sget-object v13, Lcom/android/mail/browse/SendersView;->sMessageCountSpacerString:Ljava/lang/String;

    invoke-direct {v12, v13}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    invoke-virtual {v12, v8}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v8

    .line 186
    .end local v2    # "count":I
    .end local v3    # "draftCount":I
    .end local v11    # "showSending":Z
    :cond_b
    return-object v8

    .line 145
    .restart local v2    # "count":I
    .restart local v3    # "draftCount":I
    :cond_c
    const/4 v11, 0x0

    goto/16 :goto_0

    .line 162
    .restart local v4    # "draftString":Landroid/text/SpannableStringBuilder;
    .restart local v11    # "showSending":Z
    :cond_d
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v13, Lcom/android/mail/browse/SendersView;->sDraftPluralString:Ljava/lang/CharSequence;

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    sget-object v13, Lcom/android/mail/browse/SendersView;->sDraftCountFormatString:Ljava/lang/String;

    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v16

    aput-object v16, v14, v15

    invoke-static {v13, v14}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_1
.end method

.method public static format(Landroid/content/Context;Lcom/android/mail/providers/ConversationInfo;Ljava/lang/String;ILcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)[Landroid/text/SpannableString;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "conversationInfo"    # Lcom/android/mail/providers/ConversationInfo;
    .param p2, "messageInfo"    # Ljava/lang/String;
    .param p3, "maxChars"    # I
    .param p4, "parser"    # Lcom/google/android/common/html/parser/HtmlParser;
    .param p5, "builder"    # Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    .prologue
    .line 192
    invoke-static {p0}, Lcom/android/mail/browse/SendersView;->getSenderResources(Landroid/content/Context;)V

    .line 193
    invoke-virtual {p2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    move-object v0, p0

    move v1, p3

    move-object v3, p1

    move-object v4, p4

    move-object v5, p5

    invoke-static/range {v0 .. v5}, Lcom/android/mail/browse/SendersView;->handlePriority(Landroid/content/Context;ILjava/lang/String;Lcom/android/mail/providers/ConversationInfo;Lcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Ljava/util/ArrayList;

    move-result-object v6

    .line 195
    .local v6, "displays":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/text/SpannableString;>;"
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [Landroid/text/SpannableString;

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/SpannableString;

    return-object v0
.end method

.method private static formatDefault(Lcom/android/mail/browse/ConversationItemViewModel;Ljava/lang/String;Landroid/content/Context;)V
    .locals 7
    .param p0, "header"    # Lcom/android/mail/browse/ConversationItemViewModel;
    .param p1, "sendersString"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/4 v6, 0x0

    .line 312
    invoke-static {p2}, Lcom/android/mail/browse/SendersView;->getSenderResources(Landroid/content/Context;)V

    .line 314
    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemViewModel;->senderFragments:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    .line 315
    const-string v5, ","

    invoke-static {p1, v5}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 316
    .local v4, "senders":[Ljava/lang/String;
    array-length v5, v4

    new-array v2, v5, [Ljava/lang/String;

    .line 319
    .local v2, "namesOnly":[Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v5, v4

    if-ge v1, v5, :cond_2

    .line 320
    aget-object v5, v4, v1

    invoke-static {v5}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v3

    .line 321
    .local v3, "senderTokens":[Landroid/text/util/Rfc822Token;
    if-eqz v3, :cond_1

    array-length v5, v3

    if-lez v5, :cond_1

    .line 322
    aget-object v5, v3, v6

    invoke-virtual {v5}, Landroid/text/util/Rfc822Token;->getName()Ljava/lang/String;

    move-result-object v0

    .line 323
    .local v0, "display":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 324
    aget-object v5, v3, v6

    invoke-virtual {v5}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v0

    .line 326
    :cond_0
    aput-object v0, v2, v1

    .line 319
    .end local v0    # "display":Ljava/lang/String;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 329
    .end local v3    # "senderTokens":[Landroid/text/util/Rfc822Token;
    :cond_2
    invoke-static {p0, v2}, Lcom/android/mail/browse/SendersView;->generateSenderFragments(Lcom/android/mail/browse/ConversationItemViewModel;[Ljava/lang/String;)V

    .line 330
    return-void
.end method

.method public static formatSenders(Lcom/android/mail/browse/ConversationItemViewModel;Landroid/content/Context;)V
    .locals 1
    .param p0, "header"    # Lcom/android/mail/browse/ConversationItemViewModel;
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 338
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v0, v0, Lcom/android/mail/providers/Conversation;->senders:Ljava/lang/String;

    invoke-static {p0, v0, p1}, Lcom/android/mail/browse/SendersView;->formatDefault(Lcom/android/mail/browse/ConversationItemViewModel;Ljava/lang/String;Landroid/content/Context;)V

    .line 339
    return-void
.end method

.method private static generateSenderFragments(Lcom/android/mail/browse/ConversationItemViewModel;[Ljava/lang/String;)V
    .locals 4
    .param p0, "header"    # Lcom/android/mail/browse/ConversationItemViewModel;
    .param p1, "names"    # [Ljava/lang/String;

    .prologue
    .line 333
    const-string v0, ", "

    invoke-static {v0, p1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersText:Ljava/lang/String;

    .line 334
    const/4 v0, 0x0

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersText:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-static {}, Lcom/android/mail/browse/SendersView;->getReadStyleSpan()Landroid/text/style/CharacterStyle;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/android/mail/browse/ConversationItemViewModel;->addSenderFragment(IILandroid/text/style/CharacterStyle;Z)V

    .line 335
    return-void
.end method

.method static getMe(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 304
    sget-object v0, Lcom/android/mail/browse/SendersView;->sMeString:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 305
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0c009b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/SendersView;->sMeString:Ljava/lang/String;

    .line 307
    :cond_0
    sget-object v0, Lcom/android/mail/browse/SendersView;->sMeString:Ljava/lang/String;

    return-object v0
.end method

.method private static getReadStyleSpan()Landroid/text/style/CharacterStyle;
    .locals 1

    .prologue
    .line 300
    sget-object v0, Lcom/android/mail/browse/SendersView;->sReadStyleSpan:Landroid/text/style/CharacterStyle;

    invoke-static {v0}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v0

    return-object v0
.end method

.method private static getSenderResources(Landroid/content/Context;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const v4, 0x7f110002

    .line 98
    sget-object v1, Lcom/android/mail/browse/SendersView;->sConfigurationChangedReceiver:Landroid/content/BroadcastReceiver;

    if-nez v1, :cond_0

    .line 99
    new-instance v1, Lcom/android/mail/browse/SendersView$2;

    invoke-direct {v1}, Lcom/android/mail/browse/SendersView$2;-><init>()V

    sput-object v1, Lcom/android/mail/browse/SendersView;->sConfigurationChangedReceiver:Landroid/content/BroadcastReceiver;

    .line 106
    sget-object v1, Lcom/android/mail/browse/SendersView;->sConfigurationChangedReceiver:Landroid/content/BroadcastReceiver;

    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "android.intent.action.CONFIGURATION_CHANGED"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 109
    :cond_0
    sget-object v1, Lcom/android/mail/browse/SendersView;->sDraftSingularString:Ljava/lang/CharSequence;

    if-nez v1, :cond_1

    .line 110
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 111
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f0c0100

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/SendersView;->sSendersSplitToken:Ljava/lang/String;

    .line 112
    const v1, 0x7f0c0102

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/SendersView;->sElidedString:Ljava/lang/CharSequence;

    .line 113
    const/4 v1, 0x1

    invoke-virtual {v0, v4, v1}, Landroid/content/res/Resources;->getQuantityText(II)Ljava/lang/CharSequence;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/SendersView;->sDraftSingularString:Ljava/lang/CharSequence;

    .line 114
    const/4 v1, 0x2

    invoke-virtual {v0, v4, v1}, Landroid/content/res/Resources;->getQuantityText(II)Ljava/lang/CharSequence;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/SendersView;->sDraftPluralString:Ljava/lang/CharSequence;

    .line 115
    const v1, 0x7f0c0101

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/SendersView;->sDraftCountFormatString:Ljava/lang/String;

    .line 116
    new-instance v1, Landroid/text/style/TextAppearanceSpan;

    const v2, 0x7f0d0047

    invoke-direct {v1, p0, v2}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    sput-object v1, Lcom/android/mail/browse/SendersView;->sMessageInfoStyleSpan:Landroid/text/style/CharacterStyle;

    .line 118
    new-instance v1, Landroid/text/style/TextAppearanceSpan;

    const v2, 0x7f0d0048

    invoke-direct {v1, p0, v2}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    sput-object v1, Lcom/android/mail/browse/SendersView;->sDraftsStyleSpan:Landroid/text/style/CharacterStyle;

    .line 119
    new-instance v1, Landroid/text/style/TextAppearanceSpan;

    const v2, 0x7f0d004b

    invoke-direct {v1, p0, v2}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    sput-object v1, Lcom/android/mail/browse/SendersView;->sUnreadStyleSpan:Landroid/text/style/CharacterStyle;

    .line 121
    new-instance v1, Landroid/text/style/TextAppearanceSpan;

    const v2, 0x7f0d0049

    invoke-direct {v1, p0, v2}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    sput-object v1, Lcom/android/mail/browse/SendersView;->sSendingStyleSpan:Landroid/text/style/CharacterStyle;

    .line 122
    new-instance v1, Landroid/text/style/TextAppearanceSpan;

    const v2, 0x7f0d004a

    invoke-direct {v1, p0, v2}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    sput-object v1, Lcom/android/mail/browse/SendersView;->sReadStyleSpan:Landroid/text/style/CharacterStyle;

    .line 123
    const v1, 0x7f0c0104

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/SendersView;->sMessageCountSpacerString:Ljava/lang/String;

    .line 124
    const v1, 0x7f0c0099

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/SendersView;->sSendingString:Ljava/lang/CharSequence;

    .line 126
    .end local v0    # "res":Landroid/content/res/Resources;
    :cond_1
    return-void
.end method

.method public static getTypeface(Z)Landroid/graphics/Typeface;
    .locals 1
    .param p0, "isUnread"    # Z

    .prologue
    .line 94
    if-eqz p0, :cond_0

    sget-object v0, Landroid/graphics/Typeface;->DEFAULT_BOLD:Landroid/graphics/Typeface;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    goto :goto_0
.end method

.method private static getUnreadStyleSpan()Landroid/text/style/CharacterStyle;
    .locals 1

    .prologue
    .line 296
    sget-object v0, Lcom/android/mail/browse/SendersView;->sUnreadStyleSpan:Landroid/text/style/CharacterStyle;

    invoke-static {v0}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v0

    return-object v0
.end method

.method public static handlePriority(Landroid/content/Context;ILjava/lang/String;Lcom/android/mail/providers/ConversationInfo;Lcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Ljava/util/ArrayList;
    .locals 26
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "maxChars"    # I
    .param p2, "messageInfoString"    # Ljava/lang/String;
    .param p3, "conversationInfo"    # Lcom/android/mail/providers/ConversationInfo;
    .param p4, "parser"    # Lcom/google/android/common/html/parser/HtmlParser;
    .param p5, "builder"    # Lcom/google/android/common/html/parser/HtmlTreeBuilder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/ConversationInfo;",
            "Lcom/google/android/common/html/parser/HtmlParser;",
            "Lcom/google/android/common/html/parser/HtmlTreeBuilder;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/text/SpannableString;",
            ">;"
        }
    .end annotation

    .prologue
    .line 201
    const/4 v11, -0x1

    .line 202
    .local v11, "maxPriorityToInclude":I
    invoke-virtual/range {p2 .. p2}, Ljava/lang/String;->length()I

    move-result v14

    .line 204
    .local v14, "numCharsUsed":I
    const/4 v15, 0x0

    .line 205
    .local v15, "numSendersUsed":I
    const/4 v13, 0x0

    .line 206
    .local v13, "numCharsToRemovePerWord":I
    const/4 v10, 0x0

    .line 207
    .local v10, "maxFoundPriority":I
    move/from16 v0, p1

    if-le v14, v0, :cond_0

    .line 208
    sub-int v13, v14, p1

    .line 211
    :cond_0
    sget-object v23, Lcom/android/mail/browse/SendersView;->PRIORITY_LENGTH_MAP_CACHE:Lcom/android/mail/utils/ObjectCache;

    invoke-virtual/range {v23 .. v23}, Lcom/android/mail/utils/ObjectCache;->get()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/util/Map;

    .line 213
    .local v18, "priorityToLength":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    :try_start_0
    invoke-interface/range {v18 .. v18}, Ljava/util/Map;->clear()V

    .line 215
    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_4

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/android/mail/providers/MessageInfo;

    .line 216
    .local v8, "info":Lcom/android/mail/providers/MessageInfo;
    iget-object v0, v8, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-static/range {v23 .. v23}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v23

    if-nez v23, :cond_1

    iget-object v0, v8, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->length()I

    move-result v19

    .line 217
    .local v19, "senderLength":I
    :goto_1
    iget v0, v8, Lcom/android/mail/providers/MessageInfo;->priority:I

    move/from16 v23, v0

    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v23

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v24

    move-object/from16 v0, v18

    move-object/from16 v1, v23

    move-object/from16 v2, v24

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 218
    iget v0, v8, Lcom/android/mail/providers/MessageInfo;->priority:I

    move/from16 v23, v0

    move/from16 v0, v23

    invoke-static {v10, v0}, Ljava/lang/Math;->max(II)I

    move-result v10

    goto :goto_0

    .line 216
    .end local v19    # "senderLength":I
    :cond_1
    const/16 v19, 0x0

    goto :goto_1

    .line 231
    .end local v8    # "info":Lcom/android/mail/providers/MessageInfo;
    .local v9, "length":I
    :cond_2
    move v14, v9

    .line 232
    add-int/lit8 v15, v15, 0x1

    .line 234
    .end local v9    # "length":I
    :cond_3
    add-int/lit8 v11, v11, 0x1

    .line 220
    :cond_4
    if-ge v11, v10, :cond_6

    .line 221
    add-int/lit8 v23, v11, 0x1

    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v23

    move-object/from16 v0, v18

    move-object/from16 v1, v23

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_3

    .line 222
    add-int/lit8 v23, v11, 0x1

    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v23

    move-object/from16 v0, v18

    move-object/from16 v1, v23

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Ljava/lang/Integer;

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v23

    add-int v9, v14, v23

    .line 223
    .restart local v9    # "length":I
    if-lez v14, :cond_5

    .line 224
    add-int/lit8 v9, v9, 0x2

    .line 228
    :cond_5
    move/from16 v0, p1

    if-le v9, v0, :cond_2

    const/16 v23, 0x2

    move/from16 v0, v23

    if-lt v15, v0, :cond_2

    .line 237
    .end local v9    # "length":I
    :cond_6
    sget-object v23, Lcom/android/mail/browse/SendersView;->PRIORITY_LENGTH_MAP_CACHE:Lcom/android/mail/utils/ObjectCache;

    move-object/from16 v0, v23

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/android/mail/utils/ObjectCache;->release(Ljava/lang/Object;)V

    .line 243
    new-instance v20, Ljava/util/ArrayList;

    invoke-direct/range {v20 .. v20}, Ljava/util/ArrayList;-><init>()V

    .line 247
    .local v20, "senders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/text/SpannableString;>;"
    const/4 v3, 0x0

    .line 248
    .local v3, "appendedElided":Z
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v5

    .line 249
    .local v5, "displayHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_2
    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/util/ArrayList;->size()I

    move-result v23

    move/from16 v0, v23

    if-ge v6, v0, :cond_10

    .line 250
    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/mail/providers/MessageInfo;

    .line 251
    .local v4, "currentMessage":Lcom/android/mail/providers/MessageInfo;
    iget-object v0, v4, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-static/range {v23 .. v23}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v23

    if-nez v23, :cond_b

    iget-object v12, v4, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    .line 252
    .local v12, "nameString":Ljava/lang/String;
    :goto_3
    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v23

    if-nez v23, :cond_c

    .line 253
    invoke-static/range {p0 .. p0}, Lcom/android/mail/browse/SendersView;->getMe(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v12

    .line 257
    :goto_4
    if-eqz v13, :cond_7

    .line 258
    const/16 v23, 0x0

    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v24

    sub-int v24, v24, v13

    const/16 v25, 0x0

    invoke-static/range {v24 .. v25}, Ljava/lang/Math;->max(II)I

    move-result v24

    move/from16 v0, v23

    move/from16 v1, v24

    invoke-virtual {v12, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v12

    .line 261
    :cond_7
    iget v0, v4, Lcom/android/mail/providers/MessageInfo;->priority:I

    move/from16 v17, v0

    .line 262
    .local v17, "priority":I
    iget-boolean v0, v4, Lcom/android/mail/providers/MessageInfo;->read:Z

    move/from16 v23, v0

    if-nez v23, :cond_d

    invoke-static {}, Lcom/android/mail/browse/SendersView;->getUnreadStyleSpan()Landroid/text/style/CharacterStyle;

    move-result-object v22

    .line 263
    .local v22, "style":Landroid/text/style/CharacterStyle;
    :goto_5
    move/from16 v0, v17

    if-gt v0, v11, :cond_f

    .line 264
    new-instance v21, Landroid/text/SpannableString;

    move-object/from16 v0, v21

    invoke-direct {v0, v12}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 267
    .local v21, "spannableDisplay":Landroid/text/SpannableString;
    iget-object v0, v4, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-interface {v5, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_e

    iget-object v0, v4, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-interface {v5, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Ljava/lang/Integer;

    :goto_6
    invoke-virtual/range {v23 .. v23}, Ljava/lang/Integer;->intValue()I

    move-result v16

    .line 271
    .local v16, "oldPos":I
    sget-object v23, Lcom/android/mail/browse/SendersView;->DOES_NOT_EXIST:Ljava/lang/Integer;

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Integer;->intValue()I

    move-result v23

    move/from16 v0, v16

    move/from16 v1, v23

    if-eq v0, v1, :cond_8

    iget-boolean v0, v4, Lcom/android/mail/providers/MessageInfo;->read:Z

    move/from16 v23, v0

    if-nez v23, :cond_a

    .line 274
    :cond_8
    sget-object v23, Lcom/android/mail/browse/SendersView;->DOES_NOT_EXIST:Ljava/lang/Integer;

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Integer;->intValue()I

    move-result v23

    move/from16 v0, v16

    move/from16 v1, v23

    if-eq v0, v1, :cond_9

    if-lez v6, :cond_9

    add-int/lit8 v23, v6, -0x1

    move/from16 v0, v16

    move/from16 v1, v23

    if-ne v0, v1, :cond_9

    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->size()I

    move-result v23

    move/from16 v0, v16

    move/from16 v1, v23

    if-ge v0, v1, :cond_9

    .line 277
    const/16 v23, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v16

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 279
    :cond_9
    iget-object v0, v4, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v24

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-interface {v5, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    const/16 v23, 0x0

    invoke-virtual/range {v21 .. v21}, Landroid/text/SpannableString;->length()I

    move-result v24

    const/16 v25, 0x0

    invoke-virtual/range {v21 .. v25}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 281
    invoke-virtual/range {v20 .. v21}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 249
    .end local v16    # "oldPos":I
    .end local v21    # "spannableDisplay":Landroid/text/SpannableString;
    :cond_a
    :goto_7
    add-int/lit8 v6, v6, 0x1

    goto/16 :goto_2

    .line 237
    .end local v3    # "appendedElided":Z
    .end local v4    # "currentMessage":Lcom/android/mail/providers/MessageInfo;
    .end local v5    # "displayHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    .end local v6    # "i":I
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v12    # "nameString":Ljava/lang/String;
    .end local v17    # "priority":I
    .end local v20    # "senders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/text/SpannableString;>;"
    .end local v22    # "style":Landroid/text/style/CharacterStyle;
    :catchall_0
    move-exception v23

    sget-object v24, Lcom/android/mail/browse/SendersView;->PRIORITY_LENGTH_MAP_CACHE:Lcom/android/mail/utils/ObjectCache;

    move-object/from16 v0, v24

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/android/mail/utils/ObjectCache;->release(Ljava/lang/Object;)V

    throw v23

    .line 251
    .restart local v3    # "appendedElided":Z
    .restart local v4    # "currentMessage":Lcom/android/mail/providers/MessageInfo;
    .restart local v5    # "displayHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    .restart local v6    # "i":I
    .restart local v7    # "i$":Ljava/util/Iterator;
    .restart local v20    # "senders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/text/SpannableString;>;"
    :cond_b
    const-string v12, ""

    goto/16 :goto_3

    .line 255
    .restart local v12    # "nameString":Ljava/lang/String;
    :cond_c
    move-object/from16 v0, p4

    move-object/from16 v1, p5

    invoke-static {v12, v0, v1}, Lcom/android/mail/utils/Utils;->convertHtmlToPlainText(Ljava/lang/String;Lcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Ljava/lang/String;

    move-result-object v12

    goto/16 :goto_4

    .line 262
    .restart local v17    # "priority":I
    :cond_d
    invoke-static {}, Lcom/android/mail/browse/SendersView;->getReadStyleSpan()Landroid/text/style/CharacterStyle;

    move-result-object v22

    goto/16 :goto_5

    .line 267
    .restart local v21    # "spannableDisplay":Landroid/text/SpannableString;
    .restart local v22    # "style":Landroid/text/style/CharacterStyle;
    :cond_e
    sget-object v23, Lcom/android/mail/browse/SendersView;->DOES_NOT_EXIST:Ljava/lang/Integer;

    goto/16 :goto_6

    .line 284
    .end local v21    # "spannableDisplay":Landroid/text/SpannableString;
    :cond_f
    if-nez v3, :cond_a

    .line 285
    new-instance v21, Landroid/text/SpannableString;

    sget-object v23, Lcom/android/mail/browse/SendersView;->sElidedString:Ljava/lang/CharSequence;

    move-object/from16 v0, v21

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 286
    .restart local v21    # "spannableDisplay":Landroid/text/SpannableString;
    const/16 v23, 0x0

    invoke-virtual/range {v21 .. v21}, Landroid/text/SpannableString;->length()I

    move-result v24

    const/16 v25, 0x0

    invoke-virtual/range {v21 .. v25}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 287
    const/4 v3, 0x1

    .line 288
    invoke-virtual/range {v20 .. v21}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_7

    .line 292
    .end local v4    # "currentMessage":Lcom/android/mail/providers/MessageInfo;
    .end local v12    # "nameString":Ljava/lang/String;
    .end local v17    # "priority":I
    .end local v21    # "spannableDisplay":Landroid/text/SpannableString;
    .end local v22    # "style":Landroid/text/style/CharacterStyle;
    :cond_10
    return-object v20
.end method
