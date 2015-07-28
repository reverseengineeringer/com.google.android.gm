.class public Lcom/android/mail/utils/Utils;
.super Ljava/lang/Object;
.source "Utils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/utils/Utils$MarkConversationCursorVisibleTask;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z

.field private static final LOG_TAG:Ljava/lang/String;

.field public static final SENDER_LIST_SEPARATOR:Ljava/lang/Character;

.field private static sDefaultFolderBackgroundColor:I

.field private static sMaxUnreadCount:I

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

.field private static sUnreadStyleSpan:Landroid/text/style/CharacterStyle;

.field private static sUnreadText:Ljava/lang/String;

.field private static sUseFolderListFragmentTransition:I

.field private static sVersionCode:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, -0x1

    .line 68
    const-class v0, Lcom/android/mail/utils/Utils;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/android/mail/utils/Utils;->$assertionsDisabled:Z

    .line 73
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lcom/android/mail/utils/Utils;->sPriorityToLength:Ljava/util/Map;

    .line 80
    const/16 v0, 0xa

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    sput-object v0, Lcom/android/mail/utils/Utils;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    .line 81
    new-instance v0, Landroid/text/TextUtils$SimpleStringSplitter;

    sget-object v1, Lcom/android/mail/utils/Utils;->SENDER_LIST_SEPARATOR:Ljava/lang/Character;

    invoke-virtual {v1}, Ljava/lang/Character;->charValue()C

    move-result v1

    invoke-direct {v0, v1}, Landroid/text/TextUtils$SimpleStringSplitter;-><init>(C)V

    sput-object v0, Lcom/android/mail/utils/Utils;->sSenderListSplitter:Landroid/text/TextUtils$SimpleStringSplitter;

    .line 83
    const/16 v0, 0x8

    new-array v0, v0, [Ljava/lang/String;

    sput-object v0, Lcom/android/mail/utils/Utils;->sSenderFragments:[Ljava/lang/String;

    .line 108
    sput-object v3, Lcom/android/mail/utils/Utils;->sVersionCode:Ljava/lang/String;

    .line 110
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/utils/Utils;->LOG_TAG:Ljava/lang/String;

    .line 187
    sput-object v3, Lcom/android/mail/utils/Utils;->sUnreadStyleSpan:Landroid/text/style/CharacterStyle;

    .line 196
    sput v2, Lcom/android/mail/utils/Utils;->sMaxUnreadCount:I

    .line 198
    sput v2, Lcom/android/mail/utils/Utils;->sDefaultFolderBackgroundColor:I

    .line 199
    sput v2, Lcom/android/mail/utils/Utils;->sUseFolderListFragmentTransition:I

    return-void

    .line 68
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 68
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1035
    return-void
.end method

.method static synthetic access$000(Landroid/database/Cursor;Landroid/os/Bundle;Ljava/lang/String;)Z
    .locals 1
    .param p0, "x0"    # Landroid/database/Cursor;
    .param p1, "x1"    # Landroid/os/Bundle;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-static {p0, p1, p2}, Lcom/android/mail/utils/Utils;->executeConversationCursorCommand(Landroid/database/Cursor;Landroid/os/Bundle;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static addParamsToUrl(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 739
    invoke-static {p1}, Lcom/android/mail/utils/Utils;->replaceLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 740
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 741
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-static {p0}, Lcom/android/mail/utils/Utils;->getVersionCode(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 742
    .local v1, "versionCode":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 743
    const-string v2, "version"

    invoke-virtual {v0, v2, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 746
    :cond_0
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    return-object v2
.end method

.method public static checkRequestLayout(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1185
    .line 1186
    invoke-virtual {p0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v0

    .line 1188
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Landroid/view/View;->isLayoutRequested()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1204
    :cond_0
    :goto_0
    return-void

    .line 1192
    :cond_1
    new-instance v3, Ljava/lang/Error;

    invoke-direct {v3}, Ljava/lang/Error;-><init>()V

    .line 1193
    invoke-virtual {v3}, Ljava/lang/Error;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v4

    array-length v5, v4

    move v0, v2

    :goto_1
    if-ge v0, v5, :cond_3

    aget-object v6, v4, v0

    .line 1194
    const-string v7, "android.view.ViewGroup"

    invoke-virtual {v6}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    const-string v7, "layout"

    invoke-virtual {v6}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v7, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    move v0, v1

    .line 1200
    :goto_2
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Landroid/view/View;->isLayoutRequested()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1201
    const-string v0, "MailBlankFragment"

    const-string v4, "WARNING: in requestLayout during layout pass, view=%s"

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p0, v1, v2

    invoke-static {v0, v3, v4, v1}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 1193
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_3
    move v0, v2

    goto :goto_2
.end method

.method public static cleanUpString(Ljava/lang/String;Z)Ljava/lang/Object;
    .locals 2
    .param p0, "string"    # Ljava/lang/String;
    .param p1, "removeEmptyDoubleQuotes"    # Z

    .prologue
    .line 593
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    if-eqz p1, :cond_0

    const-string v0, "\"\""

    const-string v1, ""

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .end local p0    # "string":Ljava/lang/String;
    :cond_0
    invoke-static {p0}, Landroid/text/TextUtils;->htmlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    .restart local p0    # "string":Ljava/lang/String;
    :cond_1
    const-string v0, ""

    goto :goto_0
.end method

.method public static convertHtmlToPlainText(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "htmlText"    # Ljava/lang/String;

    .prologue
    .line 539
    new-instance v0, Lcom/google/android/common/html/parser/HtmlParser;

    invoke-direct {v0}, Lcom/google/android/common/html/parser/HtmlParser;-><init>()V

    new-instance v1, Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    invoke-direct {v1}, Lcom/google/android/common/html/parser/HtmlTreeBuilder;-><init>()V

    invoke-static {p0, v0, v1}, Lcom/android/mail/utils/Utils;->getHtmlTree(Ljava/lang/String;Lcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Lcom/google/android/common/html/parser/HtmlTree;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/common/html/parser/HtmlTree;->getPlainText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static convertHtmlToPlainText(Ljava/lang/String;Lcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Ljava/lang/String;
    .locals 1
    .param p0, "htmlText"    # Ljava/lang/String;
    .param p1, "parser"    # Lcom/google/android/common/html/parser/HtmlParser;
    .param p2, "builder"    # Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    .prologue
    .line 544
    invoke-static {p0, p1, p2}, Lcom/android/mail/utils/Utils;->getHtmlTree(Ljava/lang/String;Lcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Lcom/google/android/common/html/parser/HtmlTree;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/common/html/parser/HtmlTree;->getPlainText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static createViewConversationIntent(Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)Landroid/content/Intent;
    .locals 3
    .param p0, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 640
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 641
    .local v0, "intent":Landroid/content/Intent;
    const v1, 0x1000c000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 643
    iget-object v1, p0, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    iget-object v2, p2, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 644
    const-string v1, "account"

    invoke-virtual {p2}, Lcom/android/mail/providers/Account;->serialize()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 645
    const-string v1, "folder"

    invoke-static {p1}, Lcom/android/mail/providers/Folder;->toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 646
    const-string v1, "conversationUri"

    invoke-virtual {v0, v1, p0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 647
    return-object v0
.end method

.method public static createViewFolderIntent(Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)Landroid/content/Intent;
    .locals 5
    .param p0, "folder"    # Lcom/android/mail/providers/Folder;
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 658
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 659
    :cond_0
    sget-object v1, Lcom/android/mail/utils/Utils;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Utils.createViewFolderIntent(%s,%s): Bad input"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 661
    const/4 v0, 0x0

    .line 669
    :goto_0
    return-object v0

    .line 663
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 664
    .local v0, "intent":Landroid/content/Intent;
    const v1, 0x1000c000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 666
    iget-object v1, p0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v2, p1, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 667
    const-string v1, "account"

    invoke-virtual {p1}, Lcom/android/mail/providers/Account;->serialize()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 668
    const-string v1, "folder"

    invoke-static {p0}, Lcom/android/mail/providers/Folder;->toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method

.method public static createViewInboxIntent(Lcom/android/mail/providers/Account;)Landroid/content/Intent;
    .locals 5
    .param p0, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 679
    if-nez p0, :cond_0

    .line 680
    sget-object v1, Lcom/android/mail/utils/Utils;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Utils.createViewInboxIntent(%s): Bad input"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 681
    const/4 v0, 0x0

    .line 688
    :goto_0
    return-object v0

    .line 683
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 684
    .local v0, "intent":Landroid/content/Intent;
    const v1, 0x1000c000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 686
    iget-object v1, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v1, v1, Lcom/android/mail/providers/Settings;->defaultInbox:Landroid/net/Uri;

    iget-object v2, p0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 687
    const-string v1, "account"

    invoke-virtual {p0}, Lcom/android/mail/providers/Account;->serialize()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method

.method public static disableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z
    .locals 4
    .param p0, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 997
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 998
    .local v1, "request":Landroid/os/Bundle;
    const-string v0, "allowNetwork"

    .line 999
    .local v0, "key":Ljava/lang/String;
    const-string v2, "allowNetwork"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1000
    const-string v2, "allowNetwork"

    invoke-static {p0, v1, v2}, Lcom/android/mail/utils/Utils;->executeConversationCursorCommand(Landroid/database/Cursor;Landroid/os/Bundle;Ljava/lang/String;)Z

    move-result v2

    return v2
.end method

.method public static ellipsize(Ljava/lang/String;I)Ljava/lang/String;
    .locals 6
    .param p0, "text"    # Ljava/lang/String;
    .param p1, "maxCharacters"    # I

    .prologue
    .line 147
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 148
    .local v2, "length":I
    if-ge v2, p1, :cond_0

    .line 164
    .end local p0    # "text":Ljava/lang/String;
    :goto_0
    return-object p0

    .line 151
    .restart local p0    # "text":Ljava/lang/String;
    :cond_0
    invoke-static {p1, v2}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 153
    .local v3, "realMax":I
    const-string v4, "."

    invoke-virtual {p0, v4}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v1

    .line 154
    .local v1, "index":I
    const-string v0, "\u2026"

    .line 155
    .local v0, "extension":Ljava/lang/String;
    if-ltz v1, :cond_1

    .line 157
    sub-int v4, v2, v1

    const/4 v5, 0x5

    if-gt v4, v5, :cond_1

    .line 158
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    add-int/lit8 v5, v1, 0x1

    invoke-virtual {p0, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 161
    :cond_1
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    sub-int/2addr v3, v4

    .line 162
    if-gez v3, :cond_2

    .line 163
    const/4 v3, 0x0

    .line 164
    :cond_2
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v5, 0x0

    invoke-virtual {p0, v5, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method public static enableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z
    .locals 4
    .param p0, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 1011
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 1012
    .local v1, "request":Landroid/os/Bundle;
    const-string v0, "allowNetwork"

    .line 1013
    .local v0, "key":Ljava/lang/String;
    const-string v2, "allowNetwork"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1014
    const-string v2, "allowNetwork"

    invoke-static {p0, v1, v2}, Lcom/android/mail/utils/Utils;->executeConversationCursorCommand(Landroid/database/Cursor;Landroid/os/Bundle;Ljava/lang/String;)Z

    move-result v2

    return v2
.end method

.method public static enableHardwareLayer(Landroid/view/View;)V
    .locals 2
    .param p0, "v"    # Landroid/view/View;

    .prologue
    .line 1093
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Landroid/view/View;->isHardwareAccelerated()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1094
    const/4 v0, 0x2

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 1095
    invoke-virtual {p0}, Landroid/view/View;->buildLayer()V

    .line 1097
    :cond_0
    return-void
.end method

.method public static ensureQuotedString(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 176
    if-nez p0, :cond_1

    .line 177
    const/4 p0, 0x0

    .line 182
    .end local p0    # "s":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .line 179
    .restart local p0    # "s":Ljava/lang/String;
    :cond_1
    const-string v0, "^\".*\"$"

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 180
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method private static executeConversationCursorCommand(Landroid/database/Cursor;Landroid/os/Bundle;Ljava/lang/String;)Z
    .locals 3
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "request"    # Landroid/os/Bundle;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 982
    invoke-interface {p0, p1}, Landroid/database/Cursor;->respond(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    .line 983
    .local v0, "response":Landroid/os/Bundle;
    const-string v2, "failed"

    invoke-virtual {v0, p2, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 986
    .local v1, "result":Ljava/lang/String;
    const-string v2, "ok"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    return v2
.end method

.method public static fixSubTreeLayoutIfOrphaned(Landroid/view/View;Ljava/lang/String;)V
    .locals 1
    .param p0, "v"    # Landroid/view/View;
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 1116
    invoke-static {p0}, Lcom/android/mail/utils/Utils;->isLayoutSubTreeOrphaned(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1117
    invoke-static {p1, p0}, Lcom/android/mail/utils/Utils;->markDirtyTillRoot(Ljava/lang/String;Landroid/view/View;)V

    .line 1119
    :cond_0
    return-void
.end method

.method public static formatPlural(Landroid/content/Context;II)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resource"    # I
    .param p2, "count"    # I

    .prologue
    .line 136
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Landroid/content/res/Resources;->getQuantityText(II)Ljava/lang/CharSequence;

    move-result-object v0

    .line 137
    .local v0, "formatString":Ljava/lang/CharSequence;
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getConversationId(Lcom/android/mail/browse/ConversationCursor;)J
    .locals 2
    .param p0, "cursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 1078
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationCursor;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public static getDefaultFolderBackgroundColor(Landroid/content/Context;)I
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1108
    sget v0, Lcom/android/mail/utils/Utils;->sDefaultFolderBackgroundColor:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 1109
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090013

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    sput v0, Lcom/android/mail/utils/Utils;->sDefaultFolderBackgroundColor:I

    .line 1112
    :cond_0
    sget v0, Lcom/android/mail/utils/Utils;->sDefaultFolderBackgroundColor:I

    return v0
.end method

.method public static getFileExtension(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "filename"    # Ljava/lang/String;

    .prologue
    .line 857
    const/4 v0, 0x0

    .line 858
    .local v0, "extension":Ljava/lang/String;
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    const/16 v2, 0x2e

    invoke-virtual {p0, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    .line 860
    .local v1, "index":I
    :goto_0
    if-ltz v1, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    sub-int/2addr v2, v1

    const/4 v3, 0x5

    if-gt v2, v3, :cond_0

    .line 861
    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 863
    :cond_0
    return-object v0

    .line 858
    .end local v1    # "index":I
    :cond_1
    const/4 v1, -0x1

    goto :goto_0
.end method

.method public static getFolderUnreadDisplayCount(Lcom/android/mail/providers/Folder;)I
    .locals 2
    .param p0, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 1129
    if-eqz p0, :cond_0

    .line 1130
    iget v1, p0, Lcom/android/mail/providers/Folder;->type:I

    packed-switch v1, :pswitch_data_0

    .line 1137
    :pswitch_0
    iget v0, p0, Lcom/android/mail/providers/Folder;->unreadCount:I

    .line 1143
    .local v0, "count":I
    :goto_0
    return v0

    .line 1134
    .end local v0    # "count":I
    :pswitch_1
    iget v0, p0, Lcom/android/mail/providers/Folder;->totalCount:I

    .line 1135
    .restart local v0    # "count":I
    goto :goto_0

    .line 1141
    .end local v0    # "count":I
    :cond_0
    const/4 v0, 0x0

    .restart local v0    # "count":I
    goto :goto_0

    .line 1130
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static getHtmlTree(Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlTree;
    .locals 2
    .param p0, "htmlText"    # Ljava/lang/String;

    .prologue
    .line 551
    new-instance v0, Lcom/google/android/common/html/parser/HtmlParser;

    invoke-direct {v0}, Lcom/google/android/common/html/parser/HtmlParser;-><init>()V

    new-instance v1, Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    invoke-direct {v1}, Lcom/google/android/common/html/parser/HtmlTreeBuilder;-><init>()V

    invoke-static {p0, v0, v1}, Lcom/android/mail/utils/Utils;->getHtmlTree(Ljava/lang/String;Lcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Lcom/google/android/common/html/parser/HtmlTree;

    move-result-object v0

    return-object v0
.end method

.method public static getHtmlTree(Ljava/lang/String;Lcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Lcom/google/android/common/html/parser/HtmlTree;
    .locals 2
    .param p0, "htmlText"    # Ljava/lang/String;
    .param p1, "parser"    # Lcom/google/android/common/html/parser/HtmlParser;
    .param p2, "builder"    # Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    .prologue
    .line 559
    invoke-virtual {p1, p0}, Lcom/google/android/common/html/parser/HtmlParser;->parse(Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument;

    move-result-object v0

    .line 560
    .local v0, "doc":Lcom/google/android/common/html/parser/HtmlDocument;
    invoke-virtual {v0, p2}, Lcom/google/android/common/html/parser/HtmlDocument;->accept(Lcom/google/android/common/html/parser/HtmlDocument$Visitor;)V

    .line 562
    invoke-virtual {p2}, Lcom/google/android/common/html/parser/HtmlTreeBuilder;->getTree()Lcom/google/android/common/html/parser/HtmlTree;

    move-result-object v1

    return-object v1
.end method

.method public static getSyncStatusText(Landroid/content/Context;I)Ljava/lang/CharSequence;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packedStatus"    # I

    .prologue
    .line 623
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0e0007

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    .line 624
    .local v0, "errors":[Ljava/lang/String;
    and-int/lit8 v1, p1, 0xf

    .line 625
    .local v1, "status":I
    array-length v2, v0

    if-lt v1, v2, :cond_0

    .line 626
    const-string v2, ""

    .line 628
    :goto_0
    return-object v2

    :cond_0
    aget-object v2, v0, v1

    goto :goto_0
.end method

.method public static getTransparentColor(I)I
    .locals 1
    .param p0, "color"    # I

    .prologue
    .line 945
    const v0, 0xffffff

    and-int/2addr v0, p0

    return v0
.end method

.method public static getUnreadCountString(Landroid/content/Context;I)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "unreadCount"    # I

    .prologue
    .line 602
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 603
    .local v0, "resources":Landroid/content/res/Resources;
    sget v2, Lcom/android/mail/utils/Utils;->sMaxUnreadCount:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 604
    const v2, 0x7f0a001c

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v2

    sput v2, Lcom/android/mail/utils/Utils;->sMaxUnreadCount:I

    .line 606
    :cond_0
    sget v2, Lcom/android/mail/utils/Utils;->sMaxUnreadCount:I

    if-le p1, v2, :cond_2

    .line 607
    sget-object v2, Lcom/android/mail/utils/Utils;->sUnreadText:Ljava/lang/String;

    if-nez v2, :cond_1

    .line 608
    const v2, 0x7f0c00d9

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/android/mail/utils/Utils;->sUnreadText:Ljava/lang/String;

    .line 610
    :cond_1
    sget-object v2, Lcom/android/mail/utils/Utils;->sUnreadText:Ljava/lang/String;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    sget v5, Lcom/android/mail/utils/Utils;->sMaxUnreadCount:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 616
    .local v1, "unreadCountString":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 611
    .end local v1    # "unreadCountString":Ljava/lang/String;
    :cond_2
    if-gtz p1, :cond_3

    .line 612
    const-string v1, ""

    .restart local v1    # "unreadCountString":Ljava/lang/String;
    goto :goto_0

    .line 614
    .end local v1    # "unreadCountString":Ljava/lang/String;
    :cond_3
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "unreadCountString":Ljava/lang/String;
    goto :goto_0
.end method

.method public static getValidUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "uri"    # Ljava/lang/String;

    .prologue
    .line 964
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    if-ne p0, v0, :cond_1

    .line 965
    :cond_0
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    .line 966
    :goto_0
    return-object v0

    :cond_1
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0
.end method

.method public static getVersionCode(Landroid/content/Context;)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v5, 0x0

    .line 771
    sget-object v1, Lcom/android/mail/utils/Utils;->sVersionCode:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 773
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget v1, v1, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/android/mail/utils/Utils;->sVersionCode:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 781
    :cond_0
    :goto_0
    sget-object v1, Lcom/android/mail/utils/Utils;->sVersionCode:Ljava/lang/String;

    return-object v1

    .line 776
    :catch_0
    move-exception v0

    .line 777
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-object v1, Lcom/android/mail/utils/Utils;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Error finding package %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v4

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public static isEmpty(Landroid/net/Uri;)Z
    .locals 1
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 970
    if-eqz p0, :cond_0

    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-virtual {p0, v0}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

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

.method public static isLayoutSubTreeOrphaned(Landroid/view/View;)Z
    .locals 4
    .param p0, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 1156
    if-nez p0, :cond_1

    .line 1168
    :cond_0
    :goto_0
    return v2

    .line 1160
    :cond_1
    invoke-virtual {p0}, Landroid/view/View;->isLayoutRequested()Z

    move-result v0

    .line 1161
    .local v0, "isLayoutRequested":Z
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    .line 1162
    .local v1, "parent":Landroid/view/ViewParent;
    :goto_1
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    .line 1163
    invoke-interface {v1}, Landroid/view/ViewParent;->isLayoutRequested()Z

    move-result v3

    if-nez v3, :cond_2

    .line 1164
    const/4 v2, 0x1

    goto :goto_0

    .line 1166
    :cond_2
    invoke-interface {v1}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    goto :goto_1
.end method

.method public static isRunningJellybeanOrLater()Z
    .locals 2

    .prologue
    .line 113
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static markDirtyTillRoot(Ljava/lang/String;Landroid/view/View;)V
    .locals 0
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1182
    return-void
.end method

.method public static measureViewHeight(Landroid/view/View;Landroid/view/ViewGroup;)I
    .locals 6
    .param p0, "child"    # Landroid/view/View;
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x0

    .line 577
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getWidth()I

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .line 578
    .local v1, "parentWSpec":I
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getPaddingLeft()I

    move-result v3

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getPaddingRight()I

    move-result v4

    add-int/2addr v3, v4

    const/4 v4, -0x1

    invoke-static {v1, v3, v4}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v2

    .line 581
    .local v2, "wSpec":I
    invoke-static {v5, v5}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 582
    .local v0, "hSpec":I
    invoke-virtual {p0, v2, v0}, Landroid/view/View;->measure(II)V

    .line 583
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v3

    return v3
.end method

.method public static normalizeMimeType(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "type"    # Ljava/lang/String;

    .prologue
    .line 889
    if-nez p0, :cond_1

    .line 890
    const/4 p0, 0x0

    .line 899
    .local v0, "semicolonIndex":I
    :cond_0
    :goto_0
    return-object p0

    .line 893
    .end local v0    # "semicolonIndex":I
    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    .line 895
    const/16 v1, 0x3b

    invoke-virtual {p0, v1}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 896
    .restart local v0    # "semicolonIndex":I
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 897
    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method public static normalizeUri(Landroid/net/Uri;)Landroid/net/Uri;
    .locals 3
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 928
    invoke-virtual {p0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 929
    .local v1, "scheme":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 933
    .end local p0    # "uri":Landroid/net/Uri;
    :cond_0
    :goto_0
    return-object p0

    .line 930
    .restart local p0    # "uri":Landroid/net/Uri;
    :cond_1
    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    .line 931
    .local v0, "lowerScheme":Ljava/lang/String;
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 933
    invoke-virtual {p0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object p0

    goto :goto_0
.end method

.method private static openUrl(Landroid/content/Context;Landroid/net/Uri;Landroid/os/Bundle;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "optionalExtras"    # Landroid/os/Bundle;

    .prologue
    .line 722
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 723
    :cond_0
    sget-object v1, Lcom/android/mail/utils/Utils;->LOG_TAG:Ljava/lang/String;

    const-string v2, "invalid url in Utils.openUrl(): %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 735
    :goto_0
    return-void

    .line 726
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 728
    .local v0, "intent":Landroid/content/Intent;
    if-eqz p2, :cond_2

    .line 729
    invoke-virtual {v0, p2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 731
    :cond_2
    const-string v1, "com.android.browser.application_id"

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 732
    const/high16 v1, 0x80000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 734
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method private static replaceLocale(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 759
    const-string v2, "%locale%"

    invoke-virtual {p0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 760
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 761
    .local v0, "locale":Ljava/util/Locale;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 762
    .local v1, "tmp":Ljava/lang/String;
    const-string v2, "%locale%"

    invoke-virtual {p0, v2, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 764
    .end local v0    # "locale":Ljava/util/Locale;
    .end local v1    # "tmp":Ljava/lang/String;
    :cond_0
    return-object p0
.end method

.method public static restrictWebView(Landroid/webkit/WebView;)V
    .locals 3
    .param p0, "webView"    # Landroid/webkit/WebView;

    .prologue
    const/4 v2, 0x0

    .line 122
    invoke-virtual {p0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 123
    .local v0, "webSettings":Landroid/webkit/WebSettings;
    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setSavePassword(Z)V

    .line 124
    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setSaveFormData(Z)V

    .line 125
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 126
    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 127
    return-void
.end method

.method public static sendFeedback(Landroid/content/Context;Lcom/android/mail/providers/Account;Z)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "reportingProblem"    # Z

    .prologue
    .line 834
    if-eqz p1, :cond_0

    iget-object v1, p1, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    if-eqz v1, :cond_0

    .line 835
    new-instance v0, Landroid/os/Bundle;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(I)V

    .line 836
    .local v0, "optionalExtras":Landroid/os/Bundle;
    const-string v1, "reporting_problem"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 838
    iget-object v1, p1, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    invoke-static {p0, v1, v0}, Lcom/android/mail/utils/Utils;->openUrl(Landroid/content/Context;Landroid/net/Uri;Landroid/os/Bundle;)V

    .line 840
    .end local v0    # "optionalExtras":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method public static setConversationCursorVisibility(Landroid/database/Cursor;ZZ)V
    .locals 2
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "visible"    # Z
    .param p2, "isFirstSeen"    # Z

    .prologue
    .line 1028
    new-instance v0, Lcom/android/mail/utils/Utils$MarkConversationCursorVisibleTask;

    invoke-direct {v0, p0, p1, p2}, Lcom/android/mail/utils/Utils$MarkConversationCursorVisibleTask;-><init>(Landroid/database/Cursor;ZZ)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/android/mail/utils/Utils$MarkConversationCursorVisibleTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1029
    return-void
.end method

.method public static setIntentDataAndTypeAndNormalize(Landroid/content/Intent;Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p0, "intent"    # Landroid/content/Intent;
    .param p1, "data"    # Landroid/net/Uri;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    .line 941
    invoke-static {p1}, Lcom/android/mail/utils/Utils;->normalizeUri(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v0

    invoke-static {p2}, Lcom/android/mail/utils/Utils;->normalizeMimeType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static setIntentTypeAndNormalize(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p0, "intent"    # Landroid/content/Intent;
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 937
    invoke-static {p1}, Lcom/android/mail/utils/Utils;->normalizeMimeType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static setMenuItemVisibility(Landroid/view/Menu;IZ)V
    .locals 1
    .param p0, "menu"    # Landroid/view/Menu;
    .param p1, "itemId"    # I
    .param p2, "shouldShow"    # Z

    .prologue
    .line 949
    invoke-interface {p0, p1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 950
    .local v0, "item":Landroid/view/MenuItem;
    if-nez v0, :cond_0

    .line 954
    :goto_0
    return-void

    .line 953
    :cond_0
    invoke-interface {v0, p2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public static shouldShowDisabledArchiveIcon(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1104
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0f0002

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    return v0
.end method

.method public static showFolderSettings(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 801
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 802
    :cond_0
    sget-object v1, Lcom/android/mail/utils/Utils;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Invalid attempt to show folder settings. account: %s folder: %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 812
    :goto_0
    return-void

    .line 806
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.EDIT"

    iget-object v2, p1, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 808
    .local v0, "settingsIntent":Landroid/content/Intent;
    const-string v1, "extra_account"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 809
    const-string v1, "extra_folder"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 810
    const/high16 v1, 0x80000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 811
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static showHelp(Landroid/content/Context;Lcom/android/mail/providers/Account;Ljava/lang/String;)V
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "fromWhere"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 699
    if-eqz p1, :cond_0

    iget-object v4, p1, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    if-eqz v4, :cond_0

    iget-object v4, p1, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    invoke-virtual {v4}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    .line 701
    .local v2, "urlString":Ljava/lang/String;
    :goto_0
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 702
    sget-object v3, Lcom/android/mail/utils/Utils;->LOG_TAG:Ljava/lang/String;

    const-string v4, "unable to show help for account: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 713
    :goto_1
    return-void

    .end local v2    # "urlString":Ljava/lang/String;
    :cond_0
    move-object v2, v3

    .line 699
    goto :goto_0

    .line 705
    .restart local v2    # "urlString":Ljava/lang/String;
    :cond_1
    invoke-static {p0, v2}, Lcom/android/mail/utils/Utils;->addParamsToUrl(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 706
    .local v1, "uri":Landroid/net/Uri;
    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 708
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 709
    const-string v4, "p"

    invoke-virtual {v0, v4, p2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 712
    :cond_2
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v4

    invoke-static {p0, v4, v3}, Lcom/android/mail/utils/Utils;->openUrl(Landroid/content/Context;Landroid/net/Uri;Landroid/os/Bundle;)V

    goto :goto_1
.end method

.method public static showManageFolder(Landroid/content/Context;Lcom/android/mail/providers/Account;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 818
    if-nez p1, :cond_0

    .line 819
    sget-object v1, Lcom/android/mail/utils/Utils;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Invalid attempt to the manage folders screen with null account"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 828
    :goto_0
    return-void

    .line 822
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.EDIT"

    iget-object v2, p1, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 824
    .local v0, "settingsIntent":Landroid/content/Intent;
    const-string v1, "extra_account"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 825
    const-string v1, "extra_manage_folders"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 826
    const/high16 v1, 0x80000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 827
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static showSettings(Landroid/content/Context;Lcom/android/mail/providers/Account;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 788
    if-nez p1, :cond_0

    .line 789
    sget-object v1, Lcom/android/mail/utils/Utils;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Invalid attempt to show setting screen with null account"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 795
    :goto_0
    return-void

    .line 792
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.EDIT"

    iget-object v2, p1, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 793
    .local v0, "settingsIntent":Landroid/content/Intent;
    const/high16 v1, 0x80000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 794
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static showTwoPaneSearchResults(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1085
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0f0001

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    return v0
.end method

.method public static useFolderListFragmentTransition(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 526
    sget v0, Lcom/android/mail/utils/Utils;->sUseFolderListFragmentTransition:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 527
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0a002e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    sput v0, Lcom/android/mail/utils/Utils;->sUseFolderListFragmentTransition:I

    .line 530
    :cond_0
    sget v0, Lcom/android/mail/utils/Utils;->sUseFolderListFragmentTransition:I

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static useTabletUI(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 517
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0a0012

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
