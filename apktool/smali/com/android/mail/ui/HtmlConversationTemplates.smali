.class public Lcom/android/mail/ui/HtmlConversationTemplates;
.super Ljava/lang/Object;
.source "HtmlConversationTemplates.java"


# static fields
.field public static final MESSAGE_PREFIX_LENGTH:I

.field private static final TAG:Ljava/lang/String;

.field private static final sAbsoluteImgUrlPattern:Ljava/util/regex/Pattern;

.field private static sConversationLower:Ljava/lang/String;

.field private static sConversationUpper:Ljava/lang/String;

.field private static sLoadedTemplates:Z

.field private static sMessage:Ljava/lang/String;

.field private static sSuperCollapsed:Ljava/lang/String;


# instance fields
.field private mBuilder:Ljava/lang/StringBuilder;

.field private mContext:Landroid/content/Context;

.field private mFormatter:Ljava/util/Formatter;

.field private mInProgress:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 51
    const-string v0, "m"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    sput v0, Lcom/android/mail/ui/HtmlConversationTemplates;->MESSAGE_PREFIX_LENGTH:I

    .line 58
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->TAG:Ljava/lang/String;

    .line 83
    const-string v0, "(<\\s*img\\s+(?:[^>]*\\s+)?)src(\\s*=[\\s\'\"]*http)"

    const/16 v1, 0xa

    invoke-static {v0, v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sAbsoluteImgUrlPattern:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 103
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 101
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mInProgress:Z

    .line 104
    iput-object p1, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mContext:Landroid/content/Context;

    .line 108
    sget-boolean v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sLoadedTemplates:Z

    if-nez v0, :cond_0

    .line 109
    const/4 v0, 0x1

    sput-boolean v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sLoadedTemplates:Z

    .line 110
    const v0, 0x7f080004

    invoke-direct {p0, v0}, Lcom/android/mail/ui/HtmlConversationTemplates;->readTemplate(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sSuperCollapsed:Ljava/lang/String;

    .line 111
    const v0, 0x7f080003

    invoke-direct {p0, v0}, Lcom/android/mail/ui/HtmlConversationTemplates;->readTemplate(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sMessage:Ljava/lang/String;

    .line 112
    const v0, 0x7f080002

    invoke-direct {p0, v0}, Lcom/android/mail/ui/HtmlConversationTemplates;->readTemplate(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sConversationUpper:Ljava/lang/String;

    .line 113
    const v0, 0x7f080001

    invoke-direct {p0, v0}, Lcom/android/mail/ui/HtmlConversationTemplates;->readTemplate(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sConversationLower:Ljava/lang/String;

    .line 115
    :cond_0
    return-void
.end method

.method private varargs append(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p1, "template"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 242
    iget-object v0, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mFormatter:Ljava/util/Formatter;

    invoke-virtual {v0, p1, p2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    .line 243
    return-void
.end method

.method private readTemplate(I)Ljava/lang/String;
    .locals 9
    .param p1, "id"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/res/Resources$NotFoundException;
        }
    .end annotation

    .prologue
    .line 215
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 216
    .local v5, "out":Ljava/lang/StringBuilder;
    const/4 v3, 0x0

    .line 219
    .local v3, "in":Ljava/io/InputStreamReader;
    :try_start_0
    new-instance v4, Ljava/io/InputStreamReader;

    iget-object v6, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, p1}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v6

    const-string v7, "UTF-8"

    invoke-direct {v4, v6, v7}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 221
    .end local v3    # "in":Ljava/io/InputStreamReader;
    .local v4, "in":Ljava/io/InputStreamReader;
    const/16 v6, 0x1000

    :try_start_1
    new-array v0, v6, [C

    .line 224
    .local v0, "buf":[C
    :goto_0
    invoke-virtual {v4, v0}, Ljava/io/InputStreamReader;->read([C)I

    move-result v1

    .local v1, "chars":I
    if-lez v1, :cond_1

    .line 225
    const/4 v6, 0x0

    invoke-virtual {v5, v0, v6, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 231
    .end local v0    # "buf":[C
    .end local v1    # "chars":I
    :catchall_0
    move-exception v6

    move-object v3, v4

    .end local v4    # "in":Ljava/io/InputStreamReader;
    .restart local v3    # "in":Ljava/io/InputStreamReader;
    :goto_1
    if-eqz v3, :cond_0

    .line 232
    :try_start_2
    invoke-virtual {v3}, Ljava/io/InputStreamReader;->close()V

    :cond_0
    throw v6
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 235
    :catch_0
    move-exception v2

    .line 236
    .local v2, "e":Ljava/io/IOException;
    :goto_2
    new-instance v6, Landroid/content/res/Resources$NotFoundException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unable to open template id="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {p1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " exception="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Landroid/content/res/Resources$NotFoundException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 228
    .end local v2    # "e":Ljava/io/IOException;
    .end local v3    # "in":Ljava/io/InputStreamReader;
    .restart local v0    # "buf":[C
    .restart local v1    # "chars":I
    .restart local v4    # "in":Ljava/io/InputStreamReader;
    :cond_1
    :try_start_3
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v6

    .line 231
    if-eqz v4, :cond_2

    .line 232
    :try_start_4
    invoke-virtual {v4}, Ljava/io/InputStreamReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    :cond_2
    return-object v6

    .line 235
    :catch_1
    move-exception v2

    move-object v3, v4

    .end local v4    # "in":Ljava/io/InputStreamReader;
    .restart local v3    # "in":Ljava/io/InputStreamReader;
    goto :goto_2

    .line 231
    .end local v0    # "buf":[C
    .end local v1    # "chars":I
    :catchall_1
    move-exception v6

    goto :goto_1
.end method

.method static replaceAbsoluteImgUrls(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "html"    # Ljava/lang/String;

    .prologue
    .line 127
    sget-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sAbsoluteImgUrlPattern:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    const-string v1, "$1src=\'data:\' blocked-src$2"

    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->replaceAll(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public appendMessageHtml(Lcom/android/mail/providers/Message;ZZII)V
    .locals 8
    .param p1, "message"    # Lcom/android/mail/providers/Message;
    .param p2, "isExpanded"    # Z
    .param p3, "safeForImages"    # Z
    .param p4, "headerHeight"    # I
    .param p5, "footerHeight"    # I

    .prologue
    .line 133
    if-eqz p2, :cond_1

    const-string v1, "block"

    .line 134
    .local v1, "bodyDisplay":Ljava/lang/String;
    :goto_0
    if-eqz p2, :cond_2

    const-string v2, "expanded"

    .line 135
    .local v2, "expandedClass":Ljava/lang/String;
    :goto_1
    if-eqz p3, :cond_3

    const-string v3, "mail-show-images"

    .line 137
    .local v3, "showImagesClass":Ljava/lang/String;
    :goto_2
    invoke-virtual {p1}, Lcom/android/mail/providers/Message;->getBodyAsHtml()Ljava/lang/String;

    move-result-object v0

    .line 153
    .local v0, "body":Ljava/lang/String;
    if-nez p3, :cond_0

    iget-boolean v4, p1, Lcom/android/mail/providers/Message;->embedsExternalResources:Z

    if-eqz v4, :cond_0

    .line 154
    invoke-static {v0}, Lcom/android/mail/ui/HtmlConversationTemplates;->replaceAbsoluteImgUrls(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 157
    :cond_0
    sget-object v4, Lcom/android/mail/ui/HtmlConversationTemplates;->sMessage:Ljava/lang/String;

    const/16 v5, 0x8

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {p0, p1}, Lcom/android/mail/ui/HtmlConversationTemplates;->getMessageDomId(Lcom/android/mail/providers/Message;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object v2, v5, v6

    const/4 v6, 0x2

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x3

    aput-object v3, v5, v6

    const/4 v6, 0x4

    aput-object v1, v5, v6

    const/4 v6, 0x5

    aput-object v0, v5, v6

    const/4 v6, 0x6

    aput-object v1, v5, v6

    const/4 v6, 0x7

    invoke-static {p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-direct {p0, v4, v5}, Lcom/android/mail/ui/HtmlConversationTemplates;->append(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 167
    return-void

    .line 133
    .end local v0    # "body":Ljava/lang/String;
    .end local v1    # "bodyDisplay":Ljava/lang/String;
    .end local v2    # "expandedClass":Ljava/lang/String;
    .end local v3    # "showImagesClass":Ljava/lang/String;
    :cond_1
    const-string v1, "none"

    goto :goto_0

    .line 134
    .restart local v1    # "bodyDisplay":Ljava/lang/String;
    :cond_2
    const-string v2, ""

    goto :goto_1

    .line 135
    .restart local v2    # "expandedClass":Ljava/lang/String;
    :cond_3
    const-string v3, ""

    goto :goto_2
.end method

.method public appendSuperCollapsedHtml(II)V
    .locals 4
    .param p1, "firstCollapsed"    # I
    .param p2, "blockHeight"    # I

    .prologue
    .line 118
    iget-boolean v0, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mInProgress:Z

    if-nez v0, :cond_0

    .line 119
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "must call startConversation first"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 122
    :cond_0
    sget-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sSuperCollapsed:Ljava/lang/String;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-direct {p0, v0, v1}, Lcom/android/mail/ui/HtmlConversationTemplates;->append(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 123
    return-void
.end method

.method public emit()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 202
    iget-object v1, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mFormatter:Ljava/util/Formatter;

    invoke-virtual {v1}, Ljava/util/Formatter;->toString()Ljava/lang/String;

    move-result-object v0

    .line 204
    .local v0, "out":Ljava/lang/String;
    iput-object v2, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mFormatter:Ljava/util/Formatter;

    .line 205
    iput-object v2, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mBuilder:Ljava/lang/StringBuilder;

    .line 206
    return-object v0
.end method

.method public endConversation(Ljava/lang/String;Ljava/lang/String;IIZZ)Ljava/lang/String;
    .locals 7
    .param p1, "docBaseUri"    # Ljava/lang/String;
    .param p2, "conversationBaseUri"    # Ljava/lang/String;
    .param p3, "viewWidth"    # I
    .param p4, "viewportWidth"    # I
    .param p5, "enableContentReadySignal"    # Z
    .param p6, "normalizeMessageWidths"    # Z

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 185
    iget-boolean v0, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mInProgress:Z

    if-nez v0, :cond_0

    .line 186
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "must call startConversation first"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 189
    :cond_0
    sget-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sConversationLower:Ljava/lang/String;

    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mContext:Landroid/content/Context;

    const v3, 0x7f0c00ca

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    iget-object v2, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mContext:Landroid/content/Context;

    const v3, 0x7f0c00c9

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v5

    aput-object p1, v1, v6

    const/4 v2, 0x3

    aput-object p2, v1, v2

    const/4 v2, 0x4

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x5

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x6

    invoke-static {p5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x7

    invoke-static {p6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-direct {p0, v0, v1}, Lcom/android/mail/ui/HtmlConversationTemplates;->append(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 193
    iput-boolean v4, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mInProgress:Z

    .line 195
    sget-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->TAG:Ljava/lang/String;

    const-string v1, "rendered conversation of %d bytes, buffer capacity=%d"

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    shl-int/lit8 v3, v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->capacity()I

    move-result v3

    shl-int/lit8 v3, v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 198
    invoke-virtual {p0}, Lcom/android/mail/ui/HtmlConversationTemplates;->emit()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMessageDomId(Lcom/android/mail/providers/Message;)Ljava/lang/String;
    .locals 3
    .param p1, "msg"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 170
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "m"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p1, Lcom/android/mail/providers/Message;->id:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public reset()V
    .locals 3

    .prologue
    .line 210
    new-instance v0, Ljava/lang/StringBuilder;

    const/high16 v1, 0x10000

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    iput-object v0, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mBuilder:Ljava/lang/StringBuilder;

    .line 211
    new-instance v0, Ljava/util/Formatter;

    iget-object v1, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mBuilder:Ljava/lang/StringBuilder;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Ljava/util/Formatter;-><init>(Ljava/lang/Appendable;Ljava/util/Locale;)V

    iput-object v0, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mFormatter:Ljava/util/Formatter;

    .line 212
    return-void
.end method

.method public startConversation(II)V
    .locals 5
    .param p1, "sideMargin"    # I
    .param p2, "conversationHeaderHeight"    # I

    .prologue
    const/4 v4, 0x1

    .line 174
    iget-boolean v0, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mInProgress:Z

    if-eqz v0, :cond_0

    .line 175
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "must call startConversation first"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 178
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/HtmlConversationTemplates;->reset()V

    .line 179
    sget-object v0, Lcom/android/mail/ui/HtmlConversationTemplates;->sConversationUpper:Ljava/lang/String;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-direct {p0, v0, v1}, Lcom/android/mail/ui/HtmlConversationTemplates;->append(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 180
    iput-boolean v4, p0, Lcom/android/mail/ui/HtmlConversationTemplates;->mInProgress:Z

    .line 181
    return-void
.end method
